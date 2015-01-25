package com.example.drinkcraft.init;

import com.example.drinkcraft.help.RegisterHelper;

public class ModTileentities {
	public static void init(){
		
		RegisterHelper.registerTileentity(com.example.drinkcraft.tileEntities.FurnaceBlockTileEntity.class, "dawTileEntity");
		
	}
}
