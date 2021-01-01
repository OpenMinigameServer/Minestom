package net.minestom.server.via;

import nl.matsv.viabackwards.api.ViaBackwardsConfig;

public class MinestomViaBackwardsConfig implements ViaBackwardsConfig {
    @Override
    public boolean addCustomEnchantsToLore() {
        return true;
    }

    @Override
    public boolean addTeamColorTo1_13Prefix() {
        return false;
    }

    @Override
    public boolean isFix1_13FacePlayer() {
        return false;
    }

    @Override
    public boolean alwaysShowOriginalMobName() {
        return false;
    }
}
