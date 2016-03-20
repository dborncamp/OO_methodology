package Assignment4;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Mar 20, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 *
 * Ebook factory class.
 * 
 */

    public class eBookFactory extends BookFactory {
        int current;
        boolean itemType;

        eBookFactory(){
            this.current = 0;
        }
        
    /**
     * Iterates over the list to determine if there is another book to give
     * 
     * @return True if there is another element in the list that is an ebook.
     */
    @Override
        public boolean hasNext() {
            // This works but is certainly not the correct way to do things...
            try{
                while(true){
                    Book temp = (Book) books.get(current);
                    //System.out.println("hasnext: "+temp.getCatagory()+ " "+current);
                    if (temp.isFiction() == itemType && (temp.getMedium().equals("ebook") || temp.getMedium().equals("both")) ){
                        //System.out.println(current);
                        return (books.get(current) !=null);
                    } else{
                        current +=1;
                    }
                }
            } catch (Exception e){
                return false;
            }
        }
        
        @Override
        public Book getFiction() {
            this.itemType = BookFactory.FICTION;
            Book temp = null;
            while (hasNext()){
                temp = (Book) books.get(current);
                if (temp.isFiction() == itemType &&  (temp.getMedium().equals("ebook") || temp.getMedium().equals("both")) ){
                    current +=1;
                    return temp;
                    //break;
                }
            }
            return null;
        }

        @Override
        public Book getNonFiction() {
            this.itemType = BookFactory.NONFICTION;
            Book temp = null;
            while (hasNext()){
                temp = (Book) books.get(current);
                if (temp.isFiction() == itemType && (temp.getMedium().equals("ebook") || temp.getMedium().equals("both")) ){
                    current +=1;
                    return temp;
                    //break;
                }
            }
            return null;
        }
    }
