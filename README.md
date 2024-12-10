# 📚 Trabalhos Práticos - Semestre 2024/2  

### 🎓 UnB - Universidade de Brasília  
### 🏛️ FCTE - Faculdade de Ciências e Tecnologias em Engenharias  
### 💻 FGA0242 - Técnicas de Programação para Plataformas Emergentes  

---

## 👨‍🎓 Alunos  

| Nome                          | Matrícula  |
|-------------------------------|------------|
| Paulo Henrique Almeida da Silva | 170020291 |
| Jefferson França Santos       | 180102761  |
| Abraão Alves Ribeiro          | 190023376  |
| Bernardo Chaves Pissutti      | 190103302  |

---

## 📝 Descrição do Cenário  

O **Imposto de Renda de Pessoas Físicas (IRPF)** é um imposto federal calculado com base na renda e nas despesas dedutíveis dos cidadãos brasileiros. O processo consiste em:  

1. 📈 **Calcular os rendimentos tributáveis e não tributáveis.**  
2. 🧾 **Determinar as deduções legais.**  
3. 💰 **Calcular a base de cálculo e o imposto devido por faixa.**  
4. 📊 **Determinar a alíquota efetiva.**  

### 🔍 Exemplos  

#### Rendimentos  
| Descrição do Rendimento | Tributável? | Valor            |
|--------------------------|-------------|------------------|
| Salário                 | Sim         | R$ 8.000,00     |
| Aluguel                 | Sim         | R$ 2.000,00     |
| Bolsa de estudos        | Não         | R$ 1.500,00     |
| **Total rendimentos:**  |             | **R$ 11.500,00** |
| **Total rend. tribut.:**|             | **R$ 10.000,00** |

#### Deduções  
| Descrição da Dedução     | Valor         |
|---------------------------|---------------|
| 1 dependente              | R$ 189,59     |
| Previdência oficial       | R$ 500,00     |
| Previdência complementar  | R$ 1.000,00   |
| Pensão alimentícia        | R$ 1.500,00   |
| **Total de deduções:**    | **R$ 3.189,59** |

#### Base de Cálculo  
| Descrição                        | Valor         |
|----------------------------------|---------------|
| Total rendimentos tributáveis    | R$ 10.000,00  |
| Total deduções                   | R$ 3.189,59   |
| **Base de cálculo:**             | **R$ 6.810,41** |

#### Cálculo do Imposto  
| Faixa | Faixa de Valores         | Alíquota | Imposto Devido |
|-------|---------------------------|----------|----------------|
| 1ª    | Até R$ 2.259,20          | 0,0%     | R$ 0,00        |
| 2ª    | De R$ 2.259,21 até 2.826,65 | 7,5%   | R$ 53,59       |
| 3ª    | De R$ 2.826,66 até 3.751,05 | 15,0%  | R$ 138,66      |
| 4ª    | De R$ 3.751,06 até 4.664,68 | 22,5%  | R$ 205,56      |
| 5ª    | Acima de R$ 4.664,68      | 27,5%    | R$ 590,07      |
|       | **Total:**                |          | **R$ 987,88**  |

**Alíquota efetiva:** 9,87%  
*(Imposto devido ÷ Total rendimentos tributáveis)*  

---

## 📌 Enunciados dos Trabalhos  

Os trabalhos serão realizados com base no cenário descrito acima.  

### 🚀 Temas dos Trabalhos  
1. **TDD (Test-Driven Development)**  
2. **Refatoração**  
3. **Depuração de Código**  

Os grupos terão, no máximo, 5 componentes. A composição do grupo deve ser informada através do [formulário](https://docs.google.com/forms/d/e/1FAIpQLSevIusyB-JxQe5uP1oPuWkIPXfQzdy9H6eIeuIWkVPgc1NJ2Q/viewform).  

### 🛠️ Requisitos Técnicos  
- Linguagem: **Java**  
- Repositório: **GitHub**  
- Entregas realizadas por commits no repositório.  

---

## 📅 Entrega 1 - TDD  

**Valor:** 20 pontos  
**Data de entrega:** 13/12/2024, até 23h59.  

### 📋 Requisitos  
- Implementar testes para:  
  - Base de cálculo do imposto.  
  - Impostos por faixas e total.  
  - Alíquota efetiva.  

- Integrar os testes à suíte de testes existente (`AllTests.java`).  
- Utilizar testes triangulados (preferencialmente parametrizados).  

Os testes já implementados cobrem as seguintes funcionalidades:  
| Classe                                  | Funcionalidade                     |
|----------------------------------------|------------------------------------|
| TesteCadastrarDependente                | Cadastrar dependentes              |
| TesteRendimentos                        | Cadastrar rendimentos              |
| TesteCalculosDeducoesDependentes        | Calcular deduções por dependentes  |
| TesteCadastroContribuicaoPrevidenciaria | Calcular deduções por previdência  |
| TesteCadastroPensaoAlimenticia          | Calcular deduções por pensões      |
| TesteCadastroOutrasDeducoes             | Calcular outros tipos de deduções  |

---
