package net.sourceforge.mochadoom.tests;



public class TestLightLevels {

    public static final int LIGHTLEVELS= 32;
    public static final int MAXLIGHTSCALE =48;
    public static final int NUMCOLORMAPS =32;
    public static final int LIGHTBRIGHT =2;
    public static final int DISTMAP =2;
    
    public static void main(String[] argv){
        for (int i = 0; i < LIGHTLEVELS; i++) {
            int startmap = ((LIGHTLEVELS-LIGHTBRIGHT-i)*2)*NUMCOLORMAPS/LIGHTLEVELS;
            for (int j = 0; j < MAXLIGHTSCALE; j++) {
                int level =
                    startmap - j/ DISTMAP;
                if (level < 0)
                    level = 0;
                if (level >= NUMCOLORMAPS)
                    level = NUMCOLORMAPS - 1;
                System.out.printf("%d ",level);
            }
            System.out.printf("\n");
            }
        }
    }
