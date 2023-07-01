package leticia.view;

import leticia.controladora.Controladora;
import leticia.modelo.Dados;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Esta classe representa a tela de login da aplicação.
 * Permite que o usuário insira seu email e senha para realizar o login.
 * Verifica as informações de login utilizando a classe Dados.
 * Apresenta mensagens de sucesso ou falha de login.
 */
@SuppressWarnings("serial")
public class TelaLogin extends JFrame implements ActionListener {
	private JTextField usernameField;
    private JPasswordField passwordField;
    private TelaMenu telaMenu;
    private Controladora controladora;
   
    /**
     * Cria uma nova instância da TelaLogin.
     * @param controladora A instância da Controladora.
     * @param telaMenu A instância da TelaMenu.
     */
    public TelaLogin(Controladora controladora, TelaMenu telaMenu) {
        this.controladora = controladora;
        this.telaMenu = telaMenu;
        
        setTitle("Estudo para Concurso");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
     

        JLabel usernameLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Senha:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(this);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel());
        add(loginButton);

        setVisible(true);
    }
    
    /**
     * Método chamado quando o botão de login é clicado.
     * Obtém o email e senha inseridos pelo usuário.
     * Verifica as informações de login utilizando a classe Dados.
     * Exibe uma mensagem de sucesso ou falha de login.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String email = usernameField.getText();
        String senha = new String(passwordField.getPassword());

        if (Dados.verificarLogin(email, senha)) {
            JOptionPane.showMessageDialog(this, "Login successful!");

            telaMenu.exibir(controladora); // Não é necessário passar a instância da Controladora novamente
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid email or password.");
        }
    }
    
    /**
     * Exibe a tela de login.
     */
    public void exibir() {
        setVisible(true);
    }
}
