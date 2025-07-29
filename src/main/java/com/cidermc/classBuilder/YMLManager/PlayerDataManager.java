package com.cidermc.classBuilder.YMLManager;

import com.cidermc.classBuilder.ClassBuilder;
import com.cidermc.classBuilder.Guis.ClassGUIManager;
import com.google.gson.JsonObject;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class PlayerDataManager {

    private final Plugin plugin;
    private static PlayerDataManager instance;

    private final ClassGUIManager guiManager;

    public PlayerDataManager() {

        plugin = ClassBuilder.getPlugin();
        this.guiManager = ClassGUIManager.getInstance();

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
            config.set("Miner", 1);
            config.set("Farmer", 1);
            config.set("Hunter", 1);
            config.set("powerLevel", 0);
            config.set("prestige", 0);
            config.set("exp", 0);

            // Save the configuration to the file
            config.save(dataFile);
        }
    }

    //TODO: cache configs
    
    private YamlConfiguration getConfig(UUID uuid) {
        File file = new File(plugin.getDataFolder(), uuid + ".yml");

        if (!file.exists()) {
            try {
                createYML(uuid);
                ClassBuilder.getPlugin().getLogger().severe("Creating missing UUID file " + uuid);
            } catch (IOException e) {
                ClassBuilder.getPlugin().getLogger().severe("Could not create file for player " + uuid);
                throw new RuntimeException("Could not create file for player " + uuid, e);
            }
        }
        return YamlConfiguration.loadConfiguration(file);
    }

    public boolean isMaxPowerLevel(UUID uuid) {

        YamlConfiguration config = getConfig(uuid);

        return !(7 < config.getInt("powerLevel"));
    }


    public int getPlayerPowerLevel(UUID uuid) {

        YamlConfiguration config = getConfig(uuid);

        return config.getInt("powerLevel");
    }


    public boolean playerHasTier(String perkTier, UUID uuid) {

        // Check if file exists


        int tier = perkTier.charAt(perkTier.length() - 1) - '0';

        // Load the YAML configuration
        FileConfiguration config = getConfig(uuid);

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

        int tier = perkTier.charAt(perkTier.length() - 1) - '0';
        String formatterPerkName = perkTier.substring(0, perkTier.length() - 1);

        FileConfiguration config = getConfig(uuid);

        return Integer.parseInt(Objects.requireNonNull(config.getString(formatterPerkName))) == tier;
    }

    public synchronized void playerUpgradeTier(String perkKeyWithNumber, UUID uuid){

        String className = perkKeyWithNumber.replaceAll("\\d+", "");

        File file = new File(plugin.getDataFolder(), uuid.toString() + ".yml");

        // Load the YAML configuration
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set(className, String.valueOf(perkKeyWithNumber.charAt(perkKeyWithNumber.length() - 1) - '0'));

        try {
            config.save(file);
        } catch (IOException e) {
            ClassBuilder.getPlugin().getLogger().severe("Could not upgrade tier " + perkKeyWithNumber + " for player " + uuid);
        }

    }

    public enum Classes {
        Miner,
        Hunter,
        Farmer
    }

    public synchronized void increaseEXP(double exp, UUID uuid) {

        YamlConfiguration config = getConfig(uuid);

        int currentEXP = config.getInt("exp");

        config.set("exp", currentEXP + exp);

        try {
            config.save(new File(plugin.getDataFolder(), uuid.toString() + ".yml"));
        } catch (IOException e) {
            ClassBuilder.getPlugin().getLogger().severe("Could not increase EXP for player " + uuid);
        }

    }

    public void prestigePlayer(Player player) {


        YamlConfiguration config = getConfig(player.getUniqueId());

        if(!isMaxPowerLevel(player.getUniqueId())) {
            player.playSound(player.getLocation(), "ENTITY_VILLAGER_NO", 1, 1);
            player.sendMessage(Component.text("You must be max power level").color(NamedTextColor.RED));
        }

        int prestige = config.getInt("prestige");
        if(prestige == 4) {
            player.playSound(player.getLocation(), "ENTITY_VILLAGER_NO", 1, 1);
            player.sendMessage(Component.text("You have reached the max prestige level").color(NamedTextColor.RED));
        }
        config.set("prestige", prestige + 1);

        player.playSound(player.getLocation(), "ENTITY_VILLAGER_CELEBRATE", 1, 1);
        player.sendMessage(Component.text("You have prestiged!").color(NamedTextColor.RED));

        config.set("Miner", config.get("prestige"));
        config.set("Farmer", config.get("prestige"));
        config.set("Hunter", config.get("prestige"));


        try {
            config.save(new File(plugin.getDataFolder(), player.getUniqueId() + ".yml"));
        } catch (IOException e) {
            ClassBuilder.getPlugin().getLogger().severe("Could not prestige player " + player.getUniqueId());
        }

    }

    public double getMinerModifier(UUID uuid) {
        YamlConfiguration config = getConfig(uuid);

        return 1 + (config.getInt("Miner") * 0.1);
    }

    public double getFarmerModifier(UUID uuid) {
        YamlConfiguration config = getConfig(uuid);

        return 1 + (config.getInt("Farmer") * 0.1);
    }

    public double getHunterModifier(UUID uuid) {
        YamlConfiguration config = getConfig(uuid);

        return 1 + (config.getInt("Hunter") * 0.1);
    }

    public boolean playerHasPerk(UUID uuid, String perkName, String className) {
        YamlConfiguration config = getConfig(uuid);
        int playerTier = config.getInt(className); // e.g., "Hunter", "Miner", "Farmer"

        // Check all tiers from 1 up to the player's current tier
        for(int tier = 1; tier <= playerTier; tier++) {
            JsonObject tierData = guiManager.getClassPerks(className.toLowerCase() + tier);


                for(int i = 0; i < tierData.get("perks").getAsJsonArray().size(); i++) {
                    String perk = tierData.get("perks").getAsJsonArray().get(i).getAsString();
                    if(perk.equals(perkName)) {
                        return true;
                    }
                }
        }

        return false;
    }


}
