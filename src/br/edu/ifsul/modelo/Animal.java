
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author douglas
 */
    @Entity
    @Table(name="animal")
    public class Animal implements Serializable{
    @Id
    @SequenceGenerator(name="seq_animal", sequenceName = "seq_animal_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_animal", strategy =GenerationType.SEQUENCE)
    private Integer id;
    
    
    @NotBlank(message="O nome de ser informado") //verificando se o nome esta em branco, somente para string
    @Length (max = 50, message= "O nome não deve ultrapassar {max} caracteres")     
    @Column(name = "nome", length=50, nullable = false)
    private String nome;
          
    @NotBlank(message="A especie de ser informada") //verificando se o nome esta em branco, somente para string
    @Length (max = 50, message= "O nome não deve ultrapassar {max} caracteres")     
    @Column(name="especie", columnDefinition="text")
    private String especie;
      
    @NotBlank(message="A raca deve ser informado") //verificando se o nome esta em branco, somente para string
    @Length (max = 50, message= "O nome não deve ultrapassar {max} caracteres")     
    @Column(name="raca", columnDefinition="text")
    private String raca;
       
    @NotBlank(message="A tipo da pelagem deve ser informada") //verificando se o nome esta em branco, somente para string
    @Length (max = 50, message= "O nome não deve ultrapassar {max} caracteres")     
    @Column(name="pelagem", columnDefinition="text")
    private String pelagem;
    
                
    @NotNull (message="O Cliente deve ser informado")
    @ManyToOne //para chave estrangeira
    @JoinColumn(name="cliente", referencedColumnName="id",nullable=false)
    private Cliente cliente;
        

       public Animal() {
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

        
    @Override
    public String toString() { //mostra o nome não o endereço de memória
        return  nome;
    }

     

   
    
}