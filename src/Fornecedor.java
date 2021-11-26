import java.util.InputMismatchException;
import java.util.Scanner;

public class Fornecedor implements Verificavel{
	private String razaoSocial; 
	private String nomeFantasia; 
	private String cnpj; 
	private Endereco endereco; 
	private String celular;
	
	public Fornecedor(String razaoSocial, String nomeFantasia, String cnpj, Endereco endereco, String celular) {
		this.razaoSocial=razaoSocial;
		this.nomeFantasia=nomeFantasia;
		this.cnpj=cnpj;
		this.endereco=endereco;
		this.celular=celular;
		
		if(validar(cnpj)==true) {
			this.cnpj=cnpj;
		}
		else {
			solicitarNovo();
		}
	}
	
	@Override
	public String toString() {
		return "Raz�o Social: " + razaoSocial + ", Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj+","+"\n"
				+ "" + endereco + ", Celular: " + celular + "\n";
	}

	@Override
	public boolean validar(String CNPJ) {
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") || CNPJ.equals("22222222222222")
				|| CNPJ.equals("33333333333333") || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
				|| CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") || CNPJ.equals("88888888888888")
				|| CNPJ.equals("99999999999999") || (CNPJ.length() != 14))
			return (false);

		char dig13, dig14;
		int sm, i, r, num, peso;

		// "try" - protege o código para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				// converte o i-ésimo caractere do CNPJ em um número:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posição de '0' na tabela ASCII)
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			// Verifica se os dígitos calculados conferem com os dígitos informados.
			if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
	
	@Override
	public void solicitarNovo() {
		Scanner sc=new Scanner(System.in);
		boolean cnpjerrado=true;
		
		while(cnpjerrado) {
			System.out.println("CNPJ incorreto. Digite novamente: ");
			String novocnpj=sc.next();
			
			if(validar(novocnpj)==true){
				this.cnpj=novocnpj;
				cnpjerrado=false;
			}
			else {
				cnpjerrado=true;
			}
		}
		sc.close();
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}
