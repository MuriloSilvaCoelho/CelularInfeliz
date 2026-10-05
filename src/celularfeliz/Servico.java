/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package celularfeliz;

import celularfeliz.util.StatusServico;

/**
 *
 * @author alunocmc
 */
public class Servico {
    private int id;
    private String descricao;
    private double valorBase;
    private Categoria categoria;
    private StatusServico status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public StatusServico getStatus() {
        return status;
    }

    public void setStatus(StatusServico status) {
        this.status = status;
    }

    public void executarServico() {
        if (status == StatusServico.INCLUIDO) {
            setStatus(StatusServico.EXECUTANDO);
        }
        System.out.println("Serviço " + descricao + " está sendo executado.");
    }

    public void concluirServico() {
        if (status == StatusServico.EXECUTANDO) {
            setStatus(StatusServico.CONCLUIDO);
        }
        System.out.println("Serviço " + descricao + " foi concluído.");
    }
}
