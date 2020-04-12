package com.deadrising.mod.blocks.props;

import java.util.List;

import com.deadrising.mod.deadrising;
import com.deadrising.mod.init.ModBlocks;
import com.deadrising.mod.init.ModItems;
import com.deadrising.mod.utils.CollisionHelper;
import com.deadrising.mod.utils.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LightProp extends Block implements IHasModel {
	
	

public LightProp(String name, Material material, CreativeTabs tab)
{
	super(material);
	setUnlocalizedName(name);
	setRegistryName(name);
	setCreativeTab(tab);
	this.setLightLevel(1.0F);
	this.setHardness(1); 
	
	
	ModBlocks.BLOCKS.add(this);
	ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
}


public void registerModels() 
{
	deadrising.proxy.registerBlockRender(this, 0, "inventory");

}


@Override
public BlockRenderLayer getBlockLayer() 
{
	return BlockRenderLayer.CUTOUT;
}

@Override
public boolean isFullBlock(IBlockState state) 
{
	return false;
}

@Override
public boolean isFullCube(IBlockState state) 
{
	return false;
}

@Override
public boolean isOpaqueCube(IBlockState state) 
{
	return false;
}









}
