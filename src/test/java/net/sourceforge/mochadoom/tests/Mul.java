package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.menu.fixed_t;

public class Mul
        implements Operation {

    @Override
    public void invoke(fixed_t a, fixed_t b) {
        a.FixedMul(b);

    }

}
