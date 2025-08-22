package ir.maktabsharif.model;

import ir.maktabsharif.enums.ItemStatus;
import jakarta.persistence.Entity;

@Entity

public class Book extends Item<Long>{

    public Book() {
    }

    public Book(String title, String author, int year, Publisher publisher, ItemStatus itemStatus) {
        super(title, author, year, publisher, itemStatus);
    }
}
