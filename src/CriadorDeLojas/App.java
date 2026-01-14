package CriadorDeLojas;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static ArrayList<Vendedores>vendedores = new ArrayList<>();

    public static void main(String[] args) {

        Vendedores vendedorAtivo = null;
        Scanner scanner = new Scanner(System.in);
        boolean CriarVendedor = true;
        boolean menuAdd = false;
        boolean rodando = true;


        while (rodando) {
            if (CriarVendedor) {

                System.out.println("\n\nO que você deseja fazer?\n(C)- Criar um novo vendedor" +
                        "\n(A)- Acessar vendedor\n(V)- Vender Algo ao vendedor\n(ADD)- Adicionar items");

                String resposta = scanner.nextLine();

                if (resposta.equals("ADD")) {
                    CriarVendedor = false;
                    menuAdd = true;
                } else if (resposta.equals("C")) {
                    System.out.print("Qual o nome do novo vendedor?");
                    String nome = scanner.nextLine();
                    System.out.print("Quanto dinheiro esse vendedor possui?");
                    int Saldo = scanner.nextInt();
                    scanner.nextLine();
                    Vendedores vendedor1 = new Vendedores(nome, Saldo);
                    vendedorAtivo = vendedor1;
                    vendedores.add(vendedor1);
                    System.out.print("Vendedor criado com sucesso!" +
                            "\nNOME: " + vendedor1.getnome() +
                            "\nVALOR NA CONTA: R$ " + vendedor1.getSaldoDoVendedor());
                } else if (resposta.equals("A")) {
                    if (vendedorAtivo == null) {
                        System.out.print("Não é possível acessar nenhum vendedor, pois vendedores ainda não foram criados!");
                        continue;
                    }
                    {
                        System.out.println("Aqui estão os vendedores existentes");
                        for (int i = 0; i < vendedores.size(); i++) {
                            System.out.println(i + " - " + vendedores.get(i).getnome());
                        }
                        System.out.println("Digite o número do vendedor que deseja acessar");
                        int escolha = scanner.nextInt();
                        scanner.nextLine();
                        vendedorAtivo = vendedores.get(escolha);
                        vendedorAtivo.listarItems();
                    }
                } else if (resposta.equals("V")) {
                    System.out.println("Para quem deseja vender?");


                    for (int i = 0; i < vendedores.size(); i++) {
                        System.out.println(i + " - " + vendedores.get(i).getnome());
                    }

                    System.out.println("Digite o número do vendedor");

                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    vendedorAtivo = vendedores.get(escolha);

                    System.out.println("Qual a categoria do seu item?\n(A)Armas\n(D)Armaduras");
                    resposta = scanner.nextLine();


                    if (resposta.equals("A")) {
                        System.out.println("Qual o tipo do seu item?\n(E)Espada de uma mão\n(EE)Espada de duas mãos");
                        resposta = scanner.nextLine();
                        if (resposta.equals("E")) {
                            System.out.println("Qual o valor da sua espada de uma mão?");
                            int resposta1 = scanner.nextInt();
                            scanner.nextLine();
                            if (vendedorAtivo.debitarSaldo(resposta1)) {
                                vendedorAtivo.getSaldoDoVendedor();
                                EspadasDeUmaMão espadasDeUmaMão = new EspadasDeUmaMão("armadura", 10.0, "2D6", 1000, "Armadura", "Armadura Leve","");
                                vendedorAtivo.AdicionarItens(espadasDeUmaMão);
                            }
                        } else if (resposta.equals("EE")) {
                            System.out.println("Qual o valor da sua espada de duas mãos?");
                            int resposta1 = scanner.nextInt();
                            scanner.nextLine();
                            if (vendedorAtivo.debitarSaldo(resposta1)) {
                                vendedorAtivo.getSaldoDoVendedor();
                            }
                            EspadaDeDuasMãos espadaDeDuasMãos = new EspadaDeDuasMãos("armadura", 10.0, "2D6", 1000, "Armadura", "Armadura Leve","");
                            vendedorAtivo.AdicionarItens(espadaDeDuasMãos);

                        }

                    } else if (resposta.equals("D")) {
                        System.out.println("Qual o tipo do seu item?\n(A)- Armadura pesada\n(L)- Armadura leve");
                        resposta = scanner.nextLine();
                    } else if (resposta.equals("A")) {
                        System.out.println("Qual o valor da sua Armadura pesada?");
                        int resposta1 = scanner.nextInt();
                        scanner.nextLine();
                        if (vendedorAtivo.debitarSaldo(resposta1)) {
                            vendedorAtivo.getSaldoDoVendedor();
                        }
                        ArmaduraPesada armaduraspesadas = new ArmaduraPesada("armadura", 10.0, 22, 1000, "Armadura", "Armadura Leve","");
                        vendedorAtivo.AdicionarItens(armaduraspesadas);


                    } else if (resposta.equals("L")) {
                        System.out.println("Qual o valor da sua Armadura leve?");
                        int resposta1 = scanner.nextInt();
                        scanner.nextLine();
                        if (vendedorAtivo.debitarSaldo(resposta1)) {
                            vendedorAtivo.getSaldoDoVendedor();
                            ArmadurasLeves armadurasLeves = new ArmadurasLeves("armadura", 10.0, 22, 1000, "Armadura", "Armadura Leve","");
                            vendedorAtivo.AdicionarItens(armadurasLeves);

                        }
                    }
                }
            }

         else if (menuAdd){
            System.out.print("\nVocê deseja adicionar algum item?\n(S) - Sim\n(N) - Não");
            String resposta = scanner.nextLine();
            if (resposta.equals("N")){menuAdd = false; CriarVendedor = true;}

            else if (resposta.equals("S")){
                System.out.print("\nQual a categoria?\n(A)-Armas\n(D)-Armaduras");
                String categoria = scanner.nextLine();
                if (categoria.equals("A")) {
                    System.out.print("\nQual o tipo de arma?" +
                            "\n(E)- Espada de uma mão" +
                            "\n(EE)- Espada de duas mãos");
                }
                else if (categoria.equals("D")){System.out.print("\nQual o tipo da armadura?\n" +
                        "(A) Armadura pesada" +
                        "\n(L) Armadura leve");}

                String tipo = scanner.nextLine();
                if (tipo.equals("E")) {
                    System.out.print("\nDigite o nome da espada: ");
                    String nomeItem = scanner.nextLine();
                    System.out.print("\nDigite o dano que ela causa: ");
                    String dano = scanner.nextLine();
                    System.out.print("\nDigite quanto ela pesa: ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("\nDigite o valor base: ");
                    int valor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nDigite uma descrição do seu item(opcional): ");
                    String descricao = scanner.nextLine();
                    EspadasDeUmaMão espada = new EspadasDeUmaMão(nomeItem, peso, dano, valor, categoria,tipo,descricao);
                    vendedorAtivo.AdicionarItens(espada);

                } else if (tipo.equals("EE")) {
                    System.out.print("\nDigite o nome da espada de duas mãos: ");
                    String nomeItem = scanner.nextLine();
                    System.out.print("\nDigite o dano que ela causa: ");
                    String dano = scanner.nextLine();
                    System.out.print("\nDigite quanto ela pesa: ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("\nigite o valor base: ");
                    int valor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nDigite uma descrição do seu item(opcional): ");
                    String descricao = scanner.nextLine();
                    EspadaDeDuasMãos espadaT = new EspadaDeDuasMãos(nomeItem, peso, dano,valor,categoria,tipo,descricao);
                    vendedorAtivo.AdicionarItens(espadaT);
                }


                else if (tipo.equals("A")) {System.out.print("\nDigite o nome da Armadura pesada: ");
                    String nomeItem = scanner.nextLine();
                    System.out.println("\nQual a defesa dessa armadura? ");
                    int defesa = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("\nQual o peso dessa armadura? ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("\nDigite o valor base: ");
                    int valor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nDigite uma descrição do seu item(opcional): ");
                    String descricao = scanner.nextLine();;
                    ArmaduraPesada armadura = new ArmaduraPesada(nomeItem,peso,defesa,valor,categoria,tipo,descricao);
                    vendedorAtivo.AdicionarItens(armadura);
                }

                else if (tipo.equals("L"))
                {System.out.print("\nDigite o nome da Armadura leve: ");
                    String nomeItem = scanner.nextLine();
                    System.out.println("\nQual a defesa dessa armadura? ");
                    int defesa = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("\nQual o peso dessa armadura? ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("\nDigite o valor base: ");
                    int valor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nDigite uma descrição do seu item(opcional): ");
                    String descricao = scanner.nextLine();
                    ArmadurasLeves armaduraL = new ArmadurasLeves(nomeItem, peso,defesa,valor,categoria,tipo, descricao);
                    vendedorAtivo.AdicionarItens(armaduraL);

                }

                System.out.println("\n\nVendedor criado com sucesso!");
                System.out.print("Nome do vendedor: "+vendedorAtivo.getnome());
                System.out.print("\n\nSaldo do vendedor: "+vendedorAtivo.getSaldoDoVendedor()+" tibares");
                System.out.print("\n\nInventário do vendedor: ");
                vendedorAtivo.listarItems();}
            }


    }}}

