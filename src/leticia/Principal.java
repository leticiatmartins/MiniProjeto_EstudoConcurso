/* 
* @author Leticia Torres Soares Masrtins
 * @version 1.0
 * Matrícula: 202016702
 * Tema: Estudo para Concurso
 * Turma: T03 (2023.1 - 24M12)
 * Matéria: Orientação a Objetos
 * Professora: FABIANA FREITAS MENDES
 * Suas funcionalidades são:
 * 1 - CRUD de questão de concurso.
 * 2 - Listagem de todas as questões cadastradas.
 * 3 - Busca por questões de uma determinada matéria. 
 */

package leticia;

import leticia.controladora.Controladora;
import leticia.view.TelaLogin;
import leticia.view.TelaMenu;

/*
 * Classe principal responsável por iniciar o aplicativo e exibir a tela de login.
 */
public class Principal {
    public static void main(String[] args) {
        Controladora controladora = new Controladora();
        TelaMenu telaMenu = new TelaMenu(controladora);
        TelaLogin telaLogin = new TelaLogin(controladora, telaMenu);
        telaLogin.exibir();
    }
}
