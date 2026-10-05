package celularfeliz;

import celularfeliz.util.StatusCelular;
import celularfeliz.util.StatusOrdemServico;
import celularfeliz.util.StatusServico;
import java.util.List;

public class OrdemServico {
    private int id;
    private Cliente cliente;
    private Celular celular;
    private List<Servico> servicos;
    private Funcionario funcionario;
    private double valorOrcamento;
    private StatusOrdemServico status;
    private String observacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
        System.out.println("Adicionado celular " + celular.getDescricao() + " do cliente " + cliente.getNome() + " à Ordem de Serviço.");
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getValorOrcamento() {
        return valorOrcamento;
    }

    public void setValorOrcamento(double valorOrcamento) {
        this.valorOrcamento = valorOrcamento;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        System.out.println("Status da ordem de serviço alterado para: " + status);
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void adicionarServico(Servico servico) {
        servico.setStatus(StatusServico.INCLUIDO);
        servicos.add(servico);

        System.out.println("Serviço " + servico.getDescricao() + " será realizado por: " + funcionario.getNome() + ", cargo: " + funcionario.getCargo());
    };

    public void removerServico(Servico servico) {
        servicos.remove(servico);
    };

    public void aprovarOrcamento() {
        if (status == StatusOrdemServico.ANALISANDO) {
            setStatus(StatusOrdemServico.APROVADO);

            celular.setStatus(StatusCelular.BLOQUEADO);
        }
    }

    public void reprovarOrcamento() {
        if (status == StatusOrdemServico.ANALISANDO) {
            setStatus(StatusOrdemServico.REPROVADO);

            celular.setStatus(StatusCelular.LIBERADO);
        }
    }

    public void calcularValorOrcamento() {
        this.valorOrcamento = 0.0d;

        for (Servico servico : servicos) {
            if (servico.getStatus() == StatusServico.INCLUIDO) {
                this.valorOrcamento += servico.getValorBase();
            }
        }
    }
}
