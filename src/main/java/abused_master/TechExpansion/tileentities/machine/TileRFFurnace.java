package abused_master.TechExpansion.tileentities.machine;

import abused_master.TechExpansion.registry.ModBlocks;
import abused_master.TechExpansion.tileentities.craftinghandlers.RecipePulverizer;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;
import cofh.api.energy.TileEnergyHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * Created by Mohammad on 11/22/2016.
 */
public class TileRFFurnace extends TileEntity implements ITickable, IInventory, ISidedInventory, IEnergyReceiver, IEnergyProvider{

    public EnergyStorage storage = new EnergyStorage(50000);
    private NonNullList<ItemStack> rfFurnaceInv = NonNullList.<ItemStack>func_191197_a(2, ItemStack.field_190927_a);

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList inventory = (NBTTagList) nbt.getTag("Items");
        for (int i = 0; i < inventory.tagCount(); i++) {
            NBTTagCompound itemTag = inventory.getCompoundTagAt(i);
            ItemStack stack = new ItemStack(itemTag);
            rfFurnaceInv.set(itemTag.getByte("Slot"), stack);
        }
        storage.readFromNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList inventory = new NBTTagList();
        for (byte slot = 0; slot < rfFurnaceInv.size(); slot++) {
            ItemStack stack = rfFurnaceInv.get(slot);
            if (!stack.func_190926_b()) {
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
    public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) {
        return storage.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int getEnergyStored(EnumFacing from) {
        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(EnumFacing from) {
        return storage.getMaxEnergyStored();
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
    }

    private net.minecraftforge.items.IItemHandler itemHandler;

    protected net.minecraftforge.items.IItemHandler createUnSidedHandler() {
        return new net.minecraftforge.items.wrapper.InvWrapper(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    @javax.annotation.Nullable
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @javax.annotation.Nullable net.minecraft.util.EnumFacing facing) {
        if (capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return (T) (itemHandler == null ? (itemHandler = createUnSidedHandler()) : itemHandler);
        return super.getCapability(capability, facing);
    }

    @Override
    public boolean hasCapability(net.minecraftforge.common.capabilities.Capability<?> capability, @javax.annotation.Nullable net.minecraft.util.EnumFacing facing) {
        return capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Override
    public int getSizeInventory() {
        return this.rfFurnaceInv.size();
    }


    @Override
    public ItemStack getStackInSlot(int index) {
        return (ItemStack) this.rfFurnaceInv.get(index);
    }


    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.rfFurnaceInv, index, count);
    }


    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.rfFurnaceInv, index);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }


    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }


    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }


    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        {
            if (index == 2) {
                return false;
            } else if (index != 1) {
                return true;
            } else {

                return true;
            }
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
        this.rfFurnaceInv.clear();
    }


    @Override
    public String getName() {
        return ModBlocks.RFFurnace.getUnlocalizedName();
    }


    @Override
    public boolean hasCustomName() {
        return false;
    }


    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return null;
    }


    @Override
    public boolean canInsertItem(int index, net.minecraft.item.ItemStack itemStackIn, EnumFacing direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }


    @Override
    public boolean canExtractItem(int index, net.minecraft.item.ItemStack stack, EnumFacing direction) {
        if (direction == EnumFacing.DOWN && index == 1) {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
                return false;
            }
        }
        return true;
    }

    public boolean canPulverize() {
        if (((ItemStack) this.rfFurnaceInv.get(0)).func_190926_b()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void update() {
        if (this.canPulverize()) {
            ItemStack itemstack = (ItemStack) this.rfFurnaceInv.get(0);
            ItemStack itemstack1 = FurnaceRecipes.instance().getSmeltingResult(itemstack);
            ItemStack itemstack2 = (ItemStack) this.rfFurnaceInv.get(1);
            if (storage.getEnergyStored() >= 50 && !itemstack1.func_190926_b()) {
                storage.setEnergyStored(storage.getEnergyStored() - 50);

            if (itemstack2.func_190926_b()) {
                this.rfFurnaceInv.set(1, itemstack1.copy());
            } else if (itemstack2.getItem() == itemstack1.getItem()) {
                itemstack2.func_190917_f(itemstack1.func_190916_E());
            }
            itemstack.func_190918_g(1);
            }
        }
    }
    @Override
    public boolean func_191420_l() {
        for (ItemStack itemstack : this.rfFurnaceInv)
        {
            if (!itemstack.func_190926_b())
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemstack = (ItemStack)this.rfFurnaceInv.get(index);
        boolean flag = !stack.func_190926_b() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.rfFurnaceInv.set(index, stack);

        if (stack.func_190916_E() > this.getInventoryStackLimit())
        {
            stack.func_190920_e(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag)
        {
            this.markDirty();
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

    @Override
    public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) {
        return 0;
    }
}