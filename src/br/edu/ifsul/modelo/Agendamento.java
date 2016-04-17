
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "agendamento")
public class Agendamento implements Serializable {
    @EmbeddedId
    private AgendamentoID agendamentoID;
    
    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_agendamento", nullable = false)
    private Calendar dataAgendamento;
    
 
   /* @NotNull(message = "A hora deve ser informada")
    @Temporal(TemporalType.TIME)
    @Column(name = "hora_agendamento", nullable = false)
    private Calendar horaAgendamento;
    */
    

    public Agendamento() {
    }

    public AgendamentoID getAgendamentoID() {
        return agendamentoID;
    }

    public void setAgendamentoID(AgendamentoID agendamentoID) {
        this.agendamentoID = agendamentoID;
    }

     public Calendar getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Calendar dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    
         

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.agendamentoID);
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
        final Agendamento other = (Agendamento) obj;
        if (!Objects.equals(this.agendamentoID, other.agendamentoID)) {
            return false;
        }
        return true;
    }

        

}
