package edu.ufp.inf.lp2.proj;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.ArrayList;

/**
 * Class Avião
 *
 * @author joaoc, tiago
 */
public class Aviao {

    public int id_aviao;

    public String modelo_aviao;

    public String nome_aviao;

    public String companhia_aere;

    public float velocidade_cruzeiro;

    public float altitude_cruzeiro;

    public float distancia_maxima;

    public String codigo_aeroporto;

    public int capacidade_passageiro;

    public int capacidade_deposito;

    public RedBlackBST_Projecto<Date, Voo> vooST = new RedBlackBST_Projecto<>();

    /**
     *
     * @param id_aviao
     * @param modelo_aviao
     * @param nome_aviao
     * @param companhia_aere
     * @param capacidade_passageiro
     * @param altitude_cruzeiro
     * @param distancia_maxima
     * @param codigo_aeroporto
     * @param velocidade_cruzeiro
     * @param capacidade_deposito
     */
    public Aviao(int id_aviao, String modelo_aviao, String nome_aviao, String companhia_aere, float velocidade_cruzeiro, float altitude_cruzeiro, float distancia_maxima, String codigo_aeroporto, int capacidade_passageiro, int capacidade_deposito) {
        this.id_aviao = id_aviao;
        this.modelo_aviao = modelo_aviao;
        this.nome_aviao = nome_aviao;
        this.companhia_aere = companhia_aere;
        this.velocidade_cruzeiro = velocidade_cruzeiro;
        this.altitude_cruzeiro = altitude_cruzeiro;
        this.distancia_maxima = distancia_maxima;
        this.codigo_aeroporto = codigo_aeroporto;
        this.capacidade_passageiro = capacidade_passageiro;
        this.capacidade_deposito = capacidade_deposito;
    }

    /**
     *
     * @return id_aviao
     */
    public int getId_aviao() {
        return id_aviao;
    }

    /**
     *
     * @param id_aviao
     */
    public void setId_aviao(int id_aviao) {
        this.id_aviao = id_aviao;
    }

    /**
     *
     * @return modelo_aviao
     */
    public String getModelo_aviao() {
        return modelo_aviao;
    }

    /**
     *
     * @param modelo_aviao
     */
    public void setModelo_aviao(String modelo_aviao) {
        this.modelo_aviao = modelo_aviao;
    }

    /**
     *
     * @return nome_aviao
     */
    public String getNome_aviao() {
        return nome_aviao;
    }

    /**
     *
     * @param nome_aviao
     */
    public void setNome_aviao(String nome_aviao) {
        this.nome_aviao = nome_aviao;
    }

    /**
     *
     * @return companhia_aere
     */
    public String getCompanhia_aere() {
        return companhia_aere;
    }

    /**
     *
     * @param companhia_aere
     */
    public void setCompanhia_aere(String companhia_aere) {
        this.companhia_aere = companhia_aere;
    }

    /**
     *
     * @return velocidade_cruzeiro
     */
    public float getVelocidade_cruzeiro() {
        return velocidade_cruzeiro;
    }

    /**
     *
     * @param velocidade_cruzeiro
     */
    public void setVelocidade_cruzeiro(float velocidade_cruzeiro) {
        this.velocidade_cruzeiro = velocidade_cruzeiro;
    }

    /**
     *
     * @return altitude_cruzeiro
     */
    public float getAltitude_cruzeiro() {
        return altitude_cruzeiro;
    }

    /**
     *
     * @param altitude_cruzeiro
     */
    public void setAltitude_cruzeiro(float altitude_cruzeiro) {
        this.altitude_cruzeiro = altitude_cruzeiro;
    }

    /**
     *
     * @return distancia_maxima
     */
    public float getDistancia_maxima() {
        return distancia_maxima;
    }

    /**
     *
     * @param distancia_maxima
     */
    public void setDistancia_maxima(float distancia_maxima) {
        this.distancia_maxima = distancia_maxima;
    }

    /**
     *
     * @return codigo_aeroporto
     */
    public String getCodigo_aeroporto() {
        return codigo_aeroporto;
    }

    /**
     *
     * @param codigo_aeroporto
     */
    public void setCodigo_aeroporto(String codigo_aeroporto) {
        this.codigo_aeroporto = codigo_aeroporto;
    }

    /**
     *
     * @return capacidade_passageiro
     */
    public int getN_passageiro() {
        return capacidade_passageiro;
    }

    /**
     *
     * @param n_passageiro
     */
    public void setN_passageiro(int n_passageiro) {
        this.capacidade_passageiro = n_passageiro;
    }

    /**
     *
     * @return capacidade_deposito
     */
    public int getCapacidade_deposito() {
        return capacidade_deposito;
    }

    /**
     *
     * @param capacidade_deposito
     */
    public void setCapacidade_deposito(int capacidade_deposito) {
        this.capacidade_deposito = capacidade_deposito;
    }

    @Override
    public String toString() {
        return "ID: " + id_aviao
                + " Modelo: " + modelo_aviao
                + " Nome: " + nome_aviao
                + " Companhia: " + companhia_aere
                + " Velocidade Cruzeiro: " + velocidade_cruzeiro
                + " Altitude Cruzeiro: " + altitude_cruzeiro
                + " Distancia Maxima: " + distancia_maxima
                + " Codigo Aeroporto: " + codigo_aeroporto
                + " Numero Passageiros: " + capacidade_passageiro
                + " Capacidade do Deposito: " + capacidade_deposito;
    }

    /**
     * Função para criar uma string para gravar nos ficheiros
     *
     * @return String
     */
    public String toStringSave() {
        return id_aviao + ";" + modelo_aviao + ";" + companhia_aere + ";" + velocidade_cruzeiro + ";" + altitude_cruzeiro + ";" + distancia_maxima + ";" + codigo_aeroporto + ";" + capacidade_passageiro + ";" + capacidade_deposito + ";";
    }

    // AVIAO
    /**
     * Função para fazer print dos ArrayLists
     *
     * @param aR
     */
    public static void printArraList(ArrayList<String> aR) {
        for (String ar : aR) {
            StdOut.println(ar.toString());
        }
    }

    /**
     * Funçao para carregar oa Aviões a partir dos ficheiros de texto
     *
     * @param avioesST
     * @param path
     */
    public static void carregarAviao(RedBlackBST_Projecto<Integer, Aviao> avioesST, String path) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            int id_aviao = Integer.parseInt(split[0]);
            String modelo_aviao = split[1];
            String nome_aviao = split[2];
            String companhia_aerea = split[3];
            float velocidade_cruzeiro = Float.parseFloat(split[4]);
            float altitude_cruzeiro = Float.parseFloat(split[5]);
            float distancia_maxima = Float.parseFloat(split[6]);
            String codigo_aeroporto = split[7];
            int n_passageiro = Integer.parseInt(split[8]);
            int capacidade_deposito = Integer.parseInt(split[9]);

            Aviao a = new Aviao(id_aviao, modelo_aviao, nome_aviao, companhia_aerea, velocidade_cruzeiro, altitude_cruzeiro, distancia_maxima, codigo_aeroporto, n_passageiro, capacidade_deposito);
            avioesST.put(id_aviao, a);

        }

    }

    /**
     * Função para gravar Avioes em ficheiros de texto
     *
     * @param avioesST
     * @param path
     * @return String de sucesso
     */
    public static String salvarAviao(RedBlackBST_Projecto<Integer, Aviao> avioesST, String path) {

        Out o = new Out(path);
        for (Integer auxAviao : avioesST.keys()) {
            Aviao a = (Aviao) avioesST.get(auxAviao);
            o.println(a.toStringSave());
        }
        return "SALVOU AVIOES COM SUCESSO !!!";
    }

    /**
     * Função para inserir um Avião
     *
     * @param avioesST
     * @param a
     * @return String de sucesso
     */
    public static String inserirAviao(RedBlackBST_Projecto<Integer, Aviao> avioesST, Aviao a) {
        avioesST.put(a.id_aviao, a);
        return "AVIAO INSERIDO COM SUCESSO !!!";
    }

    /**
     * Validar o id de um avião
     *
     * @param avioesST
     * @param id
     * @return bolean
     */
    public static boolean idAviaoValida(RedBlackBST_Projecto<Integer, Aviao> avioesST, int id) {
        for (int aux : avioesST.keys()) {
            Aviao a = avioesST.get(aux);
            if (a.getId_aviao() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Função para eliminar um Avião
     *
     * @param avioesST
     * @param vooST
     * @param id
     * @return String de sucesso
     */
    public static String removerAviao(RedBlackBST_Projecto<Integer, Aviao> avioesST, RedBlackBST_Projecto<Date, Voo> vooST, int id) {

        for (Integer idAux : avioesST.keys()) {
            Aviao a = (Aviao) avioesST.get(idAux);
            if (id == a.getId_aviao()) {
                avioesST.delete(idAux);
            }
        }
        for (Date dateAux : vooST.keys()) {
            Voo v = (Voo) vooST.get(dateAux);
            if (v.getIdAviao() == id) {
                vooST.delete(dateAux);
            }
        }
        return "AVIAO APAGADO COM SUCESSO !!!";
    }

    /**
     * Função para editar um avião
     *
     * @param a
     * @param update
     * @param op
     * @return String de sucesso
     */
    public static String editarAviao(Aviao a, String update, String op) {

        switch (op) {
            case "1":
                a.setModelo_aviao(update);
                return "CAMPO EDITADO COM SUCESSO";
            case "2":
                a.setNome_aviao(update);
                return "CAMPO EDITADO COM SUCESSO";
            case "3":
                a.setCompanhia_aere(update);
                return "CAMPO EDITADO COM SUCESSO";
            case "4":
                a.setVelocidade_cruzeiro(Float.parseFloat(update));
                return "CAMPO EDITADO COM SUCESSO";
            case "5":
                a.setAltitude_cruzeiro(Float.parseFloat(update));
                return "CAMPO EDITADO COM SUCESSO";
            case "6":
                a.setDistancia_maxima(Float.parseFloat(update));
                return "CAMPO EDITADO COM SUCESSO";
            case "7":
                a.setCodigo_aeroporto(update);
                return "CAMPO EDITADO COM SUCESSO";
            case "8":
                a.setN_passageiro(Integer.parseInt(update));
                return "CAMPO EDITADO COM SUCESSO";
            case "9":
                a.setCapacidade_deposito(Integer.parseInt(update));
                return "CAMPO EDITADO COM SUCESSO";
        }
        return "";
    }

    /**
     * Função para listar aviões
     *
     * @param avioesST
     */
    public static void printAviao(RedBlackBST_Projecto<Integer, Aviao> avioesST) {
        for (Integer id_aviao : avioesST.keys()) {
            Aviao a = (Aviao) avioesST.get(id_aviao);
            StdOut.println(a.toString());
        }
    }

    /**
     * Função para pesquisar aviões a partir do seu id
     *
     * @param avioesST
     * @param id
     * @return Lista de Aviões
     */
    public static ArrayList<String> pesquisaAviaoId(RedBlackBST_Projecto<Integer, Aviao> avioesST, int id) {
        ArrayList<String> res = new ArrayList<>();
        Aviao a = avioesST.get(id);
        if (a.getId_aviao() == id) {
            res.add(a.toString());
        }
        return res;
    }

    /**
     * Função para pesquisar aviões num determinado aeroporto
     *
     * @param avioesST
     * @param cod
     * @return Lista de aviões
     */
    public static ArrayList<String> pesquisaAviaoByAeroporto(RedBlackBST_Projecto<Integer, Aviao> avioesST, String cod) {
        ArrayList<String> res = new ArrayList<>();
        for (Integer aux : avioesST.keys()) {
            Aviao a = avioesST.get(aux);
            if (a.getCodigo_aeroporto().compareTo(cod) == 0) {
                res.add(a.toString());
            }
        }
        return res;
    }

    /**
     * Função para mover um avião de um aeroporto para outro quando ete realiza
     * uma viagem
     *
     * @param avioesST
     * @param origem
     * @param destino
     * @param id
     * @return String de sucesso
     */
    public static String trocaAviao(RedBlackBST_Projecto<Integer, Aviao> avioesST, String origem, String destino, int id) {
        Aviao a = avioesST.get(id);
        if (a.getCodigo_aeroporto().compareTo(origem) == 0) {
            a.setCodigo_aeroporto(destino);
        }
        return "AVIAO TRANSFERIDO PARA AEROPORTO DE DESTINO COM SUCESSO !!!";
    }

    /**
     * Função para verificar se o avião tem capacidade para um determinado
     * numero de passageiros
     *
     * @param avioesST
     * @param nPassaageiro
     * @param id
     * @return boolean
     */
    public static boolean validaPassageiro(RedBlackBST_Projecto<Integer, Aviao> avioesST, int nPassaageiro, int id) {
        Aviao a = avioesST.get(id);
        return a.getN_passageiro() <= nPassaageiro;
    }

    /**
     * Calcula o tempo que um avião demora a fazer uma determinada viagem
     *
     * @param ligacao
     * @return double
     */
    public double calcTempo(DirectedEdge ligacao) {
        return ligacao.weight() / this.velocidade_cruzeiro;
    }

    /**
     * Calcula o comsumo de um avião
     *
     * @param ligacao
     * @return double
     */
    public double calcConsumo(DirectedEdge ligacao) {
        double lphopt = ((LigacaoAerea) ligacao).weight() / 100;
        double lphextra = ((((LigacaoAerea) ligacao).getAltitude() - this.altitude_cruzeiro) * 200);
        return this.calcTempo(ligacao) * (lphopt + Math.abs(this.altitude_cruzeiro - ((LigacaoAerea) ligacao).getAltitude()) / 1000) * lphextra + ((LigacaoAerea) ligacao).getVento() * 20;
    }
}
