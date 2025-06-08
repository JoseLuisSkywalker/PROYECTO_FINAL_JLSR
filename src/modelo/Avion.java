package modelo;

public class Avion {
    private int numeroRegistro;
    private String modeloAvion;
    private int capacidadPeso;

    private int calificacionExamen1;
    private String nssTecnico1;
    private String nombreTecnico1;
    private String fechaExamen1;
    private int tiempoAire1;

    private int calificacionExamen2;
    private String nssTecnico2;
    private String nombreTecnico2;
    private String fechaExamen2;
    private int tiempoAire2;

    public Avion(){

    }

    public Avion(int numeroRegistro, String modeloAvion, int capacidadPeso,
                 int calificacionExamen1, String nssTecnico1, String nombreTecnico1, String fechaExamen1, int tiempoAire1,
                 int calificacionExamen2, String nssTecnico2, String nombreTecnico2, String fechaExamen2, int tiempoAire2) {

        this.numeroRegistro = numeroRegistro;
        this.modeloAvion = modeloAvion;
        this.capacidadPeso = capacidadPeso;

        this.calificacionExamen1 = calificacionExamen1;
        this.nssTecnico1 = nssTecnico1;
        this.nombreTecnico1 = nombreTecnico1;
        this.fechaExamen1 = fechaExamen1;
        this.tiempoAire1 = tiempoAire1;

        this.calificacionExamen2 = calificacionExamen2;
        this.nssTecnico2 = nssTecnico2;
        this.nombreTecnico2 = nombreTecnico2;
        this.fechaExamen2 = fechaExamen2;
        this.tiempoAire2 = tiempoAire2;
    }


    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getModeloAvion() {
        return modeloAvion;
    }

    public void setModeloAvion(String modeloAvion) {
        this.modeloAvion = modeloAvion;
    }

    public int getCapacidadPeso() {
        return capacidadPeso;
    }

    public void setCapacidadPeso(int capacidadPeso) {
        this.capacidadPeso = capacidadPeso;
    }

    public int getCalificacionExamen1() {
        return calificacionExamen1;
    }

    public void setCalificacionExamen1(int calificacionExamen1) {
        this.calificacionExamen1 = calificacionExamen1;
    }

    public String getNssTecnico1() {
        return nssTecnico1;
    }

    public void setNssTecnico1(String nssTecnico1) {
        this.nssTecnico1 = nssTecnico1;
    }

    public String getNombreTecnico1() {
        return nombreTecnico1;
    }

    public void setNombreTecnico1(String nombreTecnico1) {
        this.nombreTecnico1 = nombreTecnico1;
    }

    public String getFechaExamen1() {
        return fechaExamen1;
    }

    public void setFechaExamen1(String fechaExamen1) {
        this.fechaExamen1 = fechaExamen1;
    }

    public int getTiempoAire1() {
        return tiempoAire1;
    }

    public void setTiempoAire1(int tiempoAire1) {
        this.tiempoAire1 = tiempoAire1;
    }

    public int getCalificacionExamen2() {
        return calificacionExamen2;
    }

    public void setCalificacionExamen2(int calificacionExamen2) {
        this.calificacionExamen2 = calificacionExamen2;
    }

    public String getNssTecnico2() {
        return nssTecnico2;
    }

    public void setNssTecnico2(String nssTecnico2) {
        this.nssTecnico2 = nssTecnico2;
    }

    public String getNombreTecnico2() {
        return nombreTecnico2;
    }

    public void setNombreTecnico2(String nombreTecnico2) {
        this.nombreTecnico2 = nombreTecnico2;
    }

    public String getFechaExamen2() {
        return fechaExamen2;
    }

    public void setFechaExamen2(String fechaExamen2) {
        this.fechaExamen2 = fechaExamen2;
    }

    public int getTiempoAire2() {
        return tiempoAire2;
    }

    public void setTiempoAire2(int tiempoAire2) {
        this.tiempoAire2 = tiempoAire2;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "numeroRegistro=" + numeroRegistro +
                ", modeloAvion='" + modeloAvion + '\'' +
                ", capacidadPeso=" + capacidadPeso +
                ", calificacionExamen1=" + calificacionExamen1 +
                ", nssTecnico1='" + nssTecnico1 + '\'' +
                ", nombreTecnico1='" + nombreTecnico1 + '\'' +
                ", fechaExamen1='" + fechaExamen1 + '\'' +
                ", tiempoAire1=" + tiempoAire1 +
                ", calificacionExamen2=" + calificacionExamen2 +
                ", nssTecnico2='" + nssTecnico2 + '\'' +
                ", nombreTecnico2='" + nombreTecnico2 + '\'' +
                ", fechaExamen2='" + fechaExamen2 + '\'' +
                ", tiempoAire2=" + tiempoAire2 +
                '}';
    }




}
