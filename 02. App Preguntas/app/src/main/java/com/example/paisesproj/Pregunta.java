package com.example.paisesproj;

public class Pregunta {
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    private String pregunta;
    private int idPregunta;
    private int idImagen;
    private int idOpcion1;
    private int idOpcion2;
    private int idOpcion3;
    private int idRespuestaCorrecta;

    public Pregunta(int idPregunta, int idImagen, int idOpcion1, int idOpcion2, int idOpcion3, int idRespuestaCorrecta) {
        this.idPregunta = idPregunta;
        this.idImagen = idImagen;
        this.idOpcion1 = idOpcion1;
        this.idOpcion2 = idOpcion2;
        this.idOpcion3 = idOpcion3;
        this.idRespuestaCorrecta = idRespuestaCorrecta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public int getIdOpcion1() {
        return idOpcion1;
    }

    public void setIdOpcion1(int idOpcion1) {
        this.idOpcion1 = idOpcion1;
    }

    public int getIdOpcion2() {
        return idOpcion2;
    }

    public void setIdOpcion2(int idOpcion2) {
        this.idOpcion2 = idOpcion2;
    }

    public int getIdOpcion3() {
        return idOpcion3;
    }

    public void setIdOpcion3(int idOpcion3) {
        this.idOpcion3 = idOpcion3;
    }

    public int getIdRespuestaCorrecta() {
        return idRespuestaCorrecta;
    }

    public void setIdRespuestaCorrecta(int idRespuestaCorrecta) {
        this.idRespuestaCorrecta = idRespuestaCorrecta;
    }
}
