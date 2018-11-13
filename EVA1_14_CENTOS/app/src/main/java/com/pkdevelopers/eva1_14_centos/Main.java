package com.pkdevelopers.eva1_14_centos;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Main extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    //EDITTEXT
    EditText etxtNombre, etxtApellido, etxtEdad, etxtOrganizacion, etxtCorreo;

    //RADIOGROUP
    RadioGroup rdgGenero;

    //RADIOBUTTON
    RadioButton rdbHombre, rdbMujer, rdbSexo;

    //Arraylist de tipo Persona, que persona es la clase que va a almacenar los datos
    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

    //Variables para datos obtenidos
    String sNombre;
    String sApellido;
    String sEdadTemp;
    int iEdad;
    String sSexo;
    String sOrganizacion;
    String sCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VINCULAMOS COMPONENTES
        etxtEdad = findViewById(R.id.etxtEdad);
        etxtCorreo = findViewById(R.id.etxtCorreo);
        etxtOrganizacion = findViewById(R.id.etxtOrganizacion);
        etxtNombre= findViewById(R.id.etxtNombre);
        etxtApellido = findViewById(R.id.etxtApellido);
        rdgGenero = findViewById(R.id.rdgGenero);
        rdbHombre = findViewById(R.id.rdbHombre);
        rdbMujer = findViewById(R.id.rdbMujer);

        rdgGenero.setOnCheckedChangeListener(this);



    }

    public void Click(View view) {

        agregarPersona();






    }

    public void agregarPersona(){

        if(!etxtNombre.getText().toString().equals("")){

            if(!etxtApellido.getText().toString().equals("")){

                if(!etxtEdad.getText().toString().equals("")){

                    if(sSexo != null){

                        if(!etxtOrganizacion.getText().toString().equals("")){

                            if(!etxtCorreo.getText().toString().equals("")){

                                sNombre = etxtNombre.getText().toString();
                                sApellido = etxtApellido.getText().toString();
                                sEdadTemp = etxtEdad.getText().toString();
                                iEdad = Integer.parseInt(sEdadTemp);
                                //sSexo ya se obtiene directamente y no entra a este if hasta que este seleccionado
                                sOrganizacion = etxtOrganizacion.getText().toString();
                                sCorreo = etxtCorreo.getText().toString();


                                //creamos una bandera
                                boolean esRepetido = false;
                                //comprobamos que esa persona no tenga el mismo correo anteriormente
                                for (int i = 0; i < listaPersonas.size(); i++){

                                    if(listaPersonas.get(i).getsCorreoElectronico().equals(sCorreo)){
                                        esRepetido = true;
                                    }
                                    Log.wtf( "-PERSONA COMPROBACION-",listaPersonas.get(i)+"" );

                                }
                                
                                if (esRepetido != true){
                                    //agregamos la persona al arraylist
                                    listaPersonas.add(new Persona(sNombre,sApellido,iEdad,sSexo, sOrganizacion, sCorreo));

                                }else{
                                    Toast.makeText(this, "El usuario con el correo que has ingresado, es repetido", Toast.LENGTH_SHORT).show();
                                }


                            }else{
                                Toast.makeText(this, "Por favor ingrese su correo electronico", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(this, "Por favor ingrese su organización", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(this, "Por favor ingrese su sexo", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(this, "Por favor ingrese su edad", Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(this, "Por favor ingrese su apellido", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Por favor ingrese su nombre", Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch(checkedId){

            case R.id.rdbHombre:
               sSexo = "Hombre";
               break;

            case R.id.rdbMujer:
                sSexo = "Mujer";
                break;

        }
    }

    /*
    //otra forma de hacerlo, solamente que si no hay nada seleccionado se rompe
    public String regresaSexo(){


        // get selected radio button from radioGroup
        int selectedId = rdgGenero.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        rdbSexo = (RadioButton) findViewById(selectedId);
        String value = rdbSexo.getText().toString();

        //Toast.makeText(this, value +"", Toast.LENGTH_SHORT).show();
        Log.wtf("regresaSexo: ", value );


        return value;


    }
    */



}
