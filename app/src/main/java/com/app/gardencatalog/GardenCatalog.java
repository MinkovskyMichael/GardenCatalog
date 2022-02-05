package com.app.gardencatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GardenCatalog extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = { R.drawable.tomatoyellowpearfront,R.drawable.basilgenoveseface, R.drawable.watermelonradishfront};
    ImageView img;
    View frostView;
    Dialog frDialog;
    TextView gArea, spFrost, flFrost;
    String growArea ="7B", springFrost="April 12", fallFrost="October 24";
    Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden_catalog);

        recyclerView = findViewById(R.id.gardenCatalogView);
        img = findViewById(R.id.frostdata);

        frDialog = new Dialog(this);

        s1 = getResources().getStringArray(R.array.seed_names);
        s2 = getResources().getStringArray(R.array.description);

        ViewAdapter myAdapter = new ViewAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager((new LinearLayoutManager(this )));

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frDialog.setContentView(R.layout.frostpopup);
                frDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                fillDialog(frDialog);
                frDialog.show();
            }
        });
    }

    private void fillDialog(Dialog frDialog) {
        //Grow area
        gArea = frDialog.findViewById(R.id.GrowAreaTxt);
        gArea.setText(growArea);

        //Last Spring Frost
        spFrost = frDialog.findViewById(R.id.LastSpringFrosttxt);
        spFrost.setText(springFrost);

        //First Fall Frost
        flFrost = frDialog.findViewById(R.id.FirstFallFrosttxt);
        flFrost.setText(fallFrost);

        //close button
        btnClose = frDialog.findViewById(R.id.closeDiag);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frDialog.setContentView(R.layout.frostpopup);
                frDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                frDialog.hide();
            }
        });
    }

}