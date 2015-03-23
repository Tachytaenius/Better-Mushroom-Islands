package wolfboyft.bettermushroom.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolfboyft.bettermushroom.BetterMushroom;
import wolfboyft.bettermushroom.Reference;
import wolfboyft.bettermushroom.misc.EnumArmour;
import wolfboyft.bettermushroom.init.Armours;

public class BetterMushroomItems {
	
	public static Item mushroom_leather;
	public static Item cooked_shroomeat;
	public static Item raw_shroomeat;
	public static Item mooshroom_helm;
	public static Item mooshroom_chest;
	public static Item mooshroom_legs;
	public static Item mooshroom_boots;
	
	public static void init() {
		mushroom_leather = new Item().setUnlocalizedName("mushroom_leather").setCreativeTab(BetterMushroom.tabMod);
		raw_shroomeat = new ItemFood(6, 0.6F, true).setUnlocalizedName("raw_shroomeat").setCreativeTab(BetterMushroom.tabMod);
		cooked_shroomeat = new ItemFood(12, 1.2F, true).setUnlocalizedName("cooked_shroomeat").setCreativeTab(BetterMushroom.tabMod);
		int HEAD = Armours.HEAD;
		int BODY = Armours.BODY;
		int LEGS = Armours.LEGS;
		int BOOTS = Armours.BOOTS;
		mooshroom_helm = new Armours(EnumArmour.REDMOOSHROOM, HEAD);
		mooshroom_chest = new Armours(EnumArmour.REDMOOSHROOM, BODY);
		mooshroom_legs = new Armours(EnumArmour.REDMOOSHROOM, LEGS);
		mooshroom_boots = new Armours(EnumArmour.REDMOOSHROOM, BOOTS);
	}
	
	public static void register()
	{
		GameRegistry.registerItem(mushroom_leather, mushroom_leather.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(cooked_shroomeat, cooked_shroomeat.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(raw_shroomeat, raw_shroomeat.getUnlocalizedName().substring(5));
		GameRegistry.addSmelting(raw_shroomeat, new ItemStack(cooked_shroomeat), 1.0F);
        GameRegistry.addRecipe(new ItemStack(mooshroom_helm, 1),
        		    	"AAA",
        		    	"A A",
        		    	'A', mushroom_leather
        );
        GameRegistry.addRecipe(new ItemStack(mooshroom_chest, 1),
        		    	"A A",
        		    	"AAA",
        		    	"AAA",
        		    	'A', mushroom_leather
        );
        GameRegistry.addRecipe(new ItemStack(mooshroom_legs, 1),
        		    	"AAA",
        		    	"A A",
        		    	"A A",
        		    	'A', mushroom_leather
        );
        GameRegistry.addRecipe(new ItemStack(mooshroom_boots, 1),
        		    	"A A",
        		    	"A A",
        		    	'A', mushroom_leather
        );
	}
	
	public static void registerRenders()
	{
		registerRender(mushroom_leather);
		registerRender(cooked_shroomeat);
		registerRender(raw_shroomeat);
		registerRender(mooshroom_helm);
        registerRender(mooshroom_chest);
        registerRender(mooshroom_legs);
        registerRender(mooshroom_boots);
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}