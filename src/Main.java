import java.util.*;
import celularfeliz.*;
import celularfeliz.util.StatusCelular;
import celularfeliz.util.StatusOrdemServico;
import celularfeliz.util.StatusServico;

public class Main {
    public static void main(String[] args) {


        // 1. Inicializaçao do cenário de teste:
        //  a. cliente chega com celular (cliente possui celular)
        //  b. temos um funcionario (criar um funcionario)
        //  c. uma OS é criada -> status ANALISANDO
        //  d. incluir serviços com o status INCLUIDO na OS

        // 2. Orçamento
        //  a. Calcular orçamento -> soma dos valores dos serviços
        //  b. Orçamento deve ser aprovado ou reprovado de acordo com o cliente
        
        // 2.1 Orçamento aprovado
        //  a. Celular fica bloqueado
        //  b. Servicos são executados -> status EXECUTANDO e depois CONCLUIDO
        //  c. Pagamento é efetuado
        //  d. Celular é liberado

        // 2.2 Orçamento reprovado (nao pode executar serviços)
        //  a. Celular é liberado
        
        
        var cliente = new Cliente();
        cliente.setNome("João da Silva");
        cliente.setCpf("123.456.789-00");
        cliente.setTelefone("(11) 98765-4321");

        var celular = new Celular();
        celular.setId(1);
        celular.setStatus(StatusCelular.LIBERADO);

        var funcionario = new Funcionario();
        funcionario.setNome("Maria");
        funcionario.setCargo("Técnica de Celulares");

        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setId(1);
        ordemServico.setCliente(cliente);
        ordemServico.setFuncionario(funcionario);
        ordemServico.setCelular(celular);
        ordemServico.setStatus(StatusOrdemServico.ANALISANDO);
        ordemServico.setServicos(new ArrayList<>());

        var servico1 = new Servico();
        servico1.setValorBase(100.0);
        servico1.setDescricao("Conserto de tela");
        ordemServico.adicionarServico(servico1);

        var servico2 = new Servico();
        servico2.setValorBase(50.0);
        servico2.setDescricao("Troca de bateria");
        ordemServico.adicionarServico(servico2);

        ordemServico.calcularValorOrcamento();

        System.out.println("Ordem de Serviço ID: " + ordemServico.getId());
        System.out.println("Valor do Orçamento: R$ " + ordemServico.getValorOrcamento());
        System.out.println("Deseja aprovar o orçamento? (S/N)");
        Scanner scanner = new Scanner(System.in);

        // Lê a resposta do usuário e valida se é "S" ou "N"
        String resposta = scanner.nextLine();
        while (!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N")) {
            System.out.println("Resposta inválida. Digite 'S' para sim ou 'N' para não.");
            resposta = scanner.nextLine();
        }
        scanner.close();

        if (resposta.equalsIgnoreCase("S")) {
            // Muda o status da OS pra APROVADO
            // Muda o status do celular pra LIBERADO
            ordemServico.aprovarOrcamento();

            for (Servico servico : ordemServico.getServicos()) {
                if (servico.getStatus() == StatusServico.INCLUIDO) {
                    servico.executarServico();
                    servico.concluirServico();
                }
            }

            Pagamento pagamento = new Pagamento();
            ordemServico = pagamento.efetuarPagamento(ordemServico); 
            System.out.println("Ordem de Serviço finalizada com sucesso!");          
        } else {
            // Muda o status da OS pra REPROVADO
            // Muda o status do celular pra LIBERADO
            ordemServico.reprovarOrcamento();
            System.out.println("Ordem de Serviço reprovada.");
        }
        
        System.out.println("Status final do Celular: " + ordemServico.getCelular().getStatus());
    }
}
