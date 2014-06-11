package com.zer0.hardcore;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.zer0.hardcore.handlers.MCHardcoreGuiHandler;
import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.tile_entities.TileEntityBronzeFurnace;
import com.zer0.hardcore.tile_entities.TileEntityBronzeGM;
import com.zer0.hardcore.tile_entities.TileEntityGrindingMachine;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy implements IGuiHandler{
	
	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
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
		GameRegistry.registerTileEntity(TileEntityGrindingMachine.class, Reference.MODID+"grindingMachine");
		GameRegistry.registerTileEntity(TileEntityBronzeGM.class, Reference.MODID+"bronzegm");
		
		GameRegistry.registerTileEntity(TileEntityBronzeFurnace.class, Reference.MODID+"bronzeFurnace");
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		return null;
	}
	
	public static void storeEntityData(String name, NBTTagCompound compound)
	{
		extendedEntityData.put(name,  compound);
	}
	
	public static NBTTagCompound getEntityData(String name)
	{
		return extendedEntityData.remove(name);
	}

}
