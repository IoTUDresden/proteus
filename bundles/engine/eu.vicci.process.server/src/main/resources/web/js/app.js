var processTable;
var instanceTable;
var wasDisconnected = false;


// Entry point of the main app
function loadContents(){
	initDataTables();

	var engineEvents = new EventSource("/events/engineupdates");
	var stateChangeEvents = new EventSource("/events/statechanges");
	stateChangeEvents.onmessage = onStateChange;
	engineEvents.onmessage = onEngineUpdate;
	engineEvents.onerror = onDisconnected;
	engineEvents.onopen = onConnected;
}

function initDataTables(){
	instanceTable = $('#instance_table').DataTable( {
		'paging':   false,
        'ordering': true,
        'info':     false,
		'processing': true,
        'serverSide': false,
		rowId: 'processInstanceId',
        ajax: {"url": "/rest/processinstances", "dataSrc":""},
        columns: [
            { title: "Name", data: "processName" },
            { title: "Instance ID",  data: "processInstanceId" },
            { title: "State",  data: "state" }
        ]
    } );
	
	processTable = $('#process_table').DataTable( {
		'paging':   false,
        'ordering': true,
        'info':     false,
		'processing': true,
        'serverSide': false,
		rowId: 'processId',
        ajax: {"url": "/rest/processes", "dataSrc":""},
        columns: [
            { title: "Name", data: "processName" },
            { title: "ID",  data: "processId" }
        ]
    } );	
}

// Handles all engine updates (process or instance deployed)
function onEngineUpdate(event){
	// console.log("EngineUpdate");	
	// console.log(event.data);
	var parsedData = JSON.parse(event.data);
	
	if("processInstanceId" in parsedData){
		if(!instanceTable.rows('#' + parsedData.processInstanceId).any()){
			instanceTable.row.add(parsedData).invalidate().draw();
		}			
	}
	if(!("processInstanceId" in parsedData)){
		if(!processTable.rows('#' + parsedData.processId).any()){
			processTable.row.add(parsedData).invalidate().draw();	
		}
	}
}

// Handles all state changes
function onStateChange(event){
	// console.log("StateChange");	
	// console.log(event.data);
	var data = JSON.parse(event.data);
	
	//only root process is interesting
	if(data.processInstanceId === data.instanceId){
		var rowIdSelector = "#" + data.processInstanceId;
		instanceTable.cell(rowIdSelector, 2).data(data.state).invalidate().draw();
	}
}

function onConnected(){
	console.log("connected");	
	var box = document.getElementById("connection_state_box");
	box.innerHTML = 'connected';
	box.style.backgroundColor = 'green';
	
	//not load twice on startup
	if(wasDisconnected){
		processTable.ajax.reload();
		instanceTable.ajax.reload();
	}	
}

function onDisconnected(){
	console.log("disconnected");
	wasDisconnected = true;	
	var box = document.getElementById("connection_state_box");
	box.innerHTML = 'disconnected';
	box.style.backgroundColor = 'red';
}