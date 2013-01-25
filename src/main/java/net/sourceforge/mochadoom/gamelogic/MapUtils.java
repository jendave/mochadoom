package net.sourceforge.mochadoom.gamelogic;

import static net.sourceforge.mochadoom.menu.fixed_t.FixedDiv;
import static net.sourceforge.mochadoom.menu.fixed_t.FixedMul;

public class MapUtils {


    /**
     * AproxDistance
     * Gives an estimation of distance (not exact)
     *
     * @param dx fixed_t
     * @param dy fixed_t
     * @return fixed_t
     */
    //
    public static int
    AproxDistance
    (int dx,
     int dy) {
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        if (dx < dy)
            return dx + dy - (dx >> 1);
        return dx + dy - (dy >> 1);
    }

    /**
     * P_InterceptVector
     * Returns the fractional intercept point
     * along the first divline.
     * This is only called by the addthings
     * and addlines traversers.
     *
     * @return int to be treated as fixed_t
     */

    public static int
    InterceptVector
    (divline_t v2,
     divline_t v1) {
        int frac, num, den; // fixed_t

        den = FixedMul(v1.dy >> 8, v2.dx) - FixedMul(v1.dx >> 8, v2.dy);

        if (den == 0)
            return 0;
        //  I_Error ("P_InterceptVector: parallel");

        num =
                FixedMul((v1.x - v2.x) >> 8, v1.dy)
                        + FixedMul((v2.y - v1.y) >> 8, v1.dx);

        frac = FixedDiv(num, den);

        return frac;
        /*
        #else   // UNUSED, float debug.
        float   frac;
        float   num;
        float   den;
        float   v1x;
        float   v1y;
        float   v1dx;
        float   v1dy;
        float   v2x;
        float   v2y;
        float   v2dx;
        float   v2dy;

        v1x = (float)v1.x/FRACUNIT;
        v1y = (float)v1.y/FRACUNIT;
        v1dx = (float)v1.dx/FRACUNIT;
        v1dy = (float)v1.dy/FRACUNIT;
        v2x = (float)v2.x/FRACUNIT;
        v2y = (float)v2.y/FRACUNIT;
        v2dx = (float)v2.dx/FRACUNIT;
        v2dy = (float)v2.dy/FRACUNIT;

        den = v1dy*v2dx - v1dx*v2dy;

        if (den == 0)
        return 0;   // parallel

        num = (v1x - v2x)*v1dy + (v2y - v1y)*v1dx;
        frac = num / den;

        return frac*FRACUNIT;
       #endif */
    }


}
