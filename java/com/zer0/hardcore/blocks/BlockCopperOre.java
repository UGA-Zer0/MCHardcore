package com.zer0.hardcore.blocks;

import java.util.Random;

import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockCopperOre extends Block {
	
	public BlockCopperOre() 
	{
		super(Material.rock);
		setBlockName("copperOre");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
	}
	
	
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		return ModItems.copperNugget;
	}
	
	public int quantityDropped(Random rand)
	{
		return 3;
	}

}
