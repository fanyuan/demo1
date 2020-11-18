package com.example.myapplication1113;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    UserModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);

        model = ViewModelProviders.of(this).get(UserModel.class);
        model.userMutableLiveData.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                tv.setText(user.toString());
            }
        });
        Tools.attFrag(this);
        Tools.log("MainActivity onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Tools.log("MainActivity onDestroy");
    }

    public void click(View v){
        Tools.toast(this,"点击");
        model.done();
    }
    public void toFragment(View v){
        startActivity(new Intent(this,FragmentActivity.class));
    }

}
