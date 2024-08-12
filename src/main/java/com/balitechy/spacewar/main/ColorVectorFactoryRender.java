/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.balitechy.spacewar.main;

/**
 *
 * @author Usuario
 */
public class ColorVectorFactoryRender implements RenderFactory{

    @Override
    public PlayerRender createPlayerRenderer() {
        return new ColorVectorPlayerRender();
    }

    @Override
    public BulletRender createBulletRenderer() {
        return new ColorVectorBulletRender();
    }

    @Override
    public BackgroundRender createBackgroundRenderer() {
        return new ColorVectorBackgroundRender();
    }
    
}
