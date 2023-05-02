package leticia.controle;

import leticia.modelo.Dados;
import leticia.modelo.Questao;
import leticia.modelo.Usuario;

import java.util.List;

public class Controlador {

	public void adicionarQuestao(Questao questao) {
		System.out.println("Adicionar questao");
	}

	public void atualizarQuestaoPorId(int id, Questao questao) {
		System.out.println("Atualizar questao");
	}

	public void removerQuestaoPorId(int id) {
		System.out.println("Remover questao");
	}

	public List<Questao> listarQuestoes() {
		System.out.println("Listar questoes");
		return null;
	}

	public List<Questao> procurarQuestoesPorMateria(String materia) {
		System.out.println("Listar questoes por materia");
		// Implementar filtro por materia
		return null;
	}

	public void adicionarUsuario(Usuario usuario) {
		System.out.println("Adicionar Usuario");
	}

	public void removerUsuario(int id) {
		System.out.println("Remover Usuario");
	}

	public void atualizarUsuario(int id, Usuario usuario) {
		System.out.println("Atualizar Usuario");
	}

	public List<Usuario> listarUsuarios() {
		System.out.println("Listar Usuarios");
		return null;
	}
}
