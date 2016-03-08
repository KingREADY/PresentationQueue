package com.github.kingready.presentationqueue.session;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class EntityManagerProvider implements TestRule {

    private EntityManager em;
    private EntityTransaction tx;
    private PresentationFacade facade;
    private final String unitName;

    public EntityManagerProvider(String unitName) {
        this.unitName = unitName;
    }

    public void setUp() {
        System.out.println("persistence.xml: " + getClass().getResource("META-INF/persistence.xml"));
        this.em = Persistence.createEntityManagerFactory(unitName).createEntityManager();
        this.tx = em.getTransaction();
    }

    public void injectDependencies() {
        setUp();
        this.facade = new PresentationFacade();
        this.facade.em = this.em;
    }

    private void tearDown() {
        if (em.isOpen()) {
            em.close();
        }
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                injectDependencies();
                base.evaluate();
                tearDown();
            }
        };
    }

    public PresentationFacade facade() {
        return facade;
    }

    public EntityTransaction tx() {
        return tx;
    }
}
