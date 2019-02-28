package com.studio.azhar.examplecrudvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText npm, nama;
    Button btnInput;

    final String INPUT_URL = "http://192.168.167.1/MateriCRUD/insert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        npm = findViewById(R.id.editNpm);
        nama = findViewById(R.id.ediNama);
        btnInput = findViewById(R.id.btnInput);



        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputData();
            }
        });
    }


    public void inputData() {
        final String npmM = npm.getText().toString().trim();
        final String namaM = nama.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, INPUT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(MainActivity.this,response, Toast.LENGTH_SHORT).show();

                        //for show response from API and string from Toast
//                        Toast.makeText(MainActivity.this,"your toast message"+response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "error" + error, Toast.LENGTH_SHORT).show();

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("npm", npmM);
                params.put("nama", namaM);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
