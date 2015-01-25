package com.example.drinkcraft.init;

import net.minecraft.block.Block;

import com.example.drinkcraft.blocks.FireBlock;
import com.example.drinkcraft.blocks.NewFurnaceBlock;
import com.example.drinkcraft.help.RegisterHelper;

public class ModBlocks {
	public static void init() {
		Block fireBlock = new FireBlock();
		RegisterHelper.registerBlock(fireBlock);
		Block newFurnaceBlock = new NewFurnaceBlock();
		RegisterHelper.registerBlock(newFurnaceBlock);
	}
}
