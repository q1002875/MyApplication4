package com.example.user.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication4.shoes.shoes1_1;
import com.example.user.myapplication4.shoes.shoes1_2;
import com.example.user.myapplication4.shoes.shoes1_3;
import com.example.user.myapplication4.shoes.som1_1;
import com.example.user.myapplication4.shoes.som1_2;
import com.example.user.myapplication4.shoes.sow1_1;
import com.example.user.myapplication4.shoes.sow1_2;
import com.example.user.myapplication4.shoes.sow1_3;
import com.example.user.myapplication4.shoes.spm1_3;

public class First extends AppCompatActivity {
    private ImageButton imageView1;
    private ImageButton imageView2;
    private ImageButton imageView3;
    private ImageButton imageView4;
    private ImageButton imageView5;
    private ImageButton imageView6;
    private ImageButton imageView7;
    private ImageButton imageView8;
    private ImageButton imageView9;

    private TextView mTextMessage;
     TextView textView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getWindow().setWindowAnimations(0);
                    Intent in = new Intent(First.this, First.class);

                    startActivity(in);
                    return true;
                case R.id.navigation_dashboard:

                    Intent intent = new Intent(First.this, Second.class);

                    startActivity(intent);
                    return true;
                case R.id.navigation_notifications:
                    Intent i = new Intent(First.this, Third.class);

                    startActivity(i);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Toast.makeText(this,"111111",Toast.LENGTH_SHORT).show();
        textView=findViewById(R.id.tv);
        textView.setSelected(true);
        getWindow().setWindowAnimations(0);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


//        找出imagebutton
        findviews();

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(First.this,shoes1_1.class);
                startActivity(intent);
                Toast.makeText(First.this,"2222",Toast.LENGTH_SHORT).show();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(First.this,shoes1_2.class);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(First.this,shoes1_3.class);
                startActivity(intent);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(First.this,som1_1.class);
                startActivity(intent);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(First.this,som1_2.class);
                startActivity(intent);
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(First.this,sow1_1.class);
                startActivity(intent);
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(First.this,sow1_2.class);
                startActivity(intent);
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(First.this,sow1_3.class);
                startActivity(intent);
            }
        });
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(First.this,spm1_3.class);
                startActivity(intent);
            }
        });



    }



    void findviews(){
        imageView1=findViewById(R.id.imageButton1);
        imageView2=findViewById(R.id.imageButton2);
        imageView3=findViewById(R.id.imageButton3);
        imageView4=findViewById(R.id.imageButton4);
        imageView5=findViewById(R.id.imageButton5);
        imageView6=findViewById(R.id.imageButton6);
        imageView7=findViewById(R.id.imageButton7);
        imageView8=findViewById(R.id.imageButton8);
        imageView9=findViewById(R.id.imageButton9);

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
                Intent in = new Intent(First.this, First.class);

                startActivity(in);
                return true;
            case R.id.navigation_dashboard:

                Intent intent = new Intent(First.this, Second.class);

                startActivity(intent);
                return true;
            case R.id.navigation_notifications:
                Intent i = new Intent(First.this, Third.class);

                startActivity(i);
            case R.id.action_settings:
                Intent iE = new Intent(First.this, Third.class);
                startActivity(iE);




            return true;
        }

        return super.onOptionsItemSelected(item);

    }




}
