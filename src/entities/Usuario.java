package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import validadores.ValidadorCPF;
import validadores.ValidadorEmail;

public class Usuario {

	private String id;
	private String nome;
	private String email;
	private String rp;
	private String elo;
	private String cpf;

	Scanner sc = new Scanner(System.in).useDelimiter("\r\n");
	Scanner sc2 = new Scanner(System.in).useDelimiter("\r\n");
	List<Usuario> listaDeDadosDoUsuario = new ArrayList<>();

	public Usuario() {

	}

	public Usuario(String id, String nome, String email, String rp, String elo, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.rp = rp;
		this.elo = elo;
		this.cpf = cpf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRp() {
		return rp;
	}

	public void setRp(String rp) {
		this.rp = rp;
	}

	public String getElo() {
		return elo;
	}

	public void setElo(String elo) {
		this.elo = elo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void cadastrarUsuario() {
		ValidadorEmail emailUsuario = new ValidadorEmail();
		ValidadorCPF validadorCPF = new ValidadorCPF();

		System.out.print("quantos usuarios serão registrados? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Usuario Numero " + (i + 1) + "#");
			System.out.println("digite o id da conta: ");
			while (!sc.hasNextInt()) {
				System.out.println("Numero incorreto. Tente novamente por favor");
				sc.next();
			}
			String id = sc.next();
			if (!id.matches("[0-9]*")) {
				System.out.println("id invalido, só pode digitar numeros");
			}
			System.out.println("digite o nome da conta: ");
			while (!sc.hasNext("[a-zA-Z]*")) {
				System.out.println("Nome incorreto. Tente novamente por favor");
				sc.next();
			}
			String nome = sc.next();
			if (!nome.matches("[a-zA-Z]*")) {
				System.out.println("nome invalido, só pode digitar letras");
			}
			System.out.println("digite o email da conta: ");
			String email = sc2.next();

			boolean isEmailIdValid = emailUsuario.validar(email);

			while (!isEmailIdValid) {
				System.out.println("Email invalido, tente novamente");
				String novoEmailDigitado = sc2.next();
				isEmailIdValid = emailUsuario.validar(novoEmailDigitado);
			}
			System.out.println("digite a quantidade de rp da conta: ");
			String rp = sc.next();
			System.out.println("digite o elo da conta: ");
			String elo = sc.next();

			System.out.println("digite um cpf valido");
			String cpf = sc.next();
			boolean isValid = validadorCPF.valida(cpf);

			while (!isValid) {
				System.out.println("CPF incorreto. Tente novamente por favor");
				String novoValorDigitado = sc.next();
				isValid = validadorCPF.valida(novoValorDigitado);
			}

			Usuario user = new Usuario(id, nome, email, rp, elo, cpf);
			listaDeDadosDoUsuario.add(user);
		}

	}

	public void listarUsuario() {

		System.out.println("----------------------");
		if (listaDeDadosDoUsuario.size() == 0) {
			System.out.println("não possui usuarios cadastrados! ");
			System.out.println("----------------------");
			System.out.println();
		} else {
			for (Usuario usuario : listaDeDadosDoUsuario) {
				System.out.println("------------------------");
				System.out.println("USUARIO N# " + usuario.getId());
				System.out.println("NOME # " + usuario.getNome());
				System.out.println("EMAIL # " + usuario.getEmail());
				System.out.println("RP # " + usuario.getRp());
				System.out.println("ELO # " + usuario.getElo());
				System.out.println("CPF # " + usuario.getCpf());
				System.out.println("------------------------");

			}

		}

	}

	public void removerUsuario() {

		int indice = 0;
		if (listaDeDadosDoUsuario.size() == 0) {
			System.out.println("não pode excluir oq não existe! ");
		} else {
			System.out.println("----------------------");

			for (Usuario usuario : listaDeDadosDoUsuario) {
				System.out.println(usuario.getNome());
			}
			// metodo para buscar um usuario
			System.out.println("digite o nome do usuario a ser deletado ");
			String nomeAserDeletado = sc.next();
			for (Usuario usuario : listaDeDadosDoUsuario) {
				if (usuario.getNome().equals(nomeAserDeletado)) {
					indice = listaDeDadosDoUsuario.indexOf(usuario);
				}

			}

			listaDeDadosDoUsuario.remove(indice);

		}
		
	}
	
	public int novoMenu() {
		System.out.println("Ainda deseja fazer algo?");
		System.out.println("digite 5 para voltar ao menu inicial");
		System.out.println("digite qualquer outro numero para sair do sistema ");
		int acaoDigitada = sc.nextInt();
		
		return acaoDigitada;
	}

	public void consultaUsuario() {
		if(listaDeDadosDoUsuario.size() <= 0) {
			System.out.println("não existem usuarios cadastrados no momento. ");
		} else {
		System.out.println("Digite o usuario a ser procurado");
		String nome = sc.next();
		
		for (int i = 0; i < listaDeDadosDoUsuario.size(); i++) {
			if (listaDeDadosDoUsuario.get(i).getNome().equals(nome)) {
				System.out.println("nome achado. O seu indice é :" + listaDeDadosDoUsuario.indexOf(listaDeDadosDoUsuario.get(i)));
				}
			}
		}

	}

}
