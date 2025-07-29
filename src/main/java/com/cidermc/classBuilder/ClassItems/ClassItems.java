package com.cidermc.classBuilder.ClassItems;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class ClassItems {

    public static final NamespacedKey classItemKey = new NamespacedKey("classItemKey", "class_item_key");

    public ClassItems() {


    }

    public ItemStack minerItem(String crafterName, int prestigeLevel) {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);

        ItemMeta meta = item.getItemMeta();



        meta.displayName(Component.text("Diamond Drill").color(NamedTextColor.GOLD));
        List<Component> lore = List.of(
                Component.text("A powerful drill that can mine through all block types").color(NamedTextColor.GRAY),
                Component.text("May wear quickly").color(NamedTextColor.GRAY)
        );
        meta.lore(lore);

        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.addEnchant(Enchantment.EFFICIENCY, 3 + prestigeLevel, true);

        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        pdc.set(classItemKey, PersistentDataType.STRING, crafterName);

        return item;
    }

    public ItemStack hunterItem(String crafterName, int prestigeLevel) {
        ItemStack item = new ItemStack(Material.BOW);

        ItemMeta meta = item.getItemMeta();

        meta.displayName(Component.text("Hunter's Bow").color(NamedTextColor.GOLD));
        List<Component> lore = List.of(
                Component.text("A bow crafted by the finest hunters").color(NamedTextColor.GRAY),
                Component.text("Mobs hit with this bow glow").color(NamedTextColor.GRAY)
        );
        meta.lore(lore);

        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);

        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        pdc.set(classItemKey, PersistentDataType.STRING, crafterName);

        return item;
    }

    public ItemStack farmerItem(String crafterName, int prestigeLevel) {
        ItemStack item = new ItemStack(Material.DIAMOND_HOE);

        ItemMeta meta = item.getItemMeta();

        meta.displayName(Component.text("Diamond Hoe").color(NamedTextColor.GOLD));
        List<Component> lore = List.of(
                Component.text("A hoe that can till any soil").color(NamedTextColor.GRAY),
                Component.text("May wear quickly").color(NamedTextColor.GRAY)
        );
        meta.lore(lore);

        // level 0 10, level 1 15, level 2 20, level 3 25, level 4 30

        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.addEnchant(Enchantment.SHARPNESS, 10 + (prestigeLevel * 5), true);

        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        pdc.set(classItemKey, PersistentDataType.STRING, crafterName);

        return item;
    }



}
