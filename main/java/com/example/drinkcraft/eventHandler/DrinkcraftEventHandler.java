package com.example.drinkcraft.eventHandler;

import com.example.drinkcraft.help.Reference;
import com.example.drinkcraft.items.MagnesiumSword;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class DrinkcraftEventHandler {
private void magnesiumSwordHandler(LivingFallEvent event){
		if (event.entity instanceof EntityPlayer) {//Se l'entita `e un player
			EntityPlayer player = (EntityPlayer) event.entity;
			ItemStack heldItem = player.getHeldItem();
			if (heldItem != null) {		
				Item item = heldItem.getItem();		
				if (item.getUnlocalizedName().equals("item."+Reference.MODID+"_"+Reference.MAGNESIUMSWORD)){//Se cio che ha in mano `e la magnesiumsword
					event.setCanceled(true);//Cancella l' envento, e` come se il player non fosse caduto
				}
			}
		}
	}
	
	//@SubscribeEvent
	//public void 
	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event) {//Ogni volta che un player cade viene chiamato questo evento
		magnesiumSwordHandler(event);//E quindi eseguita questa funzione
	}

}