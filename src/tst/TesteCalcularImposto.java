package tst;

import java.util.*;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import app.IRPF;

@RunWith(Parameterized.class)
public class TesteCalcularImposto {

	private float rendimento;
	private float impostoEsperado;

	public TesteCalcularImposto(float rendimento, float impostoEsperado) {
		this.rendimento = rendimento;
		this.impostoEsperado = impostoEsperado;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> getParameters() {
		return Arrays.asList(new Object[][] {
			{2259.19f, 0.0f},
			{2259.21f, 7.5f}
		});
	}
	
	@Test
	public void testCalculoImposto() {
		IRPF irpf = new IRPF();
		irpf.criarRendimento("Salário", IRPF.TRIBUTAVEL, rendimento);
		assertEquals(impostoEsperado, irpf.calcularImposto(), 0.01f);
	}

}