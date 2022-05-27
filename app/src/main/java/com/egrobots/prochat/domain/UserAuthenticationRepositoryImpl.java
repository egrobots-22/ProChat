package com.egrobots.prochat.domain;

import com.egrobots.prochat.data.UserAuthenticationRepository;
import com.egrobots.prochat.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;

import androidx.lifecycle.MutableLiveData;

public class UserAuthenticationRepositoryImpl implements UserAuthenticationRepository {

    private DatabaseReference usersRef = firebaseDatabase.getReference("users2");

    @Override
    public void login(String email, String password, MutableLiveData<FirebaseUser> userMutableLiveData) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                FirebaseUser firebaseUser = task.getResult().getUser();
                userMutableLiveData.setValue(firebaseUser);
            } else {
                userMutableLiveData.setValue(null);
            }
        });
    }

    @Override
    public void registerNewUser(User user, MutableLiveData<User> userMutableLiveData) {
        firebaseAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                FirebaseUser firebaseUser = task.getResult().getUser();
                String userId = firebaseUser.getUid();
                user.setId(userId);
                usersRef.child(userId).setValue(user).addOnCompleteListener(addTask -> {
                    if (addTask.isSuccessful()) {
                        updateUserProfile(user, firebaseUser);
                        userMutableLiveData.setValue(user);
                    } else {
                        userMutableLiveData.setValue(null);
                        //must be deleted from firebase authentication accounts
                    }
                });
            } else {
                userMutableLiveData.setValue(null);
            }
        });
    }

    private void updateUserProfile(User user, FirebaseUser firebaseUser) {
        UserProfileChangeRequest.Builder profileUpdates = new UserProfileChangeRequest.Builder();
        UserProfileChangeRequest userProfileChangeRequest = profileUpdates.setDisplayName(user.getUsername()).build();
        firebaseUser.updateProfile(userProfileChangeRequest);
    }

    @Override
    public void addNewUser(User user, MutableLiveData<Boolean> success) {
        String userId = user.getId();
        usersRef.child(userId).setValue(user).addOnCompleteListener(task -> success.setValue(task.isSuccessful()));
    }
}
