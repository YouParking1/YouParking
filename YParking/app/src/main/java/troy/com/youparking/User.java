package troy.com.youparking;

import java.sql.Timestamp;

/**
 * Created by acous on 8/28/2016.
 */
public class User {

    private String fName, lName, email;

    public User(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() { return email; }

}
