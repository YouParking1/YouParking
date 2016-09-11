package troy.com.youparking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class HoldSpot extends AppCompatActivity {
    TextView coords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hold_spot);

        coords = (TextView) findViewById(R.id.showCoords);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            coords.setText(extras.getString("mLat") + " " + extras.getString("mLong"));
        }
    }
}
