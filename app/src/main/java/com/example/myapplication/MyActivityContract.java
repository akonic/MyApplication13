package com.example.myapplication;

public interface MyActivityContract {
    interface View{
        void onSuccess(String message);
        void onError(String message);

    }
    interface Presenter{
        void doLogin(String email,String Password);
    }
}
