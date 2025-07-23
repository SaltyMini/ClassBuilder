package com.cidermc.classBuilder.YMLManager;

import com.cidermc.classBuilder.ClassBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PlayerDataManager {

    private final Plugin plugin;

    public PlayerDataManager() {

        plugin = ClassBuilder.getPlugin();


    }

    public void createYML(UUID uuid) throws IOException {

        if(!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        File dataFile = new File(plugin.getDataFolder(), uuid.toString() + ".yml");

        // Check if the file doesn't exist, then create it with default properties
        if (!dataFile.exists()) {
            dataFile.createNewFile();

            // Create YAML configuration and set default properties
            FileConfiguration config = YamlConfiguration.loadConfiguration(dataFile);

            // Set default tier properties
            config.set("Miner", "1");
            config.set("Farmer", "1");
            config.set("Hunter", "1");

            // Save the configuration to the file
            config.save(dataFile);
        }
    }
    
    public File getPlayerYML(UUID uuid) {
        return new File(plugin.getDataFolder(), uuid.toString() + ".yml");
    }

    public boolean playerHasTier(String className, UUID uuid, int tier) {

        File file = plugin.getDataFolder().toPath().resolve(uuid.toString() + ".yml").toFile();

        // Check if file exists
        if (!file.exists()) {
            return false;
        }

        // Load the YAML configuration
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if(className.equalsIgnoreCase("Miner")) {

            String tierString = config.getString("Miner");
            int hasTier = tierString.charAt(tierString.length() - 1) - '0';

            return hasTier >= tier;

        } else if(className.equalsIgnoreCase("Farmer")) {

            String tierString = config.getString("Farmer");
            int hasTier = tierString.charAt(tierString.length() - 1) - '0';

            return hasTier >= tier;

        } else if (className.equalsIgnoreCase("Hunter")) {

            String tierString = config.getString("Hunter");
            int hasTier = tierString.charAt(tierString.length() - 1) - '0';

            return hasTier >= tier;

        }

        return false;
    }


}
