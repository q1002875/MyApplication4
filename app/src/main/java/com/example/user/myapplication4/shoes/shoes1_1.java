package com.example.user.myapplication4.shoes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication4.Dialog;
import com.example.user.myapplication4.First;
import com.example.user.myapplication4.LoginActivity;
import com.example.user.myapplication4.MyPagerAdapter;
import com.example.user.myapplication4.R;
import com.example.user.myapplication4.Second;
import com.example.user.myapplication4.SignUp;
import com.example.user.myapplication4.Third;
import com.example.user.myapplication4.UpCart;
import com.example.user.myapplication4.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class shoes1_1 extends AppCompatActivity {
    Spinner sp1;
    Spinner sp2;
    ImageView imageView;
    String ShoesName = "休閒鞋";
    public int size2;
    public String size;
    public String amount;
    public int amount2;
    public TextView textView;
    public String Money;

    String UpCart;
    ViewPager viewPager;
    //    抓取viewpage建立的類別來宣告
    MyPagerAdapter myPagerAdapter;

    // 在專案內放的測試圖
    private static final int[] pictures = {R.drawable.shoes1_1,
            R.drawable.shoes1_1_2, R.drawable.shoes1_1_3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setWindowAnimations(0);
        setContentView(R.layout.activity_shoes1_1);

        sp1 = findViewById(R.id.spinner);
        sp2 = findViewById(R.id.spinner2);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.result);
        viewPager = findViewById(R.id.pg);


//Viewpage跑圖
        List<Integer> list = new ArrayList<Integer>();
        for (int i : pictures) {
            list.add(i);
        }
//宣告玩得viewpage把list帶入使用
        myPagerAdapter = new MyPagerAdapter(this, list);
//      抓取xml的ui元件設定
        viewPager.setAdapter(myPagerAdapter);

//      spinner陣列
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.shoes_size, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //          一進畫面會顯示第一個所以沒加boolean會直接顯示toast
            boolean isfirsttime = true;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                size2 = position;
                switch (position) {
                    case 1:
                        size = "23.5";
                        break;
                    case 2:
                        size = "24";
                        break;
                    case 3:
                        size = "24.5";
                        break;
                    case 4:
                        size = "25";
                        break;
                    case 5:
                        size = "25.5";
                        break;
                }


                if (!isfirsttime) {
//          isfirsttime=flase才會顯示toast
//          只寫THIS會被當成LISTENER的內部類別所以要填MainActivity.this才是主要類別
                    Toast.makeText(shoes1_1.this, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
//          isfirsttime會先進到else變成false不會顯示toast
                } else
                    isfirsttime = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        sp1.setAdapter(adapter);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.amount, android.R.layout.simple_list_item_1);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //          一進畫面會顯示第一個所以沒加boolean會直接顯示toast
            boolean isfirsttime = true;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                價錢計算
                textView.setText(position * 100 + "");

                Money = (position * 100 + "");

                amount = position + "";
                amount2 = position;
                if (!isfirsttime) {
//          isfirsttime=flase才會顯示toast
//          只寫THIS會被當成LISTENER的內部類別所以要填MainActivity.this才是主要類別
                    Toast.makeText(shoes1_1.this, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
//            isfirsttime會先進到else變成false不會顯示toast
                } else
                    isfirsttime = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp2.setAdapter(adapter2);


    }


    public void buy(View v) {
        if (size2 == 0) {
            Toast.makeText(this, "請選擇尺寸", Toast.LENGTH_SHORT).show();

        } else {
            if (amount2 == 0)
                Toast.makeText(this, "請選擇購買的數量", Toast.LENGTH_SHORT).show();
            else {

                SharedPreferences settings = getSharedPreferences(null, 0);


                settings.edit()
                        .putString("第一雙","111")
                        .putString("鞋子","休閒鞋"+Money+"元"+size+"吋"+amount+"雙")
                        .commit();

                Toast.makeText(shoes1_1.this, "已放置購物車", Toast.LENGTH_SHORT).show();

//船圖片
//                           Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.shoes1_1);
//                           ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                           bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                           byte[] byteArray = stream.toByteArray();
//
//                           Intent intentt = new Intent(shoes1_1.this, Third.class);
//                           intentt.putExtra("picture", byteArray);
//                           startActivity(intentt);

                Intent  intent = new Intent(shoes1_1.this,Third.class);
                Bundle bundle = new Bundle();
                bundle.putString("KEY_HEIGHT","123");

                intent.putExtras(bundle);

                startActivity(intent);

//                Intent intentT = new Intent(shoes1_1.this, First.class);
//                startActivity(intentT);

            }

        }


//                   建立沙箱資料傳送至購物車
//                   OpenDialog();

    }


    public void OpenDialog() {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "Dialog");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.navigation_home:
                getWindow().setWindowAnimations(0);
                Intent in = new Intent(shoes1_1.this, First.class);

                startActivity(in);
                return true;
            case R.id.navigation_dashboard:

                Intent intent = new Intent(shoes1_1.this, Second.class);

                startActivity(intent);
                return true;
            case R.id.navigation_notifications:
                Intent i = new Intent(shoes1_1.this, Third.class);

                startActivity(i);
            case R.id.action_settings:
                Intent iE = new Intent(shoes1_1.this, Third.class);
                startActivity(iE);


                return true;
        }

        return super.onOptionsItemSelected(item);

    }
}
