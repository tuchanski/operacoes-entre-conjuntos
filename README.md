# Projeto Operações entre Conjuntos
<p> O objetivo do programa é realizar operações entre conjuntos de dados através de um arquivo de texto (.txt) como entrada. Projeto criado para a matéria de "Resolução de Problemas de Natureza Discreta", da PUCPR. </p>

## Tecnologias

- Linguagem: Java
- IDEs: Visual Studio Code e REPLIT

## Funcionalidades

Este projeto oferece as seguintes funcionalidades:

1. **União de conjuntos**: Realiza a união de dois conjuntos.
2. **Diferença de conjuntos**: Realiza a diferença entre dois conjuntos.
3. **Produto Cartesiano**: Realiza a operação de produto cartesiano entre dois conjuntos.
4. **Interseção**: Realiza a interseção entre dois conjuntos.

## Como Usar
1. Certifique-se de possuir um ambiente Java configurado.
2. Clone este repositório:

```bash
git clone https://github.com/tuchanski/matematica-discreta-conjuntos
```

3. Navegue até o diretório do projeto:
```bash
cd matematica-discreta-conjuntos
```

4. Compile o programa:
```bash
javac src\main\java\Main.java
```
5. Execute o programa:
```bash
java src\main\java\Main.java
```
6. O programa pedirá uma entrada (.txt) com uma formatação válida. E assim, realizará as operações pedidas entre os conjuntos declarados. Exemplo de entrada:
```bash
dados_teste/dados1.txt
```

## Criação do (.txt) corretamente formatado

1. Na primeira linha, insira o número de operações que será realizado.

2. Em seguida, para cada operação, siga o padrão:
<br><br>
a. Escreva o tipo de operação (U para união, I para interseção, D para diferença, C para produto cartesiano).
<br><br>
b. Liste os conjuntos envolvidos na operação.
<br><br>
c. Liste os elementos de cada conjunto separados por vírgulas.

## Exemplo de arquivo (.txt)
2<br>
U<br>
3, 5, 7, 9<br>
1, 2, 3, 4<br>
D<br>
1, A, C, 34<br>
A, C, D, 23<br>

## Exemplo de Uso
```bash
- Seja bem-vindo! Lembre-se de inserir um arquivo no formato válido.
- Entrada padrão p/ replit: dados_teste/nome_do_arquivo.txt
- Entre o caminho do (.txt) a ser lido: c:\\temp\\dados1.txt

União: conjunto 1 [3, 5, 7, 9], conjunto 2 [1, 2, 3, 4]. Resultado: [1, 2, 3, 4, 5, 7, 9]


Diferença: conjunto 1 [1, A, 34, C], conjunto 2 [A, 23, C, D]. Resultado: [1, 34]

