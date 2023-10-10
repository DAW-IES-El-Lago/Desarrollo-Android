package com.example.paisesproj;

public class Pregunta {

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    private String pregunta;
        private int idImagen;
        private String opcionA;
        private String opcionB;
        private String opcionC;
        private int respuestaCorrecta;

    // Métodos getter y setter
        public Pregunta(String pregunta, int idImagen, String opcionA, String opcionB, String opcionC, int respuestaCorrecta) {
            this.pregunta = pregunta;
            this.idImagen = idImagen;
            this.opcionA = opcionA;
            this.opcionB = opcionB;
            this.opcionC = opcionC;
            this.respuestaCorrecta = respuestaCorrecta;
        }

    public String getOpcionA() {
        return opcionA;
    }

    public void setOpcionA(String opcionA) {
        this.opcionA = opcionA;
    }

    public String getOpcionB() {
        return opcionB;
    }

    public void setOpcionB(String opcionB) {
        this.opcionB = opcionB;
    }

    public String getOpcionC() {
        return opcionC;
    }

    public void setOpcionC(String opcionC) {
        this.opcionC = opcionC;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
}
