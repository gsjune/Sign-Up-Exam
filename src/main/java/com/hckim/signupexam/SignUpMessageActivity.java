package com.hckim.signupexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SignUpMessageActivity extends AppCompatActivity {

    private TextView mMessageTextView; // C(2) Xml TextView id 부여 후

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_message);

        mMessageTextView = (TextView) findViewById(R.id.message_text); // C(3)

        Intent intent = getIntent(); // C(1) getIntent() 계속 써야 하니까 변수에다 받음
        if (intent != null) {
            String id = intent.getStringExtra("id");
            String password = intent.getStringExtra("password");
            String email = intent.getStringExtra("email");
            String gender = intent.getStringExtra("gender");

            mMessageTextView.setText("아이디 : " + id + "\n" + "비밀번호 : " + password + "\n"
                    + "이메일 : " + email + "\t" + "성별 : " + gender ); // C(4)
        }
    }

    public void confirm(View view) { // C(5) Xml onClick 후
        setResult(RESULT_OK); // C(6) 보내는 거면 Intent까지 필요함. 여기서는 해당 없는 것으로 처리
        finish();
    }
}
