package com.deadrising.mod.init;

import java.util.ArrayList;
import java.util.List;

import com.deadrising.mod.deadrising;
import com.deadrising.mod.blocks.PropBase;
import com.deadrising.mod.blocks.props.CabnetBlock;
import com.deadrising.mod.blocks.props.CampfireBlock;
import com.deadrising.mod.blocks.props.ChairBlock;
import com.deadrising.mod.blocks.props.FloorProp;
import com.deadrising.mod.blocks.props.LightProp;
import com.deadrising.mod.blocks.props.PinicTableBlock;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;


@Mod.EventBusSubscriber(modid = "deadrising")
public class ModBlocks
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	//Blocks
	
	
	
	//Props
	public static final Block FIREWOOD = new PropBase("firewood", Material.IRON, deadrising.TabBlocks); 
	public static final Block BOX_CRATE = new PropBase("box_crate", Material.IRON, deadrising.TabBlocks);
	public static final Block BOX = new PropBase("box", Material.IRON, deadrising.TabBlocks);
	public static final Block BOX_GRAPES = new PropBase("box_grapes", Material.IRON, deadrising.TabBlocks);
	public static final Block BOX_ORANGES = new PropBase("box_oranges", Material.IRON, deadrising.TabBlocks);
	public static final Block BOX_PEACHES = new PropBase("box_peaches", Material.IRON, deadrising.TabBlocks);
	public static final Block BOX_PLUMS = new PropBase("box_plums", Material.IRON, deadrising.TabBlocks);
	public static final Block BOX_TANGERINES = new PropBase("box_tangerines", Material.IRON, deadrising.TabBlocks);
	public static final Block CABNET = new CabnetBlock("cabnet", Material.IRON, deadrising.TabBlocks);
	public static final Block CHAIR = new ChairBlock("chair", Material.IRON, deadrising.TabBlocks);
	public static final Block CRATE_OPEN = new PropBase("crate_open", Material.IRON, deadrising.TabBlocks);
	public static final Block FLOORPROP = new FloorProp("floorprop", Material.IRON, deadrising.TabBlocks);
	public static final Block FLOORPROP2 = new FloorProp("floorprop2", Material.IRON, deadrising.TabBlocks);
	public static final Block FLOORPROP3 = new FloorProp("floorprop3", Material.IRON, deadrising.TabBlocks);
	public static final Block CAMPFIRE = new CampfireBlock("campfire", Material.IRON, deadrising.TabBlocks);
	public static final Block FIREPIT = new CampfireBlock("firepit", Material.IRON, deadrising.TabBlocks);
	public static final Block MILITARY_CRATE = new PropBase("military_crate", Material.IRON, deadrising.TabBlocks);
	public static final Block PALLET = new FloorProp("pallet", Material.IRON, deadrising.TabBlocks);
	public static final Block RUBLE = new PropBase("ruble", Material.IRON, deadrising.TabBlocks);
	public static final Block STACKEDPALLET = new PropBase("stackedpallet", Material.IRON, deadrising.TabBlocks);
	public static final Block TRASH = new PropBase("trash", Material.IRON, deadrising.TabBlocks);
	public static final Block TRASH2 = new PropBase("trash2", Material.IRON, deadrising.TabBlocks);
	public static final Block LIGHT = new LightProp("light", Material.IRON, deadrising.TabBlocks);
	public static final Block LIGHT2 = new LightProp("light2", Material.IRON, deadrising.TabBlocks);
	public static final Block TRASH3 = new PropBase("trash3", Material.IRON, deadrising.TabBlocks);
	public static final Block WARDROBE = new PropBase("wardrobe", Material.IRON, deadrising.TabBlocks);
	public static final Block WARDROBE2 = new PropBase("wardrobe2", Material.IRON, deadrising.TabBlocks);
	public static final Block BOOKSHELF = new PropBase("bookshelf", Material.IRON, deadrising.TabBlocks);
	public static final Block BOOKSHELF2 = new PropBase("bookshelf2", Material.IRON, deadrising.TabBlocks);
	public static final Block BARRICADE = new PropBase("barricade", Material.IRON, deadrising.TabBlocks);
	public static final Block PICNICTABLE = new PinicTableBlock("picnictable", Material.IRON, deadrising.TabBlocks);
	public static final Block TABLE = new PinicTableBlock("table", Material.IRON, deadrising.TabBlocks);
	public static final Block CAMPPICNICTABLE = new PinicTableBlock("camppicnictable", Material.IRON, deadrising.TabBlocks);
	public static final Block MILITARYSIGN = new PinicTableBlock("militarysign", Material.IRON, deadrising.TabBlocks);
	
	
}
