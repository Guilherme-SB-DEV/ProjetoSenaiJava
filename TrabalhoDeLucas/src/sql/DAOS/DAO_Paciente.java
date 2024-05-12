package sql.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import static sql.Conexao.open;
import users.UsrPaciente;

public class DAO_Paciente {
    public static String instrucao_selectPaciente = "SELECT * FROM usuariopaciente;";
    public static String instrucao_insertPaciente = "INSERT INTO usuariopaciente( NomePerfil, Cpf, DescricaoNecessidades, ddd, numero, idadePaciente, senhaPaciente) VALUES (?,?,?,?,?,?,?);";
    public static String instrucao_deletePaciente = "DELETE FROM usuariopaciente WHERE IDPaciente = ?;";

        public static List<UsrPaciente> consultaPaciente(){
            try{
                List<UsrPaciente> arrayPaciente = new LinkedList<>(); //inicia arrayList de usuarios
                Connection con = open(); //abre conexão
                Statement sentenca = con.createStatement();
                ResultSet rs = sentenca.executeQuery(instrucao_selectPaciente); //executa query
                while(rs.next()){
                    
                    UsrPaciente usrPaciente = new UsrPaciente(); //inicia isntancia de usuario
                    
                    //seta os dados da query como dados do objeto usuario
                    usrPaciente.setNome(rs.getString("NomePerfil"));
                    usrPaciente.setCpf(rs.getString("Cpf"));
                    usrPaciente.setDescricaoNecessidade(rs.getString("DescricaoNecessidades"));
                    usrPaciente.setDdd(rs.getString("ddd"));
                    usrPaciente.setNumero(rs.getString("numero"));
                    usrPaciente.setIdade(rs.getString("idadePaciente"));
                    usrPaciente.setSenhaPaciente(rs.getString("senhaPaciente"));
                    //add objeto no arrayList
                    arrayPaciente.add(usrPaciente);
                    
                }
                return arrayPaciente;
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
                return null;
            }
        }
        
        public static Boolean insertPaciente(String NomePerfil, String cpf, String DescricaoNecessidade, String ddd, String numero, int idadePaciente, String senhaPaciente){
            try{
                Connection con = open();
                PreparedStatement stm = con.prepareStatement(instrucao_insertPaciente);
                stm.setString(1, NomePerfil);
                stm.setString(2, cpf);
                stm.setString(3, DescricaoNecessidade);
                stm.setString(4, ddd);
                stm.setString(5, numero);
                stm.setInt(6, idadePaciente);
                stm.setString(7, senhaPaciente);
                stm.execute();
            return true;
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                return false;
            }
        }
        public static Boolean updatePaciente(int id, String decisao, String valor){
            try {
                Connection con = open();
                PreparedStatement stm;
                switch (decisao) {
                    case "numero":
                        stm = con.prepareStatement("UPDATE UsuarioPaciente SET numero=? WHERE IDPaciente = ?;");
                        break;
                    case "nome":
                        stm = con.prepareStatement("UPDATE UsuarioPaciente SET NomePerfil=? WHERE IDPaciente = ?;");
                        break;
                    case "descricao":
                        stm = con.prepareStatement("UPDATE UsuarioPaciente SET DescricaoNecessidade=? WHERE IDPaciente = ?;");
                        break;
                    case "ddd":
                        stm = con.prepareStatement("UPDATE UsuarioPaciente SET ddd=? WHERE IDPaciente = ?;");
                        break;
                    case "cpf":
                        stm = con.prepareStatement("UPDATE UsuarioPaciente SET cpf=? WHERE IDPaciente = ?;");
                        break;
                    case "senha":
                        stm = con.prepareStatement("UPDATE UsuarioPaciente SET senhaPaciente=? WHERE IDPaciente = ?;");
                        break;
                    default:
                        throw new AssertionError();
                }
                stm.setString(1, valor);
                stm.setInt(2, id);
                stm.execute();
                
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
            
        }
        public static Boolean deletePaciente(int id){
            try {
                Connection con = open();
                PreparedStatement stm = con.prepareStatement(instrucao_deletePaciente);
                stm.setInt(1, id);
                stm.execute();
                        
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }


}
