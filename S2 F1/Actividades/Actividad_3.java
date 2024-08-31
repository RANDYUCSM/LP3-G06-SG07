public class Automovil{
    private String marca;
    private String modelo;
    private int numPuertas;
    private String placa;
    private Motor motor;

    public Automovil(String placa,int nPuertas,String marca,String modelo){
        this.placa = placa;
        this.numPuertas = nPuertas;
        this.marca = marca;
        this.modelo = modelo;
    }
    public String  getPlaca(){
        return placa;
    }
    public String  getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public  int getNumPuertas(){
        return numPuertas;
    }
    public  void setPlaca(String placa){
        this.placa = placa;
    }
    public   void setMarca(String marca){
        this.marca = marca;
    }
    public   void setModelo(String modelo){
        this.modelo = modelo;
    }
    public    void setNumPuertas(int numPuertas){
        this.numPuertas = numPuertas;
    }
