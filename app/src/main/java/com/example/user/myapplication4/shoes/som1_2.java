package com.example.user.myapplication4.shoes;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication4.R;

public class som1_2 extends AppCompatActivity {
    Spinner sp1;
    Spinner sp2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_som1_2);
        sp1 = findViewById(R.id.spinner);
        sp2 = findViewById(R.id.spinner2);
        imageView = findViewById(R.id.imageView);
        getWindow().setWindowAnimations(0);
        playFrameAnimation();
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.shoes_size, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //          一進畫面會顯示第一個所以沒加boolean會直接顯示toast
            boolean isfirsttime = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!isfirsttime) {
//          isfirsttime=flase才會顯示toast
//          只寫THIS會被當成LISTENER的內部類別所以要填MainActivity.this才是主要類別
                    Toast.makeText(som1_2.this, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
//            isfirsttime會先進到else變成false不會顯示toast
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
                if (!isfirsttime) {
//          isfirsttime=flase才會顯示toast
//          只寫THIS會被當成LISTENER的內部類別所以要填MainActivity.this才是主要類別
                    Toast.makeText(som1_2.this, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
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


//將購買資料傳入
        public void buy (View v){

        }
//購買頁面的動畫
        private void playFrameAnimation(){
            imageView.setBackgroundResource(R.drawable.som1_2anim);
        AnimationDrawable anim = (AnimationDrawable)imageView.getBackground();
        anim.start();
    }
    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }
    }
