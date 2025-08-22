package ir.maktabsharif.repositor;

import java.util.List;

public interface BaseRepository<T , ID>{
     T add(T t);
     T update(ID id,String title);
     void remove(ID id);
     List<T> findAll();
}
