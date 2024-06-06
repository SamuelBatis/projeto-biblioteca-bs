import java.util.Random;

public class TesteBuscas {
  public static void main(String[] args) {
    int tamanhoArray = 1000000;
    int[] array = new int[tamanhoArray];
    Random random = new Random();

    // Preenche o array com valores ordenados
    for (int i = 0; i < tamanhoArray; i++) {
      array[i] = i * 2; // Garantir que os valores sejam distintos e ordenados
    }

    // Escolhe um valor aleatório do array para buscar
    int valorBusca = array[random.nextInt(tamanhoArray)];

    long inicio, fim;

    // Teste da Pesquisa Binária
    inicio = System.nanoTime();
    int resultadoBinaria = Buscas.pesquisaBinaria(array, 0, tamanhoArray - 1, valorBusca);
    fim = System.nanoTime();
    long tempoBinaria = fim - inicio;
    System.out.println("Resultado da Pesquisa Binária: " + resultadoBinaria);
    System.out.println("Tempo da Pesquisa Binária: " + tempoBinaria + " ns");

    // Teste da Pesquisa Ternária
    inicio = System.nanoTime();
    int resultadoTernaria = Buscas.pesquisaTernaria(array, 0, tamanhoArray - 1, valorBusca);
    fim = System.nanoTime();
    long tempoTernaria = fim - inicio;
    System.out.println("Resultado da Pesquisa Ternária: " + resultadoTernaria);
    System.out.println("Tempo da Pesquisa Ternária: " + tempoTernaria + " ns");

    // Teste da Pesquisa por Interpolação
    inicio = System.nanoTime();
    int resultadoInterpolacao = Buscas.interpolacaop(array, 0, tamanhoArray - 1, valorBusca);
    fim = System.nanoTime();
    long tempoInterpolacao = fim - inicio;
    System.out.println("Resultado da Pesquisa por Interpolação: " + resultadoInterpolacao);
    System.out.println("Tempo da Pesquisa por Interpolação: " + tempoInterpolacao + " ns");

    // Comparação dos tempos de execução
    System.out.println("A pesquisa binária foi " + (tempoBinaria / (double) tempoTernaria)
        + " vezes mais rápida que a pesquisa ternária.");
    System.out.println("A pesquisa binária foi " + (tempoBinaria / (double) tempoInterpolacao)
        + " vezes mais rápida que a pesquisa por interpolação.");
    System.out.println("A pesquisa ternária foi " + (tempoTernaria / (double) tempoInterpolacao)
        + " vezes mais rápida que a pesquisa por interpolação.");
  }
}
