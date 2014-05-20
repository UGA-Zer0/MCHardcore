package com.zer0.hardcore.rendering;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.zer0.hardcore.help.Reference;

public class ObsidianKnightRenderer extends RenderBiped {
	
	private static final ResourceLocation texLoc = new ResourceLocation(Reference.MODID + ":" + "textures/models/obsidianKnight.png");
	
	public ObsidianKnightRenderer(ModelBiped model, float shadowSize)
	{
		super(model, shadowSize);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texLoc;
	}

}
