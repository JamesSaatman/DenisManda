package Sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BD_Novo {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/cadastro_novo?useSSL=false";
		String usuario = "root";
		String senha = "Aluno123";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		}
		else {
			return false;
		}
	}
	public void listarContatos() {
		try {
		String query = "SELECT * FROM cadastro ORDER BY nome";
		this.resultset = this.statement.executeQuery(query);
		while(this.resultset.next()) {
			System.out.println("ID: " + this.resultset.getString("id") 
			+ "- NOME: " + this.resultset.getString("nome")
			+ "- CPF: " + this.resultset.getString("cpf")
			+ "- RG: " + this.resultset.getString("rg")
			+ "- NASCIMENTO: " + this.resultset.getString("nascimento")
			+ "- GENERO: " + this.resultset.getString("genero")
			+ "- TELEFONE: " + this.resultset.getString("telefone")
			+ "- EMAIL: " + this.resultset.getString("email")
			+ "- ENDEREÇO: " + this.resultset.getString("endereco")
			+ "- NÚMERO: " + this.resultset.getString("numero")
			+ "- COMPLEMENTO: " + this.resultset.getString("complemento")
			+ "- BAIRRO: " + this.resultset.getString("bairro")
			+ "- CIDADE: " + this.resultset.getString("cidade")
			+ "- ESTADO: " + this.resultset.getString("estado")
			+ "- CEP: " + this.resultset.getString("cep")
			+ "- PAI: " + this.resultset.getString("nome_pai")
			+ "- MÃE: " + this.resultset.getString("nome_mae"));
		 }
	 }
	catch(Exception e) {
		System.out.println("Error: " + e.getMessage());	
		}
	}
	
	public void inserirContato(String nome, String cpf, String rg, String nascimento, String genero, String telefone, String email, String endereco, String numero,  String complemento, String bairro, String cidade, String estado, String cep, String nome_pai, String nome_mae  ) {
		try {
			String query = "INSERT INTO cadastro(nome, cpf, rg, nascimento, genero, telefone, email, endereco, numero, complemento, bairro, cidade, estado, cep, nome_pai, nome_mae) "
					+ "values ('"+nome+"','"+cpf+"', '"+rg+"', '"+nascimento+"', '"+genero+"', '"+telefone+"', '"+email+"', '"+endereco+"', '"+numero+"', '"+complemento+"', '"+bairro+"', '"+cidade+"', '"+estado+"', '"+cep+"', '"+nome_pai+"', '"+nome_mae+"' );";
			this.statement.executeUpdate(query);
			System.out.println("Contato inserido!");
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	public void editarContato(Integer id, String nome, String cpf, String rg, String nascimento, String genero, String telefone, String email, String endereco, String numero,  String complemento, String bairro, String cidade, String estado, String cep, String nome_pai, String nome_mae) {
		try {
			String query = "UPDATE contato SET nome = '"+nome+"','"+cpf+"', '"+rg+"', '"+nascimento+"', '"+genero+"', '"+telefone+"', '"+email+"', '"+endereco+"', '"+numero+"', '"+complemento+"', '"+bairro+"', '"+cidade+"', '"+estado+"', '"+cep+"', '"+nome_pai+"', '"+nome_mae+"' where id = "+id+";";
			this.statement.executeUpdate(query);
			System.out.println("Contato Atualizado!");
			
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	public void apagarContato(String id) {
		try {
			String query= "DELETE FROM contato where id = "+id+";";
			this.statement.executeUpdate(query);
			System.out.println("Contato Dropado");
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			this.connection.close();
		}
		catch(Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	
 }
