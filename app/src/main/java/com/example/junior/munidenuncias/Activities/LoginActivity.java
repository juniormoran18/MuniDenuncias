package com.example.junior.munidenuncias.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.junior.munidenuncias.Network.ApiService;
import com.example.junior.munidenuncias.Network.ApiServiceGenerator;
import com.example.junior.munidenuncias.R;
import com.example.junior.munidenuncias.Repository.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    // SharedPreferences
    private SharedPreferences sharedPreferences;
    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText usernameInput;
    private EditText passwordInput;
    private ProgressBar progressBar;
    private View loginPanel;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = (EditText)findViewById(R.id.username_input);
        passwordInput = (EditText)findViewById(R.id.password_input);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        loginPanel = findViewById(R.id.login_panel);

        /* init SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // username remember
        String username = sharedPreferences.getString("username", null);
        if(username != null){
            usernameInput.setText(username);
            passwordInput.requestFocus();
        }

        // islogged remember
        if(sharedPreferences.getBoolean("islogged", false)){
            // Go to Dashboard
            goDashboard();
        }*/

    }


    public void callLogin(View view){
        loginPanel.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        username = usernameInput.getText().toString();
        password = passwordInput.getText().toString();

        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<User> call = service.loginUser(username, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        User usuario = response.body();
                        Log.d(TAG, "usuario: " + usuario);

                       // String usuarioCompare = usuario.getUsername();
                        // String passwordCompare = usuario.getPassword();

                       // if (usuarioCompare.equals(username) && passwordCompare.equals(password)){

                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);

                       // }

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        // Login logic
        //User user = UserRepository.login(username, password);

       /* if(user == null){
            Toast.makeText(this, "Username or password invalid", Toast.LENGTH_SHORT).show();
            loginPanel.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
            return;
        }

        Toast.makeText(this, "Welcome " + user.getUsername(), Toast.LENGTH_SHORT).show();

        // Save to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean success = editor
                .putString("username", user.getUsername())
                .putBoolean("islogged", true)
                .commit();

        // Go to Dashboard
        goDashboard();*/
    }



}
