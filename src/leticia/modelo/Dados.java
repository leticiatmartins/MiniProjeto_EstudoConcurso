package leticia.modelo;

import java.util.List;

public class Dados {
	private List<Questao> questoes;
	private List<Usuario> usuarios;

	public Dados() {
	}

	public Dados(List<Questao> questoes, List<Usuario> usuarios) {
		this.questoes = questoes;
		this.usuarios = usuarios;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
