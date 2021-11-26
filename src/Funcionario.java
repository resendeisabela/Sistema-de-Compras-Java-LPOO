import java.util.InputMismatchException;

public class Funcionario extends Pessoa{
	private float sal;
	private String funcao;
	
	public Funcionario(String nome, String cpf, Endereco endereco, String celular, float sal, String funcao) {
	super(nome, cpf, endereco, celular);	
	try {
		this.sal=sal;
	}catch(InputMismatchException e) {
		System.out.println("Valor inv�lido");
	}
	this.funcao=funcao;
	}
	
	@Override
	public String toString(){
		return "Nome do funcion�rio: "+getNome()+"\nCPF: "+getCpf()+"\nCelular: "+getCelular()+"\nFun��o: "+this.funcao+"\nSal�rio: "+this.sal+"\n";
	}

}
