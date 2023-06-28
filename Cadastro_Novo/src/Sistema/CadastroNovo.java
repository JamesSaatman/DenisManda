package Sistema;
import java.util.*;

public class CadastroNovo {

	public static void main(String[] args) {
		BD_Novo bDados = new BD_Novo();
		Scanner input = new Scanner(System.in);
		bDados.conectar();
		if(bDados.estaConectado()) {

			String nome = null;
			  while(true) {
				
				  	System.out.print("Digite seu nome: ");
					nome = input.nextLine();
					try {
					Integer.parseInt(nome);
					System.out.println("Digite um nome não numeros");
				}
			    catch(Exception e) {
			    	break;
			    }
			  }	
			  
			  
			  String cpf = null;
			  while(true) {
			      
				  System.out.print("Digite seu CPF: ");
				  cpf = input.nextLine();
				  try {
					  Long.parseLong(cpf);
					  if(cpf.length() == 11) {
						  break;
					  }
					  else {
						System.out.println("CPF inválido. Digite o CPF com 11 números");	  
					   }
				  }catch(Exception e) {
					  System.out.println("Digite somente numeros");
				  }
				  
			  }
			/*System.out.print("Digite seu CPF: ");
		    String  cpf = input.nextLine();*/
			
			  
			  
			  String rg = null;
			  while(true) {
			      System.out.print("Digite seu RG: ");
				  rg = input.nextLine();
				  try {
					  Long.parseLong(rg);
					  if(rg.length() <=13 && rg.length() >3) {
						  break;
					  }
					  else {
						  System.out.println("RG invalido");
					  }
				  }catch(Exception e) {
					  System.out.println("Digite somente números");
				  }
				  
			 } 
			
			
			  String nascimento = null;
				 while (true){
					  System.out.print("Digite seu data de nascimento: ");
					  nascimento = input.nextLine();
					  try {
						  Long.parseLong(nascimento);
						  System.out.println("Digite a data no formato: AAAA-MM-DD");
					  }catch(Exception e) {
						  if(nascimento.length() == 10) {
							  break;
						  }
						  else {
							System.out.println("Data de nascimento inválida.");	  
						   }
					  }
				 }
			
			
			
			System.out.print("Digite seu gênero: ");
			String genero = input.nextLine();
			System.out.print("Digite seu telefone: ");
			String telefone = input.nextLine();
			System.out.print("Digite seu e-mail: ");
			String email = input.nextLine();
			System.out.print("Digite o nome da rua ou logradouro: ");
			String endereco = input.nextLine();
			System.out.print("Digite o número: ");
			String numero = input.nextLine();
			System.out.print("Digite o complemento: ");
			String complemento = input.nextLine();
			System.out.print("Digite o bairro: ");
			String bairro = input.nextLine();
			System.out.print("Digite a cidade: ");
			String cidade = input.nextLine();
			System.out.print("Digite a sigla da UF: ");
			String estado = input.nextLine();
			System.out.print("Digite o CEP: ");
			String cep = input.nextLine();
			System.out.print("Digite o nome do pai: ");
			String nome_pai = input.nextLine();
			System.out.print("Digite o nome da mãe: ");
			String nome_mae = input.nextLine();
			bDados.inserirContato(nome, cpf, rg, nascimento, genero, telefone, email, endereco, numero, complemento, bairro, cidade, estado, cep, nome_pai, nome_mae);
			//bDados.editarContato(null, nome, cpf, rg, nascimento, genero, telefone, email, endereco, numero, complemento, bairro, cidade, estado, cep, nome_pai, nome_mae);
			bDados.listarContatos();
			bDados.desconectar();
	
		}
		else {
			System.out.println("Não foi possível conectar ao banco de dados.");
		}
	}

}