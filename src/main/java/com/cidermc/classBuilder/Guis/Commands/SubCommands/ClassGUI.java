package com.cidermc.classBuilder.Guis.Commands.SubCommands;

import com.cidermc.classBuilder.Guis.Commands.CommandStruct;
import org.bukkit.command.CommandSender;

public class ClassGUI extends CommandStruct {

    private final ClassGUI classGui;

    public ClassGUI() {

        classGui = new ClassGUI();

    }

    @Override
    public String getName() {
        return "OpenClassGUI";
    }

    @Override
    public String getDescription() {
        return "Opens the Class GUI for the player.";
    }

    @Override
    public String getSyntax() {
        return "/class";
    }

    @Override
    public String[] getAliases() {
        return new String[] {"classgui", "openclassgui"};
    }

    @Override
    public void commandRun(CommandSender commandSender, String[] args) {

        classGui.


    }
}
