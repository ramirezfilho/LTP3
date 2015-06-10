package controle_de_pagamento;

import dados.Horista;
import dados.Mensalista;
import utilitarios.Console;
import cadastro.*;

class Interface {

	public static void main(String[] args) {
	
	
	
	}

	
	
	private static void IncluirHorista() {
		String nome = Console.readLine("Digite o nome: ");
		String cpf = Console.readLine("Digite o cpf: ");
		double valorHora = Console.readDouble("Digite o valor recebido por hora: ");
		
		 Horista func = new Horista(nome, cpf, valorHora);
		 Cadastro.CadastroHorista(func);
	}
	
	private static void IncluirMensalista() {
		String nome = Console.readLine("Digite o nome: ");
		String cpf = Console.readLine("Digite o cpf: ");
		double valorSalario = Console.readDouble("Digite o valor do salario: ");
		
		 Mensalista func = new Mensalista(nome, cpf, valorSalario);
		 Cadastro.CadastroMensalista(func);
	}
}



