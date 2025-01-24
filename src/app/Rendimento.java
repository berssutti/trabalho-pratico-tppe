// Parte da operação de extração de classe
package app;

public class Rendimento {
    private String nome;
    private boolean tributavel;
    private float valor;
    
    public Rendimento(String nome, boolean tributavel, float valor) {
        this.nome = nome;
        this.tributavel = tributavel;
        this.valor = valor;
    }
    
    public String getNome() { return nome; }
    public boolean isTributavel() { return tributavel; }
    public float getValor() { return valor; }
}