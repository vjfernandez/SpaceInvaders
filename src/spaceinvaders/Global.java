/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import gameframe.Sprite;
import java.util.ArrayList;
import java.util.List;
import org.daw1.StdDraw;

/**
 *
 * @author victor
 */
public class Global {

    public static final int MAX_X = 800;
    public static final int MAX_Y = 600;
    private static Nave nave;
    private static List<Sprite> objetos;
    private static List<Sprite> objetosNuevos;
    private static int puntos = 0;
    private static int vidas = 3;

    static {
        inicializar();
    }

    public static void inicializar() {
        objetos = new ArrayList<>();
        objetosNuevos = new ArrayList<>();
        newNave();
    }

    public static void newNave() {
        nave = new Nave();
        addSprite(Global.nave);
    }

    public static List<Sprite> getSprites() {
        return objetos;
    }

    public static Nave getNave() {
        return nave;
    }

    public static void plusPunto() {
        puntos++;
    }

    public static void minusVida() {
        vidas--;
    }

    public static void addSprite(Sprite s) {
        objetosNuevos.add(s);
    }

    public static int getPuntos() {
        return puntos;
    }

    public static int getVidas() {
        return vidas;
    }

    public static void dibujarMarcador() {
        StdDraw.textLeft(0, Global.MAX_Y, String.format("%04d", puntos));
    }

    public static void merge() {
        for (Sprite s : objetosNuevos) {
            objetos.add(s);
        }
        objetosNuevos.clear();
    }

}
