package com.egrobots.prochat;

import com.egrobots.prochat.data.UserAuthenticationRepository;
import com.egrobots.prochat.domain.UserAuthenticationRepositoryImpl;
import com.egrobots.prochat.domain.usecases.LoginUseCase;
import com.egrobots.prochat.domain.usecases.RegisterUseCase;

public class Injection {
    public static LoginUseCase getLoginUseCase() {
        return new LoginUseCase(getUserAuthenticationRepositroy());
    }

    private static UserAuthenticationRepository getUserAuthenticationRepositroy() {
        return new UserAuthenticationRepositoryImpl();
    }

    public static RegisterUseCase getRegisterUserCase() {
        return new RegisterUseCase(getUserAuthenticationRepositroy());
    }
}
