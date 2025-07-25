package com.cidermc.classBuilder.Guis;

import com.cidermc.classBuilder.YMLManager.PlayerDataManager;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.io.InputStream;
import java.io.InputStreamReader;

public class ClassGUIManager {

    JsonObject descriptors;
    JsonObject classPerks;

    PlayerDataManager playerDataManager;

    private static ClassGUIManager instance;

    public ClassGUIManager() {

        playerDataManager = PlayerDataManager.getInstance();

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

    public static ClassGUIManager getInstance() {
        if(instance == null) {
            instance = new ClassGUIManager();
        }
        return instance;
    }

    public static GuiItem getPlaceHolderGlass() {

        GuiItem placeHolderGlass = ItemBuilder.from(Material.GRAY_STAINED_GLASS_PANE)
                .name(Component.text(" "))
                .lore(Component.text(" "))
                .asGuiItem();


        return placeHolderGlass;
    }

    public JsonObject getClassDescriptorItem(String className) {
        return descriptors.getAsJsonObject(className);
    }

    public JsonObject getClassPerks(String classPerk) {
        return classPerks.getAsJsonObject(classPerk);
    }

    public GuiItem getInfoItem(Player player) {
        playerDataManager.getPlayerPowerLevel(player.getUniqueId());
        Material playerHead = Material.PLAYER_HEAD; //TODO: Get users head
        return ItemBuilder.from(playerHead)
                .name(Component.text("Info").color(NamedTextColor.GOLD))
                .lore(Component.text("Power Level").color(NamedTextColor.GRAY), Component.text(playerDataManager.getPlayerPowerLevel(player.getUniqueId())).color(NamedTextColor.GRAY), Component.text("/10").color(NamedTextColor.GRAY))
                .lore(Component.text("EXP: 0"))
                .asGuiItem();
    }

    public GuiItem getPrestigeItem() {

        return ItemBuilder.from(Material.ECHO_SHARD)
                .name(Component.text("Prestige").color(NamedTextColor.GOLD))
                .lore(Component.text("Click to prestige").color(NamedTextColor.GREEN))
                .lore(Component.text("This will reset your progress").color(NamedTextColor.RED))
                .lore(Component.text("+ 1 base perk in each class").color(NamedTextColor.GOLD))
                .lore(Component.text("+ Tag in chat").color(NamedTextColor.GOLD))
                .asGuiItem(event -> playerDataManager.prestigePlayer((Player) event.getWhoClicked()));

    }




}
