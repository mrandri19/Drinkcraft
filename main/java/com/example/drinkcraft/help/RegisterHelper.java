package com.example.drinkcraft.help;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

public class RegisterHelper {
	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, Reference.MODID
				+ block.getUnlocalizedName().substring(5));
	}

	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, Reference.MODID
				+ item.getUnlocalizedName().substring(5));
	}
	public static void registerTileentity(Class<? extends TileEntity> tileEntityClass, String id){
		GameRegistry.registerTileEntity(tileEntityClass, id);
	}
}
