import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorkerDatabase workerDatabase = new WorkerDatabase();

        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("Salário Bruto: ");
        double grossSalary = scanner.nextDouble();

        System.out.print("Desconto INSS: ");
        double inssDiscount = scanner.nextDouble();

        System.out.print("Número de Dependentes: ");
        int numberOfDependents = scanner.nextInt();

        System.out.print("Valor Total de Descontos para Dedução IRRF: ");
        double totalDeductions = scanner.nextDouble();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        if (!CPFValidator.isValid(cpf)) {
            System.out.println("CPF inválido.");
            return;
        }

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        String address = CEPService.getAddress(cep);

        Worker worker = new Worker(name, grossSalary, inssDiscount, numberOfDependents, totalDeductions, cpf, cep);
        worker.setAddress(address);

        workerDatabase.addOrUpdateWorker(worker);

        System.out.println("Salário Líquido: " + worker.calculateNetSalary());
        System.out.println("Endereço: " + worker.getAddress());
    }
}
