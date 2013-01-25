package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.menu.Swap;

public class TestSwap {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        short a=(short)0xBEEF;
        char c=(char)0xBABE;
        int b=0XDEADBABE;
        
        System.out.printf("%X\n",a);
        System.out.printf("%X\n",b);
        System.out.printf("%X\n",(int)c);
        a=Swap.SHORT(a);
        b=Swap.LONG(b);
        c=(char)Swap.SHORT(c);
        System.out.printf("%X\n",a);
        System.out.printf("%X\n",b);
        System.out.printf("%X\n",(int)c);
        c=(char)Swap.SHORT(a);
        System.out.printf("%X\n",(int)c);

        char aa=Swap.USHORT((char)a);
        System.out.printf("%X\n",(int)a);
        System.out.printf("%X\n",(int)aa);


    }

}
