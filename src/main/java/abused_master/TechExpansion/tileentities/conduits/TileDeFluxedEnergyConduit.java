package abused_master.TechExpansion.tileentities.conduits;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileDeFluxedEnergyConduit extends TileEntity implements ITickable, IEnergyReceiver, IEnergyProvider {
	
	 public EnergyStorage energyStorage = new EnergyStorage(6000, 6000);
	 
	    public TileDeFluxedEnergyConduit() {
	    	
	    }

	    public TileDeFluxedEnergyConduit(int capacity, int maxTransfer) {
	        this.energyStorage = new EnergyStorage(capacity, maxTransfer);
	    }

	    /**
	     * Gets called every tick, and in this case, attempts to transfer objects
	     * to nearby destinations
	     */
	    @Override
	    public void update() {
	        List<EnumFacing> transferableSides = getTransferableSides();
	        if (!transferableSides.isEmpty()) {
	            int forEach = energyStorage.getEnergyStored() / transferableSides.size();
	            for (EnumFacing side : transferableSides) {
	                BlockPos neighbor = pos.offset(side);
	                TileEntity tile = worldObj.getTileEntity(neighbor);
	                // Double checking
	                if (tile != null) {
	                    if (tile instanceof IEnergyReceiver) {
	                        transferRFToTile((IEnergyReceiver) tile, side, forEach);
	                    } else if (tile instanceof IEnergyReceiver) {
	                        transferRFToTile((IEnergyReceiver) tile, side, forEach);
	                    }
	                }
	            }
	        }

	        IBlockState state = worldObj.getBlockState(pos);
	    }

	    /**
	     * Transfers RF from this tile entity to the energy receiver given.
	     * @param receiver The tile entity that will receive the energy
	     * @param side The side of this pipe to transfer energy to
	     * @param energyAmount How much energy to transfer from this pipe to the tile entity
	     */
	    private void transferRFToTile(IEnergyReceiver receiver, EnumFacing side, int energyAmount) {
	        if (receiver.canConnectEnergy(side.getOpposite())) { // If energy can be transferred on that side
	            receiver.receiveEnergy(side.getOpposite(), extractEnergy(side, energyAmount, false), false);
	        }
	    }

	    /**
	     * Returns a list of sides of this block, to which any object given can be transferred
	     * to.
	     * @return sides that stuff can be transferred to
	     */
	    public List<EnumFacing> getTransferableSides() {
	        List<EnumFacing> sides = new ArrayList<EnumFacing>();
	        for (EnumFacing side : EnumFacing.VALUES) {
	            BlockPos neighbor = pos.offset(side);
	            TileEntity tile = worldObj.getTileEntity(neighbor);
	            if (tile != null) {
	                if (tile instanceof IEnergyReceiver) {
	                    sides.add(side);
	                }
	            }
	        }

	        if (sides.size() != 0) {
	            int forEach = energyStorage.getEnergyStored() / sides.size();

	            for (EnumFacing side : EnumFacing.VALUES) {
	                if (sides.contains(side)) {
	                    BlockPos neighbor = pos.offset(side);
	                    TileEntity tile = worldObj.getTileEntity(neighbor);
	                    if (tile != null && tile instanceof IEnergyReceiver) {
	                        IEnergyReceiver receiver = (IEnergyReceiver) tile;
	                        if (receiver.getEnergyStored(side.getOpposite()) + forEach > receiver.getMaxEnergyStored(side.getOpposite())) { // can't hold more energy
	                            sides.remove(side);
	                        }
	                        if (!receiver.canConnectEnergy(side.getOpposite())) { // Can't connect on that side
	                            sides.remove(side);
	                        }
	                    }
	                }
	            }
	        }
	        return sides;
	    }

	    @Override
	    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
	        super.writeToNBT(nbt);
	        energyStorage.writeToNBT(nbt);
	        return nbt;
	    }

	    @Override
	    public void readFromNBT(NBTTagCompound nbt) {
	        super.readFromNBT(nbt);
	        energyStorage.readFromNBT(nbt);
	    }

	    @Override
	    public NBTTagCompound getUpdateTag() {
	        return writeToNBT(super.getUpdateTag());
	    }

	    @Nullable
	    @Override
	    public SPacketUpdateTileEntity getUpdatePacket() {
	        NBTTagCompound tag = new NBTTagCompound();
	        writeToNBT(tag);
	        return new SPacketUpdateTileEntity(pos, getBlockMetadata(), tag);
	    }

	    /**
	     * Returns the energy currently stored in the tile
	     * @param from side energy stored in
	     * @return energy stored currently
	     */
	    @Override
	    public int getEnergyStored(EnumFacing from) {
	        return energyStorage.getEnergyStored();
	    }

	    /**
	     * Returns the capacity of the tile
	     * @param from capacity of side
	     * @return max energy storage
	     */
	    @Override
	    public int getMaxEnergyStored(EnumFacing from) {
	        return energyStorage.getMaxEnergyStored();
	    }

	    /**
	     * Returns the energy currently stored in the tile, without side
	     * @return energy stored currently
	     */
	    public int getEnergyStored() {
	        return energyStorage.getEnergyStored();
	    }

	    /**
	     * Returns the capacity of the tile, without side
	     * @return max energy storage
	     */
	    public int getMaxEnergyStored() {
	        return energyStorage.getMaxEnergyStored();
	    }

	    /**
	     * Energy pipes do NOT support blocking transfer based on wrench toggle. Therefore returns true.
	     * However redstone signal does change this, and if this block is powered on any signal, it
	     * will NOT transfer anything. This is how all pipes behave.
	     * @param from side to check if can connect to
	     * @return can connect
	     */
	    @Override
	    public boolean canConnectEnergy(EnumFacing from) {
	        return worldObj.isBlockIndirectlyGettingPowered(pos) >= 1; // is powered by at least a signal of power 1
	    }

	    /**
	     * Extract energy from this tile entity.
	     * @param from
	     *            Orientation the energy is extracted from.
	     * @param maxExtract
	     *            Maximum amount of energy to extract.
	     * @param simulate
	     *            If TRUE, the extraction will only be simulated.
	     * @return amount of energy extracted
	     */
	    @Override
	    public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) {
	        return energyStorage.extractEnergy(maxExtract, simulate);
	    }

	    /**
	     * Received the amount of energy given
	     * @param from
	     *            Orientation the energy is received from.
	     * @param maxReceive
	     *            Maximum amount of energy to receive.
	     * @param simulate
	     *            If TRUE, the charge will only be simulated.
	     * @return amount of energy received
	     */
	    @Override
	    public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) {
	        return energyStorage.receiveEnergy(maxReceive, simulate);
	    }
	
}
