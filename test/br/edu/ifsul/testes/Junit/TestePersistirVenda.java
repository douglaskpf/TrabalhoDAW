package br.edu.ifsul.testes.Junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Servico;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.modelo.Venda;
import br.edu.ifsul.modelo.VendaItens;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestePersistirVenda {

    EntityManager em;

    public TestePersistirVenda() {
    }

    @Before
    public void setUp() {                       
        em = em = EntityManagerUtil.getEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        
        
    }
    
    //persistindo produto

  @Test
    public void teste() {
        boolean exception = false;
        try {
            Venda v = new Venda();
            v.setData(Calendar.getInstance());
            v.setPagamento("A vista");
            v.setCliente(em.find(Cliente.class, 1));
            v.setUsuario(em.find(Usuario.class, 2));
            
            VendaItens vip = new VendaItens();
            vip.setProduto(em.find(Produto.class, 1));
            vip.setValorUnitario(vip.getProduto().getPreco());
            vip.setQuantidade(1.0);
            vip.setValorTotal(vip.getValorUnitario()*vip.getQuantidade());
            v.adicionarItem(vip);
            
                     
            
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

        //persistindo servico
    
 /*  @Test
    public void teste2() {
        boolean exception = false;
        try {
            Venda v = new Venda();
            v.setData(Calendar.getInstance());
            v.setPagamento("A prazo");
            v.setCliente(em.find(Cliente.class, 1));
            v.setUsuario(em.find(Usuario.class, 2));
            
                   
          VendaItens vis = new VendaItens();
          vis.setServico(em.find(Servico.class,2));
          vis.setValorUnitario(vis.getServico().getPreco());
          vis.setQuantidade(2.0);
          vis.setValorTotal(vis.getValorUnitario()*vis.getQuantidade());
          v.adicionarItem(vis);
            
            
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
*/
    
}
