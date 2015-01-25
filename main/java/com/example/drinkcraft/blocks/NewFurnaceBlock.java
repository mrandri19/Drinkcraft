package com.example.drinkcraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.example.drinkcraft.help.Reference;
import com.example.drinkcraft.tileEntities.FurnaceBlockTileEntity;

public class NewFurnaceBlock extends Block{

	public NewFurnaceBlock() {
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName(Reference.MODID+"_"+Reference.FURNACEBLOCK);
		this.setBlockTextureName(Reference.MODID + ":" + Reference.FURNACEBLOCK);
		this.setHardness(Reference.FURNACEBLOCK_HARDNESS);
	}
	@Override
	public boolean hasTileEntity(int metadata){//Ha una tile entiny 'in se'
		return true;//si
		}
	@Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new FurnaceBlockTileEntity();//Quando viene create la returna
    }
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }
}
