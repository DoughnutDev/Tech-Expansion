package abused_master.TechExpansion.registry;

import java.util.Random;

import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDrops {
	
	 public static Random random;
	 public static int dropped;
	 
	 @SubscribeEvent
	 public void onEntityDrop(LivingDropsEvent event) {
	 random = new Random();
	 dropped = random.nextInt(2) + 1;
	 
	 if(event.getEntityLiving() instanceof EntityMob) {
	 event.getEntityLiving().entityDropItem(new ItemStack(Items.GOLD_NUGGET), dropped);
	 }

	 if(event.getEntityLiving() instanceof EntityBlaze) {
		 event.getEntityLiving().entityDropItem(new ItemStack(Items.DIAMOND, 6), dropped);

	 }

	 }
	
}
