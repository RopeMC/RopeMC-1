package de.ropemc.api.wrapper.net.minecraft.scoreboard;

import java.util.List;
import de.ropemc.api.wrapper.WrappedClass;

@WrappedClass("net.minecraft.scoreboard.ScoreDummyCriteria")
public interface ScoreDummyCriteria {

    int func_96635_a(List var0);

    String getName();

    //IScoreObjectiveCriteria$EnumRenderType getRenderType();

    boolean isReadOnly();

}
