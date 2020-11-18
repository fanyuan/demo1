package com.example.myapplication1113;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentActivity extends AppCompatActivity {
    UserModel model;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Tools.log("FragmentActivity onCreate");
        model = ViewModelProviders.of(this).get(UserModel.class);
        tv = findViewById(R.id.tv);
        model.userMutableLiveData.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                tv.setText(user.toString());
            }
        });
    }
    public void add(View v){
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.add(R.id.layout1,new FragmentOne());
        trans.add(R.id.layout2,new FragmentTwo());
        trans.commit();
        Tools.toast(this,"add");
    }
    public void click(View v){
        //Tools.toast(this,"点击");
        model.done();
    }
}
