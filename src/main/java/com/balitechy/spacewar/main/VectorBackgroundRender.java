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
 * @author Asus-PC
 */
public class VectorBackgroundRender implements BackgroundRender {
   
    @Override
    public void render(Graphics g, Canvas c) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        g.setColor(Color.BLACK);
        g.drawOval(50, 50, 100, 100);
    }
}
