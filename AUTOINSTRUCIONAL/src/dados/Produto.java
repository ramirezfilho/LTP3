package dados;

import java.util.GregorianCalendar;

public class Produto {
	
	private static int sequence = 1;
	
	private int codigo;
	private String cpf;
	private String nome;
	private double precoUnitatio;
	private GregorianCalendar dataInclusao = new GregorianCalendar();
	private GregorianCalendar dataUltAlteracao = new GregorianCalendar();
	
	public Produto(String cpf, String nome, double precoUnitatio,
			GregorianCalendar dataInclusao, GregorianCalendar dataUltAlteracao) {
		
		
		this.codigo = sequence++;
		this.cpf = cpf;
		this.nome = nome;
		this.precoUnitatio = precoUnitatio;
		this.dataInclusao = dataInclusao;
		this.dataUltAlteracao = dataUltAlteracao;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoUnitatio() {
		return precoUnitatio;
	}
	public void setPrecoUnitatio(double precoUnitatio) {
		this.precoUnitatio = precoUnitatio;
	}
	public GregorianCalendar getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(GregorianCalendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public GregorianCalendar getDataUltAlteracao() {
		return dataUltAlteracao;
	}
	public void setDataUltAlteracao(GregorianCalendar dataUltAlteracao) {
		this.dataUltAlteracao = dataUltAlteracao;
	}
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", cpf=" + cpf + ", nome=" + nome
				+ ", precoUnitatio=" + precoUnitatio + ", dataInclusao="
				+ dataInclusao + ", dataUltAlteracao=" + dataUltAlteracao + "]";
	}
	
	
	
	
	
}
