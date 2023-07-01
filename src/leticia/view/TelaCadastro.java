package leticia.view;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import leticia.controladora.Controladora;
import leticia.modelo.Questao;
import leticia.modelo.QuestaoMultiplaEscolha;
import leticia.modelo.QuestaoRespostaUnica;

/**
 * Classe responsável pela tela de cadastro de questões
 * Ele permite que o usuário insira as informações da questão e selecione o tipo de questão e em seguida, realiza o cadastro.
 */
public class TelaCadastro {
    private Controladora controladora;

    /**
     * Construtor da classe TelaCadastro.
     *
     * @param controladora A instância da classe Controladora.
     */
    public TelaCadastro(Controladora controladora) {
        this.controladora = controladora;
    }

    /**
     * Exibe a tela de cadastro de questões e realiza o cadastro com base nas informações fornecidas pelo usuário.
     */
    public void cadastrarQuestao() {
        JTextField idField = new JTextField();
        JTextField materiaField = new JTextField();
        JTextField concursoField = new JTextField();
        JTextField textoQuestaoField = new JTextField();

        /**
         * Exibição da janela de diálogo para cadastro de questão
         */
        Object[] message = { "ID:", idField, "Matéria:", materiaField, "Concurso:", concursoField,
                "Enunciado da Questão:", textoQuestaoField };
        /*
         * Captura das informações da questão
         */
        int option = JOptionPane.showConfirmDialog(null, message, "Cadastrar Questão", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            String materia = materiaField.getText();
            String concurso = concursoField.getText();
            String textoQuestao = textoQuestaoField.getText();
            /*
             * Seleção do tipo de questão
             */
            String[] options = { "Resposta Única", "Resposta Múltipla" };
            int tipoQuestaoOption = JOptionPane.showOptionDialog(null, "Selecione o tipo de questão:",
                    "Tipo de Questão", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                    options[0]);

            /*
             * Cadastro de questão de resposta única
             */
            if (tipoQuestaoOption == 0) {
                JTextField respostaField = new JTextField();
                Object[] respostaUnicaMessage = { "Resposta:", respostaField };

                // Exibe a janela de diálogo para o usuário inserir a resposta da questão de resposta única
                int respostaUnicaOption = JOptionPane.showConfirmDialog(null, respostaUnicaMessage,
                        "Cadastrar Questão - Resposta Única", JOptionPane.OK_CANCEL_OPTION);
                
                if (respostaUnicaOption == JOptionPane.OK_OPTION) {
                    String resposta = respostaField.getText();
                    
                 // Cria uma nova questão de resposta única
                    Questao questao = new QuestaoRespostaUnica(id, materia, concurso, textoQuestao, resposta);
                    controladora.cadastrarQuestao(questao);
                    JOptionPane.showMessageDialog(null, "Questão de Resposta Única cadastrada com sucesso!",
                            "Cadastrar Questão", JOptionPane.INFORMATION_MESSAGE);
                }
                
                /*
                 * Cadastro de questão de resposta única
                 */
            } else if (tipoQuestaoOption == 1) {
                JTextField opcoesRespostaField = new JTextField();
                JTextField respostaCorretaField = new JTextField();

             // Exibe a janela de diálogo para o usuário inserir as respostas da questão
                Object[] respostaMultiplaMessage = { "Possíveis Respostas (separadas por ';'):", opcoesRespostaField,
                        "Resposta Correta:", respostaCorretaField };

                int respostaMultiplaOption = JOptionPane.showConfirmDialog(null, respostaMultiplaMessage,
                        "Cadastrar Questão - Resposta Múltipla", JOptionPane.OK_CANCEL_OPTION);

                // Verificar se a resposta correta está entre as opções
                if (respostaMultiplaOption == JOptionPane.OK_OPTION) {
                    String opcoesResposta = opcoesRespostaField.getText();
                    String respostaCorreta = respostaCorretaField.getText();
                    
                    // Divide a string opcoesResposta em substrings usando o caractere
                    String[] opcoes = opcoesResposta.split(";");
                    List<String> opcoesList = Arrays.asList(opcoes);

                    // Verificar se a resposta correta está entre as opções
                    if (!opcoesList.contains(respostaCorreta)) {
                        JOptionPane.showMessageDialog(null,
                                "Resposta correta inválida! Deve ser uma das opções fornecidas.", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Cria uma nova questão de resposta múltipla
                    Questao questao = new QuestaoMultiplaEscolha(id, materia, concurso, textoQuestao, respostaCorreta,
                            opcoesList);

                    controladora.cadastrarQuestao(questao);
                    JOptionPane.showMessageDialog(null, "Questão de Resposta Múltipla cadastrada com sucesso!",
                            "Cadastrar Questão", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de questão inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
