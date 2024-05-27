public class Worker {
    private String name;
    private double grossSalary;
    private double inssDiscount;
    private int numberOfDependents;
    private double totalDeductions;
    private String cpf;
    private String cep;
    private String address;

    public Worker(String name, double grossSalary, double inssDiscount, int numberOfDependents, double totalDeductions, String cpf, String cep) {
        this.name = name;
        this.grossSalary = grossSalary;
        this.inssDiscount = inssDiscount;
        this.numberOfDependents = numberOfDependents;
        this.totalDeductions = totalDeductions;
        this.cpf = cpf;
        this.cep = cep;
    }

    public double calculateNetSalary() {
        double irrf = calculateIRRF();
        return grossSalary - inssDiscount - irrf;
    }

    private double calculateIRRF() {
        double baseCalc = grossSalary - inssDiscount - (numberOfDependents * 189.59);
        baseCalc -= totalDeductions;

        if (baseCalc <= 1903.98) return 0;
        if (baseCalc <= 2826.65) return baseCalc * 0.075 - 142.80;
        if (baseCalc <= 3751.05) return baseCalc * 0.15 - 354.80;
        if (baseCalc <= 4664.68) return baseCalc * 0.225 - 636.13;
        return baseCalc * 0.275 - 869.36;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getInssDiscount() {
        return inssDiscount;
    }

    public void setInssDiscount(double inssDiscount) {
        this.inssDiscount = inssDiscount;
    }

    public int getNumberOfDependents() {
        return numberOfDependents;
    }

    public void setNumberOfDependents(int numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    public double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + ";" + grossSalary + ";" + inssDiscount + ";" + numberOfDependents + ";" + totalDeductions + ";" + cpf + ";" + cep + ";" + address;
    }
}
