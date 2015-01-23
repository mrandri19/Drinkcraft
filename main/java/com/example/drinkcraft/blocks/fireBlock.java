package com.example.drinkcraft.blocks;

import java.util.Random;

import com.example.drinkcraft.help.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class fireBlock extends Block{

	public fireBlock() {
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName(Reference.MODID+"_"+Reference.FIREBLOCK);
		this.setBlockTextureName(Reference.MODID + ":" + Reference.FIREBLOCK);
		this.setHardness(Reference.FIREBLOCK_HARDNESS);
	}
	 public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)//Quando viene droppato(rotto)
	    {
	        return Item.getItemFromBlock(this);//Ritorna (che blocco viene droppato quando e' rotto) se stesso. Insomma, quando viene rotto si droppa.
	    }
@Override
public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		if ( world.getBlockPowerInput(x, y, z)<1){//Se non gli arriva un impulso di redstone maggiore di 1(il minimo). Insomma, da spento
			entity.setFire(26000);//Manda a fuoco il tipo sopra di lui
			for(int particlecount =0; particlecount<10; particlecount++){
				world.spawnParticle("reddust", x+(particlecount/5), y+2, z+(particlecount/5), 0, 2.0, 0);
				}
		}
	}
}

