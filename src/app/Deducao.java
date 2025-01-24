// Parte da operação de extração de classe
package app;

public class Deducao {
    private String nome;
    private float valor;
    
    public Deducao(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }
    
    public String getNome() { return nome; }
    public float getValor() { return valor; }
}