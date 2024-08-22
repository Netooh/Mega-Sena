# MegaSena

**Descrição do Projeto:** Teste de Simulação de MegaSena

A implementação foca na criação de uma simulação do jogo MegaSena, onde o usuário pode escolher números, e o sistema sorteia números aleatórios para verificar quantos acertos o usuário conseguiu.

**Implementação Detalhada:**

- O sistema gera uma cartela de números de 1 a 60, organizada em uma matriz.
- O usuário escolhe seis números da cartela, que são então comparados com seis números sorteados aleatoriamente.
- A classe `Random` é usada para garantir a aleatoriedade dos números sorteados.
- Após o usuário escolher os números, eles ficam marcados na tabela gerada, facilitando a visualização dos números selecionados.
- O sistema imprime a cartela, os números escolhidos, os números sorteados e quantos acertos o usuário obteve.

**Exemplo de Interação:**
```
NÚMEROS ESCOLHIDOS: 5 18 27 33 42 50
NÚMEROS SORTEADOS: 4 18 21 33 39 55
Você acertou 2 número(s).
```

O projeto foi criado na faculdade na matéria de Programação Orientada a Objetos (POO) e pode conter erros ou imperfeições, servindo como uma experiência de aprendizado e prática.

**Tipos de Arquivos:**

- `MegaSena` - Implementação principal da simulação do jogo MegaSena.
