package com.example.drinkcraft.items;

import java.util.Collection;

import com.example.drinkcraft.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class HotCoffee extends ItemFood{
	private int potionLevel = -1;//Parte da -1 perche lo alzera gia da subito di 1. (riga 45)
	private int duration = Reference.HOTCOFFEE_DURATION;//4 Minuti
	private Collection<PotionEffect> playerPotionEffects;
	
	public HotCoffee(int heal, float saturation, boolean wolfmeat){
		super(heal, saturation, wolfmeat);
		this.setUnlocalizedName(Reference.MODID+"_"+Reference.HOTCOFFEE);
		this.setTextureName(Reference.MODID+":"+Reference.HOTCOFFEE);
		this.setCreativeTab(CreativeTabs.tabFood);
	}
	
	@Override
	protected void onFoodEaten(ItemStack itemStack, World world,
			EntityPlayer entityPlayer) {
		if (!world.isRemote) {
			if(itemStack.getItem() == this) {
				playerPotionEffects = entityPlayer.getActivePotionEffects();//Ritorna una collezione con tutti gli effetti che sono sul player
				if (!playerPotionEffects.isEmpty()) {//Se non e' vuota
					Object[] o = playerPotionEffects.toArray();//Mette la collezione in un array di oggetti
					for (int i=0; i<o.length;i++) {//Per ogni oggetto
						PotionEffect e = (PotionEffect) o[i];//Lo casta in un potion effect (cio che e)
						if (e.getPotionID()==Reference.HOTCOFFEE_POTION_EFFECT ){//Se e speed
							potionLevel =e.getAmplifier();//Ottiene di quanto e amplificato
							duration = e.getDuration();//Ottiene la durata
						}
					}
				}
				
				if (potionLevel >= Reference.HOTCOFFEE_MAX_LEVEL) {//Se e' maggiore del valore massimo
					potionLevel = -1;//Ripristina i valori di default
					duration = Reference.HOTCOFFEE_DURATION;
					entityPlayer.removePotionEffect(Reference.HOTCOFFEE_POTION_EFFECT);//E leva l' effetto precendente
				}
				entityPlayer.addPotionEffect(new PotionEffect(Reference.HOTCOFFEE_POTION_EFFECT, duration/Reference.HOTCOFFEE_DURATION_FACTOR, potionLevel+1));//Da` al player un effetto. PotionEffect(effect, duration, level).
			}
		}
	}
}
//TODO rendere il tutto una classe (la roba della pozione, insomma tutto il metodo onfoodeaten)
