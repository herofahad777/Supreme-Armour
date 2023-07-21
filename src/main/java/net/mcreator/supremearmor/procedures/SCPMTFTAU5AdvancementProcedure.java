package net.mcreator.supremearmor.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.supremearmor.item.SCPMTFTau5Item;
import net.mcreator.supremearmor.SupremeArmourMod;

import java.util.Map;
import java.util.Iterator;

public class SCPMTFTAU5AdvancementProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SupremeArmourMod.LOGGER.warn("Failed to load dependency entity for procedure SCPMTFTAU5Advancement!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (SCPMTFTau5Item.body == ((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
				: ItemStack.EMPTY).getItem()) {
			if (SCPMTFTau5Item.legs == ((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS)
					: ItemStack.EMPTY).getItem()) {
				if (SCPMTFTau5Item.boots == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof ServerPlayerEntity) {
						Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("supreme_armour:official_mtf_personal"));
						AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemaningCriteria().iterator();
							while (_iterator.hasNext()) {
								String _criterion = (String) _iterator.next();
								((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
							}
						}
					}
				}
			}
		}
	}
}
