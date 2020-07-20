package program;

import java.util.Scanner;

import entities.Usuario;

public class Lol {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in).useDelimiter("\r\n");		
		int acaoDigitada = 0;
		Usuario usuario1 = new Usuario();

		do {
			System.out.println("#BEM VINDO AO LOL");

			System.out.println(
					"o que deseja fazer?\n" + "Registrar usuarios, digite: 1\n" + "ver todos os usuarios, digite : 2\n"
							+ "excluir um usuario, digite : 3\n" + "para consultar um usuario digite : 4 \n" + "digite outro numero para sair do sistema\n");
			System.out.println("----------------------");
			acaoDigitada = sc.nextInt();

			if (acaoDigitada == 1) {
				usuario1.cadastrarUsuario();
			}
			if (acaoDigitada == 2) {
				usuario1.listarUsuario();
			}
			if (acaoDigitada == 3) {
				usuario1.removerUsuario();
			}
			if (acaoDigitada == 4) {
				usuario1.consultaUsuario();
			}
			
			usuario1.descobrirIdadeDoUsuario();
			acaoDigitada = usuario1.novoMenu();

		} while (acaoDigitada != 1 && acaoDigitada != 2 && acaoDigitada != 3 && acaoDigitada != 4);
		sc.close();
	}

}
