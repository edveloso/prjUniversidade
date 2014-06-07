package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;




@Entity
public class Empregado implements Comparable<Empregado>{

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@OneToOne
	@Cascade({org.hibernate.annotations.CascadeType.ALL})
	@JoinColumn(name="end_emp_id")
	private Endereco endereco;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dep_emp_id",
			referencedColumnName="id"
			)
	private Departamento departamento;
	
	public Empregado() {
		// TODO Auto-generated constructor stub
	}
	
	public Empregado(String nome, Endereco endereco,Departamento departamento) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.departamento = departamento;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int compareTo(Empregado o) {
		return nome.compareTo(o.nome);
	}
	

}
