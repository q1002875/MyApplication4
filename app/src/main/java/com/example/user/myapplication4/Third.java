package com.example.user.myapplication4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Third extends AppCompatActivity {

    static  String size;
    static String amount;
    static String money;
ArrayList<String> data=new ArrayList<>();
   static FirebaseDatabase firebaseDatabase;
    static DatabaseReference table_user;
    private TextView mTextMessage;
    Button button;
    ImageView image;
    public ListView mListView;
    static MyAdapter mAdapter;
    private ImageView img;
    int namefolder=1;
   TextView text;
   static String height;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent i = new Intent(Third.this, First.class);

                    startActivity(i);
                    return true;
                case R.id.navigation_dashboard:
                    Intent ia = new Intent(Third.this, Second.class);

                    startActivity(ia);
                    return true;
                case R.id.navigation_notifications:
                    Intent ic = new Intent(Third.this, Third.class);

                    startActivity(ic);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getWindow().setWindowAnimations(0);
        mTextMessage = (TextView) findViewById(R.id.message);
        mListView = findViewById(R.id.list);

        Toast.makeText(Third.this,"333333",Toast.LENGTH_SHORT).show();

        mAdapter = new MyAdapter();
        mListView.setAdapter(mAdapter);
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(Third.this)
                        .setTitle("是否刪除項目?")
                        .setMessage("第" + (position+1)+ "項商品")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mAdapter.removeItem(position);
                                mAdapter.notifyDataSetChanged();
//                                加入刪除沙箱裡的資料
                            }
                        })
                        .setNegativeButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.print("height="+11111);
                            }
                        })
                        .show();

                return false;
            }
        });
//控制不被消掉
        SharedPreferences settings = getSharedPreferences(null,0);
        String name=settings.getString("第一雙", "");
        String name2=settings.getString("第二雙", "");
            if(name.equals("111"))
        { mAdapter.addItem(mAdapter.getCount() + 1);
            mAdapter.notifyDataSetChanged();

        }

            else{}



//控制傳值來新增列表
try {
    Bundle bundle = getIntent().getExtras();
    height = bundle.getString("KEY_HEIGHT");
    Log.i("Height", "height" + height);
    Toast.makeText(Third.this,"height="+height,Toast.LENGTH_SHORT).show();


    switch (height){
        case "123":
            if(!name.equals("111")) {
                Toast.makeText(Third.this, "5555555", Toast.LENGTH_SHORT).show();
                mAdapter.addItem(mAdapter.getCount() + 1);
                mAdapter.notifyDataSetChanged(); }
        case "456":

            mAdapter.addItem(mAdapter.getCount() + 1);
            mAdapter.notifyDataSetChanged();

            mAdapter.addItem(mAdapter.getCount() + 1);
            mAdapter.notifyDataSetChanged();

    }




}catch (Exception e){}







        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            }



//            Bundle extras = getIntent().getExtras();
//            byte[] byteArray = extras.getByteArray("picture");
//            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//            image = (ImageView) findViewById(R.id.imageView2);
//            image.setImageBitmap(bmp);



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.

//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        switch (id) {
//            case R.id.navigation_home:
//                getWindow().setWindowAnimations(0);
//                Intent in = new Intent(Third.this, First.class);
//
//                startActivity(in);
//                return true;
//            case R.id.navigation_dashboard:
//
//                Intent intent = new Intent(Third.this, Second.class);
//
//                startActivity(intent);
//                return true;
//            case R.id.navigation_notifications:
//                Intent i = new Intent(Third.this, Second.class);
//
//                startActivity(i);
//            case R.id.action_settings:
//                Intent iE = new Intent(Third.this, Third.class);
//                startActivity(iE);
//
//
//
//
//                return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//
//    }


   public class MyAdapter extends BaseAdapter {
        private ArrayList<Integer> mList;

        public MyAdapter(){
            mList = new ArrayList<>();
        }

        public void addItem(Integer i){
            mList.add(i);
        }

        public void removeItem(int index){
            mList.remove(index);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {




            return mList [position];
        }



        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            Holder holder;
            if (v == null) {
                v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_item, null);
                holder = new Holder();
                holder.text = (TextView) v.findViewById(R.id.text);

                v.setTag(holder);
            } else {
                holder = (Holder) v.getTag();
            }
            SharedPreferences settings = getSharedPreferences(null, 0);
            Bundle bundle = getIntent().getExtras();
            String shoes = settings.getString("第一雙", "");
            String shoes2 = settings.getString("鞋子", "");
            String name2 = settings.getString("第二鞋子", "");
            String name = settings.getString("第二雙", "");

//            集合放進去
            try {
                height = bundle.getString("KEY_HEIGHT");

//判定傳來的值是哪個決定文社要設定哪個
                if (height.equals("123"))
                    position=0;
                else if (height.equals("456"))
                    position=1;
            }catch (Exception e){}
            switch(position) {
                case 0:
                    holder.text.setText(shoes2);
                    break;
                case 1:
                    holder.text.setText(name2);
                    break;
            }





            return v;

        }
        class Holder{
            TextView text;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, Menu.FIRST, 0, "add item");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case Menu.FIRST://add item
                mAdapter.addItem(mAdapter.getCount() + 1);
                mAdapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
