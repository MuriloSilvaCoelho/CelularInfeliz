/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package celularfeliz;

import celularfeliz.util.StatusCelular;
import celularfeliz.util.StatusPagamento;

/**
 *
 * @author jmmur
 */
public class Pagamento {
    private StatusPagamento status;

    public OrdemServico efetuarPagamento(OrdemServico ordemServico) {
        // Simula o processo de pagamento
        System.out.println("Processando pagamento no valor de R$ " + ordemServico.getValorOrcamento() + "...");
        status = StatusPagamento.AGUARDANDO;
        
        try {
            Thread.sleep(3000); // Simula delay de 3 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        status = StatusPagamento.EFETUADO;
        System.out.println("Pagamento efetuado com sucesso!");
        
        ordemServico.getCelular().setStatus(StatusCelular.LIBERADO);
        ordemServico.setObservacao("Ordem de Serviço finalizada!");
        return ordemServico;
    }

    public StatusPagamento getStatus() {
        return status;
    }

}