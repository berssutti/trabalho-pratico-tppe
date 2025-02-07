Critérios de correção do TP2
----------------------------

Critérios avaliados para refatorações automatizadas (Refat. 1 e 3):    
Crit. 1 - Testes estão passando sem erros?    
Crit. 2 - A execução da refatoração foi corretaa? (Em especial para a refatoração substituir método por objeto-método). 
Crit. 3 - Testes estão integrados à suite de testes?    
-10% para cada critério não atendido em cada unidade implementada.    
   
Critérios avaliados para refatoração "Substituir método por objeto-método": 
Crit. 1 - Variáveis do método são transformadas em atributos da classe do objeto-método? Referência para o objeto de origem foi utilizada? 
Crit. 2 - O método de origem se transformou em uma instanciação do metodo-objeto seguida por uma chamada ao método?
Crit. 3 - Testes estão passando sem erros?    

Unidades a serem implementadas:    
Refat. 1 - Extrair método   
Refat. 2 - Substituir método por objeto-método   
Refat. 3 - Extrair classe   


Avaliação
---------

| Critérios | Refat. 1 | Refat. 2 | Refat. 3 |
|:----------|:--------:|:--------:|:--------:|
| Crit. 1   |    Ok    |   NOk    |    Ok    |
| Crit. 2   |   NOk    |   NOk    |    Ok    |
| Crit. 3   |    Ok    |    Ok    |    Ok    |
| TOTAL     |    20    |    10    |    30    |

Observações: 
- Refatoração "Substituir método por objeto-metodo" não eliminou variáveis temporária, deixou elementos no método de origem, não criou referencia para o objeto de origem. 
- A refatoração "Extrair Método" simplesmente encapsulou todo o método original (calcularImposto) em um novo método chamado "Calcular", dentro da classe CalcularImposto. 
- 
- 
