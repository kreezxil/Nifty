package com.androsa.nifty.blocks;

import com.androsa.nifty.util.BlockModelHelper;
import com.androsa.nifty.util.ModelUtil;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NiftyStairs extends BlockStairs implements BlockModelHelper {

    private boolean isBeaconBase;

    public NiftyStairs(IBlockState state, SoundType sound, float hardness, float resistance, boolean beacon) {
        super(state);

        this.setSoundType(sound);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        this.useNeighborBrightness = true;
        this.isBeaconBase = beacon;
    }

    public NiftyStairs(IBlockState state, SoundType sound, float hardness, float resistance, int harvest, boolean beacon) {
        super(state);

        this.setSoundType(sound);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
            this.setHarvestLevel("pickaxe", harvest);

        this.useNeighborBrightness = true;
        this.isBeaconBase = beacon;
    }

    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return this.isBeaconBase;
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, HALF, SHAPE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return super.getMetaFromState(state);
    }

    @Override
    @Deprecated
    public IBlockState getStateFromMeta(int meta) {
        return super.getStateFromMeta(meta & 0b0111);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        list.add(new ItemStack(this, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModel() {
        ModelUtil.registerToState(this, 0, getDefaultState().withProperty(FACING, EnumFacing.EAST));
    }
}
