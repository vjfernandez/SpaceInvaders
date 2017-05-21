/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import gameframe.SpriteAutoMove;
import org.daw1.StdDraw;

/**
 *
 * @author victor
 */
public class Alien extends SpriteAutoMove{
    private static int desplazamientoVertical;
    private int maxDesplazamientoHorizontal;
    private int cuentaDesplazamientoHorizontal;

    
    static {
        desplazamientoVertical = -5;
    }
    public Alien() {
        super("resources/ufo.png", 0, 0, 90, 63);
        java.util.Random random = new java.util.Random();
        double x = random.nextInt(Global.MAX_X - 80);
        System.err.println(x);
        double y = Global.MAX_Y - 100 - random.nextInt(Global.MAX_Y / 5) ;
        setX(x);
        setY(y);

        cuentaDesplazamientoHorizontal = 0;
        // vector de movimiento horizontal aleatorio entre 1 y 3
        setiX(random.nextInt(5)+3); 
        maxDesplazamientoHorizontal = random.nextInt(40)+40;
        
        
    }
    
    @Override
    public void mover() {
        super.mover();
        cuentaDesplazamientoHorizontal++;
        //cuando cuentaDesplazamientoHorizontal alcanza maxDesplazamientoHorizontal cambia de direccion
        if (cuentaDesplazamientoHorizontal>maxDesplazamientoHorizontal
                || getX() > Global.MAX_X
                || getX() < 0
                ) {
            cuentaDesplazamientoHorizontal =0;
            setiX(-getiX());
            setY(getY() + desplazamientoVertical);
        } 
        if (this.ColisionaCon(Global.getNave())) {
            Global.getNave().eliminar();
            Global.minusVida();
        }
        
        if (new java.util.Random().nextInt(4000 / (Global.getPuntos() + 1)) == 0) {
            Global.addSprite(new FuegoAlien(this));
        }
    }
   
    @Override
    public void dibujar() {
        super.dibujar();
        if (isEliminado()) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledCircle(getX(), getY(), 30);
        }
    }
    
    public FuegoAlien getFuego() {
        if (new java.util.Random().nextInt(12) == 0 ) {
            return new FuegoAlien(this);
        } else {
            return null;
        }
    }
    
}
