package abused_master.TechExpansion.tileentities.generators;

import abused_master.TechExpansion.tileentities.container.generators.CoalGenContainer;
import abused_master.TechExpansion.tileentities.machine.StackUtil;
import cofh.api.energy.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * Created by Mohammad on 12/1/2016.
 */
public class TileCoalGen extends TileEntity implements IEnergyProvider, IEnergyReceiver, ITickable, ISidedInventory {

    public EnergyStorage storage = new EnergyStorage(100000, 500);
    private NonNullList<ItemStack> coalGen = NonNullList.<ItemStack>func_191197_a(1, ItemStack.field_190927_a);
    public static final int PRODUCE = 32;
    public int maxBurnTime;
    public int currentBurnTime;

    private int lastEnergy;
    private int lastBurnTime;
    private int lastCurrentBurnTime;

    public static int SENDPERTICK = 1500;

    public TileCoalGen() {
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList inventory = (NBTTagList) nbt.getTag("Items");
        for(int i = 0; i < inventory.tagCount(); i++) {
            NBTTagCompound itemTag = inventory.getCompoundTagAt(i);
            ItemStack stack = new ItemStack(itemTag);
            coalGen.set(itemTag.getByte("Slot"), stack);
        }
        storage.readFromNBT(nbt);
        this.currentBurnTime = nbt.getInteger("BurnTime");
        this.maxBurnTime = nbt.getInteger("MaxBurnTime");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList inventory = new NBTTagList();
        for(byte slot = 0; slot < coalGen.size(); slot++) {
            ItemStack stack = coalGen.get(slot);
            if(!stack.func_190926_b()) {
                NBTTagCompound itemTag = new NBTTagCompound();
                stack.writeToNBT(itemTag);
                itemTag.setByte("Slot", slot);
                inventory.appendTag(itemTag);
            }
        }
        nbt.setTag("Items", inventory);
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
        return 0;
    }

    @Override
    public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) {
        return storage.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        if (direction == EnumFacing.DOWN && index == 1)
        {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
            {
                return false;
            }
        }
        return true;    }

    @Override
    public int getSizeInventory() {
        return this.coalGen.size();
    }

    @Override
    public boolean func_191420_l() {
        for (ItemStack itemstack : this.coalGen)
        {
            if (!itemstack.func_190926_b())
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return (ItemStack)this.coalGen.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.coalGen, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.coalGen, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemstack = (ItemStack)this.coalGen.get(index);
        boolean flag = !stack.func_190926_b() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.coalGen.set(index, stack);

        if (stack.func_190916_E() > this.getInventoryStackLimit())
        {
            stack.func_190920_e(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag)
        {
            this.markDirty();
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 2)
        {
            return false;
        }
        else if (index != 1)
        {
            return true;
        }else {

            return true;
        }
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        this.coalGen.clear();
    }

    @Override
    public String getName() {
        return "CoalGen";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    public static boolean isEnergyTE(TileEntity te) {
        return te instanceof IEnergyHandler || (te != null && te.hasCapability(CapabilityEnergy.ENERGY, null));
    }

    @Override
    public void update() {
        if(!this.worldObj.isRemote){
            boolean isBurning = this.currentBurnTime > 0;

            if(this.currentBurnTime > 0){
                this.currentBurnTime--;
                this.storage.receiveEnergy(PRODUCE, false);
            }

            if(this.currentBurnTime <= 0 && StackUtil.isValid(this.coalGen.get(0)) && TileEntityFurnace.getItemBurnTime(this.coalGen.get(0)) > 0 && this.storage.getEnergyStored() < this.storage.getMaxEnergyStored()){


                int burnTime = TileEntityFurnace.getItemBurnTime(this.coalGen.get(0));

                this.maxBurnTime = burnTime;
                this.currentBurnTime = burnTime;

                this.coalGen.set(0, StackUtil.addStackSize(this.coalGen.get(0), -1));
            }

            if(isBurning != this.currentBurnTime > 0){
                this.markDirty();
            }

            if((this.storage.getEnergyStored() != this.lastEnergy || this.currentBurnTime != this.lastCurrentBurnTime || this.lastBurnTime != this.maxBurnTime)){
                this.lastEnergy = this.storage.getEnergyStored();
                this.lastCurrentBurnTime = this.currentBurnTime;
                this.lastBurnTime = this.currentBurnTime;
            }

        }







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
                        received = 0;
                    } else {
                        received = 0;
                    }
                } else {
                    received = 0;
                }
                energyStored -= storage.extractEnergy(received, false);
                if (energyStored <= 0) {
                    break;
                }
            }
        }
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
    public NBTTagCompound getUpdateTag()
    {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        writeToNBT(nbtTagCompound);
        return nbtTagCompound;
    }

    @Override
    public void handleUpdateTag(NBTTagCompound tag)
    {
        this.readFromNBT(tag);
    }

}
