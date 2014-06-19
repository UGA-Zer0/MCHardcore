package com.zer0.hardcore.models;

import org.lwjgl.opengl.GL11;

import com.zer0.hardcore.entities.Goblin;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGoblinModel extends ModelBase
{
	
	
    ModelRenderer Head;
    ModelRenderer RightEar;
    ModelRenderer LeftEar;
    ModelRenderer Nose;
    ModelRenderer NosePart2;
    
    ModelRenderer UpperArm2;
    ModelRenderer UpperArm1;
    ModelRenderer LowerArm2;
    ModelRenderer LowerArm1;
    
    ModelRenderer UpperBody;
    ModelRenderer LowerBody;
    
    ModelRenderer Leg2;
    ModelRenderer Leg1;
    ModelRenderer UpperLeg1;
    ModelRenderer UpperLeg2;
    
    ModelRenderer hilt;
    ModelRenderer CrossGuard;
    ModelRenderer CrossGuardLeft;
    ModelRenderer CrossGuardRight;
    ModelRenderer Blade;
    ModelRenderer BladePart3;
    ModelRenderer BladePart2;
  
  public ModelGoblinModel()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Head = new ModelRenderer(this, 42, 0);
      Head.addBox(-3F, -5F, -2.5F, 6, 5, 5);
      Head.setRotationPoint(0F, 5F, 0F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      
      UpperBody = new ModelRenderer(this, 46, 10);
      UpperBody.addBox(-3F, -5F, -1F, 6, 5, 3);
      UpperBody.setRotationPoint(0F, 10F, 0F);
      UpperBody.setTextureSize(64, 32);
      UpperBody.mirror = true;
      setRotation(UpperBody, 0F, 0F, 0F);
      
      LowerBody = new ModelRenderer(this, 48, 18);
      LowerBody.addBox(-2.5F, -2F, -1F, 5, 5, 3);
      LowerBody.setRotationPoint(0F, 12F, 0F);
      LowerBody.setTextureSize(64, 32);
      LowerBody.mirror = true;
      setRotation(LowerBody, 0F, 0F, 0F);
      
      UpperArm2 = new ModelRenderer(this, 28, 24);
      UpperArm2.addBox(-1F, 0F, -1.5F, 2, 5, 3);
      UpperArm2.setRotationPoint(3F, 5F, 0.5F);
      UpperArm2.setTextureSize(64, 32);
      UpperArm2.mirror = true;
      setRotation(UpperArm2, 0.2F, -0.1F, -0.3665191F);
      
      UpperArm1 = new ModelRenderer(this, 38, 24);
      UpperArm1.addBox(-1F, 0F, -1.5F, 2, 5, 3);
      UpperArm1.setRotationPoint(-3F, 5F, 0.5F);
      UpperArm1.setTextureSize(64, 32);
      UpperArm1.mirror = true;
      setRotation(UpperArm1, 0.4014257F, 0.1483529F, 03665191F);
      
      UpperLeg1 = new ModelRenderer(this, 26, 0);
      UpperLeg1.addBox(-1F, 0F, -1F, 2, 4, 2);
      UpperLeg1.setRotationPoint(-1.5F, 15F, 0.5F);
      UpperLeg1.setTextureSize(64, 32);
      UpperLeg1.mirror = true;
      setRotation(UpperLeg1, 0.52F, 0F, 0F);
      
      
      UpperLeg2 = new ModelRenderer(this, 34, 0);
      UpperLeg2.addBox(-1F, 0F, -1F, 2, 4, 2);
      UpperLeg2.setRotationPoint(1.5F, 15F, 0.5F);
      UpperLeg2.setTextureSize(64, 32);
      UpperLeg2.mirror = true;
      setRotation(UpperLeg2, 0.52F, 0F, 0F);
      
      LowerArm2 = new ModelRenderer(this, 26, 6);
      LowerArm2.addBox(-1F, 0F, -1F, 2, 6, 2);
      LowerArm2.setRotationPoint(0F, 5F, 0F);
      LowerArm2.setTextureSize(64, 32);
      LowerArm2.mirror = true;
      setRotation(LowerArm2, -0.5853981F, 0F, 0F);
      
      LowerArm1 = new ModelRenderer(this, 34, 6);
      LowerArm1.addBox(-1F, 0F, -1F, 2, 6, 2);
      LowerArm1.setRotationPoint(0F, 5F, 0F);
      LowerArm1.setTextureSize(64, 32);
      LowerArm1.mirror = true;
      setRotation(LowerArm1, -0.5853981F, 0F, 0F);
      
      Leg1 = new ModelRenderer(this, 30, 14);
      Leg1.addBox(-1F, 0F, -1F, 2, 6, 2);
      Leg1.setRotationPoint(0F, 3F, 0F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0.2F, 0F, 0F);
      
      Leg2 = new ModelRenderer(this, 38, 14);
      Leg2.addBox(-1F, 0F, -1F, 2, 6, 2);
      Leg2.setRotationPoint(0F, 3F, 0F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0.2F, 0F, 0F);
      
      Nose = new ModelRenderer(this, 50, 26);
      Nose.addBox(-0.5F, -0.5F, -1F, 1, 1, 1);
      Nose.setRotationPoint(0F, -2F, -2F);
      Nose.setTextureSize(64, 32);
      Nose.mirror = true;
      setRotation(Nose, 0.1745329F, 0F, 0F);
      
      NosePart2 = new ModelRenderer(this, 50, 29);
      NosePart2.addBox(-0.5F, -0.5F, -1F, 1, 2, 1);
      NosePart2.setRotationPoint(0F, -1.3F, -2.5F);
      NosePart2.setTextureSize(64, 32);
      NosePart2.mirror = true;
      setRotation(NosePart2, -0.5948578F, 0F, 0F);
      
      RightEar = new ModelRenderer(this, 54, 29);
      RightEar.addBox(-4F, -1F, -0.5F, 4, 2, 1);
      RightEar.setRotationPoint(-2.5F, -3F, 0F);
      RightEar.setTextureSize(64, 32);RightEar.mirror = true;
      setRotation(RightEar, 0.3490659F, 0.7853982F, 0.3490659F);
      
      LeftEar = new ModelRenderer(this, 54, 26);
      LeftEar.addBox(0F, -1F, -0.5F, 4, 2, 1);
      LeftEar.setRotationPoint(2.5F, -3F, 0F);
      LeftEar.setTextureSize(64, 32);LeftEar.mirror = true;
      setRotation(LeftEar, 0.3490659F, -0.7853982F, -0.3490659F); 
      
      hilt = new ModelRenderer(this, 0, 28);
      hilt.addBox(0F, 0F, 0F, 1, 1, 3);
      hilt.setRotationPoint(-1F, 4F, -1.5F);
      hilt.setTextureSize(64, 32);
      hilt.mirror = true;
      setRotation(hilt, 0F, 0F, 0F);
      
      CrossGuard = new ModelRenderer(this, 0, 0);
      CrossGuard.addBox(0F, 0F, 0F, 1, 3, 1);
      CrossGuard.setRotationPoint(-1F, 3F, -2.5F);
      CrossGuard.setTextureSize(64, 32);
      setRotation(CrossGuard, 0F, 0F, 0F);
      
      CrossGuardLeft = new ModelRenderer(this, 8, 26);
      CrossGuardLeft.addBox(0F, 0F, 0F, 1, 2, 1);
      CrossGuardLeft.setRotationPoint(-1F, 5.4F, -2.2F);
      CrossGuardLeft.setTextureSize(64, 32);
      setRotation(CrossGuardLeft, -0.5948578F, 0F, 0F);
      
      Blade = new ModelRenderer(this, 0, 11);
      Blade.addBox(0F, 0F, 0F, 1, 3, 12);
      Blade.setRotationPoint(-1F, 3F, -14.5F);
      Blade.setTextureSize(64, 32);
      setRotation(Blade, 0F, 0F, 0F);
      
      CrossGuardRight = new ModelRenderer(this, 8, 29);
      CrossGuardRight.addBox(0F, 0F, 0F, 1, 2, 1);
      CrossGuardRight.setRotationPoint(-1F, 3.1F, -1.4F);
      CrossGuardRight.setTextureSize(64, 32);
      setRotation(CrossGuardRight, 3.735005F, 0F, 0F);
      
      BladePart3 = new ModelRenderer(this, 15, 4);
      BladePart3.addBox(0F, 0F, 0F, 1, 1, 1);
      BladePart3.setRotationPoint(-1F, 2F, -13.5F);
      BladePart3.setTextureSize(64, 32);
      setRotation(BladePart3, 0F, 0F, 0F);
      
      BladePart2 = new ModelRenderer(this, 4, 0);
      BladePart2.addBox(0F, 0F, 0F, 1, 2, 1);
      BladePart2.setRotationPoint(-1F, 1F, -14.5F);
      BladePart2.setTextureSize(64, 32);
      setRotation(BladePart2, 0F, 0F, 0F);
      
      Head.addChild(NosePart2);
      Head.addChild(Nose);
      Head.addChild(RightEar);
      Head.addChild(LeftEar);
      
      UpperLeg1.addChild(Leg1);
      UpperLeg2.addChild(Leg2);
      
      LowerArm1.addChild(hilt);
      
      UpperArm2.addChild(LowerArm2);
      UpperArm1.addChild(LowerArm1);

      LowerArm1.addChild(BladePart3);
      LowerArm1.addChild(BladePart2);

      LowerArm1.addChild(CrossGuardLeft);
      LowerArm1.addChild(CrossGuardRight);
      LowerArm1.addChild(Blade);
      
      LowerArm1.addChild(CrossGuard);
      
  }
  
  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Head.render(f5);
    UpperArm2.render(f5);
    UpperArm1.render(f5);
    LowerBody.render(f5);
    UpperLeg1.render(f5);
    UpperLeg2.render(f5);
    UpperBody.render(f5);
  }
  
  protected void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    this.Head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Head.rotateAngleX = f3 / (180F / (float)Math.PI);

    this.UpperArm1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.UpperArm2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.UpperArm1.rotateAngleZ = 0.27F;
    this.UpperArm2.rotateAngleZ = -0.11F;
    
    this.UpperLeg1.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.4F * f1)-0.22F;
    this.UpperLeg2.rotateAngleX = (MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1)-0.22F;
    this.UpperLeg1.rotateAngleY = 0.15F;
    this.UpperLeg2.rotateAngleY = -0.15F;
    
    this.UpperArm1.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    this.UpperArm2.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    this.UpperArm1.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    this.UpperArm2.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
  }

   
}
