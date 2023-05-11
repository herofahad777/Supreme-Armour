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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
	}
}