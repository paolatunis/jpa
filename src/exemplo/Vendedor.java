package exemplo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendedor {
	
	@Id //chave primária
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Especifica como a chave primária pode ser inicializada: Automático, manual ou valor tirado da tabela de seqüência.
	@Column(columnDefinition= "INT(4)") //especifica coluna
	private Integer codVendedor;
	
	
	@Column(columnDefinition="VARCHAR(45)")
	private String nome;
	
	@Column(columnDefinition="DECIMAL(10,2)", nullable=false) //nullable false - not null
	private double salarioFixo;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "enum('A','B','C','D')", nullable=false) //not null
	private Comissao faixaComissao; //tem uma classe comissão que define como enum
	
		
	public Vendedor() {
		super();
	}


	public Vendedor(Integer codVendedor, String nome, double salarioFixo, Comissao faixaComissao) {
		super();
		this.codVendedor = codVendedor;
		this.nome = nome;
		this.salarioFixo = salarioFixo;
		this.faixaComissao = faixaComissao;
	}


	public Integer getCodVendedor() {
		return codVendedor;
	}


	public void setCodVendedor(Integer codVendedor) {
		this.codVendedor = codVendedor;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getSalarioFixo() {
		return salarioFixo;
	}


	public void setSalarioFixo(float salarioFixo) {
		this.salarioFixo = salarioFixo;
	}


	public Comissao getFaixaComissao() {
		return faixaComissao;
	}


	public void setFaixaComissao(Comissao faixaComissao) {
		this.faixaComissao = faixaComissao;
	}

	

}
