package Interface_inclass020916;

/**
 *
 * @author Dave Borncamp <dbornc1@students.towson.edu>
 * @date Feb 9, 2016
 * 
 * Created for COSC 716 Spring 2016 at Towson University.
 * 
 * This file was origionally named SemesterSchedule.java.
 *
 *
 */
public class SemesterSchedule implements Sized{

    int credits;
    public SemesterSchedule(int cred) {
        credits = cred;
    }

    @Override
    public String getSize() {
        return Integer.toString(credits) + " credits";
    }

}
