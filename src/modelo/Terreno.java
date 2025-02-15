package modelo;

public class Terreno extends Financiamento {
    private static final long serialVersionUID = 1L;

    private String zonaLocalizacao;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxasJurosaAnuais, String zonaLocalizacao) {
        super(valorImovel, prazoFinanciamento, taxasJurosaAnuais);
        this.zonaLocalizacao = zonaLocalizacao;
    }

    @Override
    public double pagamentoMensal() {
        return super.pagamentoMensal() * 1.02;
    }

    public String getZonaLocalizacao() {
        return zonaLocalizacao;
    }

    public void setZonaLocalizacao(String zonaLocalizacao) {
        this.zonaLocalizacao = zonaLocalizacao;
    }

    public String toString() {
        return String.format("Terreno:\n" +
                        "  Zona de Localização: '%s'\n" +
                        "  Valor do Imóvel: R$%.2f\n" +
                        "  Prazo de Financiamento: %d anos\n" +
                        "  Taxas de Juros Anuais: %.2f%%\n" +
                        "  Pagemento mensal: R$%.2f\n" +
                        "  Pagamento total: R$%.2f \n",
                zonaLocalizacao, valorImovel, prazoFinanciamento, taxasJurosaAnuais, pagamentoMensal(), totPagamento());
    }
}
