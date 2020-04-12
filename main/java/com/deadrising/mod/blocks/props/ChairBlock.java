package com.deadrising.mod.blocks.props;

import java.util.Collections;
import java.util.List;

import com.deadrising.mod.deadrising;
import com.deadrising.mod.entity.EntitySittableBlock;
import com.deadrising.mod.init.ModBlocks;
import com.deadrising.mod.init.ModItems;
import com.deadrising.mod.utils.CollisionHelper;
import com.deadrising.mod.utils.IHasModel;
import com.deadrising.mod.utils.SittableUtil;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ChairBlock extends Block implements IHasModel 
{
	
	
    public static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.1, 0.0, 0.1, 0.9, 1.2, 0.9);

    public static final AxisAlignedBB CHAIR_SEAT = new AxisAlignedBB(1.6 * 0.0625, 8 * 0.0625, 1.6 * 0.0625, 14.4 * 0.0625, 9.6 * 0.0625, 14.4 * 0.0625);
    public static final AxisAlignedBB CHAIR_BACKREST_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.825, 0.6, 0.1, 0.9, 1.2, 0.9);
    public static final AxisAlignedBB CHAIR_BACKREST_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.825, 0.6, 0.1, 0.9, 1.2, 0.9);
    public static final AxisAlignedBB CHAIR_BACKREST_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.825, 0.6, 0.1, 0.9, 1.2, 0.9);
    public static final AxisAlignedBB CHAIR_BACKREST_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.825, 0.6, 0.1, 0.9, 1.2, 0.9);
    public static final AxisAlignedBB[] LEGS = {new AxisAlignedBB(1.6 * 0.0625, 0, 12.8 * 0.0625, 3.2 * 0.0625, 8 * 0.0625, 14.4 * 0.0625), new AxisAlignedBB(12.8 * 0.0625, 0, 12.8 * 0.0625, 14.4 * 0.0625, 8 * 0.0625, 14.4 * 0.0625), new AxisAlignedBB(12.8 * 0.0625, 0, 1.6 * 0.0625, 14.4 * 0.0625, 8 * 0.0625, 3.2 * 0.0625), new AxisAlignedBB(1.6 * 0.0625, 0, 1.6 * 0.0625, 3.2 * 0.0625, 8 * 0.0625, 3.2 * 0.0625)};

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	{
	    this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH)); 
	}
	



	public ChairBlock(String name, Material material, CreativeTabs tab)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		this.setHardness(1); 
		
		
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	
	public void registerModels() 
	{
		deadrising.proxy.registerBlockRender(this, 0, "inventory");
	
	}
	
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!playerIn.isSneaking())
        {
            if(SittableUtil.sitOnBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), playerIn, 7 * 0.0625))
            {
                worldIn.updateComparatorOutputLevel(pos, this);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean hasComparatorInputOverride(IBlockState state)
    {
        return true;
    }

    @Override
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return SittableUtil.isSomeoneSitting(worldIn, pos.getX(), pos.getY(), pos.getZ()) ? 1 : 0;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	public boolean isFullcube(IBlockState state) {
		return false;
	}
	
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean p_185477_7_)
    {
        if(!(entityIn instanceof EntitySittableBlock))
        {
            List<AxisAlignedBB> list = getCollisionBoxList(this.getActualState(state, worldIn, pos));
            for(AxisAlignedBB box : list)
            {
                addCollisionBoxToList(pos, entityBox, collidingBoxes, box);
            }
        }
    }
	


	@Override
	public IBlockState getStateFromMeta(int meta) 
    {
		EnumFacing facing = EnumFacing.getFront(meta);

		if(facing.getAxis()==EnumFacing.Axis.Y) 
		{
			facing=EnumFacing.NORTH;
		}
		return getDefaultState().withProperty(FACING, facing);
    }
	
	//Facing
	@Override
	public int getMetaFromState(IBlockState state) 
    {
		return ((EnumFacing) state.getValue(FACING)).getIndex();
    }
	    
	//Facing
    @Override
	protected BlockStateContainer createBlockState() 
    {
    	return new BlockStateContainer(this, new IProperty[]{FACING});
    }
    
    //Facing
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos,EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
    {
	  return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }
	
	private boolean canBlockStay(World worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) 
	{
		return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
	}
	
	


    private List<AxisAlignedBB> getCollisionBoxList(IBlockState state)
    {
        List<AxisAlignedBB> list = Lists.newArrayList();
        EnumFacing facing = state.getValue(FACING);
        switch(facing)
        {
            case NORTH:
                list.add(CHAIR_BACKREST_NORTH);
                break;
            case SOUTH:
                list.add(CHAIR_BACKREST_SOUTH);
                break;
            case WEST:
                list.add(CHAIR_BACKREST_WEST);
                break;
            default:
                list.add(CHAIR_BACKREST_EAST);
                break;
        }
        list.add(CHAIR_SEAT);
        Collections.addAll(list, LEGS);
        return list;
    }

    @Override
    public RayTraceResult collisionRayTrace(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start, Vec3d end)
    {
        List<RayTraceResult> list = Lists.newArrayList();

        for(AxisAlignedBB axisalignedbb : getCollisionBoxList(this.getActualState(blockState, worldIn, pos)))
        {
            list.add(this.rayTrace(pos, start, end, axisalignedbb));
        }

        RayTraceResult raytraceresult1 = null;
        double d1 = 0.0D;

        for(RayTraceResult raytraceresult : list)
        {
            if(raytraceresult != null)
            {
                double d0 = raytraceresult.hitVec.squareDistanceTo(end);

                if(d0 > d1)
                {
                    raytraceresult1 = raytraceresult;
                    d1 = d0;
                }
            }
        }

        return raytraceresult1;
    }
	
}
