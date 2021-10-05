package proj;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

	   
	@Id
	@GeneratedValue
	private Integer id;
	private String descricao;
	private Double preco;
	private static final long serialVersionUID = 1L;

	public Produto() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
   
}
