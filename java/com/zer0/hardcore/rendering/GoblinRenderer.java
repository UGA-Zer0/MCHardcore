package com.zer0.hardcore.rendering;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.models.ModelGoblinModel;

public class GoblinRenderer extends RenderLiving {
	
	private static final ResourceLocation texLoc = new ResourceLocation(Reference.MODID + ":" + "textures/models/goblin.png");
	
	public GoblinRenderer(ModelGoblinModel model, float shadowSize)
	{
		super(model, shadowSize);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texLoc;
	}

}
