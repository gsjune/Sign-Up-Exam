package com.hckim.signupexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpOhActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE = 1000;
    private EditText mIdEditText; // (3)
    private EditText mPasswordEditText;
    private EditText mPasswordConfirmEditText;
    private EditText mEmailEditText;
    private RadioGroup mGenderRadioGroup; // B(2) Xml id 생성 후

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_oh);

        mIdEditText = (EditText) findViewById(R.id.id_edit); // (4)
        mPasswordEditText = (EditText) findViewById(R.id.password_edit);
        mPasswordConfirmEditText = (EditText) findViewById(R.id.password_confirm_edit);
        mEmailEditText = (EditText) findViewById(R.id.id_edit);
        mGenderRadioGroup = (RadioGroup) findViewById(R.id.gender_group); // B(3)

        findViewById(R.id.reset_button).setOnClickListener(this); // (1)
        findViewById(R.id.sign_up_button).setOnClickListener(this); // (1)'
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) { // (2)
            case R.id.reset_button:
                break;
            case R.id.sign_up_button:
//                if (mIdEditText.getText().toString().equals("")) // 비었는지
//                if (TextUtils.isEmpty(mIdEditText.getText().toString()) || // (5) 이하 6줄
//                        TextUtils.isEmpty(mPasswordEditText.getText().toString()) ||
//                        TextUtils.isEmpty(mPasswordConfirmEditText.getText().toString()) ||
//                        TextUtils.isEmpty(mEmailEditText.getText().toString())) {
                if (isEditTextEmpty()) { // (7) (5)를 메소드화. 이름 바꿈
                    Toast.makeText(this, "모두 입력해 주셔야 합니다", Toast.LENGTH_SHORT).show();
                    return;
                }

//                if (!mPasswordEditText.getText().toString().equals(mPasswordConfirmEditText.getText().toString())) { // 아래와 같음
//                if (!mPasswordEditText.getText().toString().equals(mPasswordConfirmEditText.getText().toString()) == false) { // (6)
                if (isInvalidPassword()) { // (8) 더 간단히
                    Toast.makeText(this, "비밀번호가 다릅니다", Toast.LENGTH_SHORT).show();
                    return;
                }

                String gender = "남성"; // B(4)'
                if (mGenderRadioGroup.getCheckedRadioButtonId() == R.id.female_radio_button) { // B(4)
                    gender = "여성"; // B(4)"
                }

//                String gender = ((RadioButton)findViewById(mGenderRadioGroup.getCheckedRadioButtonId())).getText().toString(); // B(6) 가능

                Intent intent = new Intent(SignUpOhActivity.this, SignUpMessageActivity.class); // B(1) 여기부터는 넘기는 거
                intent.putExtra("id", mIdEditText.getText().toString());
                intent.putExtra("password", mPasswordEditText.getText().toString());
                intent.putExtra("email", mEmailEditText.getText().toString());
                intent.putExtra("gender", gender); // B(5)
//                startActivity(intent); // B(7) 일단 보냄
                startActivityForResult(intent, REQUEST_CODE); // D(1)

                break;
        }

    }

    private boolean isInvalidPassword() { // (8)' (8)로부터 메소드로 생겨남
        return mPasswordEditText.getText().toString().equals(mPasswordConfirmEditText.getText().toString()) == false;
    }

    private boolean isEditTextEmpty() { // (7)' (7)로부터 메소드로 생겨남. 이름 바꿈
        return TextUtils.isEmpty(mIdEditText.getText().toString()) ||
                TextUtils.isEmpty(mPasswordEditText.getText().toString()) ||
                TextUtils.isEmpty(mPasswordConfirmEditText.getText().toString()) ||
                TextUtils.isEmpty(mEmailEditText.getText().toString());
    }

    @Override // D(2)
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) { // 데이터는 안 넘어 왔음
            Toast.makeText(this, "확인 버튼을 누르셨습니다", Toast.LENGTH_SHORT).show();
        }
    }
}
