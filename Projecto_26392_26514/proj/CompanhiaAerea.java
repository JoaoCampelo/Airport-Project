package edu.ufp.inf.lp2.proj;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.ArrayList;

/**
 *
 * @author joaoc, tiago
 */
public class CompanhiaAerea {

    public int id_ca;

    public String nome_ca;

    public String pais_ca;

    /**
     *
     * @param id_ca
     * @param nome_ca
     * @param pais_ca
     */
    public CompanhiaAerea(int id_ca, String nome_ca, String pais_ca) {
        this.id_ca = id_ca;
        this.nome_ca = nome_ca;
        this.pais_ca = pais_ca;
    }

    /**
     *
     * @return id_ca
     */
    public int getId_ca() {
        return id_ca;
    }

    /**
     *
     * @param id_ca
     */
    public void setId_ca(int id_ca) {
        this.id_ca = id_ca;
    }

    /**
     *
     * @return nome_ca
     */
    public String getNome_ca() {
        return nome_ca;
    }

    /**
     *
     * @param nome_ca
     */
    public void setNome_ca(String nome_ca) {
        this.nome_ca = nome_ca;
    }

    /**
     *
     * @return pais_ca
     */
    public String getPais_ca() {
        return pais_ca;
    }

    /**
     *
     * @param pais_ca
     */
    public void setPais_ca(String pais_ca) {
        this.pais_ca = pais_ca;
    }

    @Override
    public String toString() {
        return "Nome Companhia: " + nome_ca
                + " Pais Companhia: " + pais_ca;
    }

    /**
     * Cria uma string para gravar nos ficheiros de texto
     *
     * @return String
     */
    public String toStringSave() {
        return +id_ca + ";" + nome_ca + ";" + pais_ca + ";";
    }

    /**
     * Fução para fazer print de ArrayLists
     *
     * @param aR
     */
    public static void printArraList(ArrayList<String> aR) {
        for (String ar : aR) {
            StdOut.println(ar.toString());
        }
    }

    // COMPANHIA AEREA
    /**
     * Carrega as companhias aereas existentes num ficheiro de texto
     *
     * @param caST
     * @param path
     */
    public static void carragarCompanhia(SeparateChainingHashST_Projecto<Integer, CompanhiaAerea> caST, String path) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            Integer idCa = Integer.parseInt(split[0]);
            String nomeCa = split[1];
            String paisCa = split[2];

            CompanhiaAerea c = new CompanhiaAerea(idCa, nomeCa, paisCa);
            caST.put(idCa, c);
        }

    }

    /**
     * Função para gravar as companhias aereas em ficheiros de texto
     *
     * @param caST
     * @param path
     * @return String de sucesso
     */
    public static String salvarCompanhia(SeparateChainingHashST_Projecto<Integer, CompanhiaAerea> caST, String path) {

        Out o = new Out(path);
        for (Integer idaux : caST.keys()) {
            CompanhiaAerea c = (CompanhiaAerea) caST.get(idaux);
            o.println(c.toStringSave());
        }
        return "SALVOU COMPANHIA AEREA COM SUCESSO !!!";
    }

    /**
     * Função para inserir uma companhia aerea
     *
     * @param caST
     * @param ca
     * @return String de sucesso
     */
    public static String inserirCompanhia(SeparateChainingHashST_Projecto<Integer, CompanhiaAerea> caST, CompanhiaAerea ca) {
        caST.put(ca.id_ca, ca);
        return "COMPANHIA AEREA INSERIDA COM SUCESSO !!!";
    }

    /**
     * Função para editar uma companhia aerea
     *
     * @param ca
     * @param update
     * @param op
     * @return String de sucesso
     */
    public static String editarCompanhia(CompanhiaAerea ca, String update, String op) {
        switch (op) {
            case "1":
                ca.setNome_ca(update);
                return "CAMPO EDITADO COM SUCESSO";
            case "2":
                ca.setPais_ca(update);
                return "CAMPO EDITADO COM SUCESSO";
        }
        return "";
    }

    /**
     * Função para remover uma companhia aerea
     *
     * @param caST
     * @param id
     * @return String de sucesso
     */
    public static String removerCompanhia(SeparateChainingHashST_Projecto<Integer, CompanhiaAerea> caST, Integer id) {
        for (Integer idaux : caST.keys()) {
            CompanhiaAerea c = (CompanhiaAerea) caST.get(idaux);
            if (id == c.getId_ca()) {
                caST.delete(idaux);
            }
        }
        return "COMPANHIA AEREA APAGADA COM SUCESSO !!!";
    }

    /**
     * Função para listar as companhias aereas
     *
     * @param caST
     */
    public static void printCompanhia(SeparateChainingHashST_Projecto<Integer, CompanhiaAerea> caST) {
        for (Integer idaux : caST.keys()) {
            CompanhiaAerea c = (CompanhiaAerea) caST.get(idaux);
            StdOut.println(c.toString());
        }
    }

    /**
     * Função para validar se existe ou não uma companhia aerea com um
     * determinado nome
     *
     * @param caST
     * @param nome
     * @return booblean
     */
    public static boolean nomeCAvalida(SeparateChainingHashST_Projecto<Integer, CompanhiaAerea> caST, String nome) {
        for (int aux : caST.keys()) {
            CompanhiaAerea c = caST.get(aux);
            if (c.getNome_ca().contains(nome)) {
                return true;
            }
        }
        return false;
    }
}
