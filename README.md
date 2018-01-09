[![Build Status](https://travis-ci.org/IoTUDresden/proteus.svg?branch=master)](https://travis-ci.org/IoTUDresden/proteus)

# PROtEUS: A Process Execution System for Cyber-physical Systems

See the following publications for more detail:

Seiger, R., Huber, S., Schlegel, T., (2015), Proteus: An integrated system for process execution in cyber-physical systems. In
Khaled Gaaloul, Rainer Schmidt, Selmin Nurcan, Sergio Guerreiro, and Qin Ma, editors, Enterprise, Business-Process and Information Systems Modeling, volume 214 of Lecture Notes in Business Information Processing, pages 265–280.

Seiger, R., Keller, C., Niebling, F., Schlegel, T., (2015), Modelling complex and flexible processes for smart cyber-physical en-
vironments. Journal of Computational Science, 10:137 – 148.

Seiger, R., Huber, S., Schlegel, T., (2016), Toward an execution system for self-healing workflows in cyber-physical systems. Software & Systems Modeling, pages 1–22.

# usage

See the [wiki](https://github.com/IoTUDresden/proteus/wiki) for information how to use PROtEUS.

# ide setup

- download the Eclipse Installer from <https://wiki.eclipse.org/Eclipse_Installer>
- download the PROtEUS setup file from <https://raw.githubusercontent.com/IoTUDresden/proteus/master/VicciProcess.setup>
- run the installer and go to advanced mode
- choose **Eclipse Modeling Tools – Mars** (newer Eclipse versions not tested)
- drop the PROtEUS setup file in the *Projects* dialog and select *Vicci Process*
- finish the installation and in Eclipse right click on some project -> *Maven* -> *Update* *Project...* and select all projects to update

# repo

Artifacts which are build by Travis CI are published at <https://github.com/IoTUDresden/proteus-repo>

## p2

You can add <https://IoTUDresden.github.io/proteus-repo/p2/latest/> as update site in Eclipse, to download the latest process model editor plugins.

## maven / gradle

If you want to add proteus dependencies to your project (e.g. model), add <https://IoTUDresden.github.io/proteus-repo/maven/snapshot/> as repo to your gradle/maven project.

```
repositories {
  maven { url 'https://IoTUDresden.github.io/proteus-repo/maven/snapshot' }
}

dependencies {

  compile 'eu.vicci.proteus.bundles.model:eu.vicci.process.model:1.0.0-SNAPSHOT',
	      'eu.vicci.proteus.bundles.model:eu.vicci.process.core:1.0.0-SNAPSHOT',
	      'eu.vicci.proteus.bundles.model:eu.vicci.process.model.util:1.0.0-SNAPSHOT'
}
```
