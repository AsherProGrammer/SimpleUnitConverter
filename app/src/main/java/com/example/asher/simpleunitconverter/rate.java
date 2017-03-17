package com.example.asher.simpleunitconverter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

public class rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
    }

    public void send(View v){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        String[] TO = {getString(R.string.myemail)};
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.app_name) + " Feedback: " + ((RatingBar) (findViewById(R.id.ratingBar))).getRating());
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,  ((EditText) (findViewById(R.id.editText))).getText().toString());
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        finish();
    }
}
