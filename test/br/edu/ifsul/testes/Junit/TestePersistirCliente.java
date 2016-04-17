
package br.edu.ifsul.testes.Junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import javax.persistence.EntityManager;
import br.edu.ifsul.modelo.Cliente;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestePersistirCliente {
    
    EntityManager em;
    
    public TestePersistirCliente() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
        Boolean exception = false;
        try {
            
            Cliente cli = new Cliente();
            
            cli.setNome("Douglas");
            cli.setTelefone("99999999");
            cli.setEmail("douglas.kraczeski@passofundo.ifsul.edu.br");
            cli.setEndereco("Rua xxxx");
           
              
            cli.setRg("2072517069");
            cli.setCpf("09263784655");
       

          
            em.getTransaction().begin();
            em.persist(cli);
            em.getTransaction().commit();
            
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
