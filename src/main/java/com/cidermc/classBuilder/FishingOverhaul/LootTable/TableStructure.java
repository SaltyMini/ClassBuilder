package com.cidermc.classBuilder.FishingOverhaul.LootTable;

import org.bukkit.Material;
import org.bukkit.block.Biome;

import java.util.List;

public interface TableStructure {

    public List<Biome> biomes();
    public List<Material> materials();

}
