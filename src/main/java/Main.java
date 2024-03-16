/* Guilherme Tuchanski Rocha
 * OBS: Conforme esclarecido com professor, utilizarei Java.
 * Para obter os pontos relativos a este trabalho, você deverá criar um programa, utilizando a
 * linguagem Python, C, ou C++. Este programa, quando executado, irá apresentar os resultados de
 * operações que serão realizadas entre dois conjuntos de dados.
 * O programa que você desenvolverá irá receber como entrada um arquivo de texto (.txt)
 * contendo vários conjuntos de dados e várias operações. Estas operações e dados estarão representadas
 * em um arquivo de textos contendo apenas os dados referentes as operações que devem ser realizadas
 * segundo a seguinte regra fixa: a primeira linha do arquivo de texto de entrada conterá o número de
 * operações que estão descritas no arquivo, este número de operações será um inteiro; as linhas
 * seguintes seguirão sempre o mesmo padrão de três linhas: a primeira linha apresenta o código da
 * operação (U para união, I para interseção, D para diferença e C produto cartesiano), a segunda e
 * terceira linhas conterão os elementos dos conjuntos separados por virgulas. A seguir está um exemplo
 * das linhas que podem existir em um arquivo de testes para o programa que você irá desenvolver:
 * 4
 * U
 * 3, 5, 67, 7
 * 1, 2, 3, 4
 * I
 * 1, 2, 3, 4, 5
 * 4, 5
 * D
 * 1, A, C, 34
 * A, C, D, 23
 * C
 * 3, 4, 5, 5, A, B, R
 * 1, B, C, D, 1
 * Neste exemplo temos 4 operações uma união (U), uma interseção (I), um diferença (D) e um
 * produto cartesiano (C). A união, definida por U, deverá ser executada sobre os conjuntos {𝟑, 𝟓, 𝟔𝟕, 𝟕} e
 * {𝟏, 𝟐, 𝟑, 𝟒}, cujos elementos estão explicitados nas linhas posteriores a definição da operção (U).
 * A resposta do seu programa deverá conter a operação realizada, descrita por extenso, os dados
 * dos conjuntos identificados, e o resultado da operação. No caso da união a linha de saída deverá conter
 * a informação e a formatação mostrada a seguir:
 * União: conjunto 1 {3, 5, 67, 7}, conjunto 2 {1, 2, 3, 4}. Resultado: {3, 5, 67, 7, 1, 2, 4}
 * Seu programa deverá mostrar a saída no terminal, ou em um arquivo de textos. Em qualquer
 * um dos casos, a saída será composta por uma linha de saída para cada operação constante no arquivo
 * de textos de entrada formatada segundo o exemplo de saída acima. Observe as letras maiúsculas e
 * minúsculas, e os pontos utilizados na formatação da linha de saída apresenta acima.
 * No caso do texto de exemplo, teremos 4 linhas, e apenas 4 linhas de saída, formatadas e
 * pontuadas conforme o exemplo de saída acima. O uso de linhas extras na saída, ou erros de formatação,
 * implicam em perda de pontos como pode ser visto na rubrica de avaliação constante neste documento.
 * Para que seu programa possa ser testado você deve criar, no mínimo, três arquivos de entrada
 * contendo um número diferente de operações, operações com dados diferentes, e operações em ordem
 * Página | 3 de 3
 * Andrey Cabral
 * Exercicios, pesquisas e atividades
 * EXERCÍCIOS AVALIAÇÃO INDIVIDUAL
 * diferentes. Os arquivos de entrada criados para os seus testes devem estar disponíveis tanto no
 * ambiente repl.it quanto no ambiente Github.
 * Observe que o professor irá testar seu programa com os arquivos de testes que você criar e com,
 * no mínimo um arquivo de testes criado pelo próprio professor.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
          System.out.println("- Seja bem-vindo! Lembre-se de inserir um arquivo no formato válido.");
            System.out.print("- Entre o caminho do .txt para ser lido: ");
            String path = input.next(); // Favor ir até a pasta de dados e inserir o caminho do arquivo escolhido. Padrão: dados_teste/nome_do_arquivo.txt
            // Exemplo: dados_teste/dados1.txt

            File arquivo = new File(path);
            Scanner scanner = new Scanner(arquivo);

            int numOperacoes = Integer.parseInt(scanner.nextLine().trim()); // Lê a primeira linha - número de operações
            for (int i = 0; i < numOperacoes; i++) {

                System.out.println();
                String operacao = scanner.nextLine().trim(); // Pega o tipo da operação
                Set<String> conjunto1 = lerConjunto(scanner.nextLine().trim()); // Primeiro conjunto
                Set<String> conjunto2 = lerConjunto(scanner.nextLine().trim()); // Segundo conjunto
                Set<String> resultado = new HashSet<>(); // Hashset - interface de Set que não permite duplicatas

                // Verifica operação e a realiza.
                switch (operacao) {
                    case "U": // Para união
                        resultado.addAll(conjunto1);
                        resultado.addAll(conjunto2);
                        System.out.printf("União: conjunto 1 %s, conjunto 2 %s. Resultado: %s%n",
                                conjunto1, conjunto2, resultado);
                        break;
                    case "I": // Para interseção
                        resultado.addAll(conjunto1);
                        resultado.retainAll(conjunto2);
                        System.out.printf("Interseção: conjunto 1 %s, conjunto 2 %s. Resultado: %s%n",
                                conjunto1, conjunto2, resultado);
                        break;
                    case "D": // Para diferença
                        resultado.addAll(conjunto1);
                        resultado.removeAll(conjunto2);
                        System.out.printf("Diferença: conjunto 1 %s, conjunto 2 %s. Resultado: %s%n",
                                conjunto1, conjunto2, resultado);
                        break;
                    case "C": // Para produto cartesiano
                        for (String elemento1 : conjunto1) {
                            for (String elemento2 : conjunto2) {
                                resultado.add("(" + elemento1 + ", " + elemento2 + ")");
                            }
                        }
                        System.out.printf("Cartesiano: conjunto 1 %s, conjunto 2 %s. Resultado: %s%n",
                                conjunto1, conjunto2, resultado);
                        break;
                    default:
                        System.out.println("Operação inválida.");
                }
                System.out.println();
            }
            input.close();
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }

    // Função que lê um conjunto
    private static Set<String> lerConjunto(String linha) {
        String[] elementos = linha.split(",");
        Set<String> conjunto = new HashSet<>();
        for (String elemento : elementos) {
            conjunto.add(elemento.trim());
        }
        return conjunto;
    }
}