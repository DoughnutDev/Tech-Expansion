package abused_master.TechExpansion.tileentities.machine;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import cofh.api.energy.IEnergyProvider;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Mohammad on 11/23/2016.
 */
public class TileQuarry extends TileEntity implements ITickable, IEnergyProvider, IEnergyReceiver {

    protected EnergyStorage storage = new EnergyStorage(100000);
    public static int y = -1;



    public boolean atTickRate(int rate) { return (worldObj.getTotalWorldTime() + ((long) rate) + ((long) pos.hashCode()) + ((long) pos.getX()) + ((long) pos.getY()) + ((long) pos.getZ())) % ((long) rate) == 0; };
    private long field_190578_g;
    private int transferCooldown = -1;
    public static int RANGE = 16;
    public ItemStack item = ItemStack.field_190927_a;
    private static FakePlayer harvester = null;

    public TileQuarry() {
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        storage.readFromNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        return storage.writeToNBT(nbt);
    }

    @Override
    public boolean canConnectEnergy(EnumFacing from) {
        return true;
    }

    @Override
    public int getEnergyStored(EnumFacing from) {
        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(EnumFacing from) {
        return storage.getMaxEnergyStored();
    }

    @Override
    public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) {
        return storage.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) {
        return storage.extractEnergy(0, simulate);
    }


    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {

        NBTTagCompound data = new NBTTagCompound();
        writeToNBT(data);
        return new SPacketUpdateTileEntity(this.pos, 1, data);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onDataPacket(NetworkManager networkManager, SPacketUpdateTileEntity s35PacketUpdateTileEntity) {
        readFromNBT(s35PacketUpdateTileEntity.getNbtCompound());
        worldObj.markBlockRangeForRenderUpdate(this.pos, this.pos);
        markForUpdate();
    }


    public void markForUpdate() {
        if (this.worldObj != null) {
            Block block = worldObj.getBlockState(this.pos).getBlock();
            this.worldObj.notifyBlockUpdate(this.pos, worldObj.getBlockState(this.pos), worldObj.getBlockState(this.pos), 3);
        }
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        writeToNBT(nbtTagCompound);
        return nbtTagCompound;
    }

    @Override
    public void update() {
        BlockPos quarrypos = getPos();
        if (y == -1) y = pos.getY() - 1;
        int chunkX, chunkZ;

        {
            Chunk c = worldObj.getChunkFromBlockCoords(pos);
            chunkX = c.xPosition;
            chunkZ = c.zPosition;
        }


        if (atTickRate(10) && storage.getEnergyStored() >= 100) {
            storage.setEnergyStored(storage.getEnergyStored() - 100);
            boolean hasBrokenBlock = false;
            start:
            for (int x = 0; x < 16; ++x)
                for (int z = 0; z < 16; ++z) {
                    BlockPos pos = new BlockPos(chunkX * 16 + x, y, chunkZ * 16 + z);
                    Block bb = worldObj.getBlockState(pos).getBlock();
                    if (!hasBrokenBlock && !worldObj.isAirBlock(pos) && FluidRegistry.lookupFluidForBlock(bb) == null && bb != Blocks.FLOWING_LAVA && bb != Blocks.FLOWING_WATER) {
                        IBlockState state = worldObj.getBlockState(pos);
                        World world;
                        Block b = state.getBlock();
                        if (b.getBlockHardness(state, worldObj, pos) < 0F) continue;

                        List<ItemStack> drops;

                        drops = new ArrayList<ItemStack>();
                        drops.add(new ItemStack(state.getBlock(), 1, state.getBlock().getMetaFromState(state)));
                        drops = state.getBlock().getDrops(getWorld(), pos, state, 0);
                        for (ItemStack drop : drops) {
                            for (EnumFacing side : EnumFacing.VALUES) {
                                BlockPos cip = pos.offset(side);
                                TileEntity ite = worldObj.getTileEntity(cip);
                                if (ite instanceof IItemHandler) {
                                    drop = TileEntityHopper.putStackInInventoryAllSlots(null, (IInventory) ite, drop, side.getOpposite());
                                }
                                if (drop == null) {
                                    break;
                                }
                            }
                            if (drop != null) {
                                EntityItem ent = new EntityItem(getWorld(), quarrypos.getX() + 0.5, quarrypos.getY() + 1, quarrypos.getZ() + 0.5);
                                ent.setEntityItemStack(drop);
                                getWorld().spawnEntityInWorld(ent);
                            }
                        }


                        hasBrokenBlock = true;
                        worldObj.destroyBlock(pos, false);

                        break start;
                    }
                }
            if (!hasBrokenBlock) y--;
        }

    }
}