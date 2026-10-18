# Reflexão - Prática 05: TDD em Java

1. No Ciclo 1, devolver `70` foi de propósito. Com um teste só, o valor fixo passava. O segundo exemplo, com outras notas, mostrou que era preciso fazer a soma de verdade.

2. Testei `69` e `70` porque é nesse limite que a regra muda. Se alguém usar `> 70` em vez de `>= 70`, o teste de `70` falha. Com `50` e `90`, esse erro passaria despercebido.

3. No Ciclo 4, troquei os três blocos parecidos pelo método `validarNota`. Ele recebe a nota, o limite e o nome da avaliação. Rodei os testes de novo. Continuaram verdes, então a refatoração não mudou o comportamento.

4. Mudei os testes antes do código porque eles mostram como a regra nova deve funcionar. Aí apareceu a falha da regra antiga. O código veio depois, com a reprovação por falta tendo prioridade.

5. O Ciclo 6 foi o que mais me deu trabalho, porque precisei juntar a regra da nota com a frequência mínima e entender em quais casos o aluno podia fazer a AI.
