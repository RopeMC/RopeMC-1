package de.ropemc.api.wrapper.net.minecraft.entity.ai;

import de.ropemc.api.wrapper.WrappedClass;

@WrappedClass("net.minecraft.entity.ai.EntityJumpHelper")
public interface EntityJumpHelper {

    void doJump();

    void setJumping();

}
