package Assignment4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Mar 14, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 *
 */
public abstract class BookFactory {
    private int idx;
    protected static LinkedList books = new LinkedList();
    public static final boolean FICTION = true;
    public static final boolean NONFICTION = false;
    public static final String EBOOK = "ebook";
    public static final String PHYSICAL = "physical";
//  s  public static final boolean FICTION = true;
//    public static final boolean NON_FICTION = false;
    
    // Methods that need to be implemented
    public abstract Book getFiction();
    public abstract Book getNonFiction();
    public abstract boolean hasNext();
    
    /**
     *  Get a factory for the given type of book
     * 
     * @param type - BookFactory.EBOOK or BookFactory.PHYSICAL
     * @return - a BookFactory that will iterate over those types of books.
     * @throws IllegalArgumentException
     */
    public static BookFactory getBookFactory(String type) throws IllegalArgumentException{
        switch (type) {
            case BookFactory.EBOOK:
                return new eBookFactory();
            case BookFactory.PHYSICAL:
                return new PhysicalBookFactory();
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public BookFactory(){
        idx = 0;
    }
    
    public static void addBook(String title, boolean fiction, String medium){
        books.add(new Book(title, fiction, medium));
    }
    
    public static void addBook(Book b){
        books.add(b);
    }
    
    public Book getBook(){
        Book book = (Book)books.get(idx);
        return book;
    }
}