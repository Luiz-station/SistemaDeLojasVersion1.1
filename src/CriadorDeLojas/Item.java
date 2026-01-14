package CriadorDeLojas;

public abstract class Item {
    protected String nome;
    protected Double peso;
    protected int valor;
    protected String categoria;
    protected String tipo;
    protected String descrição;

    public Item(String nome, Double peso, int valor,String categoria, String tipo, String descrição) {
        this.categoria = categoria;
        this.tipo = tipo;
        this.nome = nome;
        this.peso = peso;
        this.valor = valor;
        this.descrição = descrição;
    }

    public String getNome(){return nome;}
    public int getValor(){return valor;}
    public double getPeso(){return peso;}
    public String getDescrição() {
        return descrição;
    }
}
