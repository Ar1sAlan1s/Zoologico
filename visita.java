import java.util.ArrayList;
public class visita {
    ArrayList<visita> ListaDeVisitas=new ArrayList<>();
    public String fechaDeRecorrido;
    Personal guia = new Personal();
    Visitantes visitante = new Visitantes("", " ", 0, " ", " ");
    double costoTotal;
    int NumDeNiños, NumDeAdultos;
    ArrayList<Visitantes> ListaDeVisitantesEnRecorrido=new ArrayList<>();

    public visita(String fechaDeRecorrido, Personal guia, double costoTotal,int numDeAdultos, int numDeNiños) {
        this.fechaDeRecorrido=fechaDeRecorrido;
        this.guia=guia;
        this.costoTotal=costoTotal;
        Visitantes visitante1 = visitante;
    }
    public  void agregarVisitantesARecorrido(Visitantes visitante){
        ListaDeVisitantesEnRecorrido.add(visitante);
    }
    //getters and setters
    public ArrayList<Visitantes> getListaDeVisitantesEnRecorrido() {
        return ListaDeVisitantesEnRecorrido;
    }

    public void setListaDeVisitantesEnRecorrido(ArrayList<Visitantes> listaDeVisitantesEnRecorrido) {
        ListaDeVisitantesEnRecorrido = listaDeVisitantesEnRecorrido;
    }

}