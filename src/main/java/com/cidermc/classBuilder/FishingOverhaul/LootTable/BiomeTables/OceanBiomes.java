package com.cidermc.classBuilder.FishingOverhaul.LootTable.BiomeTables;

import com.cidermc.classBuilder.FishingOverhaul.LootTable.TableStructure;
import org.bukkit.Material;
import org.bukkit.block.Biome;

import java.util.List;

public class OceanBiomes implements TableStructure {
    @Override
    public List<Biome> biomes() {
        return List.of(Biome.OCEAN,
                Biome.DEEP_OCEAN,
                Biome.WARM_OCEAN,
                Biome.LUKEWARM_OCEAN,
                Biome.COLD_OCEAN,
                Biome.FROZEN_OCEAN);
    }

    @Override
    public List<Material> materials() {
        return List.of(Material.COD,
                Material.DIAMOND);
    }
}
