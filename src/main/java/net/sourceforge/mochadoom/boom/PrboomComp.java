package net.sourceforge.mochadoom.boom;

public class PrboomComp {

    public PrboomComp(int minver, int maxver, boolean state, String cmd) {
        this.minver = minver;
        this.maxver = maxver;
        this.state = state;
        this.cmd = cmd;
    }

    public int minver;

    public int maxver;

    public boolean state;

    public String cmd;
}