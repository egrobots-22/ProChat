package com.egrobots.prochat.domain.usecases;

import com.egrobots.prochat.data.UserAuthenticationRepository;
import com.google.firebase.auth.FirebaseUser;

import androidx.lifecycle.MutableLiveData;

public class LoginUseCase {
    private final UserAuthenticationRepository userAuthenticationRepository;

    public LoginUseCase(UserAuthenticationRepository userAuthenticationRepository) {
        this.userAuthenticationRepository = userAuthenticationRepository;
    }

    public void execute(String email, String password, MutableLiveData<FirebaseUser> firebaseUserMutableLiveData) {
        userAuthenticationRepository.login(email, password, firebaseUserMutableLiveData);
    }
}
