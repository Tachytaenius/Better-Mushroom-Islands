package wolfboyft.bettermushroom.proxy;

import wolfboyft.bettermushroom.init.BetterMushroomItems;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders() {
		BetterMushroomItems.registerRenders();
	}
}
