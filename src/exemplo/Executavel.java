package exemplo;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Executavel {
	
	//Liste os produtos, do mais caro para o mais barato, dos pedidos no mês de junho
	//(considerando todos os anos)
	//Linhas: 871

	public static void questaoUm(final EntityManager em) {
		String jpql = "SELECT P.codProduto AS Produto, P.descricao, P.valorUnitario  " + 
				"FROM ItemPedido I INNER JOIN I.produto P " + 
				"INNER JOIN I.pedido E " +
				"WHERE MONTH(E.dataPedido)=6 " +
				"GROUP BY P.codProduto ORDER BY P.valorUnitario DESC";
		
		TypedQuery<Object[]> typedQuery = em.createQuery(jpql, Object[].class);
		List<Object[]> lista = typedQuery.getResultList();
			
		lista.stream().forEach(result -> System.out.println("Produto " + result[0] + " - Descricao " + result[1] + " - ValorUnitatio: " + result[2]));
		//System.out.println(lista.size());
	}
	
	
	
	
	// Liste o nome dos clientes e o total de pedidos de cada cliente, em ordem crescente
	//de pedidos. Os clientes sem pedidos também devem ser listados. (total asc, nome asc)
	//Linhas: 1575
	public static void questaoDois(final EntityManager em) {
		String jpql = "select c.codCliente, c.nome as Cliente, COUNT(p.codPedido) as totalpedidos from Pedido p "
				+ "LEFT JOIN p.cliente c ON c.codCliente = p.cliente.codCliente " + 
				"group by c.nome order by totalpedidos, c.nome";
		
		TypedQuery<Object[]> typedQuery = em.createQuery(jpql, Object[].class);
		List<Object[]> lista = typedQuery.getResultList();
		
		lista.stream().forEach(result -> System.out.println("CodCliente: " + result[0] + " - Nome: " + result[1] + " - TotalPedidos: " + result[2]));
		//System.out.println(lista.size());
	}
	
	
	


	//Ver os pedidos de cada cliente, listando nome do cliente e número do pedido. (codpedido asc,
	//codcliente asc) Linhas: 8432 
	
	public static void questaoTres(final EntityManager em) {
		String jpql = "select c.codCliente, c.nome as cliente,  " + 
				"p.codPedido as pedido  " + 
				"from Pedido p inner join p.cliente c order by p.codPedido";
		
		TypedQuery<Object[]> typedQuery = em.createQuery(jpql, Object[].class);
		List<Object[]> lista = typedQuery.getResultList();
		
		
		lista.stream().forEach(result -> System.out.println("CodCliente: " + result[0] + " - Nome: " + result[1] + " - CodPedido: " + result[2]));
		//System.out.println(lista.size());
	}
	
	
	
	
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		//questaoUm(em);
		//questaoDois(em);
		//questaoTres(em);
		
		em.getTransaction().commit();

		em.close();
		emf.close();
		
	}


	//public static void main(String[] args) {
	//		Vendedor vendedor = new Vendedor(null, "Paola Tunis", 1000.0, Comissao.A);
	//		em.persist(vendedor);

	//		Produto produto = new Produto(null, "ASPIRADOR DE PO HLD P/TECLADO FD-368", 528.89);
	//		em.persist(produto);

	//		Cliente c = new Cliente(null, "Laura Gomez", "95277  Cuba Blvd.", "Warren", "06776", "RR", "318533545");
	//		em.persist(c);

	//		Vendedor vendedor = new Vendedor();
	//		vendedor.setCodVendedor(1);
	//		Cliente cliente = new Cliente();
	//		cliente.setCodCliente(1);		
	//		Pedido p = new Pedido(null, LocalDate.of(2020, 10, 10), LocalDate.now(), cliente, vendedor);
	//		em.persist(p);

	//		Pedido pedido = new Pedido();
	//		pedido.setCodPedido(1);
	//		Produto produto = new Produto();
	//		produto.setCodProduto(1);
	//		ItemPedido i = new ItemPedido(null, produto, pedido, 10);
	//		em.persist(i);

}