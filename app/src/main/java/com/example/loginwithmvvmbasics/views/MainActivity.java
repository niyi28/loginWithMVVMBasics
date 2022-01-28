package com.example.loginwithmvvmbasics.views;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.text.TextUtils;
import android.util.Patterns;
import androidx.databinding.*;
import com.example.loginwithmvvmbasics.BR;
import com.example.loginwithmvvmbasics.R;
import com.example.loginwithmvvmbasics.databinding.ActivityMainBinding;
import com.example.loginwithmvvmbasics.model.User;
import androidx.appcompat.app.AppCompatActivity;
import com.example.loginwithmvvmbasics.viewsModels.LoginViewModel;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LoginViewModel loginViewModel = new LoginViewModel();
        String email = loginViewModel.getUserEmail();
        String password = loginViewModel.getUserPassword();
        activityMainBinding.setVariable(R.id.inEmail, email);
        
        /*activityMainBinding.setVariable(BR.userPassword, password);*/
        activityMainBinding.executePendingBindings();
        /*Button tickCard = findViewById(R.id.button);
        runMe(tickCard, "done");*/
    }

    @BindingAdapter({"toastMessage"})
    public void runMe(Button buttonClick, String message) {
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (message != null) {
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
