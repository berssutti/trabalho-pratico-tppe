package tst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import app.IRPF;

public class TesteCadastroContribuicaoPrevidenciaria {

    IRPF irpf;

    @BeforeEach
    public void setup() {
        irpf = new IRPF();
    }

    // Teste Triangulado com @ParameterizedTest
    @ParameterizedTest
    @CsvSource({
        "1000, 1, 1000.0",
        "500, 2, 1500.0",
        "200, 3, 1700.0"
    })
    public void testarCadastroContribuicoesPrevidenciarias(float contribuicao, int numContribuicoesEsperadas, float totalContribuicoesEsperadas) {
        // Cadastro das contribuições
        irpf.cadastrarContribuicaoPrevidenciaria(contribuicao);

        // Verificação do número de contribuições
        assertEquals(numContribuicoesEsperadas, irpf.getNumContribuicoesPrevidenciarias());

        // Verificação do total das contribuições
        assertEquals(totalContribuicoesEsperadas, irpf.getTotalContribuicoesPrevidenciarias(), 0f);
        
        // Verificação das deduções
        assertEquals(totalContribuicoesEsperadas, irpf.getDeducao(), 0f);
    }

    @Test
    public void cadastrarUmaContribuicaoPrevidenciaria() {
        irpf.cadastrarContribuicaoPrevidenciaria(1000);
        assertEquals(1, irpf.getNumContribuicoesPrevidenciarias());
        assertEquals(1000f, irpf.getTotalContribuicoesPrevidenciarias(), 0f);
        assertEquals(1000f, irpf.getDeducao(), 0f);
    }

    @Test
    public void cadastrarDuasContribuicoesPrevidenciarias() {
        irpf.cadastrarContribuicaoPrevidenciaria(1000);
        irpf.cadastrarContribuicaoPrevidenciaria(500);
        assertEquals(2, irpf.getNumContribuicoesPrevidenciarias());
        assertEquals(1500f, irpf.getTotalContribuicoesPrevidenciarias(), 0f);
        assertEquals(1500f, irpf.getDeducao(), 0f);
    }

    @Test
    public void cadastrarTresContribuicoesPrevidenciarias() {
        irpf.cadastrarContribuicaoPrevidenciaria(1000);
        irpf.cadastrarContribuicaoPrevidenciaria(500);
        irpf.cadastrarContribuicaoPrevidenciaria(200);
        assertEquals(3, irpf.getNumContribuicoesPrevidenciarias());
        assertEquals(1700f, irpf.getTotalContribuicoesPrevidenciarias(), 0f);
        assertEquals(1700f, irpf.getDeducao(), 0f);
    }
}
