import java.util.ArrayList;
public class Visitantes {
    private ArrayList<Visitantes> visitante = new ArrayList<>();
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String CURP;
    private int numVisitas;
    private String fechaRegistro;

    public Visitantes(String nombre, String apellidos, String fechaNacimiento, String CURP, String fechaRegistro) {
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
  public String getFechaNacimiento(){
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
    public void incrementarNumVisistas(int subIndiceVisitante){
      int visitas = visitante.get(subIndiceVisitante).getNumVisitas();
      visitas++;
      visitante.get(subIndiceVisitante).setNumVisistas(visitas);
  }
   public int getSubindiceVisitante(String curp){
        int subIndice = 0;
         for(int i = 0; i <= visitante.size(); i++){
            if(visitante.get(i).getCURP().equalsIgnoreCase(curp)){
                subIndice = i;
            }
            else {
                subIndice =-1;
            }
        }
        return subIndice;
 }
}