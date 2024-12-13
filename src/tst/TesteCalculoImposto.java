package tst;

import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import app.IRPF;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

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
            { 10000.0f, 3189.59f, 987.88f },
            { 5000.0f, 1000.0f, 237.23f },
            { 3000.0f, 3500.0f, 0.0f },
            { 5000.0f, 5000.0f, 0.0f },
            { 12000.0f, 6000.0f, 754.00f }
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