package com.app.gardencatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class SeedDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seed_details);

        SetItemsInvisible();

    }

    private void SetItemsInvisible() {
    }

    private void SetItemsForBackView(){
      //  title.setVisibility(View.VISIBLE);
       // title.setText("RADISH"+"\n"+"watermelon");
       // mainImageView.setVisibility((View.INVISIBLE));
       // view.setBackgroundColor(Color.parseColor("#f5f5f5"));

    }
}