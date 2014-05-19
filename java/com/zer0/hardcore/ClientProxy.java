package com.zer0.hardcore;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	
	public void registerRenderer()
	{
		
	}
	
	public int addArmour(String armour)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armour);
	}

}
