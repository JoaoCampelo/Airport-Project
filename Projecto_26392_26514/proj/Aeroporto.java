package edu.ufp.inf.lp2.proj;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class Aeroporto
 *
 * @author joaoc, tiago
 */
public class Aeroporto implements Serializable {

    public int idAeroporto;

    public String nome_aeroporto;

    public String codigo_aeroporto;

    public String cidade;

    public String pais;

    public String continente;

    public Float classificao_aeroporto;

    public Float longitude;

    public Float latitude;

    public RedBlackBST_Projecto<Integer, Aviao> aeroportoByAviaoST = new RedBlackBST_Projecto<>();

    /**
     *
     * @param idAeroporto
     * @param nome_aeroporto
     * @param codigo_aeroporto
     * @param cidade
     * @param pais
     * @param continente
     * @param classificao_aeroporto
     * @param longitude
     * @param latitude
     */
    public Aeroporto(int idAeroporto, String nome_aeroporto, String codigo_aeroporto, String cidade, String pais, String continente, Float classificao_aeroporto, Float longitude, Float latitude) {
        this.idAeroporto = idAeroporto;
        this.nome_aeroporto = nome_aeroporto;
        this.codigo_aeroporto = codigo_aeroporto;
        this.cidade = cidade;
        this.pais = pais;
        this.continente = continente;
        this.classificao_aeroporto = classificao_aeroporto;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     *
     * @return idAeroporto
     */
    public int getIdAeroporto() {
        return idAeroporto;
    }

    /**
     *
     * @param idAeroporto
     */
    public void setIdAeroporto(int idAeroporto) {
        this.idAeroporto = idAeroporto;
    }

    /**
     *
     * @return nome_aeroporto
     */
    public String getNome_aeroporto() {
        return nome_aeroporto;
    }

    /**
     *
     * @param nome_aeroporto
     */
    public void setNome_aeroporto(String nome_aeroporto) {
        this.nome_aeroporto = nome_aeroporto;
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
     * @return cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     *
     * @param cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     *
     * @return pais
     */
    public String getPais() {
        return pais;
    }

    /**
     *
     * @param pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     *
     * @return continente
     */
    public String getContinente() {
        return continente;
    }

    /**
     *
     * @param continente
     */
    public void setContinente(String continente) {
        this.continente = continente;
    }

    /**
     *
     * @return classificao_aeroporto
     */
    public Float getClassificao_aeroporto() {
        return classificao_aeroporto;
    }

    /**
     *
     * @param classificao_aeroporto
     */
    public void setClassificao_aeroporto(Float classificao_aeroporto) {
        this.classificao_aeroporto = classificao_aeroporto;
    }

    @Override
    public String toString() {
        return "Codigo Aeroporto: " + codigo_aeroporto
                + " Nome Aeroporto: " + nome_aeroporto
                + " Cidade: " + cidade
                + " Pais: " + pais
                + " Continente: " + continente
                + " Classificacao: " + classificao_aeroporto;
    }

    /**
     * Função para criar uma string para encrever nos ficheiros
     *
     * @return
     */
    public String toStringSave() {
        return idAeroporto + ";" + nome_aeroporto + ";" + codigo_aeroporto + ";" + cidade + ";" + pais + ";" + continente + ";" + classificao_aeroporto + ";" + longitude + ";" + latitude + ";";
    }

    // AEROPORTO
    /**
     * Função para fazer print de ArrayLists
     *
     * @param aR
     */
    public static void printArraList(ArrayList<String> aR) {
        for (String ar : aR) {
            StdOut.println(ar.toString());
        }
    }

    /**
     * Função para carregar aeroportos a partir de ficheiros de texto
     *
     * @param aeroportoST
     * @param path
     */
    public static void carragarAeroporto(SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST, String path) {

        In in = new In(path);
        while (!in.isEmpty()) {
            String[] split = in.readLine().split(";");
            int idAeroporto = Integer.parseInt(split[0]);
            String nome_aeroporto = split[1];
            String codigo_aeroporto = split[2];
            String cidade = split[3];
            String pais = split[4];
            String continente = split[5];
            float classificacao = Float.parseFloat(split[6]);
            float longitude = Float.parseFloat(split[7]);
            float latitude = Float.parseFloat(split[8]);

            Aeroporto a = new Aeroporto(idAeroporto, nome_aeroporto, codigo_aeroporto, cidade, pais, continente, classificacao, longitude, latitude);
            aeroportoST.put(codigo_aeroporto, a);
        }
    }

    /* public static void carregaavioaobyaeroporto(SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST, int idAviao, Aviao a, String codAero) {
       
        Aeroporto aero = aeroportoST.get(codAero);
        aero.getAeroportoByAviaoST().put(idAviao, a);
    }*/
    /**
     * Função para guardar aeroportos em ficheiros, tanto ficheiros de texto
     * como binarios
     *
     * @param aeroportoST
     * @param path
     * @return string de sucesso
     */
    public static String salvarAeroporto(SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST, String path) {

        Out o = new Out(path);
        for (String auxAero : aeroportoST.keys()) {
            Aeroporto aero = (Aeroporto) aeroportoST.get(auxAero);
            o.println(aero.toStringSave());
        }

        try {
            File file = new File(".//data//binAero.bin");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream dos = new ObjectOutputStream(fos);

            for (String aeroporto : aeroportoST.keys()) {
                System.out.println("entrei");
                dos.writeObject(aeroporto);
            }
            dos.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return "SALVOU AEROPORTOS COM SUCESSO !!!";
    }

    /**
     * Função para inserir aeroportos
     *
     * @param aeroportoST
     * @param a
     * @return String de sucesso
     */
    public static String inserirAeroporto(SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST, Aeroporto a) {

        aeroportoST.put(a.codigo_aeroporto, a);
        return "AEROPORTO INSERIDO COM SUCESSO !!!";
    }

    /**
     * Função para validar codigos de aeroportos
     *
     * @param aeroportoST
     * @param codAero
     * @return boolean
     */
    public static boolean codAeroValida(SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST, String codAero) {

        for (String codAux : aeroportoST.keys()) {
            Aeroporto a = aeroportoST.get(codAux);
            if (a.getCodigo_aeroporto().equals(codAero)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Função para editar um aeroporto
     *
     * @param a
     * @param update
     * @param op
     * @return String de successo
     */
    public static String editarAeroporto(Aeroporto a, String update, String op) {

        switch (op) {
            case "1":
                a.setNome_aeroporto(update);
                return "CAMPO EDITADO COM SUCESSO";
            case "2":
                a.setClassificao_aeroporto(Float.parseFloat(update));
                return "CAMPO EDITADO COM SUCESSO";
        }
        return "";
    }

    /**
     * Função para eliminar aeroportos
     *
     * @param aeroportoST
     * @param vooST
     * @param codAero
     * @return String de sucesso
     */
    public static String removerAeroporto(SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST, RedBlackBST_Projecto<Date, Voo> vooST, String codAero) {

        for (String codAux : aeroportoST.keys()) {
            Aeroporto a = (Aeroporto) aeroportoST.get(codAux);
            if (a.getCodigo_aeroporto().equals(codAero)) {
                aeroportoST.delete(codAux);
            }
        }
        for (Date dateAux : vooST.keys()) {
            Voo v = (Voo) vooST.get(dateAux);
            if (v.getAeroporto_inicio().equals(codAero) || v.getAeroporto_fim().equals(codAero)) {
                vooST.delete(dateAux);
            }
        }
        return "AEROPORTO " + codAero + " APAGADO COM SUCESSO !!!";

    }

    /**
     * Função para listar os aeroportos
     *
     * @param aeroportoST
     */
    public static void printAeroporto(SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST) {

        for (String cod_aeroporto : aeroportoST.keys()) {
            Aeroporto a = (Aeroporto) aeroportoST.get(cod_aeroporto);
            StdOut.println(a.toString());
        }
    }

    /**
     * Função para validar se existe um determinado codigo de um pais
     *
     * @param aeroportoST
     * @param pais
     * @return bolean
     */
    public static boolean codPaisValida(SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST, String pais) {

        for (String paisAux : aeroportoST.keys()) {
            Aeroporto a = aeroportoST.get(paisAux);
            if (a.getPais().equals(paisAux)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Função para pesquisar quais os aeroportos de um determinado ais
     *
     * @param aeroportoST
     * @param pais
     * @return Lista de aeroportos
     */
    public static ArrayList<String> pesquisarAeroportoByPais(SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST, String pais) {

        ArrayList<String> res = new ArrayList<>();
        for (String aux : aeroportoST.keys()) {
            Aeroporto a = aeroportoST.get(aux);
            if (a.getPais().contentEquals(pais)) {
                //StdOut.println(a.toString());
                res.add(a.toString());
            }
        }
        return res;
    }

    /**
     * Função para pesquisarr o aeroporto com mais trafego passageiros
     *
     * @param vooST
     * @param aeroportoST
     * @return String de sucesso
     */
    public static String pesquisarAeroportoByPassageiro(RedBlackBST_Projecto<Date, Voo> vooST, SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST) {

        int count = 0, auxCount = 0;
        String codAux = "";
        for (String cod_aeroporto : aeroportoST.keys()) {
            Aeroporto a = (Aeroporto) aeroportoST.get(cod_aeroporto);
            count = 0;
            for (Date dataInicio : vooST.keys()) {
                Voo v = (Voo) vooST.get(dataInicio);
                if (v.aeroporto_inicio.compareTo(a.codigo_aeroporto) == 0 || v.aeroporto_fim.compareTo(a.codigo_aeroporto) == 0) {

                    count = count + v.getN_passageiros();
                }
            }
            if (auxCount < count) {

                auxCount = count;
                codAux = a.codigo_aeroporto;
            }
        }
        return "Codigo Aeroporto: " + codAux + " Trafego Passageiros: " + auxCount;
    }

    /**
     * Função para Gravar um historico de aeroportos eliminados
     *
     * @param aeroportoST
     * @param codAero
     * @param path
     * @return String de sucesso
     */
    public static String saveHistoricoAeroporto(SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST, String codAero, String path) {

        Out o = new Out(path);
        for (String codAux : aeroportoST.keys()) {
            Aeroporto a = (Aeroporto) aeroportoST.get(codAux);
            if (a.getCodigo_aeroporto().equals(codAero)) {
                o.println(a.toStringSave());
            }
        }
        return "SALVOU HISTORICO AEROPORTO " + codAero + " COM SUCESSO !!!";
    }

    /**
     * @return the longitude
     */
    public Float getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public Float getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}
