package com.example.drinkcraft.items;

import java.util.Collection;

import com.example.drinkcraft.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class AmplifierItem extends ItemFood {
	private Collection<PotionEffect>playerPotionEffects;
	public AmplifierItem(int heal, float saturation, boolean wolfMeat){
		super(heal, saturation, wolfMeat);
		this.setUnlocalizedName(Reference.MODID+"_"+Reference.AMPLIFIER);
		this.setTextureName(Reference.MODID+":"+Reference.AMPLIFIER);
		this.setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if(!world.isRemote){
			if(itemStack.getItem()==this){
				playerPotionEffects = entityPlayer.getActivePotionEffects();
				if (!playerPotionEffects.isEmpty()){
					Object[] o = playerPotionEffects.toArray();
					for (int i=0; i<o.length;i++) {
						PotionEffect e = (PotionEffect) o[i];
						entityPlayer.removePotionEffect(e.getPotionID());
						entityPlayer.addPotionEffect(new PotionEffect(e.getPotionID(), e.getDuration()*2, e.getAmplifier()));
					}
				}
			}
		}
	}
}