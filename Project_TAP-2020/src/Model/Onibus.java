package Model;

public class Onibus {

    private int idOnibus, capacidadeMax, prioridade;
    private String tipo; //Tipo do onibus
    private String stituacao = "V"; // C = cheio | V = vazio

    public Onibus(int idOnibus) {
        this.idOnibus = idOnibus;
    }

    public Onibus() {
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public int getIdOnibus() {
        return idOnibus;
    }

    public void setIdOnibus(int idOnibus) {
        this.idOnibus = idOnibus;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getStituacao() {
        return stituacao;
    }

    public void setStituacao(String stituacao) {
        this.stituacao = stituacao;
    }

}
