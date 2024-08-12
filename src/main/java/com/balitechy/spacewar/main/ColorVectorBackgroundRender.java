/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Usuario
 */
public class ColorVectorBackgroundRender implements BackgroundRender{

    @Override
    public void render(Graphics g, Canvas c) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        g.setColor(Color.GRAY);
        g.fillOval(50, 50, 100, 100);
    }
    
}
