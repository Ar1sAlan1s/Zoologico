import java.util.ArrayList;
import java.util.Scanner;
public class Visitantes {
    private ArrayList<Visitantes> visitante = new ArrayList<>();
    private String nombre;
    private String apellidos;
    private int fechaNacimiento;
    private String CURP;
    private int numVisitas;
    private String fechaRegistro;
    private Scanner sc = new Scanner(System.in);
    public Visitantes(String nombre, String apellidos, int fechaNacimiento, String CURP, String fechaRegistro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.CURP = CURP;
        this.fechaRegistro = fechaRegistro;
    }

    public int getNumVisitas(){
        return numVisitas;
    }
    public void setNumVisistas(int Visitas){
        numVisitas=Visitas;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public int getFechaNacimiento(){
        return fechaNacimiento;
    }
    public String getCURP(){
        return CURP;
    }
    public String getFechaRegistro(){
        return fechaRegistro;
    }
    public ArrayList<Visitantes>getVisitantes(){
        return visitante;
    }
    public void añadirVisitante(Visitantes visitantes){
        visitante.add(visitantes);
    }
    public void eliminarVisitante() {
        System.out.println("Proporcione la CURP del visitante que desea eliminar: ");
        String curp = sc.next();
        int indiceVisitante = buscarVisitantePorCURP(curp);

        if (indiceVisitante != -1) {
            if (visitante.get(indiceVisitante).getNumVisitas() == 0) {
                visitante.remove(indiceVisitante);
                System.out.println("El visitante con la CURP " + curp + " ha sido eliminado exitosamente.");
            } else {
                System.out.println("No se puede eliminar el visitante, ya que tiene visitas registradas.");
            }
        } else {
            System.out.println("No se encontró ningún visitante con esa CURP.");
        }
    }
    public void mostrarVisitantes(){
        for (Visitantes visitantes : visitante){
            System.out.println("-------------------------------");
            System.out.println("|Nombre del Visitante: |" + visitantes.getNombre()
                    + "| Apellidos del Visitante: |" + visitantes.getApellidos()
                    + "| Fecha de Nacimiento: |" + visitantes.getFechaNacimiento()
                    + "| CURP del Visitante: |" + visitantes.getCURP());
            System.out.println("-------------------------------");
        }
    }
    private boolean visitanteValido(int valido){
        if(valido == -1 ){
            return false;
        }
        else{
            return true;
        }
    }
    public int getSubindiceVisitante(){
        int verificacion = -1;
        System.out.println("Proporcione la CURP del visitante: ");
        String curp = sc.next();
        for (int i = 0; i < visitante.size(); i++){
            if(curp.equals(visitante.get(i).CURP)){
                verificacion = i;
                break;
            }
        }
        return verificacion;
    }
    public void getDatosVisitante(){
        if(visitante.isEmpty()){
            System.out.println("No se han añadido visitantes al Sistema.");
        }
        else{
            int i = getSubindiceVisitante();
            if(visitanteValido(i)){
                System.out.println("-------------------------------");
                System.out.println("|Nombre del Visitante: |" + visitante.get(i).getNombre()
                        + "| Apellidos del Visitante: |" + visitante.get(i).getApellidos()
                        + "| Fecha de Nacimiento: |" + visitante.get(i).getFechaNacimiento()
                        + "| CURP del Visitante: |" + visitante.get(i).getCURP()
                        + "| Visitas totales: |"  + visitante.get(i).getNumVisitas());
                System.out.println("-------------------------------");
            }
            else{
                System.out.println("Este visitante no existe.");
            }
        }
    }
    public int buscarVisitantePorCURP(String curp) {
        for (int i = 0; i < visitante.size(); i++) {
            if (curp.equals(visitante.get(i).getCURP())) {
                return i;
            }
        }
        return -1;
    }
    public void aumentarVisitas() {
        System.out.println("Ingrese la CURP del visitante:");
        String curp = sc.next();

        int indiceVisitante = buscarVisitantePorCURP(curp);

        if (indiceVisitante != -1) {
            int visitasActuales = visitante.get(indiceVisitante).getNumVisitas();
            visitante.get(indiceVisitante).setNumVisistas(visitasActuales + 1);
            System.out.println("Visitas actualizadas para el visitante con CURP: " + curp);
        } else {
            System.out.println("No se encontró ningún visitante con esa CURP.");
        }
}

}
