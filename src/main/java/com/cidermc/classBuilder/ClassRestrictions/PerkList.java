package com.cidermc.classBuilder.ClassRestrictions;

public class PerkList {

    public enum HunterPerks {
        TAME_WOLF, //Tame wolfs
        REDUCE_NOISE_PASSIVE, //reduced range mob can hear you
        REDUCE_NOISE_HOSTILE, //reduces range hostile mobs can hear you
        SILENT_STEP, //mobs cant hear you anymore
        REDUCE_VISION_MOBS, //reduce mob vision range
        INCREASE_CRITICAL_DMG, //increase critical damage by 25%
        ALLOW_HEADSHOT, //Ability to headshot with bow
    }

    enum MinerPerks {
        BREAK_DIAMONDS, //Ability to break diamonds
        NORMAL_CAVE_MOB_DMG, // Normal cave mob damage
        REDUCED_CAVE_MOB_SPAWN, // Reduced cave mob spawn rate
        INCREASED_SMELT_TIME, // 50% faster smelting
        REDUCED_CAVE_FALL_DMG, // Reduced cave fall damage
        HARDENED_SKIN, // Remove lava hit flinch, reduce lava burn time and damage
        CRAFT_DYNAMITE, // Ability to craft dynamite, a short throw explosive
    }

    enum FarmerPerks {
        BREED_ANIMALS, // Ability to breed animals
        FARM_CROPS_100, // 100 percent chance to get crop
        FARM_CROPS_150, // 50% chance to get 2 crops
        REMOVE_EATING, // half eat time and remove slowdown
        BUFFED_GOLDEN_APPLE, //increase added hearts from golden apple, longer regen time
        STOP_CROP_TRAMPLE, //disables trampling crops
        TAME_HORSE, // Ability to tame horse
    }

    //TODO: Make wolf and horse transferable to other players
}



