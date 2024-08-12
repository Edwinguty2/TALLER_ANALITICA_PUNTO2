/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Asus-PC
 */
public class VectorPlayerRender implements PlayerRender {
    
     @Override
    public void render(Graphics g, double x, double y) {
        g.setColor(Color.BLACK);
        g.drawPolygon(new int[]{(int)x, (int)x + 15, (int)x + 30}, 
                      new int[]{(int)y + 30, (int)y, (int)y + 30}, 3);
    }
}
