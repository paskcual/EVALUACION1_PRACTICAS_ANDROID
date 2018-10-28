package com.pkdevelopers.eva1_13_expectativa_vida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    //EDITTEXT
    EditText etxtAño;

    //TEXTVIEW
    TextView lblFecha, lblExpectativa;

    //RADIOGROUP
    RadioGroup rdgRegiones, rdgGenero;

    //RADIOBUTTON
    RadioButton rdbHombre, rdbMujer, rdbRegiones, rdbAmerica, rdbAsia, rdbAfrica;

    //VARIABLES GLOBALES
    String sTipoReg = "";
    String sGenero = "";
    double dDiferenciaGenero = 0;
    double dAño;
    double dEdad = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VINCULAMOS LOS RECURSOS
        rdbHombre = findViewById(R.id.rdbHombre);
        rdbMujer = findViewById(R.id.rdbMujer);
        rdbRegiones = findViewById(R.id.rdbRegiones);
        rdbAmerica = findViewById(R.id.rdbAmerica);
        rdbAfrica = findViewById(R.id.rdbAfrica);
        rdbAsia = findViewById(R.id.rdbAsia);

        rdgRegiones = findViewById(R.id.rdgRegiones);
        rdgGenero = findViewById(R.id.rdgGenero);

        lblExpectativa = findViewById(R.id.lblExpectativa);
        lblFecha = findViewById(R.id.lblFecha);

        etxtAño = findViewById(R.id.txtAño);

        rdgRegiones.setOnCheckedChangeListener(this);
        rdgGenero.setOnCheckedChangeListener(this);

    }

    //ONCHECKED CHANGE PARA REGIONES
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if (!etxtAño.getText().toString().equals("")) {

            dAño = Integer.parseInt(etxtAño.getText().toString());

            //COMPROBAMOS DE DONDE ES
            comprobarRegion(checkedId);

            //COMPROBAMOS EL GENERO
            comprobarGenero(checkedId);

            //FILTRAMOS PARA DECIDIR EL AÑO
            decidirAño();

            //HACEMOS EL CALCULO DE LA DIFERENCIA DE GENERO
            if ((dDiferenciaGenero % 2) != 0) {

                dEdad = dEdad + 0.5;

            }

            dDiferenciaGenero = dDiferenciaGenero / 2;

            if (sGenero == "Hombre") {

                dEdad = dEdad - dDiferenciaGenero;

            } else if (sGenero == "Mujer") {

                dEdad = dEdad + dDiferenciaGenero;

            }

            if (rdbMujer.isChecked() || rdbHombre.isChecked()) {

                lblExpectativa.setText(dEdad + " años");
                lblFecha.setText((dAño + dEdad) + "");

            }

        } else {

            Toast.makeText(this, "por favor escruba un año", Toast.LENGTH_SHORT).show();

        }

    }

    public void comprobarRegion(int checkedId){

        if (checkedId == R.id.rdbRegiones) {

            sTipoReg = "regiones";

        } else if (checkedId == R.id.rdbAmerica) {

            sTipoReg = "america";

        } else if (checkedId == R.id.rdbAfrica) {

            sTipoReg = "africa";

        } else if (checkedId == R.id.rdbAsia) {

            sTipoReg = "asia";

        }

    }

    public void comprobarGenero(int checkedId){

        if (checkedId == R.id.rdbHombre) {

            sGenero = "hombre";

        } else if (checkedId == R.id.rdbMujer) {

            sGenero = "mujer";

        }

    }

    public void decidirAño(){

        if (dAño >= 1950 && dAño < 1960) {

            dDiferenciaGenero = 10;

            switch (sTipoReg) {
                case "Regiones":
                    dEdad = 75;
                    break;
                case "America":
                    dEdad = 60;
                    break;
                case "Asia":
                    dEdad = 45;
                    break;
                case "Africa":
                    dEdad = 35;
                    break;
            }

        } else if (dAño >= 1960 && dAño < 1970) {

            dDiferenciaGenero = 9;

            switch (sTipoReg) {
                case "Regiones":
                    dEdad = 75;
                    break;
                case "America":
                    dEdad = 65;
                    break;
                case "Asia":
                    dEdad = 50;
                    break;
                case "Africa":
                    dEdad = 45;
                    break;
            }

        } else if (dAño >= 1970 && dAño < 1980) {

            dDiferenciaGenero = 8;

            switch (sTipoReg) {
                case "Regiones":
                    dEdad = 80;
                    break;
                case "America":
                    dEdad = 70;
                    break;
                case "Asia":
                    dEdad = 65;
                    break;
                case "Africa":
                    dEdad = 55;
                    break;
            }

        } else if (dAño >= 1980 && dAño < 1990) {

            dDiferenciaGenero = 7;

            switch (sTipoReg) {
                case "Regiones":
                    dEdad = 80;
                    break;
                case "America":
                    dEdad = 75;
                    break;
                case "Asia":
                    dEdad = 65;
                    break;
                case "Africa":
                    dEdad = 60;
                    break;
            }

        } else if (dAño >= 1990 && dAño < 2000) {

            dDiferenciaGenero = 6;

            switch (sTipoReg) {
                case "Regiones":
                    dEdad = 85;
                    break;
                case "America":
                    dEdad = 75;
                    break;
                case "Asia":
                    dEdad = 60;
                    break;
                case "Africa":
                    dEdad = 55;
                    break;
            }

        } else if (dAño >= 2000) {

            dDiferenciaGenero = 4;

            switch (sTipoReg) {
                case "Regiones":
                    dEdad = 90;
                    break;
                case "America":
                    dEdad = 70;
                    break;
                case "Asia":
                    dEdad = 65;
                    break;
                case "Africa":
                    dEdad = 60;
                    break;
            }

        } else {

            Toast.makeText(this, "intenta con otra edad", Toast.LENGTH_SHORT).show();

        }

    }

}
