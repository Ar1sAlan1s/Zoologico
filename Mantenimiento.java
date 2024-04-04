public class Mantenimiento {
    Personal empleado=new Personal();
    Animales animal=new Animales();
    int ID;
    String observaciones;
    String fechaDeMantenimento;
    String ProcesoQuSeRealizo;
    public Mantenimiento(Personal empleado, int ID, String procesoRealizado, String ProcesoQueSeRealizo, String fechaDeMantenimento){
        this.empleado=empleado;
        this.ID=ID;
        this.ProcesoQuSeRealizo=ProcesoQueSeRealizo;
        this.fechaDeMantenimento=fechaDeMantenimento;

    }

}