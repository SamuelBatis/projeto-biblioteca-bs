public class CatalogoDeLivros {
  public ListaLigadaD livros;

  public CatalogoDeLivros() {
    this.livros = new ListaLigadaD();
    inicializarCatalogo();
  }

  private void inicializarCatalogo() {
    adicionarLivro(
        new Livro("Gerra dos Tronos", "George R.R Martin", "9788496208490", "Bantam Spectra", "01/08/1996",
            "A guerra dos tronos é o primeiro livro da série best-seller internacional As Crônicas de Gelo e Fogo, que deu origem à adaptação de sucesso da HBO, Game of Thrones.\n"
                + //
                "O verão pode durar décadas. O inverno, toda uma vida. E a guerra dos tronos começou. Como Guardião do Norte, lorde Eddard Stark não fica feliz quando o rei Robert o proclama a nova Mão do Rei. Sua honra o obriga a aceitar o cargo e deixar seu posto em Winterfell para rumar para a corte, onde os homens fazem o que lhes convém, não o que devem... e onde um inimigo morto é algo a ser admirado.\n"
                + //
                "",
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

}
