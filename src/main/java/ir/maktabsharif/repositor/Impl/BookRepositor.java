package ir.maktabsharif.repositor.Impl;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.model.Item;
import ir.maktabsharif.repositor.BaseRepository;
import ir.maktabsharif.util.EntityManagerProvider;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BookRepositor implements BaseRepository<Book,Long> {
    @Override
    public Book add(Book item) {
        EntityManager entityManager=EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(item);
        entityManager.getTransaction().commit();
        entityManager.close();
        return item;
    }
    @Override
    public Book update(Long aLong, String title) {
        EntityManager entityManager=EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Book item=entityManager.find(Book.class,aLong);
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
        Book item=entityManager.find(Book.class,aLong);
        if(item==null){
            throw new NullPointerException("item is null.");
        }
        entityManager.remove(item);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Override
    public List<Book> findAll() {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        return entityManager.createQuery("select b from Book b",Book.class).getResultList();

    }
}
