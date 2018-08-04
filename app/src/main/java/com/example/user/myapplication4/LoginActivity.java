package com.example.user.myapplication4;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
EditText editText1;
EditText editText2;
Button button;
Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1=findViewById(R.id.username);
        editText2=findViewById(R.id.password);
        button=findViewById(R.id.sign_in_button);
        button2=findViewById(R.id.sign_up_button);



        button.setOnClickListener(new View.OnClickListener() {
            FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
            final DatabaseReference table_user=firebaseDatabase.getReference("User");
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog=new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("請稍後");
                progressDialog.show();

                if (editText1.getText().toString().equals("") | editText2.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "欄位不可空白", Toast.LENGTH_SHORT).show();
                } else {

                    table_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {


                            if (dataSnapshot.child(editText1.getText().toString()).exists()) {
                                progressDialog.dismiss();
                                User user = dataSnapshot.child(editText1.getText().toString()).getValue(User.class);

                                if (user.getPassword().equals(editText2.getText().toString())) {
                                    Toast.makeText(LoginActivity.this, "成功登入", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(LoginActivity.this,First.class);
                                    startActivity(intent);
                                }
                                else
                                    Toast.makeText(LoginActivity.this, "密碼錯誤", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "沒這個帳號", Toast.LENGTH_SHORT).show();
                            }


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }

            }


        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignUp.class);
                startActivity(intent);
            }
        });
    }
//一切換頁面就回收資源
    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }
}
