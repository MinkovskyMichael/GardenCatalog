package com.app.gardencatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GardenDetail extends AppCompatActivity {

    ImageView mainImageView;
    int img;
    TextView title;
    View v;

//   Fragment fragFront;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden_detail);

        GetElemets();
        SetItemsInvisible();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.card_rotate);
        anim.setRepeatCount(10);
        anim.setRepeatMode(Animation.REVERSE);



        getData();
        setData();

        AnimationHelper(anim);

        mainImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainImageView.startAnimation(anim);
            }
        });
    }

    private void AnimationHelper(Animation anim) {
        anim.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation anim){
            }

            @Override
            public void onAnimationEnd(Animation anim){
                SetItemsForBackView();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }


        });
    }

    private void GetElemets() {
        mainImageView = findViewById(R.id.imageViewFront);
        title = findViewById(R.id.seedName);
        v=findViewById(R.id.detailView);
    }


    private void getData(){
        if(getIntent().hasExtra("myImage")){
            img = getIntent().getIntExtra("myImage", 1);
        }
        else{
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        mainImageView.setImageResource(img);

    }
    private void SetItemsInvisible() {
        title.setVisibility(View.INVISIBLE);
    }


    private void SetItemsForBackView(){
          title.setVisibility(View.VISIBLE);
          title.setText("RADISH"+"\n"+"Watermelon");
          mainImageView.setVisibility(View.INVISIBLE);
          v.setBackgroundColor(Color.parseColor("#f5f5f5"));
    }


}