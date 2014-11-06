package net.sourceforge.mochadoom.automap;

import net.sourceforge.mochadoom.menu.fixed_t;

public class MPoint {
    public MPoint(fixed_t x, fixed_t y) {
        this.x = x.val;
        this.y = y.val;
    }

    public MPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MPoint(double x, double y) {
        this.x = (int) x;
        this.y = (int) y;
    }

    public MPoint() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * fixed_t
     */
    public int x, y;

    public String toString() {
        return (Integer.toHexString(x) + " , " + Integer.toHexString(y));
    }
};
