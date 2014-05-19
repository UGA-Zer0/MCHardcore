package com.zer0.hardcore;

import com.zer0.hardcore.handlers.MCHardcoreGuiHandler;
import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.tile_entities.TileEntityGrindingMachine;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {
	
	public void registerRenderer()
	{
		
	}
	
	public void registerNetwork()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(MCHardcore.modInstance, new MCHardcoreGuiHandler());
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
