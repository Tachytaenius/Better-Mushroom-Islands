package wolfboyft.bettermushroom;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import wolfboyft.bettermushroom.init.BetterMushroomItems;

public class ModTab extends CreativeTabs{

	public ModTab(String label) {
		super(label);
	}
	
	@Override
	public Item getTabIconItem() {
		return BetterMushroomItems.mushroom_leather;
	}
}
