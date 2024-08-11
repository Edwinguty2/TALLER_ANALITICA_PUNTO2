/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.balitechy.spacewar.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Usuario
 */
public class SpriteRenderFactory implements RenderFactory{
    
    
    private SpritesImageLoader sprites;
    private BufferedImage backgroundImage;


    public SpriteRenderFactory(SpritesImageLoader sprites) {
        this.sprites = sprites;
    }
    
    @Override
    public PlayerRender createPlayerRenderer() {
        BufferedImage image = sprites.getImage(219, 304, 56, 28);
        return new SpritePlayerRender(image);
    }

    @Override
    public BulletRender createBulletRenderer() {
        BufferedImage image = sprites.getImage(35, 52, 11, 21);
        return new SpriteBulletRender(image);
    }

    @Override
    public BackgroundRender createBackgroundRenderer(){
        SpritesImageLoader bgLoader = new SpritesImageLoader("/bg.png");
        try {
            BufferedImage background = bgLoader.loadImage();
            return new SpriteBackgroundRender(background);
        } catch (IOException e) {
            System.err.println("Failed to create BackgroundRender.");
            return null;
        }

    }
    
}
