package com.app.gardencatalog;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public ViewAdapter(Context ct, String s1[], String s2[], int img[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        images=img;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
           holder.tx1.setText(data1[position]);
        holder.tx2.setText(data2[position]);
        holder.imgV.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GardenDetail.class);
                intent.putExtra("myImage", images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tx1, tx2;
        ImageView imgV;
        ConstraintLayout mainLayout;

     public ViewHolder(@NonNull View itemView){
         super(itemView);
         tx1 = itemView.findViewById(R.id.textName);
         tx2 = itemView.findViewById(R.id.textDescription);
         imgV = itemView.findViewById(R.id.plantView);
         mainLayout = itemView.findViewById((R.id.mainLayout));
     }
    }
}
