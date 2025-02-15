package modelo;

public class Apartamento extends Financiamento  {
    private static final long serialVersionUID = 1L;
    private int vagaGaragem;
    private int numeroDoAndar;


    public Apartamento(double valorImovel, int prazoFinanciamento, double taxasJurosaAnuais, int vagaGaragem, int numeroDoAndar) {
        super(valorImovel, prazoFinanciamento, taxasJurosaAnuais);
        this.vagaGaragem = vagaGaragem;
        this.numeroDoAndar = numeroDoAndar;

    }

    @Override
    public double pagamentoMensal() {
        double taxaMensal = taxasJurosaAnuais / 100 / 12;
        double meses = prazoFinanciamento * 12;
        return valorImovel * taxaMensal * Math.pow(1 + taxaMensal, meses) / (Math.pow(1 + taxaMensal, meses) - 1);
    }


    public int getVagaGaragem() {
        return vagaGaragem;
    }

    public int getNumeroDoAndar() {
        return numeroDoAndar;
    }

    public void setVagaGaragem(int vagaGaragem) {
        this.vagaGaragem = vagaGaragem;
    }

    public void setNumeroDoAndar(int numeroDoAndar) {
        this.numeroDoAndar = numeroDoAndar;
    }


    @Override
    public String toString() {
        return String.format("Apartamento:\n" +
                        "  Vaga de Garagem: %d\n" +
                        "  Número do Andar: %d\n" +
                        "  Valor do Imóvel: R$%.2f\n" +
                        "  Prazo de Financiamento: %d anos\n" +
                        "  Taxas de Juros Anuais: %.2f%%\n" +
                        "  Pagamento mensal: R$%.2f\n" +
                        "  Pagamento total: R$%.2f \n",
                vagaGaragem, numeroDoAndar, valorImovel, prazoFinanciamento, taxasJurosaAnuais, pagamentoMensal(), totPagamento());
    }
}