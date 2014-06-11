package com.zer0.hardcore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.common.MinecraftForge;

import com.zer0.hardcore.entities.ObsidianKnight;
import com.zer0.hardcore.entities.VillagerSoldier;
import com.zer0.hardcore.gui.GuiLevelBar;
import com.zer0.hardcore.models.VillagerSoldierModel;
import com.zer0.hardcore.rendering.ObsidianKnightRenderer;
import com.zer0.hardcore.rendering.VillagerSoldierRenderer;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	
	public void registerRenderer()
	{
		RenderingRegistry.registerEntityRenderingHandler(ObsidianKnight.class, new ObsidianKnightRenderer(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(VillagerSoldier.class, new VillagerSoldierRenderer());
	}
	
	public int addArmour(String armour)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armour);
	}

}
