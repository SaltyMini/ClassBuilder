package com.cidermc.classBuilder.Guis;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ClassGUIManager {

    JsonObject descriptors;
    JsonObject classPerks;

    public ClassGUIManager() {

        try {
            InputStream inputStreamDescriptors = getClass().getClassLoader()
                    .getResourceAsStream("ClassDescriptors.json");

            InputStream inputStreamPerks = getClass().getClassLoader()
                    .getResourceAsStream("ClassPerks.json");

            if (inputStreamDescriptors == null || inputStreamPerks == null) {
                throw new RuntimeException("Could not find ClassDescriptors.json or ClassPerks.json in resources.");
            }

            InputStreamReader descriptorsReader = new InputStreamReader(inputStreamDescriptors);
            InputStreamReader perksReader = new InputStreamReader(inputStreamPerks);

            descriptors = JsonParser.parseReader(descriptorsReader).getAsJsonObject();
            classPerks = JsonParser.parseReader(perksReader).getAsJsonObject();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static GuiItem getPlaceHolderGlass() {

        GuiItem placeHolderGlass = ItemBuilder.from(Material.GRAY_STAINED_GLASS_PANE)
                .name(Component.text(" "))
                .lore(Component.text(" "))
                .asGuiItem();

        return placeHolderGlass;
    }

    public static GuiItem getMinerDescriptor() {

        List<Component> lore = List.of(
                Component.text("A class focused on mining resources."),
                Component.text("Unlocks various mining abilities and tools."),
                Component.text("Another lore"),
                Component.text("More lore")
        );

        GuiItem minerDescriptor = ItemBuilder.from(Material.BLUE_STAINED_GLASS_PANE)
                .name(Component.text("Miner Class"))
                .lore(lore)
                .asGuiItem();

        return minerDescriptor;
    }



}
