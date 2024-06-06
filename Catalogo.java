
// Classe Catalogo
class Catalogo {
  private ListaLigadaD livros;

  public Catalogo() {
    this.livros = new ListaLigadaD();
  }

  public void adicionarLivro(Livro livro) {
    livros.adiciona(livro);
  }

  public ListaLigadaD getLivros() {
    return livros;
  }

  public int buscarLivro(String isbn) {
    return buscarLivroBinario(isbn, 0, livros.tamanho() - 1);
  }

  private int buscarLivroBinario(String isbn, int inicio, int fim) {
    if (inicio <= fim) {
      int meio = inicio + (fim - inicio) / 2;
      Livro livro = (Livro) livros.pega(meio);
      int comparacao = livro.getIsbn().compareTo(isbn);

      if (comparacao == 0) {
        return meio; // ISBN encontrado
      }
      if (comparacao < 0) {
        return buscarLivroBinario(isbn, meio + 1, fim);
      } else {
        return buscarLivroBinario(isbn, inicio, meio - 1);
      }
    }
    return -1; // ISBN não encontrado
  }
}