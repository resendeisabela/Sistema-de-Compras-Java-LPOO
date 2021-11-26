import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		List<Endereco> enderecos= new ArrayList<Endereco>();
		enderecos.add(new Endereco("Avenida Costa e Silva", 2182, "Pioneiros", "Campo Grande", "79071081"));
		enderecos.add(new Endereco("Rua da Libra", 602, "Vila Carlota", "Campo Grande","79094320" ));
		enderecos.add(new Endereco("Rua Afonso Pena", 3504, "Jardim dos Estados", "Campo Grande", "79020120"));
		enderecos.add(new Endereco("Avenida Paulista", 39, "Baixo Augusta", "S�o Paulo", "04059060"));
		enderecos.add(new Endereco("Rod. Celso Garcia Cid", 5600, "Gleba Fazenda Palhano", "Londrina", "86050482"));
		enderecos.add(new Endereco("Av. Dr. Mauro Lindemberg Monteiro", 628, "Santa F�", "Osasco", "06045330"));
		
		List<Funcionario> funcionarios=new ArrayList<Funcionario>();
		funcionarios.add(new Funcionario("Luisa Santos", "69647122160", enderecos.get(0), "97651-0371", 1650.00f, "Gerente"));
		funcionarios.add(new Funcionario("Manuela Carneiro", "69098916198", enderecos.get(1), "98927-7418", 1192.50f, "Atendente de caixa"));

		List<Cliente> clientes=new ArrayList<Cliente>();
		clientes.add(new Cliente("Jo�o Oliveira", "26310476130", enderecos.get(2), "97268-2084"));
		clientes.add(new Cliente("Pedro Neto", "34394445116", enderecos.get(3), "98131-2987"));

		List<Fornecedor> fornecedores=new ArrayList<Fornecedor>();
		fornecedores.add(new Fornecedor("Pandurata Alimentos Ltda.", "Bauducco", "49033004001803", enderecos.get(4), "99135-7785"));
		fornecedores.add(new Fornecedor("Nestle Brasil Ltda", "Nestle", "60409075000152", enderecos.get(5), "99726-9466"));
		
		List<Produto> produtos=new ArrayList<Produto>();
		produtos.add(new Produto("Chocottone", 20.00f, fornecedores.get(0)));
		produtos.add(new Produto("Cesta da Natal Grande", 301.50f, fornecedores.get(0)));
		produtos.add(new Produto("Panettone", 17.00f, fornecedores.get(0)));
		produtos.add(new Produto("Chocottone Bites", 11.50f, fornecedores.get(0)));
		produtos.add(new Produto("Biscoito Choco Biscuit", 4f, fornecedores.get(0)));
		produtos.add(new Produto("Chocolate Suflair 20 uni.", 76.50f, fornecedores.get(1)));
		produtos.add(new Produto("Caixa de Bombom", 9f, fornecedores.get(1)));
		produtos.add(new Produto("Achocolatado Nescau", 7.50f, fornecedores.get(1)));
		produtos.add(new Produto("Kit Kat Nestl� Chocolate Cl�ssico ao Leite 24 uni.", 80f, fornecedores.get(1)));
		produtos.add(new Produto("Chocolate em p� Galak", 8.50f, fornecedores.get(1)));
        
		
		System.out.print("Bem vindo ao programa. Seleciona a op��o que deseja\n");
		while(true) {
			System.out.println("[1] Endere�os");
			System.out.println("[2] Funcionarios");
			System.out.println("[3] Clientes");
			System.out.println("[4] Fornecedores");
			System.out.println("[5] Cadastrar produtos");
			System.out.println("[6] Comprar");
			System.out.println("[7] Sair");
			
			int op=sc.nextInt();
			//sc.nextLine();
			
			if(op==1) {
				try {
				for(int i=0; i<enderecos.size(); i++) {
					System.out.println(enderecos.get(i));
				}
				System.out.print("\nEstes s�o os endere�os cadastrados atualmente. Deseja cadastrar um novo? (S/N) ");
				String op1=sc.next();
				sc.nextLine();
				
				if(op1.equals("S") || op1.equals("s")){
					System.out.print("Rua: ");
					String rua=sc.nextLine();
					System.out.print("N�mero: ");
					int num=sc.nextInt();
					sc.nextLine();
					System.out.print("Bairro: ");
					String bairro=sc.nextLine();
					System.out.print("Cidade: ");
					String cidade=sc.nextLine();
					System.out.print("CEP: ");
					String cep=sc.nextLine();
					
					enderecos.add(new Endereco(rua, num, bairro, cidade, cep));
			} //if op1
				}catch(InputMismatchException e) {
					System.out.println("Entrada inv�lida, tente novamente");
				}
			
		}//if op
			
			if(op==2) {
				try {
				for(int i=0; i<funcionarios.size(); i++) {
					System.out.println(funcionarios.get(i));
				}
				System.out.print("\nEstes s�o os funcion�rios cadastrados atualmente. Deseja cadastrar um novo? (S/N) ");
				String op2=sc.next();
				sc.nextLine();
				if(op2.equals("S") || op2.equals("s")){
					int numend=0;
					System.out.print("Nome: ");
					String nomefun=sc.nextLine();
					System.out.print("CPF: ");
					String cpffun=sc.next();
					for(int i=0; i<enderecos.size(); i++) {
						System.out.println("["+(i+1)+"] "+enderecos.get(i));
					}
					System.out.print("O endere�o do funcion�rio j� est� cadastrado? (S/N) ");
					String op22=sc.next();
					if(op22.equals("S") || op22.equals("s")) {
					System.out.print("Digite o n�mero do endere�o correto: ");
					numend=sc.nextInt(); }
					else if(op22.equals("N") || op22.equals("n")) {
						sc.nextLine();
						System.out.print("Rua: ");
						String rua=sc.nextLine();
						System.out.print("N�mero: ");
						int num=sc.nextInt();
						sc.nextLine();
						System.out.print("Bairro: ");
						String bairro=sc.nextLine();
						System.out.print("Cidade: ");
						String cidade=sc.nextLine();
						System.out.print("CEP: ");
						String cep=sc.next();
						
						enderecos.add(new Endereco(rua, num, bairro, cidade, cep));
					}
					sc.nextLine();
					System.out.print("N�mero de telefone: ");
					String numfun=sc.nextLine();
					System.out.print("S�lario: ");
					float sal=sc.nextFloat();
					sc.nextLine();
					System.out.print("Fun��o: ");
					String funcao=sc.nextLine();
					
					if(numend>0){
					funcionarios.add(new Funcionario(nomefun, cpffun,enderecos.get(numend-1),numfun, sal, funcao));}
					else {
						funcionarios.add(new Funcionario(nomefun, cpffun,enderecos.get(enderecos.size()-1),numfun, sal, funcao)); }
			}
				}catch(InputMismatchException e) {
					System.out.println("Entrada inv�lida, tente novamente");
				}
			
		}//if op
			
			if(op==3) {
				try {
				for(int i=0; i<clientes.size(); i++) {
					System.out.println(clientes.get(i));
				}
				System.out.print("\nEstes s�o os clientes cadastrados atualmente. Deseja cadastrar um novo? (S/N) ");
				String op3=sc.next();
				sc.nextLine();
				if(op3.equals("S") || op3.equals("s")){
					int numendcli=0;
					System.out.print("Nome: ");
					String nomecli=sc.nextLine();
					System.out.print("CPF: ");
					String cpfcli=sc.next();
					for(int i=0; i<enderecos.size(); i++) {
						System.out.println("["+(i+1)+"] "+enderecos.get(i));
					}
					System.out.print("O endere�o do cliente j� est� cadastrado? (S/N) ");
					String op33=sc.next();
					if(op33.equals("S") || op33.equals("s")) {
						System.out.print("Digite o n�mero do endere�o correto: ");
					numendcli=sc.nextInt(); }
					else if(op33.equals("N") || op33.equals("n")) {
						sc.nextLine();
						System.out.print("Rua: ");
						String rua=sc.nextLine();
						System.out.print("N�mero: ");
						int num=sc.nextInt();
						sc.nextLine();
						System.out.print("Bairro: ");
						String bairro=sc.nextLine();
						System.out.print("Cidade: ");
						String cidade=sc.nextLine();
						System.out.print("CEP: ");
						String cep=sc.next();
						
						enderecos.add(new Endereco(rua, num, bairro, cidade, cep));
					}
					sc.nextLine();
					System.out.print("N�mero de telefone: ");
					String numcli=sc.nextLine();
					
					if(numendcli>0){
					clientes.add(new Cliente(nomecli, cpfcli,enderecos.get(numendcli-1),numcli));}
					else {
						clientes.add(new Cliente(nomecli, cpfcli,enderecos.get(enderecos.size()-1),numcli)); }
				
			}
				}catch(InputMismatchException e){
					System.out.println("Entrada inv�lida, tente novamente");
				}

	}//if op3
			if(op==4) {
				try {
				for(int i=0; i<fornecedores.size(); i++) {
					System.out.println(fornecedores.get(i));
				}
				System.out.print("\nEstes s�o os fornecedores cadastrados atualmente. Deseja cadastrar um novo? (S/N) ");
				String op4=sc.next();
				sc.nextLine();
				if(op4.equals("S") || op4.equals("s")){
					int numendfor=0;
					System.out.print("Raz�o social: ");
					String razaos=sc.nextLine();
					System.out.print("Nome fantasia: ");
					String nomefan=sc.nextLine();
					System.out.print("CNPJ: ");
					String cnpj=sc.next();
					for(int i=0; i<enderecos.size(); i++) {
						System.out.println("["+(i+1)+"] "+enderecos.get(i));
					}
					System.out.print("O endere�o do fornecedor j� est� cadastrado? (S/N) ");
					String op44=sc.next();
					if(op44.equals("S") || op44.equals("s")) {
					System.out.print("\nDigite o n�mero do endere�o correto: ");
					numendfor=sc.nextInt(); }
					else if(op44.equals("N") || op44.equals("n")) {
						sc.nextLine();
						System.out.print("Rua: ");
						String rua=sc.nextLine();
						System.out.print("N�mero: ");
						int num=sc.nextInt();
						sc.nextLine();
						System.out.print("Bairro: ");
						String bairro=sc.nextLine();
						System.out.print("Cidade: ");
						String cidade=sc.nextLine();
						System.out.print("CEP: ");
						String cep=sc.next();
						
						enderecos.add(new Endereco(rua, num, bairro, cidade, cep));
					}
					sc.nextLine();
					System.out.print("N�mero de telefone: ");
					String numfor=sc.nextLine();
					
					if(numendfor>0){
					fornecedores.add(new Fornecedor(razaos, nomefan,cnpj,enderecos.get(numendfor-1),numfor));}
					else {
						fornecedores.add(new Fornecedor(razaos, nomefan, cnpj,enderecos.get(enderecos.size()-1),numfor)); }
			}
			}catch(InputMismatchException e) {
				System.out.println("Entrada inv�lida, tente novamente");
			}
			}
				if(op==5) {
					try {
					for(int i=0; i<produtos.size(); i++) {
						System.out.println(produtos.get(i));
					}
					System.out.print("\nEstes s�o os produtos cadastrados atualmente. Deseja cadastrar um novo? (S/N) ");
					String op5=sc.next();
					sc.nextLine();
					if(op5.equals("S") || op5.equals("s")){
						int numendfor=0;
						System.out.print("Nome do produto: ");
						String nomeprod=sc.nextLine();
						System.out.print("Valor: ");
						float valorprod=sc.nextFloat();
						sc.nextLine();
						for(int i=0; i<fornecedores.size(); i++) {
							System.out.println("["+(i+1)+"] "+fornecedores.get(i));
						}
						System.out.print("O fornecedor j� est� cadastrado? (S/N) ");
						String op55=sc.next();
						if(op55.equals("S") || op55.equals("s")) {
						System.out.print("Digite o n�mero do fornecedor correto: ");
						numendfor=sc.nextInt(); }
						else if(op55.equals("N") || op55.equals("n")) {
							sc.nextLine();
							System.out.print("Raz�o social: ");
							String razaos=sc.nextLine();
							System.out.print("Nome fantasia: ");
							String nomefan=sc.nextLine();
							System.out.print("CNPJ: ");
							String cnpj=sc.next();
							System.out.println("Endere�o:\n");
							System.out.print("Rua: ");
							String rua=sc.nextLine();
							System.out.print("N�mero: ");
							int num=sc.nextInt();
							sc.nextLine();
							System.out.print("Bairro: ");
							String bairro=sc.nextLine();
							System.out.print("Cidade: ");
							String cidade=sc.nextLine();
							System.out.print("CEP: ");
							String cep=sc.next();
							
							enderecos.add(new Endereco(rua, num, bairro, cidade, cep));
							System.out.print("N�mero de telefone: ");
							String numfor=sc.nextLine();
							fornecedores.add(new Fornecedor(razaos, nomefan, cnpj,enderecos.get(enderecos.size()-1),numfor));
						}
						if(numendfor>0){
							produtos.add(new Produto(nomeprod, valorprod, fornecedores.get(numendfor-1)));}
							else {
								produtos.add(new Produto(nomeprod, valorprod, fornecedores.get(fornecedores.size()-1)));}
					}
				}catch(InputMismatchException e) {
					System.out.println("Entrada inv�lida, tente novamente");
				}
				}
				if(op==6) {
					try {
					for(int i=0; i<funcionarios.size(); i++) {
						System.out.println("["+(i+1)+"] "+funcionarios.get(i));
					}
					System.out.print("Selecione o funcion�rio que ir� processar a compra: ");
					int idfun=sc.nextInt();
					for(int i=0; i<clientes.size(); i++) {
						System.out.println("["+(i+1)+"] "+clientes.get(i));
					}
					System.out.print("Selecione o cliente que ir� realizar a compra: ");
					int idcli=sc.nextInt();
					Compra compra1 = new Compra(funcionarios.get(idfun-1), clientes.get(idcli-1));
					
					System.out.print("Digite a quantidade de produtos que ser�o comprados: ");
					int quantprod=sc.nextInt();
					for(int i=0; i<produtos.size(); i++) {
						System.out.println("["+(i+1)+"] "+produtos.get(i));
					}
					System.out.print("Informe os produtos a serem adicinados no carrinho: ");
					for(int i=0; i<quantprod; i++) {
						int numprod=sc.nextInt();
						compra1.adicionarProduto(produtos.get(numprod-1));
					}
					compra1.listarCompra();
				}catch(InputMismatchException e) {
						System.out.println("Entrada inv�lida, tente novamente");
					}
				}

				if(op==7) {
					break;
				}
				if(op>=8) {
					System.out.print("Essa fun��o n�o est� no menu, digite novamente a op��o desejada\n");
				}
}
		sc.close();
}
}


