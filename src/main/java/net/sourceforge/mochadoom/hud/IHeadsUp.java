package net.sourceforge.mochadoom.hud;

import net.sourceforge.mochadoom.doom.event_t;
import net.sourceforge.mochadoom.rendering.patch_t;

public interface IHeadsUp {

    void Ticker();

    void Erase();

    void Drawer();

    boolean Responder(event_t ev);

    patch_t[] getHUFonts();

    char dequeueChatChar();

    void Init();

    void setChatMacro(int i, String s);

    void Start();

    void Stop();

}
