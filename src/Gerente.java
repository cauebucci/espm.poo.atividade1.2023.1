

public class Gerente extends Empregado implements Bonus{
    private double salario;
    private double bonus;

    public Gerente(double salario, double bonus) {
        this.salario = salario;
        this.bonus = bonus;
    }

    public Gerente() {
       
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public double calcularBonus() {
        return salario*bonus;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    
}
