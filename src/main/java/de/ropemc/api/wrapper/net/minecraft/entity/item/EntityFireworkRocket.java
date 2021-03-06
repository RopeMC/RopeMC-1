package de.ropemc.api.wrapper.net.minecraft.entity.item;

import de.ropemc.api.wrapper.net.minecraft.nbt.NBTTagCompound;
import de.ropemc.api.wrapper.WrappedClass;

@WrappedClass("net.minecraft.entity.item.EntityFireworkRocket")
public interface EntityFireworkRocket {

    boolean canAttackWithItem();

    void entityInit();

    float getBrightness(float var0);

    int getBrightnessForRender(float var0);

    void handleStatusUpdate(byte var0);

    boolean isInRangeToRenderDist(double var0);

    void onUpdate();

    void readEntityFromNBT(NBTTagCompound var0);

    void setVelocity(double var0, double var1, double var2);

    void writeEntityToNBT(NBTTagCompound var0);

}
