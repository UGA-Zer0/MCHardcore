package com.zer0.hardcore.rendering;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.models.OrcModel;

public class OrcRenderer extends RenderLiving {
	
	private static final ResourceLocation texLoc = new ResourceLocation(Reference.MODID + ":" + "textures/models/orc.png");
	
	public OrcRenderer(OrcModel model, float shadowSize)
	{
		super(model, shadowSize);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texLoc;
	}

}
