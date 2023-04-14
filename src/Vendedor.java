

public class Vendedor extends Empregado implements Salario{
    private double totalDasVendas;
    private double comissao;

    public Vendedor(double totalDasVendas, double comissao) {
        this.totalDasVendas = totalDasVendas;
        this.comissao = comissao;
    }

    public Vendedor() {
        
    }
    
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setTotalDasVendas(double totalDasVendas) {
        this.totalDasVendas = totalDasVendas;
    }

    public double getTotalDasVendas() {
        return totalDasVendas;
    }
    
    public double calcularSalario() {
        return totalDasVendas*comissao;
    }
}
