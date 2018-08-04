package com.example.user.myapplication4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{

private Context mcomtext;

private  Integer[] mthumbids={R.drawable.shoes1_1,R.drawable.shoes1_2,
        R.drawable.shoes1_3,R.drawable.som1_1,R.drawable.som1_2,R.drawable.sow1_1,
        R.drawable.sow1_2,R.drawable.sow1_3,R.drawable.spm1_3};

public ImageAdapter(Context context) {mcomtext=context;}



//注意回傳長度
    @Override
    public int getCount() { return mthumbids.length; }

    @Override
    public Object getItem(int position) { return null; }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ImageView imageView;

        imageView=new ImageView(mcomtext);
//設定圖片長寬
        imageView.setLayoutParams(new AbsListView.LayoutParams(1000,1000));
//設定圖片為全銀幕
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);


//        設定圖片與圖片間距
        imageView.setPadding(8,20,8,20);

        imageView.setImageResource(mthumbids[position]);

        return imageView;
    }
}
