package com.example.cityguide.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.cityguide.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.CategoriesHelperclass;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedHelpeClass;
import com.example.cityguide.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.example.cityguide.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {
    //(005)recyclervariable
    RecyclerView featuredrecycler,mostviewedrecycler,categoriesrecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);


        //(005 inflate recycler view)
        featuredrecycler=findViewById(R.id.featured_recycler);
        mostviewedrecycler=findViewById(R.id.mostviewedrecycler);
        categoriesrecycler=findViewById(R.id.categoriesrecycler);
        //(005)call this function
        featuredrecycler();
        mostviewedrecycler();
        categoriesrecycler();

    }

    private void categoriesrecycler() {
        GradientDrawable gradient=new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffeff400,0xffaff600});
        categoriesrecycler.setHasFixedSize(true);
        categoriesrecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<CategoriesHelperclass>categories=new ArrayList<>();
        categories.add(new CategoriesHelperclass(R.drawable.ic_restaurant,"Restaurant",R.drawable.card1));
        categories.add(new CategoriesHelperclass(R.drawable.ic_edu,"Education",R.drawable.card3));
        categories.add(new CategoriesHelperclass(R.drawable.ic_shopp,"Shops",R.drawable.card4));
        categories.add(new CategoriesHelperclass(R.drawable.ic_hot,"Hotels",R.drawable.card2));

        adapter=new CategoriesAdapter(categories);
        categoriesrecycler.setAdapter(adapter);

    }

    private void mostviewedrecycler() {
        mostviewedrecycler.setHasFixedSize(true);
        mostviewedrecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<MostViewedHelperClass>mostViewed=new ArrayList<>();
        mostViewed.add(new MostViewedHelperClass(R.drawable.sit_back_and_relax,"McDonals","fgfhgh sjhj eghuahbn lklk;l lklkll,cm jhjhjfllaFINXNT SFY"));
        mostViewed.add(new MostViewedHelperClass(R.drawable.search_place,"Edenrobe","fgfhgh sjhj eghuahbn lklk;l lklkll,cm jhjhjfllaFINXNT SFY"));
        mostViewed.add(new MostViewedHelperClass(R.drawable.add_missing_place,"Sweet","fgfhgh sjhj eghuahbn lklk;l lklkll,cm jhjhjfllaFINXNT SFY"));

        adapter=new MostViewedAdapter(mostViewed);
        mostviewedrecycler.setAdapter(adapter);
    }

    // (005 this function to deal with recycler view featured)
    private void featuredrecycler() {

    featuredrecycler.setHasFixedSize(true);
    featuredrecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelpeClass> featuredlocations=new ArrayList<>();
        featuredlocations.add(new FeaturedHelpeClass(R.drawable.sit_back_and_relax,"McDonals","fgfhgh sjhj eghuahbn lklk;l lklkll,cm jhjhjfllaFINXNT SFY"));
        featuredlocations.add(new FeaturedHelpeClass(R.drawable.search_place,"Edenrobe","fgfhgh sjhj eghuahbn lklk;l lklkll,cm jhjhjfllaFINXNT SFY"));
        featuredlocations.add(new FeaturedHelpeClass(R.drawable.add_missing_place,"Sweet and Bakers","fgfhgh sjhj eghuahbn lklk;l lklkll,cm jhjhjfllaFINXNT SFY"));

        adapter=new FeaturedAdapter(featuredlocations);
        featuredrecycler.setAdapter(adapter);

        GradientDrawable gradient=new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffeff400,0xffaff600});
        
    }
}