package troy.com.youparking;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tickets, spots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.icons), iconFont);

        tickets = (TextView)findViewById(R.id.numTickets);
        spots = (TextView)findViewById(R.id.spotsAvailable);

        /* TODO: Travis Clinkscales - Go to database and grab the number of spots that are available and number of tickets the user owns */
    }

    public void openMyMap(View view) {
        Intent intent = new Intent(this, GeneralMap.class);
        startActivity(intent);
    }
}
