package troy.com.youparking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText emailEt, passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEt = (EditText) findViewById(R.id.email);
        passwordEt = (EditText) findViewById(R.id.pass);
    }

    public void OnLogin(View view) {
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();
        String type = "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, email, password);
    }

}
