package br.edu.ifsul.testes.Junit;

import br.edu.ifsul.jpa.EntityManagerUtil;

import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestePersistirUsuario {

    EntityManager em;

    public TestePersistirUsuario() {
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
    public void teste() {
        boolean exception = false;
        try {
            Usuario obj = new Usuario();
            
            obj.setNome("Douglas Karczeski");
            obj.setTelefone("99999999");
            obj.setEmail("jorge.bavaresco@passofundo.ifsul.edu.br");
            obj.setEndereco("Rua tal");
            
            obj.setRg("8898584392");
            obj.setCpf("01189728044");
       
            
            obj.setApelido("douglas");
            obj.setSenha("douglas");
            obj.setStatus(true);
            obj.setAdmin(true);
            
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
