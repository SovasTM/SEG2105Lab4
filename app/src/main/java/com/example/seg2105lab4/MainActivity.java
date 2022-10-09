package com.example.seg2105lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnOpenInGoogleMaps (View view){
        EditText teamAddress = (EditText) findViewById(R.id.teamAddressField);

        Uri gmmIntentUri = Uri.parse("https://maps.google.com/maps?q="+teamAddress.getText());

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

    public void OnSetAvatarButton(View view){
        // ProfileActivity is the name of the second activity! Though you don't have it yet, it'll change from red when you add it
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        //Deprecated method? (i.e. disabled b/c buggy). Ask TA for updated method
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;
        //Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView)
                findViewById(R.id.avatarImage);
        //Figuring out the correct image
        String drawableName = "ic_logo_00";
        int imageResource = getResources().getIdentifier("@drawable/"+ drawableName, null, getPackageName());
        avatarImage.setImageDrawable(getDrawable(imageResource));
        switch (data.getIntExtra("imageID", R.id.avatarImage)) {
            case R.id.avatarImage:
                drawableName =
                        "avatarImage";
                break;
            case R.id.team1Image:
                drawableName =
                        "team1Image";
                break;
            case R.id.team2Image:
                drawableName =
                        "team2Image";
                break;
            case R.id.team3Image:
                drawableName =
                        "team3Image";
                break;
            case R.id.team4Image:
                drawableName =
                        "team4Image";
                break;
            case R.id.team5Image:
                drawableName =
                        "team5Image";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
    }
}