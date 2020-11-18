package com.example.myapplication1113;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class FragmentOne extends Fragment {
    private UserModel userModel ;
    private TextView tv;
    private Button button;
    @Override
    public void onStart() {
        super.onStart();
        userModel = ViewModelProviders.of(getActivity()).get(UserModel.class);
        userModel.userMutableLiveData.observe(getActivity(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                tv.setText(user.toString());
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_one,container,false);
        tv = view.findViewById(R.id.tv);
        button = view.findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userModel.done();
            }
        });
        return view;
    }
}
