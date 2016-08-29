package troy.com.youparking;

import java.sql.Timestamp;

/**
 * Created by acous on 8/28/2016.
 */
public class User {

    private String fName, lName;

    public User(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;

        printUser();
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    private void printUser() {
        System.out.println(fName + " " + lName);
    }

}
