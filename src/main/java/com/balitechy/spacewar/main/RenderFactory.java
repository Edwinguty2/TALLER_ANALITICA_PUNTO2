/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.balitechy.spacewar.main;

/**
 *
 * @author Usuario
 */
public interface RenderFactory {
    PlayerRender createPlayerRenderer();
    BulletRender createBulletRenderer();
    BackgroundRender createBackgroundRenderer();
}
