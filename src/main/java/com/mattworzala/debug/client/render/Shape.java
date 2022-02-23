package com.mattworzala.debug.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import org.lwjgl.opengl.GL11;

public abstract class Shape {

    public RenderLayer layer = RenderLayer.INLINE;

    public void render(double cameraX, double cameraY, double cameraZ) {
        // Setup
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.disableTexture();
        RenderSystem.enableDepthTest();
        layer.setup();

        render0(cameraX, cameraY, cameraZ);

        // Cleanup
        RenderSystem.depthFunc(GL11.GL_LEQUAL);
        RenderSystem.depthMask(true);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }

    public abstract void render0(double cameraX, double cameraY, double cameraZ);

}
