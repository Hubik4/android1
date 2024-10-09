package com.example.logowanie;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText firstName, lastName, email, phone, password, confirmPassword;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firstName = findViewById(R.id.Name);
        lastName = findViewById(R.id.Surname);
        email = findViewById(R.id.Email);
        phone = findViewById(R.id.Phone);
        password = findViewById(R.id.Password);
        confirmPassword = findViewById(R.id.ConfirmPassword);
        submitButton = findViewById(R.id.SubmitButton);


        submitButton.setOnClickListener(new View.OnClickListener() {



            public void onClick(View v) {
                String firstNameInput = firstName.getText().toString().trim();
                String lastNameInput = lastName.getText().toString().trim();
                String emailInput = email.getText().toString().trim();
                String phoneInput = phone.getText().toString().trim();
                String passwordInput = password.getText().toString().trim();
                String confirmPasswordInput = confirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(firstNameInput)) {
                    firstName.setError("Podaj imię");
                    return;
                }

                if (TextUtils.isEmpty(lastNameInput)) {
                    lastName.setError("Podaj nazwisko");
                    return;
                }

                if (TextUtils.isEmpty(emailInput) || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                    email.setError("Podaj poprawny adres e-mail");
                    return;
                }

                if (TextUtils.isEmpty(phoneInput) || phoneInput.length() < 9) {
                    phone.setError("Podaj poprawny numer telefonu");
                    return;
                }

                if (TextUtils.isEmpty(passwordInput) || passwordInput.length() < 6) {
                    password.setError("Hasło musi zawierać co najmniej 6 znaków");
                    return;
                }

                if (!passwordInput.equals(confirmPasswordInput)) {
                    confirmPassword.setError("Hasła się nie zgadzają");
                    return;
                }

                // Jeżeli wszystko jest poprawnie
                Toast.makeText(MainActivity.this, "Formularz został poprawnie wypełniony!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}