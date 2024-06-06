
class FilaPilha {
  private Pilha entrada = new Pilha();
  private Pilha saida = new Pilha();

  public void enfileirar(Object item) {

    entrada.push(item);

  }

  public Object desenfileirar() {
    if (saida.vazia()) {
      while (!entrada.vazia())
        saida.push(entrada.pop());
    }
    return saida.pop();
  }

  public boolean vazia() {
    return entrada.vazia() && saida.vazia();
  }
}
