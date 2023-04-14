

public class Cliente extends Pessoa {
    private double valorDaDivida;

    public Cliente(double valorDaDivida) {
        this.valorDaDivida = valorDaDivida;
    }
    public Cliente() {
        
    }

    public void setValorDaDivida(double valorDaDivida) {
        this.valorDaDivida = valorDaDivida;
    }

    public double getValorDaDivida() {
        return valorDaDivida;
    }
}
