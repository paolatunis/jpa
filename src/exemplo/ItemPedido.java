package exemplo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="CodItemPedido", columnDefinition= "INT(4)")
	private Integer codItemPedido;
	
	@ManyToOne
	@JoinColumn(name = "CodProduto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "CodPedido")
	private Pedido pedido;
	
	@Column(name ="Quantidade", columnDefinition="INT(5)", nullable= false)
	private Integer quantidade;

	public ItemPedido() {
		super();
	}

	public ItemPedido(Integer codPedido, Produto produto, Pedido pedido, Integer quantidade) {
		super();
		this.codItemPedido = codPedido;
		this.produto = produto;
		this.pedido = pedido;
		this.quantidade = quantidade;
	}

	public Integer getCodPedido() {
		return codItemPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codItemPedido = codPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
