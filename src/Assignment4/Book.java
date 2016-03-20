package Assignment4;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Mar 14, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 * Book Object to make factory of.
 * 
 * 3/20/16
 * Changed the implementation of this because I now see that books can be either ebook or physical,
 * and that does not change the properties of the book itself. The book is still fiction/nonfiction but can be
 * presented in either medium or both and it is still the same book.
 */
public class Book {
    private final String title;
    private final Boolean fiction;
    private final String medium;
    
    /**
     * Enum class for the allowed types of mediums that books can be on. They can be available on either
     * physical, ebook or both. This also includes a tester to see if a string is equal to one of the acceptable
     * types.
     */
    enum mediumType {
       PHYSICAL, EBOOK, BOTH;

       // Test that a string is equal to the allowed enum types by looping over them.
      public static boolean contains(String s){
          for(mediumType med:values())
               if (med.name().equals(s)) 
                  return true;
          return false;
      } 
    };
    
    /**
     * Book constructor. To make a book, you need a title, if it is fiction or not and the medium it is available
     * on.
     * 
     * @param title - title of the book
     * @param fiction - True for fiction, false for non-fiction
     * @param medium - The medium that the book is available on
     */
    public Book(String title, Boolean fiction, String medium){
        this.title = title;
        this.fiction = fiction;
        if (mediumType.contains(medium.toUpperCase())){
            this.medium = medium.toLowerCase();
        } else {
            throw new IllegalArgumentException("Not an allowed medium. Please enter physical, ebook or both");
        }
    }

    /**
     *  Will return if book is fiction.
     * 
     * @return True if book is fiction.
     */
    public boolean isFiction() {
        return this.fiction;
    }
    
    /**
     *  Will return the medium that the book is available on. Could be physical, ebook or both.
     * 
     * @return the medium that the book is on
     */
    public String getMedium(){
        return medium;
    }
    
    @Override
    public String toString(){
        String middle = "non-";
        if (isFiction()){
            middle = "";
        }
        return title + " is a " + middle + "fiction book on " + medium;
    }

}
