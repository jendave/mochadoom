package net.sourceforge.mochadoom.tests;

public class TestPrimitiveClassDetection {

    public static void main(String argv[]) throws InstantiationException, IllegalAccessException{
        Object shit;
        Object shiiit=new double[5];
        shit=shiiit;
        System.out.println(shit.getClass());
        int status=-1;
        double[] something = null;
        
        
         if (shit instanceof double[]) 
             something=(double[])shit;
         
        System.out.println(something.length);
        
    }
}
