package modelo;

import util.AcresimoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    private static final long serialVersionUID = 1L;

    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxasJurosaAnuais, double areaConstruida, double areaTerreno) {
        super(valorImovel, prazoFinanciamento, taxasJurosaAnuais);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    private void validarAcrescimo(double valorJuros, double valorAcrescimo) throws AcresimoMaiorDoQueJurosException {
        if (valorAcrescimo > valorJuros) {
            throw new AcresimoMaiorDoQueJurosException(
                    "O acréscimo (" + valorAcrescimo + ") não pode ser maior que os juros (" + valorJuros + ")."
            );
        }
    }


    @Override
    public double pagamentoMensal() {
        double juros = super.pagamentoMensal() - (valorImovel / (prazoFinanciamento * 12));
        double acrescimo = 80;

        try {
            validarAcrescimo(juros, acrescimo);
        } catch (AcresimoMaiorDoQueJurosException e) {
            System.out.println("Erro: " + e.getMessage());
            acrescimo = juros;
        }

        return super.pagamentoMensal() + acrescimo;
    }

    @Override
    public String toString() {
        return String.format("Casa:\n" +
                        "  Área Construída: %.2fm²\n" +
                        "  Área do Terreno: %.2fm²\n" +
                        "  Valor do Imóvel: R$%.2f\n" +
                        "  Prazo de Financiamento: %d anos\n" +
                        "  Taxas de Juros Anuais: %.2f%%\n" +
                        "  Pagamento mensal: R$%.2f\n" +
                        "  Pagamento total: R$%.2f \n" ,
                areaConstruida, areaTerreno, valorImovel, prazoFinanciamento, taxasJurosaAnuais, pagamentoMensal(), totPagamento());
    }
}

