package CriadorDeLojas;

public abstract class Armaduras extends Item {
    protected int defesa;

    public Armaduras(String nome, Double peso, int defesa, int valor,String categoria,
                     String tipo,String descrição )
    {super(nome, peso, valor,categoria,tipo, descrição);
    this.defesa = defesa;}

    public int getDefesa() {
        return defesa;
    }
}
