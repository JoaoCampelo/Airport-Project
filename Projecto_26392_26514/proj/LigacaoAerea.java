package edu.ufp.inf.lp2.proj;

import edu.princeton.cs.algs4.In;
import java.util.HashMap;

/**
 *
 * @author joaoc, tiago
 */
public class LigacaoAerea extends DirectedEdge {

    private double vento;

    private double altitude;

    /**
     *
     * @param origem
     * @param destino
     * @param distancia
     * @param vento
     * @param altitude
     */
    public LigacaoAerea(int origem, int destino, double distancia, double vento, double altitude) {
        super(origem, destino, distancia);
        this.vento = vento;
        this.altitude = altitude;
    }

    /**
     * @return vento
     */
    public double getVento() {
        return vento;
    }

    /**
     * @param vento
     */
    public void setVento(double vento) {
        this.vento = vento;
    }

    /**
     * @return altitude
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * @param altitude
     */
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        HashMap<Integer, String> hMap = new HashMap<>();
        In in = new In(".//data//hashMapToAirpot.txt");
        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            String value = split[0];
            int key = Integer.parseInt(split[1]);
            hMap.put(key, value);
        }
        return "\t" + hMap.get(super.from()) + "->" + hMap.get(super.to()) + " - {Distance: " + super.weight() + " , Vento: " + this.getVento() + " , Altitude: " + this.getAltitude() + "}\n";
    }

    /**
     * Função para carregar ligaçoes aereas a partir de um ficheiro de texto
     *
     * @param g
     * @param path
     * @return grafo de ligaçoes aereas
     */
    public static EdgeWeightedDigraph carregarLa(EdgeWeightedDigraph g, String path) {
        In in = new In(path);
        int v = Integer.parseInt(in.readLine()); // Numero de Aeroporto
        int w = Integer.parseInt(in.readLine()); // Numero de Ligacoes
        g = new EdgeWeightedDigraph(v);

        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            int origem = Integer.parseInt(split[0]);
            int destino = Integer.parseInt(split[1]);
            double distancia = Double.parseDouble(split[2]);
            double velocidaeVento = Double.parseDouble(split[3]);
            double tunelVento = Double.parseDouble(split[4]);

            g.addEdge(new LigacaoAerea(origem, destino, distancia, velocidaeVento, tunelVento));
        }
        return g;
    }
}
