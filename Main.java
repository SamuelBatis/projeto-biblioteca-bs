import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
  private Catalogo catalogo;
  private JTextField tituloField, autorField, isbnField, editoraField, dataPublicacaoField, buscarIsbnField;
  private JTextArea resultadoArea;

  public Main() {
    catalogo = new Catalogo();

    setTitle("Catálogo de Livros");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    JPanel painelCadastro = new JPanel();
    painelCadastro.setLayout(new GridLayout(6, 2));

    painelCadastro.add(new JLabel("Título:"));
    tituloField = new JTextField();
    painelCadastro.add(tituloField);

    painelCadastro.add(new JLabel("Autor:"));
    autorField = new JTextField();
    painelCadastro.add(autorField);

    painelCadastro.add(new JLabel("ISBN:"));
    isbnField = new JTextField();
    painelCadastro.add(isbnField);

    painelCadastro.add(new JLabel("Editora:"));
    editoraField = new JTextField();
    painelCadastro.add(editoraField);

    painelCadastro.add(new JLabel("Data de Publicação:"));
    dataPublicacaoField = new JTextField();
    painelCadastro.add(dataPublicacaoField);

    JButton adicionarButton = new JButton("Adicionar Livro");
    adicionarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        adicionarLivro();
      }
    });
    painelCadastro.add(adicionarButton);

    add(painelCadastro, BorderLayout.NORTH);

    JPanel painelBusca = new JPanel();
    painelBusca.setLayout(new FlowLayout());

    painelBusca.add(new JLabel("Buscar ISBN:"));
    buscarIsbnField = new JTextField(10);
    painelBusca.add(buscarIsbnField);

    JButton buscarButton = new JButton("Buscar");
    buscarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        buscarLivro();
      }
    });
    painelBusca.add(buscarButton);

    add(painelBusca, BorderLayout.CENTER);

    resultadoArea = new JTextArea();
    resultadoArea.setEditable(false);
    add(new JScrollPane(resultadoArea), BorderLayout.SOUTH);
  }

  private void adicionarLivro() {
    String titulo = tituloField.getText();
    String autor = autorField.getText();
    String isbn = isbnField.getText();
    String editora = editoraField.getText();
    String dataPublicacao = dataPublicacaoField.getText();

    Livro livro = new Livro(titulo, autor, isbn, editora, dataPublicacao);
    catalogo.adicionarLivro(livro);

    tituloField.setText("");
    autorField.setText("");
    isbnField.setText("");
    editoraField.setText("");
    dataPublicacaoField.setText("");

    resultadoArea.setText("Livro adicionado ao catálogo.");
  }

  private void buscarLivro() {
    String isbn = buscarIsbnField.getText();
    int indice = catalogo.buscarLivro(isbn);

    if (indice != -1) {
      Livro livro = catalogo.getLivros().get(indice);
      resultadoArea.setText("Livro encontrado:\n" + livro);
    } else {
      resultadoArea.setText("Livro com ISBN " + isbn + " não encontrado.");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Main().setVisible(true);
      }
    });
  }
}