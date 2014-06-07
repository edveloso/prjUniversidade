package modelo;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="departamento", fetch=FetchType.LAZY)
	private Set<Empregado> empregados;

	public Departamento() {
	}

	public Departamento(String nome) {
		super();
		empregados = new TreeSet<Empregado>();
		this.nome = nome;
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

	public Set<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(Set<Empregado> empregados) {
		this.empregados = empregados;
	}
	

}
