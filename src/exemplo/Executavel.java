package exemplo;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Executavel {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
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
		
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
