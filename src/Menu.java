import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.getRootFrame;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Menu {
    
    public static void abrir() {
        boolean programa = true;
		try {
            do {
                boolean opcS = true;
                int opca = 0;
                do {
                    String aux = "Escolha uma das opções:\n\n";
                    aux += "1. Cadastrar Empregado\n";
                    aux += "2. Cadastrar Cliente\n";
                    aux += "3. Pesquisar\n";
                    aux += "4. Listar Empregados\n";
                    aux += "5. Listar Clientes\n";
                    aux += "6. Remover\n";
                    aux += "7. Finalizar\n";
                    String opc = showInputDialog(aux);

                    if(opc == null) {
                        return;
                    }

                    if(!opc.matches("[0-9]+")) {
                        showMessageDialog(null, "Opção inválida!");
                    
                    }else {
                        
                        opca = parseInt(opc);
                        if(opca < 1 || opca > 7) {
                            showMessageDialog(null, "Opção inválida!");
                        }else {
                            opcS = false;
                        }
                    }	
                }while(opcS);
                
                if(opca == 1) {
                    cadastrarEmpregado();
                }else if(opca == 2) {
                    cadastrarCliente();
                }else if(opca == 3) {
                    pesquisar();
                }else if(opca == 4) {
                    
                }else if(opca == 5) {
                    
                }else if(opca == 6) {
                    
                }else {
                    showMessageDialog(getRootFrame(), "Programa finalizado com sucesso!");
                    break;
                }
            }while(programa);
        } catch (Exception e) {
            showMessageDialog(null, "ERRO\n\nOuve um erro ao executar o programa!\n\nReporte o seguinte erro ao suporte:\n" + e);
        }
    }

    public static void cadastrarEmpregado() {
        boolean opcSb = true;
        int opcab = 0;
        
        String nome = showInputDialog("Qual o nome do empregado?");
        String cpf = showInputDialog("Qual o cpf do empregado?");

        if(nome.length() < 1) {
            showMessageDialog(null, "Nome inválido!");
            return;
        }
        if(cpf.length() < 1) {
            showMessageDialog(null, "CPF inválido!");
            return;
        }

        do {

            String aux = "Qual o cargo do empregado que deseja cadastrar?\n\n";
            aux += "1. Vendedor\n";
            aux += "2. Gerente\n";

            String opcb = showInputDialog(aux);

            if(opcb == null) {
                return;
            }

            if(!opcb.matches("[0-9]+")) {
                showMessageDialog(null, "Opção inválida!");
            }else {
                opcab = parseInt(opcb);
                if(opcab < 1 || opcab > 2) {
                    showMessageDialog(null, "Opção inválida!");
                }else {
                    opcSb = false;
                }
            }	
        }while(opcSb);
        

        if(opcab == 1) {
            String totalDeVendasString = showInputDialog("Qual o total de vendas desse vendedor?");
            double totalDeVendas = 0;
            try {
                totalDeVendas = Double.parseDouble(totalDeVendasString);
            }catch (NumberFormatException e){
                showMessageDialog(null, "Valor do total de vendas inválido!");
                return;
            }
            String comissaoString = showInputDialog("Qual o valor da comissão desse vendedor? (%)");
            double comissao = 0;
            try {
               comissao = Double.parseDouble(comissaoString);
            }catch (NumberFormatException e){
                showMessageDialog(null, "Valor do total de vendas inválido!");
                return;
            }

            Util.cadastrarVendedor(nome, cpf, totalDeVendas, comissao);
            showMessageDialog(null, "Vendedor cadastrado com sucesso!");
        }else {
            String salarioString = showInputDialog("Qual o salário do gerente?");
            double salario = 0;
            try {
                salario = Double.parseDouble(salarioString);
            }catch (NumberFormatException e){
                showMessageDialog(null, "Valor do salário inválido!");
                return;
            }
            String bonusString = showInputDialog("Qual o bonus do gerente? (%)");
            double bonus = 0;
            try {
               bonus = Double.parseDouble(bonusString);
            }catch (NumberFormatException e){
                showMessageDialog(null, "Valor do bonus inválido!");
                return;
            }

            Util.cadastrarGerente(nome, cpf, salario, bonus);
            showMessageDialog(null, "Gerente cadastrado com sucesso!");
        }
    }

    public static void cadastrarCliente() {
        String nome = showInputDialog("Qual o nome do empregado?");
        String cpf = showInputDialog("Qual o cpf do empregado?");

        if(nome.length() < 1) {
            showMessageDialog(null, "Nome inválido!");
            return;
        }
        if(cpf.length() < 1) {
            showMessageDialog(null, "CPF inválido!");
            return;
        }

        String valorDaDividaString = showInputDialog("Qual o valor da dívida desse cliente?");
            double valorDaDivida = 0;
            try {
                valorDaDivida = Double.parseDouble(valorDaDividaString);
            }catch (NumberFormatException e){
                showMessageDialog(null, "Valor da dívida inválido!");
                return;
            }

            Util.cadastrarCliente(nome, cpf, valorDaDivida);


    }

    public static void pesquisar() {
        String cpf = showInputDialog("Qual o CPF que deseja pesquisar? ");
        String aux = "Dados encontrados cadastrados no CPF '" + cpf + "':\n";
        if(Util.pegarPessoa(cpf) != null) {
            aux += Util.pesquisarDados(cpf);
        }else{
            aux += "Nenhuma pessoa encontrada.";
        }

        showMessageDialog(null, aux);

    }
}
