package com.example.drinkcraft.init;


import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.example.drinkcraft.help.Reference;
import com.example.drinkcraft.help.RegisterHelper;
import com.example.drinkcraft.items.AmplifierItem;
import com.example.drinkcraft.items.CoffeeCup;
import com.example.drinkcraft.items.HotCoffee;
import com.example.drinkcraft.items.MagnesiumSword;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static void init() {
	
		Item coffeeCup = new CoffeeCup();
		RegisterHelper.registerItem(coffeeCup);
		//TODO add crafting recipe
		
		Item hotCoffee = new HotCoffee(Reference.HOTCOFFEE_HEAL,
		Reference.HOTCOFFEE_SATURATION, Reference.HOTCOFFEE_WOLFMEAT);
		RegisterHelper.registerItem(hotCoffee);
		GameRegistry.addSmelting(coffeeCup, new ItemStack(hotCoffee), 1f); // Registra la ricetta per la fonace passandogli l' item di input, un itemstack(istanza dell' item) e la xp.
	
		Item amplifierItem = new AmplifierItem(Reference.AMPLIFIER_HEAL, Reference.AMPLIFIER_SATURATION, Reference.AMPLIFIER_WOLFMEAT);
		RegisterHelper.registerItem(amplifierItem);
		//TODO add crafting recipe
		
		ToolMaterial magnesium = EnumHelper.addToolMaterial(Reference.TOOLMATERIAL, 2, Reference.TOOLMATERIAL_MAXUSES, Reference.TOOLMATERIAL_EFF,Reference.TOOLMATERIAL_DAMAGE, Reference.TOOLMATERIAL_ENCHANT);
		Item magnesiumSword = new MagnesiumSword(magnesium);
		RegisterHelper.registerItem(magnesiumSword);
		//TODO add crafting recipe
	}
}