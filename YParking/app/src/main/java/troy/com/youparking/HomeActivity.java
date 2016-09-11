package troy.com.youparking;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.internal.NavigationMenu;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tickets, spots;
    ImageView imageView;
    RoundImage roundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //rounding the image for profile picture
        imageView = (ImageView)findViewById(R.id.profilePic);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_profile_pic);
        roundImage = new RoundImage(bitmap);
        imageView.setImageDrawable(roundImage);


        tickets = (TextView)findViewById(R.id.numTickets);
        spots = (TextView)findViewById(R.id.spotsAvailable);

        /* TODO: Travis Clinkscales - Go to database and grab the number of spots that are available and number of tickets the user owns */
    }

    public void openMyMap(View view) {
        Intent intent = new Intent(this, GeneralMap.class);
        startActivity(intent);
    }

    public void goToNav(View view)
    {
        Intent intent = new Intent(this, troy.com.youparking.NavigationMenu.class);
        startActivity(intent);
    }
}
