package edu.ufp.inf.lp2.proj.GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * Classe para desenhar um mapa com as ligaçoes aereas entre aeroportos.
 *
 * @author joaoc, tiago
 */
public class Canvas {

    public static JLabel view;

    public static BufferedImage surface;

    /**
     * Aqui é definido as definiçoes do frame que vai ser criado.
     */
    public Canvas() {
        surface = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        view = new JLabel(new ImageIcon(surface));
        Graphics g = surface.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 600, 400);
        g.dispose();
        view.repaint();
    }

    /**
     * Função para desenhar uma bola que representa um aeroporto.
     *
     * @param x - latitude
     * @param y - longitude
     */
    public static void drawAeroporto(int x, int y) {
        Graphics g = surface.getGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 8, 8);
        g.drawOval(x, y, 8, 8);
        g.dispose();
        view.repaint();
    }

    /**
     * Funçao para desenhar uma linha, que corresponde a ligação entre
     * aeroportos.
     *
     * @param x - latitude do aeroporto de origem
     * @param y - longitude do aeroporto de origem
     * @param xx - latitude do aeroporto de destino
     * @param yy - longitude do aeroporto de destino
     */
    public static void drawLine(int x, int y, int xx, int yy) {
        Graphics g = surface.getGraphics();
        g.setColor(Color.GREEN);
        g.drawLine(x, y, xx, yy);
        g.dispose();
        view.repaint();
    }

    /**
     * Retorna um calculo feito para posicionar a latitude no frame.
     *
     * @param lat
     * @return int
     */
    public static int getLat(Float lat) {
        return 265 + (Math.round(lat) * 2);
    }

    /**
     * Retorna um calculo feito para posicionar a longitude no frame.
     *
     * @param lon
     * @return int
     */
    public static int getLon(Float lon) {
        return 180 + (Math.round(lon) * 3);
    }

    /**
     * Função para desenhar no mapa o nome de cada aeroporto.
     *
     * @param s - codigo do aeroporto
     * @param x - latitude
     * @param y - longitude
     */
    public static void printNome(String s, int x, int y) {
        Graphics g = surface.getGraphics();
        g.setColor(Color.BLACK);
        g.drawString(s, x - 5, y - 3);
    }
}
