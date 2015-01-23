package com.example.drinkcraft.init;

import net.minecraft.block.Block;

import com.example.drinkcraft.blocks.fireBlock;
import com.example.drinkcraft.help.RegisterHelper;

public class ModBlocks {
	public static void init() {
		Block fireBlock = new fireBlock();
		RegisterHelper.registerBlock(fireBlock);
	}
}
