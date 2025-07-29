package com.cidermc.classBuilder;

import com.cidermc.classBuilder.ClassRestrictions.Restrictions;
import com.cidermc.classBuilder.Commands.CommandManager;
import com.cidermc.classBuilder.Events.FarmerEvents.BreakCrop;
import com.cidermc.classBuilder.Events.HunterEvents.KillEntity;
import com.cidermc.classBuilder.Events.HunterEvents.TameWolf;
import com.cidermc.classBuilder.Events.MinerEvents.MineOre;
import com.cidermc.classBuilder.Events.PlayerJoin;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ClassBuilder extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        Objects.requireNonNull(getCommand("class")).setExecutor(new CommandManager());

        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new PlayerJoin(), plugin);
        pm.registerEvents(new MineOre(), plugin);
        pm.registerEvents(new TameWolf(), plugin);
        pm.registerEvents(new KillEntity(), plugin);
        pm.registerEvents(new BreakCrop(), plugin);
        pm.registerEvents(new Restrictions(), plugin);

    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
