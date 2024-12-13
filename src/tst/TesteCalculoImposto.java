package tst;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

import app.IRPF;

@RunWith(Parameterized.class)
public class TesteCalculoImposto {
    
    private final float totalRendimentos;
    private final float totalDeducoes;
    private final float impostoEsperado;

    public TesteCalculoImposto(float totalRendimentos, float totalDeducoes, float impostoEsperado) {
        this.totalRendimentos = totalRendimentos;
        this.totalDeducoes = totalDeducoes;
        this.impostoEsperado = impostoEsperado;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // { 10000.0f, 3189.59f, 987.88f }, 
            { 5000.0f, 1000.0f, 150,71f },  // Base 4000.0f: Imposto na 2ª faixa
            //{ 3000.0f, 3500.0f, 0.0f },    // Base 0.0f: Isento
            //{ 5000.0f, 5000.0f, 0.0f },    // Base 0.0f: Isento
            //{ 12000.0f, 6000.0f, 523.87f } // Base 6000.0f: 4ª faixa parcial
        });
    }

    @Test
    public void testarCalculoImposto() {
        IRPF irpf = new IRPF();
        irpf.criarRendimento("Rendimento", IRPF.TRIBUTAVEL, totalRendimentos);
        irpf.cadastrarDeducaoIntegral("Deducao", totalDeducoes);

        float impostoCalculado = irpf.calcularImposto();

        assertEquals(impostoEsperado, impostoCalculado, 0.01);
    }
}
