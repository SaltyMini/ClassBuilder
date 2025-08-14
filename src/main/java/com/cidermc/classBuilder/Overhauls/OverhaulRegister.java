package com.cidermc.classBuilder.Overhauls;

//This class is registor for all the overhauls
//This class is called on runtime in onEnable

import com.cidermc.classBuilder.Overhauls.FishingOverhaul.FishingOverhaul;

public class OverhaulRegister {

    private FishingOverhaul fishingOverhaul;

    public OverhaulRegister() {

        fishingOverhaul = new FishingOverhaul();


    }


}
