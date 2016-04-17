
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "cliente")
public class Cliente extends Pessoa implements Serializable {
    
    @NotBlank(message = "O RG deve ser informado")
    @Length(max = 11, message = "O RG não deve ultrapassar {max} caracteres")
    @Column(name = "rg", nullable = false, length = 11)
    private String rg;
    
    @CPF(message = "O CPF deve ser válido")
    @NotBlank(message = "O CPF deve ser informado")
    @Length(max = 14, message = "O CPF não deve ultrapassar {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;
    
    
    @ManyToMany
    @JoinTable(name = "desejos_produtos",
            joinColumns = 
            @JoinColumn(name = "cliente", referencedColumnName = "id", 
                    nullable = false), 
            inverseJoinColumns = 
            @JoinColumn(name = "produto", referencedColumnName = "id", 
                    nullable = false))
    private List<Produto> desejos_produtos = new ArrayList<>();
    
    
    @ManyToMany
    @JoinTable(name = "desejos_servicos",
            joinColumns = 
            @JoinColumn(name = "cliente", referencedColumnName = "id", 
                    nullable = false), 
            inverseJoinColumns = 
            @JoinColumn(name = "servico", referencedColumnName = "id", 
                    nullable = false))
    private List<Servico> desejos_servicos = new ArrayList<>();
    
    

    public Cliente() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    public List<Produto> getDesejos_produtos() {
        return desejos_produtos;
    }

    public void setDesejos_produtos(List<Produto> desejos_produtos) {
        this.desejos_produtos = desejos_produtos;
    }

    public List<Servico> getDesejos_servicos() {
        return desejos_servicos;
    }

    public void setDesejos_servicos(List<Servico> desejos_servicos) {
        this.desejos_servicos = desejos_servicos;
    }

    
}