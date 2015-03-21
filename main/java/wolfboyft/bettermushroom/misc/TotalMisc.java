package wolfboyft.bettermushroom.misc;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class TotalMisc {
	public static ArmorMaterial addArmorMaterial(String name, int durability, int[] oldArmor, int enchantability) {
        int duraNew = (int) Math.round(durability / 13.75);
        return EnumHelper.addArmorMaterial(name, name, duraNew, oldArmor, enchantability);
    }
	public static Item toItem(Block block){
		return Item.getItemFromBlock(block);
	}
}
