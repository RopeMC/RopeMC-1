package de.ropemc.api.wrapper.net.minecraft.command.server;

import de.ropemc.api.wrapper.net.minecraft.command.ICommandSender;
import de.ropemc.api.wrapper.net.minecraft.util.BlockPos;
import java.util.List;
import de.ropemc.api.wrapper.WrappedClass;

@WrappedClass("net.minecraft.command.server.CommandBanIp")
public interface CommandBanIp {

    List addTabCompletionOptions(ICommandSender var0, String[] var1, BlockPos var2);

    boolean canCommandSenderUseCommand(ICommandSender var0);

    void func_147210_a(ICommandSender var0, String var1, String var2);

    String getCommandName();

    String getCommandUsage(ICommandSender var0);

    int getRequiredPermissionLevel();

    void processCommand(ICommandSender var0, String[] var1);

}
