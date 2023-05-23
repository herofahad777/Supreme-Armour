
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

import net.mcreator.supremearmor.procedures.SwathelemetOverlayDisplayOverlayIngameProcedure;
import net.mcreator.supremearmor.procedures.SwatAdvancementProcedureProcedure;
import net.mcreator.supremearmor.itemgroup.SupremeArmourItemGroup;
import net.mcreator.supremearmor.SupremeArmourModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@SupremeArmourModElements.ModElement.Tag
public class SwatItem extends SupremeArmourModElements.ModElement {
	@ObjectHolder("supreme_armour:swat_helmet")
	public static final Item helmet = null;
	@ObjectHolder("supreme_armour:swat_chestplate")
	public static final Item body = null;
	@ObjectHolder("supreme_armour:swat_leggings")
	public static final Item legs = null;
	@ObjectHolder("supreme_armour:swat_boots")
	public static final Item boots = null;

	public SwatItem(SupremeArmourModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 24;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 10;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.LEATHER), new ItemStack(Items.IRON_INGOT));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "swat";
			}

			@Override
			public float getToughness() {
				return 1f;
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
				armorModel.bipedHead = new ModelSwat_Armor().Helmet;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "supreme_armour:textures/entities/swat_armor_texblack.png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SwathelemetOverlayDisplayOverlayIngameProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}.setRegistryName("swat_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(SupremeArmourItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedBody = new ModelSwat_Armor().Body;
				armorModel.bipedLeftArm = new ModelSwat_Armor().LeftArm;
				armorModel.bipedRightArm = new ModelSwat_Armor().RightArm;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "supreme_armour:textures/entities/swat_armor_texblack.png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SwatAdvancementProcedureProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}.setRegistryName("swat_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(SupremeArmourItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedLeftLeg = new ModelSwat_Armor().LeftLeg;
				armorModel.bipedRightLeg = new ModelSwat_Armor().RightLeg;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "supreme_armour:textures/entities/swat_armor_texblack.png";
			}
		}.setRegistryName("swat_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(SupremeArmourItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedLeftLeg = new ModelSwat_Armor().Leftboot;
				armorModel.bipedRightLeg = new ModelSwat_Armor().Rightboot;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "supreme_armour:textures/entities/swat_armor_texblack.png";
			}
		}.setRegistryName("swat_boots"));
	}

	// Made with Blockbench 4.7.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class ModelSwat_Armor extends EntityModel<Entity> {
		private final ModelRenderer Helmet;
		private final ModelRenderer cube_r1;
		private final ModelRenderer Smoother;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer Body;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer Leftboot;
		private final ModelRenderer Rightboot;
		private final ModelRenderer LeftArm;
		private final ModelRenderer cube_r13;
		private final ModelRenderer RightArm;
		private final ModelRenderer cube_r14;

		public ModelSwat_Armor() {
			textureWidth = 128;
			textureHeight = 128;
			Helmet = new ModelRenderer(this);
			Helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
			Helmet.setTextureOffset(110, 119).addBox(-4.0F, -8.0F, -6.0F, 8.0F, 8.0F, 1.0F, 0.0F, false);
			Helmet.setTextureOffset(0, 119).addBox(-5.0F, -8.0F, 5.0F, 10.0F, 8.0F, 1.0F, 0.0F, false);
			Helmet.setTextureOffset(0, 112).addBox(5.0F, -8.0F, -4.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
			Helmet.setTextureOffset(0, 112).addBox(-6.0F, -8.0F, -4.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -8.5F, 0.0F);
			Helmet.addChild(cube_r1);
			setRotationAngle(cube_r1, -1.5708F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 117).addBox(-5.0F, -5.0F, -0.5F, 10.0F, 10.0F, 1.0F, 0.0F, false);
			Smoother = new ModelRenderer(this);
			Smoother.setRotationPoint(-0.0035F, -4.7841F, 0.3607F);
			Helmet.addChild(Smoother);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
			Smoother.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.6109F, -1.5708F, 0.0F);
			cube_r2.setTextureOffset(0, 126).addBox(-4.0F, -24.0F, -23.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
			Smoother.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.6109F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(0, 126).addBox(-4.0F, -24.0F, -23.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
			Smoother.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.6109F, 1.5708F, 0.0F);
			cube_r4.setTextureOffset(0, 126).addBox(-4.0F, -24.0F, -23.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
			Smoother.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.6109F, 3.1416F, 0.0F);
			cube_r5.setTextureOffset(0, 126).addBox(-5.0F, -24.0F, -23.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
			Smoother.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 2.6616F, 0.0F);
			cube_r6.setTextureOffset(0, 118).addBox(-7.0F, -32.0F, -3.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
			Smoother.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, 0.48F, 0.0F);
			cube_r7.setTextureOffset(0, 118).addBox(-7.0F, -32.0F, 1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
			Smoother.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, -0.7679F, 0.0F);
			cube_r8.setTextureOffset(0, 118).addBox(-7.0F, -32.0F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
			Smoother.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, -0.7854F, 0.0F);
			cube_r9.setTextureOffset(0, 119).addBox(-1.0F, -32.0F, -7.0F, 2.0F, 8.0F, 1.0F, 0.0F, false);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(0.0F, 24.0F, 0.0F);
			Body.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.0F, 3.1416F, 0.0F);
			cube_r10.setTextureOffset(110, 113).addBox(-4.0F, -21.0F, 3.0F, 8.0F, 5.0F, 1.0F, 0.0F, false);
			cube_r10.setTextureOffset(0, 126).addBox(-1.0F, -24.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r10.setTextureOffset(0, 126).addBox(-2.0F, -23.0F, 3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r10.setTextureOffset(0, 126).addBox(-3.0F, -22.0F, 3.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r10.setTextureOffset(0, 115).addBox(-4.0F, -24.0F, 2.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
			cube_r10.setTextureOffset(0, 115).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
			cube_r10.setTextureOffset(0, 124).addBox(0.0F, -15.0F, 3.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r10.setTextureOffset(0, 124).addBox(-4.0F, -15.0F, 3.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r10.setTextureOffset(0, 124).addBox(-4.0F, -15.0F, -4.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r10.setTextureOffset(0, 124).addBox(1.0F, -15.0F, -4.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(1.0F, 24.0F, 0.0F);
			Body.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.0F, 3.1416F, 0.0F);
			cube_r11.setTextureOffset(0, 112).addBox(-4.0F, -24.0F, -2.0F, 1.0F, 12.0F, 4.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(-1.0F, 24.0F, 0.0F);
			Body.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.0F, 3.1416F, 0.0F);
			cube_r12.setTextureOffset(0, 112).addBox(3.0F, -24.0F, -2.0F, 1.0F, 12.0F, 4.0F, 0.0F, false);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			RightLeg.setTextureOffset(0, 114).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 8.0F, 6.0F, 0.0F, false);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			LeftLeg.setTextureOffset(0, 114).addBox(-2.0F, 0.0F, -3.0F, 5.0F, 8.0F, 6.0F, 0.0F, false);
			Leftboot = new ModelRenderer(this);
			Leftboot.setRotationPoint(1.9F, 12.0F, 0.0F);
			Leftboot.setTextureOffset(0, 117).addBox(-3.0F, 7.0F, -3.0F, 7.0F, 5.0F, 6.0F, 0.0F, false);
			Rightboot = new ModelRenderer(this);
			Rightboot.setRotationPoint(-1.9F, 12.0F, 0.0F);
			Rightboot.setTextureOffset(0, 117).addBox(-4.0F, 7.0F, -3.0F, 7.0F, 5.0F, 6.0F, 0.0F, false);
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(-5.0F, 22.0F, 0.0F);
			LeftArm.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.0F, 3.1416F, 0.0F);
			cube_r13.setTextureOffset(0, 112).addBox(-4.0F, -24.0F, -2.0F, 1.0F, 12.0F, 4.0F, 0.0F, false);
			cube_r13.setTextureOffset(0, 111).addBox(-9.0F, -24.0F, -3.0F, 1.0F, 12.0F, 5.0F, 0.0F, false);
			cube_r13.setTextureOffset(0, 115).addBox(-8.0F, -24.0F, -3.0F, 4.0F, 12.0F, 1.0F, 0.0F, false);
			cube_r13.setTextureOffset(0, 121).addBox(-9.0F, -12.0F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
			cube_r13.setTextureOffset(0, 121).addBox(-9.0F, -25.0F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
			cube_r13.setTextureOffset(0, 122).addBox(-10.0F, -19.0F, -2.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r13.setTextureOffset(97, 115).addBox(-9.0F, -24.0F, 2.0F, 5.0F, 12.0F, 1.0F, 0.0F, false);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(5.0F, 22.0F, 0.0F);
			RightArm.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.0F, 3.1416F, 0.0F);
			cube_r14.setTextureOffset(0, 110).addBox(8.0F, -24.0F, -3.0F, 1.0F, 12.0F, 6.0F, 0.0F, false);
			cube_r14.setTextureOffset(0, 112).addBox(3.0F, -24.0F, -2.0F, 1.0F, 12.0F, 4.0F, 0.0F, false);
			cube_r14.setTextureOffset(0, 115).addBox(4.0F, -24.0F, -3.0F, 4.0F, 12.0F, 1.0F, 0.0F, false);
			cube_r14.setTextureOffset(0, 121).addBox(4.0F, -12.0F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
			cube_r14.setTextureOffset(0, 121).addBox(4.0F, -25.0F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
			cube_r14.setTextureOffset(0, 122).addBox(9.0F, -19.0F, -2.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r14.setTextureOffset(86, 115).addBox(4.0F, -24.0F, 2.0F, 4.0F, 12.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Helmet.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			RightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			Leftboot.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			Rightboot.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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
