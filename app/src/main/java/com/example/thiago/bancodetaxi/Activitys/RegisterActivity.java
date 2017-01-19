package com.example.thiago.bancodetaxi.Activitys;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thiago.bancodetaxi.R;

public class RegisterActivity extends AppCompatActivity {

    private Button buttonConfirm;
    private EditText editText1,editText2,editText3,editText4, editTextLogin, editTextPassword;
    private TextView textView1,textView2,textView3,textView4;
    private Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);


        editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);

        mySwitch = (Switch) findViewById(R.id.mySwitch);
        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);

        mySwitch.setChecked(true);

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mySwitch.setText("Cliente");
                    Drawable img = getApplicationContext().getResources().getDrawable( R.drawable.cliente_icon );
                    mySwitch.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);

                    textView1.setText("Nome");
                    textView2.setText("Endereço");
                    editText3.getText().clear();
                    editText4.getText().clear();
                    editText3.setVisibility(View.INVISIBLE);
                    editText4.setVisibility(View.INVISIBLE);
                    textView3.setVisibility(View.INVISIBLE);
                    textView4.setVisibility(View.INVISIBLE);

                }else{
                    mySwitch.setText("Motorista");
                    Drawable img = getApplicationContext().getResources().getDrawable( R.drawable.motorista_icon );
                    mySwitch.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);


                    textView1.setText("CPF");
                    textView2.setText("CNH");
                    editText3.getText().clear();
                    editText4.getText().clear();
                    editText3.setVisibility(View.VISIBLE);
                    editText4.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.VISIBLE);
                    textView4.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    public void onClickConfirm(View v){

        if (mySwitch.isChecked()){

            String login = editTextLogin.getText().toString();
            String password = editTextPassword.getText().toString();
            String nome = editText1.getText().toString();
            String endereco = editText2.getText().toString();

            String conditon = MainActivity.crud.insertUsuario(login, password, nome, endereco);

            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            if (conditon == "Usuário Inserido com sucesso"){
                Toast toast = Toast.makeText(context, conditon, duration);
                toast.show();
            }
            else {
                Toast toast = Toast.makeText(context, conditon, duration);
                toast.show();
            }
            finish();
        }
        else {
            String login = editTextLogin.getText().toString();
            String password = editTextPassword.getText().toString();
            String cpf = editText1.getText().toString();
            String cnh = editText2.getText().toString();
            String nome = editText3.getText().toString();
            String data_adm = editText4.getText().toString();

            String conditon = MainActivity.crud.insertMotorista(login, password, cpf, cnh, nome, data_adm);

            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            if (conditon == "Motorista Inserido com sucesso"){
                Toast toast = Toast.makeText(context, conditon, duration);
                toast.show();
            }
            else {
                Toast toast = Toast.makeText(context, conditon, duration);
                toast.show();
            }
            finish();
        }
    }
}
