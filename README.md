prjUniversidade
===============

Aula de JPA para o curso de extensão


Configuração:
	Arquivo persistence.xml
	Anotações
EntityManagerFactory
EntityManager
Transaction
API:
	find
	remove
	merge
	createQuery....getResultList	
	createQuery....getResultList	
	Query ... setParameter


Mapeamento
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="CUSTOMER_ID")

    @OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="USER_ID", nullable=true)


