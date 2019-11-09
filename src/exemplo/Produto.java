package exemplo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(4)")
	private Integer codProduto;
	
	@Column(columnDefinition="VARCHAR(100)", nullable=false)
	private String descricao;
	
	@Column(columnDefinition="DECIMAL(10,2)", nullable=false)
	private Double valorUnitario;
	
	public Produto() {
		super();
	}

	public Produto(Integer codProduto, String descricao, Double valorUnitario) {
		super();
		this.codProduto = codProduto;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
	}

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	

}
