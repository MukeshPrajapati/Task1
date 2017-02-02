package com.mukesh.task1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentLogin extends Fragment {
    View view;
    Button login, cancel;
    EditText username, password;
    Fragment f;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment, container, false);

        username = (EditText)view.findViewById(R.id.username);
        password = (EditText)view.findViewById(R.id.password);

        final String uname = "student@vnurture.com";
        final String pwd = "student@123";

        login = (Button)view.findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals(uname) && password.getText().toString().equals(pwd)){
                    f = new FragmentSucess();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.main_id, f);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            }
        });

        cancel = (Button)view.findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return view;
    }
}

