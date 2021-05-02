package com.example.cityguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

//(005)adapter class to recycler view
public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {
    //(005)make Array list that hold featured helper class variable
    ArrayList<FeaturedHelpeClass> featuredlocation;

    //(005)creat aconstructor of Array list varaible


    public FeaturedAdapter(ArrayList<FeaturedHelpeClass> featuredlocation) {
        this.featuredlocation = featuredlocation;
    }



    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      //(005) this method is link between FeaturedViewHolder and layout
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);
        FeaturedViewHolder featuredViewHolder=new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

         FeaturedHelpeClass featuredHelpeClass=featuredlocation.get(position);

        holder.image.setImageResource(featuredHelpeClass.getImage());
        holder.title.setText(featuredHelpeClass.getTitle());
        holder.desc.setText(featuredHelpeClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return featuredlocation.size();
    }


    //(005 create this class to deal with recycler view holderin layout)
    public static class  FeaturedViewHolder extends RecyclerView.ViewHolder {
      //(005)variables which deal with layout
       ImageView image;
       TextView title,desc;

       public FeaturedViewHolder(@NonNull View itemView) {
           super(itemView);

           // (005)layout inflater
           image=itemView.findViewById(R.id.featured_image);
           title=itemView.findViewById(R.id.featured_title);
           desc=itemView.findViewById(R.id.featured_desc);
       }
   }
}
