package com.zer0.hardcore.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.zer0.hardcore.gui.GrindingMachineGUI;
import com.zer0.hardcore.inventory.ContainerGrindingMachine;
import com.zer0.hardcore.tile_entities.TileEntityGrindingMachine;

import cpw.mods.fml.common.network.IGuiHandler;

public class MCHardcoreGuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == 0)
		{
			TileEntityGrindingMachine tileEntityGM = (TileEntityGrindingMachine)world.getTileEntity(x, y, z);
			return new ContainerGrindingMachine(player.inventory, tileEntityGM);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == 0)
		{
			TileEntityGrindingMachine tileEntityGM = (TileEntityGrindingMachine)world.getTileEntity(x, y, z);
			return new GrindingMachineGUI(player.inventory, tileEntityGM);
		}
		return null;
	}

}
