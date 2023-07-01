package leticia.view;

import java.util.List;

import javax.swing.JOptionPane;

import leticia.controladora.Controladora;
import leticia.modelo.Questao;

/**
 * Classe responsável por exibir a tela de pesquisa de questões.
 */
public class TelaPesquisar {
    private Controladora controladora;

    /**
     * Construtor da classe TelaPesquisar.
     *
     * @param controladora a instância da controladora responsável pela lógica do sistema.
     */
    public TelaPesquisar(Controladora controladora) {
        this.controladora = controladora;
    }

    /**
     * Método para pesquisar questões por matéria.
     * Solicita ao usuário a entrada da matéria e exibe as questões encontradas.
     */
    public void pesquisarQuestoesPorMateria() {
        // Solicita ao usuário a entrada da matéria a ser pesquisada
        String materia = JOptionPane.showInputDialog("Digite a matéria para pesquisar as questões:");

        // Verifica se a matéria não é nula e não está vazia
        if (materia != null && !materia.isEmpty()) {
            // Chama o método da controladora para buscar questões por matéria
            List<Questao> questoesEncontradas = controladora.buscarQuestoesPorMateria(materia);

            // Verifica se foram encontradas questões para a matéria pesquisada
            if (!questoesEncontradas.isEmpty()) {
                // Cria um StringBuilder para construir a mensagem de resultado da pesquisa
                StringBuilder resultado = new StringBuilder();
                resultado.append("Questões encontradas para a matéria ").append(materia).append(":\n");

                for (Questao questao : questoesEncontradas) {
                    resultado.append("ID: ").append(questao.getId()).append(" - ").append(questao.getTextoQuestao()).append("\n");
                }

                JOptionPane.showMessageDialog(null, resultado.toString(), "Resultado da Pesquisa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Exibe uma mensagem informando que não foram encontradas questões para a matéria pesquisada
                JOptionPane.showMessageDialog(null, "Nenhuma questão encontrada para a matéria informada.", "Resultado da Pesquisa", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Exibe uma mensagem informando que a matéria é inválida (nula ou vazia)
            JOptionPane.showMessageDialog(null, "Matéria inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
