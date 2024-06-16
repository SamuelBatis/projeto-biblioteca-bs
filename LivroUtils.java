public class LivroUtils {

  public int buscar_livro(String isbn, ListaLigadaD livros) {
    return buscarLivroBinario(isbn, 0, livros.tamanho() - 1, livros);
  }

  private int buscarLivroBinario(String isbn, int inicio, int fim, ListaLigadaD livros) {
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
