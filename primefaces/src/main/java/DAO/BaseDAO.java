package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProviderResolverHolder;
 
import org.apache.log4j.Logger;

import entity.Book;
import interfaces.DAO;
 
/**
 */
public abstract class BaseDAO implements DAO {
 
    private final static Logger logger = Logger.getLogger(BaseDAO.class);
 
    protected final static EntityManagerFactory EMF;
 
    static {
        logger.info("Initializing EntityManagerFactory...");
        logger.info("providers:"
                + PersistenceProviderResolverHolder
                        .getPersistenceProviderResolver()
                        .getPersistenceProviders());
        EMF = Persistence.createEntityManagerFactory("default");
    }
 
    public EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }
 
    public boolean delete(Integer id, Class clazz) {
        EntityManager e = getEntityManager();
        EntityTransaction t = null;
        try {
            t = e.getTransaction();
            t.begin();
            Book b = e.find(clazz, id);
            e.remove(b);
            t.commit();
            return true;
        } catch (Exception ex) {
            if (t != null && t.isActive())
                t.rollback();
            logger.error(ex.getMessage(), ex);
            return false;
        } finally {
            e.close();
        }
    }
 
    public boolean save(Object object) {
        EntityManager e = getEntityManager();
        EntityTransaction t = null;
        try {
            t = e.getTransaction();
            t.begin();
            e.merge(object);
            t.commit();
            return true;
        } catch (Exception ex) {
            if (t != null && t.isActive())
                t.rollback();
            ex.printStackTrace(System.out);
            return false;
        } finally {
            e.close();
        }
    }
 
    public Object findById(Integer id, Class classs) {
        return getEntityManager().find(classs, id);
    }
 
    public List findAll(String query) {
        return getEntityManager().createQuery(query).getResultList();
    }
 
}