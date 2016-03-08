package com.github.kingready.presentationqueue.session;

import com.github.kingready.presentationqueue.entity.Presentation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PresentationFacade extends AbstractFacade<Presentation>{

    @PersistenceContext
    EntityManager em;

    public PresentationFacade() {
        super(Presentation.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
