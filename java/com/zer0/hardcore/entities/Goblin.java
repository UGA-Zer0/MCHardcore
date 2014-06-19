package com.zer0.hardcore.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.zer0.hardcore.armour.ModArmour;
import com.zer0.hardcore.items.ModItems;
import com.zer0.hardcore.tools.ModTools;

public class Goblin extends EntityMob {

	public Goblin(World world) {
		super(world);
		this.setSize(0.6F, 1.5F);
		
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityOrc.class, 6.0F, 1.0D, 1.2D));
		this.tasks.addTask(2, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 20.0F));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));

		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		
		this.isImmuneToFire = true;
		this.experienceValue = 78;
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.28D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.5D);
	}
	
	public boolean isAIEnabled()
	{
		return true;
	}
	
	public boolean isValidLightLevel()
	{
		return true;
	}
	
	public boolean getCanSpawnHere()
	{
		return true;
	}
	
	protected Item getDropItem()
	{
		return ModItems.goldCoin;
	}
	
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

    protected String getHurtSound()
    {
        return "game.player.hurt";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.zombie.step", 0.15F, 1.0F);
    }
    
    protected String getSwimSound()
    {
        return "game.player.swim";
    }

    protected String getSplashSound()
    {
        return "game.player.swim.splash";
    }
    
    protected String getDeathSound()
    {
        return "game.hostile.die";
    }

    protected String func_146067_o(int p_146067_1_)
    {
        return p_146067_1_ > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small";
    }

}
