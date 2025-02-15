package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxasJurosaAnuais;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxasJurosaAnuais) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxasJurosaAnuais = taxasJurosaAnuais;

    }

    public double pagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxasJurosaAnuais/12));

    }
    public double totPagamento(){
        return pagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public String toString() { return "Financiamento{" + "totaldepagamento=" + totPagamento() + ", valorImovel=" + valorImovel + ", prazoFinanciamento=" + prazoFinanciamento + ", taxasJurosaAnuais=" + taxasJurosaAnuais + '}';
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxasJurosaAnuais() {
        return taxasJurosaAnuais;
    }
}
