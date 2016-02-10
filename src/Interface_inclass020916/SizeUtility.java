package Interface_inclass020916;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Feb 9, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 * 
 * This file was origionally named SizeUtility.java.
 *
 *
 */
public class SizeUtility {
    private static String str;

    public SizeUtility() {
    }
    
    public static String getSizeDescription(Object o) throws UnsizedException{
        if ((o instanceof String) || (o instanceof StringBuffer)){
            str = (String)o;
            return Integer.toString(str.length())+" Characters";
        } else if (o instanceof Sized){
            Sized temp = (Sized)o;
            str = temp.getSize();
        } else{
            throw new UnsizedException();
        }
        return str;
    }

}
