package com.pkdevelopers.eva1_12_cafeteria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CheckBox.OnCheckedChangeListener {

    //RADIOGROUP
    RadioGroup rdgCafes;

    //RADIOBUTTON
    RadioButton rdbExpresso;
    RadioButton rdbCapuchino;
    RadioButton rdbAmericano;

    //CHECKOBOX
    CheckBox cbxCrema;
    CheckBox cbxAzucar;

    //TEXTVIEW
    TextView lblDescripcion;
    EditText etxtCant;

    //VARIABLES GLOBALES
    int iExtras;
    int iPrecioCafe;
    String sDescripcion;
    String sCafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VINCULACION DE COMPONENTES
        rdgCafes = findViewById(R.id.rdgCafes);

        rdbExpresso = findViewById(R.id.rdbExpresso);
        rdbAmericano = findViewById(R.id.rdbAmericano);
        rdbCapuchino = findViewById(R.id.rdbCapuchino);

        cbxAzucar = findViewById(R.id.cbxAzucar);
        cbxCrema = findViewById(R.id.cbxCrema);

        lblDescripcion = findViewById(R.id.lblDescripcion);

        etxtCant = findViewById(R.id.etxtCant);

        cbxAzucar.setEnabled(false);
        cbxCrema.setEnabled(false);

        cbxAzucar.setOnCheckedChangeListener(this);
        cbxCrema.setOnCheckedChangeListener(this);
        rdgCafes.setOnCheckedChangeListener(this);

    }

    //METODO ONCHECKEDCHANGED DE CREMA Y AZUCAR
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (cbxCrema.isChecked()) {

            iExtras = 1;
            sDescripcion = sCafe + ", crema";

            if (cbxAzucar.isChecked()) {

                iExtras = 2;
                sDescripcion = sCafe + ", crema y azucar";

            }
        } else if (cbxAzucar.isChecked()) {

            iExtras = 1;
            sDescripcion = sCafe + ", azucar";

            if (cbxCrema.isChecked()) {

                iExtras = 2;
                sDescripcion = sCafe + ", crema y azucar";

            }
        } else {

            sDescripcion = sCafe;
            iExtras = 0;

        }

        lblDescripcion.setText(sDescripcion);

    }

    //METODO ONCHECKEDCHANGES DE CAFES
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        cbxCrema.setEnabled(true);
        cbxAzucar.setEnabled(true);

        if (R.id.rdbAmericano == checkedId) {

            iPrecioCafe = 20;
            sCafe = "americano";

        } else if (R.id.rdbCapuchino == checkedId) {

            iPrecioCafe = 48;
            sCafe = "capuchino";

        } else if (R.id.rdbExpresso == checkedId) {

            iPrecioCafe = 30;
            sCafe = "expresso";

        }

        cbxCrema.setChecked(false);
        cbxAzucar.setChecked(false);
        lblDescripcion.setText(sCafe);

    }

    public void click(View v) {

        if (!etxtCant.getText().toString().equals("")) {

            int iCant = Integer.parseInt(etxtCant.getText().toString());
            int iTotal = (iExtras * iCant) + (iPrecioCafe * iCant);

            Toast.makeText(this, "$ " + iTotal, Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "por favor escribe una cantidad", Toast.LENGTH_SHORT).show();

        }
    }

}
