package usuario;

import java.util.ArrayList;
import java.util.GregorianCalendar;


import dados.CadClientes;
import dados.Celular;
import dados.ClienteCelular;
import erros.CelularException;
import utilitarios.Console;

public class Interface {

	public static void main(String[] args) {
		
		do{
		int recebe = Console.readInt("Menu de op��es: " +
		"1 - Incluir Cliente" + 
		"2 - Excluir Cliente" +
		"3 - Pesquisar Cliente Por CPF" +
		"4 - Pesquisa Cliente Nome" + 
		"5 - Incluir Celular "
		+ "6 - Excluir Celular "
		+ "7 - Buscar Celular por N�mero ");
	
		switch (recebe) {
		case 1 : incluirCliente(); break;
		case 2 : pesquisaClienteCpf(); break;
		case 3 : excluirCliente(); break;
		case 4 : System.out.println(CadClientes.listaClientes); break;
		case 5 : pesquisaPorNome();
		}
		
		} while (true);
		
	}

	private static void pesquisaPorNome() {
		String nome =  Console.readLine("NOME: ");
		
		try {
			System.out.println(CadClientes.pesquisaClientesNome(nome));
		} catch (CelularException e) {
			System.out.println("N�o existe!");
		}
		
		
	}

	private static void incluirCliente() {
		String nome;
		String cpf;
		String numero;
		Celular celular = null;
		ClienteCelular incluiCLiente;
				
		nome = Console.readLine("NOME: ");
		cpf = Console.readLine("CPF: ");
		
		System.out.println("Cadastro celular");
		numero = Console.readLine("NUMERO: ");
		
		ClienteCelular.incluirCelular(new Celular(numero));		
		CadClientes.incluirCliente(incluiCLiente = new ClienteCelular(cpf, nome.toUpperCase(), ClienteCelular.listaCelular));
		}
	
	private static void pesquisaClienteCpf() {
		String cpf = Console.readLine("CPF: ");
		
		try{
		System.out.println(CadClientes.pesquisaClienteCpf(cpf));
		} catch (CelularException e) {
			System.out.println("CU");
		}	
	}
		
	
	private static void excluirCliente () {
		String cpf = Console.readLine("CPF: ");
		
		if(CadClientes.listaClientes.containsKey(cpf)){
			CadClientes.listaClientes.remove(cpf);
		} else{
			System.out.println("N�o existe o caboclo");
		}
	}
	
	
	
	
	}
