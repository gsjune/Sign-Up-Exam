package com.hckim.signupexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        
        findViewById(R.id.conform_button).setOnClickListener(this);

        if (getIntent() != null) {
            String id = getIntent().getStringExtra("id");
            String password = getIntent().getStringExtra("password");
            String email = getIntent().getStringExtra("email");

            Toast.makeText(this, "회원가입을 축하합니다!" + "\n" + "아이디 : " + id + "\n" + "비밀번호 : " + password +
                    "\n" + "이메일 : " + email + "\t" + "성별 : ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "모두 입력해 주셔야 합니다", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        
    }
}
