package com.example.user.myapplication4;

import android.content.Intent;
import android.support.annotation.NonNull;
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

public class SignUp extends AppCompatActivity {

    EditText editText1,editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgin_up);

        editText1=findViewById(R.id.editText4);
        editText2=findViewById(R.id.editText5);
        button=findViewById(R.id.button99);



        button.setOnClickListener(new View.OnClickListener() {
            final FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
            final DatabaseReference table_user=firebaseDatabase.getReference("User");
            @Override
            public void onClick(View v) {

                if (editText1.getText().toString().equals("")||(editText2.getText().toString().equals(""))){
                    Toast.makeText(SignUp.this,"欄位不可空白",Toast.LENGTH_SHORT).show();
                }else {
                    table_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        如果帳號跟firebase的帳號一樣則顯示已有此帳號
                            if (dataSnapshot.child(editText1.getText().toString()).exists()) {

                                Toast.makeText(SignUp.this, "此帳號已被註冊", Toast.LENGTH_SHORT).show();
                            } else {

                                User user = new User(editText1.getText().toString(), editText2.getText().toString());
                                table_user.child(editText1.getText().toString()).setValue(user);

                                Toast.makeText(SignUp.this, "註冊成功", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUp.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }


            }
        });
    }


}
