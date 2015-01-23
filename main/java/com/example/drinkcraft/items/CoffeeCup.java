package com.example.drinkcraft.items;

import com.example.drinkcraft.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CoffeeCup extends Item {
	public CoffeeCup() {
		super();
		this.setUnlocalizedName(Reference.MODID + "_" + Reference.COFFEECUP); // Unlocalized
																				// name
																				// modid_name
		this.setTextureName(Reference.MODID + ":" + Reference.COFFEECUP); // Texture
																			// name
																			// modidi:texture
		this.setCreativeTab(CreativeTabs.tabFood);
	}
}
