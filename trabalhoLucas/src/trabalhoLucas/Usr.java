package trabalhoLucas;

import java.util.Date;

public class Usr {
	private String nome;
	private String cidade;
	private String bairro;
	private String ddd;
	private String numero;
	private Date dataNascimento;
	private String cpf;
	
	public void setUsr(String nome, String cidade, String bairro, String ddd, String numero, Date dataNascimento, String cpf){
		this.nome = nome;
		this.bairro = bairro;
		this.cidade = cidade;
		this.ddd = ddd;
		this.cpf = cpf;
		this.numero = numero;
		this.dataNascimento = dataNascimento;
	}
	public String toString() {
		return nome + cidade + bairro + ddd + numero + cpf;
	}

}
