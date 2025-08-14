package com.cidermc.classBuilder.Overhauls.FishingOverhaul.LootTable.BiomeTables;

import com.cidermc.classBuilder.Overhauls.FishingOverhaul.LootTable.TableStructure;
import org.bukkit.Material;
import org.bukkit.block.Biome;

import java.util.Arrays;
import java.util.List;

public class Default implements TableStructure {

    @Override
    public List<Biome> biomes() {
        return null;
    }

    @Override
    public List<Material> materials() {
        return Arrays.asList(
                Material.COD,
                Material.SALMON,
                Material.PUFFERFISH
        );
    }

}
