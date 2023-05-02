package leticia.modelo;

public class QuestaoRespostaUnica extends Questao {
	private String respostaCorreta;

	public QuestaoRespostaUnica(int id, String materia, String concurso, String textoQuestao, String respostaCorreta) {
		super(id, materia, concurso, textoQuestao);
		this.respostaCorreta = respostaCorreta;
	}

	public String getRespostaCorreta() {
		return respostaCorreta;
	}

	public void setRespostaCorreta(String respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}
}
