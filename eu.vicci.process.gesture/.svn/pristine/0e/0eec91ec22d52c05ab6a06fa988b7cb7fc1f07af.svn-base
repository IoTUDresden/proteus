package eu.vicci.process.gesture;


public class Interval {

    private double min;
    private double max;

    public Interval(double min, double max) {
        assert (min <= max);
        this.min  = min;
        this.max = max;
    }

    public void setMin(int le) {
        this.min = le;
    }

    public void setMax(int re) {
        this.min = re;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    // Gibt es eine Schnittmenge von Interval a und b?
    public boolean intersects(Interval b) {
        Interval a = this;
        if (b.min <= a.max && b.min >= a.min) { return true; }
        if (a.min <= b.max && a.min >= b.min) { return true; }
        return false;
    }

    public String toString() {
        return "[" + min + ", " + max + "]";
    }

    // Groesse der Schnittmenge
    public double amount(Interval b) {

    	double amount = this.max - b.min;
    	return amount;
    }

    // Prozentuale Groesse der Schnittmenge zu den Intervallen
    public double percent(Interval b)
    {
    	Interval a = this;
    	double percent = (100/(b.max - a.min) )* a.amount(b);
    	return percent;
    }

    // Ueberpruefen ob Max des Intervalls b groesser Max des Intervalls a ist
    public boolean more(Interval b)
    {
    	Interval a = this;
    	if (a.max < b.max) {return true;}
    	return false;

    }

    // Ueberpruefen ob Min des Intervalls b kleiner Min des Intervalls a ist
    public boolean less(Interval b)
    {
    	Interval a = this;
    	if (a.min > b.min) {return true;}
    	return false;

    }

    // Ueberprueft ob Interval b Teilmenge von Interval a ist
    public boolean subset(Interval b)
    {
    	Interval a = this;
    	if (a.min >= b.min && a.max <= b.max)
    	{
    		//System.out.println("subset true " +a.min +">="+ b.min +" && "+ a.max +"<="+ b.max);
    		return true;
    		}
    	else
    	{
//    		System.out.println("subset false "+a.min +">="+ b.min +" && "+ a.max +"<="+ b.max);

    	return false;
    	}
    }

    /*
     * -------------------------------------------
     * Test
     * -------------------------------------------
     */

//    public static void main(String[] args) {
//        Interval a = new Interval(15, 20);
//        Interval b = new Interval(25, 30);
//        Interval c = new Interval(10, 40);
//        Interval d = new Interval(10, 50);
//
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//        System.out.println("c = " + c);
//        System.out.println("d = " + d);
//
//        System.out.println("b intersects a = " + b.intersects(a));
//        System.out.println("b subset d = " + b.subset(d));
//        System.out.println("d les b = " + b.less(d));
//    }
}