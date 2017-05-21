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
public class FuegoNave extends SpriteAutoMove {

    private static int desplazamientoVertical;

    static {
        desplazamientoVertical = +10;
    }

    public FuegoNave() {
        super("resources/shipshot.png",
                Global.getNave().getX(),
                Global.getNave().getY() + 35, // 35 más para que el fuego salga de la punta de la nave
                10, 15
        );

        setiX(0);
        setiY(desplazamientoVertical);

    }

    @Override
    public void mover() {
        super.mover();
        for (Sprite s : Global.getSprites()) {
            if (s instanceof Alien) {
                Alien alien = ((Alien) s);
                if (alien.ColisionaCon(this)) {
                    alien.eliminar();
                    this.eliminar();
                    break;
                }
            }
        }
        if (getY() > Global.MAX_Y - 30) {
            eliminar();
        }
    }

}
