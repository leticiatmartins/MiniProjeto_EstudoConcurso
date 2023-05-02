package leticia.modelo;

import java.util.List;

public class QuestaoMultiplaEscolha extends Questao {
	private List<String> alternativas;
	private String alternativaCorreta;

	public QuestaoMultiplaEscolha(int id, String materia, String concurso, String textoQuestao,
			List<String> alternativas, String alternativaCorreta) {
		super(id, materia, concurso, textoQuestao);
		this.alternativas = alternativas;
		this.alternativaCorreta = alternativaCorreta;
	}

	public List<String> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<String> alternativas) {
		this.alternativas = alternativas;
	}

	public String getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(String alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}
}
