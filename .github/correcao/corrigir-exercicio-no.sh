#!/usr/bin/env bash
# Correcao automatica do exercicio: extrair a classe No de
# ArvoreExemploSimples.java para o arquivo No.java, sem renomear
# metodos nem variaveis, e manter o programa funcionando igual.

set -u

SRC="demo/src/main/java/com/example"
ARVORE="$SRC/ArvoreExemploSimples.java"
NO="$SRC/No.java"
ESPERADA=".github/correcao/saida-esperada.txt"
BUILD="$(mktemp -d)"

falhas=0
ok()    { echo "  [OK]    $1"; }
falha() { echo "  [FALHA] $1"; falhas=$((falhas + 1)); }

# Remove comentarios para as buscas no codigo nao serem enganadas por eles.
sem_comentarios() {
    sed -e 's://.*$::' "$1" | perl -0pe 's:/\*.*?\*/::gs'
}

echo "== 1. Arquivos =="
if [ -f "$NO" ]; then ok "No.java existe em $SRC"; else falha "No.java nao foi encontrado em $SRC"; fi
if [ -f "$ARVORE" ]; then ok "ArvoreExemploSimples.java existe"; else falha "ArvoreExemploSimples.java nao foi encontrado"; fi

if [ "$falhas" -gt 0 ]; then
    echo
    echo "Correcao interrompida: arquivos obrigatorios ausentes."
    exit 1
fi

echo
echo "== 2. Estrutura do codigo-fonte =="
if sem_comentarios "$ARVORE" | grep -Eq '\bclass[[:space:]]+No\b'; then
    falha "ArvoreExemploSimples.java ainda declara a classe No (ela deve sair daqui)"
else
    ok "A classe No foi removida de ArvoreExemploSimples.java"
fi

if sem_comentarios "$NO" | grep -Eq '^[[:space:]]*package[[:space:]]+com\.example[[:space:]]*;'; then
    ok "No.java esta no pacote com.example"
else
    falha "No.java deve declarar 'package com.example;'"
fi

if sem_comentarios "$NO" | grep -Eq '\bclass[[:space:]]+No\b'; then
    ok "No.java declara a classe No"
else
    falha "No.java nao declara 'class No'"
fi

# Com getters e setters, ArvoreExemploSimples nao deve acessar os atributos direto.
ACESSO_DIRETO="$(sem_comentarios "$ARVORE" | grep -nE '\.(nome|filhos)\b')"
if [ -z "$ACESSO_DIRETO" ]; then
    ok "ArvoreExemploSimples nao acessa .nome/.filhos diretamente"
else
    falha "ArvoreExemploSimples ainda acessa atributos de No diretamente (use os getters):"
    echo "$ACESSO_DIRETO" | sed 's/^/            /'
fi

# As variaveis locais do main devem continuar com os mesmos nomes.
for var in raiz financeiro vendas suporte contas cobranca lojaFisica lojaOnline; do
    if sem_comentarios "$ARVORE" | grep -Eq "\bNo[[:space:]]+$var[[:space:]]*="; then
        ok "Variavel '$var' mantida no main"
    else
        falha "Variavel '$var' nao encontrada no main (o nome nao pode ser alterado)"
    fi
done

echo
echo "== 3. Compilacao =="
if javac -encoding UTF-8 -d "$BUILD" "$SRC"/*.java; then
    ok "Projeto compilou"
else
    falha "Erro de compilacao (veja as mensagens acima)"
    echo
    echo "Correcao interrompida: o codigo precisa compilar."
    exit 1
fi

if [ -f "$BUILD/com/example/ArvoreExemploSimples\$No.class" ]; then
    falha "Ainda existe uma classe aninhada ArvoreExemploSimples.No"
fi
if [ -f "$BUILD/com/example/No.class" ]; then
    ok "Classe com.example.No gerada como classe de topo"
else
    falha "Classe com.example.No nao foi gerada"
fi

echo
echo "== 4. Nomes de metodos, atributos e construtor =="
ASSIN_NO="$(javap -p -cp "$BUILD" com.example.No 2>/dev/null)"
ASSIN_ARV="$(javap -p -cp "$BUILD" com.example.ArvoreExemploSimples 2>/dev/null)"

confere() { # $1 = assinaturas, $2 = regex, $3 = descricao
    if echo "$1" | grep -Eq "$2"; then ok "$3"; else falha "$3 nao encontrado"; fi
}

confere "$ASSIN_NO"  'private java\.lang\.String nome;'                  "No: atributo 'private String nome'"
confere "$ASSIN_NO"  'private java\.util\.List<com\.example\.No> filhos;' "No: atributo 'private List<No> filhos'"
confere "$ASSIN_NO"  'com\.example\.No\(java\.lang\.String\);'            "No: construtor 'No(String)'"
confere "$ASSIN_NO"  'void adicionarFilho\(com\.example\.No\);'           "No: metodo 'adicionarFilho(No)'"
confere "$ASSIN_NO"  'java\.lang\.String getNome\(\);'                    "No: getter 'String getNome()'"
confere "$ASSIN_NO"  'void setNome\(java\.lang\.String\);'                "No: setter 'setNome(String)'"
confere "$ASSIN_NO"  'java\.util\.List<com\.example\.No> getFilhos\(\);'  "No: getter 'List<No> getFilhos()'"
confere "$ASSIN_NO"  'void setFilhos\(java\.util\.List<com\.example\.No>\);' "No: setter 'setFilhos(List<No>)'"

confere "$ASSIN_ARV" 'static boolean ehFolha\(com\.example\.No\);'        "ArvoreExemploSimples: 'ehFolha(No)'"
confere "$ASSIN_ARV" 'static int contarNos\(com\.example\.No\);'          "ArvoreExemploSimples: 'contarNos(No)'"
confere "$ASSIN_ARV" 'static int contarFolhas\(com\.example\.No\);'       "ArvoreExemploSimples: 'contarFolhas(No)'"
confere "$ASSIN_ARV" 'static int altura\(com\.example\.No\);'             "ArvoreExemploSimples: 'altura(No)'"
confere "$ASSIN_ARV" 'static int profundidade\(com\.example\.No, java\.lang\.String, int\);' "ArvoreExemploSimples: 'profundidade(No, String, int)'"
confere "$ASSIN_ARV" 'static void exibirArvore\(com\.example\.No, int\);' "ArvoreExemploSimples: 'exibirArvore(No, int)'"
confere "$ASSIN_ARV" 'public static void main\(java\.lang\.String\[\]\);' "ArvoreExemploSimples: 'main(String[])'"

echo
echo "== 5. Execucao =="
SAIDA="$BUILD/saida.txt"
if timeout 10 java -cp "$BUILD" com.example.ArvoreExemploSimples > "$SAIDA" 2>&1; then
    ok "Programa executou sem erros"
else
    falha "Programa terminou com erro"
    cat "$SAIDA"
fi

if diff -u --strip-trailing-cr "$ESPERADA" "$SAIDA"; then
    ok "Saida identica a esperada"
else
    falha "Saida diferente da esperada (diff acima: '-' esperado, '+' obtido)"
fi

echo
if [ "$falhas" -eq 0 ]; then
    echo "RESULTADO: APROVADO - todas as verificacoes passaram."
    exit 0
else
    echo "RESULTADO: REPROVADO - $falhas verificacao(oes) falharam."
    exit 1
fi
