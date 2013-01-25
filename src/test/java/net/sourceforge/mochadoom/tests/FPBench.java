package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.menu.FixedFloat;
import net.sourceforge.mochadoom.menu.fixed_t;

class FPBench{         
public static final int PRECISION=16;

    public static void main(String argv[])
{
    final int tests=500000;
 for (int j=0;j<2;j++){   
    float[] a=new float[tests];
    float[] b=new float[tests];
    float[] c=new float[tests];
    fixed_t[] fa=new fixed_t[tests];
    fixed_t[] fb=new fixed_t[tests];
    fixed_t[] fc=new fixed_t[tests];
    
    long tan_0=System.nanoTime();
    for (int i=0;i<tests;i++){           
    a[i]=((float)(Math.random()*65535.0-32678.0));
    b[i]=((float)(Math.random()*65535.0-32678.0));
    }
    long tan_1=System.nanoTime();
    
    System.out.println("Allocate "+tests+" random IEEE floats: \t" + (tan_1-tan_0));
    
    tan_0=System.nanoTime();
    for (int i=0;i<tests;i++){           
    fa[i]=F2F(a[i]);
    fb[i]=F2F(b[i]);
    }
    tan_1=System.nanoTime();
    
    System.out.println("Convert "+tests+" random IEEE floats into fixed_t (creates new): \t" + (tan_1-tan_0));
    
    tan_0=System.nanoTime();
    for (int i=0;i<tests;i++){           
    F2F(a[i],fa[i]);
    F2F(b[i],fb[i]);
    }
    tan_1=System.nanoTime();
    
    System.out.println("Convert "+tests+" random IEEE floats into fixed_t (reuses objects): \t" + (tan_1-tan_0));
    
    tan_0=System.nanoTime();
    for (int i=0;i<tests;i++){           
    fa[i].set(FixedFloat.toFixed(a[i]));
    fb[i].set(FixedFloat.toFixed(b[i]));
    }
    tan_1=System.nanoTime();
    
    System.out.println("Convert "+tests+" random IEEE floats into fixed_t (new method, reuses objects): \t" + (tan_1-tan_0));
    
    tan_0=System.nanoTime();
    for (int i=0;i<tests;i++){
     c[i]=a[i]*b[i];    
    }
    tan_1=System.nanoTime();
    
    System.out.println("Perform "+tests+" random IEEE floats multiplications: \t" + (tan_1-tan_0));
    
    tan_0=System.nanoTime();
    for (int i=0;i<tests;i++){
     fc[i]=new fixed_t(fixed_t.FixedMul(fa[i],fb[i]));    
    }
    tan_1=System.nanoTime();

    System.out.println("Perform "+tests+" random fixed_t multiplications (new objects): \t"+ (tan_1-tan_0));
    
    System.out.println(tan_1-tan_0);
    
    tan_0=System.nanoTime();
    for (int i=0;i<tests;i++){
     fc[i].val=(fixed_t.FixedMulInt(fa[i],fb[i]));    
    }
    tan_1=System.nanoTime();
    
    System.out.println("Perform "+tests+" random fixed_t multiplications (integer return): \t" + (tan_1-tan_0));
    
    tan_0=System.nanoTime();
    for (int i=0;i<tests;i++){
     fixed_t.FixedMul(fa[i],fb[i],fc[i]);    
    }
    tan_1=System.nanoTime();
    
    System.out.println("Perform "+tests+" random fixed_t multiplications (in-place): \t"+ (tan_1-tan_0));

    tan_0=System.nanoTime();
    for (int i=0;i<tests;i++){
     c[i]=a[i]/b[i];    
    }
    tan_1=System.nanoTime();
    
    System.out.println("Perform "+tests+" random IEEE floats divisions: \t" + (tan_1-tan_0));
    
    
    tan_0=System.nanoTime();
    for (int i=0;i<tests;i++){
       // fc[i]=fixed_t.FixedDiv(fa[i],fb[i]);    
    }
    tan_1=System.nanoTime();
    
    System.out.println("Perform "+tests+" random fixed_t divisions (new objects): \t"+ (tan_1-tan_0));
   
    tan_0=System.nanoTime();
    for (int i=0;i<tests;i++){
        //fixed_t.FixedDiv(fa[i],fb[i],fc[i]);    
    }
    tan_1=System.nanoTime();
    
    System.out.println("Perform "+tests+" random fixed_t divisions (in-place): \t"+ (tan_1-tan_0));
    
 }
}


public static fixed_t F2F(float f){
    fixed_t tmp;
    int ing;
    ing=(int)Math.floor(f);
    tmp= new fixed_t((ing<<16)|FixedDecimal(f));
    //System.out.println(Integer.toHexString(tmp.val));    
    return tmp;

}

public static void  F2F(float f, fixed_t tmp){
    int ing;
    ing=(int)Math.floor(f);
    tmp.set((ing<<16)|FixedDecimal(f));
}

public static char FixedDecimal(float f){
         char fixint_value=0;
         float decimal_part= (float) (f-Math.floor(f));
for ( int i = 1; i <= PRECISION; i++)
{
   if (decimal_part >= 1.f/(float)(i + 1))
   {
      decimal_part -= 1.f/(float)(i + 1);
      fixint_value |= (1 << PRECISION - i);
   }
}
return fixint_value;
}

}

