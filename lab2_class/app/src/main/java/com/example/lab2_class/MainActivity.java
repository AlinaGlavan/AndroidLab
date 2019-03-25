package com.example.lab2_class;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int size=0;
    int nrComanda=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv_36= findViewById(R.id.tv_36);
        TextView tv_37= findViewById(R.id.tv_37);
        TextView tv_38= findViewById(R.id.tv_38);
        TextView tv_39= findViewById(R.id.tv_39);
        final TextView tv_MarimeSelectata = findViewById(R.id.tv_MarimeSelectata);


        final TextView tv_order = findViewById(R.id.tv_order);
        Button btn_order = findViewById(R.id.btn_order);

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nrComanda++;
                tv_order.setText("Comanda cu numarul " + nrComanda +" a fost plasata");
            }
        });


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size =Integer.parseInt(((TextView) v).getText().toString());
                tv_MarimeSelectata.setText(Integer.toString(size));
            }
        };

        tv_36.setOnClickListener(listener);
        tv_37.setOnClickListener(listener);
        tv_38.setOnClickListener(listener);
        tv_39.setOnClickListener(listener);

    }
}
