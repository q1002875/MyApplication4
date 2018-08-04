package com.example.user.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.myapplication4.shoes.shoes1_1;
import com.example.user.myapplication4.shoes.shoes1_2;
import com.example.user.myapplication4.shoes.shoes1_3;
import com.example.user.myapplication4.shoes.som1_1;
import com.example.user.myapplication4.shoes.som1_2;
import com.example.user.myapplication4.shoes.sow1_1;
import com.example.user.myapplication4.shoes.sow1_2;
import com.example.user.myapplication4.shoes.sow1_3;
import com.example.user.myapplication4.shoes.spm1_3;

public class Second extends AppCompatActivity {
    ListView listView;
    private TextView mTextMessage;
//切換頁面配置
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(Second.this, First.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_dashboard:
                    Intent inten = new Intent(Second.this, Second.class);
                    startActivity(inten);
                    return true;
                case R.id.navigation_notifications:
                    Intent inte = new Intent(Second.this, Third.class);
                    startActivity(inte);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getWindow().setWindowAnimations(0);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//設定LIST圖片
        listView=findViewById(R.id.list);

        listView.setAdapter(new ImageAdapter(Second.this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

switch(position){

    case 0:
        Intent intent=new Intent(Second.this,shoes1_1.class);
        startActivity(intent);
        break;

    case 1:
        Intent inten=new Intent(Second.this,shoes1_2.class);
        startActivity(inten);
        break;

    case 2:
        Intent inte=new Intent(Second.this,shoes1_3.class);
        startActivity(inte);
        break;

    case 3:
        Intent in=new Intent(Second.this,som1_1.class);
        startActivity(in);
        break;

    case 4:
        Intent i=new Intent(Second.this,som1_2.class);
        startActivity(i);
        break;

    case 5:
        Intent t=new Intent(Second.this,sow1_1.class);
        startActivity(t);
        break;

    case 6:
        Intent nt=new Intent(Second.this,sow1_2.class);
        startActivity(nt);
        break;

    case 7:
        Intent ent=new Intent(Second.this,sow1_3.class);
        startActivity(ent);
        break;

    case 8:
        Intent tent=new Intent(Second.this,spm1_3.class);
        startActivity(tent);
        break;


}


            }
        });


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
                Intent in = new Intent(Second.this, First.class);

                startActivity(in);
                return true;
            case R.id.navigation_dashboard:

                Intent intent = new Intent(Second.this,Second.class);

                startActivity(intent);
                return true;
            case R.id.navigation_notifications:
                Intent i = new Intent(Second.this, Third.class);

                startActivity(i);
            case R.id.action_settings:
                Intent iE = new Intent(Second.this, Third.class);
                startActivity(iE);




                return true;
        }

        return super.onOptionsItemSelected(item);

    }
    }