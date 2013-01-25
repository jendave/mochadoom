package net.sourceforge.mochadoom.tests;

import static net.sourceforge.mochadoom.data.SineCosine.finesine;
import static net.sourceforge.mochadoom.data.Tables.*;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACBITS;
import static net.sourceforge.mochadoom.menu.fixed_t.FixedDiv;
import static net.sourceforge.mochadoom.menu.fixed_t.FixedMul;

public class TestScale {

    private static int detailshift=0;
    private static long rw_normalangle;
    private static long viewangle;
    private static int projection=0xF0000000;
    private static int rw_distance=0xFF000;
    private static final int divs=10;
    private static int viewx=0, viewy=0;
    private static int dist=256*FRACUNIT;
    
    

    public static void main(String[] argv){
        
        int[][] octants={{dist,0},{dist,dist},{0,dist},{-dist,dist},{-dist,0},{-dist,-dist},{0,-dist},{dist,-dist}};
        for (int i=0;i<octants.length;i++){
            long ang = PointToAngle (octants[i][0],octants[i][1]);
            System.out.print((ang*360.0)/0xFFFFFFFFL);            
            System.out.print(" "+(ang>>FRACBITS));
            
            System.out.print(" "+(Long.toHexString(ang)));
            System.out.print(" "+(Long.toBinaryString(ang+(ANG45*9)/2)));
            int rot = (int) (((ang+(ANG45*9)/2)&BITS32)>>29);
            System.out.print(" "+rot+"\n");
            
        }
        
        /*
        long angle=0;
        projection=0;
        int divisions=(int) (0xFFFFFFFFL/divs);
        for (int i=0;i<divs;i++){
                for (int j=0;j<divs;j++){
            System.out.println(i+" "+j+" "+rw_normalangle+" "+viewangle+" "+ScaleFromGlobalAngle(viewangle));
            viewangle+=divisions;
                }
                rw_normalangle+=divisions;
            }*/
        
        }
    
    /**
     * R_ScaleFromGlobalAngle
     * Returns the texture mapping scale
     *  for the current line (horizontal span)
     *  at the given angle.
     * rw_distance must be calculated first.
     */
    
    public static int ScaleFromGlobalAngle (long visangle)
    {
        int         scale; // fixed_t
        int         anglea;
        int         angleb;
        int         sinea;
        int         sineb;
        int         num; // fixed_t
        int         den;

        // UNUSED
    /*
    {
        fixed_t     dist;
        fixed_t     z;
        fixed_t     sinv;
        fixed_t     cosv;
        
        sinv = finesine[(visangle-rw_normalangle)>>ANGLETOFINESHIFT];   
        dist = FixedDiv (rw_distance, sinv);
        cosv = finecosine[(viewangle-visangle)>>ANGLETOFINESHIFT];
        z = abs(FixedMul (dist, cosv));
        scale = FixedDiv(projection, z);
        return scale;
    }
    */

        anglea = (int) (ANG90 +visangle-viewangle);
        angleb = (int) (ANG90 +visangle-rw_normalangle);

        // both sines are allways positive
        sinea = finesine[anglea>>>ANGLETOFINESHIFT]; 
        sineb = finesine[angleb>>>ANGLETOFINESHIFT];
        num = FixedMul(projection,sineb)<<detailshift;
        den = FixedMul(rw_distance,sinea);

        if (den > num>>16)
        {
        scale = FixedDiv (num, den);

        
        if (scale > 64*FRACUNIT)
            scale = 64*FRACUNIT;
        // Minimum scale.
        else if (scale < 256)
            scale = 256;
        }
        else
        // Top saturation scale
        scale = 64*FRACUNIT;
        
        return scale;
    }
    
    /**
     * R_PointToAngle
     *  To get a global angle from cartesian coordinates,
     *  the coordinates are flipped until they are in
     *  the first octant of the coordinate system, then
     *  the y (<=x) is scaled and divided by x to get a
     *  tangent (slope) value which is looked up in the
     *   tantoangle[] table.
     *   
     *   @param xx (fixed_t)
     *   @param yy (fixed_t)
     */

    public static long
    PointToAngle
    ( int   x,
      int   y )
    {   
        // MAES: note how we don't use &BITS32 here. That is because we know that the maximum possible
        // value of tantoangle is angle
        // This way, we are actually working with vectors emanating from our current position.
        x-= viewx;
        y-= viewy;
        
        if ( (x==0) && (y==0) )
        return 0;

        if (x>= 0)
        {
        // x >=0
        if (y>= 0)
        {
            // y>= 0

            if (x>y)
            {
            // octant 0
            return tantoangle[ SlopeDiv(y,x)];
            }
            else
            {
            // octant 1
            return (ANG90-1-tantoangle[ SlopeDiv(x,y)]);
            }
        }
        else
        {
            // y<0
            y = -y;

            if (x>y)
            {
            // octant 8
            return -tantoangle[SlopeDiv(y,x)];
            }
            else
            {
            // octant 7
            return ANG270+tantoangle[ SlopeDiv(x,y)];
            }
        }
        }
        else
        {
        // x<0
        x = -x;

        if (y>= 0)
        {
            // y>= 0
            if (x>y)
            {
            // octant 3
            return (ANG180-1-tantoangle[ SlopeDiv(y,x)]);
            }
            else
            {
            // octant 2
            return (ANG90+ tantoangle[ SlopeDiv(x,y)]);
            }
        }
        else
        {
            // y<0
            y = -y;

            if (x>y)
            {
            // octant 4
            return (ANG180+tantoangle[ SlopeDiv(y,x)]);
            }
            else
            {
             // octant 5
            return (ANG270-1-tantoangle[ SlopeDiv(x,y)]);
            }
        }
        }
        // This is actually unreachable.
       // return 0;
    }
    

    /** R_PointToDist
     * 
     * @param x fixed_t
     * @param y fixed_t
     * @return
     */
    
    public static int
    PointToDist
    ( int   x,
      int   y )
    {
        int     angle=0;
        int dx;
        int dy;
        int temp;
        int dist;
        
        dx = Math.abs(x - viewx);
        dy = Math.abs(y - viewy);
        
        // Sanity check, else it's going to bomb.
        /* if (dx==0){
            //
            if (dy>0) angle= Tables.toBAMIndex(ANG90);
            else           
            if (dy<0) angle= Tables.toBAMIndex(ANG270);
            else
                      angle= 0;     
        }
        
        else { */
        
        if (dy>dx)
        {
        temp = dx;
        dx = dy;
        dy = temp;
        }
        
        
        /* If both dx and dy are zero, this is going to bomb.
           Fixeddiv will return MAXINT aka 7FFFFFFF, >> DBITS will make it 3FFFFFF,
           addding ANG90 will make if 43FFFFFF and angletofineshi
        */
            
        angle = (int) (((tantoangle[ FixedDiv(dy,dx)>>DBITS ]+ANG90)&BITS32) >> ANGLETOFINESHIFT);
        
        // use as cosine
        dist = FixedDiv (dx, finesine[angle] ); 
        
        return dist;
    }
    
    
}
