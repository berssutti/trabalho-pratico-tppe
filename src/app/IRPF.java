package app;

public class IRPF {
    public static final boolean TRIBUTAVEL = true;
    public static final boolean NAOTRIBUTAVEL = false;
    
    private Rendimento[] rendimentos;
    private int numRendimentos;
    private float totalRendimentos;
    
    private Dependente[] dependentes;
    private int numDependentes;
    
    private int numContribuicaoPrevidenciaria;
    private float totalContribuicaoPrevidenciaria;
    private float totalPensaoAlimenticia;
    
    private Deducao[] deducoes;

    public IRPF() {
        rendimentos = new Rendimento[0];
        dependentes = new Dependente[0];
        deducoes = new Deducao[0];
        numRendimentos = 0;
        numDependentes = 0;
        totalRendimentos = 0f;
        numContribuicaoPrevidenciaria = 0;
        totalContribuicaoPrevidenciaria = 0f;
        totalPensaoAlimenticia = 0f;
    }
    
    /**
     * Cadastra um rendimento na base do contribuinte, informando o nome do 
     * rendimento, seu valor e se ele é tributável ou não. 
     * @param nome nome do rendimento a ser cadastrado
     * @param tributavel true caso seja tributável, false caso contrário
     * @param valor valor do rendimento a ser cadastrado
     */
    public void criarRendimento(String nome, boolean tributavel, float valor) {
        Rendimento[] temp = new Rendimento[rendimentos.length + 1];
        for (int i=0; i<rendimentos.length; i++) {
            temp[i] = rendimentos[i];
        }
        temp[rendimentos.length] = new Rendimento(nome, tributavel, valor);
        rendimentos = temp;
        numRendimentos++;
        totalRendimentos += valor;
    }

    /**
     * Retorna o número de rendimentos já cadastrados para o contribuinte
     * @return numero de rendimentos
     */
    public int getNumRendimentos() {
        return numRendimentos;
    }

    /**
     * Retorna o valor total de rendimentos cadastrados para o contribuinte
     * @return valor total dos rendimentos
     */
    public float getTotalRendimentos() {
        return totalRendimentos;
    }

    /**
     * Retorna o valor total de rendimentos tributáveis do contribuinte
     * @return valor total dos rendimentos tributáveis
     */
    public float getTotalRendimentosTributaveis() {
        float total = 0f;
        for (Rendimento r : rendimentos) {
            if (r.isTributavel()) {
                total += r.getValor();
            }
        }
        return total;
    }

    /**
     * Método para realizar o cadastro de um dependente, informando seu grau 
     * de parentesco
     * @param nome Nome do dependente
     * @param parentesco Grau de parentesco
     */
    public void cadastrarDependente(String nome, String parentesco) {
        Dependente[] temp = new Dependente[dependentes.length + 1];
        for (int i=0; i<dependentes.length; i++) {
            temp[i] = dependentes[i];
        }
        temp[dependentes.length] = new Dependente(nome, parentesco);
        dependentes = temp;
        numDependentes++;
    }

    /**
     * Método que retorna o numero de dependentes do contribuinte
     * @return numero de dependentes
     */
    public int getNumDependentes() {
        return numDependentes;
    }
    
    /**
     * Return o valor do total de deduções para o contribuinte
     * @return valor total de deducoes
     */
    public float getDeducao() {
        return (numDependentes * 189.59f) + totalContribuicaoPrevidenciaria;
    }

    /**
     * Cadastra um valor de contribuição previdenciária oficial
     * @param contribuicao valor da contribuição previdenciária oficial
     */
    public void cadastrarContribuicaoPrevidenciaria(float contribuicao) {
        numContribuicaoPrevidenciaria++;
        totalContribuicaoPrevidenciaria += contribuicao;
    }

    /**
     * Retorna o numero total de contribuições realizadas como contribuicao 
     * previdenciaria oficial
     * @return numero de contribuições realizadas
     */
    public int getNumContribuicoesPrevidenciarias() {
        return numContribuicaoPrevidenciaria;
    }

    /**
     * Retorna o valor total de contribuições oficiais realizadas
     * @return valor total de contribuições oficiais
     */
    public float getTotalContribuicoesPrevidenciarias() {
        return totalContribuicaoPrevidenciaria;
    }

    /**
     * Realiza busca do dependente no cadastro do contribuinte
     * @param nome nome do dependente que está sendo pesquisado
     * @return nome do dependente ou null, caso nao conste na lista de dependentes
     */
    public String getDependente(String nome) {
        for (Dependente d : dependentes) {
            if (d.getNome().contains(nome))
                return d.getNome();
        }
        return null;
    }

    /**
     * Método que retorna o grau de parentesco para um dado dependente, caso ele
     * conste na lista de dependentes
     * @param dependente nome do dependente
     * @return grau de parentesco, nulo caso nao exista o dependente
     */
    public String getParentesco(String dependente) {
        for (Dependente d : dependentes) {
            if (d.getNome().equalsIgnoreCase(dependente))
                return d.getParentesco();
        }
        return null;
    }

    /**
     * Realiza o cadastro de uma pensao alimenticia para um dos dependentes do 
     * contribuinte, caso ele seja um filho ou alimentando. 
     * @param dependente nome do dependente 
     * @param valor valor da pensao alimenticia
     */
    public void cadastrarPensaoAlimenticia(String dependente, float valor) {
        String parentesco = getParentesco(dependente);
        if (parentesco != null && 
            (parentesco.toLowerCase().contains("filh") || 
             parentesco.toLowerCase().contains("alimentand"))) {
            totalPensaoAlimenticia += valor;
        }
    }

    /**
     * Retorna o valor total pago em pensões alimentícias pelo contribuinte.
     * @return valor total de pensoes alimenticias
     */
    public float getTotalPensaoAlimenticia() {
        return totalPensaoAlimenticia;
    }

    /**
     * Metodo para cadastrar deduções integrais para o contribuinte. Para cada
     * dedução é informado seu nome e valor. 
     * @param nome nome da deducao 
     * @param valorDeducao valor da deducao
     */
    public void cadastrarDeducaoIntegral(String nome, float valorDeducao) {
        Deducao[] temp = new Deducao[deducoes.length + 1];
        for (int i=0; i<deducoes.length; i++) {
            temp[i] = deducoes[i];
        }
        temp[deducoes.length] = new Deducao(nome, valorDeducao);
        deducoes = temp;
    }

    /**
     * Método para pesquisar uma deducao pelo seu nome. 
     * @param substring do nome da deducao a ser pesquisada
     * @return nome da deducao, ou null caso na esteja cadastrada
     */
    public String getOutrasDeducoes(String nome) {
        for (Deducao d : deducoes) {
            if (d.getNome().toLowerCase().contains(nome.toLowerCase()))
                return d.getNome();
        }
        return null;
    }

    /**
     * Obtem o valor da deducao à partir de seu nome 
     * @param nome nome da deducao para a qual se busca seu valor
     * @return valor da deducao
     */
    public float getDeducao(String nome) {
        for (Deducao d : deducoes) {
            if (d.getNome().toLowerCase().contains(nome.toLowerCase()))
                return d.getValor();
        }
        return 0;
    }

    /**
     * Obtem o valor total de todas as deduções que nao sao do tipo
     * contribuicoes previdenciarias ou por dependentes
     * @return valor total das outras deducoes
     */
    public float getTotalOutrasDeducoes() {
        float total = 0;
        for (Deducao d : deducoes) {
            total += d.getValor();
        }
        return total;
    }
    
    public float baseDeCalculoImposto() {
        float totalRendimentos = getTotalRendimentosTributaveis();
        float deducoes = getDeducao() + getTotalOutrasDeducoes() + getTotalPensaoAlimenticia();
        return Math.max(0, totalRendimentos - deducoes);
    }
    
    public float calcularImposto() {
        float baseDeCalculo = baseDeCalculoImposto();
        CalcularImposto calculadora = new CalcularImposto(baseDeCalculo);
        return calculadora.calcular();
    }

    public float calcularBaseCalculo() {
        float rendimentosTributaveis = getTotalRendimentosTributaveis();
        float totalDeducoes = getDeducao();
        return rendimentosTributaveis - totalDeducoes;
    }
    
    /**
     * Calcula a alíquota efetiva do imposto de renda com base nos rendimentos
     * tributáveis e no imposto devido.
     * @param rendimentosTributaveis valor total dos rendimentos tributáveis
     * @param impostoDevido valor do imposto devido
     * @return alíquota efetiva do imposto de renda
     */
    public float calcularAliquotaEfetiva(float rendimentosTributaveis, float impostoDevido) {
        if (rendimentosTributaveis == 0) {
            return 0;
        }
        return (impostoDevido / rendimentosTributaveis) * 100;
    }
}