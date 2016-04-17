package br.edu.ifsul.testes.Junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Animal;
import br.edu.ifsul.modelo.Cliente;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author douglas
 */

//versão do pacote Junit

public class TestePersistirAnimal {
    
      EntityManager em;
    
    public TestePersistirAnimal() {
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
            
            Animal ani = new Animal();
            
            Cliente cli = em.find(Cliente.class, 1); //chave estrangeira apontado para o cliente 1
                        
            ani.setNome("Julinho");
            ani.setEspecie("cachorro");
            ani.setRaca("Poodle");
            ani.setPelagem("crespíssimo");
        
            ani.setCliente(cli);//setando o cliente
            
            em.getTransaction().begin();
            em.persist(ani);
            em.getTransaction().commit();
            
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
 }   