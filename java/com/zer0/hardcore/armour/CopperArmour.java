package com.zer0.hardcore.armour;

import com.zer0.hardcore.help.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class CopperArmour extends ItemArmor {

	public CopperArmour(ArmorMaterial material, int var1, int var2) {
		super(material, var1, var2);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == ModArmour.copperHelm || stack.getItem() == ModArmour.copperChestplate 
				|| stack.getItem() == ModArmour.copperBoots)
		{
			return Reference.MODID + ":textures/armour/copperArmour1.png";
		}
		else if(stack.getItem() == ModArmour.copperLegs)
		{
			return Reference.MODID + ":textures/armour/copperArmour2.png";
		}
		else
		{
			return null;
		}
	}
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		if (player.getCurrentArmor(3) != null &&
			player.getCurrentArmor(2) != null &&
			player.getCurrentArmor(1) != null &&
			player.getCurrentArmor(0) != null)
		{
			ItemStack helm = player.getCurrentArmor(3);
			ItemStack chestplate = player.getCurrentArmor(2);
			ItemStack legs = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			
			if (helm.getItem() == ModArmour.copperHelm &&
				chestplate.getItem() == ModArmour.copperChestplate &&
				legs.getItem() == ModArmour.copperLegs &&
				boots.getItem() == ModArmour.copperBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 20, 1));
			}
		}
	}

}
