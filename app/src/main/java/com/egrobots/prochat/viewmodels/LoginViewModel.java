package com.egrobots.prochat.viewmodels;

import com.egrobots.prochat.Injection;
import com.egrobots.prochat.domain.usecases.LoginUseCase;
import com.google.firebase.auth.FirebaseUser;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private final LoginUseCase loginUseCase;
    private MutableLiveData<FirebaseUser> firebaseUserMutableLiveData = new MutableLiveData<>();

    public LoginViewModel() {
        loginUseCase = Injection.getLoginUseCase();
    }

    public void login(String email, String password) {
        loginUseCase.execute(email, password, firebaseUserMutableLiveData);
    }

    public MutableLiveData<FirebaseUser> getFirebaseUserMutableLiveData() {
        return firebaseUserMutableLiveData;
    }
}
