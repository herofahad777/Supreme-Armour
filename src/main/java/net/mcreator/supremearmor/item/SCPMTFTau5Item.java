
package net.mcreator.supremearmor.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.supremearmor.procedures.SCPMTFTAU5AdvancementProcedure;
import net.mcreator.supremearmor.itemgroup.SupremeArmourItemGroup;
import net.mcreator.supremearmor.SupremeArmourModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@SupremeArmourModElements.ModElement.Tag
public class SCPMTFTau5Item extends SupremeArmourModElements.ModElement {
	@ObjectHolder("supreme_armour:scpmtf_tau_5_helmet")
	public static final Item helmet = null;
	@ObjectHolder("supreme_armour:scpmtf_tau_5_chestplate")
	public static final Item body = null;
	@ObjectHolder("supreme_armour:scpmtf_tau_5_leggings")
	public static final Item legs = null;
	@ObjectHolder("supreme_armour:scpmtf_tau_5_boots")
	public static final Item boots = null;

	public SCPMTFTau5Item(SupremeArmourModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 35;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{4, 8, 15, 6}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 15;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_diamond"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.DIAMOND));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "scpmtf_tau_5";
			}

			@Override
			public float getToughness() {
				return 2.2f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(SupremeArmourItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedHead = new ModelSCP_MTF_Tau_5_Armour().Head;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "supreme_armour:textures/entities/scp_mtf_tau-5_armour_tex.png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SCPMTFTAU5AdvancementProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}.setRegistryName("scpmtf_tau_5_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(SupremeArmourItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedBody = new ModelSCP_MTF_Tau_5_Armour().Body;
				armorModel.bipedLeftArm = new ModelSCP_MTF_Tau_5_Armour().LeftArm;
				armorModel.bipedRightArm = new ModelSCP_MTF_Tau_5_Armour().RightArm;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "supreme_armour:textures/entities/scp_mtf_tau-5_armour_tex.png";
			}
		}.setRegistryName("scpmtf_tau_5_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(SupremeArmourItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedLeftLeg = new ModelSCP_MTF_Tau_5_Armour().LeftLeg;
				armorModel.bipedRightLeg = new ModelSCP_MTF_Tau_5_Armour().RightLeg;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "supreme_armour:textures/entities/scp_mtf_tau-5_armour_tex.png";
			}
		}.setRegistryName("scpmtf_tau_5_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(SupremeArmourItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedLeftLeg = new ModelSCP_MTF_Tau_5_Armour().LeftBoot;
				armorModel.bipedRightLeg = new ModelSCP_MTF_Tau_5_Armour().RightBoot;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "supreme_armour:textures/entities/scp_mtf_tau-5_armour_tex.png";
			}
		}.setRegistryName("scpmtf_tau_5_boots"));
	}

	// Made with Blockbench 4.7.4
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class ModelSCP_MTF_Tau_5_Armour extends EntityModel<Entity> {
		private final ModelRenderer Head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer Body;
		private final ModelRenderer lighthing;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		private final ModelRenderer cube_r17;
		private final ModelRenderer RightArm;
		private final ModelRenderer cube_r18;
		private final ModelRenderer cube_r19;
		private final ModelRenderer cube_r20;
		private final ModelRenderer cube_r21;
		private final ModelRenderer cube_r22;
		private final ModelRenderer cube_r23;
		private final ModelRenderer cube_r24;
		private final ModelRenderer cube_r25;
		private final ModelRenderer LeftArm;
		private final ModelRenderer cube_r26;
		private final ModelRenderer cube_r27;
		private final ModelRenderer cube_r28;
		private final ModelRenderer cube_r29;
		private final ModelRenderer cube_r30;
		private final ModelRenderer cube_r31;
		private final ModelRenderer cube_r32;
		private final ModelRenderer cube_r33;
		private final ModelRenderer RightLeg;
		private final ModelRenderer cube_r34;
		private final ModelRenderer cube_r35;
		private final ModelRenderer cube_r36;
		private final ModelRenderer cube_r37;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer cube_r38;
		private final ModelRenderer cube_r39;
		private final ModelRenderer cube_r40;
		private final ModelRenderer cube_r41;
		private final ModelRenderer LeftBoot;
		private final ModelRenderer RightBoot;

		public ModelSCP_MTF_Tau_5_Armour() {
			textureWidth = 128;
			textureHeight = 128;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.setTextureOffset(0, 112).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			Head.setTextureOffset(0, 112).addBox(-4.5F, -8.0F, -4.0F, 0.5F, 8.0F, 8.0F, 0.0F, false);
			Head.setTextureOffset(0, 112).addBox(4.0F, -8.0F, -4.0F, 0.5F, 8.0F, 8.0F, 0.0F, false);
			Head.setTextureOffset(4, 116).addBox(4.5F, -7.0F, -3.0F, 0.5F, 6.0F, 6.0F, 0.0F, false);
			Head.setTextureOffset(114, 119).addBox(-2.1F, -4.0F, -5.5F, 4.2F, 0.5F, 0.5F, 0.0F, false);
			Head.setTextureOffset(114, 119).addBox(-2.1F, -5.0F, -5.5F, 4.2F, 1.5F, 0.5F, 0.0F, false);
			Head.setTextureOffset(114, 119).addBox(-2.7F, -6.0F, -5.5F, 5.4F, 0.5F, 0.5F, 0.0F, false);
			Head.setTextureOffset(114, 119).addBox(-2.2F, -5.5F, -5.5F, 4.4F, 0.5F, 0.5F, 0.0F, false);
			Head.setTextureOffset(113, 118).addBox(5.0F, -6.0F, -1.0F, 0.5F, 2.0F, 2.0F, 0.0F, false);
			Head.setTextureOffset(116, 121).addBox(5.0F, -6.0F, 1.0F, 0.5F, 0.7F, 0.5F, 0.0F, false);
			Head.setTextureOffset(116, 121).addBox(5.0F, -6.0F, 1.5F, 0.5F, 0.5F, 0.5F, 0.0F, false);
			Head.setTextureOffset(116, 121).addBox(5.0F, -6.0F, 2.0F, 0.5F, 0.3F, 0.4F, 0.0F, false);
			Head.setTextureOffset(116, 121).addBox(5.0F, -6.0F, 2.4F, 0.5F, 0.2F, 0.6F, 0.0F, false);
			Head.setTextureOffset(116, 121).addBox(-5.5F, -6.0F, 1.0F, 0.5F, 0.7F, 0.5F, 0.0F, false);
			Head.setTextureOffset(116, 121).addBox(-5.5F, -6.0F, 1.5F, 0.5F, 0.5F, 0.5F, 0.0F, false);
			Head.setTextureOffset(116, 121).addBox(-5.5F, -6.0F, 2.0F, 0.5F, 0.3F, 0.4F, 0.0F, false);
			Head.setTextureOffset(116, 121).addBox(-5.5F, -6.0F, 2.4F, 0.5F, 0.2F, 0.6F, 0.0F, false);
			Head.setTextureOffset(113, 118).addBox(-5.5F, -6.0F, -1.0F, 0.5F, 2.0F, 2.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-5.75F, -5.3281F, 1.3085F);
			Head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.3491F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(114, 119).addBox(0.25F, -0.1F, -0.35F, 0.5F, 0.2F, 2.0F, 0.0F, false);
			cube_r1.setTextureOffset(114, 119).addBox(10.75F, -0.1F, -0.35F, 0.5F, 0.2F, 2.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 24.0F, 0.0F);
			Head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, 1.2217F);
			cube_r2.setTextureOffset(114, 119).addBox(-28.9F, -8.0F, -5.5F, 2.4F, 0.5F, 0.5F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 24.0F, 0.0F);
			Head.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.0F, -1.2217F);
			cube_r3.setTextureOffset(114, 119).addBox(26.6F, -8.0F, -5.5F, 2.4F, 0.5F, 0.5F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, -1.5708F);
			cube_r4.setTextureOffset(4, 116).addBox(8.5F, -3.0F, -3.0F, 0.5F, 6.0F, 6.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, -1.5708F, 0.0F);
			cube_r5.setTextureOffset(4, 116).addBox(4.5F, -7.0F, -3.0F, 0.5F, 6.0F, 6.0F, 0.0F, false);
			cube_r5.setTextureOffset(0, 112).addBox(4.0F, -8.0F, -4.0F, 0.5F, 8.0F, 8.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 3.1416F, 0.0F);
			cube_r6.setTextureOffset(4, 116).addBox(4.5F, -7.0F, -3.0F, 0.5F, 6.0F, 6.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, 1.5708F, 0.0F);
			cube_r7.setTextureOffset(4, 116).addBox(4.5F, -7.0F, -3.0F, 0.5F, 6.0F, 6.0F, 0.0F, false);
			cube_r7.setTextureOffset(0, 112).addBox(4.0F, -8.0F, -4.0F, 0.5F, 8.0F, 8.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.addChild(cube_r8);
			setRotationAngle(cube_r8, 1.5708F, 0.0F, -1.5708F);
			cube_r8.setTextureOffset(0, 112).addBox(8.0F, -4.0F, -4.0F, 0.5F, 8.0F, 8.0F, 0.0F, false);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.setTextureOffset(0, 112).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			Body.setTextureOffset(0, 112).addBox(4.0F, 0.0F, -2.0F, 1.0F, 12.0F, 4.0F, 0.0F, false);
			Body.setTextureOffset(0, 112).addBox(-5.0F, 0.0F, -2.0F, 1.0F, 12.0F, 4.0F, 0.0F, false);
			Body.setTextureOffset(0, 115).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(0, 115).addBox(-4.0F, 0.0F, 2.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
			lighthing = new ModelRenderer(this);
			lighthing.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.addChild(lighthing);
			lighthing.setTextureOffset(114, 119).addBox(2.5F, 2.2F, -3.5F, 0.5F, 7.0F, 0.5F, 0.0F, false);
			lighthing.setTextureOffset(114, 119).addBox(-2.9F, 2.0F, -3.5F, 0.5F, 7.0F, 0.5F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(2.0F, 9.0F, 5.0F);
			lighthing.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, 0.0F, -2.7053F);
			cube_r9.setTextureOffset(114, 119).addBox(3.7026F, -4.5968F, -2.0F, 0.5F, 2.0F, 0.5F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(2.0F, 9.0F, 5.0F);
			lighthing.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.0F, 0.0F, -3.1416F);
			cube_r10.setTextureOffset(114, 119).addBox(4.5F, -0.8F, -2.0F, 0.5F, 7.0F, 0.5F, 0.0F, false);
			cube_r10.setTextureOffset(114, 119).addBox(-0.9F, -1.0F, -2.0F, 0.5F, 7.0F, 0.5F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(2.0F, 9.0F, 5.0F);
			lighthing.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.0F, 0.0F, -2.3562F);
			cube_r11.setTextureOffset(114, 119).addBox(7.4F, 0.9F, -2.0F, 0.5F, 4.0F, 0.5F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(2.0F, 9.0F, 5.0F);
			lighthing.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.0F, 0.0F, 2.3562F);
			cube_r12.setTextureOffset(114, 119).addBox(-4.9F, 3.6F, -2.0F, 0.5F, 4.0F, 0.5F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(2.0F, 9.0F, 5.0F);
			lighthing.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.0F, 0.0F, 2.7053F);
			cube_r13.setTextureOffset(114, 119).addBox(-0.5F, -3.0F, -2.0F, 0.5F, 2.0F, 0.5F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(-2.0F, 3.0F, -2.0F);
			lighthing.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.0F, 0.0F, 0.7854F);
			cube_r14.setTextureOffset(114, 119).addBox(7.4F, 0.9F, -1.5F, 0.5F, 4.0F, 0.5F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(-2.0F, 3.0F, -2.0F);
			lighthing.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.0F, 0.0F, -0.7854F);
			cube_r15.setTextureOffset(114, 119).addBox(-4.9F, 3.6F, -1.5F, 0.5F, 4.0F, 0.5F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(-2.0F, 3.0F, -2.0F);
			lighthing.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.0F, 0.0F, -0.4363F);
			cube_r16.setTextureOffset(114, 119).addBox(-0.5F, -3.0F, -1.5F, 0.5F, 2.0F, 0.5F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(2.0F, 2.0F, -2.0F);
			lighthing.addChild(cube_r17);
			setRotationAngle(cube_r17, 0.0F, 0.0F, 0.4363F);
			cube_r17.setTextureOffset(114, 119).addBox(0.5F, -2.0F, -1.5F, 0.5F, 2.0F, 0.5F, 0.0F, false);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			RightArm.setTextureOffset(0, 112).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(-1.0053F, 2.5992F, -2.25F);
			RightArm.addChild(cube_r18);
			setRotationAngle(cube_r18, 0.0F, 0.0F, -0.7854F);
			cube_r18.setTextureOffset(114, 119).addBox(-0.2947F, -3.2992F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(-1.0053F, 7.4276F, -2.25F);
			RightArm.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.0F, 0.0F, -0.7854F);
			cube_r19.setTextureOffset(114, 119).addBox(-0.2947F, -3.1276F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(-1.0053F, 2.5992F, 2.25F);
			RightArm.addChild(cube_r20);
			setRotationAngle(cube_r20, 0.0F, 0.0F, 0.7854F);
			cube_r20.setTextureOffset(114, 119).addBox(-0.2947F, -3.4992F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(-3.25F, 7.2029F, -0.2732F);
			RightArm.addChild(cube_r21);
			setRotationAngle(cube_r21, 0.7854F, 0.0F, 0.0F);
			cube_r21.setTextureOffset(114, 119).addBox(-0.25F, -2.7029F, -0.2268F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(-3.75F, 2.3837F, 0.0281F);
			RightArm.addChild(cube_r22);
			setRotationAngle(cube_r22, 0.7854F, 0.0F, 0.0F);
			cube_r22.setTextureOffset(114, 119).addBox(0.25F, -3.1837F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(1.25F, 2.3837F, 0.0281F);
			RightArm.addChild(cube_r23);
			setRotationAngle(cube_r23, -0.7854F, 0.0F, 0.0F);
			cube_r23.setTextureOffset(114, 119).addBox(-0.25F, -2.8837F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r24 = new ModelRenderer(this);
			cube_r24.setRotationPoint(1.25F, 7.9025F, 0.3312F);
			RightArm.addChild(cube_r24);
			setRotationAngle(cube_r24, -0.7854F, 0.0F, 0.0F);
			cube_r24.setTextureOffset(114, 119).addBox(-0.25F, -3.4025F, -0.8312F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r25 = new ModelRenderer(this);
			cube_r25.setRotationPoint(-0.5262F, 7.9485F, 2.25F);
			RightArm.addChild(cube_r25);
			setRotationAngle(cube_r25, 0.0F, 0.0F, 0.7854F);
			cube_r25.setTextureOffset(114, 119).addBox(-0.9738F, -3.4485F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
			LeftArm.setTextureOffset(0, 112).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			cube_r26 = new ModelRenderer(this);
			cube_r26.setRotationPoint(3.25F, 2.6427F, -0.2309F);
			LeftArm.addChild(cube_r26);
			setRotationAngle(cube_r26, 0.7854F, 0.0F, 0.0F);
			cube_r26.setTextureOffset(114, 119).addBox(-0.25F, -3.25F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r27 = new ModelRenderer(this);
			cube_r27.setRotationPoint(0.9283F, 2.596F, -2.25F);
			LeftArm.addChild(cube_r27);
			setRotationAngle(cube_r27, 0.0F, 0.0F, 0.7854F);
			cube_r27.setTextureOffset(114, 119).addBox(-0.25F, -3.25F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r28 = new ModelRenderer(this);
			cube_r28.setRotationPoint(3.25F, 7.3837F, 0.0281F);
			LeftArm.addChild(cube_r28);
			setRotationAngle(cube_r28, 0.7854F, 0.0F, 0.0F);
			cube_r28.setTextureOffset(114, 119).addBox(-0.25F, -3.25F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r29 = new ModelRenderer(this);
			cube_r29.setRotationPoint(1.0496F, 7.5458F, -2.25F);
			LeftArm.addChild(cube_r29);
			setRotationAngle(cube_r29, 0.0F, 0.0F, 0.7854F);
			cube_r29.setTextureOffset(114, 119).addBox(-0.25F, -3.25F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r30 = new ModelRenderer(this);
			cube_r30.setRotationPoint(-1.25F, 2.4306F, 0.0749F);
			LeftArm.addChild(cube_r30);
			setRotationAngle(cube_r30, -0.7854F, 0.0F, 0.0F);
			cube_r30.setTextureOffset(114, 119).addBox(-0.25F, -3.25F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r31 = new ModelRenderer(this);
			cube_r31.setRotationPoint(1.1393F, 2.3914F, 2.25F);
			LeftArm.addChild(cube_r31);
			setRotationAngle(cube_r31, 0.0F, 0.0F, -0.7854F);
			cube_r31.setTextureOffset(114, 119).addBox(-0.25F, -3.25F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r32 = new ModelRenderer(this);
			cube_r32.setRotationPoint(-1.25F, 7.5734F, 0.13F);
			LeftArm.addChild(cube_r32);
			setRotationAngle(cube_r32, -0.7854F, 0.0F, 0.0F);
			cube_r32.setTextureOffset(114, 119).addBox(-0.25F, -3.25F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			cube_r33 = new ModelRenderer(this);
			cube_r33.setRotationPoint(1.1024F, 7.2963F, 2.25F);
			LeftArm.addChild(cube_r33);
			setRotationAngle(cube_r33, 0.0F, 0.0F, -0.7854F);
			cube_r33.setTextureOffset(114, 119).addBox(-0.25F, -3.25F, -0.25F, 0.5F, 6.5F, 0.5F, 0.0F, false);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			RightLeg.setTextureOffset(0, 114).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.3F, 4.0F, 0.0F, false);
			cube_r34 = new ModelRenderer(this);
			cube_r34.setRotationPoint(3.9F, 18.0F, 3.0F);
			RightLeg.addChild(cube_r34);
			setRotationAngle(cube_r34, 0.0F, 0.0F, 2.3562F);
			cube_r34.setTextureOffset(114, 119).addBox(-8.0F, 11.0F, -1.0F, 0.5F, 4.9F, 0.5F, 0.0F, false);
			cube_r35 = new ModelRenderer(this);
			cube_r35.setRotationPoint(3.9F, 19.0F, 3.0F);
			RightLeg.addChild(cube_r35);
			setRotationAngle(cube_r35, 0.0F, 0.0F, 2.3562F);
			cube_r35.setTextureOffset(114, 119).addBox(-6.0F, 9.0F, -1.0F, 0.5F, 4.9F, 0.5F, 0.0F, false);
			cube_r36 = new ModelRenderer(this);
			cube_r36.setRotationPoint(-0.1F, -9.0F, -2.0F);
			RightLeg.addChild(cube_r36);
			setRotationAngle(cube_r36, 0.0F, 0.0F, 0.7854F);
			cube_r36.setTextureOffset(114, 119).addBox(8.5F, 6.0F, -0.5F, 0.5F, 5.0F, 0.5F, 0.0F, false);
			cube_r37 = new ModelRenderer(this);
			cube_r37.setRotationPoint(-0.1F, -8.0F, -2.0F);
			RightLeg.addChild(cube_r37);
			setRotationAngle(cube_r37, 0.0F, 0.0F, 0.7854F);
			cube_r37.setTextureOffset(114, 119).addBox(10.5F, 8.0F, -0.5F, 0.5F, 5.0F, 0.5F, 0.0F, false);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			LeftLeg.setTextureOffset(0, 112).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.3F, 4.0F, 0.0F, false);
			cube_r38 = new ModelRenderer(this);
			cube_r38.setRotationPoint(0.1F, 18.0F, 3.0F);
			LeftLeg.addChild(cube_r38);
			setRotationAngle(cube_r38, 0.0F, 0.0F, -2.3562F);
			cube_r38.setTextureOffset(114, 119).addBox(10.5F, 8.0F, -1.0F, 0.5F, 5.0F, 0.5F, 0.0F, false);
			cube_r39 = new ModelRenderer(this);
			cube_r39.setRotationPoint(0.1F, 19.0F, 3.0F);
			LeftLeg.addChild(cube_r39);
			setRotationAngle(cube_r39, 0.0F, 0.0F, -2.3562F);
			cube_r39.setTextureOffset(114, 119).addBox(8.5F, 6.0F, -1.0F, 0.5F, 5.0F, 0.5F, 0.0F, false);
			cube_r40 = new ModelRenderer(this);
			cube_r40.setRotationPoint(-3.9F, -9.0F, -2.0F);
			LeftLeg.addChild(cube_r40);
			setRotationAngle(cube_r40, 0.0F, 0.0F, -0.7854F);
			cube_r40.setTextureOffset(114, 119).addBox(-6.0F, 9.0F, -0.5F, 0.5F, 4.9F, 0.5F, 0.0F, false);
			cube_r41 = new ModelRenderer(this);
			cube_r41.setRotationPoint(-3.9F, -8.0F, -2.0F);
			LeftLeg.addChild(cube_r41);
			setRotationAngle(cube_r41, 0.0F, 0.0F, -0.7854F);
			cube_r41.setTextureOffset(114, 119).addBox(-8.0F, 11.0F, -0.5F, 0.5F, 4.9F, 0.5F, 0.0F, false);
			LeftBoot = new ModelRenderer(this);
			LeftBoot.setRotationPoint(1.9F, 12.0F, 0.0F);
			LeftBoot.setTextureOffset(0, 121).addBox(-2.0F, 9.3F, -2.0F, 4.0F, 2.7F, 4.0F, 0.0F, false);
			RightBoot = new ModelRenderer(this);
			RightBoot.setRotationPoint(-1.9F, 12.0F, 0.0F);
			RightBoot.setTextureOffset(0, 121).addBox(-2.0F, 9.3F, -2.0F, 4.0F, 2.7F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			RightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			LeftBoot.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			RightBoot.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}

}
