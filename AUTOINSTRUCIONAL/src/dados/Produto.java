package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;
import utilitarios.LtpUtil;


public class Produto implements Serializable {
	
	private static int sequence = 0;
	
	private int codigo;	
	private String nome;
	private double precoUnitatio;
	private GregorianCalendar dataInclusao = new GregorianCalendar();
	private GregorianCalendar dataUltAlteracao = new GregorianCalendar();
	
	public Produto(String nome, double precoUnitatio,
			GregorianCalendar dataInclusao, GregorianCalendar dataUltAlteracao) {
		
		
		this.codigo = ++sequence;
		this.nome = nome;
		this.precoUnitatio = precoUnitatio;
		this.dataInclusao = dataInclusao;
		this.dataUltAlteracao = dataUltAlteracao;
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
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public static int getSequence() {
		return sequence;
	}

	public static void setSequence(int sequence) {
		Produto.sequence = sequence;
	}

	@Override
	public String toString() {
		return "\nProduto\n Codigo = " + codigo + ", \n Nome = " + nome
				+ ", \n Pre�o Unit�tio = " + precoUnitatio + ", \n Data de inclus�o = " + LtpUtil.formatarData( dataInclusao, "dd/MM/yyyy hh:mm")
				+ ", \n Data de altera��o = =" + LtpUtil.formatarData( dataUltAlteracao, "dd/MM/yyyy hh:mm");
	}
	
}
