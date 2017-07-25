package com.hckim.signupexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_ADMIT = 1000;
    private EditText mIdEditText;
    private EditText mPasswordEditText;
    private EditText mEmailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIdEditText = (EditText) findViewById(R.id.id_edit);
        mPasswordEditText = (EditText) findViewById(R.id.password_edit);
        mEmailEditText = (EditText) findViewById(R.id.email_edit);

        findViewById(R.id.admit_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("id", mIdEditText.getText().toString());
        intent.putExtra("password", mPasswordEditText.getText().toString());
        intent.putExtra("email", mEmailEditText.getText().toString());
        startActivityForResult(intent, REQUEST_CODE_ADMIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADMIT && resultCode == RESULT_OK && data != null) {
            String text = data.getStringExtra("text");
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }
}
