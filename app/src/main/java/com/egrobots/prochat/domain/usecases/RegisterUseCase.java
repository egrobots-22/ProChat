package com.egrobots.prochat.domain.usecases;

import com.egrobots.prochat.data.UserAuthenticationRepository;
import com.egrobots.prochat.model.User;

import androidx.lifecycle.MutableLiveData;

public class RegisterUseCase {

    private final UserAuthenticationRepository userAuthenticationRepository;

    public RegisterUseCase(UserAuthenticationRepository userAuthenticationRepository) {
        this.userAuthenticationRepository = userAuthenticationRepository;
    }

    public void execute(User user, MutableLiveData<User> userMutableLiveData) {
        userAuthenticationRepository.registerNewUser(user, userMutableLiveData);
    }
}
