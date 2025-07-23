package com.cidermc.classBuilder.Events;

import com.cidermc.classBuilder.YMLManager.PlayerDataManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class PlayerJoin implements Listener {

    PlayerDataManager playerDataManager;

    public PlayerJoin() {
        playerDataManager = new PlayerDataManager();
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {

        try {
            playerDataManager.createYML(event.getPlayer().getUniqueId());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
