public class CatalogoDeLivros {
  public ListaLigadaD livros;

  public CatalogoDeLivros() {
    this.livros = new ListaLigadaD();
    inicializarCatalogo();
  }

  private void inicializarCatalogo() {
    adicionarLivro(new Livro("Livro A", "Autor A", "1234567890", "Editora A", "01/01/2020", "Descrição do Livro A",
        "Ficção", "./capas/91+1SUO3vUL._AC_UF1000,1000_QL80_.jpg"));
    adicionarLivro(new Livro("Crime e Castigo", "Fiodor Dostoievski", "9788420741468", "Martin Claret", "01/06/2013",
        "Crime e castigo é um daqueles romances universais que, concebidos no decorrer do romântico século XIX, abriram caminhos ao trágico realismo literário dos tempos modernos. Contando nele a soturna história de um assassino em busca de redenção e ressurreição espiritual, Dostoiévski chegou a explorar, como nenhum outro escritor de sua época, as mais diversas facetas da psicologia humana sujeita a abalos e distorções e, desse modo, criou uma obra de imenso valor artístico, merecidamente cultuada em todas as partes do mundo. O fascinante efeito que produz a leitura de Crime e castigo ― angústia, revolta e compaixão renovadas a cada página com um desenlace aliviador ― poderia ser comparado à catarse dos monumentais dramas gregos.",
        "Não Ficção", "./capas/crime-castigo.jpg"));
    adicionarLivro(new Livro("Livro C", "Autor C", "1122334455", "Editora C", "03/03/2022", "Descrição do Livro C",
        "Romance", "./capas/Metamorf.jpg"));
  }

  public void adicionarLivro(Livro livro) {
    livros.adiciona(livro);
    ordenarLivrosPorISBN();
  }

  public int buscarLivro(String isbn) {
    return buscarLivroBinario(isbn, 0, livros.tamanho() - 1);
  }

  private void ordenarLivrosPorISBN() {
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
    int min = inicio;
    int max = fim;
    while (min <= max) {
      int med = (min + max) >>> 1;
      Livro livro = (Livro) livros.pega(med);
      int comparacao = livro.getIsbn().compareTo(isbn);
      if (comparacao == 0) {
        return med;
      }
      if (comparacao < 0) {
        min = med + 1;
      } else {
        max = med - 1;
      }
    }
    return -1;
  }
}
