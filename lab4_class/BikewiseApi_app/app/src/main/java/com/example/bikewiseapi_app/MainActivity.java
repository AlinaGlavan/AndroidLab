package com.example.bikewiseapi_app;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    Button btnGetRepos;
    TextView tvRepoList;
    RequestQueue requestQueue;

    String baseUrl = "https://bikewise.org/api/v2/incidents";
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnGetRepos = (Button) findViewById(R.id.btn_get_incidents);
        this.tvRepoList = (TextView) findViewById(R.id.tv_incidents_list);
        this.tvRepoList.setMovementMethod(new ScrollingMovementMethod());

        requestQueue = Volley.newRequestQueue(this);

    }



    private void clearIncidentsList() {
        this.tvRepoList.setText("");
    }

    private void addToIncidentsList(String title, String description, String address) {
        String strRow = title + " / " + description + " / " + address;
        String currentText = tvRepoList.getText().toString();
        this.tvRepoList.setText(currentText + "\n\n" + strRow);
    }

    private void setIncidentsListText(String str) {
        this.tvRepoList.setText(str);
    }
    private void getIncidentsList() {
        this.url = this.baseUrl;
        JsonObjectRequest arrReq =new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArr = response.getJSONArray("incidents");
                            if (jsonArr.length() > 0) {
                                for (int i = 0; i < jsonArr.length(); i++) {
                                    JSONObject json = jsonArr.getJSONObject(i);
                                    String title = json.get("title").toString();
                                    String description = json.get("description").toString();
                                    String address = json.get("address").toString();
                                    addToIncidentsList(title, description, address);
                                }
                            } else {
                                setIncidentsListText("No incidents found.");
                            }
                        } catch (JSONException e) {
                            Log.e("Volley", "Invalid JSON Object.");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                setIncidentsListText("Error while calling REST API");
                Log.e("Volley", error.toString());
            }
        });
        requestQueue.add(arrReq);
    }
    public void getIncidentsClicked(View v) {
        clearIncidentsList();
        getIncidentsList();
    }
}
