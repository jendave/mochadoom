package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.menu.cheatseq_t;

public class TestCheats {

    
    public static void main(String argv[]){
    char  cheat_ammo_seq[] =
    {
        0xb2, 0x26, 0xf2, 0x66, 0xa2, 0xff  // idkfa
    };
    
    cheatseq_t idkfa=new cheatseq_t( cheat_ammo_seq);
    //event_t[] keystokes={new event_t('i'),new event_t('d') ,new event_t('k') ,new event_t('f') ,new event_t('a') };    
    
    //idkfa.sequence=cheat_ammo_seq
    System.out.println(idkfa.CheckCheat('i'));
    System.out.println(idkfa.CheckCheat('d'));
    System.out.println(idkfa.CheckCheat('k'));
    System.out.println(idkfa.CheckCheat('f'));
    System.out.println(idkfa.CheckCheat('a'));
    System.out.println(idkfa.CheckCheat('i'));
    System.out.println(idkfa.CheckCheat('d'));
    System.out.println(idkfa.CheckCheat('k'));
    System.out.println(idkfa.CheckCheat('f'));
    System.out.println(idkfa.CheckCheat('b'));
    System.out.println(idkfa.CheckCheat('i'));
    System.out.println(idkfa.CheckCheat('d'));
    System.out.println(idkfa.CheckCheat('k'));
    System.out.println(idkfa.CheckCheat('f'));
    System.out.println(idkfa.CheckCheat('a'));
    }
    
}
