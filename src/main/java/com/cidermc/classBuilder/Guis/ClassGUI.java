package com.cidermc.classBuilder.Guis;

import com.cidermc.classBuilder.YMLManager.PlayerDataManager;
import com.google.gson.JsonObject;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassGUI {

    private final ClassGUIManager guiManager;
    private final PlayerDataManager playerDataManager;

    public ClassGUI() {

        guiManager = ClassGUIManager.getInstance();
        this.playerDataManager = PlayerDataManager.getInstance();
    }

    public void openGUI(Player player) {

        Gui gui = guiBuilder(player);

        gui.open(player);

    }

    private Gui guiBuilder(Player player) {

        Gui gui = Gui.gui()
                .title(Component.text("Class Builder"))
                .rows(6)
                .create();

        gui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        /*
         *Miner class
         */
        gui.setItem(0, descriptorItem("Miner", ClassGlassColour.MINER));
        for(int i = 2; i < 10; i++) {

            String perkTier = "Miner" + i;
            gui.setItem(2, i, classSubItem(perkTier, player, gui));
        }

        /*
        *Hunter class
         */
        gui.setItem(0, descriptorItem("Hunter", ClassGlassColour.HUNTER));
        for(int i = 2; i < 10; i++) {

            String perkTier = "Hunter" + i;
            gui.setItem(2, i, classSubItem(perkTier, player, gui));
        }

        /*
         *Farmer class
         */
        gui.setItem(0, descriptorItem("Farmer", ClassGlassColour.FARMER));
        for(int i = 2; i < 10; i++) {

            String perkTier = "Farmer" + i;
            gui.setItem(2, i, classSubItem(perkTier, player, gui));
        }

        //Fill in empty slots with gray glass
        for(int i = 0; i < gui.getRows() * 9; i++) {
            if(gui.getGuiItem(i) == null) {
                // Set the item to a glass pane
                gui.setItem(i, ClassGUIManager.getPlaceHolderGlass());
            }
        }

        return gui;
    }

    private void updateGUI(Gui gui, Player player) {

    }

    public enum ClassGlassColour {
        HUNTER(Material.RED_STAINED_GLASS_PANE),
        MINER(Material.BLUE_STAINED_GLASS_PANE),
        FARMER(Material.YELLOW_STAINED_GLASS_PANE);

        private final Material material;

        ClassGlassColour(Material material) {
            this.material = material;
        }

        public Material getMaterial() {
            return material;
        }
    }


    private GuiItem descriptorItem(String className, ClassGlassColour colour) {

        JsonObject jsonObject = guiManager.getClassDescriptorItem(className);

        return ItemBuilder.from(colour.getMaterial())
                .name(Component.text(jsonObject.get("name").getAsString()))
                .lore(Component.text(jsonObject.get("description").getAsString()))
                .asGuiItem();
    }

    private GuiItem classSubItem(String perkTier, Player player, Gui gui) {

        JsonObject jsonObject = guiManager.getClassPerks(perkTier);

        List<Component> lore = new ArrayList<>();

        //If bedrock shows something has gone wrong
        Material colour = Material.BEDROCK;

        if(perkTier.contains("Miner")) {
            colour = ClassGlassColour.MINER.getMaterial();
        } else if(perkTier.contains("Farmer")) {
            colour = ClassGlassColour.FARMER.getMaterial();
        } else if(perkTier.contains("Hunter")) {
            colour = ClassGlassColour.HUNTER.getMaterial();
        }

        for(int i = 0; jsonObject.get("lore").getAsJsonArray().size() > i; i++) {
            lore.add(Component.text(jsonObject.get("lore").getAsJsonArray().get(i).getAsString()));
        }

        return ItemBuilder.from(
                colour)
                .name(Component.text(jsonObject.get("name").getAsString()))
                .lore(lore)
                .asGuiItem(event -> {
                    upgradeClass(perkTier, player, gui);
                });

    }

    public Material getItemMaterial(String className) {

        Material mat;

        if()

        return mat;
    }

    public boolean upgradeClass(String perkTier, Player player, Gui gui) {

        if(playerDataManager.playerHasTier(perkTier, player.getUniqueId())) {

            //upgrade player

            GuiItem confirmItem = ItemBuilder.from(Material.GREEN_STAINED_GLASS_PANE)
                            .name(Component.text("Confirm upgrade"))
                            .lore(Component.text("Click again to congfirm"))
                            .asGuiItem(event -> {

                                //TODO: complete upgrade

                                            });

        }

        return true;
    }


}
