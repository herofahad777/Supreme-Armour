
package net.mcreator.supremearmor.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.supremearmor.item.SwatItem;
import net.mcreator.supremearmor.SupremeArmourModElements;

@SupremeArmourModElements.ModElement.Tag
public class SupremeArmourItemGroup extends SupremeArmourModElements.ModElement {
	public SupremeArmourItemGroup(SupremeArmourModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsupreme_armour") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SwatItem.helmet);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
