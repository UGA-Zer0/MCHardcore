package com.zer0.hardcore.entities;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class SpawnHandler {
	
	public static void registerMobSpawns()
	{
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.plains);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.desert);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.extremeHills);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.extremeHillsEdge);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.forest);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.taiga);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.desertHills);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.forestHills);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.birchForest);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.birchForestHills);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.roofedForest);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.coldTaiga);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.coldTaigaHills);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.extremeHillsPlus);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.savanna);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.savannaPlateau);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.mesa);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.mesaPlateau);
		EntityRegistry.addSpawn(ObsidianKnight.class, 100, 4, 4, EnumCreatureType.monster, BiomeGenBase.mesaPlateau_F);
	}

}
