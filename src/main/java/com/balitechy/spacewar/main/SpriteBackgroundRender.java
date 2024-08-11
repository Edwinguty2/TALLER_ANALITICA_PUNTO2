/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Usuario
 */
public class SpriteBackgroundRender implements BackgroundRender {
    
    private BufferedImage background;

    public SpriteBackgroundRender(BufferedImage background) {
        this.background = background;
    }
    
    
    @Override
    public void render(Graphics g, Canvas c) {
        g.drawImage(background, 0, 0, c.getWidth(), c.getHeight(), c);
    }
    
}
