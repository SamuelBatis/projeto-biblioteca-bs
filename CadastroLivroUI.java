import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CadastroLivroUI extends JFrame {
  private JTextField tituloField;
  private JTextField autorField;
  private JTextField isbnField;
  private JTextField editoraField;
  private JTextField dataPublicacaoField;
  private JTextArea descricaoArea;
  private JTextField generoField;
  private JLabel capaLabel;
  private String caminhoCapa;

  private CatalogoUI catalogoUI;

  public CadastroLivroUI(CatalogoUI catalogoUI) {
    this.catalogoUI = catalogoUI;
    initComponents();
  }

  private void initComponents() {
    setTitle("Cadastro de Livro");
    setSize(600, 700);
    setLayout(new BorderLayout(10, 10));
    setLocationRelativeTo(null);

    JPanel formPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.anchor = GridBagConstraints.WEST;

    tituloField = createFormField("Título:", formPanel, gbc, 0);
    autorField = createFormField("Autor:", formPanel, gbc, 1);
    isbnField = createFormField("ISBN:", formPanel, gbc, 2);
    editoraField = createFormField("Editora:", formPanel, gbc, 3);
    dataPublicacaoField = createFormField("Data de Publicação:", formPanel, gbc, 4);
    generoField = createFormField("Gênero:", formPanel, gbc, 5);

    gbc.gridx = 0;
    gbc.gridy = 6;
    formPanel.add(new JLabel("Descrição:"), gbc);
    gbc.gridx = 1;
    descricaoArea = new JTextArea(5, 20);
    descricaoArea.setPreferredSize(new Dimension(300, 100));
    formPanel.add(new JScrollPane(descricaoArea), gbc);

    gbc.gridx = 0;
    gbc.gridy = 7;
    formPanel.add(new JLabel("Capa:"), gbc);
    gbc.gridx = 1;
    capaLabel = new JLabel();
    capaLabel.setPreferredSize(new Dimension(150, 200));
    formPanel.add(capaLabel, gbc);

    JButton selecionarImagemButton = new JButton("Selecionar Imagem");
    selecionarImagemButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        selecionarImagem();
      }
    });

    gbc.gridx = 1;
    gbc.gridy = 8;
    formPanel.add(selecionarImagemButton, gbc);

    JButton adicionarButton = new JButton("Adicionar Livro");
    adicionarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        adicionarLivro();
      }
    });

    gbc.gridx = 1;
    gbc.gridy = 9;
    formPanel.add(adicionarButton, gbc);

    add(formPanel, BorderLayout.CENTER);
  }

  private JTextField createFormField(String labelText, JPanel panel, GridBagConstraints gbc, int row) {
    JLabel label = new JLabel(labelText);
    JTextField textField = new JTextField(30);
    gbc.gridx = 0;
    gbc.gridy = row;
    panel.add(label, gbc);
    gbc.gridx = 1;
    panel.add(textField, gbc);
    return textField;
  }

  private void selecionarImagem() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      caminhoCapa = file.getAbsolutePath();
      ImageIcon capaIcon = new ImageIcon(caminhoCapa);
      capaLabel.setIcon(new ImageIcon(capaIcon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
    }
  }

  private void adicionarLivro() {
    String titulo = tituloField.getText();
    String autor = autorField.getText();
    String isbn = isbnField.getText();
    String editora = editoraField.getText();
    String dataPublicacao = dataPublicacaoField.getText();
    String descricao = descricaoArea.getText();
    String genero = generoField.getText();

    if (titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty() || editora.isEmpty() || dataPublicacao.isEmpty()
        || descricao.isEmpty() || genero.isEmpty() || caminhoCapa == null) {
      JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
      return;
    }

    Livro livro = new Livro(titulo, autor, isbn, editora, dataPublicacao, descricao, genero, caminhoCapa);
    catalogoUI.adicionarLivroAoCatalogo(livro);
    dispose();
  }
}
