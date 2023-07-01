package leticia.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import leticia.modelo.Questao;
import leticia.modelo.QuestaoMultiplaEscolha;
import leticia.modelo.QuestaoRespostaUnica;

/**
 * Classe responsável pela exibição das questões em uma janela.
 */
public class TelaExibir {
    private JFrame frame;
    private JTextArea questoesTextArea;

    /**
     * Construtor da classe TelaExibir.
     */
    public TelaExibir() {
        frame = new JFrame("Exibir Questões");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

        questoesTextArea = new JTextArea();
        questoesTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(questoesTextArea);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Exibe as questões na janela.
     *
     * @param questoes A lista de questões a serem exibidas.
     */
    public void exibirQuestoes(List<Questao> questoes) {
        StringBuilder questoesStr = new StringBuilder();
        boolean primeiraQuestaoMultiplaEscolha = true;

        for (Questao questao : questoes) {
            if (questao instanceof QuestaoMultiplaEscolha) {
                if (!primeiraQuestaoMultiplaEscolha) {
                    questoesStr.append("\n");
                }
                questoesStr.append("Questões de Múltipla Escolha:\n");
                questoesStr.append(obterInformacoesQuestaoMultiplaEscolha((QuestaoMultiplaEscolha) questao));
                primeiraQuestaoMultiplaEscolha = false;
            } else if (questao instanceof QuestaoRespostaUnica) {
                questoesStr.append("\n");
                questoesStr.append("Questões de Resposta Única:\n");
                questoesStr.append(obterInformacoesQuestaoRespostaUnica((QuestaoRespostaUnica) questao));
            }
        }

        questoesTextArea.setText(questoesStr.toString());
        frame.setVisible(true);
    }

    /**
     * Obtém as informações de uma questão de resposta única formatadas como uma string.
     *
     * @param questao A questão de resposta única.
     * @return As informações da questão formatadas como string.
     */
    private String obterInformacoesQuestaoRespostaUnica(QuestaoRespostaUnica questao) {
        StringBuilder str = new StringBuilder();
        str.append("ID: ").append(questao.getId()).append("\n");
        str.append("Matéria: ").append(questao.getMateria()).append("\n");
        str.append("Concurso: ").append(questao.getConcurso()).append("\n");
        str.append("Enunciado: ").append(questao.getTextoQuestao()).append("\n");
        str.append("Resposta: ").append(questao.getResposta()).append("\n");
        str.append("\n"); // Espaçamento entre questões
        return str.toString();
    }

    /**
     * Obtém as informações de uma questão de múltipla escolha formatadas como uma string.
     *
     * @param questao A questão de múltipla escolha.
     * @return As informações da questão formatadas como string.
     */
    private String obterInformacoesQuestaoMultiplaEscolha(QuestaoMultiplaEscolha questao) {
        StringBuilder str = new StringBuilder();
        str.append("ID: ").append(questao.getId()).append("\n");
        str.append("Matéria: ").append(questao.getMateria()).append("\n");
        str.append("Concurso: ").append(questao.getConcurso()).append("\n");
        str.append("Enunciado: ").append(questao.getTextoQuestao()).append("\n");
        str.append("Opções: ").append(String.join(", ", questao.getAlternativas())).append("\n");
        str.append("Resposta: ").append(questao.getAlternativaCorreta()).append("\n");
        str.append("\n"); // Espaçamento entre questões
        return str.toString();
    }
}
