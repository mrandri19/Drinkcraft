package com.example.drinkcraft;

import net.minecraftforge.common.MinecraftForge;

import com.example.drinkcraft.init.ModBlocks;
import com.example.drinkcraft.init.ModItems;
import com.example.drinkcraft.init.ModTileentities;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
	public static final String MODID = "drinkcraft";
	public static final String VERSION = "1.0";

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModBlocks.init();
		ModTileentities.init();
		System.out.println("\ndaw");
	}

	@Mod.EventHandler
	public void Init(FMLInitializationEvent event) {

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new com.example.drinkcraft.eventHandler.DrinkcraftEventHandler());
	}
}
