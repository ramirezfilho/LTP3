package dados;

import java.util.ArrayList;

public class Mensalista extends Funcionario {

	private double salarioMensal;
	private ArrayList<Falta> listaFaltas = new ArrayList<>();
	
	public Mensalista(String nome, String cpf, double salarioMensal) {
		super(nome, cpf);
		this.salarioMensal = salarioMensal;
	}

	public double getSalarioMensal() {
		return salarioMensal;
	}

	public void setSalarioMensal(double salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	public ArrayList<Falta> getListaFaltas() {
		return listaFaltas;
	}

	public void setListaFaltas(ArrayList<Falta> listaFaltas) {
		this.listaFaltas = listaFaltas;
	}


	@Override
	public double getSalario(int mes, int ano) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTipo() {
		return MENSALISTA;
	}
	
	
	
	
	
}
