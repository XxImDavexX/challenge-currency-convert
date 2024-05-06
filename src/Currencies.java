public class Currencies {
    private String baseCurrency;
    private String  targetCurrency;
    private double amount;
    private double valueBaseCurrency;
    private double totalTargetCurrency;

    public Currencies(DataCurrencies dataCurrencies){
        this.baseCurrency = dataCurrencies.base_code();
        this.targetCurrency = dataCurrencies.target_code();
        this.valueBaseCurrency = dataCurrencies.conversion_rate();
        this.totalTargetCurrency = dataCurrencies.conversion_result();
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getTargetCurrency() {
        return this.targetCurrency;
    }

    public double getAmount() {
        return this.amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getValueBaseCurrency() {
        return this.valueBaseCurrency;
    }

    public double getTotalTargetCurrency() {
        return this.totalTargetCurrency;
    }

    @Override
    public String toString(){
        return this.baseCurrency + ": " + this.amount +
                "\n"+ this.targetCurrency + " value for $1 " + this.baseCurrency + ": $" + this.valueBaseCurrency +
                "\nTotal "+ this.targetCurrency + ": $" + this.totalTargetCurrency;
    }


}
