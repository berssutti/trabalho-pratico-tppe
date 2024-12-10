package tst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import app.IRPF;

public class TesteBaseCalculoImposto {

    IRPF irpf;

    @BeforeEach
    public void setup() {
        irpf = new IRPF();
    }

    // Teste de Base de Cálculo de Imposto com diferentes valores de rendimentos, contribuições e deduções
    @ParameterizedTest
    @CsvSource({
        "1000, 500, 200, 1, 1000, 1000",
        "1000, 1000, 500, 2, 2000, 1000",
        "2000, 1000, 800, 1, 3000, 1800",
        "3000, 0, 0, 3, 3000, 0"
    })
    public void testarBaseCalculoImposto(float rendimento, float contribuicao, float pensao, int numDependentes, float totalRendimentosEsperados, float baseCalculoEsperada) {
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
