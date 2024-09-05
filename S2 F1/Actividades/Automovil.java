public class Automovil {
    private String placa;
    private int numPuertas;
    private String marca;
    private String modelo;
    private Motor motor;

    public Automovil(String placa, int numPuertas, String marca, String modelo) {
        this.placa = placa;
        this.numPuertas = numPuertas;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = null;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public String mostrarInfo() {
        return "Placa: " + placa + ", Puertas: " + numPuertas + ", Marca: " + marca + ", Modelo: " + modelo +", Motor: " + (motor != null ? motor.mostrarInfo() : "Sin motor");
    }
}  
//
public class Motor {
    private int numMotor;
    private int revPorMin;

    public Motor(int numMotor, int revPorMin) {
        this.numMotor = numMotor;
        this.revPorMin = revPorMin;
    }

    public int getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(int numMotor) {
        this.numMotor = numMotor;
    }

    public int getRevPorMin() {
        return revPorMin;
    }

    public void setRevPorMin(int revPorMin) {
        this.revPorMin = revPorMin;
    }
    public String mostrarInfo() {
        return "Número Motor: " + numMotor + ", RPM: " + revPorMin;
    }
}
//
public class TestAgregacion {
    public static void main(String[] args) {
        Motor motor1 = new Motor(7898, 1000);
        Motor motor2 = new Motor(5942, 1500);

        Automovil auto1 = new Automovil("ABC-123", 4, "Ford", "Fiesta");
        auto1.setMotor(motor1);

        Automovil auto2 = new Automovil("GVC-584", 4, "Toyota", "Corolla");
        auto2.setMotor(motor2);

        System.out.println("Automóvil 1: " + auto1.mostrarInfo());
        System.out.println("Automóvil 2: " + auto2.mostrarInfo());
    }
}