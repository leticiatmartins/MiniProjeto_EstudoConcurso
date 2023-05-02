package leticia.modelo;

public abstract class Questao {
	private int id;
	private String materia;
	private String concurso;
	private String textoQuestao;

	public Questao(int id, String materia, String concurso, String textoQuestao) {
		this.id = id;
		this.materia = materia;
		this.concurso = concurso;
		this.textoQuestao = textoQuestao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}

	public String getTextoQuestao() {
		return textoQuestao;
	}

	public void setTextoQuestao(String textoQuestao) {
		this.textoQuestao = textoQuestao;
	}
}
