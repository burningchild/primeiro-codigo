package validadores;

import java.util.List;
import java.util.Scanner;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

public class ValidadorCPF {

   public static boolean valida(String cpf) {
     
        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
        if (erros.size() > 0) {
            System.out.println(erros);
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o cpf");
        String cpf = scanner.next();

        System.out.println(valida(cpf));
        scanner.close();

    }
}