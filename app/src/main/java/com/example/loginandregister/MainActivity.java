package com.example.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputNames, inputPwd1;

    private Button button_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        inputNames = (EditText)findViewById(R.id.inputnames);
        inputPwd1 = (EditText)findViewById(R.id.inputpwd1);

    //activated the login button with a toast for successful submission
        button_Login = (Button) findViewById(R.id.login_btn);
        button_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Login was Successful!!!", Toast.LENGTH_SHORT).show();
            }
        });

        //activated the registration button
        Button button_Reg = (Button) findViewById(R.id.reg_btn);
        button_Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistrationActivity();
            }
        });
        //assigned which text fields will be watched for changes
        inputNames.addTextChangedListener(loginTextWatch);
        inputPwd1.addTextChangedListener(loginTextWatch);


    }
    //this is a watcher to make sure that the login button will not be enabled unless the ontext changed params are met

    private TextWatcher loginTextWatch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String nameInput = inputNames.getText().toString();
            String pwdInput = inputPwd1.getText().toString();
            button_Login.setEnabled(!nameInput.isEmpty() && (!pwdInput.isEmpty()));
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    //this opens the registration activity if the register button was clicked

    public void openRegistrationActivity(){


        Intent intent = new Intent(this, RegistrationActivity.class);
                startActivity(intent);


    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}