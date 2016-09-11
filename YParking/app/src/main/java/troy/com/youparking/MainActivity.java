package troy.com.youparking;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AsyncResponse {
    EditText emailEt, passwordEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEt = (EditText) findViewById(R.id.email);
        passwordEt = (EditText) findViewById(R.id.pass);
        TextView tvSignUp =(TextView) findViewById(R.id.tvSignUp);

        //listener for "SignUp!" to link to register page
       /* tvSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent RegisterIntent = new Intent (MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(RegisterIntent
                );
            }
        });*/
    }

    public void OnLogin(View view) {
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();
        String type = "login";

        if (email.toUpperCase().contains(".EDU") && email.contains("@")) {
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.delegate = this;
            backgroundWorker.execute(type, email, password);
        }
    }


    @Override
    public void processFinish(String output) {
        if (output.contains("success")) {
            User.email = emailEt.getText().toString();
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }
}
