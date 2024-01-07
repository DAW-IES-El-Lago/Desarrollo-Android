package com.melaku.reproductor_multimedia;

public class Musica {
    private int nombreCancion;
    private int posicion;
    private int img;
    private int sonido;

    public Musica(int nombreCancion,  int img, int sonido) {
        this.nombreCancion = nombreCancion;
        this.img = img;
        this.sonido = sonido;
    }

    public int getSonido() {
        return sonido;
    }

    public void setSonido(int sonido) {
        this.sonido = sonido;
    }

    public int getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(int nombreCancion) {
        this.nombreCancion = nombreCancion;
    }



    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
