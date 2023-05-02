package leticia;

import leticia.modelo.Usuario;

import leticia.modelo.UsuarioAdministrador;
import leticia.modelo.QuestaoMultiplaEscolha;
import leticia.modelo.QuestaoRespostaUnica;
import java.util.Arrays;

public class Principal {
	public static void main(String[] args) {
		Usuario usuario = new Usuario(
				1, 
				"Ione Torres", 
				"ione@me.com", 
				"12345678900", 
				"senha123");
		UsuarioAdministrador administrador = 
				new UsuarioAdministrador(
						2, 
						"Leticia Martins", 
						"lele@me.com",
						"23456789000", 
						"senha456", 
						"MC1010");
		QuestaoMultiplaEscolha questaoMultiplaEscolha = 
				new QuestaoMultiplaEscolha(
						1, 
						"Biologia", 
						"ENEM 2020",
						"Organismos unicelulares tem quantas células?", 
						Arrays.asList("A - UMA", "B - DUAS"), "A - UMA");
		QuestaoRespostaUnica questaoRespostaUnica = 
				new QuestaoRespostaUnica(
						2, 
						"Matemática", 
						"ENEM 2022",
						"Quanto é 1 + 1?", 
						"2");
	}
}
