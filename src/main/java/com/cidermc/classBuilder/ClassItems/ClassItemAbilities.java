package com.cidermc.classBuilder.ClassItems;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class ClassItemAbilities implements Listener {

    @EventHandler
    public void arrowSpectralEffect(EntityDamageEvent event) {

        if (event.getDamageSource().getDirectEntity() instanceof Arrow arrow) {

            // Get who shot the arrow
            if (arrow.getShooter() instanceof Player shooter) {
                // Now you have both the arrow and the shooter
                //Checks just the hotbar of the shooter
                for(int i = 27; i < 37; i++) {
                    ItemStack item = shooter.getInventory().getItem(i);
                    if (item == null || item.getItemMeta() == null) continue;

                    PersistentDataContainer pdc = item.getItemMeta().getPersistentDataContainer();
                    String shooterName = pdc.get(ClassItems.classItemKey, PersistentDataType.STRING);

                    if(shooter.getName().equals(shooterName)) {
                        // Add spectral effect (glowing) to the damaged entity
                        LivingEntity target = (LivingEntity) event.getEntity();
                        target.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 200, 0)); // 10 seconds (200 ticks)
                    }
                }
            }
        }
    }

    @EventHandler
    public void multiTool(BlockDamageEvent event) {

        ItemStack currentItem = event.getItemInHand();
        ItemMeta currentItemMeta = currentItem.getItemMeta();
        PersistentDataContainer pdcCurrent = currentItemMeta.getPersistentDataContainer();

        if(Objects.equals(pdcCurrent.get(ClassItems.classItemKey, PersistentDataType.STRING), event.getPlayer().getName())) {


            if(ToolBlocks.getRequiredTool(event.getBlock().getType()) == ToolBlocks.ToolType.NONE) return;

            if(ToolBlocks.getRequiredTool(event.getBlock().getType()) == ToolBlocks.getToolType(currentItem)) {
                return; //right tool for block
            }

            ItemStack newItem = ToolBlocks.getRequiredToolItem(event.getBlock().getType());
            ItemMeta newItemMeta = newItem.getItemMeta();

            //TODO: copy the stats of current item to new item



        }

    }

}
