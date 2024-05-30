import java.util.LinkedList;

// Classe Catalogo
class Catalogo {
  private LinkedList<Livro> livros;

  public Catalogo() {
    this.livros = new LinkedList<>();
  }

  public void adicionarLivro(Livro livro) {
    // Assumindo que os livros são adicionados em ordem crescente de ISBN
    livros.add(livro);
  }

  public LinkedList<Livro> getLivros() {
    return livros;
  }

  public int buscarLivro(String isbn) {
    return buscarLivroBinario(isbn, 0, livros.size() - 1);
  }

  private int buscarLivroBinario(String isbn, int inicio, int fim) {
    if (inicio <= fim) {
      int meio = inicio + (fim - inicio) / 2;
      Livro livro = livros.get(meio);
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