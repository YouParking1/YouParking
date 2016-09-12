package troy.com.youparking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class HoldSpot extends AppCompatActivity implements AsyncResponse {
    TextView coords;
    double mLat, mLong;
    EditText comments;
    Spinner tickets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hold_spot);

        coords = (TextView) findViewById(R.id.showCoords);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mLat = extras.getDouble("mLat");
            mLong = extras.getDouble("mLong");
            coords.setText(extras.getDouble("mLat") + " " + extras.getDouble("mLong"));
        }
    }

    public void onHold(View view) {
        comments = (EditText)findViewById(R.id.comments);
        tickets = (Spinner)findViewById(R.id.spinner1);
        String comment = comments.getText().toString();
        String ticket = tickets.getSelectedItem().toString();
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.delegate = this;
        backgroundWorker.execute("hold", ticket, "1", Double.toString(mLat), Double.toString(mLong), comment);
    }

    @Override
    public void processFinish(String output) {

    }
    //
}
