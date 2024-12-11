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
    
    private IRPF irpf;
    private float rendimento;
    private float contribuicao;
    private float pensao;
    private int numDependentes;
    private float totalRendimentosEsperados;
    private float baseCalculoEsperada;

    public TesteBaseCalculoImposto(float rendimento, float contribuicao, float pensao, 
            int numDependentes, float totalRendimentosEsperados, float baseCalculoEsperada) {
        this.rendimento = rendimento;
        this.contribuicao = contribuicao;
        this.pensao = pensao;
        this.numDependentes = numDependentes;
        this.totalRendimentosEsperados = totalRendimentosEsperados;
        this.baseCalculoEsperada = baseCalculoEsperada;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {1000f, 500f, 200f, 1, 1000f, 1000f},
            {1000f, 1000f, 500f, 2, 2000f, 1000f},
            {2000f, 1000f, 800f, 1, 3000f, 1800f},
            {3000f, 0f, 0f, 3, 3000f, 0f}
        });
    }

    @Before
    public void setup() {
        irpf = new IRPF();
    }

    @Test
    public void testarBaseCalculoImposto() {
        // Cadastro de rendimento
        irpf.criarRendimento("Salário", true, rendimento);

        // Cadastro de contribuição previdenciária
        irpf.cadastrarContribuicaoPrevidenciaria(contribuicao);

        // Cadastro de pensão alimentícia
        irpf.cadastrarPensaoAlimenticia("Filho", pensao);

        // Cadastro de dependentes
        for (int i = 0; i < numDependentes; i++) {
            irpf.cadastrarDependente("Dependente" + i, "Filho");
        }

        // Verificação do total de rendimentos
        assertEquals(totalRendimentosEsperados, irpf.getTotalRendimentos(), 0f);

        // Verificação da base de cálculo do imposto
        assertEquals(baseCalculoEsperada, irpf.getTotalRendimentos() - irpf.getDeducao(), 0f);
    }

    @Test
    public void testarBaseCalculoImpostoComUmRendimento() {
        irpf.criarRendimento("Salário", true, 1000);
        irpf.cadastrarContribuicaoPrevidenciaria(500);
        irpf.cadastrarPensaoAlimenticia("Filho", 200);
        irpf.cadastrarDependente("Filho", "Filho");

        float baseCalculoEsperada = 1000 - irpf.getDeducao();
        
        // Verificando a base de cálculo do imposto
        assertEquals(baseCalculoEsperada, irpf.getTotalRendimentos() - irpf.getDeducao(), 0f);
    }

    @Test
    public void testarBaseCalculoImpostoComDoisRendimentos() {
        irpf.criarRendimento("Salário", true, 1000);
        irpf.criarRendimento("Freelance", true, 500);
        irpf.cadastrarContribuicaoPrevidenciaria(1000);
        irpf.cadastrarPensaoAlimenticia("Filho", 500);
        irpf.cadastrarDependente("Filho", "Filho");

        float baseCalculoEsperada = 1500 - irpf.getDeducao();

        // Verificando a base de cálculo do imposto
        assertEquals(baseCalculoEsperada, irpf.getTotalRendimentos() - irpf.getDeducao(), 0f);
    }

    @Test
    public void testarBaseCalculoImpostoComSemRendimento() {
        irpf.cadastrarContribuicaoPrevidenciaria(1000);
        irpf.cadastrarPensaoAlimenticia("Filho", 500);
        irpf.cadastrarDependente("Filho", "Filho");

        float baseCalculoEsperada = 0 - irpf.getDeducao();

        // Verificando a base de cálculo do imposto
        assertEquals(baseCalculoEsperada, irpf.getTotalRendimentos() - irpf.getDeducao(), 0f);
    }
}
