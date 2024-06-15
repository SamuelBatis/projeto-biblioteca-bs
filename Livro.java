public class Livro {
  private String titulo;
  private String autor;
  private String isbn;
  private String editora;
  private String dataPublicacao;
  private String descricao;
  private String genero;
  private String caminhoCapa;

  public Livro(String titulo, String autor, String isbn, String editora, String dataPublicacao, String descricao,
      String genero, String caminhoCapa) {
    this.titulo = titulo;
    this.autor = autor;
    this.isbn = isbn;
    this.editora = editora;
    this.dataPublicacao = dataPublicacao;
    this.descricao = descricao;
    this.genero = genero;
    this.caminhoCapa = caminhoCapa;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getEditora() {
    return editora;
  }

  public String getDataPublicacao() {
    return dataPublicacao;
  }

  public String getDescricao() {
    return descricao;
  }

  public String getGenero() {
    return genero;
  }

  public String getCaminhoCapa() {
    return caminhoCapa;
  }

  @Override
  public String toString() {
    return "Livro{" +
        "titulo='" + titulo + '\'' +
        ", autor='" + autor + '\'' +
        ", isbn='" + isbn + '\'' +
        ", editora='" + editora + '\'' +
        ", dataPublicacao='" + dataPublicacao + '\'' +
        ", descricao='" + descricao + '\'' +
        ", genero='" + genero + '\'' +
        '}';
  }
}
