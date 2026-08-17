# Encapsulamento

## O que é

Encapsulamento é o pilar da orientação a objetos que consiste em **ocultar o
estado interno de um objeto** (seus atributos) e **controlar como esse estado
é acessado ou modificado**, expondo apenas o que for necessário através de
métodos públicos.

Na prática, em Java isso normalmente aparece como:

```java
public class Exemplo {
    private double valor; // atributo oculto (private)

    public double getValor() {      // acesso controlado para leitura
        return valor;
    }

    public void setValor(double valor) { // acesso controlado para escrita
        this.valor = valor;
    }
}
```

## "Sem getter e setter não tem encapsulamento" — correto?

Quase, mas precisa de um ajuste importante: **o que define o encapsulamento é
o atributo ser `private` (estado oculto) + o acesso a ele ser controlado por
métodos**. O par getter/setter é apenas **a forma mais comum** de fazer esse
controle — não é a única, e não é obrigatória para todo atributo.

Isso significa que existem variações, todas válidas como encapsulamento:

### 1. Getter e setter (o caso "clássico")
Atributo privado, leitura e escrita liberadas via métodos. É o mais comum
quando o dado pode ser lido e alterado livremente de fora da classe.

```java
private double primeiroValor;
public double getPrimeiroValor() { return primeiroValor; }
public void setPrimeiroValor(double v) { this.primeiroValor = v; }
```

### 2. Somente getter (atributo "somente leitura")
O atributo pode ser lido de fora, mas só é alterado internamente pela própria
classe (normalmente por regra de negócio, não por um setter arbitrário). Isso
é encapsulamento tão (ou mais) legítimo quanto o par completo — é assim que
se protege um dado calculado ou um invariante.

```java
private double resultado;
public double getResultado() { return resultado; } // não existe setResultado
```

Exemplo na `Calculadora` desta aula: `resultado` só muda quando você chama
`somar()`, `subtrair()`, `multiplicar()` ou `dividir()` — nunca diretamente.

### 3. Somente setter (mais raro)
O valor pode ser definido de fora, mas não lido diretamente (ex.: senha, que
você define mas não expõe em texto puro depois). Também é encapsulamento.

### 4. Nenhum accessor público (ocultação total)
O atributo é privado e usado só internamente pela classe, sem getter nem
setter. É o grau mais forte de encapsulamento: o dado nem existe do ponto de
vista de quem usa a classe.

### 5. Setter com validação/regra de negócio
Onde o encapsulamento realmente mostra seu valor: o setter não apenas guarda
o valor, ele impede estados inválidos.

```java
public void setSegundoValor(double v) {
    if (v == 0) {
        throw new IllegalArgumentException("Segundo valor não pode ser zero");
    }
    this.segundoValor = v;
}
```

### 6. Getter computado
O getter pode retornar um valor calculado na hora, sem que exista um atributo
armazenado com esse nome.

```java
public double getArea() { return largura * altura; }
```

## Resumo da regra correta

- **Obrigatório para ter encapsulamento:** atributo `private` (estado
  oculto/protegido) + acesso controlado por métodos da própria classe.
- **Não obrigatório:** ter os dois (getter *e* setter) para todo atributo.
  Ter só um dos dois, ou nenhum, também é encapsulamento — geralmente um
  encapsulamento *mais rigoroso*, porque limita ainda mais o que o mundo de
  fora pode fazer com o objeto.
- Atributo `public` sem controle nenhum = **não há** encapsulamento, esse
  caso sim quebra a regra.

## Aplicado na `Calculadora`

A classe `Calculadora` (`demo/src/main/java/com/example/Calculadora.java`)
usa três dessas variações ao mesmo tempo:

| Atributo         | Getter | Setter | Por quê |
|------------------|--------|--------|---------|
| `primeiroValor`  | sim    | sim    | operando livre para o usuário da classe definir |
| `segundoValor`   | sim    | sim    | operando livre para o usuário da classe definir |
| `resultado`      | sim    | não    | só a própria classe pode mudar, executando uma operação |

Além disso, `dividir()` protege um invariante (não dividir por zero) — esse é
o "controle de acesso" do encapsulamento em ação, não apenas mover valores
para dentro e para fora do objeto.
