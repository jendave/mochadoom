package net.sourceforge.mochadoom.doom;

/**
 * A shiny new and enterprisey (yeah right) interface for
 * command-line handling. No more argv/argc nastiness!
 *
 * @author velktron
 */

public interface ICommandLineManager {

    public abstract String getArgv(int index);

    public abstract int getArgc();

    /**
     * M_CheckParm Checks for the given parameter in the program's command line
     * arguments. Returns the argument number (1 to argc-1) or 0 if not present
     * <p/>
     * OK, now WHY ON EARTH was this be defined in m_menu.c?
     * <p/>
     * MAES: this needs to be modified for Java, or else bump myargc one element up.
     */

    public abstract int CheckParm(String check);

    void FindResponseFile();

    public abstract void setArgv(int index, String string);

    boolean CheckParmBool(String check);

}