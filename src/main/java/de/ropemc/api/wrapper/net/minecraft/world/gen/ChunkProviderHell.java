package de.ropemc.api.wrapper.net.minecraft.world.gen;

import de.ropemc.api.wrapper.net.minecraft.world.chunk.IChunkProvider;
import de.ropemc.api.wrapper.net.minecraft.world.chunk.Chunk;
import de.ropemc.api.wrapper.net.minecraft.world.chunk.ChunkPrimer;
import de.ropemc.api.wrapper.net.minecraft.entity.EnumCreatureType;
import de.ropemc.api.wrapper.net.minecraft.util.BlockPos;
import java.util.List;
import de.ropemc.api.wrapper.net.minecraft.world.World;
import de.ropemc.api.wrapper.net.minecraft.util.IProgressUpdate;
import de.ropemc.api.wrapper.WrappedClass;

@WrappedClass("net.minecraft.world.gen.ChunkProviderHell")
public interface ChunkProviderHell {

    boolean canSave();

    boolean chunkExists(int var0, int var1);

    boolean func_177460_a(IChunkProvider var0, Chunk var1, int var2, int var3);

    void func_180515_a(int var0, int var1, ChunkPrimer var2);

    void func_180516_b(int var0, int var1, ChunkPrimer var2);

    int getLoadedChunkCount();

    List getPossibleCreatures(EnumCreatureType var0, BlockPos var1);

    BlockPos getStrongholdGen(World var0, String var1, BlockPos var2);

    double[] initializeNoiseField(double[] var0, int var1, int var2, int var3, int var4, int var5, int var6);

    String makeString();

    void populate(IChunkProvider var0, int var1, int var2);

    Chunk provideChunk(int var0, int var1);

    Chunk provideChunk(BlockPos var0);

    void recreateStructures(Chunk var0, int var1, int var2);

    boolean saveChunks(boolean var0, IProgressUpdate var1);

    void saveExtraData();

    boolean unloadQueuedChunks();

}
