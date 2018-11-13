package com.pkdevelopers.eva1_14_centos;

public class Persona {

    //atributos
    private String sNombre;
    private String sApellido;
    private int iEdad;
    private String sSexo;
    private String sOrganizacion;
    private String sCorreoElectronico;

    public Persona(String sNombre, String sApellido, int iEdad, String sSexo, String sOrganizacion, String sCorreoElectronico ) {

        this.sNombre = sNombre;
        this.sApellido = sApellido;
        this.iEdad = iEdad;
        this.sSexo = sSexo;
        this.sOrganizacion = sOrganizacion;
        this.sCorreoElectronico = sCorreoElectronico;

    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public int getiEdad() {
        return iEdad;
    }

    public void setiEdad(int iEdad) {
        this.iEdad = iEdad;
    }

    public String getsSexo() {
        return sSexo;
    }

    public void setsSexo(String sSexo) {
        this.sSexo = sSexo;
    }

    public String getsOrganizacion() {
        return sOrganizacion;
    }

    public void setsOrganizacion(String sOrganizacion) {
        this.sOrganizacion = sOrganizacion;
    }

    public String getsCorreoElectronico() {
        return sCorreoElectronico;
    }

    public void setsCorreoElectronico(String sCorreoElectronico) {
        this.sCorreoElectronico = sCorreoElectronico;
    }
}
