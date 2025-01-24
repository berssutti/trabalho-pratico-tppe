// Parte da operação de extração de classe
package app;

public class Dependente {
    private String nome;
    private String parentesco;
    
    public Dependente(String nome, String parentesco) {
        this.nome = nome;
        this.parentesco = parentesco;
    }
    
    public String getNome() { return nome; }
    public String getParentesco() { return parentesco; }
}