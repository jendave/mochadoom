package net.sourceforge.mochadoom.automap;

/**
 * used only in automap
 */
public class MLine {
    public MLine() {
        this(0, 0, 0, 0);
    }

    public int ax, ay, bx, by;

    public MLine(int ax, int ay, int bx, int by) {
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
    }

    public MLine(double ax, double ay, double bx, double by) {
        this.ax = (int) ax;
        this.ay = (int) ay;
        this.bx = (int) bx;
        this.by = (int) by;
    }

    /*
    public MLine(MPoint a, MPoint b) {
        this.a = a;
        this.b = b;
    }

    public MLine(int ax,int ay,int bx,int by) {
        this.a = new MPoint(ax,ay);
        this.b = new MPoint(bx,by);
    }
        
    public MLine(double ax,double ay,double bx,double by) {
        this.a = new MPoint(ax,ay);
        this.b = new MPoint(bx,by);
    }
    
    public MPoint a, b;
    public int ax;
    
    public String toString(){
        return a.toString()+" - "+ b.toString();
    }
    */
}
