package com.example.myapplication;

import android.text.TextUtils;

public class MyActivityPresenter implements MyActivityContract.Presenter {

    MyActivityContract.View view;

    public MyActivityPresenter(MyActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {

        if(email.equals("test@live") && password.equals(12345)){
            view.onSuccess("Sucess");
        }
        else{
            view.onError("Error");
        }

    }
}
