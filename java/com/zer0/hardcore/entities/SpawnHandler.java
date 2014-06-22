package com.zer0.hardcore.entities;

import java.lang.reflect.Array;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class SpawnHandler {
	
	public static void registerMobSpawns()
	{
		BiomeGenBase[] obsidianKnightSpawns = new BiomeGenBase[]{BiomeGenBase.hell};
		
		BiomeGenBase[] goblinSpawns = new BiomeGenBase[]{BiomeGenBase.swampland, 
														 BiomeGenBase.roofedForest};
		
		BiomeGenBase[] orcSpawns = new BiomeGenBase[]{BiomeGenBase.swampland, 
													  BiomeGenBase.roofedForest};
		
		//BiomeGenBase[] villagerSoldierSpawns = new BiomeGenBase[]{BiomeGenBase.plains, 
		//														  BiomeGenBase.desert, 
		//														  BiomeGenBase.desertHills,
		//														  BiomeGenBase.extremeHills,
		//														  BiomeGenBase.extremeHillsEdge,
		//														  BiomeGenBase.extremeHillsPlus,
		//														  BiomeGenBase.forest};
		
		EntityRegistry.addSpawn(ObsidianKnight.class, 30, 1, 2, EnumCreatureType.monster, obsidianKnightSpawns);
		EntityRegistry.addSpawn(Goblin.class, 30, 10, 14, EnumCreatureType.monster, goblinSpawns);
		EntityRegistry.addSpawn(EntityOrc.class, 5, 1, 1, EnumCreatureType.monster, orcSpawns);
		//EntityRegistry.addSpawn(VillagerSoldier.class, 100, 1, 2, EnumCreatureType.ambient, villagerSoldierSpawns);
	}

}
