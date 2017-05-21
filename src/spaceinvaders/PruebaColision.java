/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import gameframe.Sprite;
import gameframe.SpriteBitmap;
import org.daw1.*;

/**
 *
 * @author victor
 */
public class PruebaColision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        StdDraw.setCanvasSize(800, 600);
        StdDraw.setXScale(0, 800);
        StdDraw.setYScale(0, 600);

        Rectangulo s1 = new Rectangulo(100, 100, 200, 44);
        Rectangulo s2 = new Rectangulo(300, 400, 55, 80);
        s2.setColor(StdDraw.GREEN);
        Alien s3 = new Alien();
        while (true) {
            StdDraw.clear(StdDraw.YELLOW);
            s1.dibujar();
            s2.dibujar();
            s3.dibujar();
            s3.mover();
            if (StdDraw.hasNextKeyTyped()) {
                char k = StdDraw.nextKeyTyped();
                if (k == 'p') {

                    s2.setX(s2.getX() + 1);
                } else if (k == 'o') {
                    s2.setX(s2.getX() - 1);
                } else if (k == 'q') {
                    s2.setY(s2.getY() + 1);
                } else if (k == 'a') {
                    s2.setY(s2.getY() - 1);
                } else if (k == '\u001b') {
                    break;
                }
            }
            if (s2.ColisionaCon(s1) || s2.ColisionaCon(s3)) {
                s2.setColor(StdDraw.RED);
            } else {
                s2.setColor(StdDraw.GREEN);
            }
            StdDraw.show(30);

        }

    }

}
