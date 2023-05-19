package view;

import javax.swing.JOptionPane;

import controller.TabelaBancoController;
import model.Cliente;

public class Main {

	public static void main(String[] args) 
	{
		int op = -1;
		TabelaBancoController controllBanco = new TabelaBancoController();	
		
		while(op != 9)
		{
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite as opcoes desejadas: \n"
															+ "1 - Adicionar Novo Cliente.\n"
															+ "2 - Consultar Cliente.\n"
															+ "3 - Excluir Cliente.\n"
															+ "9 - Sair do sistema."));
			try {
				switch(op)
				{
				case 1:
					
					int numConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta(0 a 9999): "));
					
					if (numConta < 0 || numConta > 9999)
					{
						JOptionPane.showMessageDialog(null, "Numero invalido, apenas 4 digitos e positivo!\nDigite a opcao novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
						break;
					}
					
					
					Cliente novoCliente = new Cliente(numConta, 
													  JOptionPane.showInputDialog("Digite o nome do Cliente:"), 
													  Float.parseFloat(JOptionPane.showInputDialog("Digite o saldo do cliente:")));
					System.out.println(novoCliente.hashCode());
					controllBanco.addCliente(novoCliente);
					break;
				case 2:
					Cliente consultCliente = new Cliente(0, JOptionPane.showInputDialog("Digite o nome do Cliente:"), 0);
					controllBanco.consultCliente(consultCliente);
					break;
				case 3:
					Cliente excluiCliente = new Cliente(0, JOptionPane.showInputDialog("Digite o nome do Cliente:"), 0);
					controllBanco.removerCliente(excluiCliente);
					break;
				case 9:
					JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso Sistema!");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcao invalida!\nDigite novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

}
