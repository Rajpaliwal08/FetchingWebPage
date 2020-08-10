package com.rajpaliwal.fetchingweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String URL = editText.getText().toString();


                final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

                StringRequest stringRequest = new StringRequest(Request.Method.POST,URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                textView.setText("Web page is:\n" + response);


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {


                                textView.setText("Something went wrong: " + error);

                            }
                        }
                );

                requestQueue.add(stringRequest);

            }
        });


    }
}
