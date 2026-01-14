package CriadorDeLojas;

import java.util.ArrayList;

public class Vendedores {

    private String nome;
    private int SaldoDoVendedor;
    private ArrayList<Item>itens;

    public Vendedores(String nome, int SaldoDoVendedor)
    {this.nome = nome;
    this.SaldoDoVendedor = SaldoDoVendedor;
    this.itens = new ArrayList<>();}

    public void AdicionarItens(Item item){itens.add(item);}

    public void listarItems(){for (Item item : itens)
    {

        System.out.print("\n[Categoria & tipo do item: Categoria: "+item.categoria+" &  Tipo: "+item.tipo+"]\n\n[Nome do item: "+item.getNome()+"]\n\n[Peso: "+item.getPeso()+
                "]\n\n[Preço base: "+item.getValor()+" Tibares]"+"\n\n[Descrição do item: "+item.descrição+"]");


        if (item instanceof Armas arma) { // Java 16+ permite 'pattern matching'
        System.out.print("\n\n[Dano da arma: " + arma.getDano() + "]");}

        else if (item instanceof Armaduras armadura){System.out.print("\n\n[Defesa da armadura: " + armadura.getDefesa() + "]");}

        System.out.print("\n\n[FIM DESTE ITEM]\n\n");
    }}

    public boolean debitarSaldo(int valor) {
        if (SaldoDoVendedor >= valor) {
            SaldoDoVendedor -= valor;
            return true;
        }
        return false;
    }


    public String getnome(){return nome;}
    public int getSaldoDoVendedor(){return SaldoDoVendedor;}



}
