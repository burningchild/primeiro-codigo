package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Usuario;

public class TesteListas {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Usuario usuario = new Usuario();
		usuario.setNome("Marcos");
		
		List<String> jogadores = new ArrayList<>();
		
		List<Usuario> user = new ArrayList<>();
		jogadores.add("Enos");
		jogadores.add("Pedro");
		jogadores.add("Marcos");
		jogadores.add("Random");
		
		
		for(int i=0; i<jogadores.size();i++) {
			System.out.println(jogadores.get(i));
			
		}
		for(int i=0; i<jogadores.size(); i++) {
			// == só para comparar tipos primitivos
			//equals = para comparar objetos
			// jogadores.get(i) == 'Marcos'{
			if(jogadores.get(i).equals("Marcos")) {
				System.out.println("marcos existe");
			} else {
				System.out.println("sumiu");
			}
		}
		System.out.println("Digite o nome a ser procurado");
		String nome = scanner.next();
		for(int i=0; i<jogadores.size(); i++) {
			if(jogadores.get(i).equals(nome)) {
				System.out.println("nome achado. O seu indice é :"+ jogadores.get(i));
			} 
		}
		
	
	
		scanner.close();	
		
	}
	
	

}
