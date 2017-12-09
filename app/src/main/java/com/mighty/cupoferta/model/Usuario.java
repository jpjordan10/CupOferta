package com.mighty.cupoferta.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("nombres")
    @Expose
    private String nombres;

    @SerializedName("apellidos")
    @Expose
    private String apellidos;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("dni")
    @Expose
    private String dni;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("id")
    @Expose
    private Integer id;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}