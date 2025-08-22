package ir.maktabsharif;

import ir.maktabsharif.enums.ItemStatus;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.model.Magazine;
import ir.maktabsharif.model.Publisher;
import ir.maktabsharif.repositor.BaseRepository;
import ir.maktabsharif.repositor.Impl.BookRepositor;
import ir.maktabsharif.repositor.Impl.MagazineRepository;

public class Main {
    public static void main(String[] args) {

        Book book1=new Book("dev","davod",2000,new Publisher("gaj","tehran"), ItemStatus.LOST);
        Book book2=new Book("delbar","davod",2020,new Publisher("gaj","tehran"), ItemStatus.AVAILABLE);

        Magazine magazine1=new Magazine("shahrvand","Ali",2024,new Publisher ("kayhan","thran"),ItemStatus.AVAILABLE);
        Magazine magazine2=new Magazine("vezartkhone","Meraj",2014,new Publisher ("kayhan","thran"),ItemStatus.BORROWED);

        BookRepositor bookRepositor = new BookRepositor();
        MagazineRepository magazineRepository = new MagazineRepository();
        bookRepositor.add(book1);
        bookRepositor.add(book2);
        magazineRepository.add(magazine1);
        magazineRepository.add(magazine2);
        


    }
}
