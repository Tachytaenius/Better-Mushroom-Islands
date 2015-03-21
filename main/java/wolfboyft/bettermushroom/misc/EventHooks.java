package wolfboyft.bettermushroom.misc;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wolfboyft.bettermushroom.init.BetterMushroomItems;

public class EventHooks {
	
	@SubscribeEvent
	public void LivingDropEvent(LivingDropsEvent event){
		if(event.entity instanceof EntityMooshroom){
			if(event.entityLiving.isChild()){
			}
			else{
			event.drops.clear();
			event.drops.add(new EntityItem(event.entityLiving.worldObj,event.entityLiving.posX,event.entityLiving.posY,event.entityLiving.posZ,new ItemStack(BetterMushroomItems.mushroom_leather, 1)));
			if (event.entityLiving.isBurning()){
				event.drops.add(new EntityItem(event.entityLiving.worldObj,event.entityLiving.posX,event.entityLiving.posY,event.entityLiving.posZ,new ItemStack(BetterMushroomItems.cooked_shroomeat, 1)));
			}else{
				event.drops.add(new EntityItem(event.entityLiving.worldObj,event.entityLiving.posX,event.entityLiving.posY,event.entityLiving.posZ,new ItemStack(BetterMushroomItems.raw_shroomeat, 1)));
				}
			}
		}
	}
}
