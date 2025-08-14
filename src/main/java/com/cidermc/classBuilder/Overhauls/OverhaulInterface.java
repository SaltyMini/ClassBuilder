package com.cidermc.classBuilder.Overhauls;


/*
* This interface must be implemented by all sub overhaul manager classes, e.g. FishingOverhaul
 */

public interface OverhaulInterface {

    String getName();
    boolean isEnabled();

}
