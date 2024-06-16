import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogoUI extends JFrame {
  private CatalogoDeLivros catalogo;
  private JTextField isbnField;
  private JLabel capaLabel;
  private JLabel tituloLabel;
  private JLabel autorLabel;
  private JLabel isbnInfoLabel;
  private JLabel editoraLabel;
  private JLabel dataPublicacaoLabel;
  private JTextArea descricaoArea;
  private JLabel generoLabel;

  public CatalogoUI() {
    catalogo = new CatalogoDeLivros();
    initComponents();
  }

  private void initComponents() {
    setTitle("Catálogo de Livros");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout(10, 10));
    setLocationRelativeTo(null);

    JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    JLabel isbnPromptLabel = new JLabel("ISBN:");
    isbnField = new JTextField(20);

    JButton buscarButton = new JButton("Buscar");
    buscarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        buscarLivro();
      }
    });

    JButton adicionarButton = new JButton("Adicionar Livro");
    adicionarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        abrirInterfaceDeCadastro();
      }
    });

    searchPanel.add(isbnPromptLabel);
    searchPanel.add(isbnField);
    searchPanel.add(buscarButton);
    searchPanel.add(adicionarButton);

    add(searchPanel, BorderLayout.NORTH);

    JPanel resultadoPanel = new JPanel(new BorderLayout(10, 10));

    capaLabel = new JLabel();
    capaLabel.setPreferredSize(new Dimension(150, 200));
    resultadoPanel.add(capaLabel, BorderLayout.WEST);

    JPanel infoPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.anchor = GridBagConstraints.WEST;

    tituloLabel = createInfoLabel("Título:", infoPanel, gbc, 0);
    autorLabel = createInfoLabel("Autor:", infoPanel, gbc, 1);
    isbnInfoLabel = createInfoLabel("ISBN:", infoPanel, gbc, 2);
    editoraLabel = createInfoLabel("Editora:", infoPanel, gbc, 3);
    dataPublicacaoLabel = createInfoLabel("Data de Publicação:", infoPanel, gbc, 4);
    descricaoArea = createTextArea("Descrição:", infoPanel, gbc, 5);
    generoLabel = createInfoLabel("Gênero:", infoPanel, gbc, 6);

    resultadoPanel.add(infoPanel, BorderLayout.CENTER);

    add(resultadoPanel, BorderLayout.CENTER);
  }

  private JLabel createInfoLabel(String labelText, JPanel panel, GridBagConstraints gbc, int row) {
    JLabel label = new JLabel(labelText);
    JLabel valueLabel = new JLabel();
    valueLabel.setPreferredSize(new Dimension(400, 20));
    gbc.gridx = 0;
    gbc.gridy = row;
    panel.add(label, gbc);
    gbc.gridx = 1;
    panel.add(valueLabel, gbc);
    return valueLabel;
  }

  private JTextArea createTextArea(String labelText, JPanel panel, GridBagConstraints gbc, int row) {
    JLabel label = new JLabel(labelText);
    JTextArea textArea = new JTextArea(5, 20);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(400, 100));
    gbc.gridx = 0;
    gbc.gridy = row;
    panel.add(label, gbc);
    gbc.gridx = 1;
    panel.add(scrollPane, gbc);
    return textArea;
  }

  private void buscarLivro() {
    LivroUtils livroUtils = new LivroUtils();
    String isbn = isbnField.getText();
    int posicao = livroUtils.buscar_livro(isbn, catalogo.livros);
    if (posicao != -1) {
      Livro livro = (Livro) catalogo.livros.pega(posicao);
      tituloLabel.setText(livro.getTitulo());
      autorLabel.setText(livro.getAutor());
      isbnInfoLabel.setText(livro.getIsbn());
      editoraLabel.setText(livro.getEditora());
      dataPublicacaoLabel.setText(livro.getDataPublicacao());
      descricaoArea.setText(livro.getDescricao());
      generoLabel.setText(livro.getGenero());
      ImageIcon capaIcon = new ImageIcon(livro.getCaminhoCapa());
      capaLabel.setIcon(new ImageIcon(capaIcon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
    } else {
      tituloLabel.setText("");
      autorLabel.setText("");
      isbnInfoLabel.setText("");
      editoraLabel.setText("");
      dataPublicacaoLabel.setText("");
      descricaoArea.setText("");
      generoLabel.setText("");
      capaLabel.setIcon(null);
      JOptionPane.showMessageDialog(this, "Livro não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void abrirInterfaceDeCadastro() {
    CadastroLivroUI cadastroUI = new CadastroLivroUI(this);
    cadastroUI.setVisible(true);
  }

  public void adicionarLivroAoCatalogo(Livro livro) {
    catalogo.adicionarLivro(livro);
    JOptionPane.showMessageDialog(this, "Livro adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void main(String[] args) {
    CatalogoUI ui = new CatalogoUI();
    ui.setVisible(true);
  }
}
