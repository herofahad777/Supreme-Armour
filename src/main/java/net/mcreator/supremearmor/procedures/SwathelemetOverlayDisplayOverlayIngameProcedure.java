package net.mcreator.supremearmor.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.supremearmor.item.SwatItem;
import net.mcreator.supremearmor.SupremeArmourMod;

import java.util.Map;

public class SwathelemetOverlayDisplayOverlayIngameProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SupremeArmourMod.LOGGER.warn("Failed to load dependency entity for procedure SwathelemetOverlayDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (SwatItem.helmet == ((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD)
				: ItemStack.EMPTY).getItem()) {
			return true;
		}
		return false;
	}
}
