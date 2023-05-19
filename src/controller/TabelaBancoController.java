package controller;

import javax.swing.JOptionPane;

import matheus.ListaObject.ListaObject;
import model.Cliente;

public class TabelaBancoController 
{
	ListaObject[] tabelaBanco;
	
	public TabelaBancoController()
	{
		tabelaBanco = new ListaObject[10];
		iniciaTabela();
	}

	private void iniciaTabela() 
	{
		int tam = tabelaBanco.length;
		for (int i = 0; i < tam; i++)
		{
			tabelaBanco[i] = new ListaObject();
		}
	}
	
	public void addCliente(Cliente fulano) throws Exception
	{
		int posit = fulano.hashCode();
		
		if (tabelaBanco[posit].isEmpty())
		{
			tabelaBanco[posit].addFirst(fulano);
		}
		else
		{
			tabelaBanco[posit].addLast(fulano);
		}
	}
	
	public Cliente consultCliente(Cliente fulano) throws Exception
	{
		int tam = tabelaBanco.length;
		
		for (int i = 0; i < tam; i++)
		{
			int tamDep = tabelaBanco[i].size();
			for (int j = 0; j < tamDep; j++)
			{				
				Cliente consultFulano = (Cliente) tabelaBanco[i].get(j);
				if (consultFulano.getNomeCliente().equals(fulano.getNomeCliente()))
				{
					JOptionPane.showMessageDialog(null, consultFulano.toString());
					return fulano;
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "Nome do cliente especifico nao encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
		return fulano;
	}
	
	public Cliente removerCliente(Cliente fulano) throws Exception
	{
		int tam = tabelaBanco.length;
		
		for (int i = 0; i < tam; i++)
		{
			int tamBanco = tabelaBanco[i].size();
			for (int j = 0; j < tamBanco; j++)
			{				
				Cliente removeClient = (Cliente) tabelaBanco[i].get(j);
				if (removeClient.getNomeCliente().equals(fulano.getNomeCliente()))
				{
					tabelaBanco[i].remove(j);
					return fulano;
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "Nome do cliente especifico nao encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
		return fulano;
	}
	
}
