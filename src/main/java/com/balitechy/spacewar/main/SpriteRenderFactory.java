/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.balitechy.spacewar.main;

import java.awt.image.BufferedImage;

/**
 *
 * @author Usuario
 */
public class SpriteRenderFactory implements RenderFactory{
    
    
    private SpritesImageLoader sprites;

    public SpriteRenderFactory(SpritesImageLoader sprites) {
        this.sprites = sprites;
    }
    
    @Override
    public PlayerRender createPlayerRenderer() {
        BufferedImage image = sprites.getImage(219, 304, 30, 30);
        return new SpritePlayerRender(image);
    }

    @Override
    public BulletRender createBulletRenderer() {
        BufferedImage image = sprites.getImage(35, 52, 5, 5);
        return new SpriteBulletRender(image);
    }

    @Override
    public BackgroundRender createBackgroundRenderer(){
        BufferedImage background = sprites.getImage(0, 0, 640, 480);
        return new SpriteBackgroundRender(background);
    }
    
}
