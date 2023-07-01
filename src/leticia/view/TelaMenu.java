package leticia.view;

import leticia.controladora.Controladora;
import leticia.modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Essa classe representa a tela do menu principal do sistema.
 * Permite cadastrar, exibir, editar e deletar questões.
 */

public class TelaMenu {
    private TelaExibir telaExibir;
    private TelaCadastro telaCadastro;
    private TelaEditar telaEditar;
    private TelaDeletar telaDeletar;
    private TelaPesquisar telaPesquisar;
   
    /**
     * Construtor da classe TelaMenu.
     * @param controladora A controladora do sistema.
     */
    public TelaMenu(Controladora controladora) {
        this.telaExibir = new TelaExibir();
        this.telaCadastro = new TelaCadastro(controladora);
        this.telaEditar = new TelaEditar(controladora);
        this.telaDeletar = new TelaDeletar(controladora);
        this.telaPesquisar = new TelaPesquisar(controladora);
        
    }

    /**
     * Exibe a tela do menu principal.
     */
    public void exibir(Controladora controladora) {
        // Configuração da janela
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());



        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Botão para cadastrar questão
        JButton cadastrarButton = new JButton("Cadastrar Questão");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastro.cadastrarQuestao();
            }
        });
        buttonPanel.add(cadastrarButton);

        // Botão para exibir questões
        JButton exibirButton = new JButton("Exibir Questões");
        exibirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Questao> questoes = controladora.listarQuestoes();
                telaExibir.exibirQuestoes(questoes);
            }
        });
        buttonPanel.add(exibirButton);

        // Botão para editar questões
        JButton editarButton = new JButton("Editar Questões");
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaEditar.editarQuestoes();
            }
        });
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(editarButton);
       
        // Botão para Deletar questões
        JButton deletarButton = new JButton("Deletar Questão");
        deletarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                telaDeletar.deletarQuestoes();
            }
        });
        buttonPanel.add(deletarButton);

        
        // Botão para Pesquisar questões
        JButton pesquisarButton = new JButton("Pesquisar Questão");
        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPesquisar.pesquisarQuestoesPorMateria();
            }
        });
        buttonPanel.add(pesquisarButton);
        
        // Mostra a janela
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
