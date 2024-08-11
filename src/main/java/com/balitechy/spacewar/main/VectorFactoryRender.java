/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.balitechy.spacewar.main;

/**
 *
 * @author Usuario
 */
public class VectorFactoryRender implements RenderFactory{

    @Override
    public PlayerRender createPlayerRenderer() {
        return new VectorPlayerRender();
    }

    @Override
    public BulletRender createBulletRenderer() {
        return new VectorBulletRender();
    }

    @Override
    public BackgroundRender createBackgroundRenderer() {
        return new VectorBackgroundRender();
    }
    
}
