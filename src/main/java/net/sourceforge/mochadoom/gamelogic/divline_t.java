package net.sourceforge.mochadoom.gamelogic;

import net.sourceforge.mochadoom.rendering.line_t;

import static net.sourceforge.mochadoom.menu.fixed_t.FRACBITS;
import static net.sourceforge.mochadoom.menu.fixed_t.FixedMul;

//
// P_MAPUTL
//

public class divline_t {

    /**
     * fixed_t
     */
    public int x, y, dx, dy;


    /**
     * P_PointOnDivlineSide
     * Returns 0 or 1. (false or true)
     *
     * @param x         fixed
     * @param y         fixed
     */
    public boolean
    PointOnDivlineSide
    (int x,
     int y
    ) {
        int dx;
        int dy;
        int left;
        int right;

        if (this.dx == 0) {
            if (x <= this.x)
                return this.dy > 0;

            return this.dy < 0;
        }
        if (this.dy == 0) {
            if (y <= this.y)
                return this.dx < 0;

            return this.dx > 0;
        }

        dx = (x - this.x);
        dy = (y - this.y);

        // try to quickly decide by looking at sign bits
        if (((this.dy ^ this.dx ^ dx ^ dy) & 0x80000000) != 0) {
            if (((this.dy ^ dx) & 0x80000000) != 0)
                return true;       // (left is negative)
            return false;
        }

        left = FixedMul(this.dy >> 8, dx >> 8);
        right = FixedMul(dy >> 8, this.dx >> 8);

        if (right < left)
            return false;       // front side
        return true;           // back side
    }


    //
    //P_MakeDivline
    //
    public void
    MakeDivline
    (line_t li) {
        this.x = li.v1x;
        this.y = li.v1y;
        this.dx = li.dx;
        this.dy = li.dy;
    }

    public divline_t(line_t li) {
        this.x = li.v1x;
        this.y = li.v1y;
        this.dx = li.dx;
        this.dy = li.dy;
    }

    public divline_t() {
        // TODO Auto-generated constructor stub
    }


    /**
     * P_DivlineSide
     * Returns side 0 (front), 1 (back), or 2 (on).
     */
    public int
    DivlineSide
    (int x,
     int y) {
        int dx; // fixed_t
        int dy;
        int left;
        int right;

        if (this.dx == 0) {
            if (x == this.x)
                return 2;

            if (x <= this.x)
                return (this.dy > 0) ? 1 : 0;

            return (this.dy < 0) ? 1 : 0;
        }

        if (this.dy == 0) {
            if (x == this.y)
                return 2;

            if (y <= this.y)
                return (this.dx < 0) ? 1 : 0;

            return (this.dx > 0) ? 1 : 0;
        }

        dx = (x - this.x);
        dy = (y - this.y);

        left = (this.dy >> FRACBITS) * (dx >> FRACBITS);
        right = (dy >> FRACBITS) * (this.dx >> FRACBITS);

        if (right < left)
            return 0;    // front side

        if (left == right)
            return 2;
        return 1;        // back side
    }


}
