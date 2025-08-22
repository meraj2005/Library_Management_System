package ir.maktabsharif.model;

import ir.maktabsharif.enums.ItemStatus;
import jakarta.persistence.Entity;

@Entity
public class Magazine extends Item<Long>{
    public Magazine() {
    }

    public Magazine(String title, String author, int year, Publisher publisher, ItemStatus itemStatus) {
        super(title, author, year, publisher, itemStatus);
    }
}
