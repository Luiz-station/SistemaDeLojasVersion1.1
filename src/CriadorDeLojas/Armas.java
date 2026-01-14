package CriadorDeLojas;

public abstract class Armas extends Item {
    protected String dano;

    public Armas(String nome, Double peso, String dano,int valor,String categoria,
                String tipo,String descrição )
    {super(nome,peso,valor,categoria,tipo, descrição);
    this.dano = dano;}

    public String getDano() {
        return dano;
    }
}
