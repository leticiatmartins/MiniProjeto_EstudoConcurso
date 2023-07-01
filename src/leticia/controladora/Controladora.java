package leticia.controladora;

import leticia.modelo.Questao;
import leticia.modelo.QuestaoMultiplaEscolha;
import leticia.modelo.QuestaoRespostaUnica;

import java.util.ArrayList;
import java.util.List;

/**
 * Controladora responsável pela gestão das questões.
 */

public class Controladora {
    private static List<Questao> listarquestoes;
  
    /**
     * Construtor da Controladora.
     */
    public Controladora() {
        listarquestoes = new ArrayList<>();
    }

    /**
     * Cadastra uma nova questão.
     *
     * @param questao A questão a ser cadastrada.
     */
    public void cadastrarQuestao(Questao questao) {
        listarquestoes.add(questao);
    }

    /**
     * Retorna a lista de questões cadastradas.
     *
     * @return A lista de questões cadastradas.
     */
    public List<Questao> getQuestoes() {
        return listarquestoes;
    }

    /**
     * Busca uma questão pelo ID.
     *
     * @param id O ID da questão a ser buscada.
     * @return A questão encontrada ou null se não for encontrada.
     */
    public Questao buscarQuestaoPorId(int id) {
        for (Questao questao : listarquestoes) {
            if (questao.getId() == id) {
                return questao;
            }
        }
        return null;
    }

    /**
     * Edita a resposta de uma questão de resposta única.
     *
     * @param id           O ID da questão a ser editada.
     * @param novaResposta A nova resposta da questão.
     */
    public void editarQuestaoRespostaUnica(int id, String novaResposta) {
        for (Questao questao : listarquestoes) {
            if (questao instanceof QuestaoRespostaUnica && questao.getId() == id) {
                QuestaoRespostaUnica questaoRespostaUnica = (QuestaoRespostaUnica) questao;
                questaoRespostaUnica.setResposta(novaResposta);
                break;
            }
        }
    }

    /**
     * Edita uma questão de múltipla escolha.
     *
     * @param id                  O ID da questão a ser editada.
     * @param alternativas        As alternativas da questão.
     * @param alternativaCorreta  A alternativa correta da questão.
     */
    public void editarQuestaoMultiplaEscolha(int id, List<String> alternativas, String alternativaCorreta) {
        for (Questao questao : listarquestoes) {
            if (questao instanceof QuestaoMultiplaEscolha && questao.getId() == id) {
                QuestaoMultiplaEscolha questaoMultiplaEscolha = (QuestaoMultiplaEscolha) questao;
                questaoMultiplaEscolha.setAlternativas(alternativas);
                questaoMultiplaEscolha.setAlternativaCorreta(alternativaCorreta);
                break;
            }
        }
    }

    /**
     * Exibe as questões cadastradas.
     */
    public void exibirQuestoesCadastradas() {
        for (Questao questao : listarquestoes) {
            System.out.println(questao);
        }
    }

    /**
     * Retorna a lista de todas as questões cadastradas.
     *
     * @return A lista de todas as questões cadastradas.
     */

    public List<Questao> listarQuestoes() {
        return listarquestoes;
    }

    /**
     * Exclui uma questão pelo ID.
     *
     * @param idRecebido O ID da questão a ser excluída.
     */
	public void excluirQuestao(int idRecebido) {
		// Encontre a questão pelo ID na lista de questões
	    Questao questao = null;
	    for (Questao q : listarquestoes) {
	        if (q.getId() == idRecebido) {
	            questao = q;
	            break;
	        }
	    }
	    
	    if (questao != null) {
	        // Remova a questão da lista de questões
	        listarquestoes.remove(questao);
	    } else {
	        System.out.println("Questão não encontrada.");
	    }
		
	}
	
	/**
	 * Busca e retorna uma lista de questões com base na matéria especificada.
	 *
	 * @param materia a matéria das questões a serem buscadas
	 * @return uma lista de questões encontradas com a matéria especificada
	 */
	public List<Questao> buscarQuestoesPorMateria(String materia) {
        List<Questao> questoesEncontradas = new ArrayList<>();

        for (Questao questao : listarquestoes) {
            if (questao.getMateria().equalsIgnoreCase(materia)) {
                questoesEncontradas.add(questao);
            }
        }

        return questoesEncontradas;
    }
}
