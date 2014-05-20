package com.zer0.hardcore;

import net.minecraft.client.model.ModelBiped;

import com.zer0.hardcore.entities.ObsidianKnight;
import com.zer0.hardcore.rendering.ObsidianKnightRenderer;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	
	public void registerRenderer()
	{
		RenderingRegistry.registerEntityRenderingHandler(ObsidianKnight.class, new ObsidianKnightRenderer(new ModelBiped(), 0.5F));
	}
	
	public int addArmour(String armour)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armour);
	}

}
