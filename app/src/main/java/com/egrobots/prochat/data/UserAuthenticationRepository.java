package com.egrobots.prochat.data;

import com.egrobots.prochat.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import androidx.lifecycle.MutableLiveData;

public interface UserAuthenticationRepository {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    void login(String email, String password, MutableLiveData<FirebaseUser> userMutableLiveData);

    void registerNewUser(User user, MutableLiveData<User> userMutableLiveData);

    void addNewUser(User user, MutableLiveData<Boolean> success);

}
