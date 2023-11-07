package com.example.ejerciciorepaso;

public class Pregunta {
    private int idImagen1, idImagen2, idImagen3, idImagen4, correcta;

    public int getIdImagen1() {
        return idImagen1;
    }

    public void setIdImagen1(int idImagen1) {
        this.idImagen1 = idImagen1;
    }

    public int getIdImagen2() {
        return idImagen2;
    }

    public void setIdImagen2(int idImagen2) {
        this.idImagen2 = idImagen2;
    }

    public int getIdImagen3() {
        return idImagen3;
    }

    public void setIdImagen3(int idImagen3) {
        this.idImagen3 = idImagen3;
    }

    public int getIdImagen4() {
        return idImagen4;
    }

    public void setIdImagen4(int idImagen4) {
        this.idImagen4 = idImagen4;
    }

    public int getCorrecta() {
        return correcta;
    }

    public void setCorrecta(int correcta) {
        this.correcta = correcta;
    }

    public Pregunta(int idImagen1, int idImagen2, int idImagen3, int idImagen4, int correcta) {
        this.idImagen1 = idImagen1;
        this.idImagen2 = idImagen2;
        this.idImagen3 = idImagen3;
        this.idImagen4 = idImagen4;
        this.correcta = correcta;
    }

}
