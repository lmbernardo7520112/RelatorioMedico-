import java.time.LocalDate;
import java.time.Period; 
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
  
  public static void main(String[] args) {
	
  Scanner console = new Scanner(System.in);
	String nomePaciente = "";
	String sexo = "";
  double massa = 0.0;
  double peso = 0.0;
	//Date dataAtual = new Date();
	double alturaPaciente = 0.0;
  double imc = 0.0;
  double pesoIdealHomem = 0.0;
  double pesoIdealMulher = 0.0;
	
	// Entrada de Dados
    
  System.out.print("Digite o nome do paciente: ");
  nomePaciente = console.nextLine();
  System.out.print("Digite a data de nascimento do paciente no formato brasileiro (dd-mm-aaaa): ");
    
	String dataNascimento = console.nextLine(); 
  DateTimeFormatter dataNascimentoFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
  LocalDate dataNascimentoConvertida =  LocalDate.parse(dataNascimento, dataNascimentoFormat);
	System.out.print("Digite o sexo do paciente- M para masculino e F para feminino: ");
	sexo = console.nextLine();
  System.out.print("Digite a altura do paciente em metros ");
	alturaPaciente = console.nextDouble();
  System.out.print("Digite a massa do paciente em quilogramas: ");
  massa = console.nextDouble();
  console.close();

  //cálculos
    
  peso =  massa * 9.8;
  imc = (massa/(alturaPaciente*alturaPaciente));
  pesoIdealHomem =  (72.7 * alturaPaciente)-58.00;
  pesoIdealMulher = (62.1 * alturaPaciente)-44.7;

  //conclusão
  System.out.println("RELATÓRIO MÉDICO");
  System.out.println("Nome: " + nomePaciente);
  System.out.println("Sexo: " + sexo);
  System.out.println("Nascimento: " + dataNascimento);
  System.out.println("Idade: " + calculateAge(dataNascimentoConvertida) + " " + "anos");
  System.out.println("Peso: " + String.format("%.2f",peso) + " " + "N" );
  System.out.println("Massa: " + String.format("%.2f",massa) + " " + "Kg" );
  if (imc < 17.00) {
    System.out.println("IMC: " + String.format("%.2f",imc) + " " + "Muito abaixo do peso");
  } else if (imc >= 17 && imc <= 18.49) {
    System.out.println("IMC: " + String.format("%.2f",imc) + " " + "Abaixo do peso");
  } else if (imc >= 18.50 && imc <= 24.99) {
    System.out.println("IMC: " + String.format("%.2f",imc) + " " + "Abaixo do peso");
  } else if (imc >= 25.00 && imc <= 29.99) {
    System.out.println("IMC: " + String.format("%.2f",imc) + " " + "Acima do peso");
  } else if (imc >= 30.00 && imc <= 34.99) {
    System.out.println("IMC: " + String.format("%.2f",imc) + " " + "Obesidade I");
  } else if (imc >= 35.00 && imc <= 39.99) {
    System.out.println("IMC: " + String.format("%.2f",imc) + " " + "Obesidade II (severa)");
  } else if (imc >= 40.00 ) {
    System.out.println("IMC: " + String.format("%.2f",imc) + " " + "Obesidade III (mórbida)");
  } else{
    System.out.println("Um erro ocorreu");
}
  
  if (sexo.equals("M")) {
    System.out.println("Peso Ideal: " + String.format("%.2f",pesoIdealHomem) + " " + "Kg");
  } else if (sexo.equals("F")) {
    System.out.println("Peso Ideal: " + String.format("%.2f",pesoIdealMulher) +  " " +  "Kg");
  } else {
    System.out.println("Um erro ocorreu");
  }
}
  
  
  public static int calculateAge(LocalDate dataNascimentoConvertida)   
{  
//creating an instance of the LocalDate class and invoking the now() method      
//now() method obtains the current date from the system clock in the default time zone      
LocalDate curDate = LocalDate.now();  
//calculates the amount of time between two dates and returns the years  
if ((dataNascimentoConvertida != null) && (curDate != null))   
{  
return Period.between(dataNascimentoConvertida, curDate).getYears();  
}  
else  
{  
return 0;  
}  
}
}