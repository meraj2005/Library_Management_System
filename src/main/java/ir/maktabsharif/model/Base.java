package ir.maktabsharif.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Base<ID extends  Number> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "base")
    @SequenceGenerator(name="base",sequenceName = "base_sequence",allocationSize = 0)
    private ID id;
    private LocalDate createAt;
    private LocalDate updateAt;

    public ID getId(){
        return id;
    }
    @PrePersist
    protected void onCreate(){
        createAt=LocalDate.now();
        updateAt=createAt;

    }
    @PreUpdate
    protected void onUpdate(){
        updateAt=LocalDate.now();
    }



}
