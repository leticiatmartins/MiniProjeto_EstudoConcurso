package leticia.modelo;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String cpf;
	private String senha;

	public Usuario(int id, String nome, String email, String cpf, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean realizarLogin(String email, String senha) {
	    String lowercaseEmail = email.toLowerCase();
	    String lowercaseSenha = senha.toLowerCase();
	    return this.email.equalsIgnoreCase(lowercaseEmail) && this.senha.equals(lowercaseSenha);
	}

}
