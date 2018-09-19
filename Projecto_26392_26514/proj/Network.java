package edu.ufp.inf.lp2.proj;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.io.IOException;
import java.util.Scanner;
import edu.ufp.inf.lp2.proj.LigacaoAerea;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;

/**
 *
 * @author joaoc, tiago
 */
public class Network {

    /**
     * Declaração das tabelas de hash nocessarias
     */
    public static SeparateChainingHashST_Projecto<String, Aeroporto> aeroportoST = new SeparateChainingHashST_Projecto<>();

    public static RedBlackBST_Projecto<Integer, Aviao> avioesST = new RedBlackBST_Projecto<>();

    public static RedBlackBST_Projecto<Date, Voo> vooST = new RedBlackBST_Projecto<>();

    public static SeparateChainingHashST_Projecto<Integer, CompanhiaAerea> caST = new SeparateChainingHashST_Projecto<>();

    /**
     * Nesta classe é onde temos todas as opçoes do projeto, utilizaçoes menus
     * para escolher o que queremos fazer, e consoante o que pretendemos pedimos
     * dados e chamamos as funçoes necessarias que estão nas outras classes.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        /**
         * Carregar ST's a partir dos ficheiros
         */
        Aeroporto.carragarAeroporto(aeroportoST, ".//data//aeroporto.txt");
        Aviao.carregarAviao(avioesST, ".//data//aviao.txt");
        Voo.carregarVoo(vooST, ".//data//voo.txt");

        /**
         * MENU PRINCIPAL
         */
        Scanner sca = new Scanner(System.in);
        Network n = new Network();

        String op;
        do {
            StdOut.printf("\t\t -----> NETWORK <-----\n");
            StdOut.printf(" [1] -> AEROPORTO\n");
            StdOut.printf(" [2] -> AVIAO\n");
            StdOut.printf(" [3] -> VOO\n");
            StdOut.printf(" [4] -> COMPANHIA AEREA\n");
            StdOut.printf(" [S] -> SAIR\n");
            StdOut.printf("OP: ");
            op = sca.nextLine();
            switch (op) {
                case "1":
                    n.menuAeroporto();
                    break;
                case "2":
                    n.menuAviao();
                    break;
                case "3":
                    n.menuVoo();
                    break;
                case "4":
                    n.menuCa();
                    break;
                case "s":
                case "S":
                    break;
                default:
                    StdOut.printf("Opcao Errada!!!\n");
            }
        } while (!"s".equals(op) && !"S".equals(op));
    }

    /**
     * MENU AEROPORTO
     */
    @SuppressWarnings("empty-statement")
    public void menuAeroporto() {
        Scanner s = new Scanner(System.in);
        String op;
        do {

            StdOut.println("\t\t -----> AEROPORTO <-----\n");
            StdOut.printf(" [1] -> Inserir Aeroporto\n");
            StdOut.printf(" [2] -> Editar Aeroporto\n");
            StdOut.printf(" [3] -> Remover Aeroporto\n");
            StdOut.printf(" [4] -> Listar Aeroporto\n");
            StdOut.printf(" [5] -> Pesquisa Aeroporto\n");
            StdOut.printf(" [6] -> Salvar Aeroporto\n");
            StdOut.printf(" [V] -> Voltar\n");
            StdOut.printf("OP: ");
            op = s.nextLine();
            switch (op) {
                case "1":
                    Scanner aeroScan = new Scanner(System.in);
                    int idAux = 0;

                    for (String paisAux : aeroportoST.keys()) {
                        Aeroporto a = aeroportoST.get(paisAux);
                        if (a.getIdAeroporto() > idAux) {
                            idAux = a.getIdAeroporto();
                        }
                    }
                    idAux += 1;
                    StdOut.println("id = " + idAux);
                    StdOut.println("\t\t -----> INSERIR AEROPORTO <-----\n");
                    StdOut.printf("Nome Aeroporto: ");
                    String nome_aeroporto = aeroScan.nextLine();
                    StdOut.printf("Codigo Aeroporto: ");
                    String codigo_aeroporto = aeroScan.nextLine();

                    while (Aeroporto.codAeroValida(aeroportoST, codigo_aeroporto) == true) {
                        StdOut.println("\nCODIGO DO AEROPORTO JA ESXITE");
                        StdOut.printf("\nNovo Codigo Aeroporto: ");
                        codigo_aeroporto = aeroScan.nextLine();
                    }

                    StdOut.printf("Cidade: ");
                    String cidade = aeroScan.nextLine();
                    StdOut.printf("Pais: ");
                    String pais = aeroScan.nextLine();
                    StdOut.printf("Continente: ");
                    String continente = aeroScan.nextLine();
                    StdOut.printf("Classificacao (0a10): ");
                    float classificacao = Float.parseFloat(aeroScan.nextLine());
                    while (classificacao > 10 || classificacao < 0) {
                        StdOut.println("\nCLASSIFCACAO ENTRE 0 a 10");
                        StdOut.printf("Classificacao (0a10): ");
                        classificacao = Float.parseFloat(aeroScan.nextLine());;

                    }
                    StdOut.printf("Longitude: ");
                    float longitude = Float.parseFloat(aeroScan.nextLine());
                    StdOut.printf("Latitude: ");
                    float latitude = Float.parseFloat(aeroScan.nextLine());
                    Aeroporto a = new Aeroporto(idAux, nome_aeroporto, codigo_aeroporto, cidade, pais, continente, classificacao, longitude, latitude);
                    StdOut.println("MENSAGEM: " + Aeroporto.inserirAeroporto(aeroportoST, a));
                    break;

                case "2":
                    Scanner sa = new Scanner(System.in);
                    String update;
                    String oP = "";
                    StdOut.print("Editar Aeroporto (Cod Aeroporto): ");
                    String codaero = sa.nextLine();
                    while (Aeroporto.codAeroValida(aeroportoST, codaero) == false) {
                        StdOut.println("\nCODIGO DO AEROPORTO NAO ESXITE");
                        StdOut.print("Editar Aeroporto (Cod Aeroporto): ");
                        codaero = sa.nextLine();
                    }
                    Aeroporto aUp = (Aeroporto) aeroportoST.get(codaero);
                    if (aUp.getCodigo_aeroporto().contains(codaero)) {
                        do {
                            StdOut.println("\t\t -----> EDITAR AEROPORTO <-----\n");
                            StdOut.printf(" [1] -> Nome Aeroporto \n");
                            StdOut.printf(" [2] -> Classificacao Aeroporto\n");
                            StdOut.printf(" [V] -> Voltar\n");
                            StdOut.printf("OP: ");
                            oP = sa.nextLine();
                            switch (oP) {
                                case "1":
                                    StdOut.printf("Novo Nome Aeroporto: ");
                                    update = sa.nextLine();
                                    StdOut.println("MENSAGEM: " + Aeroporto.editarAeroporto(aUp, update, oP));
                                    break;
                                case "2":

                                    StdOut.printf("Nova Classificacao Aeroporto(0 a 10): ");
                                    update = sa.nextLine();
                                    int idUp = Integer.parseInt(update);
                                    while (idUp > 10 || idUp < 0) {
                                        StdOut.println("\nCLASSIFCACAO ENTRE 0 a 10");
                                        StdOut.printf("Nova Classificacao Aeroporto(0 a 10): ");
                                        update = sa.nextLine();
                                        idUp = Integer.parseInt(update);
                                    }
                                    StdOut.println("MENSAGEM: " + Aeroporto.editarAeroporto(aUp, update, oP));
                                    break;
                                case "v":
                                case "V":
                                    break;
                                default:
                                    StdOut.printf("Opcao Errada!!!\n");
                            }
                        } while (!"v".equals(oP) && !"V".equals(oP));
                    }
                    break;
                case "3":
                    Scanner sca = new Scanner(System.in);

                    StdOut.println("\t\t -----> ELIMINAR AEROPORTO <-----\n");
                    System.out.printf("Eliminar Aeroporto (codAero): ");
                    String codAero = sca.nextLine();
                    while (Aeroporto.codAeroValida(aeroportoST, codAero) == false) {
                        StdOut.printf("\nCODIGO DO AEROPORTO NAO ESXITE");
                        StdOut.printf("\nEliminar Aeroporto (codAero): ");
                        codAero = sca.nextLine();
                    }

                    StdOut.printf("\nGuardar Historio do Aeroporto(Y/N): ");
                    String v = sca.nextLine();
                    if (v.contains("y") || v.contains("Y")) {
                        String path = ".//data//historico//aeroporto//" + codAero + ".txt";
                        StdOut.println("MENSAGEM: " + Aeroporto.saveHistoricoAeroporto(aeroportoST, codAero, path));
                    }
                    StdOut.println("MENSAGEM: " + Aeroporto.removerAeroporto(aeroportoST, vooST, codAero));
                    break;
                case "4":
                    StdOut.println("\t\t -----> LISTAR AEROPORTO <-----\n");
                    Aeroporto.printAeroporto(aeroportoST);
                    break;
                case "5":
                    do {
                        StdOut.println("\t\t -----> PESQUISA AEROPORTO <-----\n");
                        StdOut.printf(" [1] -> Por Pais\n");
                        StdOut.printf(" [2] -> Por Tragego\n");
                        StdOut.printf(" [3] -> Por Aeroporto (Avioes)\n");
                        StdOut.printf(" [V] -> Voltar\n");
                        StdOut.printf("OP: ");
                        op = s.nextLine();
                        switch (op) {
                            case "1":
                                Scanner p = new Scanner(System.in);
                                StdOut.printf("Pais: ");
                                String paisAux = p.nextLine();
                                while (Aeroporto.codPaisValida(aeroportoST, paisAux) == false) {
                                    StdOut.println("\nPAIS NAO ESXITE");
                                    StdOut.printf("\nPAIS: ");
                                    paisAux = p.nextLine();
                                }
                                Aeroporto.printArraList(Aeroporto.pesquisarAeroportoByPais(aeroportoST, paisAux));
                                break;
                            case "2":
                                StdOut.println("MENSAGEM: " + Aeroporto.pesquisarAeroportoByPassageiro(vooST, aeroportoST));
                                break;
                            case "3":
                                Scanner scan = new Scanner(System.in);
                                System.out.printf("Codigo Aeroporto: ");
                                String cod_aero = scan.nextLine();
                                while (Aeroporto.codAeroValida(aeroportoST, cod_aero) == false) {
                                    StdOut.printf("\nCODIGO DO AEROPORTO NAO ESXITE");
                                    StdOut.printf("\nCodigo Aeroporto: ");
                                    cod_aero = scan.nextLine();
                                }
                                break;
                            case "v":
                            case "V":
                                break;
                            default:
                                StdOut.printf("Opcao Errada!!!\n");
                        }
                    } while (!"v".equals(op) && !"V".equals(op));
                    break;
                case "6":
                    StdOut.println("MENSAGEM: " + Aeroporto.salvarAeroporto(aeroportoST, ".//data//aeroporto.txt"));
                    break;
                case "v":
                case "V":
                    break;
                default:
                    StdOut.printf("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));
    }

    /**
     * MENU AVIÃO
     */
    public void menuAviao() {
        Scanner s = new Scanner(System.in);
        String op;
        do {

            StdOut.println("\t\t -----> AVIAO <-----\n");
            StdOut.printf(" [1] -> Inserir Aviao\n");
            StdOut.printf(" [2] -> Editar Aviao\n");
            StdOut.printf(" [3] -> Remover Aviao\n");
            StdOut.printf(" [4] -> Listar Aviao\n");
            StdOut.printf(" [5] -> Pesquisa Aviao\n");
            StdOut.printf(" [6] -> Salvar Aviao\n");
            StdOut.printf(" [V] -> Voltar\n");
            StdOut.printf("OP: ");
            op = s.nextLine();
            switch (op) {
                case "1":
                    Scanner aeroScan = new Scanner(System.in);
                    int id_aviao = avioesST.get(avioesST.size() - 1).getId_aviao() + 1;
                    StdOut.println("\t\t -----> NOVO AVIAO <-----");
                    StdOut.print("Nome Aviao: ");
                    String nome_aviao = aeroScan.nextLine();
                    StdOut.print("Modelo Aviao: ");
                    String modelo_aviao = aeroScan.nextLine();
                    StdOut.print("Companhia Aerea: ");
                    String ca = aeroScan.nextLine();
                    StdOut.print("Velocidae Cruzeiro: ");
                    float velocidade_cruzeiro = Float.parseFloat(aeroScan.nextLine());
                    StdOut.print("Altitude Cruzeiro: ");
                    float altitude_cruzeiro = Float.parseFloat(aeroScan.nextLine());
                    StdOut.print("Distancia Maxima: ");
                    float distancia_maxima = Float.parseFloat(aeroScan.nextLine());
                    StdOut.print("Codigo Aeroporto: ");
                    String codaero = aeroScan.nextLine();

                    while (Aeroporto.codAeroValida(aeroportoST, codaero) == false) {
                        StdOut.println("\nCODIGO DO AEROPORTO NAO ESXITE");
                        StdOut.print("Codigo Aeroporto: ");
                        codaero = aeroScan.nextLine();
                    }

                    StdOut.print("Numero de passageiros: ");
                    int n_passageiros = Integer.parseInt(aeroScan.nextLine());
                    StdOut.print("Capacidade de Deposito: ");
                    int capacidade_deposito = Integer.parseInt(aeroScan.nextLine());
                    Aviao a = new Aviao(id_aviao, modelo_aviao, nome_aviao, ca, velocidade_cruzeiro, altitude_cruzeiro, distancia_maxima, codaero, n_passageiros, capacidade_deposito);
                    StdOut.println("MENSAGEM: " + Aviao.inserirAviao(avioesST, a));
                    break;
                case "2":
                    Scanner sca = new Scanner(System.in);
                    String update;
                    String val;
                    System.out.println("Editar AVIAO(ID AVIAO): ");
                    int idAux = Integer.parseInt(sca.nextLine());
                    while (Aviao.idAviaoValida(avioesST, idAux) == false) {
                        StdOut.println("\nID DO AVIAO NAO ESXITE" + "(" + avioesST.max() + ")");
                        StdOut.print("\nNovo ID Aviao: ");
                        idAux = Integer.parseInt(sca.nextLine());
                    }
                    Aviao av = (Aviao) avioesST.get(idAux);
                    if (av.getId_aviao() == idAux) {
                        do {
                            StdOut.println("\t\t -----> EDITAR AVIAO <-----\n");
                            StdOut.printf(" [1] -> Modelo Aviao \n");
                            StdOut.printf(" [2] -> Nome Aviao\n");
                            StdOut.printf(" [3] -> Companhia Aerea\n");
                            StdOut.printf(" [4] -> Velocidade Cruzeiro\n");
                            StdOut.printf(" [5] -> Altitude Cruzeiro\n");
                            StdOut.printf(" [6] -> Distancia Maxima\n");
                            StdOut.printf(" [7] -> Codigo Aeroporto\n");
                            StdOut.printf(" [8] -> Capacidade Passageiro\n");
                            StdOut.printf(" [9] -> Capacidade Deposito\n");
                            StdOut.printf(" [V] -> Voltar\n");
                            StdOut.printf("OP: ");
                            val = sca.nextLine();

                            switch (val) {
                                case "1":
                                    StdOut.printf("Novo Modelo Aviao: ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + Aviao.editarAviao(av, update, val));
                                    break;
                                case "2":
                                    StdOut.printf("Novo Nome Aviao: ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + Aviao.editarAviao(av, update, val));
                                    break;
                                case "3":
                                    StdOut.printf("Nova Companhia Aerea: ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + Aviao.editarAviao(av, update, val));
                                    break;
                                case "4":
                                    StdOut.printf("Nova Velocidade Cruzeiro: ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + Aviao.editarAviao(av, update, val));
                                    break;
                                case "5":
                                    StdOut.printf("Nova Altitude Cruzeiro: ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + Aviao.editarAviao(av, update, val));
                                    break;
                                case "6":
                                    StdOut.printf("Nova Distancia Maxima: ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + Aviao.editarAviao(av, update, val));
                                    break;
                                case "7":
                                    StdOut.printf("Novo Codigo Aeroporto: ");
                                    update = sca.nextLine();
                                    while (Aeroporto.codAeroValida(aeroportoST, update) == false) {
                                        StdOut.println("\nCODIGO DO AEROPORTO NAO ESXITE");
                                        StdOut.printf("Codigo Aeroporto: ");
                                        update = sca.nextLine();
                                    }
                                    StdOut.println("MENSAGEM: " + Aviao.editarAviao(av, update, val));
                                    break;
                                case "8":
                                    StdOut.printf("Nova Capacidade Passageiro: ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + Aviao.editarAviao(av, update, val));
                                    break;
                                case "9":
                                    StdOut.printf("Nova Capacidade Deposito: ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + Aviao.editarAviao(av, update, val));
                                    break;
                                case "v":
                                case "V":
                                    break;
                                default:
                                    StdOut.printf("Opcao Errada!!!\n");
                            }
                        } while (!"v".equals(val) && !"V".equals(val));
                    }

                case "3":
                    Scanner sc = new Scanner(System.in);
                    StdOut.println("\t\t -----> ELIMINAR AVIAO <-----\n");
                    System.out.printf("Eliminar Aviao(ID): ");
                    int id = sc.nextInt();
                    while (Aviao.idAviaoValida(avioesST, id) == false) {
                        StdOut.println("\nID DO AVIAO NAO ESXITE" + "(" + avioesST.max() + ")");
                        StdOut.printf("\nNovo ID Aviao: ");
                        id = Integer.parseInt(sc.nextLine());
                    }
                    StdOut.println("MENSAGEM: " + Aviao.removerAviao(avioesST, vooST, id));
                    break;
                case "4":
                    StdOut.println("\t\t -----> LISTAR AVIAO <-----\n");
                    Aviao.printAviao(avioesST);
                    break;
                case "5":
                    do {
                        StdOut.println("\t\t -----> PESQUISAR AVIAO <-----\n");
                        StdOut.printf(" [1] -> Por Id\n");
                        StdOut.printf(" [2] -> Por Aeroporto\n");
                        StdOut.printf(" [V] -> Voltar\n");
                        StdOut.printf("[OP]: ");
                        op = s.nextLine();
                        switch (op) {
                            case "1":
                                Scanner scanId = new Scanner(System.in);
                                System.out.printf("ID Aviao: ");
                                id = scanId.nextInt();
                                while (Aviao.idAviaoValida(avioesST, id) == false) {
                                    StdOut.println("\nID DO AVIAO NAO ESXITE" + "(" + avioesST.max() + ")");
                                    StdOut.printf("\nNovo ID Aviao: ");
                                    id = Integer.parseInt(scanId.nextLine());
                                }
                                Aviao.printArraList(Aviao.pesquisaAviaoId(avioesST, id));
                                break;
                            case "2":
                                Scanner scaCod = new Scanner(System.in);
                                System.out.println("Codigo Aeroporto: ");
                                String codAero = scaCod.nextLine();
                                while (Aeroporto.codAeroValida(aeroportoST, codAero) == false) {
                                    StdOut.printf("\nCODIGO DO AEROPORTO NAO ESXITE");
                                    StdOut.printf("\nEliminar Aeroporto (codAero): ");
                                    codAero = scaCod.nextLine();
                                }
                                Aviao.printArraList(Aviao.pesquisaAviaoByAeroporto(avioesST, codAero));
                                break;
                        }
                    } while (!"v".equals(op) && !"V".equals(op));
                    break;
                case "6":
                    StdOut.println("MENSAGEM: " + Aviao.salvarAviao(avioesST, ".//data//aviao.txt"));
                    break;
                case "v":
                case "V":
                    break;
                default:
                    StdOut.printf("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));

    }

    /**
     * MENU VOO
     */
    public void menuVoo() {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(0);
        g = LigacaoAerea.carregarLa(g, ".//data//la.txt");

        Scanner s = new Scanner(System.in);
        String op;
        do {

            StdOut.println("\t\t -----> VOO <-----\n");
            StdOut.printf(" [1] -> Inserir Voo\n");
            StdOut.printf(" [2] -> Editar Voo\n");
            StdOut.printf(" [3] -> Remover Voo\n");
            StdOut.printf(" [4] -> Listar Voo\n");
            StdOut.printf(" [5] -> Pesquisa Voo\n");
            StdOut.printf(" [6] -> Salvar Voo\n");
            StdOut.printf(" [V] -> Voltar\n");
            StdOut.printf("OP: ");
            op = s.nextLine();
            switch (op) {

                case "1":
                    Scanner conf = new Scanner(System.in);
                    Scanner vooScan = new Scanner(System.in);
                    StdOut.println("\t\t -----> NOVO VOO <-----");
                    StdOut.print("Origem: ");
                    String origem = vooScan.nextLine();
                    while (Aeroporto.codAeroValida(aeroportoST, origem) == false) {
                        StdOut.println("\nCODIGO DO AEROPORTO DE ORIGEM NAO ESXITE");
                        StdOut.print("Nova ORIGEM: ");
                        origem = vooScan.nextLine();
                    }
                    int idOrigem = aeroportoST.get(origem).idAeroporto;
                    StdOut.print("Destino: ");
                    String destino = vooScan.nextLine();
                    while (Aeroporto.codAeroValida(aeroportoST, destino) == false || destino.contains(origem)) {
                        StdOut.println("\nCODIGO DO AEROPORTO DE DESTINO NAO ESXITE OU IGUAL A ORIGEM");
                        StdOut.print("Novo DESTINO: ");
                        destino = vooScan.nextLine();
                    }
                    int idDestino = aeroportoST.get(destino).idAeroporto;
                    /* 
                    
                    if (((LigacaoAerea)ligacao).from() == idOrigem && ((LigacaoAerea)ligacao).to() == idDestino) {
                        StdOut.println("\nLIGACAO ENTRE AEROPORTO DE ORIGEM E DESTINO NAO ESXITE");
                        StdOut.println("NOVA LIGACAO AEREA: ");
                            StdOut.print("Distancia: ");
                            double dist = conf.nextDouble();
                            StdOut.print("Velocidade Vento: ");
                            double vVento = conf.nextDouble();
                            StdOut.print("Tunel Vento: ");
                            double tVento = conf.nextDouble();
                            g.addEdge(new LigacaoAerea(idOrigem, idDestino, dist, vVento, tVento));
                        
                    }*/
                    StdOut.print("Data Inicio (dd/mm/yyyy hh:mm): ");
                    Date dataInicio = new Date(vooScan.nextLine());
                    StdOut.print("Data Fim (dd/mm/yyyy hh:mm): ");
                    Date dataFim = new Date(vooScan.nextLine());
                    while (dataFim.compareTo(dataInicio) <= 0) {
                        StdOut.println("\nDATA DE FIM INCORRECTA");
                        StdOut.print("Nova Data Fim (dd/mm/yyyy hh:mm): ");
                        dataFim = new Date(vooScan.nextLine());
                    }
                    StdOut.print("Id Aviao: ");
                    int idAviao = Integer.parseInt(vooScan.nextLine());
                    while (Voo.vooValidaIdAviao(avioesST, origem, idAviao) == false) {
                        StdOut.println("\nESSE AVIAO NAO EXITE NO AEROPORTO DE ORIGEM\n");
                        Aviao.printArraList(Aviao.pesquisaAviaoByAeroporto(avioesST, origem));
                        StdOut.print("Novo ID: ");
                        idAviao = Integer.parseInt(vooScan.nextLine());
                    }
                    StdOut.print("Numero de Passageiros: ");
                    int nPassageiros = Integer.parseInt(vooScan.nextLine());
                    while (Aviao.validaPassageiro(avioesST, nPassageiros, idAviao) == true) {
                        StdOut.println("\nESSE AVIAO NAO TEM CAPACIDADE\n");
                        Aviao.printArraList(Aviao.pesquisaAviaoByAeroporto(avioesST, origem));
                        StdOut.println("Numero de Passageiros: ");
                        nPassageiros = Integer.parseInt(vooScan.nextLine());
                    }

                    Aviao aviao = avioesST.get(idAviao);

                    DijkstraSP duracao = new DijkstraSP(g, idDestino, aviao, "Duracao");
                    DijkstraSP consumo = new DijkstraSP(g, idDestino, aviao, "Consumo");
                    DijkstraSP distancia = new DijkstraSP(g, idDestino, aviao, " ");
                    double resDistancia = distancia.distTo(idOrigem);
                    double resDuracao = duracao.distTo(idOrigem);
                    double resConsumo = consumo.distTo(idOrigem);
                    Voo v = new Voo(origem, destino, dataInicio, dataFim, idAviao, nPassageiros, resDuracao, resConsumo);
                    StdOut.println("MENSAGEM: " + Voo.inserirVoo(vooST, v));
                    StdOut.println("MENSAGEM: " + Aviao.trocaAviao(avioesST, origem, destino, idAviao));
                    StdOut.println("MENSAGEM: " + "Duracao Voo: " + resDuracao + " Consumo Aviao: " + resConsumo + "(l/h)" + " Distancia Voo: " + resDistancia + "KM");
                    StdOut.println("MENSAGEM: + RAPIDO " + duracao.pathTo(idOrigem));
                    break;

                case "2":

                    Scanner sca = new Scanner(System.in);
                    String val;
                    String update;
                    System.out.println("Editar VOO(DATA INICIO): ");
                    Date dataInicioUp = new Date(sca.nextLine());
                    while (Voo.dataValida(vooST, dataInicioUp) == false) {
                        StdOut.println("\nDATA DO VOO NAO ESXITE");
                        StdOut.print("Editar VOO(DATA INICIO): ");
                        dataInicioUp = new Date(sca.nextLine());
                    }
                    Voo vo = (Voo) vooST.get(dataInicioUp);
                    if (vo.getData_inicio().equals(dataInicioUp)) {
                        do {
                            StdOut.println("\t\t -----> EDITAR VOO <-----\n");
                            StdOut.printf(" [1] -> Origem Voo \n");
                            StdOut.printf(" [2] -> Destino Voo\n");
                            StdOut.printf(" [3] -> Velocidade do Vento \n");
                            StdOut.printf(" [4] -> Data Inicial \n");
                            StdOut.printf(" [5] -> Data Final \n");
                            StdOut.printf(" [6] -> Id do Aviao \n");
                            StdOut.printf(" [7] -> Numero de passageiros\n");
                            StdOut.printf(" [V] -> Voltar\n");
                            StdOut.printf("OP: ");
                            val = sca.nextLine();
                            switch (val) {

                                case "1":
                                    StdOut.printf("Novo Aeroporto Inicio: ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + Voo.editarVoo(vo, op, update));
                                    break;
                                case "2":
                                    StdOut.printf("Novo Aeroporto Fim: ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + Voo.editarVoo(vo, op, update));
                                    break;
                                case "3":
                                    StdOut.printf("Nova Data Inicio(dd/mm/yyy hh:mm): ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + Voo.editarVoo(vo, op, update));
                                    break;
                                case "4":
                                    StdOut.printf("Nova Data Fim(dd/mm/yyy hh:mm): ");
                                    Date dF = new Date(sca.nextLine());
                                    while (vo.data_inicio.afterDate(dF) == true || vo.data_inicio.equals(dF)) {
                                        StdOut.println("\nDATA DE FIM INCORRECTA");
                                        StdOut.printf("Nova Data Fim (dd/mm/yyyy hh:mm): ");
                                        dF = new Date(sca.nextLine());
                                    }
                                    StdOut.println("MENSAGEM: " + Voo.editarVoo(vo, op, dF.toString()));
                                    break;

                                case "5":
                                    StdOut.printf("Novo Id Aviao: ");
                                    update = sca.nextLine();
                                    while (Voo.vooValidaIdAviao(avioesST, vo.getAeroporto_inicio(), Integer.parseInt(update)) == false) {
                                        StdOut.println("\nESSE AVIAO NAO EXITE NO AEROPORTO DE ORIGEM\n");
                                        Aviao.pesquisaAviaoByAeroporto(avioesST, vo.getAeroporto_inicio());
                                        StdOut.printf("Novo ID: ");
                                        update = sca.nextLine();
                                    }
                                    StdOut.println("MENSAGEM: " + Voo.editarVoo(vo, op, update));
                                    break;

                                case "6":
                                    StdOut.printf("Novo Numero Passageiros: ");
                                    update = sca.nextLine();
                                    while (Aviao.validaPassageiro(avioesST, Integer.parseInt(update), vo.getIdAviao()) == false) {
                                        StdOut.println("\nESSE AVIAO NAO TEM CAPACIDADE\n");
                                        Aviao.printArraList(Aviao.pesquisaAviaoByAeroporto(avioesST, vo.getAeroporto_inicio()));
                                        StdOut.printf("Novo Numero Passageiros: ");
                                        update = sca.nextLine();
                                    }
                                    StdOut.println("MENSAGEM: " + Voo.editarVoo(vo, op, update));
                                    break;

                                case "v":
                                case "V":
                                    break;
                                default:
                                    StdOut.printf("Opcao Errada!!!\n");
                            }
                        } while (!"v".equals(val) && !"V".equals(val));
                    }

                    break;

                case "3":
                    Scanner sc = new Scanner(System.in);
                    System.out.printf("Eliminar VOO(DATA INICIO): ");
                    Date dataI = new Date(sc.nextLine());
                    while (Voo.dataValida(vooST, dataI) == false) {
                        StdOut.println("\nDATA DO VOO NAO ESXITE");
                        StdOut.printf("Eliminar VOO(DATA INICIO): ");
                        dataI = new Date(sc.nextLine());
                    }
                    StdOut.println("MENSAGEM: " + Voo.removerVoo(vooST, dataI));
                    break;

                case "4":
                    StdOut.println("\t\t -----> LISTAR VOOS <-----\n");
                    Voo.printVoo(vooST);
                    break;

                case "5":
                    Scanner ss = new Scanner(System.in);
                    do {
                        StdOut.println("\t\t -----> PESQUISAR VOO <-----\n");
                        StdOut.printf(" [1] -> Por Origem\n");
                        StdOut.printf(" [2] -> Por Destino\n");
                        StdOut.printf(" [3] -> Por Id Aviao\n");
                        StdOut.printf(" [4] -> Por Data\n");
                        StdOut.printf(" [5] -> Por Trafego\n");
                        StdOut.printf(" [6] -> Por Passageiros\n");
                        StdOut.printf(" [V] -> Voltar\n");
                        StdOut.printf("OP: ");
                        op = s.nextLine();
                        switch (op) {

                            case "1":

                                StdOut.printf("Origem: ");
                                String org = ss.nextLine();
                                while (Aeroporto.codAeroValida(aeroportoST, org) == false) {
                                    StdOut.println("\nCODIGO DO AEROPORTO DE ORIGEM NAO ESXITE");
                                    StdOut.printf("Origem: ");
                                    org = ss.nextLine();
                                }
                                Voo.printArraList(Voo.pesquisarOrigDest(vooST, 1, org));
                                break;

                            case "2":

                                StdOut.printf("Destino: ");
                                org = ss.nextLine();
                                while (Aeroporto.codAeroValida(aeroportoST, org) == false) {
                                    StdOut.println("\nCODIGO DO AEROPORTO DE DESTINO NAO ESXITE");
                                    StdOut.printf("Destino: ");
                                    org = ss.nextLine();
                                }
                                Voo.printArraList(Voo.pesquisarOrigDest(vooST, 2, org));
                                break;

                            case "3":

                                System.out.printf("Id Aviao: ");
                                int id = Integer.parseInt(ss.nextLine());
                                while (Aviao.idAviaoValida(avioesST, id) == false) {
                                    StdOut.println("\nID DO AVIAO NAO ESXITE");
                                    StdOut.printf("\nId Aviao: ");
                                    id = Integer.parseInt(ss.nextLine());
                                }
                                Voo.printArraList(Voo.pesquisarVooByAviao(vooST, id));
                                break;

                            case "4":

                                System.out.printf("Data Inicio: ");
                                Date datai = new Date(ss.nextLine());
                                while (Voo.dataValida(vooST, datai) == false) {
                                    StdOut.println("\nDATA DO VOO NAO ESXITE");
                                    StdOut.printf("Data Inicio: ");
                                    datai = new Date(ss.nextLine());
                                }
                                System.out.printf("Data Fim: ");
                                Date dataf = new Date(ss.nextLine());
                                while (Voo.dataValida(vooST, dataf) == false) {
                                    StdOut.println("\nDATA DO VOO NAO ESXITE");
                                    StdOut.printf("Data Fim: ");
                                    dataf = new Date(ss.nextLine());
                                }
                                Voo.printArraList(Voo.pesquisarByDate(vooST, datai, dataf));
                                break;

                            case "5":
                                StdOut.println("MENSAGEM: " + Voo.pesquisarTrafego(vooST, aeroportoST));
                                break;

                            case "6":
                                StdOut.println("MENSAGEM: NUMERO DE PASSAGEIROS " + Voo.pesquisarVooByPassageiro(vooST));
                                break;
                            case "v":
                            case "V":
                                break;
                            default:
                                StdOut.printf("Opcao Errada!!!\n");
                        }
                    } while (!"v".equals(op) && !"V".equals(op));
                    break;
                case "6":
                    StdOut.println("MENSAGEM: " + Voo.salvarVoo(vooST, ".//data//voo.txt"));
                    break;
                case "v":
                case "V":
                    break;
                default:
                    StdOut.printf("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));
    }

    public void menuCa() {
        Scanner s = new Scanner(System.in);
        String op;
        do {

            StdOut.println("\t\t -----> COMPANHIA AEREA <-----\n");
            StdOut.printf(" [1] -> Inserir Companhia Aerea\n");
            StdOut.printf(" [2] -> Editar Companhia Aerea\n");
            StdOut.printf(" [3] -> Remover Companhia Aerea\n");
            StdOut.printf(" [4] -> Listar Companhia Aerea\n");
            StdOut.printf(" [5] -> Pesquisa Companhia Aerea\n");
            StdOut.printf(" [6] -> Salvar Companhia Aerea\n");
            StdOut.printf(" [V] -> Voltar\n");
            StdOut.printf("OP: ");
            op = s.nextLine();
            switch (op) {
                case "1":
                    Scanner caScan = new Scanner(System.in);
                    int idCa = caST.get(caST.size() - 1).getId_ca() + 1;
                    StdOut.println("\t\t -----> NOVA COMPANHIA AEREA <-----");
                    StdOut.print("Nome Companhia Aerea: ");
                    String nomeCa = caScan.nextLine();
                    StdOut.print("Pais Companhia Aerea: ");
                    String paisCa = caScan.nextLine();
                    CompanhiaAerea c = new CompanhiaAerea(idCa, nomeCa, paisCa);
                    StdOut.println("MENSAGEM: " + CompanhiaAerea.inserirCompanhia(caST, c));
                    break;
                /*  case "2":
                    Scanner sca = new Scanner(System.in);
                    String update;
                    String val;
                    System.out.println("Editar Companhia(NOME): ");
                    String nome_Ca = sca.nextLine();

                    while (CompanhiaAerea.nomeCAvalida(caST, nome_Ca) == false) {
                        StdOut.println("\nNOME DA COMPANHIA NAO EXISTE");
                        StdOut.print("\nEditar Companhia(NOME: ");
                        nome_Ca = sca.nextLine();
                    }

                    if (ca.getNome_ca().contains(nome_Ca)) {
                        do {
                            StdOut.println("\t\t -----> EDITAR COMPANHIA AEREA <-----\n");
                            StdOut.printf(" [1] -> Nome da Companhia Aerea \n");
                            StdOut.printf(" [2] -> Pais da COMPANHIA AEREA\n");
                            StdOut.printf("OP: ");
                            val = sca.nextLine();
                            switch (val) {
                                case "1":
                                    StdOut.printf("Novo Nome Companhia Aerea: ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + CompanhiaAerea.editarCompanhia(ca, op, update));
                                    break;
                                case "2":
                                    StdOut.printf("Novo Pais Companhia Aerea: ");
                                    update = sca.nextLine();
                                    StdOut.println("MENSAGEM: " + CompanhiaAerea.editarCompanhia(ca, op, update));
                                    break;
                                case "v":
                                case "V":
                                    break;
                                default:
                                    StdOut.printf("Opcao Errada!!!\n");
                            }
                        } while (!"v".equals(op) && !"V".equals(op));
                    }
                    break;*/

                case "3":
                    Scanner Scan = new Scanner(System.in);
                    System.out.println("Remover Companhia(NOME): ");
                    String nCa = Scan.nextLine();
                    while (CompanhiaAerea.nomeCAvalida(caST, nCa) == false) {
                        StdOut.println("\nNOME DA COMPANHIA NAO EXISTE");
                        StdOut.print("Remover Companhia(NOME: ");
                        nCa = Scan.nextLine();
                    }
                    for (int idaux : caST.keys()) {
                        CompanhiaAerea co = (CompanhiaAerea) caST.get(idaux);
                        if (co.getNome_ca().equals(nCa)) {
                            StdOut.println("MENSAGEM: " + CompanhiaAerea.removerCompanhia(caST, idaux));
                        }
                    }
                    break;
                case "4":
                    StdOut.println("\t\t -----> LISTAR COMPANHIA AEREA<-----\n");
                    CompanhiaAerea.printCompanhia(caST);
                    break;
                case "5":

                    break;
                case "6":
                    StdOut.println("MENSAGEM: " + CompanhiaAerea.salvarCompanhia(caST, ".//data//companhia.txt"));
                    break;
                case "v":
                case "V":
                    break;
                default:
                    StdOut.printf("Opcao Errada!!!\n");
            }
        } while (!"v".equals(op) && !"V".equals(op));

    }

    /**
     * MENU LIGAÇÃo AEREA
     */
    public void menuLa() {

        EdgeWeightedDigraph g = new EdgeWeightedDigraph(0);
        g = LigacaoAerea.carregarLa(g, ".//data//la.txt");

        System.out.println(g.toString());

        //Retorna Duracao do VOO
        int aOrigem = 1;
        int aDestino = 20;
        Aviao aviao = avioesST.get(37);
        DijkstraSP duracao = new DijkstraSP(g, aDestino, aviao, "Duracao");
        System.out.println(duracao.distTo(aOrigem));

        // Retorona o Consumo do Aviao
        DijkstraSP consumo = new DijkstraSP(g, aDestino, aviao, "Consumo");
        System.out.println(consumo.distTo(aOrigem));

        // Retorna a Distancia da Ligacao
        DijkstraSP distancia = new DijkstraSP(g, aDestino, aviao, " ");
        System.out.println(distancia.distTo(aOrigem));

        // Sem ligacao directa 
        System.out.println(duracao.pathTo(aOrigem));
    }

}
