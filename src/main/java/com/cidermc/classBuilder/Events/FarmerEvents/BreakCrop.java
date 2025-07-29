package com.cidermc.classBuilder.Events.FarmerEvents;

import com.cidermc.classBuilder.YMLManager.PlayerDataManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakCrop implements Listener {

    private final double expPerCrop = 1;
    PlayerDataManager playerDataManager;

    public BreakCrop() {
        playerDataManager = PlayerDataManager.getInstance();
    }

    @EventHandler
    public void breakCrop(BlockBreakEvent event) {

        //TODO: implement after test
        //Make A enum list
        if(event.getBlock().getType() == Material.WHEAT) {
            playerDataManager.increaseEXP(expPerCrop * playerDataManager.getFarmerModifier(event.getPlayer().getUniqueId()), event.getPlayer().getUniqueId());
        }

    }

}
