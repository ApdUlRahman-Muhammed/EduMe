package com.example.mohamed.gradpro;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {

        this.context = context;
    }

    //////////// Arrays ///////////

    public int[] slider_image = {
            R.drawable.group10,
            R.drawable.group11,
            R.drawable.group12,
            R.drawable.group11
    };
    public String[] slider_title = {
            "title1",
            "title2",
            "title3",
            "title4"
    };
    public String[] slider_desc = {
            "Description1",
            "Description2",
            "Description",
            "Description4"
    };

    @Override
    public int getCount() {
        return slider_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider1, container, false);

        ImageView s_image=view.findViewById(R.id.s_img);
        TextView s_title = view.findViewById(R.id.s_tit);
        TextView s_desc = view.findViewById(R.id.s_desc);

        s_image.setImageResource(slider_image[position]);
        s_title.setText(slider_title[position]);
        s_desc.setText(slider_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
