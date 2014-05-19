package com.zer0.hardcore.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.zer0.hardcore.tile_entities.TileEntityGrindingMachine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerGrindingMachine extends Container {
	
	private TileEntityGrindingMachine tileGM;
	private int lastCookTime;
	private int lastItemBurnTime;
	private int lastBurnTime;
	
	public ContainerGrindingMachine(InventoryPlayer player, TileEntityGrindingMachine tileEntityGM)
	{
		this.tileGM = tileEntityGM;
		this.addSlotToContainer(new Slot(tileEntityGM, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileEntityGM, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(player.player, tileEntityGM, 2, 116, 35));
		int i;
		
		for(i = 0; i < 3; ++i)
		{
			for(int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(player, j+i*9+9, 8+j*18, 84+i*18));
			}
		}
		for(i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(player, i, 8+i*18, 142));
		}
	}
	
	public void addCraftingToCrafters(ICrafting craft)
	{
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 0, this.tileGM.cookTime);
		craft.sendProgressBarUpdate(this, 1, this.tileGM.furnaceBurnTime);
		craft.sendProgressBarUpdate(this, 2, this.tileGM.currentBurnTime);
	}
	
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting craft = (ICrafting)this.crafters.get(i);
			if(this.lastCookTime != this.tileGM.cookTime)
			{
				craft.sendProgressBarUpdate(this, 0, this.tileGM.cookTime);
			}
			if(this.lastCookTime != this.tileGM.furnaceBurnTime)
			{
				craft.sendProgressBarUpdate(this, 1, this.tileGM.furnaceBurnTime);
			}
			if(this.lastCookTime != this.tileGM.currentBurnTime)
			{
				craft.sendProgressBarUpdate(this, 2, this.tileGM.currentBurnTime);
			}
		}
		
		this.lastBurnTime = this.tileGM.furnaceBurnTime;
		this.lastCookTime = this.tileGM.cookTime;
		this.lastItemBurnTime = this.tileGM.currentBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int var1, int var2)
	{
		if(var1 == 0)
		{
			this.tileGM.cookTime = var2;
		}
		if(var1 == 1)
		{
			this.tileGM.furnaceBurnTime = var2;
		}
		if(var1 == 2)
		{
			this.tileGM.currentBurnTime = var2;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileGM.isUseableByPlayer(player);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if(par2 == 2){
				if(!this.mergeItemStack(itemstack1, 3, 39, true)){
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}else if(par2 != 1 && par2 != 0){
				if(FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null){
					if(!this.mergeItemStack(itemstack1, 0, 1, false)){
						return null;
					}
				}else if(TileEntityGrindingMachine.isItemFuel(itemstack1)){
					if(!this.mergeItemStack(itemstack1, 1, 2, false)){
						return null;
					}
				}else if(par2 >=3 && par2 < 30){
					if(!this.mergeItemStack(itemstack1, 30, 39, false)){
						return null;
					}
				}else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
					return null;
				}
			}else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
				return null;
			}
			if(itemstack1.stackSize == 0){
				slot.putStack((ItemStack)null);
			}else{
				slot.onSlotChanged();
			}
			if(itemstack1.stackSize == itemstack.stackSize){
				return null;
			}
			slot.onPickupFromSlot(player, itemstack1);
		}
		return itemstack;
	}

}
