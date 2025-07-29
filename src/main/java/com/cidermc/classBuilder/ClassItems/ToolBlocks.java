package com.cidermc.classBuilder.ClassItems;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class ToolBlocks {

    // Blocks that require/are best broken with a PICKAXE
    public static final Set<Material> PICKAXE_BLOCKS = Set.of(
            // Stone variants
            Material.STONE,
            Material.COBBLESTONE,
            Material.MOSSY_COBBLESTONE,
            Material.SMOOTH_STONE,
            Material.STONE_BRICKS,
            Material.MOSSY_STONE_BRICKS,
            Material.CRACKED_STONE_BRICKS,
            Material.CHISELED_STONE_BRICKS,
            Material.DEEPSLATE,
            Material.COBBLED_DEEPSLATE,
            Material.POLISHED_DEEPSLATE,
            Material.DEEPSLATE_BRICKS,
            Material.CRACKED_DEEPSLATE_BRICKS,
            Material.DEEPSLATE_TILES,
            Material.CRACKED_DEEPSLATE_TILES,
            Material.CHISELED_DEEPSLATE,

            // Granite, Diorite, Andesite
            Material.GRANITE,
            Material.POLISHED_GRANITE,
            Material.DIORITE,
            Material.POLISHED_DIORITE,
            Material.ANDESITE,
            Material.POLISHED_ANDESITE,
            Material.TUFF,

            // Ores
            Material.COAL_ORE,
            Material.DEEPSLATE_COAL_ORE,
            Material.IRON_ORE,
            Material.DEEPSLATE_IRON_ORE,
            Material.COPPER_ORE,
            Material.DEEPSLATE_COPPER_ORE,
            Material.GOLD_ORE,
            Material.DEEPSLATE_GOLD_ORE,
            Material.REDSTONE_ORE,
            Material.DEEPSLATE_REDSTONE_ORE,
            Material.EMERALD_ORE,
            Material.DEEPSLATE_EMERALD_ORE,
            Material.LAPIS_ORE,
            Material.DEEPSLATE_LAPIS_ORE,
            Material.DIAMOND_ORE,
            Material.DEEPSLATE_DIAMOND_ORE,
            Material.NETHER_GOLD_ORE,
            Material.NETHER_QUARTZ_ORE,
            Material.ANCIENT_DEBRIS,

            // Metal blocks
            Material.IRON_BLOCK,
            Material.COPPER_BLOCK,
            Material.EXPOSED_COPPER,
            Material.WEATHERED_COPPER,
            Material.OXIDIZED_COPPER,
            Material.CUT_COPPER,
            Material.EXPOSED_CUT_COPPER,
            Material.WEATHERED_CUT_COPPER,
            Material.OXIDIZED_CUT_COPPER,
            Material.WAXED_COPPER_BLOCK,
            Material.WAXED_EXPOSED_COPPER,
            Material.WAXED_WEATHERED_COPPER,
            Material.WAXED_OXIDIZED_COPPER,
            Material.GOLD_BLOCK,
            Material.DIAMOND_BLOCK,
            Material.EMERALD_BLOCK,
            Material.LAPIS_BLOCK,
            Material.REDSTONE_BLOCK,
            Material.COAL_BLOCK,
            Material.NETHERITE_BLOCK,

            // Other stone-like blocks
            Material.SANDSTONE,
            Material.CHISELED_SANDSTONE,
            Material.CUT_SANDSTONE,
            Material.SMOOTH_SANDSTONE,
            Material.RED_SANDSTONE,
            Material.CHISELED_RED_SANDSTONE,
            Material.CUT_RED_SANDSTONE,
            Material.SMOOTH_RED_SANDSTONE,
            Material.PRISMARINE,
            Material.PRISMARINE_BRICKS,
            Material.DARK_PRISMARINE,
            Material.NETHERRACK,
            Material.NETHER_BRICKS,
            Material.CRACKED_NETHER_BRICKS,
            Material.CHISELED_NETHER_BRICKS,
            Material.RED_NETHER_BRICKS,
            Material.BASALT,
            Material.POLISHED_BASALT,
            Material.SMOOTH_BASALT,
            Material.BLACKSTONE,
            Material.POLISHED_BLACKSTONE,
            Material.POLISHED_BLACKSTONE_BRICKS,
            Material.CRACKED_POLISHED_BLACKSTONE_BRICKS,
            Material.CHISELED_POLISHED_BLACKSTONE,
            Material.GILDED_BLACKSTONE,
            Material.END_STONE,
            Material.END_STONE_BRICKS,
            Material.PURPUR_BLOCK,
            Material.PURPUR_PILLAR,
            Material.OBSIDIAN,
            Material.CRYING_OBSIDIAN,

            // Rails and redstone
            Material.RAIL,
            Material.POWERED_RAIL,
            Material.DETECTOR_RAIL,
            Material.ACTIVATOR_RAIL,
            Material.REDSTONE_LAMP,
            Material.OBSERVER,
            Material.DROPPER,
            Material.DISPENSER,
            Material.PISTON,
            Material.STICKY_PISTON,
            Material.HOPPER,
            Material.FURNACE,
            Material.BLAST_FURNACE,
            Material.SMOKER,
            Material.STONECUTTER,
            Material.BREWING_STAND,
            Material.CAULDRON,
            Material.ANVIL,
            Material.CHIPPED_ANVIL,
            Material.DAMAGED_ANVIL,
            Material.IRON_DOOR,
            Material.IRON_TRAPDOOR,
            Material.IRON_BARS,
            Material.CHAIN,
            Material.LANTERN,
            Material.SOUL_LANTERN,
            Material.BELL,
            Material.GRINDSTONE,
            Material.LODESTONE,
            Material.RESPAWN_ANCHOR
    );

    // Blocks that require/are best broken with an AXE
    public static final Set<Material> AXE_BLOCKS = Set.of(
            // Wood logs
            Material.OAK_LOG,
            Material.SPRUCE_LOG,
            Material.BIRCH_LOG,
            Material.JUNGLE_LOG,
            Material.ACACIA_LOG,
            Material.DARK_OAK_LOG,
            Material.MANGROVE_LOG,
            Material.CHERRY_LOG,
            Material.CRIMSON_STEM,
            Material.WARPED_STEM,
            Material.STRIPPED_OAK_LOG,
            Material.STRIPPED_SPRUCE_LOG,
            Material.STRIPPED_BIRCH_LOG,
            Material.STRIPPED_JUNGLE_LOG,
            Material.STRIPPED_ACACIA_LOG,
            Material.STRIPPED_DARK_OAK_LOG,
            Material.STRIPPED_MANGROVE_LOG,
            Material.STRIPPED_CHERRY_LOG,
            Material.STRIPPED_CRIMSON_STEM,
            Material.STRIPPED_WARPED_STEM,

            // Wood blocks
            Material.OAK_WOOD,
            Material.SPRUCE_WOOD,
            Material.BIRCH_WOOD,
            Material.JUNGLE_WOOD,
            Material.ACACIA_WOOD,
            Material.DARK_OAK_WOOD,
            Material.MANGROVE_WOOD,
            Material.CHERRY_WOOD,
            Material.CRIMSON_HYPHAE,
            Material.WARPED_HYPHAE,
            Material.STRIPPED_OAK_WOOD,
            Material.STRIPPED_SPRUCE_WOOD,
            Material.STRIPPED_BIRCH_WOOD,
            Material.STRIPPED_JUNGLE_WOOD,
            Material.STRIPPED_ACACIA_WOOD,
            Material.STRIPPED_DARK_OAK_WOOD,
            Material.STRIPPED_MANGROVE_WOOD,
            Material.STRIPPED_CHERRY_WOOD,
            Material.STRIPPED_CRIMSON_HYPHAE,
            Material.STRIPPED_WARPED_HYPHAE,

            // Planks
            Material.OAK_PLANKS,
            Material.SPRUCE_PLANKS,
            Material.BIRCH_PLANKS,
            Material.JUNGLE_PLANKS,
            Material.ACACIA_PLANKS,
            Material.DARK_OAK_PLANKS,
            Material.MANGROVE_PLANKS,
            Material.CHERRY_PLANKS,
            Material.CRIMSON_PLANKS,
            Material.WARPED_PLANKS,
            Material.BAMBOO_PLANKS,

            // Wooden stairs
            Material.OAK_STAIRS,
            Material.SPRUCE_STAIRS,
            Material.BIRCH_STAIRS,
            Material.JUNGLE_STAIRS,
            Material.ACACIA_STAIRS,
            Material.DARK_OAK_STAIRS,
            Material.MANGROVE_STAIRS,
            Material.CHERRY_STAIRS,
            Material.CRIMSON_STAIRS,
            Material.WARPED_STAIRS,
            Material.BAMBOO_STAIRS,

            // Wooden slabs
            Material.OAK_SLAB,
            Material.SPRUCE_SLAB,
            Material.BIRCH_SLAB,
            Material.JUNGLE_SLAB,
            Material.ACACIA_SLAB,
            Material.DARK_OAK_SLAB,
            Material.MANGROVE_SLAB,
            Material.CHERRY_SLAB,
            Material.CRIMSON_SLAB,
            Material.WARPED_SLAB,
            Material.BAMBOO_SLAB,

            // Wooden fences and gates
            Material.OAK_FENCE,
            Material.SPRUCE_FENCE,
            Material.BIRCH_FENCE,
            Material.JUNGLE_FENCE,
            Material.ACACIA_FENCE,
            Material.DARK_OAK_FENCE,
            Material.MANGROVE_FENCE,
            Material.CHERRY_FENCE,
            Material.CRIMSON_FENCE,
            Material.WARPED_FENCE,
            Material.BAMBOO_FENCE,
            Material.OAK_FENCE_GATE,
            Material.SPRUCE_FENCE_GATE,
            Material.BIRCH_FENCE_GATE,
            Material.JUNGLE_FENCE_GATE,
            Material.ACACIA_FENCE_GATE,
            Material.DARK_OAK_FENCE_GATE,
            Material.MANGROVE_FENCE_GATE,
            Material.CHERRY_FENCE_GATE,
            Material.CRIMSON_FENCE_GATE,
            Material.WARPED_FENCE_GATE,
            Material.BAMBOO_FENCE_GATE,

            // Wooden doors and trapdoors
            Material.OAK_DOOR,
            Material.SPRUCE_DOOR,
            Material.BIRCH_DOOR,
            Material.JUNGLE_DOOR,
            Material.ACACIA_DOOR,
            Material.DARK_OAK_DOOR,
            Material.MANGROVE_DOOR,
            Material.CHERRY_DOOR,
            Material.CRIMSON_DOOR,
            Material.WARPED_DOOR,
            Material.BAMBOO_DOOR,
            Material.OAK_TRAPDOOR,
            Material.SPRUCE_TRAPDOOR,
            Material.BIRCH_TRAPDOOR,
            Material.JUNGLE_TRAPDOOR,
            Material.ACACIA_TRAPDOOR,
            Material.DARK_OAK_TRAPDOOR,
            Material.MANGROVE_TRAPDOOR,
            Material.CHERRY_TRAPDOOR,
            Material.CRIMSON_TRAPDOOR,
            Material.WARPED_TRAPDOOR,
            Material.BAMBOO_TRAPDOOR,

            // Other wooden items
            Material.CRAFTING_TABLE,
            Material.CHEST,
            Material.TRAPPED_CHEST,
            Material.BARREL,
            Material.BOOKSHELF,
            Material.LECTERN,
            Material.COMPOSTER,
            Material.CARTOGRAPHY_TABLE,
            Material.FLETCHING_TABLE,
            Material.SMITHING_TABLE,
            Material.LOOM,
            Material.NOTE_BLOCK,
            Material.JUKEBOX,
            Material.BAMBOO,
            Material.BAMBOO_BLOCK,
            Material.SCAFFOLDING,
            Material.MELON,
            Material.PUMPKIN,
            Material.CARVED_PUMPKIN,
            Material.JACK_O_LANTERN,
            Material.MUSHROOM_STEM,
            Material.BROWN_MUSHROOM_BLOCK,
            Material.RED_MUSHROOM_BLOCK
    );

    // Blocks that require/are best broken with a SHOVEL
    public static final Set<Material> SHOVEL_BLOCKS = Set.of(
            // Dirt variants
            Material.DIRT,
            Material.COARSE_DIRT,
            Material.ROOTED_DIRT,
            Material.PODZOL,
            Material.MYCELIUM,
            Material.GRASS_BLOCK,
            Material.DIRT_PATH,
            Material.FARMLAND,

            // Sand variants
            Material.SAND,
            Material.RED_SAND,
            Material.SUSPICIOUS_SAND,

            // Gravel and related
            Material.GRAVEL,
            Material.SUSPICIOUS_GRAVEL,
            Material.CLAY,

            // Snow and ice
            Material.SNOW,
            Material.SNOW_BLOCK,
            Material.POWDER_SNOW,
            Material.ICE,
            Material.PACKED_ICE,
            Material.BLUE_ICE,
            Material.FROSTED_ICE,

            // Soul blocks
            Material.SOUL_SAND,
            Material.SOUL_SOIL,

            // Concrete powder
            Material.WHITE_CONCRETE_POWDER,
            Material.ORANGE_CONCRETE_POWDER,
            Material.MAGENTA_CONCRETE_POWDER,
            Material.LIGHT_BLUE_CONCRETE_POWDER,
            Material.YELLOW_CONCRETE_POWDER,
            Material.LIME_CONCRETE_POWDER,
            Material.PINK_CONCRETE_POWDER,
            Material.GRAY_CONCRETE_POWDER,
            Material.LIGHT_GRAY_CONCRETE_POWDER,
            Material.CYAN_CONCRETE_POWDER,
            Material.PURPLE_CONCRETE_POWDER,
            Material.BLUE_CONCRETE_POWDER,
            Material.BROWN_CONCRETE_POWDER,
            Material.GREEN_CONCRETE_POWDER,
            Material.RED_CONCRETE_POWDER,
            Material.BLACK_CONCRETE_POWDER
    );

    // Utility methods
    public static boolean requiresPickaxe(Material material) {
        return PICKAXE_BLOCKS.contains(material);
    }

    public static boolean requiresAxe(Material material) {
        return AXE_BLOCKS.contains(material);
    }

    public static boolean requiresShovel(Material material) {
        return SHOVEL_BLOCKS.contains(material);
    }

    public enum ToolType {
        PICKAXE,
        AXE,
        SHOVEL,
        NONE
    }

    public static ToolType getRequiredTool(Material material) {
        if (requiresPickaxe(material)) return ToolType.PICKAXE;
        if (requiresAxe(material)) return ToolType.AXE;
        if (requiresShovel(material)) return ToolType.SHOVEL;
        return ToolType.NONE; // No specific tool required
    }

    public static ToolType getToolType(ItemStack item) {
        switch (item.getType()) {
            case DIAMOND_PICKAXE:
                return ToolType.PICKAXE;
            case DIAMOND_AXE:
                return ToolType.AXE;
            case DIAMOND_SHOVEL:
                return ToolType.SHOVEL;
            default:
                return ToolType.NONE; // No specific tool type

        }
    }

    public static ItemStack getRequiredToolItem(Material block) {

        ToolType requiredTool = getRequiredTool(block);
        return switch (requiredTool) {
            case PICKAXE -> new ItemStack(Material.DIAMOND_PICKAXE);
            case AXE -> new ItemStack(Material.DIAMOND_AXE);
            case SHOVEL -> new ItemStack(Material.DIAMOND_SHOVEL);
            default -> null; // No specific tool required
        };
    }
}