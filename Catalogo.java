// Classe Catalogo
class Catalogo {
  private ListaLigadaD livros;

  public Catalogo() {
    this.livros = new ListaLigadaD();
  }

  public void adicionarLivro(Livro livro) {
    livros.adiciona(livro);
    ordenarLivrosPorISBN(); // Garante que a lista esteja ordenada após adicionar um novo livro
  }

  public ListaLigadaD getLivros() {
    return livros;
  }

  public int buscarLivro(String isbn) {
    return buscarLivroBinario(isbn, 0, livros.tamanho() - 1);
  }

  private void ordenarLivrosPorISBN() {
    // Implementar ordenação por inserção direta
    ListaLigadaD livrosOrdenados = new ListaLigadaD();

    int tamanho = livros.tamanho();
    for (int i = 0; i < tamanho; i++) {
      Livro livroAtual = (Livro) livros.pega(i);
      inserirOrdenado(livrosOrdenados, livroAtual);
    }

    this.livros = livrosOrdenados;
  }

  private void inserirOrdenado(ListaLigadaD lista, Livro livro) {
    int tamanho = lista.tamanho();
    int posicao = 0;

    while (posicao < tamanho) {
      Livro livroNaLista = (Livro) lista.pega(posicao);
      if (livro.getIsbn().compareTo(livroNaLista.getIsbn()) < 0) {
        break;
      }
      posicao++;
    }

    lista.adiciona(posicao, livro);
  }

  private int buscarLivroBinario(String isbn, int inicio, int fim) {
    // Converte a lógica do seu algoritmo de busca binária para trabalhar com ISBN
    int min = inicio;
    int max = fim;
    while (min <= max) {
      int med = (min + max) >>> 1;
      Livro livro = (Livro) livros.pega(med);
      int comparacao = livro.getIsbn().compareTo(isbn);

      if (comparacao == 0) {
        return med; // ISBN encontrado
      }
      if (comparacao < 0) {
        min = med + 1;
      } else {
        max = med - 1;
      }
    }
    return -1; // ISBN não encontrado
  }
}
