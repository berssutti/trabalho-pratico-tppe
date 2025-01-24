package app;

public class CalcularImposto {
    private float baseDeCalculo;
    
    public CalcularImposto(float baseDeCalculo) {
        this.baseDeCalculo = baseDeCalculo;
    }
    
    public float calcular() {
        return calcularImpostoPorFaixa();
    }
    
    private float calcularImpostoPorFaixa() {
        float imposto = 0.0f;
        if (baseDeCalculo <= 2259.20f) {
            imposto = 0.0f;
        } else if (baseDeCalculo <= 2826.65f) {
            imposto = (baseDeCalculo - 2259.20f) * 0.075f;
        } else if (baseDeCalculo <= 3751.05f) {
            imposto = (2826.65f - 2259.20f) * 0.075f + (baseDeCalculo - 2826.65f) * 0.15f;
        } else if (baseDeCalculo <= 4664.68f) {
            imposto = (2826.65f - 2259.20f) * 0.075f + (3751.05f - 2826.65f) * 0.15f + (baseDeCalculo - 3751.05f) * 0.225f;
        } else {
            imposto = (2826.65f - 2259.20f) * 0.075f + (3751.05f - 2826.65f) * 0.15f + (4664.68f - 3751.05f) * 0.225f + (baseDeCalculo - 4664.68f) * 0.275f;
        }
        return imposto;
    }
}