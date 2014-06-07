package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class Endereco {

	@Id
	@GeneratedValue
	private Long id;
	private String logradouro;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	public Endereco(String logradouro) {
		super();
		this.logradouro = logradouro;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	

}
