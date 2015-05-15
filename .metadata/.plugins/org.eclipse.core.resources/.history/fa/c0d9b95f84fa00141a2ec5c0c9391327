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
		/*
		Cliente teste = new Cliente("Jovem","1111111","12445","jovem@email.com", new GregorianCalendar(10,10,2010), new GregorianCalendar(10,10,2012));
		Cliente teste1 = new Cliente("Jovenzinho","122222","12445","jovem@email.com", new GregorianCalendar(10,10,2010), new GregorianCalendar(10,10,2012));
		
		Cadastro.incluirCliente (teste);
		Cadastro.incluirCliente (teste1);
		
		
		System.out.println(Cadastro.buscarClienteCPF("122222"));
		System.out.println(LtpUtil.formatarData(new GregorianCalendar(), "dd/MM/yyyy"));
		*/
		
		
		incluirCliente();
		
		System.out.println(Cadastro.buscarClienteCod("Ramirez Goncalves"));
		
	
	
	
	}

	
	
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
	
	
	
}
