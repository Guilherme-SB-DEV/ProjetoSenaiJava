package sql;

import java.sql.*;
import static sql.Conexao.open;
import java.util.LinkedList;
import java.util.List;
import users.Usr;
public class DAO {
    public static String instrucao_select = "SELECT * FROM sla;";
    public static String instrucao_insert = "INSERT INTO sla(nome, idade) VALUES (?,?,?,?,?);";
    public static String instrucao_update = "UPDATE sla SET nome=?, idade=? WHERE id =?;";
    public static String instrucao_delete = "DELETE FROM new_table WHERE id = ?;";
        public static List<Usr> consulta(){
            try{
                List<Usr> array = new LinkedList<>(); //inicia arrayList de usuarios
                Connection con = open(); //abre conexão
                Statement sentenca = con.createStatement();
                ResultSet rs = sentenca.executeQuery(instrucao_select); //executa query
                while(rs.next()){
                    Usr usr = new Usr(); //inicia isntancia de usuario
                    //seta os dados da query como dados do objeto usuario
                    usr.setNome(rs.getString("nome"));
                    usr.setCidade(rs.getString("cidade"));
                    usr.setBairro(rs.getString("bairro"));
                    usr.setDdd(rs.getString("ddd"));
                    usr.setNumero(rs.getString("numero"));
                    usr.setCpf(rs.getString("cpf"));
                    //add objeto no arrayList
                    array.add(usr);
                    
                }
                return array;
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
                return null;
            }
        }
        
        public static Boolean insert(String nome, String cidade, String bairro, String ddd, String cpf){
            try{
                Connection con = open();
                PreparedStatement stm = con.prepareStatement(instrucao_insert);
                stm.setString(1, nome);
                stm.setString(2, cidade);
                stm.setString(3, bairro);
                stm.setString(4, ddd);
                stm.setString(5, cpf);
                stm.execute();
            return true;
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                return false;
            }
        }
        public static Boolean update(int id, String new_nome, int new_idade){
            try {
                Connection con = open();
                PreparedStatement stm = con.prepareStatement(instrucao_update);
                stm.setString(1, new_nome);
                stm.setInt(2, new_idade);
                stm.setInt(3, id);
                stm.execute();
                
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
            
        }
        public static Boolean delete(int id){
            try {
                Connection con = open();
                PreparedStatement stm = con.prepareStatement(instrucao_delete);
                stm.setInt(1, id);
                stm.execute();
                        
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }

}
