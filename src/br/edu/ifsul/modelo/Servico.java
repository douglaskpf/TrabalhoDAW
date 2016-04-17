
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "servico")
public class Servico implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_servico", sequenceName = "seq_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_servico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ultrapassar {max} caracteres")    
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    
    @NotNull(message = "O preço deve ser informado")
    @Column(name = "preco", nullable = false, columnDefinition = "decimal(12,2)")
    private Double preco;
    
     
      
      
    @NotNull(message = "O cliente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;
       
        
        @ManyToMany
        @JoinTable(name = "desejos_servicos",
            joinColumns = 
            @JoinColumn(name = "servico", referencedColumnName = "id", 
                    nullable = false), 
            inverseJoinColumns = 
            @JoinColumn(name = "cliente", referencedColumnName = "id", 
                    nullable = false))
    private List<Cliente> desejam = new ArrayList<>();
    
     
     @OneToMany(mappedBy = "agendamentoID.servico", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();
     
    public Servico() {
    }
    
    
    public void gerarAgendamentos(){
   
            Agendamento ag = new Agendamento();
            AgendamentoID id = new AgendamentoID();
            id.setNumero(5);
            id.setServico(this);
            ag.setAgendamentoID(id);
                        
           
         // maneira correta de copiar uma data
         //   Calendar data = (Calendar) this.data.clone();
        
        
            Calendar data = Calendar.getInstance();
           
             data.set(Calendar.MONTH, Calendar.APRIL);
             data.set(Calendar.DAY_OF_MONTH, 17);
             data.set(Calendar.YEAR,2016);
             data.set(Calendar.HOUR_OF_DAY, 14); 
             data.set(Calendar.MINUTE,30);
             data.set(Calendar.SECOND,00);
      
             
             ag.setDataAgendamento(data);
                                         
             this.agendamentos.add(ag);
             
                        
        }
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
     public List<Cliente> getDesejam() {
        return desejam;
    }

    public void setDesejam(List<Cliente> desejam) {
        this.desejam = desejam;
    }


    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

  
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

 
   
  
    
}
