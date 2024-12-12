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
public class TesteBaseCalculoImposto {
    
    private final float totalRendimentos;
    private final float totalDeducoes;
    private final float baseDeCalculoEsperada;

    public TesteBaseCalculoImposto(float totalRendimentos, float totalDeducoes, float baseDeCalculoEsperada) {
        this.totalRendimentos = totalRendimentos;
        this.totalDeducoes = totalDeducoes;
        this.baseDeCalculoEsperada = baseDeCalculoEsperada;
    }

    @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {
	            { 5000.0f, 1000.0f, 4000.0f },
	            { 10000.0f, 3000.0f, 7000.0f },
	            { 3000.0f, 3500.0f, 0.0f },
	            { 5000.0f, 0.0f, 5000.0f },
	            { 0.0f, 1000.0f, 0.0f },
	            { -5000.0f, 1000.0f, 0.0f },
//	            { 5000.0f, -1000.0f, 5000.0f },
	            { Float.MAX_VALUE, 0.0f, Float.MAX_VALUE },
	            { 1000000.0f, 999999.0f, 1.0f },
	            { 0.0001f, 0.0f, 0.0001f }
        });
    }
	    

    @Test
    public void testarBaseCalculoImposto() {
    	
        IRPF irpf = new IRPF();

        irpf.criarRendimento("Rendimento", IRPF.TRIBUTAVEL, totalRendimentos);
        irpf.cadastrarDeducaoIntegral("deducao", totalDeducoes);

        float baseDeCalculo = irpf.baseDeCalculoImposto();

        assertEquals(baseDeCalculoEsperada, baseDeCalculo, 0.001);
    }
}

