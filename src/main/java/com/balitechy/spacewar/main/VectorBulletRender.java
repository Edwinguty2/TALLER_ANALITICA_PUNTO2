/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Usuario
 */
public class VectorBulletRender implements BulletRender{

    @Override
    public void render(Graphics g, double x, double y) {
        g.setColor(Color.PINK);
        g.drawLine((int)x, (int)y, (int)x, (int)y + 5);
    }
    
}
