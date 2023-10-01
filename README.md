# Interpretador compiladores 2022.2 UFAL

Esse é um algoritmo feito em java, sua execução é começando na principal.java, na main temos o leitor
do arquivo de entrada teste, basta adicionar o endereço de origem do arquivo de entrada e executar o código,
mais detalhes na bnf.

Aviso: Algoritmo nao reconhece tempo, ou seja o tempo colocado nos teste sao meramente para seguir padroes da bnf,
a equipe nao conseguiu implementar essa funcionalidade.

Atualizacoes feitas na BNF:

  Termos alterados na BNF: antes/depois
  
    tempo --> | 20_min | 1_hora | 1_dia | 2_dias | sem limite
    | 15_min / tempo --> quinzemin | vintemin | umahora | umdia | doisdias | semlimite
   
  Simbolos adicionados/removidos na BNF: antes/depois
  
    programa_SOL --> loop vezes sequência / programa_SOL --> loop vezes sequência;
    Explore navegar tempo ; | Explore / Explore navegar tempo | Explore
  
  Termos alterados para evitar redundaçia: antes / depois
  
    sequência --> Present tempo | fases_EPIC / sequência --> fases_EPIC
    
  Termos alterados para aberturas de links, com seus devidos objetivos
  
    visualizar_pdf = https://drive.google.com/
    visualizar_vídeo  = https://www.youtube.com/
    videoconferência = https://meet.google.com/
    whatsapp_web = https://web.whatsapp.com/
    email = https://mail.google.com/
