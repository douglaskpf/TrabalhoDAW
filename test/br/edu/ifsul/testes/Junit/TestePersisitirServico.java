/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.Junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Servico;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author douglas
 */
public class TestePersisitirServico {
    
        EntityManager em;
    
    public TestePersisitirServico() {
    }
    
    @Before
    public void setUp() {
        
         em = em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        
        em.close();
    }
    
    
     @Test
    public void teste(){
        Boolean exception = false;
        try {
            
        Servico s = new Servico();
        s.setCliente(em.find(Cliente.class, 4));
        s.setNome("banho");
        s.setDescricao("banho e tosa");
        s.setPreco(40.00);

        
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
            
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
    
}
