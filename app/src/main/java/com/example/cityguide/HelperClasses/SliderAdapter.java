package com.example.cityguide.HelperClasses;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.cityguide.R;

//1---frist extends pager adapter
public class SliderAdapter extends PagerAdapter {

    //2---vraibles (003)
    Context context;
    LayoutInflater layoutInflater;

    //3---generate constuctor

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //4---variables for images and text
    int images[]={

            R.drawable.search_place,
            R.drawable.make_a_call,
            R.drawable.add_missing_place,
            R.drawable.sit_back_and_relax
    };

    int headings[]={
            R.string.frist_slide_title,
            R.string.second_slide_title,
            R.string.third_slide_title,
            R.string.fourth_slide_title,

    };

    int discription[]={
      R.string.frist_slide_disc,
      R.string.second_slide_disc,
      R.string.third_slide_disc,
      R.string.fourth_slide_disc,

    };

    //(003) methed you should implement it to avoid error

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }


    //(003) implement this method to inflate layout

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slides_layout,container,false);


        ImageView imageView=view.findViewById(R.id.slider_image);
        TextView heading=view.findViewById(R.id.slider_txt);
        TextView disc=view.findViewById(R.id.slider_desc);


        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        disc.setText(discription[position]);

        container.addView(view);
        // return imageView;
      return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
