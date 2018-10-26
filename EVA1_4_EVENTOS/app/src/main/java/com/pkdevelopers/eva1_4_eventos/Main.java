package com.pkdevelopers.eva1_4_eventos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity implements View.OnClickListener {

    TextView txtVwMensaje; //Este objeto se vincula al winidget
    Button btnAccion2;
    Button btnAccion3;
    Button btnAccion4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwMensaje = findViewById(R.id.txtVwMensaje); // en caso de error castearlo
        txtVwMensaje.setText("Hola mundo :)!");
        // Una vez vinculado, se puede utilizar

        btnAccion2 = findViewById(R.id.btnAccion2);
        btnAccion2.setOnClickListener(this);// Le mandas de argumento la clase principal

        btnAccion3 = findViewById(R.id.btnAccion3);
        btnAccion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Desde clase anonima", Toast.LENGTH_LONG).show();
            }
        });
        ClickListener cMiClick = new ClickListener();
        btnAccion4 = findViewById(R.id.btnAccion4);
        btnAccion4.setOnClickListener(cMiClick);

    }

    public void MiClick(View view){
        Toast.makeText(this,"Desde XML",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"Desde interfaz",Toast.LENGTH_LONG).show();
    }
}
