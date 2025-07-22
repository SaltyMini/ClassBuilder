package com.cidermc.classBuilder.Guis;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ClassGUI {

    public void gui() {

        Gui gui = Gui.gui()
                .title(Component.text("Class Builder"))
                .rows(6)
                .create();


        //Items

    }

    public void openGUI(Player player) {

        Gui gui = Gui.gui()
                .title(Component.text("Class Builder"))
                .rows(6)
                .create();




        gui.open(player);

    }

    private Gui guiBuilder() {

        Gui gui = Gui.gui()
                .title(Component.text("Class Builder"))
                .rows(6)
                .create();



        //Fill bottom row





        //Fill in empty slots with gray glass
        for(int i = 0; i < gui.getRows() * 9; i++) {
            if(gui.getGuiItem(i) == null) {
                // Set the item to a glass pane
                gui.setItem(i, ClassGUIManager.getPlaceHolderGlass());
            }
        }

        return gui;
    }


    private enum glassColour {
        RED,
        GREEN,
    }

    private GuiItem getGlassColourItem(glassColour colour, String name, String... lore) {

        GuiItem item = null;

        switch (colour) {
            case RED -> {
                // Set item to red glass pane
                item = ItemBuilder.from(Material.RED_STAINED_GLASS_PANE)
                        .name(Component.text(name))
                        .lore(Component.text(Arrays.toString(lore))).asGuiItem();
            }
            case GREEN -> {
                // Set item to green glass pane
                item = ItemBuilder.from(Material.GREEN_STAINED_GLASS_PANE)
                        .name(Component.text(name))
                        .lore(Component.text(Arrays.toString(lore))).asGuiItem();
            }
        }

        return item;

    }



}
