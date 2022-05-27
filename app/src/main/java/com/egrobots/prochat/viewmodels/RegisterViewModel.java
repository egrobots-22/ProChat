package com.egrobots.prochat.viewmodels;

import com.egrobots.prochat.Injection;
import com.egrobots.prochat.domain.usecases.RegisterUseCase;
import com.egrobots.prochat.model.User;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegisterViewModel  extends ViewModel {

    private final RegisterUseCase registerUseCase;
    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public RegisterViewModel() {
        registerUseCase = Injection.getRegisterUserCase();
    }

    public void register(User user) {
        registerUseCase.execute(user, userMutableLiveData);
    }

    private void validate() {

    }

    public MutableLiveData<User> getUserMutableLiveData() {
        return userMutableLiveData;
    }
}
