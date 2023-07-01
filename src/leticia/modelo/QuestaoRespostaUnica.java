package leticia.modelo;

public class QuestaoRespostaUnica extends Questao {
	private String resposta;

    public QuestaoRespostaUnica(int id, String materia, String concurso ,String textoQuestao, String resposta) {
        super(id, materia, concurso, textoQuestao, resposta);
        this.resposta = resposta;
    }

	public String getRespostaCorreta() {
        return resposta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.resposta = respostaCorreta;
    }
}