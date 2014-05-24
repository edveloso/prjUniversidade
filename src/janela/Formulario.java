package janela;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.service.spi.Manageable;

import modelo.Tarefa;

public class Formulario {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("tarefas");
		
		Tarefa tarefa = new Tarefa();
		Calendar dataFinalizacao = Calendar.getInstance();
		tarefa.setDataFinalizacao(dataFinalizacao);
		tarefa.setDescricao("estudar jpa");
		tarefa.setFinalizado(true);
		
		EntityManager em = factory.createEntityManager();
		List<Tarefa> lista = em.createQuery("select t from Tarefa t").getResultList();
		//System.out.println(found.getDescricao());
		 for (Tarefa t : lista) {
			System.out.println(t.getDescricao());
		}
		
		
	}

}
