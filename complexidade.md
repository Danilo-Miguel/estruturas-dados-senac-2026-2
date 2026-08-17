# Complexidade de algoritmos (de forma simples)

## A ideia, em uma frase

Complexidade mede **quanto trabalho um algoritmo faz conforme a entrada
cresce**. Não é medir tempo em segundos no relógio — é medir quantos passos
ele dá.

## As duas que interessam hoje

### Busca linear — O(n)

Procura item por item, do começo ao fim, até achar (ou até acabar o array).

- Array com 10 itens → até 10 passos.
- Array com 1.000.000 de itens → até 1.000.000 de passos.
- **Regra:** dobrou o array, dobra o trabalho no pior caso.

### Busca binária — O(log n)

Só funciona em array **ordenado**. A cada passo, olha o item do meio e
descarta metade do array (a metade onde o alvo não pode estar).

- Array com 10 itens → no máximo ~4 passos.
- Array com 1.000.000 de itens → no máximo ~20 passos.
- **Regra:** dobrou o array, adiciona só mais 1 passo.

## Por que isso importa

| Tamanho do array | Busca linear (pior caso) | Busca binária (pior caso) |
|-------------------|---------------------------|------------------------------|
| 10                 | 10 passos                 | ~4 passos                    |
| 1.000              | 1.000 passos               | ~10 passos                   |
| 1.000.000          | 1.000.000 passos           | ~20 passos                   |

A busca linear cresce junto com o array. A busca binária cresce muito
devagar, porque a cada passo ela corta o problema pela metade.

## No código (`Busca.java`)

- `buscaLinear` — um laço `for` simples, olhando posição por posição.
- `buscaBinaria` — um laço `while` que guarda um `inicio` e um `fim`, calcula
  o `meio`, e decide se descarta a metade da esquerda ou da direita.

Ambos os métodos estão comentados linha a linha no código-fonte.
