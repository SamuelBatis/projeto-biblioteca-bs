class Livro {
  private String titulo;
  private String autor;
  private String isbn;
  private String editora;
  private String dataPublicacao;

  public Livro(String titulo, String autor, String isbn, String editora, String dataPublicacao) {
    this.titulo = titulo;
    this.autor = autor;
    this.isbn = isbn;
    this.editora = editora;
    this.dataPublicacao = dataPublicacao;
  }

  public String getIsbn() {
    return isbn;
  }

  @Override
  public String toString() {
    return "Livro{" +
        "titulo='" + titulo + '\'' +
        ", autor='" + autor + '\'' +
        ", isbn='" + isbn + '\'' +
        ", editora='" + editora + '\'' +
        ", dataPublicacao='" + dataPublicacao + '\'' +
        '}';
  }
}