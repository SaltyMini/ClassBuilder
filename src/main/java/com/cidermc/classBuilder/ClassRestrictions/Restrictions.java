package com.cidermc.classBuilder.ClassRestrictions;

import com.cidermc.classBuilder.YMLManager.PlayerDataManager;
import io.papermc.paper.event.block.BlockBreakBlockEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Restrictions implements Listener {

    @EventHandler
    public void blockDiamondBreak(BlockBreakEvent event) {

        if(event.getBlock().getType() == Material.DIAMOND_ORE) {

            if(!PlayerDataManager.getInstance().playerHasPerk(event.getPlayer().getUniqueId(), "BREAK_DIAMONDS", "Miner")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(Component.text("You need the Miner perk to break diamonds!").color(NamedTextColor.RED));
            }


        }

    }


}
