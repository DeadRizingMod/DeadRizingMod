package com.deadrising.mod.proxy;

import com.deadrising.mod.blocks.BlockBase;
import com.deadrising.mod.blocks.PropBase;
import com.deadrising.mod.blocks.props.CabnetBlock;
import com.deadrising.mod.blocks.props.CampfireBlock;
import com.deadrising.mod.blocks.props.ChairBlock;
import com.deadrising.mod.blocks.props.FloorProp;
import com.deadrising.mod.blocks.props.LightProp;
import com.deadrising.mod.blocks.props.PinicTableBlock;
import com.deadrising.mod.common.EnumParticles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void spawnParticle(EnumParticles particle, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {

    }
	public void registerItemRender(Item item, int meta, String id) {}
	
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {}
	public void OpenAirdropGUI(EntityPlayer player) {}

	public void registerBlockRender(LightProp lightprop, int i, String string) {
		// TODO Auto-generated method stub
		
	}
	public void registerBlockRender(BlockBase blockprop, int i, String string) {
		// TODO Auto-generated method stub
		
	}
	public void registerBlockRender(PropBase blockBase, int i, String string) {
		// TODO Auto-generated method stub
		
	}

	public void registerBlockRender(FloorProp floorProp, int i, String string) {
		// TODO Auto-generated method stub
		
	}

	public void registerBlockRender(ChairBlock chairBlock, int i, String string) {
		// TODO Auto-generated method stub
		
	}

	public void registerBlockRender(CampfireBlock campfireBlock, int i, String string) {
		// TODO Auto-generated method stub
		
	}

	public void registerBlockRender(PinicTableBlock pinicTableBlock, int i, String string) {
		// TODO Auto-generated method stub
		
	}

	public void registerBlockRender(CabnetBlock cabnetBlock, int i, String string) {
		// TODO Auto-generated method stub
		
	}


	
	
}
