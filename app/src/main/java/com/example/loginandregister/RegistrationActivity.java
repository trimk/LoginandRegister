package com.example.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class RegistrationActivity extends AppCompatActivity {

    private EditText editFirstName, editLastName, dateOfBirth, emailAddress, passwordNew;

    //oncreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        editFirstName = (EditText)findViewById(R.id.input_firstname);
        editLastName = (EditText)findViewById(R.id.input_lastname);
        dateOfBirth = (EditText) findViewById(R.id.input_dob);
        emailAddress= (EditText)findViewById(R.id.input_email);
        passwordNew= (EditText)findViewById(R.id.input_pwd);


        Button button_reg2 = (Button) findViewById(R.id.button);
        button_reg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmInput_OpenMainActivity();

            }
        });

    }
//conditions to validate if the field is empty, too long, too short. if any of these are true, the app will return it false because it is  not meeting required criteria
    private boolean validateFirstName(){
        String firstnameInput = editFirstName.getText().toString();
        if (firstnameInput.isEmpty()){
            editFirstName.setError("Field can't be empty");
            return false;

        } else if (firstnameInput.length()>30 || firstnameInput.length()< 3) {
            editFirstName.setError("Please enter valid name");
            return false;

        } else{
            editFirstName.setError(null);
            return true;
        }

    }

    //conditions to validate if the field is empty, too long, too short. if any of these are true, the app will return it false because it is  not meeting required criteria

    private boolean validateLastName(){
        String lastNameInput = editLastName.getText().toString();
        if (lastNameInput.isEmpty()){
            editLastName.setError("Field can't be empty");
            return false;

        } else if (lastNameInput.length()>30 || lastNameInput.length()< 3) {
            editLastName.setError("Please enter valid name");
            return false;

        } else{
            editLastName.setError(null);
            return true;
        }

    }
// condition to validate if the field is empty, or if it doesn't have 8 characters. it will only return true if it meets this
    private boolean validateDateOfBirth() {
        String dateInput = dateOfBirth.getText().toString();
        if (dateInput.isEmpty()) {
            dateOfBirth.setError("Field can't be empty");
            return false;

        } else if (dateInput.length() != 8) {
            return false;
        } else {
            dateOfBirth.setError(null);
            return true;
        }
    }
// imported the patterns regex so that the email address format is followed
    private boolean validateEmail(){
        String emailUserInput = emailAddress.getText().toString();
        if (emailUserInput.isEmpty()){
            emailAddress.setError("Field can't be empty");
            return false;

        } else if ((!Patterns.EMAIL_ADDRESS.matcher(emailUserInput).matches())){
            emailAddress.setError("Please enter valid address");
            return false;
        } else {
            emailAddress.setError(null);
            return true;
        }
    }
//using the custom pattern declared above, this follows the criteria for that and also ensures it wont return if empty.
    private boolean validatePassword(){
        String passwordInput = passwordNew.getText().toString();
        if (passwordInput.isEmpty()){
            passwordNew.setError("Field can't be empty");
            return false;
        } else {
            passwordNew.setError(null);
            return true;
        }
    }
//this  makes the button return back to main activity login page once the user meets all the required registration fields.
    public void  confirmInput_OpenMainActivity(){
        if (!validateFirstName() | !validateLastName() | !validateDateOfBirth() | !validateEmail() | !validatePassword()) {
            return;

    }
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
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