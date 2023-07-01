package leticia.modelo;

import java.util.List;

import leticia.controladora.Controladora;

	/**
	A classe Dados representa um objeto que contém listas de questões e usuários.
	Essas listas são utilizadas para armazenar os dados do sistema.
	A classe também possui métodos para acessar e modificar essas listas.
	*/
public class Dados {
	private List<Questao> questoes;
	private List<Usuario> usuarios;
	private static String emailArmazenado = "email@exemplo.com";
	private static String senhaArmazenada = "senha123";


	/**
	Construtor da classe Dados.
	@param questoes A lista de questões a serem armazenadas nos dados.
	@param usuarios A lista de usuários a serem armazenados nos dados.
	@param controladora A instância da controladora que manipula os dados.
	*/
	public Dados(List<Questao> questoes, List<Usuario> usuarios, Controladora controladora) {
		this.questoes = questoes;
		this.usuarios = usuarios;
	}
	
	/**
	Define a lista de questões armazenadas nos dados.
	@param questoes A lista de questões a ser definida.
	*/
	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	/**
	Obtém a lista de questões armazenadas nos dados.
	@return A lista de questões.
	*/
	public List<Questao> getQuestoes() {
		return questoes;
	}

	/**
	Obtém a lista de usuários armazenados nos dados.
	@return A lista de usuários.
	*/
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	Define a lista de usuários armazenados nos dados.
	@param usuarios A lista de usuários a ser definida.
	*/
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	/**
	 * Verifica se o email e a senha fornecidos correspondem aos dados armazenados.
	 *
	 * @param email o email a ser verificado
	 * @param senha a senha a ser verificada
	 * @return true se o email e a senha correspondem aos dados armazenados, false caso contrário
	 */
	public static boolean verificarLogin(String email, String senha) {
	    return emailArmazenado.equals(email) && senhaArmazenada.equals(senha);
	}
}
