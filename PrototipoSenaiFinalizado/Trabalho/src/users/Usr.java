package users;

import java.util.Date;

public class Usr {
        private String id;
	private String nome;
	private String cidade;
	private String bairro;
	private String ddd;
	private String numero;
	private String cpf;
        private int idade;
	
	public String toString() {
		return getNome() + getCidade() + getBairro() + getDdd() + getNumero() + getCpf();
	}


    public String getNome() {
        return nome;
    }

 
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

   
    public String getBairro() {
        return bairro;
    }

 
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getDdd() {
        return ddd;
    }


    public void setDdd(String ddd) {
        this.ddd = ddd;
    }


    public String getNumero() {
        return numero;
    }

 
    public void setNumero(String numero) {
        this.numero = numero;
    }

 


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public int getIdade() {
        return idade;
    }

  
    public void setIdade(int idade) {
        this.idade = idade;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

}
