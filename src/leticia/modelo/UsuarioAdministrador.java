package leticia.modelo;

public class UsuarioAdministrador extends Usuario {
	private String matriculaFuncionario;

	public UsuarioAdministrador(int id, String nome, String email, String cpf, String senha, String matriculaFuncionario) {
		super(id, nome, email, cpf, senha);
		this.matriculaFuncionario = matriculaFuncionario;
	}

	public String getMatriculaFuncionario() {
		return matriculaFuncionario;
	}

	public void setMatriculaFuncionario(String matriculaFuncionario) {
		this.matriculaFuncionario = matriculaFuncionario;
	}
}
