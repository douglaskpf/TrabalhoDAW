/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.Junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Funcionario;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author douglas
 */
public class TestePersistirFuncionario {
    
     EntityManager em;
    
    public TestePersistirFuncionario() {
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
            
            Funcionario fun = new Funcionario();
            
            fun.setNome("Feliz");
            fun.setTelefone("99999999");
            fun.setEmail("douglas.kraczeski@passofundo.ifsul.edu.br");
            fun.setEndereco("Rua xxxx");
                       
            fun.setRg("2072517069");
            fun.setCpf("95948076016");
          
          
            em.getTransaction().begin();
            em.persist(fun);
            em.getTransaction().commit();
            
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
