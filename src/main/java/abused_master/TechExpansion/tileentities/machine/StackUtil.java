package abused_master.TechExpansion.tileentities.machine;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * Created by Mohammad on 12/2/2016.
 */
public class StackUtil {

    public static ItemStack validateCopy(ItemStack stack){
        if(isValid(stack)){
            return stack.copy();
        }
        else{
            return getNull();
        }
    }

    public static ItemStack validateCheck(ItemStack stack){
        if(isValid(stack)){
            return stack;
        }
        else{
            return getNull();
        }
    }

    /**
     * Used to see if the item is actually valid for containers.
     * @param stack that needs to be checked if its vaild
     * @return returns false/true if the ItemStack is NULL AND EMPTY
     */
    public static boolean isValid(ItemStack stack){
        return stack != null && !stack.func_190926_b(); // checks if the ItemStack is null or empty, and returns false if it is.
    }

    /**
     * Gets a Null ItemStack
     * @return A EMPTY/NULL itemstack
     */
    public static ItemStack getNull(){
        return ItemStack.field_190927_a;
    }

    public static int getStackSize(ItemStack stack){
        if(!isValid(stack)){
            return 0;
        }
        else{
            return stack.func_190916_E();
        }
    }

    /**
     * Sets a Stack to a certain size
     * @param stack the stack to be changed
     * @param size the amount the stack needs to be set to
     * @return A new ItemStack that
     */
    public static ItemStack setStackSize(ItemStack stack, int size){
        if(size <= 0){
            if(isValid(stack)){
                return stack.getItem().getContainerItem(stack); //gets the ContainerItem
            }
            else{
                return getNull();
            }
        }
        stack.func_190920_e(size); //stack.setCount to the size appointed above
        return stack;
    }

    /**
     * A method for
     * @param stack the ItemStack to have stacksize added to.
     * @param size the amount of stack that needs to be added
     * @return a new ItemStack that has the orginal + the size amount included.
     */

    public static ItemStack addStackSize(ItemStack stack, int size){
        return setStackSize(stack, getStackSize(stack)+size);
    }

    /**
     * A method for checking a Inventory of contents/
     * @param slots checks a list of slots for ItemStacks
     * @return returns false if the inventory IS empty.
     */
    public static boolean isIInvEmpty(NonNullList<ItemStack> slots){
        for(ItemStack stack : slots){
            if(StackUtil.isValid(stack)){
                return false;
            }
        }

        return true;
    }

    public static NonNullList<ItemStack> createSlots(int size){
        return NonNullList.func_191197_a(size, getNull());
    }


}
