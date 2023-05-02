// Made with Blockbench 4.7.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelSwat_Helmet extends EntityModel<Entity> {
	private final ModelRenderer Helmet;
	private final ModelRenderer Top;
	private final ModelRenderer cube_r1;
	private final ModelRenderer Left;
	private final ModelRenderer Front;
	private final ModelRenderer Right;
	private final ModelRenderer Back;
	private final ModelRenderer Smoother;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;

	public ModelSwat_Helmet() {
		textureWidth = 64;
		textureHeight = 64;

		Helmet = new ModelRenderer(this);
		Helmet.setRotationPoint(0.0F, 0.0F, 0.0F);

		Top = new ModelRenderer(this);
		Top.setRotationPoint(0.0F, -8.5F, 0.0F);
		Helmet.addChild(Top);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Top.addChild(cube_r1);
		setRotationAngle(cube_r1, -1.5708F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 53).addBox(-5.0F, -5.0F, -0.5F, 10.0F, 10.0F, 1.0F, 0.0F, false);

		Left = new ModelRenderer(this);
		Left.setRotationPoint(-4.75F, -3.5F, 0.0F);
		Helmet.addChild(Left);
		Left.setTextureOffset(0, 51).addBox(-1.25F, -4.5F, -4.0F, 2.0F, 5.0F, 8.0F, 0.0F, false);

		Front = new ModelRenderer(this);
		Front.setRotationPoint(0.0F, -4.0F, -4.75F);
		Helmet.addChild(Front);
		Front.setTextureOffset(46, 55).addBox(-4.0F, -4.0F, -1.25F, 8.0F, 8.0F, 1.0F, 0.0F, false);

		Right = new ModelRenderer(this);
		Right.setRotationPoint(4.75F, -3.5F, 0.0F);
		Helmet.addChild(Right);
		Right.setTextureOffset(0, 51).addBox(-0.75F, -4.5F, -4.0F, 2.0F, 5.0F, 8.0F, 0.0F, false);

		Back = new ModelRenderer(this);
		Back.setRotationPoint(0.0F, -5.5F, 5.0F);
		Helmet.addChild(Back);
		Back.setTextureOffset(0, 57).addBox(-5.0F, -2.5F, -1.0F, 10.0F, 5.0F, 2.0F, 0.0F, false);

		Smoother = new ModelRenderer(this);
		Smoother.setRotationPoint(-0.0035F, -4.7841F, 0.3607F);
		Helmet.addChild(Smoother);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
		Smoother.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.6109F, 3.1416F, 0.0F);
		cube_r2.setTextureOffset(0, 62).addBox(-5.0F, -24.0F, -23.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
		Smoother.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 2.6616F, 0.0F);
		cube_r3.setTextureOffset(0, 57).addBox(-7.0F, -32.0F, -3.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
		Smoother.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.48F, 0.0F);
		cube_r4.setTextureOffset(0, 57).addBox(-7.0F, -32.0F, 1.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
		Smoother.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -0.7679F, 0.0F);
		cube_r5.setTextureOffset(0, 54).addBox(-7.0F, -32.0F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
		Smoother.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -0.7854F, 0.0F);
		cube_r6.setTextureOffset(0, 55).addBox(-1.0F, -32.0F, -7.0F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
		Smoother.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.6109F, 1.5708F, 0.0F);
		cube_r7.setTextureOffset(0, 62).addBox(-4.0F, -24.0F, -23.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
		Smoother.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.6109F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(0, 62).addBox(-4.0F, -24.0F, -23.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0035F, 28.7841F, -0.3607F);
		Smoother.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.6109F, -1.5708F, 0.0F);
		cube_r9.setTextureOffset(0, 62).addBox(-4.0F, -24.0F, -23.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Helmet.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}