package org.androidtown.dumdumtest1;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 2018-01-18.
 */

public class InfiniteCycleViewAdapter extends PagerAdapter{


    List<Integer> lstImages;
    Context context;
    LayoutInflater layoutInflater;

    // Animation FRONT, BACK;

    public InfiniteCycleViewAdapter(List<Integer> lstImages, Context context) {
        this.lstImages = lstImages;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lstImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.infinitecycleview_item,container,false);
        TextView textView = (TextView) view.findViewById( R.id.textView);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);


        imageView.setImageResource(lstImages.get(position));
        container.addView(view);
        return view;
    }
}
