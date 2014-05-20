package com.zer0.hardcore.entities;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class SpawnHandler {
	
	public static void registerMobSpawns()
	{
		EntityRegistry.addSpawn(ObsidianKnight.class, 10, 3, 15, EnumCreatureType.monster, BiomeGenBase.desert);
	}

}
