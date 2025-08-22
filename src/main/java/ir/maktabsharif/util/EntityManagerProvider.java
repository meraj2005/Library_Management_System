package ir.maktabsharif.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("postgres");
    public static final EntityManager getEntityManager (){
        if (emf==null&&!emf.isOpen()){
            throw new IllegalStateException("entity manager factory is null.");
        }
        return emf.createEntityManager();
    }
    public static void close(){
        if(emf!=null&&emf.isOpen()){

            emf.close();
        }
    }

}
