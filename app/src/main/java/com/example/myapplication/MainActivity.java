package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MyActivityContract.View{

    @BindView(R.id.email)
    EditText et_email;
    @BindView(R.id.password)
    EditText et_password;
    @BindView(R.id.btn_login)
    Button btnLogin;

    MyActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MyActivityPresenter(this);
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {

        String email = et_email.getText().toString();
        String password = et_password.getText().toString();
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            onError("Fields required");}
            else{
        presenter.doLogin(email,password);}


    }




    @Override
    public void onSuccess(String message) {
        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(getApplicationContext(),"Login Failure",Toast.LENGTH_LONG).show();

    }
}