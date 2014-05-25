package com.zer0.hardcore.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.zer0.hardcore.gui.BronzeFurnaceGUI;
import com.zer0.hardcore.gui.BronzeGrindingMachineGUI;
import com.zer0.hardcore.gui.GrindingMachineGUI;
import com.zer0.hardcore.inventory.ContainerBronzeFurnace;
import com.zer0.hardcore.inventory.ContainerBronzeGM;
import com.zer0.hardcore.inventory.ContainerGrindingMachine;
import com.zer0.hardcore.tile_entities.TileEntityBronzeFurnace;
import com.zer0.hardcore.tile_entities.TileEntityBronzeGM;
import com.zer0.hardcore.tile_entities.TileEntityGrindingMachine;

import cpw.mods.fml.common.network.IGuiHandler;

public class MCHardcoreGuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && te instanceof TileEntityGrindingMachine)
		{
			TileEntityGrindingMachine tileEntityGM = (TileEntityGrindingMachine)te;
			return new ContainerGrindingMachine(player.inventory, tileEntityGM);
		}
		else if(te != null && te instanceof TileEntityBronzeGM)
		{
			TileEntityBronzeGM teBronzeGM = (TileEntityBronzeGM)te;
			return new ContainerBronzeGM(player.inventory, teBronzeGM);
		}
		else if(te != null && te instanceof TileEntityBronzeFurnace)
		{
			TileEntityBronzeFurnace tileEntityBF = (TileEntityBronzeFurnace)te;
			return new ContainerBronzeFurnace(player.inventory, tileEntityBF);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && te instanceof TileEntityGrindingMachine)
		{
			TileEntityGrindingMachine tileEntityGM = (TileEntityGrindingMachine)te;
			return new GrindingMachineGUI(player.inventory, tileEntityGM);
		}
		else if(te != null && te instanceof TileEntityBronzeGM)
		{
			TileEntityBronzeGM teBronzeGM = (TileEntityBronzeGM)te;
			return new BronzeGrindingMachineGUI(player.inventory, teBronzeGM);
		}
		else if(te != null && te instanceof TileEntityBronzeFurnace)
		{
			TileEntityBronzeFurnace tileEntityBF = (TileEntityBronzeFurnace)te;
			return new BronzeFurnaceGUI(player.inventory, tileEntityBF);
		}
		return null;
	}

}
