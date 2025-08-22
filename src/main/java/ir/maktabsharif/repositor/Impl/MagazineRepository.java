package ir.maktabsharif.repositor.Impl;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.model.Magazine;
import ir.maktabsharif.repositor.BaseRepository;
import ir.maktabsharif.util.EntityManagerProvider;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MagazineRepository implements BaseRepository<Magazine,Long> {
    @Override
    public Magazine add(Magazine item) {
        EntityManager entityManager= EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(item);
        entityManager.getTransaction().commit();
        entityManager.close();
        return item;
    }
    @Override
    public Magazine update(Long aLong, String title) {
        EntityManager entityManager=EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Magazine item=entityManager.find(Magazine.class,aLong);
        if(item==null){
            throw new NullPointerException("item is null.");
        }
        item.setTitle(title);
        entityManager.getTransaction().commit();
        entityManager.close();
        return item;
    }

    @Override
    public void remove(Long aLong) {
        EntityManager entityManager=EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Magazine item=entityManager.find(Magazine.class,aLong);
        if(item==null){
            throw new NullPointerException("item is null.");
        }
        entityManager.remove(item);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Override
    public List<Magazine> findAll() {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        return entityManager.createQuery("select b from Magazine b",Magazine.class).getResultList();

    }
}
