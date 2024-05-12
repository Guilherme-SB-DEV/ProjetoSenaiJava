package main;
import static sql.DAOS.DAO_Cuidador.consultaCuidador;
import java.util.Scanner;
import static sql.DAOS.DAO_Paciente.consultaPaciente;
import static sql.DAOS.DAO_Paciente.deletePaciente;
import static sql.DAOS.DAO_Paciente.insertPaciente;
import users.Usr;
import users.UsrCuidador;
import users.UsrPaciente;
public class Main extends Usr{
    public static void main(String[] args){
        // TODO code application logic here
        int counter = 0;
//        Scanner input = new Scanner(System.in);
//        System.out.println("cpf: ");
//        String cpfInput = input.next();
//        System.out.println("senha: ");
//        String senhaInput = input.next();
        //(tipoContrato, cpf, nomePerfil, especialidade, periodo, senha)
        //insertCuidador("clt","12312312312", "henrique", "especialidade", "tarde", "senhacuidador");
        //(nomePerfil, cpf, descrição, ddd, numero, senha)
//        insertPaciente("a","65656", "necessidade2", "72", "numero", 69,"senhapaciente");
//        deletePaciente(5);
//        deletePaciente(4);
//        deletePaciente(3);
        for(UsrPaciente usrPaciente: consultaPaciente()){
            System.out.println(consultaPaciente().get(counter).getNome());
            System.out.println(consultaPaciente().get(counter).getDescricaoNecessidades());
            System.out.println(consultaPaciente().get(counter).getIdade());
            System.out.println(consultaPaciente().get(counter).getCpf());
            System.out.println(consultaPaciente().get(counter).getCidade());
            System.out.println(consultaPaciente().get(counter).getBairro());
            System.out.println(consultaPaciente().get(counter).getSenhaPaciente());
            counter++;
        }
        //updateCuidador(1, "nome", "nome_teste");
//        deleteCuidador(1);
//        deleteCuidador(2);
//        deleteCuidador(3);
//        deleteCuidador(4);
//        for(UsrCuidador usrCuidador: consultaCuidador()){
//            System.out.println(consultaCuidador().get(counter).getNome());
//            System.out.println(consultaCuidador().get(counter).getDescricaoEspecialidade());
//           System.out.println(consultaCuidador().get(counter).getPeriodo());
//           System.out.println(consultaCuidador().get(counter).getTipoContrato());
//            System.out.println(consultaCuidador().get(counter).getCpf());
//            System.out.println(consultaCuidador().get(counter).getSenha());
//            counter++;
//        }
//        
//        System.out.println("resultado: "+ login(cpfInput, senhaInput));
//               
//                
//               
    }
    public static boolean login (String cpf, String senha){
        int counterLogin=0;
        boolean result= false;
        for(UsrCuidador usrCuidador: consultaCuidador()){
            if(consultaCuidador().get(counterLogin).getCpf().equals(cpf) && consultaCuidador().get(counterLogin).getSenha().equals(senha)){
                result = true;
                
            }else{
                result = false;
            }
            
            counterLogin++;
        }
        return result;
        
    }


}
