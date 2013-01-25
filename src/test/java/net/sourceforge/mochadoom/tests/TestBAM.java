package net.sourceforge.mochadoom.tests;

import static net.sourceforge.mochadoom.data.SineCosine.*;
import net.sourceforge.mochadoom.menu.FixedFloat;

/** This is a class that tests what happens with BAM angles used in Doom
 *  Normally, they were supposed to be unsigned 32-bit types, mapping
 *  the [0...360) range to a continuum of 32-bit integer values.
 *  
 *  However, in Java we have no unsigned integer type. 
 *  A workaround is to declare angles as ints, and be careful about what operations we perform.
 *  The general rules are:
 *  
 *  a) Angles below ANG180 (1st and 2nd qdt) will compare just fine.
 *  b) Angles in the 3rd and 4th quadrant will compare OK too.
 *  c) However angles from different semiplanes won't compare correctly: they need to be extended to longs.
 *  d) Alternatively, comparisons can be done with a specialized function -> need to benchmark that.
 *  e) Sums and subtractions of angles will work ok with ints, as far as the bit content is concerned. 
 *     When they need to be compared however, the above limitations apply.
 *  f) Multiplications with work OK with either type.
 *  g) Divisions for cumulative angles between 180 and -0.0 degrees will fail due to signs.
 *  g) So, the best thing would be to expand angles to longs and use the extra value range.
 *  
 *  Some benchmark facts:
 *  1) Addition/subtraction between 32-bit and 64-bit operands are, on average, the same speed.
 *  2) Multiplication is twice as fast with 32-bit operands.
 *  2) Casting to int is usually slightly faster than ANDing with a 32-bit mask and storing as long.
 *  3) Using a special method for division between ints can be almost as 1.5x as fast 
 *     than performing long divisions on 32-bit limited numbers.
 *  4) The only thing that's undeliably faster in 64-bit mode are comparisons between "32 bit unsigned"
 *     numbers (5x as fast), and the overall.
 *     
 *     Using 32-bit ints clearly improves memory bandwidth and storage, but makes comparisons problematic.
 *     If most of the angle code consists of additions and comparisons, I'd say keep BAM angles 64-bit.
 *     Using code that's multiplication or division intensive may benefit from 32-bit BAM angles...
 *     eventally code can be locally optimized depending on what's being done.
 *     
 */

public class TestBAM {
    
    
    public final static int PASSES=2;
    public final static int TESTS=5000000;
    public final static int ANG90=0x40000000;
    public final static int ANG180=0x80000000;
    public final static int ANG270=0xC0000000;
    public final static int ANG45=ANG90/2;
    public final static int ANG135=ANG270/2;
    public final static long LANG90=0x40000000;
    public final static long LANG180=0x80000000;
    public final static long LANG270=0xC0000000L;
    public final static long LANG45=LANG90/2;
    public final static long LANG135=LANG270/2;
    public final static long ANGLETOFINESHIFT=19;
    public final static int BITS31=0x7FFFFFFF;
    
    public static void main(String argv[]){
    System.out.println("ANG90>ANG45: "+(ANG90>ANG45));
    System.out.println("LANG180> ANG90 "+ (toLong(ANG180)>ANG90));
    System.out.println("ANG180>ANG90 "+ (ANG180>ANG90)); // this resolves wrong, because ANG180 is "negative" in signed int notation.
    System.out.println("ANG180>ANG90 with GT"+ GT(ANG180,ANG90)); // this resolves wrong, because ANG180 is "negative" in signed int notation.
    System.out.println("ANG270>ANG180 " + (ANG270>ANG180)); // but this resolves correctly, because ANG270 is negative but "larger".
    System.out.println("ANG270>ANG180 " + GT(ANG270,ANG180)); // but this resolves correctly, because ANG270 is negative but "larger".
    System.out.println(ANG45>ANG270); // this resolves wrong, too. It should be false.
    System.out.println((ANG45>toLong(ANG270))); // this resolves wrong, too. It should be false.
    System.out.println((ANG270-ANG45)>ANG180); // this resolves correctly.
    System.out.println("ZILCH "+((ANG270-ANG45)>ANG90)); // this, however, won't.
    System.out.println((0-ANG45)>ANG180); // this resolves correctly too.
    System.out.println((ANG270-ANG180)>ANG45); // correct.
    System.out.println((ANG270-ANG180)==ANG90); // This is true, and correct. 
    System.out.println((ANG270/2)>ANG90); // This won't work, because it will resolve to a negative.
    System.out.println((ANG270/2)>ANG180); // This won't work either.
    System.out.println((toLong(ANG270)/2)>toLong(ANG180)); // Only this will work.
    
    
    System.out.println(ANG45>>ANGLETOFINESHIFT);
    System.out.println(ANG90>>ANGLETOFINESHIFT);
    
    System.out.println("ANG90 mult 3 == ANG270" +GE(ANG90*5,ANG90));
    System.out.println(ANG180*2);
    System.out.println((long)ANG180/2);
    System.out.println(ANG270*2 == ANG180);
    
    
    System.out.println(FixedFloat.toFloat((int) (ANG45>>>ANGLETOFINESHIFT))+" "+finesine[(int) (ANG45>>>ANGLETOFINESHIFT)]);
    System.out.println(FixedFloat.toFloat((int) (ANG270>>>ANGLETOFINESHIFT))+" "+finesine[(int) (ANG270>>>ANGLETOFINESHIFT)]);
    System.out.println(FixedFloat.toFloat((int) ((ANG45*6)>>>ANGLETOFINESHIFT))+" "+finesine[(int) (ANG45*6)>>>ANGLETOFINESHIFT]);
    System.out.println(FixedFloat.toFloat((int) (ANG45>>>ANGLETOFINESHIFT))+" "+finesine[(int) (ANG45>>>ANGLETOFINESHIFT)]);
    System.out.println(FixedFloat.toFloat((int) (ANG270>>>ANGLETOFINESHIFT))+" "+finesine[(int) (ANG270>>>ANGLETOFINESHIFT)]);
    System.out.println(FixedFloat.toFloat((int) ((ANG45*6)>>>ANGLETOFINESHIFT))+" "+finesine[(int) (ANG45*6)>>>ANGLETOFINESHIFT]);
    
    int[] BAM32=new int[TESTS];
    long[] BAM64=new long[TESTS];
    
    for (int i=0;i<TESTS;i++){
        // Keep only 32 bits.
        BAM64[i]=(Double.doubleToLongBits(Math.random())&0xFFFFFFFFL);
        BAM32[i]=(int) (BAM64[i]);
    }

    int errors=0;
    for (int i=0;i<TESTS-1;i++){
        // Keep only 32 bits.
        if ((BAM64[i]<BAM64[i+1])!=(!GE(BAM32[i],BAM32[i+1]))) errors++;
    }

    System.out.println("Comparison Errors "+ errors);
    
    errors=0;
    for (int i=0;i<TESTS-1;i++){
        // Keep only 32 bits.
        if ((int)(BAM64[i]*BAM64[i+1])!=(BAM32[i]*BAM32[i+1])) errors++;
    }

    System.out.println("Multiplication Errors "+ errors);
    
    errors=0;
    
    // Preventing overflow errors is easy.
    for (int i=0;i<TESTS-1;i++){
        // Keep only 32 bits.
        if ((toLong(BAM32[i])/2)!=((BAM64[i]/2)&0x0FFFFFFFFL)) errors++;
    }
    
    System.out.println("Overflow Errors "+ errors);
    
    errors=0;
    for (int i=0;i<TESTS-1;i++){
        // Keep only 32 bits.
        if ((int)(BAM64[i]/BAM64[i+1])!=(BAM32[i]/BAM32[i+1])) errors++;
    }
    
    System.out.println("Division Errors "+ errors);
    
    errors=0;
    for (int i=1;i<TESTS-1;i++){
        // Keep only 32 bits.
        if ((int)(BAM64[i]/i)!=BAMDiv(BAM32[i],i)) errors++;
        //System.out.println(BAMDiv(BAM32[i],i));
    }
    
    System.out.println("Division with BAMDiv Errors "+ errors);
    
    /*for (int i=0;i<tantoangle.length;i++){
        System.out.println(FixedFloat.toFloat(tantoangle[i]));
    }*/
    for (int p=0;p<PASSES;p++){
    timingTests(BAM32,BAM64);
    }
    }

    private static void timingTests(int[] bAM32, long[] bAM64) {
        
        long a,b;
        int errors;
        int results1[]=new int[TESTS];
        int results2[]=new int[TESTS];
        long results3[]=new long[TESTS];
        a=System.nanoTime();
        for (int i=0;i<TESTS-1;i++){
            // Keep only 32 bits.
            results1[i]=bAM32[i]+bAM32[i+1];
            //System.out.println(BAMDiv(BAM32[i],i));
        }
         b=System.nanoTime();
        
        System.out.println("Time for "+TESTS+" 32-bit additions: "+ (b-a));
        
        a=System.nanoTime();
        for (int i=0;i<TESTS-1;i++){
            // Keep only 32 bits.
            results2[i]=(int) (bAM64[i]+bAM64[i+1]);
            //System.out.println(BAMDiv(BAM32[i],i));
        }
        b=System.nanoTime();
        
        System.out.println("Time for "+TESTS+" 64-bit additions (int storage with cast to 32-bit): "+ (b-a));
        
        a=System.nanoTime();
        for (int i=0;i<TESTS-1;i++){
            // Keep only 32 bits.
            results3[i]=(bAM64[i]+bAM64[i+1])&0xFFFFFFFFL;
            //System.out.println(BAMDiv(BAM32[i],i));
        }
        b=System.nanoTime();
        
        System.out.println("Time for "+TESTS+" 64-bit additions (long storage with 32-bit cutoff): "+ (b-a));
        
        errors=0;
        for (int i=1;i<TESTS-1;i++){
            // Keep only 32 bits.
            if (results1[i]!=results2[i]) errors++;
            //System.out.println(BAMDiv(BAM32[i],i));
        }
        
        System.out.println("Errors "+ errors);
        
        a=System.nanoTime();
        for (int i=0;i<TESTS-1;i++){
            // Keep only 32 bits.
            results1[i]=bAM32[i]*bAM32[i+1];
            //System.out.println(BAMDiv(BAM32[i],i));
        }
         b=System.nanoTime();
         
         System.out.println("Time for "+TESTS+" 32-bit multiplications : "+ (b-a));
         
         a=System.nanoTime();
         for (int i=0;i<TESTS-1;i++){
             // Keep only 32 bits.
             results2[i]=(int)(bAM64[i]*bAM64[i+1]);
             //System.out.println(BAMDiv(BAM32[i],i));
         }
          b=System.nanoTime();
          System.out.println("Time for "+TESTS+" 64-bit multiplications (with result cast to int): "+ (b-a));
          
          errors=0;
          for (int i=1;i<TESTS-1;i++){
              // Keep only 32 bits.
              if (results1[i]!=results2[i]) errors++;
              //System.out.println(BAMDiv(BAM32[i],i));
          }
          
          System.out.println("Errors "+ errors);
          
          a=System.nanoTime();
          for (int i=1;i<TESTS-1;i++){
              // Keep only 32 bits.
              results1[i]=BAMDiv(bAM32[i],50);
              //System.out.println(BAMDiv(BAM32[i],i));
          }
           b=System.nanoTime();
           
           System.out.println("Time for "+TESTS+" 32-bit divisions with BAMDiv: "+ (b-a));
           
           a=System.nanoTime();
           for (int i=1;i<TESTS-1;i++){
               // Keep only 32 bits.
               results2[i]=(int)(bAM64[i]/50);
               //System.out.println(BAMDiv(BAM32[i],i));
           }
            b=System.nanoTime();
            System.out.println("Time for "+TESTS+" 64-bit divisions (with result cast to int): "+ (b-a));
            
            errors=0;
            for (int i=1;i<TESTS-1;i++){
                // Keep only 32 bits.
                results1[i]=(GE(bAM32[i],bAM32[i+1])?1:0);
                //System.out.println(BAMDiv(BAM32[i],i));
            }
            
            System.out.println("Time for "+TESTS+" 32-bit comparisons): "+ (b-a));
            
            a=System.nanoTime();
            for (int i=1;i<TESTS-1;i++){
                // Keep only 32 bits.
                results2[i]=(bAM64[i]>=bAM64[i+1]?1:0);
                //System.out.println(BAMDiv(BAM32[i],i));
            }
             b=System.nanoTime();
             System.out.println("Time for "+TESTS+" 64-bit comparisons (with result cast to int): "+ (b-a));
             
             errors=0;
             for (int i=1;i<TESTS-1;i++){
                 // Keep only 32 bits.
                 if (results1[i]!=results2[i]) errors++;
                 //System.out.println(BAMDiv(BAM32[i],i));
             }
             
             System.out.println("Errors "+ errors);
          
          
    }

    public static final long toLong(int a){
        return(0xFFFFFFFFL&a);
    }
 
    /** Compare BAM angles in 32-bit format 
     *  "Greater or Equal" bam0>bam1
     * */
    
    public static final boolean GE(int bam0, int bam1){
        // Handle easy case.
        if (bam0==bam1) return true;
        
        // bam0 is greater than 180 degrees.
        if (bam0<0 && bam1>=0) return true;
        // bam1 is greater than 180 degrees.
        if (bam0>=0 && bam1<0) return false;
        
        // Both "greater than 180", No other way to compare.
        bam0&=BITS31;
        bam1&=BITS31;        
        return bam0>bam1;
    }
    
    public static final boolean GT(int bam0, int bam1){       
        // bam0 is greater than 180 degrees.
        if (bam0<0 && bam1>=0) return true;
        // bam1 is greater than 180 degrees.
        if (bam0>=0 && bam1<0) return false;
        
        // Both "greater than 180", No other way to compare.
        bam0&=BITS31;
        bam1&=BITS31;        
        return bam0>bam1;
    }
    
    public static final int BAMDiv(int bam0, int bam1){       
        // bam0 is greater than 180 degrees.
        if (bam0>=0) return bam0/bam1;
        // bam0 is greater than 180 degrees.
        // We have to make is so that ANG270 0xC0000000 becomes ANG135, aka 60000000
        if (bam1>=0)
        return (int) ((long)(0x0FFFFFFFFL&bam0)/bam1);
        
        return (int) ((long)(0x0FFFFFFFFL&bam0)/(0x0FFFFFFFFL&bam1));
    }
    
}
