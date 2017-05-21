/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import gameframe.SpriteBitmap;
import org.daw1.StdDraw;

/**
 *
 * @author victor
 */
public class Nave extends SpriteBitmap {
    private int cuentaNaveNueva;
    

    private static final double desplazamiento = 5;

    public Nave() {
        super("resources/ship.png", Global.MAX_X / 2, 40, 48, 70);
        java.util.Random random = new java.util.Random();
        cuentaNaveNueva = 60;
    }
    
    

    public void moverIzquierda() {
        if (getX() > desplazamiento) {
            setX(getX() - desplazamiento);
        }
    }

    public void moverDerecha() {
        if (getX() < Global.MAX_X - desplazamiento) {
            setX(getX() + desplazamiento);
        }
    }

    
    @Override
    public void eliminar() {
        if (cuentaNaveNueva == 0) {
            super.eliminar();
        }
    }
    
    @Override
    public void dibujar() {
        super.dibujar();

        if (cuentaNaveNueva > 0 && cuentaNaveNueva % 2 == 0) {
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.rectangle(getX(), getY(), getAnchura() / 2 + 2, getAltura() / 2 + 2);
        }
        if (isEliminado()) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledCircle(getX(), getY(), 30);
        }
        if (cuentaNaveNueva > 0) {
            cuentaNaveNueva--;
        }        
    }

}
