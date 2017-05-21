/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import gameframe.Sprite;
import java.awt.Color;
import org.daw1.StdDraw;

/**
 *
 * @author victor
 */
public class Rectangulo extends Sprite {
    
    java.awt.Color color;
    
    public Rectangulo(double x, double y, double ancho, double alto) {
        super(x, y , ancho, alto);
        color = StdDraw.BLACK;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void dibujar() {
        StdDraw.setPenColor(color);
        StdDraw.rectangle(getX(), getY(), getAnchura() / 2 , getAltura() / 2);
    }
}
