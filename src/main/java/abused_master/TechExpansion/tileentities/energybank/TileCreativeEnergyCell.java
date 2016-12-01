package abused_master.TechExpansion.tileentities.energybank;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyConnection;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class TileCreativeEnergyCell extends TileEntity implements IEnergyReceiver, IEnergyProvider, ITickable {
	
	protected EnergyStorage storage = new EnergyStorage(1000000000);
    public static int SENDPERTICK = 6000;

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
	public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) {

		return storage.receiveEnergy(maxReceive, simulate);
	}

	@Override
	public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) {

		//return storage.extractEnergy(maxExtract = 1000000, simulate);
		return 1000000;
	}
	@Override
	public int getEnergyStored(EnumFacing from) {

		return storage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(EnumFacing from) {

		return storage.getMaxEnergyStored();
	}
	
	 public static boolean isEnergyTE(TileEntity te) {
	        return te instanceof IEnergyHandler || (te != null && te.hasCapability(CapabilityEnergy.ENERGY, null));
	    }
	
	 public static int receiveEnergy(TileEntity tileEntity, EnumFacing from, int maxReceive) {
	        if (tileEntity instanceof IEnergyReceiver) {
	            return ((IEnergyReceiver) tileEntity).receiveEnergy(from, maxReceive, false);
	        } else if (tileEntity != null && tileEntity.hasCapability(CapabilityEnergy.ENERGY, from)) {
	            IEnergyStorage capability = tileEntity.getCapability(CapabilityEnergy.ENERGY, from);
	            if (capability.canReceive()) {
	                return capability.receiveEnergy(maxReceive, false);
	            }
	        }
	        return 0;
	    }
	 
	@Override
	public void update() {
		storage.setEnergyStored(1000000000);

		int energyStored = getEnergyStored(EnumFacing.DOWN);

	        for (EnumFacing facing : EnumFacing.values()) {
	            BlockPos pos = getPos().offset(facing);
	            TileEntity te = worldObj.getTileEntity(pos);
	            if (isEnergyTE(te)) {
	            EnumFacing opposite = facing.getOpposite();
                int rfToGive = SENDPERTICK <= energyStored ? SENDPERTICK : energyStored;
                int received;
                
	                if (te instanceof IEnergyConnection) {
	                    IEnergyConnection connection = (IEnergyConnection) te;
	                    if (connection.canConnectEnergy(opposite)) {
	                        received = receiveEnergy(te, opposite, rfToGive);
	                    } else {
	                        received = 0;
	                    }
	                } else {
	                    received = receiveEnergy(te, opposite, rfToGive);
	                }
	                energyStored -= storage.extractEnergy(received, false);
	                if (energyStored <= 0) {
	                    break;
	                }
	            }
	        }
		}
	}
