/*package com.zer0.hardcore.armour;

import com.zer0.hardcore.help.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ThiefArmour extends ItemArmor {

	public ThiefArmour(ArmorMaterial material, int par1, int par2) {
		super(material, par1, par2);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == ModArmour.thiefHelm || stack.getItem() == ModArmour.thiefChest 
				|| stack.getItem() == ModArmour.thiefBoots)
		{
			return Reference.MODID + ":textures/armour/thiefArmour1.png";
		}
		else if(stack.getItem() == ModArmour.thiefLegs)
		{
			return Reference.MODID + ":textures/armour/thiefArmour2.png";
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
			
			if (helm.getItem() == ModArmour.thiefHelm &&
				chestplate.getItem() == ModArmour.thiefChest &&
				legs.getItem() == ModArmour.thiefLegs &&
				boots.getItem() == ModArmour.thiefBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 100, 1));
				player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 100, 1));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 100, 1));
				player.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 100, 4));
				
			}
		}
	}

}*/
