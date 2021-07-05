package unsa.edu.ges;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import unsa.edu.ges.models.User;
import unsa.edu.ges.models.UserStorage;

public class NormalLogin extends AppCompatActivity{
    TextView tv_login_username;
    TextView tv_login_password;
    Button btn_login;
    Button btn_registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_login);
        UserStorage.init();

        tv_login_username = findViewById(R.id.tv_login_username);
        tv_login_password = findViewById(R.id.tv_login_password);
        btn_login = findViewById(R.id.btn_login);
        btn_registro = findViewById(R.id.btn_signup_form);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User userNow = UserStorage.findUser(tv_login_username.getText().toString());
                if (userNow != null) {
                    if (userNow.getPassword().equals(tv_login_password.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Login Realizado con Éxito", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "La contraseña no coincide", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario no Registrado", Toast.LENGTH_SHORT).show();
                }
                Log.e("Usuarios:", UserStorage.getUsers());
            }
        });

        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterLocalActivity.class);
                startActivity(intent);
            }
        });
    }
}