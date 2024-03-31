import java.util.ArrayList;

public class Animales {
    ArrayList<Animales> Animales = new ArrayList<>();
    private String TipoDeAnimal;
    private String FechaDeNacimiento;
    private String FechaLlegada;
    private float Peso;
    private int size = 0;
    private String[] Enfermedades = new String[size];
    private String FrecuenciaDeAlimentacion;
    private String tiposDeAlimentacion;
    private boolean Vacunas;

    public Animales() {

    }

    public Animales(String TipoDeAnimal, String fechaDeNacimiento, String fechaLlegada, float peso, int size, String[] enfermedades, String frecuenciaDeAlimentacion, String tiposDeAlimentacion, Boolean vacunas) {
        this.TipoDeAnimal = TipoDeAnimal;
        this.FechaDeNacimiento = fechaDeNacimiento;
        this.FechaLlegada = fechaLlegada;
        this.Peso = peso;
        this.size = size;
        this.FrecuenciaDeAlimentacion = frecuenciaDeAlimentacion;
        this.tiposDeAlimentacion = tiposDeAlimentacion;
        this.Vacunas = vacunas;
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

    public int getSize() {
        return size;
    }

    public String[] getEnfermedades() {
        return Enfermedades;
    }

    public String getFrecuenciaDeAlimentacion() {
        return FrecuenciaDeAlimentacion;
    }

    public String getTiposDeAlimentacion() {
        return tiposDeAlimentacion;
    }

    public boolean isVacunas() {
        return Vacunas;
    }

    public void RegistrarAnimal(Animales animal) {
        Animales.add(animal);
    }

    public void MostrarAnimales() {
        for (int i = 0; i < Animales.size(); i++) {
            System.out.printf("Tipo de animal:%S\n");
        }
    }
}
