package net.sourceforge.mochadoom.menu;

import static net.sourceforge.mochadoom.doom.English.HUSTR_CHATMACRO0;
import static net.sourceforge.mochadoom.doom.English.HUSTR_CHATMACRO1;
import static net.sourceforge.mochadoom.doom.English.HUSTR_CHATMACRO2;
import static net.sourceforge.mochadoom.doom.English.HUSTR_CHATMACRO3;
import static net.sourceforge.mochadoom.doom.English.HUSTR_CHATMACRO4;
import static net.sourceforge.mochadoom.doom.English.HUSTR_CHATMACRO5;
import static net.sourceforge.mochadoom.doom.English.HUSTR_CHATMACRO6;
import static net.sourceforge.mochadoom.doom.English.HUSTR_CHATMACRO7;
import static net.sourceforge.mochadoom.doom.English.HUSTR_CHATMACRO8;
import static net.sourceforge.mochadoom.doom.English.HUSTR_CHATMACRO9;
import static net.sourceforge.mochadoom.game.Keys.KEY_ALT;
import static net.sourceforge.mochadoom.game.Keys.KEY_CTRL;
import static net.sourceforge.mochadoom.game.Keys.KEY_LEFTARROW;
import static net.sourceforge.mochadoom.game.Keys.KEY_RIGHTARROW;
import static net.sourceforge.mochadoom.game.Keys.KEY_SHIFT;


/**
 * An anumeration with the most basic default Doom settings their default
 * values, used if nothing else is available. They are applied first thing,
 * and then updated from the .cfg file.
 */

public enum Settings {
    mouse_sensitivity("5"),
    sfx_volume("8"),
    music_volume("8"),
    show_messages("1"),
    alwaysrun("1"),
    key_right(KEY_RIGHTARROW),
    key_left(KEY_LEFTARROW),
    key_up('w'),
    key_down('s'),
    key_strafeleft('a'),
    key_straferight('d'),
    key_fire(KEY_CTRL),
    key_use(' '),
    key_strafe(KEY_ALT),
    key_speed(KEY_SHIFT),
    use_mouse(1),
    mouseb_fire(0),
    mouseb_strafe(1),
    mouseb_forward(2),
    use_joystick(0),
    joyb_fire(0),
    joyb_strafe(1),
    joyb_use(3),
    joyb_speed(2),
    screenblocks(10),
    detaillevel(0),
    snd_channels(6),
    usegamma(0),
    mb_used(2),
    chatmacro0(HUSTR_CHATMACRO0),
    chatmacro1(HUSTR_CHATMACRO1),
    chatmacro2(HUSTR_CHATMACRO2),
    chatmacro3(HUSTR_CHATMACRO3),
    chatmacro4(HUSTR_CHATMACRO4),
    chatmacro5(HUSTR_CHATMACRO5),
    chatmacro6(HUSTR_CHATMACRO6),
    chatmacro7(HUSTR_CHATMACRO7),
    chatmacro8(HUSTR_CHATMACRO8),
    chatmacro9(HUSTR_CHATMACRO9);

    private Settings(String defaultval) {
        this.value = defaultval;
    }


    private Settings(int defaultval) {
        this.value = Integer.toString(defaultval);
    }

    public String value;

    /**
     * Normally this is default.cfg, might be .doomrc on lunix???
     */

    public static String basedefault = "default.cfg";

}