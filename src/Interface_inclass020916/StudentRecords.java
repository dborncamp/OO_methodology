package Interface_inclass020916;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Feb 9, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 * 
 * This file was origionally named StudentRecords.java.
 *
 *
 */
public class StudentRecords implements Sized{

    private int records;
    public StudentRecords(int num) {
        records = num;
    }

    @Override
    public String getSize() {
        return Integer.toString(records) + " Records";
    }
    
}
