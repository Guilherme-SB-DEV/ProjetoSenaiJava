package sql.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import static sql.Conexao.open;
import users.UsrCuidador;
import users.UsrPaciente;

public class DAO_Cuidado {
    //insere usuario e paciente na tabela de relacionamento "cuida"
    private static String instrucao_insert = "INSERT INTO cuida(fk_usuariopaciente_IDpaciente, fk_usuariocuidador_IDCuidador) VALUES (?,?);";
    //seleciona dados do cuidador juntando a tabela "cuida" com usuariocuidador onde o id do paciente for igual ao parametro(?)
    private static String instrucao_pesquisaPaciente = "select cuida.fk_usuariocuidador_IDCuidador,"
            + " usuariocuidador.NomePerfil,"
            + " usuariocuidador.periodo,"
            + " usuariocuidador.TipoContrato,"
            + " usuariocuidador.DescricaoEspecialidades"
            + " from cuida join usuariocuidador on fk_usuariocuidador_IDCuidador = usuariocuidador.IDCuidador"
            + " where fk_usuariopaciente_IDpaciente = ?; ";
    //seleciona dados do paciente juntando a tabela "cuida" com usuario paciente onde o id do cuidador for igual ao parametro(?)
    private static String instrucao_pesquisaCuidador = "select cuida.fk_usuariopaciente_IDpaciente,"
            + " usuariopaciente.NomePerfil,"
            + " usuariopaciente.idadePaciente,"
            + " usuariopaciente.ddd,"
            + " usuariopaciente.numero,"
            + " usuariopaciente.DescricaoNecessidades,"
            + " usuariopaciente.Cidade,"
            + " usuariopaciente.Bairro"
            + " from cuida join usuariopaciente on fk_usuariopaciente_IDpaciente = usuariopaciente.IDpaciente"
            + " where fk_usuariocuidador_IDCuidador = ?;"; 
    

    public static HashMap<String, UsrCuidador> pesquisaAgendamentoPaciente(String id) throws Exception{
            HashMap<String, UsrCuidador> mapaCuidador = new HashMap<>(); // Inicializa o HashMap
            Connection con = open(); // Abre conexão
            PreparedStatement stm = con.prepareStatement(instrucao_pesquisaPaciente);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery(); // Executa query
            

            try {
                while (rs.next()) {
                    UsrCuidador usr = new UsrCuidador(); // Inicia instância de usuário

                    // Seta os dados da query como dados do objeto usuário
                    
                    usr.setId(rs.getString("fk_usuariocuidador_IDCuidador"));
                    usr.setTipoContrato(rs.getString("TipoContrato"));
                    usr.setNome(rs.getString("NomePerfil"));    
                    usr.setDescricaoEspecialidade(rs.getString("DescricaoEspecialidades"));
                    usr.setPeriodo(rs.getString("periodo"));

                    // Adiciona o objeto no HashMap usando o CPF como chave
                    mapaCuidador.put(usr.getId(), usr);
                }
                System.out.println(mapaCuidador);
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            return mapaCuidador;
        }
    public static HashMap<String, UsrPaciente> pesquisaAgendamentoCuidador(String id) throws Exception{
            HashMap<String, UsrPaciente> mapaCuidador = new HashMap<>(); // Inicializa o HashMap
            Connection con = open(); // Abre conexão
            PreparedStatement stm = con.prepareStatement(instrucao_pesquisaCuidador);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery(); // Executa query
            

            try {
                while (rs.next()) {
                    UsrPaciente usr = new UsrPaciente(); // Inicia instância de usuário

                    // Seta os dados da query como dados do objeto usuário
                    
                    usr.setId(rs.getString("fk_usuariopaciente_IDpaciente"));
                    usr.setNome(rs.getString("NomePerfil"));    
                    usr.setDdd(rs.getString("ddd"));
                    usr.setNumero(rs.getString("numero"));
                    usr.setDescricaoNecessidades(rs.getString("DescricaoNecessidades"));
                    usr.setIdade(rs.getInt("idadePaciente"));
                    usr.setCidade(rs.getString("Cidade"));
                    usr.setBairro(rs.getString("Bairro"));

                    // Adiciona o objeto no HashMap usando o CPF como chave
                    mapaCuidador.put(usr.getId(), usr);
                }
                System.out.println(mapaCuidador);
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            return mapaCuidador;
        }
    
    
    public static Boolean insertCuida(String idPaciente, String idCuidador) throws Exception{
                try{
                    Connection con = open();
                    PreparedStatement stm = con.prepareStatement(instrucao_insert);
                    stm.setString(1, idPaciente);
                    stm.setString(2, idCuidador);
                    stm.execute();
                    con.close();
            return true;
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                return false;
            }
    }
}
