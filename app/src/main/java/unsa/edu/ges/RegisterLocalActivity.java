package unsa.edu.ges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import unsa.edu.ges.models.User;
import unsa.edu.ges.models.UserCheck;
import unsa.edu.ges.models.UserStorage;

public class RegisterLocalActivity extends AppCompatActivity {

    TextView signup_username;
    TextView signup_email;
    TextView signup_password;
    TextView signup_repeat_password;
    TextView signup_adress;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_local);
        signup_username=findViewById(R.id.tv_signup_username);
        signup_email=findViewById(R.id.tv_signup_email);
        signup_password=findViewById(R.id.tv_signup_password);
        signup_repeat_password=findViewById(R.id.tv_signup_repeat_password);
        signup_adress=findViewById(R.id.tv_signup_address);
        btn_register=findViewById(R.id.btn_signup);
        UserStorage.init();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User userIn=new User(signup_username.getText().toString(),
                        signup_password.getText().toString(),
                        signup_email.getText().toString(),
                        signup_adress.getText().toString());
                if(UserCheck.checkUser(userIn,signup_repeat_password.getText().toString())){
                    UserStorage.addUser(userIn);
                    Toast.makeText(getApplicationContext(),"Usuario Registrado Satisfactoriamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Error en el Almacenamiento de Usuarios", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}