package wolfboyft.bettermushroom.misc;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import wolfboyft.bettermushroom.init.BetterMushroomItems;

public enum EnumArmour{
	
REDMOOSHROOM(TotalMisc.addArmorMaterial("redmooshroom", 300, new int[] {2, 4, 3, 2}, 20), "redmooshroom", false, 30, BetterMushroomItems.mushroom_leather);
	
	private ArmorMaterial armorMaterial;
	private String type;
	private boolean undamageable;
	private int damageReduction;
	private Item repairItem;

	private EnumArmour(ArmorMaterial armorMaterial, String type, boolean undamageable, int damageReduction, Item repair) {
		this.armorMaterial = armorMaterial;
		this.type = type;
		this.undamageable = undamageable;
		this.damageReduction = damageReduction;
		this.repairItem = repair;
	}

	private EnumArmour(ArmorMaterial armorMaterial, String type, boolean undamageable, int damageReduction, Block repair) {
		this.armorMaterial = armorMaterial;
		this.type = type;
		this.undamageable = undamageable;
		this.damageReduction = damageReduction;
		this.repairItem = TotalMisc.toItem(repair);
	}

	public Item getRepairItem(){
		return repairItem;
	}

	public ArmorMaterial getArmorMaterial() {
		return armorMaterial;
	}

	public String getType() {
		return type;
	}

	public boolean isUndamageable() {
		return undamageable;
	}

	public int getDamageReduction() {
		return damageReduction;
	}
}