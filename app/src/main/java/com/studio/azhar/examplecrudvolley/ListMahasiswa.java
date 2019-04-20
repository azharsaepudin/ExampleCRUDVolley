package com.studio.azhar.examplecrudvolley;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListMahasiswa extends AppCompatActivity {

    private static final String URL_mahasiswa = "http://192.168.167.1/MateriCRUD/getData.php";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ModelMahasiswa> modelMahasiswas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        recyclerView = findViewById(R.id.recyclerViewMhs);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        modelMahasiswas = new ArrayList<>();

        loadDataMahasiswa();

    }

    private void loadDataMahasiswa (){
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_mahasiswa, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);


                    JSONArray array = jsonObject.getJSONArray("results");

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject jo = array.getJSONObject(i);

                        ModelMahasiswa mdlmhs = new ModelMahasiswa(jo.getString("id"),
                                jo.getString("npm"),
                                jo.getString("nama"));

                        modelMahasiswas.add(mdlmhs);
                    }

                    adapter = new MahasiswaAdapter(modelMahasiswas,getApplicationContext());
                    recyclerView.setAdapter(adapter);



                } catch (JSONException ex) {
                    Log.d("exep", ex.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
