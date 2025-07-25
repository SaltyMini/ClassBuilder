package com.cidermc.classBuilder.YMLManager;

import com.cidermc.classBuilder.ClassBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class PlayerDataManager {

    private final Plugin plugin;
    private static PlayerDataManager instance;

    public PlayerDataManager() {

        plugin = ClassBuilder.getPlugin();


    }

    public static PlayerDataManager getInstance() {
        if(instance == null) {
            instance = new PlayerDataManager();
        }
        return instance;
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

    public boolean playerHasTier(String perkTier, UUID uuid) {

        File file = plugin.getDataFolder().toPath().resolve(uuid.toString() + ".yml").toFile();

        // Check if file exists
        if (!file.exists()) {
            return false;
        }

        int tier = perkTier.charAt(perkTier.length() - 1) - '0';

        // Load the YAML configuration
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if(perkTier.contains("Miner")) {

            String tierString = config.getString("Miner");
            assert tierString != null;
            int hasTier = tierString.charAt(tierString.length() - 1) - '0';

            return hasTier >= tier;

        } else if(perkTier.contains("Farmer")) {

            String tierString = config.getString("Farmer");
            assert tierString != null;
            int hasTier = tierString.charAt(tierString.length() - 1) - '0';

            return hasTier >= tier;

        } else if (perkTier.contains("Hunter")) {

            String tierString = config.getString("Hunter");
            assert tierString != null;
            int hasTier = tierString.charAt(tierString.length() - 1) - '0';

            return hasTier >= tier;

        }

        return false;
    }

    public boolean playerHasExactTier(String perkTier, UUID uuid) {

        File file = plugin.getDataFolder().toPath().resolve(uuid.toString() + ".yml").toFile();

        // Check if file exists
        if (!file.exists()) {
            return false;
        }

        int tier = perkTier.charAt(perkTier.length() - 1) - '0';
        String formatterPerkName = perkTier.substring(0, perkTier.length() - 1);

        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        return Integer.parseInt(Objects.requireNonNull(config.getString(formatterPerkName))) == tier;
    }

    public void playerUpgradeTier(String perkKeyWithNumber, UUID uuid){

        String className = perkKeyWithNumber.replaceAll("\\d+", "");

        File file = new File(plugin.getDataFolder(), uuid.toString() + ".yml");

        // Load the YAML configuration
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set(className, String.valueOf(perkKeyWithNumber.charAt(perkKeyWithNumber.length() - 1) - '0'));

        try {
            config.save(file);
        } catch (IOException e) {
            ClassBuilder.getPlugin().getLogger().severe("Could not upgrade tier " + perkKeyWithNumber + " for player " + uuid.toString());
            e.printStackTrace();
        }

    }


}
