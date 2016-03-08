package com.github.kingready.presentationqueue.session;

import com.github.kingready.presentationqueue.entity.Presentation;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

public class T04FacadeIT {

//    private PresentationFacade facade;
//    EntityManager em;
//    private EntityTransaction tx;
    
    @Rule 
    public EntityManagerProvider provider = new EntityManagerProvider("IntegrationTestingPU");
    
    public T04FacadeIT() {
    }
    
//    public void setUp() {
//        System.out.println("persistence.xml: "+getClass().getResource("META-INF/persistence.xml"));
//        this.em = Persistence.createEntityManagerFactory("IntegrationTestingPU").createEntityManager();
//        this.tx = em.getTransaction();
//    }
//    
//    @Before
//    public void injectDependencies() {
//        setUp();
//        this.facade = new PresentationFacade();
//        this.facade.em = this.em;
//    }

    @Test
    public void verifyMappings() {
        System.out.println("verify Mappings");
//        this.tx.begin();
        provider.tx().begin();
        Presentation presentation = new Presentation("f.pohnemaennchen", "Testing", "PRJ");
        provider.facade().create(presentation);
        provider.tx().commit();
//        this.facade.create(presentation);
//        this.tx.commit();
    }
}
