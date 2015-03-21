package wolfboyft.bettermushroom.init;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolfboyft.bettermushroom.BetterMushroom;
import wolfboyft.bettermushroom.misc.EnumArmour;

public class Armours extends ItemArmor implements ISpecialArmor{
	
	protected final static int HEAD = 0;
	protected final static int BODY = 1;
	protected final static int LEGS = 2;
	protected final static int BOOTS = 3;
	protected double damageReduction;
	protected boolean unbreakable;
	protected String textureName = "bettermushroom:textures/armour/", name;
	protected int fullReduction;
	protected EnumArmour armorMaterial;

	public Armours(EnumArmour armorMaterial, int type) {
		this(armorMaterial, type, armorMaterial.getType());
	}

	public Armours(EnumArmour armorMaterial, int type, String name) {
		super(armorMaterial.getArmorMaterial(), type, type);
		this.armorMaterial = armorMaterial;
		this.fullReduction = armorMaterial.getDamageReduction();
		if (armorType == 0) damageReduction = ((((double)fullReduction) / 24) * 5) / 100;
		else if (armorType == 1) damageReduction = ((((double)fullReduction) / 24) * 8) / 100;
		else if (armorType == 2) damageReduction = ((((double)fullReduction) / 24) * 7) / 100;
		else if (armorType == 3) damageReduction = ((((double)fullReduction) / 24) * 4) / 100;
		this.unbreakable = armorMaterial.isUndamageable();
		setCreativeTab(BetterMushroom.tabMod);
		setArmorType(name, armorType);
		setUnlocalizedName(this.name);
		GameRegistry.registerItem(this, this.name);
	}

	@Override
	public boolean getIsRepairable(ItemStack i, ItemStack i1) {
		return armorMaterial.getRepairItem() != null && armorMaterial.getRepairItem() == i1.getItem() ? true : super.getIsRepairable(i, i1);
	}

	protected void setArmorType(String material, int armorType) {
		this.name = armorType == HEAD ? material + "Helmet" : armorType == BODY ? material + "Body" : armorType == LEGS ? material + "Legs" : armorType == BOOTS ? material + "Boots" : material + "Unknown";
		this.textureName = (armorType == 0 || armorType == 1 || armorType == 3) ? textureName + armorMaterial.getType() + "_1.png" : textureName + armorMaterial.getType() + "_2.png";
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return textureName;
	}

	@Override
	public boolean isDamageable() {
		return !unbreakable;
	}

	@Override
	public void damageArmor(EntityLivingBase l, ItemStack s, DamageSource d, int amount, int slot) {
		if(!unbreakable) s.damageItem(1, l);
	}

	@Override
	public int getArmorDisplay(EntityPlayer p, ItemStack s, int b) {
		return (int)Math.round((damageReduction * 100) / 4);
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase l, ItemStack s, DamageSource d, double amount, int slot) {
		return new ISpecialArmor.ArmorProperties(0, damageReduction, 50000);
	}
	
}
