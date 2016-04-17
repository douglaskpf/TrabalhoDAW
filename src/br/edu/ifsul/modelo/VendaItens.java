
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Entity
@Table(name = "venda_itens")
public class VendaItens implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_venda_item", 
            sequenceName = "seq_venda_item_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_venda_item", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A quantidade deve ser informada")
    @Column(name = "quantidade", nullable = false,columnDefinition = "numeric(10,2)")
    private Double quantidade;
    
    @NotNull(message = "O valor unitario deve ser informado")
    @Column(name = "valor_unitario", nullable = false,columnDefinition = "numeric(10,2)")    
    private Double valorUnitario;
    
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false,columnDefinition = "numeric(10,2)")    
    private Double valorTotal;
    
   // @NotNull(message = "Informe o produto")
    @ManyToOne
    @JoinColumn(name = "produto", referencedColumnName = "id", nullable = true)
    private Produto produto;
    
    
//    @NotNull(message = "Informe o serviço")
    @ManyToOne
    @JoinColumn(name = "servico", referencedColumnName = "id", nullable = true)
    private Servico servico;
       
       
    @NotNull(message = "A venda deve ser informada")
    @ManyToOne
    @JoinColumn(name = "venda_id",referencedColumnName = "id", nullable = false)
    private Venda venda;

    public VendaItens() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
     public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }


    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VendaItens other = (VendaItens) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
}
