package com.animu;

public class Cuentas {
    private String usuario;
    private String password;
    private String intentos;

    public Cuentas(String usuario, String password, String intentos) {
        this.usuario = usuario;
        this.password = password;
        this.intentos = intentos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntentos() {
        return intentos;
    }

    public void setIntentos(String intentos) {
        this.intentos = intentos;
    }
}
