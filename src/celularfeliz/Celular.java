
package celularfeliz;

import celularfeliz.util.StatusCelular;

/**
 *
 * @author alunocmc
 */
public class Celular {
    private int id;
    private String descricao;
    private String observacao;
    private StatusCelular status;

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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public StatusCelular getStatus() {
        return status;
    }

    public void setStatus(StatusCelular status) {
        this.status = status;
    }
    
    

}
