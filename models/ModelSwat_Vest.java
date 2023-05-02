// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelSwat_Vest extends EntityModel<Entity> {
	private final ModelRenderer Body;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightArm;
	private final ModelRenderer Smoother;

	public ModelSwat_Vest() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(25, 45).addBox(1.0F, 9.0F, -4.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(25, 45).addBox(-4.0F, 9.0F, -4.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(25, 45).addBox(-4.0F, 9.0F, 3.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(26, 46).addBox(0.0F, 9.0F, 3.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 51).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 51).addBox(-4.0F, 0.0F, 2.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(20, 48).addBox(-3.0F, 2.0F, 3.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(23, 48).addBox(-2.0F, 1.0F, 3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(24, 48).addBox(-1.0F, 0.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 45).addBox(-4.0F, 3.0F, 3.0F, 8.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		Body.addChild(LeftArm);
		LeftArm.setTextureOffset(21, 44).addBox(4.0F, 3.0F, -2.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		LeftArm.setTextureOffset(19, 44).addBox(-1.0F, -3.0F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
		LeftArm.setTextureOffset(19, 44).addBox(-1.0F, 10.0F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
		LeftArm.setTextureOffset(54, 51).addBox(-1.0F, -2.0F, -3.0F, 4.0F, 12.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(54, 48).addBox(-2.0F, -2.0F, -2.0F, 1.0F, 12.0F, 4.0F, 0.0F, false);
		LeftArm.setTextureOffset(52, 46).addBox(3.0F, -2.0F, -3.0F, 1.0F, 12.0F, 6.0F, 0.0F, false);
		LeftArm.setTextureOffset(32, 51).addBox(-1.0F, -2.0F, 2.0F, 4.0F, 12.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		Body.addChild(RightArm);
		RightArm.setTextureOffset(21, 44).addBox(-5.0F, 3.0F, -2.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		RightArm.setTextureOffset(19, 44).addBox(-4.0F, -3.0F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
		RightArm.setTextureOffset(19, 44).addBox(-4.0F, 10.0F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
		RightArm.setTextureOffset(54, 51).addBox(-3.0F, -2.0F, -3.0F, 4.0F, 12.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(52, 47).addBox(-4.0F, -2.0F, -3.0F, 1.0F, 12.0F, 5.0F, 0.0F, false);
		RightArm.setTextureOffset(54, 48).addBox(1.0F, -2.0F, -2.0F, 1.0F, 12.0F, 4.0F, 0.0F, false);
		RightArm.setTextureOffset(19, 51).addBox(-4.0F, -2.0F, 2.0F, 5.0F, 12.0F, 1.0F, 0.0F, false);

		Smoother = new ModelRenderer(this);
		Smoother.setRotationPoint(0.0F, 24.0F, 0.0F);

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Smoother.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}