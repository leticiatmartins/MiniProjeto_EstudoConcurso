package leticia.view;

import java.util.List;

import javax.swing.JOptionPane;

import leticia.controladora.*;
import leticia.modelo.Questao;

/**
 * A classe TelaDeletar representa a interface de usuário para a funcionalidade de exclusão de questões.
 * Permite ao usuário selecionar e deletar uma questão do sistema.
 */
public class TelaDeletar {
	private Controladora controladora;
	
	 /**
     * Construtor da classe TelaDeletar.
     * 
     * @param controladora A instância da controladora que manipula os dados.
     */
	public TelaDeletar(Controladora controladora) {
        this.controladora = controladora;
    }
	
	/**
     * Exibe a tela de deleção de questões.
     * Permite ao usuário selecionar e deletar uma questão do sistema.
     */
	public void deletarQuestoes() {
		List<Questao> questoesCadastradas = controladora.getQuestoes(); //Verificar listar questões cadastradas
		if (questoesCadastradas.isEmpty()) {  //Se não tiver questões parecer "Nenhuma questão cadastrada"
			JOptionPane.showMessageDialog(null, "Nenhuma questão cadastrada.", "Deletar Questões",
					JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			String[] questoesArray = new String[questoesCadastradas.size()]; //Mostrar questões selecionadas para deletar
			for (int i = 0; i < questoesCadastradas.size(); i++) { 
				Questao questao = questoesCadastradas.get(i);
				questoesArray[i] = "ID: " + questao.getId() + " - " + questao.getTextoQuestao();
			}
			
			//Mostra painel de deletar
			String selectedQuestao = (String) JOptionPane.showInputDialog(null, "Selecione a questão a ser deletada:",
					"Deletar Questões", JOptionPane.QUESTION_MESSAGE, null, questoesArray, questoesArray[0]);
			
			//Pegar o ID da Questão selecionada
			if (selectedQuestao != null) {
				String idStr = selectedQuestao.split(" - ")[0].substring(4);
				
				//Procurar questão que possui o ID selecionado pelo Usuario
				try {
					int id;
					
					id = Integer.parseInt(idStr);
					Questao questaoSelecionada = null;
					for (Questao questao : questoesCadastradas) {
						if (questao.getId() == id) {
							questaoSelecionada = questao;
							break;
						}
					}
					
					//Deletar Questão
					if (questaoSelecionada != null) {
						
						controladora.excluirQuestao(questaoSelecionada.getId());
						JOptionPane.showMessageDialog(null, "Questão excluída com sucesso!", "Excluir Questão",
				                JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	

}
