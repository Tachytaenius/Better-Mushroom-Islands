package wolfboyft.bettermushroom;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import wolfboyft.bettermushroom.init.BetterMushroomItems;
import wolfboyft.bettermushroom.misc.EventHooks;
import wolfboyft.bettermushroom.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class BetterMushroom {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final ModTab tabMod = new ModTab("tabMod");
	
	EventHooks eventhooksVar = new EventHooks();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		BetterMushroomItems.init();
		BetterMushroomItems.register();
		MinecraftForge.EVENT_BUS.register(eventhooksVar);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		proxy.registerRenders();
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		
	}
	
}