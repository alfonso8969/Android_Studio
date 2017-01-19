package es.cice.vehiculoslistview.model;

/**
 * Created by cice on 19/1/17.
 */

public class Vehiculo {
    private String modelo,fabricante,descripcion;
    private int icon,image;

    public Vehiculo(String descripcion,String fabricante, int icon, int image, String modelo) {
        this.descripcion = descripcion;
        this.fabricante = fabricante;
        this.icon = icon;
        this.image = image;
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
