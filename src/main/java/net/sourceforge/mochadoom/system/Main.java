package net.sourceforge.mochadoom.system;

import java.io.IOException;
import net.sourceforge.mochadoom.doom.CommandLine;
import net.sourceforge.mochadoom.doom.DoomMain;
import net.sourceforge.mochadoom.doom.ICommandLineManager;
import net.sourceforge.mochadoom.menu.IVariablesManager;
import net.sourceforge.mochadoom.menu.VarsManager;

//Emacs style mode select   -*- C++ -*- 
//-----------------------------------------------------------------------------
//
//$Id: Main.java,v 1.13 2012/11/06 16:05:17 velktron Exp $
//
//Copyright (C) 1993-1996 by id Software, Inc.
//
//This program is free software; you can redistribute it and/or
//modify it under the terms of the GNU General Public License
//as published by the Free Software Foundation; either version 2
//of the License, or (at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//
//DESCRIPTION:
//Main program, simply calls D_DoomMain high level loop after loading 
//some essential settings and determining what "flavor" we're going to run.
//
//-----------------------------------------------------------------------------


public class Main {
    public static BppMode bpp;

    public static void main(String[] argv) throws IOException {

        //First, get the command line parameters.
        ICommandLineManager clm = new CommandLine(argv);

        // Handles variables and settings from default.cfg
        IVariablesManager vm = new VarsManager(clm);

        // load before initing other systems, but don't apply them yet.
        System.out.print("M_LoadDefaults: Load system defaults.\n");
        vm.LoadDefaults(vm.getDefaultFile());

        bpp = BppMode.Indexed;

        if (vm.isSettingLiteral("color_depth", "hicolor"))
            bpp = BppMode.HiColor;
        if (vm.isSettingLiteral("color_depth", "truecolor"))
            bpp = BppMode.TrueColor;

        if (clm.CheckParmBool("-hicolor")) bpp = BppMode.HiColor;
        else if (clm.CheckParmBool("-truecolor")) bpp = BppMode.TrueColor;


        // Here we create DOOM
        DoomMain<?, ?> dm = null;
        // Create a dummy. This will force static init to run.

        switch (bpp) {
            case Indexed:
                System.out.println("Indexed 8-bit mode selected...");
                dm = new DoomMain.Indexed();
                break;
            case HiColor:
                System.out.println("HiColor (Alpha) 16-bit mode selected...");
                dm = new DoomMain.HiColor();
                break;
            case TrueColor:
                System.out.println("TrueColor (extended colormaps) 24-bit mode selected...");
                dm = new DoomMain.TrueColor();
                break;

        }

        dm.setCommandLineArgs(clm);
        dm.registerVariableManager(vm);
        dm.Init();
        dm.Start();

        return;
    }
}
