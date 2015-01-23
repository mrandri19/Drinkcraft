package com.example.drinkcraft.items;

import com.example.drinkcraft.help.Reference;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class MagnesiumSword extends ItemSword{

	public MagnesiumSword(ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.setUnlocalizedName(Reference.MODID+"_"+Reference.MAGNESIUMSWORD);
		this.setTextureName(Reference.MODID+":"+Reference.MAGNESIUMSWORD);
		this.setMaxStackSize(Reference.MAGNESIUMSWORD_MAXSTACKSIZE);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entity)//Quando viene premuto
    {
		entity.jump();
		int damage = itemStack.getItemDamage();//Ottiene il danno
		itemStack.setItemDamage(damage+1);//Lo setta danno+1
		entity.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));//Dice che e' in uso
        return itemStack;//Ritorna quell' istanza
    }
}
