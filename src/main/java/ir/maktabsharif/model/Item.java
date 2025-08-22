package ir.maktabsharif.model;

import ir.maktabsharif.enums.ItemStatus;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class Item<ID extends Number> extends Base<ID > {

    private String title;

    private String author;

    private int year;

    @Embedded
    private Publisher publisher;


    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    public Item() {
    }

    public Item(String title, String author, int year, Publisher publisher, ItemStatus itemStatus) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.itemStatus = itemStatus;
    }

    public String getTitle(){
        return title;
    }
    public  String getAuthor(){
        return author;
    }
    public int getYear(){
        return year;
    }

}
