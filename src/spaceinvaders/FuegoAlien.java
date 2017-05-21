/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import gameframe.*;

/**
 *
 * @author victor
 */
public class FuegoAlien extends SpriteAutoMove {

    private static int desplazamientoVertical;

    static {
        desplazamientoVertical = -5;
    }

    public FuegoAlien(Alien alien) {
        super("resources/ufoshot.png",
                alien.getX(),
                alien.getY(),
                10, 15
        );

        setiX(0);
        setiY(desplazamientoVertical + new java.util.Random().nextInt(7) - 3);

    }

    @Override
    public void mover() {
        super.mover();
        if (this.ColisionaCon(Global.getNave())) {
            Global.getNave().eliminar();
            Global.minusVida();
            this.eliminar();
        }
        if (getY() < 0) {
            eliminar();
        }
    }

}
