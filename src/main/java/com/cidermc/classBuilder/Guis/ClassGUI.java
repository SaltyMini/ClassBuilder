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

    public enum glassColour {
        RED,
        GREEN,
    }

    public enum classLevel {
        miner1,
        miner2,
        miner3,
        miner4,
        miner5,
        miner6,
        farmer1,
        farmer2,
        farmer3,
        farmer4,
        farmer5,
        farmer6,
        hunter1,
        hunter2,
        hunter3,
        hunter4,
        hunter5,
        hunter6,
    }

    public void openGUI(Player player) {

        Gui gui = Gui.gui()
                .title(Component.text("Class Builder"))
                .rows(6)
                .create();

//Fill in emptry slots with gray glass
        GuiItem placeHolderGlass = ItemBuilder.from(Material.GRAY_STAINED_GLASS_PANE)
                .name(Component.text(" "))
                .lore(Component.text(" "))
                .asGuiItem();

        for(int i = 0; i > gui.getRows() * 9; i++) {
            if(gui.getGuiItem(i) == null) {
                // Set the item to a glass pane

                gui.setItem(i, placeHolderGlass);
            }
        }

        gui.open(player);

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
