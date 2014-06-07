package janela;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Departamento;
import modelo.Empregado;
import modelo.Endereco;
import modelo.Tarefa;

public class Formulario {

	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager em = factory.createEntityManager();
		
		Departamento departamento = new Departamento("rh");
		
		Empregado emp1 = new Empregado("hjose", new Endereco("rua b"), departamento);
		Empregado emp2 = new Empregado("antonio", new Endereco("rua c"), departamento);
		
		
		departamento.getEmpregados().add(emp1);
		departamento.getEmpregados().add(emp2);
		em.getTransaction().begin();
		em.persist(departamento);
		em.getTransaction().commit();
		
		List<Departamento> list = em.createQuery("select d from Departamento d").getResultList();
		for (Departamento dep : list) {
			System.out.println(dep.getNome() + " " );
			  for (Empregado emp : dep.getEmpregados()) {
				System.out.println(emp.getNome() + " " + emp.getEndereco().getLogradouro());
			}
		}
		
		
	}
	public static void _main(String[] args) {
		/**
		//Responsável por pegar as informações no arquivo 
		//persistence.xml e configurar uma conexão com o 
		//banco de dados. (EntityManagerFactory)
		 * */
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("tarefas");
		
		/** /Atraves da fábrica do EntityManagerFactory o EntityManager é 
		//é criado. Ele é reponsável pela sessão do usuário com o banco.
		//Isto é, com ele é possível salvar, remover, excluir e listar
		//as informações do banco usando o paradigma de objetos. */
		EntityManager em = factory.createEntityManager();
		
		/*
		// inserir tarefa
		
		Tarefa tarefa = new Tarefa();
		tarefa.setDataInicio(Calendar.getInstance());
		tarefa.setDescricao("aprender JPA"); 
		
		em.getTransaction().begin();
		em.persist(tarefa);
		em.getTransaction().commit();
		em.close();
		*/
		
		/*
		//buscar um objeto do banco via em.
		//find busca um linha do banco de acordo com o seu id
		Tarefa tarefa = em.find(Tarefa.class, 1);
		System.out.println(tarefa.getDescricao());
		System.out.println(tarefa.getId());
		System.out.println(tarefa.getDataInicio().getTime());
		
		//remover um objeto do banco que tem que estar em uma transação
		em.getTransaction().begin();
		em.remove(tarefa); 
		em.getTransaction().commit();
		*/
		
		//listar todos do banco
		List<Tarefa> tarefas = 
				em.createQuery("select t from Tarefa t").getResultList();
		for(Tarefa tar : tarefas){
			System.out.println(tar.getId() + " " + tar.getDescricao()); 
		}
		
		Tarefa tarefa = em.find(Tarefa.class, 2l);
		tarefa.setDescricao("Aprender Orientação a objetos");
		
		em.getTransaction().begin();
		em.merge(tarefa);
		em.getTransaction().commit();
		em.close();
		factory.close();
		

	}

}
