package com.zer0.hardcore.worldgen;

import java.util.Random;

import com.zer0.hardcore.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class HCWorldGenOre implements IWorldGenerator {

	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch (world.provider.dimensionId)
		{
		case -1:
			generateNether(random, chunkX * 16, chunkZ * 16, world);
			break;
		case 0:
			generateSurface(random, chunkX * 16, chunkZ * 16, world);
			break;
		case 1:
			generateEnd(random, chunkX * 16, chunkZ * 16, world);
			break;
		default:
			;
		}
	}
	
	private void addOre(Block block, Block blockSpawn, Random random, World world, int posX, int posZ, int minY, 
			int maxY, int minVeinSize, int maxVeinSize, int spawnChance)
	{
		for(int i = 0; i < spawnChance; i++)
		{
			int defaultChunkSize = 16;
			
			int xPos = posX + random.nextInt(defaultChunkSize);
			int yPos = minY + random.nextInt(maxY - minY);
			int zPos = posZ + random.nextInt(defaultChunkSize);
			
			new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), blockSpawn)
				.generate(world, random, xPos, yPos, zPos);
		}
	}
	
	private void generateEnd(Random random, int chunkX, int chunkZ, World world)
	{
		//END GENERATION - NONE YET
	}
	
	private void generateSurface(Random random, int chunkX, int chunkZ, World world)
	{
		addOre(ModBlocks.copperOre, Blocks.stone, random, world, chunkX, chunkZ, 20, 60, 4, 11, 32);
		addOre(ModBlocks.tinOre, Blocks.stone, random, world, chunkX, chunkZ, 20, 60, 4, 9, 24);
	}
	
	private void generateNether(Random random, int chunkX, int chunkZ, World world)
	{
		//NETHER GENERATION - NONE YET
	}

}
