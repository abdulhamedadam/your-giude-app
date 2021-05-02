package com.example.cityguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>{
    ArrayList<CategoriesHelperclass> categories;

    public CategoriesAdapter(ArrayList<CategoriesHelperclass> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design,parent,false);
        CategoriesAdapter.CategoriesViewHolder categoriesViewHolder=new CategoriesAdapter.CategoriesViewHolder(view);
        return categoriesViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        CategoriesHelperclass categoriesHelperclass=categories.get(position);

        holder.image.setImageResource(categoriesHelperclass.getImage());
        holder.title.setText(categoriesHelperclass.getTitle());
        holder.background.setBackgroundResource(categoriesHelperclass.getBackground());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    public static class  CategoriesViewHolder extends RecyclerView.ViewHolder {
        //(005)variables which deal with layout
        ImageView image;
        TextView title;
        RelativeLayout background;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            // (005)layout inflater
            image=itemView.findViewById(R.id.cat_image);
            title=itemView.findViewById(R.id.cat_title);
            background=itemView.findViewById(R.id.cat_background);

        }
    }
}
