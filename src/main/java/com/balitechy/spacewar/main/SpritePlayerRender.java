/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Usuario
 */
public class SpritePlayerRender implements PlayerRender{
    
    private BufferedImage image;

    public SpritePlayerRender(BufferedImage image) {
        this.image = image;
    }


    @Override
    public void render(Graphics g, double x, double y) {
        g.drawImage(image, (int)x, (int)y, null);
    }
    
}
