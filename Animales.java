import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class Animales {
    Scanner leer=new Scanner(System.in);
    Random ran=new Random();
    ArrayList<Animales> Animales = new ArrayList<>();
    private String TipoDeAnimal;
    private String FechaDeNacimiento;
    private String FechaLlegada;
    private float Peso;
    private String FrecuenciaDeAlimentacion;
    private String tiposDeAlimentacion;
    private int id;
    public int getId() {
        return id;
    }
    public String getVacunas() {
        return Vacunas;
    }

    private String Vacunas;

    public Animales() {

    }

    public Animales(String TipoDeAnimal,int id, String fechaDeNacimiento, String fechaLlegada, float peso, String frecuenciaDeAlimentacion, String tiposDeAlimentacion, String Vacunas,ArrayList Enfermedades) {
        this.TipoDeAnimal = TipoDeAnimal;
        this.id=id;
        this.FechaDeNacimiento = fechaDeNacimiento;
        this.FechaLlegada = fechaLlegada;
        this.Peso = peso;
        this.FrecuenciaDeAlimentacion = frecuenciaDeAlimentacion;
        this.tiposDeAlimentacion = tiposDeAlimentacion;
        this.Vacunas = Vacunas;
    }

    public String getTipoDeAnimal() {
        return TipoDeAnimal;
    }

    public String getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public String getFechaLlegada() {
        return FechaLlegada;
    }

    public float getPeso() {
        return Peso;
    }


    public String getFrecuenciaDeAlimentacion() {
        return FrecuenciaDeAlimentacion;
    }

    public String getTiposDeAlimentacion() {
        return tiposDeAlimentacion;
    }

    public void ValidarId(int id){
        for (int i=0;i<Animales.size();i++){
            if(Animales.get(i).getId()==id){
                id= ran.nextInt(10)+1;
                i=0;
            }
        }

    }

    public void RegistrarAnimal() {
        System.out.print("Ingrese tipo de Animal:");
        String tipodeanimal=leer.nextLine();
        int id= ran.nextInt(10)+1;
        ValidarId(id);
        System.out.print("\nIngrese fecha de nacimiento con el formato Dia/Mes/Año:");
        String fechadenacimiento=leer.nextLine();
        System.out.print("\nIngrese Fecha de llegada con el formato Dia/Mes/Año:");
        String FechaDellegada=leer.nextLine();
        System.out.print("\nIngrese peso:");
        float peso=leer.nextFloat();
        leer.nextLine();
        System.out.print("\nIngrese Frecuencia de alimentacion:");
        String frecuenciadealimentacion=leer.nextLine();
        System.out.print("\nIngrese tipos de alimentacion:");
        String tiposdealimentacion=leer.nextLine();
        System.out.print("\nTiene vacunas 'Si' No tiene vacunas 'No':");
        String Vacunas=leer.nextLine();
        ArrayList<String>Enfermedades=new ArrayList<>();
        System.out.print("\nIngrese enfermedades, cuando acabe ingrese Fin:");
        String enfermedad=leer.nextLine();
        while(enfermedad.equals("Fin")){
            Enfermedades.add(enfermedad);
            System.out.print("Ingrese enfermedad:");
            enfermedad=leer.nextLine();
            System.out.println();
        }
        Animales Animal =new Animales(tipodeanimal,id,fechadenacimiento,FechaDellegada,peso,frecuenciadealimentacion,tiposdealimentacion,Vacunas,Enfermedades);
        Animales.add(Animal);
    }

    public void MostrarAnimales() {
        for (int i = 0; i < Animales.size(); i++) {
            System.out.printf("Tipo de animal:%S\nSu id:%d\nFecha de nacimiento:%s\nFecha de llegada\nPeso:%f\nFrecuencia de alimentacion:%S\nTipos de alimentacion:%s\nVacunas:%s\n", Animales.get(i).getTipoDeAnimal(),Animales.get(i).getId(),Animales.get(i).getFechaDeNacimiento(),Animales.get(i).getFechaLlegada(), Animales.get(i).getPeso(),Animales.get(i).getFrecuenciaDeAlimentacion(),Animales.get(i).getTiposDeAlimentacion(), Animales.get(i).getVacunas());

        }
    }
}
