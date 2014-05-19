package com.zer0.hardcore;

import com.zer0.hardcore.tile_entities.TileEntityGrindingMachine;
import com.zer0.hardcore.help.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {
	
	public void registerRenderer()
	{
		
	}
	
	public int addArmour(String armour)
	{
		return 0;
	}
	
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityGrindingMachine.class, Reference.MODID);
	}

}
