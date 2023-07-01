package leticia.view;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import leticia.controladora.Controladora;
import leticia.modelo.Questao;
import leticia.modelo.QuestaoMultiplaEscolha;
import leticia.modelo.QuestaoRespostaUnica;

/**
 * A classe TelaEditar é responsável por exibir a tela de edição de questões e
 * permitir ao usuário editar as questões cadastradas.
 */
public class TelaEditar {
	private Controladora controladora;

	/**
	 * Construtor da classe TelaEditar.
	 *
	 * @param controladora a instância da classe Controladora.
	 */
	public TelaEditar(Controladora controladora) {
		this.controladora = controladora;
		
		// Cadastrar uma questão previamente salva no banco de dados
        Questao questaoSalva = new QuestaoRespostaUnica(1, "Matemática", "ENEM 2022", "Quanto é 2 + 2?", "4");
        controladora.cadastrarQuestao(questaoSalva);
	}

	/**
	 * Exibe a tela de edição de questões e permite ao usuário editar as questões
	 * cadastradas.
	 */
	public void editarQuestoes() {
		List<Questao> questoesCadastradas = controladora.getQuestoes();
		if (questoesCadastradas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhuma questão cadastrada.", "Editar Questões",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			String[] questoesArray = new String[questoesCadastradas.size()];
			for (int i = 0; i < questoesCadastradas.size(); i++) {
				Questao questao = questoesCadastradas.get(i);
				questoesArray[i] = "ID: " + questao.getId() + " - " + questao.getTextoQuestao();
			}

			String selectedQuestao = (String) JOptionPane.showInputDialog(null, "Selecione a questão a ser editada:",
					"Editar Questões", JOptionPane.QUESTION_MESSAGE, null, questoesArray, questoesArray[0]);

			if (selectedQuestao != null) {
				/*
				 * Conversão do ID da questão: Ele extrai a parte do ID da string, converte para
				 * um valor inteiro e procura pela questão correspondente na lista de questões
				 * cadastradas.
				 */
				String idStr = selectedQuestao.split(" - ")[0].substring(4);
				try {
					int id = Integer.parseInt(idStr);
					Questao questaoSelecionada = null;
					for (Questao questao : questoesCadastradas) {
						if (questao.getId() == id) {
							questaoSelecionada = questao;
							break;
						}
					}
					if (questaoSelecionada != null) {
						if (questaoSelecionada instanceof QuestaoRespostaUnica) {
							editarQuestaoRespostaUnica(controladora, (QuestaoRespostaUnica) questaoSelecionada);
						} else if (questaoSelecionada instanceof QuestaoMultiplaEscolha) {
							editarQuestaoMultiplaEscolha((QuestaoMultiplaEscolha) questaoSelecionada);
						}
					}
					/*
					 * Se ocorrer um erro na procura do ID, exibe uma mensagem de erro.*/
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * Exibe a tela de edição de uma questão de resposta única e permite ao usuário
	 * editar a questão.
	 *
	 * @param controladora a instância da classe Controladora.
	 * @param questao      a questão de resposta única a ser editada.
	 */
	public static void editarQuestaoRespostaUnica(Controladora controladora, QuestaoRespostaUnica questao) {
		JTextField idField = new JTextField(String.valueOf(questao.getId()));
		JTextField materiaField = new JTextField(questao.getMateria());
		JTextField concursoField = new JTextField(questao.getConcurso());
		JTextField textoQuestaoField = new JTextField(questao.getTextoQuestao());
		JTextField respostaCorretaField = new JTextField(questao.getResposta());
		
		/*
		 * cria um array de objetos message contendo os rótulos e campos de texto a serem exibidos no diálogo de edição.
		 */
		Object[] message = { "ID:", idField, "Matéria:", materiaField, "Concurso:", concursoField,
				"Enunciado da Questão:", textoQuestaoField, "Resposta Correta:", respostaCorretaField };

		int option = JOptionPane.showConfirmDialog(null, message, "Editar Questão - Resposta Única",
				JOptionPane.OK_CANCEL_OPTION);
		/*
		 * Atualiza a questão.
		 */
		if (option == JOptionPane.OK_OPTION) {
			int id = Integer.parseInt(idField.getText());
			String materia = materiaField.getText();
			String concurso = concursoField.getText();
			String textoQuestao = textoQuestaoField.getText();
			String respostaCorreta = respostaCorretaField.getText();

			questao.setId(id);
			questao.setMateria(materia);
			questao.setConcurso(concurso);
			questao.setTextoQuestao(textoQuestao);
			questao.setResposta(respostaCorreta);

			JOptionPane.showMessageDialog(null, "Questão de Resposta Única editada com sucesso!", "Editar Questão",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Exibe a tela de edição de uma questão de resposta múltipla e permite ao
	 * usuário editar a questão.
	 *
	 * @param questao a questão de resposta múltipla a ser editada.
	 */
	public static void editarQuestaoMultiplaEscolha(QuestaoMultiplaEscolha questao) {
		JTextField idField = new JTextField(String.valueOf(questao.getId()));
		JTextField materiaField = new JTextField(questao.getMateria());
		JTextField concursoField = new JTextField(questao.getConcurso());
		JTextField textoQuestaoField = new JTextField(questao.getTextoQuestao());
		JTextField opcoesRespostaField = new JTextField(String.join(";", questao.getAlternativas()));
		JTextField respostaCorretaField = new JTextField(questao.getAlternativaCorreta());

		/*
		 * cria um array de objetos message contendo os rótulos e campos de texto a serem exibidos no diálogo de edição.
		 */
		Object[] message = { "ID:", idField, "Matéria:", materiaField, "Concurso:", concursoField,
				"Enunciado da Questão:", textoQuestaoField, "Possíveis Respostas (separadas por ';'):",
				opcoesRespostaField, "Resposta Correta:", respostaCorretaField };

		int option = JOptionPane.showConfirmDialog(null, message, "Editar Questão - Resposta Múltipla",
				JOptionPane.OK_CANCEL_OPTION);

		/*
		 * Recebe as alterações que o usuario faz.
		 */
		if (option == JOptionPane.OK_OPTION) {
			int id = Integer.parseInt(idField.getText());
			String materia = materiaField.getText();
			String concurso = concursoField.getText();
			String textoQuestao = textoQuestaoField.getText();
			String opcoesResposta = opcoesRespostaField.getText();
			String respostaCorreta = respostaCorretaField.getText();
			
			/*
			 * Conversão do ID da questão: Ele extrai a parte do ID da string, converte para
			 * um valor inteiro e procura pela questão correspondente na lista de questões
			 * cadastradas.
			 */
			String[] opcoes = opcoesResposta.split(";");
			List<String> opcoesList = Arrays.asList(opcoes);

			// Verificar se a resposta correta está entre as opções
			if (!opcoesList.contains(respostaCorreta)) {
				JOptionPane.showMessageDialog(null, "Resposta correta inválida! Deve ser uma das opções fornecidas.",
						"Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			/*
			 * atualizar os valores dos atributos da questão com os novos valores inseridos pelo usuário durante a edição.
			 **/
			questao.setId(id);
			questao.setMateria(materia);
			questao.setConcurso(concurso);
			questao.setTextoQuestao(textoQuestao);
			questao.setAlternativas(opcoesList);
			questao.setAlternativaCorreta(respostaCorreta);

			JOptionPane.showMessageDialog(null, "Questão de Resposta Múltipla editada com sucesso!", "Editar Questão",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
