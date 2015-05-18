package Usuario;

import java.util.Calendar;
import java.util.GregorianCalendar;

import utilitarios.Console;
import utilitarios.LtpUtil;
import cadastro.Cadastro;
import dados.Cliente;
import erros.SisVendasException;

public class Usuario {	
		
	public static void main(String[] args) throws SisVendasException {

		//MENU DOS INFERNO!! 
		int option;
			
		do{
			option = Console.readInt(" ----- MENU DE OPÇÕES ----- \n" 
					+ " 1 - Incluir "
					+ "\n 2 - Alterar "
					+ "\n 3 - Excluir "
					+ "\n 4 - Buscar pelo CPF "
					+ "\n 5 - Exibir todos os clientes "
					+ "\n 6 - Sair "
					+ "\n\n -> Qual opção deseja?");
			
			switch(option){
				case 1 : incluirCliente(); break;
				case 2 : alterarCliente(); break;
				case 3 : excluirCliente(); break;
				case 4 : buscarClienteCPF(); break;
				case 5 : System.out.println(Cadastro.clientes); break;
				case 6 : System.out.println("Fim do programa, obrigado por usar!");break;
			}
			
			for(int i = 0; i<5; i++) System.out.println("");
			
		}while(option != 6);
	}

	
	/**
	 * Método responsável pelo cadastro de clientes.
	 */
	private static void incluirCliente (){
		String cpf;
		String nome;
		String telefone;
		String email;
		
		Cliente inclusaoCliente;
		
		System.out.println(" ---- CADASTRO DE CLIENTES ---- ");
		
		
		do{
			cpf = Console.readLine("CPF: ");
		}while(!LtpUtil.validarCPF(cpf));
		
		do{
			nome = Console.readLine("NOME: ");
		}while(!nome.matches("^(\\D*)+(\\s*)+(\\D)$"));
		
		telefone =  Console.readLine("TELEFONE: ");
		
		do{
			email = Console.readLine("EMAIL: ");
		}while(!LtpUtil.validarEmail(email));
		
		
		Cadastro.incluirCliente(inclusaoCliente = new Cliente(nome,cpf,telefone,email, new GregorianCalendar(), new GregorianCalendar()));

	}
	
	/**
	 * Método responsável pela alteração dos cadastros dos Clientes.
	 * 
	 */
	private static void alterarCliente(){
		
		int codigo;
		String opcao;
	    Cliente alteracao;
		
		try {
			codigo = Console.readInt("Digite o código do usuário que deseja alterar: ");
			System.out.println(Cadastro.buscarClienteCod(codigo));		
			alteracao = Cadastro.buscarClienteCod(codigo);
			do{
			opcao = Console.readLine("Deseja  realmente alterar o cliente? (S/N): ");
			}while(!(opcao.toUpperCase().charAt(0) == 'S'));
			
			if(opcao.toUpperCase().charAt(0) == 'S' ){

				String cpf;
				String nome;
				String telefone;
				String email;
				GregorianCalendar data = new GregorianCalendar();

				System.out.println(" ---- ALTERAÇÃO DE CLIENTE ---- ");
				
				do{
					cpf = Console.readLine("CPF: ");
				}while(!LtpUtil.validarCPF(cpf));
				
				do{
					nome = Console.readLine("NOME: ");
				}while(!nome.matches("^(\\D*)+(\\s*)+(\\D)$"));
				
				telefone =  Console.readLine("TELEFONE: ");
				
				do{
					email = Console.readLine("EMAIL: ");
				}while(!LtpUtil.validarEmail(email));
				
				alteracao.setCpf(cpf);
				alteracao.setNome(nome);
				alteracao.setTelefone(telefone);
				alteracao.setEmail(email);
				alteracao.setDataUltAlteracao(data); // Passando data da alteração		
			}
			
		} catch (SisVendasException e) {
			System.out.println("Deu ruim manolo!!!!!");
		}	
	}
	
	
	/**
	 * Método responsável pela exclusão de clientes
	 * @throws SisVendasException - Quando não é possível encontrar o cliente
	 */
	public static void excluirCliente() throws SisVendasException{
		
		int codigo  = Console.readInt("Digite o código do cliente que deseja exlcuir: ");
		
		try{
		Cadastro.clientes.remove(Cadastro.buscarClienteCod(codigo));
		System.out.println("Cliente excluído com sucessso!");
		}catch(Exception e){
			 System.out.println("\nNão foi possível excuir o cliente, código inválido!");
		}
	}
	
	
	/**
	 * Método responsável pela busca de clientes pelo CPF
	 * @throws SisVendasException - Quando não é encontrado cliente pelo CPF informado
	 */
	public static void buscarClienteCPF() throws SisVendasException {
		String cpf = Console.readLine("Digite o CPF para buscar: " );
		System.out.println(Cadastro.buscarClienteCPF(cpf));			
	}
	
	public static void exibeEmOrdem() {
		
	}
	
	
	
}