package android.example.com.elviera_1202152335_modul3;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


   EditText musername;
   EditText mpassword;
   Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // mendapatkan nilai resource dari EditText
        musername = (EditText) findViewById(R.id.username);
        mpassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.buttonLogin);

        //menset klik button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mendapatkan username dan password dari yang sudah di deklarasikan
                String usernameKey = musername.getText().toString();
                String passwordKey = mpassword.getText().toString();

                if (usernameKey.equals("EAD") && passwordKey.equals("MOBILE")) {
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "LOGIN SUCCEEDED!",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, DaftarAir.class);
                    LoginActivity.this.startActivity(intent);
                    finish();
                } else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("password/username wrong, try again!")
                            .setNegativeButton("Retry", null).create().show();
                }
            }
        });
    }
}