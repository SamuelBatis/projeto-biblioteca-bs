
public class Pilha {
  private ListaLigadaD lista = new ListaLigadaD();

  public void push(Object elemento) {
    this.lista.adiciona(elemento);
  }

  public boolean vazia() {
    return this.lista.tamanho() > 0 ? false : true;
  }

  public Object pop() {
    if (!vazia()) {
      Object dados = this.lista.pega(lista.tamanho() - 1);
      this.lista.remove(lista.tamanho() - 1);
      // this.lista.removeDoFim();
      return dados;
    }
    return null;
  }

  /*
   * public ListaLigada mostra() {
   * return this.lista;
   * }
   */

}
