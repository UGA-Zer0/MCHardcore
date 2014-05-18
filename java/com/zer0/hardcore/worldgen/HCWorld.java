package com.zer0.hardcore.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class HCWorld {
	
	public static void mainRegistry()
	{
		initialiseWorldGen();
	}
	public static void initialiseWorldGen()
	{
		registerWorldGen(new HCWorldGenOre(), 1);
	}

	public static void registerWorldGen(IWorldGenerator worldGenClass, int weightedProberblity){
		GameRegistry.registerWorldGenerator(worldGenClass, weightedProberblity);
	}

}
