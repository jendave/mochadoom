package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.menu.FixedFloat;
import net.sourceforge.mochadoom.menu.fixed_t;
import static net.sourceforge.mochadoom.menu.fixed_t.*;

class FPTest{         
public static final int PRECISION=16;

    public static void main(String argv[])
{
        
    byte aa=(byte) 129;
        
    fixed_t a=new fixed_t(0x8FFF0000);
    fixed_t b=new fixed_t(0xFFFFFFFF);
    
   // a=F2F(32393.244141f);
   // b=F2F(2.5f);
    
    /*System.out.println(Integer.toHexString(a.val));
    System.out.println(Integer.toHexString(b.val));
    System.out.println(FixedFloat.toFloat(a.val));
    System.out.println(FixedFloat.toFloat(b.val));

    System.out.println(FixedFloat.toDouble(a.val));
    System.out.println(FixedFloat.toDouble(b.val));*/

    int c=FixedFloat.toFixed(2.512344f);
    System.out.println(Integer.toHexString(c));
    System.out.println(FixedFloat.toFloat(c));
    System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(FixedFloat.toFloat(c))));

    int d=FixedFloat.toFixed(32768.0125d);
    int e=FixedFloat.toFixed(Double.NEGATIVE_INFINITY);
    int f=FixedFloat.toFixed(-2.5123d);
    System.out.println(FixedFloat.toFloat(d));
    System.out.println(FixedFloat.toFloat(e));
    System.out.println(FixedFloat.toFloat(f));
    
    System.out.println(FixedFloat.toDouble(d));
    System.out.println(FixedFloat.toDouble(e));
    System.out.println(FixedFloat.toDouble(f));
    
    int g=FixedFloat.toFixed(10.0);
    int h=FixedFloat.toFixed(3.0);
    System.out.println(FixedFloat.toFloat(FixedDiv(g,h)));
    
    //System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(FixedFloat.toDouble(c))));

    /*
    fixed_t.FixedMul(a,b,b);    
    System.out.println(Integer.toHexString(b.get()));    

    a=F2F(2.5f);
    b=F2F(2.5f);
    
    
   // a.set(a.val+b.val-(fixed_t.FixedMul(F2F(1.5f),a)).val);
    System.out.println(Integer.toHexString(a.get()));  
    
    a=F2F(10000.0f);
    b=F2F(0.5657f);
    
    System.out.println(Integer.toHexString(a.val));
    System.out.println(Integer.toHexString(b.val));
    
    a=fixed_t.FixedDiv(a,b);
    System.out.println(Integer.toHexString(a.val));
*/
}

public static fixed_t F2F(float f){
    fixed_t tmp;
    int ing;
    float frac;


    ing=(int)Math.floor(f);
    //System.out.println("Int: "+(int)(f));
    //System.out.println("Hex: "+Integer.toHexString(ing));

    //System.out.println("Frac: "+(f-Math.floor(f)));
    //System.out.println("Frac hex: "+Integer.toHexString(FixedDecimal(f)));

    tmp= new fixed_t((ing<<16)|FixedDecimal(f));
    //System.out.println(Integer.toHexString(tmp.val));    
    return tmp;

}

public static char FixedDecimal(float f){
         char fixint_value=0;
         float decimal_part= (float) (f-Math.floor(f));
for ( int i = 1; i <= PRECISION; i++)
{
   if (decimal_part > 1.f/(float)(i + 1.0))
   {
      decimal_part -= 1.f/(float)(i + 1.0);
      fixint_value |= (1 << PRECISION - i);
   }
}
return fixint_value;
}

public static double Value(int fixed){
    double dec=(fixed>>FRACBITS);
    double frac=0;char fixint_value=0;

    for ( int i = FRACBITS; i >=0; i--)
    {
       if (((fixed>>FRACBITS)&(0x0001))==1) {
           frac+=1/(2+(FRACBITS-i));
           }
    }
return (dec+frac);
}


}

