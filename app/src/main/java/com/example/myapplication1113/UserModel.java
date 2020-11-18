package com.example.myapplication1113;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class UserModel extends ViewModel {
    public final MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
    public UserModel(){
        userMutableLiveData.postValue(new User(1,"name1"));
    }
    public void done(){
        User user = userMutableLiveData.getValue();
        if(user != null){
            int i = new Random().nextInt(15);
            user.age = i;
            user.name = "name"+i;
            userMutableLiveData.setValue(user);
        }
    }
}
