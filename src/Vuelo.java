public class Vuelo{
    private String numero;
    private String origen;
    private String destino;
    private int capacidadMaxima;
    private Asiento[] asientos; 

    //CONSTRUCTORES

    public Vuelo(){
    }

    public Vuelo(String numero, String origen, String destino){
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;

    }

    public Vuelo(String numero, String origen, String destino, int capacidadMaxima){
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.capacidadMaxima = capacidadMaxima;
        // El vuelo crea sus propios asientos - composicion
        asientos = new Asiento[capacidadMaxima];
        for (int i = 0, i < capacidadMaxima; i++){
            asientos[i] = new Asiento("A" + (i + 1)); 
        }
    }

    //getters

    public String getNumero(){
        return numero;
    }

    public String getOrigen(){
        return origen;
    }

    public String getDestino(){
        return destino;
    }

    //METODOS

    public void mostrarInfo(){
        System.out.println("----- Vuelo " + numero + "----");
        System.out.println("Ruta: " + origen + "-> " + destino);
        System.out.println("Capacidad: " + capacidadMaxima + " asientos");
    }

    //muestra el estado de cada asiento
    public void mostrarAsientos(){
        System.out.println("Estado de asientos - vuelo" + numero + ": ");
        for (Asiento a : asientos){
            a.mostrarEstado();
        }
    }

    //busca un asiento por codigo y lo busca
    public void embarcar(String codigoAsiento){
        for (Asiento a : asientos){
            if (a.getCodigo().equals(codigoAsiento)){
                a.ocupar();
                return;
            }
        }

    }


}