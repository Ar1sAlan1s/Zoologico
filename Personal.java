import java.util.ArrayList;
public class Personal {
    ArrayList<Personal> Personal =new ArrayList<>();
    private String name;
    private String apellido;
    private  String FechaDeNacimiento;
    private  String RFC;
    private  double Salario;
    private  String rol;
    private String FechaDeIngreso;
    private String CURP;
    private String horario;
    public Personal(){

    }
    public Personal(String name,String apellido,String FechaDeNacimiento,String RFC,double Salario,String rol,String FechaDeIngreso,String CURP,String horario){
        this.name=name;
        this.apellido=apellido;
        this.FechaDeNacimiento=FechaDeNacimiento;
        this.RFC=RFC;
        this.Salario=Salario;
        this.rol=rol;
        this.FechaDeIngreso=FechaDeIngreso;
        this.CURP=CURP;
        this.horario=horario;


    }


    public String getName() {
        return name;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public String getRFC() {
        return RFC;
    }

    public double getSalario() {
        return Salario;
    }

    public String getRol() {
        return rol;
    }

    public String getFechaDeIngreso() {
        return FechaDeIngreso;
    }

    public String getCURP() {
        return CURP;
    }

    public String getHorario() {
        return horario;
    }

    public void RegistrarEmpleado(Personal Empleado){
        Personal.add(Empleado);
    }

    public void MostrarEmpleados(){
        for (int i = 0; i < Personal.size(); i++){
            System.out.printf("Su nombre;%s\nSu Apellido:%s\nSu Fecha de Nacimiento;%s\nSu RFC:%s\nSu salario:%.2f\nSu rol:%s\nSu Fecha de ingreso;%s\nSu CURP:%s\nSu Horario;%s\n############################\n",Personal.get(i).getName(),Personal.get(i).getApellido(),Personal.get(i).getFechaDeNacimiento(),Personal.get(i).getRFC(),Personal.get(i).getSalario(),Personal.get(i).getRol(),Personal.get(i).getFechaDeIngreso(),Personal.get(i).getCURP(),Personal.get(i).getHorario());
        }
    }





}
