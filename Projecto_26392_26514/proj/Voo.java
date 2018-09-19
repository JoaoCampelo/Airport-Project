package edu.ufp.inf.lp2.proj;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.ArrayList;

/**
 *
 * @author joaoc, tiago
 */
public class Voo {

    public String aeroporto_inicio;

    public String aeroporto_fim;

    public Date data_inicio;

    public Date data_fim;

    public int idAviao;

    public int n_passageiros;

    public double duracaoVoo;

    public double consumoAviao;

    public RedBlackBST_Projecto<Date, Voo> vooST = new RedBlackBST_Projecto<>();

    /**
     *
     * @param aeroporto_inicio
     * @param aeroporto_fim
     * @param data_inicio
     * @param data_fim
     * @param idAviao
     * @param n_passageiros
     * @param duracaoVoo
     * @param consumoAviao
     */
    public Voo(String aeroporto_inicio, String aeroporto_fim, Date data_inicio, Date data_fim, int idAviao, int n_passageiros, double duracaoVoo, double consumoAviao) {
        this.aeroporto_inicio = aeroporto_inicio;
        this.aeroporto_fim = aeroporto_fim;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.idAviao = idAviao;
        this.n_passageiros = n_passageiros;
        this.duracaoVoo = duracaoVoo;
        this.consumoAviao = consumoAviao;
    }

    /**
     *
     * @return aeroporto_inicio
     */
    public String getAeroporto_inicio() {
        return aeroporto_inicio;
    }

    /**
     *
     * @param aeroporto_inicio
     */
    public void setAeroporto_inicio(String aeroporto_inicio) {
        this.aeroporto_inicio = aeroporto_inicio;
    }

    /**
     *
     * @return aeroporto_fim
     */
    public String getAeroporto_fim() {
        return aeroporto_fim;
    }

    /**
     *
     * @param aeroporto_fim
     */
    public void setAeroporto_fim(String aeroporto_fim) {
        this.aeroporto_fim = aeroporto_fim;
    }

    /**
     *
     * @return data_inicio
     */
    public Date getData_inicio() {
        return data_inicio;
    }

    /**
     *
     * @param data_inicio
     */
    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    /**
     *
     * @return data_fim
     */
    public Date getData_fim() {
        return data_fim;
    }

    /**
     *
     * @param data_fim
     */
    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    /**
     *
     * @return idAviao
     */
    public int getIdAviao() {
        return idAviao;
    }

    /**
     *
     * @param idAviao
     */
    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    /**
     *
     * @return n_passageiros
     */
    public int getN_passageiros() {
        return n_passageiros;
    }

    /**
     *
     * @param n_passageiros
     */
    public void setN_passageiros(int n_passageiros) {
        this.n_passageiros = n_passageiros;
    }

    /**
     *
     * @return duracaoVoo
     */
    public double getDuracaoVoo() {
        return duracaoVoo;
    }

    /**
     *
     * @param duracaoVoo
     */
    public void setDuracaoVoo(double duracaoVoo) {
        this.duracaoVoo = duracaoVoo;
    }

    /**
     *
     * @return consumoAviao
     */
    public double getConsumoAviao() {
        return consumoAviao;
    }

    /**
     *
     * @param consumoAviao
     */
    public void setConsumoAviao(double consumoAviao) {
        this.consumoAviao = consumoAviao;
    }

    @Override
    public String toString() {
        return "Origem: " + aeroporto_inicio
                + " Destino: " + aeroporto_fim
                + " Data Inicio: " + data_inicio
                + " Data Fim: " + data_fim
                + " Numero Passageiros: " + n_passageiros
                + " ID Aviao: " + idAviao
                + " Duracao Voo: " + duracaoVoo
                + " Consumo do Aviao: " + consumoAviao;
    }

    /**
     * Cria uma string para guardar nos ficheiros de texto
     *
     * @return String
     */
    public String toStringSave() {
        return aeroporto_inicio + ";" + aeroporto_fim + ";" + ";" + data_inicio + ";" + data_fim + ";" + idAviao + ";" + n_passageiros + ";" + duracaoVoo + ";" + consumoAviao + ";";

    }

    // VOO
    /**
     * Faz print de ArrayLists
     *
     * @param aR
     */
    public static void printArraList(ArrayList<String> aR) {
        for (String ar : aR) {
            StdOut.println(ar.toString());
        }
    }

    /**
     * Função para carregar voos a partir de um ficheiro de texto
     *
     * @param vooST
     * @param path
     */
    public static void carregarVoo(RedBlackBST_Projecto<Date, Voo> vooST, String path) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            String aeroportoInicio = split[0];
            String aeroportoFim = split[1];
            String dataInicio = split[2];
            String dataFim = split[3];
            int idAviao = Integer.parseInt(split[4]);
            int nPassageiros = Integer.parseInt(split[5]);
            double duracao = Double.parseDouble(split[6]);
            double consumo = Double.parseDouble(split[7]);

            Voo aux = new Voo(aeroportoInicio, aeroportoFim, new Date(dataInicio), new Date(dataFim), idAviao, nPassageiros, duracao, consumo);
            vooST.put(aux.getData_inicio(), aux);
        }
    }

    /**
     * Função para gravar os voos no ficheiro de texto
     *
     * @param vooST
     * @param path
     * @return string de sucesso
     */
    public static String salvarVoo(RedBlackBST_Projecto<Date, Voo> vooST, String path) {

        Out o = new Out(path);
        for (Date auxVoo : vooST.keys()) {
            Voo v = (Voo) vooST.get(auxVoo);
            o.println(v.toStringSave());
        }
        return "SALVOU VOOS COM SUCESSO !!!";
    }

    /**
     * Função para inserir um voo
     *
     * @param vooST
     * @param v
     * @return string de sucesso
     */
    public static String inserirVoo(RedBlackBST_Projecto<Date, Voo> vooST, Voo v) {
        vooST.put(v.data_inicio, v);
        return "VOO INSERIDO COM SUCESSO !!!";
    }

    /**
     * Função para verificar se um id de um aviao já existe ou não
     *
     * @param avioesST
     * @param origem
     * @param idAviao
     * @return boolean
     */
    public static boolean vooValidaIdAviao(RedBlackBST_Projecto<Integer, Aviao> avioesST, String origem, int idAviao) {
        for (int aux : avioesST.keys()) {
            Aviao a = avioesST.get(aux);
            if (a.getId_aviao() == idAviao && a.getCodigo_aeroporto().contains(origem)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Função para se existem uma determinada data já existe nos voos
     *
     * @param vooST
     * @param d
     * @return boolean
     */
    public static boolean dataValida(RedBlackBST_Projecto<Date, Voo> vooST, Date d) {
        for (Date dAux : vooST.keys()) {
            Voo v = vooST.get(dAux);
            if (v.getData_inicio().equals(d)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Função para editar um voo, consuante a opçao que passarmos edita o
     * parametro correspondente a essa opção no voo.
     *
     * @param v
     * @param op
     * @param update
     * @return string de sucesso
     */
    public static String editarVoo(Voo v, String op, String update) {
        switch (op) {
            case "1":
                v.setAeroporto_inicio(update);
                return "CAMPO EDITADO COM SUCESSO";
            case "2":
                v.setAeroporto_fim(update);
                return "CAMPO EDITADO COM SUCESSO";
            case "3":
                v.setData_inicio(new Date(update));
                return "CAMPO EDITADO COM SUCESSO";
            case "4":
                v.setData_fim(new Date(update));
                return "CAMPO EDITADO COM SUCESSO";
            case "5":
                v.setIdAviao(Integer.parseInt(update));
                return "CAMPO EDITADO COM SUCESSO";
            case "6":
                v.setN_passageiros(Integer.parseInt(update));
                return "CAMPO EDITADO COM SUCESSO";
        }
        return " ";
    }

    /**
     * Função para eliminar um voo.
     *
     * @param vooST
     * @param dataInicio
     * @return string de sucesso
     */
    public static String removerVoo(RedBlackBST_Projecto<Date, Voo> vooST, Date dataInicio) {
        for (Date dateAux : vooST.keys()) {
            Voo v = (Voo) vooST.get(dateAux);
            if (v.getData_inicio().equals(dataInicio)) {
                vooST.delete(dataInicio);
            }
        }
        return "VOO APAGADO COM SUCESSO !!!";
    }

    /**
     * Função para listar os voos existentes
     *
     * @param vooST
     */
    public static void printVoo(RedBlackBST_Projecto<Date, Voo> vooST) {
        for (Date dataInicio : vooST.keys()) {
            Voo v = (Voo) vooST.get(dataInicio);
            StdOut.println(v.toString());
        }
    }

    /**
     * Função que retorna uma lista de voos com uma determinada origem, ou
     * destino.
     *
     * @param vooST
     * @param val
     * @param org
     * @return lista de voos
     */
    public static ArrayList<String> pesquisarOrigDest(RedBlackBST_Projecto<Date, Voo> vooST, int val, String org) {
        ArrayList<String> res = new ArrayList<>();
        if (val == 1) {
            for (Date aux : vooST.keys()) {
                Voo voo = vooST.get(aux);
                if (voo.getAeroporto_inicio().compareTo(org) == 0) {
                    res.add(voo.toString());
                }
            }
        } else if (val == 2) {
            for (Date aux : vooST.keys()) {
                Voo voo = vooST.get(aux);
                if (voo.getAeroporto_fim().compareTo(org) == 0) {
                    res.add(voo.toString());
                }
            }
        }
        return res;
    }

    /**
     * Função que retorna uma lista com os voos de um determinado avião.
     *
     * @param vooST
     * @param id
     * @return lista de voos
     */
    public static ArrayList<String> pesquisarVooByAviao(RedBlackBST_Projecto<Date, Voo> vooST, int id) {
        ArrayList<String> res = new ArrayList<>();
        for (Date aux : vooST.keys()) {
            Voo v = vooST.get(aux);
            if (v.getIdAviao() == id) {
                res.add(v.toString());
            }
        }
        return res;
    }

    /**
     * Função que retorna uma lista de voos de uma determinada data.
     *
     * @param vooST
     * @param inicio
     * @param fim
     * @return lista de voos
     */
    public static ArrayList<String> pesquisarByDate(RedBlackBST_Projecto<Date, Voo> vooST, Date inicio, Date fim) {
        ArrayList<String> res = new ArrayList<>();
        for (Date aux : vooST.keys()) {
            Voo v = vooST.get(aux);
            if ((v.getData_inicio().compareTo(inicio) > -1 || v.getData_inicio().compareTo(inicio) == 0) && (v.getData_inicio().compareTo(fim) < 1 || v.getData_inicio().compareTo(fim) == 0)) {
                res.add(v.toString());
            }
        }
        return res;
    }

    /**
     * Função que retorna o aeroporto com mais voos.
     *
     * @param vooST
     * @param aeroportoST
     * @return string
     */
    public static String pesquisarTrafego(RedBlackBST_Projecto<Date, Voo> vooST, SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST) {
        int count = 0, auxCount = 0;
        String codAux = "";
        for (String cod_aeroporto : aeroportoST.keys()) {
            Aeroporto a = (Aeroporto) aeroportoST.get(cod_aeroporto);
            count = 0;
            for (Date dataInicio : vooST.keys()) {
                Voo v = (Voo) vooST.get(dataInicio);
                if (v.aeroporto_inicio.compareTo(a.codigo_aeroporto) == 0 || v.aeroporto_fim.compareTo(a.codigo_aeroporto) == 0) {
                    count++;
                }
            }
            if (auxCount < count) {
                auxCount = count;
                codAux = a.codigo_aeroporto;
            }
        }
        return "Codigo Aeroporto: " + codAux + " Trafego Voos: " + auxCount;
    }

    /**
     * Função para pesquisar os voos com mais passageiros.
     *
     * @param vooST
     * @return int
     */
    public static int pesquisarVooByPassageiro(RedBlackBST_Projecto<Date, Voo> vooST) {
        int count = 0;
        ArrayList<Voo> cods = new ArrayList();
        for (Date dataInicio : vooST.keys()) {
            Voo v = (Voo) vooST.get(dataInicio);
            if (v.n_passageiros > count) {
                cods.clear();
                count = v.n_passageiros;
                cods.add(v);
            } else if (count == v.n_passageiros) {
                cods.add(v);
            }
        }
        for (Voo v : cods) {
            StdOut.println(v.toString());
        }
        return count;
    }
}
