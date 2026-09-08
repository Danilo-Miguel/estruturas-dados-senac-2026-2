# Estruturas de Dados

Material didatico da disciplina de Estruturas de Dados do Senac. O repositorio reune exemplos desenvolvidos nas aulas, exercicios praticos e uma trilha de consulta dos conceitos.

## Cronograma

| Aula | Tema | Material |
| --- | --- | --- |
| 11/08 | Fundamentos de Java | `demo/src/main/java/com/example/Main.java` |
| 18/08 | Encapsulamento e TAD | [encapsulamento.md](encapsulamento.md) |
| 18/08 | Busca linear e busca binaria | [complexidade.md](complexidade.md) |
| 25/08 | Vetores e arrays | [docs de vetores](demo/docs/vetores/01-declaracao-vetores.md) |
| 01/09 | Exercicio: vetor de supermercado | [enunciado](exercicios/01_vetor_supermercado.md) |

## Organizacao

- `demo/src/main/java`: exemplos executaveis em Java.
- `demo/docs`: explicacoes conceituais organizadas por tema.
- `exercicios`: enunciados e propostas de pratica.

## Como executar

```text
cd demo
mvn test
```

O projeto usa Java 17 e Maven. A classe `com.example.Main` concentra as demonstracoes das aulas de vetores e analise de complexidade.