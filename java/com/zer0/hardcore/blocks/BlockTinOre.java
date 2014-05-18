package com.zer0.hardcore.blocks;

import java.util.Random;

import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockTinOre extends Block {

	public BlockTinOre() {
		super(Material.rock);
		setBlockName("tinOre");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
	}
	
	
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		return ModItems.tinNugget;
	}
	
	public int quantityDropped(Random rand)
	{
		return 3;
	}
}
