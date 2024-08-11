package com.balitechy.spacewar.main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Usuario
 */
public class SpriteBulletRender implements BulletRender{
    private BufferedImage image;

    public SpriteBulletRender(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void render(Graphics g, double x, double y) {
        g.drawImage(image, (int)x, (int)y, null);
    }
}
