public class Hospede {
	private String CPF;
	private String RG;
	private String nome;
	private String idade;
	private String endereco;

	public Hospede(){

	}

	public Hospede(String c, String r, String n, String i, String e){
		CPF = c;
		RG = r;
		nome = n;
		idade = i;
		endereco = e;
	}

	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cpf) {
		CPF = cpf;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rg) {
		RG = rg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean validaNome(String n){
		if(n.matches("[A-Z][a-z]*"))
			return true;
		else 
			return false;	
	}
}
