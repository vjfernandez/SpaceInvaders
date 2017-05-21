/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import gameframe.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.daw1.*;

public class Game {
    int numAliens;
    public static final int MAX_CARENCIA_FUEGO_NAVE = 10;

    static int carenciaFuegoNave;

    public void decrementarCarenciaFuegoNave() {
        if (carenciaFuegoNave > 0) {
            carenciaFuegoNave--;
        }
    }

    public void resetearCarenciaFuegoNave() {
        carenciaFuegoNave = MAX_CARENCIA_FUEGO_NAVE;
    }


    public void run() {
        StdDraw.setCanvasSize(Global.MAX_X, Global.MAX_Y);
        StdDraw.setXScale(0, Global.MAX_X);
        StdDraw.setYScale(0, Global.MAX_Y);
        

        numAliens = 0;
        int numAliensInicial = 3;
        int numAliensIncremento = 30;

        while (true) {
            //dibujar
            StdDraw.clear(StdDraw.YELLOW);
            Global.dibujarMarcador();
            for (Sprite s : Global.getSprites()) {
                s.dibujar();
            }
            

            // Quitar eliminados
            Iterator<Sprite> iter = Global.getSprites().iterator();
            while (iter.hasNext()) {
                Sprite next = iter.next();
                if (next.isEliminado()) {
                    iter.remove();
                    if (next instanceof Alien) {
                        numAliens--;
                        Global.plusPunto();
                    }
                    if (next instanceof Nave) {
                        Global.minusVida();
                        Global.newNave();
                    }
                }
            }

            // Añadir aliens
            for (int i = numAliens; i < numAliensInicial + Global.getPuntos() / numAliensIncremento; i++) {
                Global.addSprite(new Alien());
                numAliens++;
            }

           
            //gestionar eventos
            if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_LEFT)) {
                Global.getNave().moverIzquierda();
            }
            if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_RIGHT)) {
                Global.getNave().moverDerecha();
            }
            if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_SPACE)) {
                if (carenciaFuegoNave == 0) {
                    Global.addSprite(new FuegoNave());
                    resetearCarenciaFuegoNave();
                }
            }
            //recalcular modelo
            for (Sprite s : Global.getSprites()) {
                if (s instanceof SpriteAutoMove) {
                    ((SpriteAutoMove) s).mover();
                }
            }
            decrementarCarenciaFuegoNave();
            Global.merge();
            StdDraw.show(30);

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game().run();
    }

}
