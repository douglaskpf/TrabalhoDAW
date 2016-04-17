
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public abstract class Pessoa implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_pessoa",sequenceName = "seq_pessoa_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome deve ter até {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    
    @NotBlank(message = "O numero deve ser informado")
    @Length(max = 14, message = "O numero não deve ultrapassar {max} caracteres")
    @Column(name = "telefone", nullable = false, length = 14)    
    private String telefone;    
 
    @Email(message = "Informe um email valido")
    @NotBlank(message = "O email deve ser informado")
    @Length(max = 50, message = "O email deve ter até {max} caracteres")
    @Column(name = "email", nullable = false, length = 50)    
    private String email;
    
    @NotBlank(message = "O endereço deve ser informado")
    @Length(max = 50, message = "O endereço deve ter até {max} caracteres")
    @Column(name = "endereco", nullable = false, length = 50)    
    private String endereco;
    
   

    public Pessoa() {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
   

   

  
    @Override
    public String toString() {
        return nome;
    }
    

}
