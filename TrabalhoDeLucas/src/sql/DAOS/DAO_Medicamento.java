package sql.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import static sql.Conexao.open;
import users.Medicamento;

public class DAO_Medicamento {
    private static String instrucao_select = "SELECT Cadastro_de_medicacoes.NomeMedicamento, Cadastro_de_medicacoes.Tipo, Prescricao_medica.HorarioInicial, Prescricao_medica.Dosagem, Prescricao_medica.Periodicidade, Prescricao_medica.DuracaoDoTratamento"
            +                                       "FROM usuariopaciente"
            +                                       "JOIN Medicamento_cadastro ON Cadastro_de_medicacoes.idCadastroMedicacao = Medicamento_cadastro.fk_Cadastro_de_medicacoes_IdCadastroMedicacao"
            +                                       "JOIN Prescricao_medica ON fk_Prescrocao_medica_IDPrescricao = Prescricao_medica.IDPrescricao;";
    private static String instrucao_insert = "INSERT INTO Cadastro_de_medicacoes( NomeMedicamento, Tipo) VALUES (?,?);";
    private static String instrucao_insert2 = "INSERT INTO Prescricao_medica( HorarioInicial, Dosagem, Peridiocidade, DuracaoDoTratamento) VALUES (?,?,?,?);";
    private static String instrucao_delete = "DELETE FROM usuariopaciente WHERE IDPaciente = ?;";

        public static List<Medicamento> consultaMedicamento(){
            try{
                List<Medicamento> arrayMedicamento = new LinkedList<>(); //inicia arrayList de usuarios
                Connection con = open(); //abre conexão
                Statement sentenca = con.createStatement();
                ResultSet rs = sentenca.executeQuery(instrucao_select); //executa query
                while(rs.next()){
                    
                    Medicamento medicamento = new Medicamento(); //inicia isntancia de usuario
                    
                    //seta os dados da query como dados do objeto usuario
                    medicamento.setNomeMedicamento(rs.getString("NomeMedicamento"));
                    medicamento.setTipo(rs.getString("Tipo"));
                    medicamento.setHorarioInicial(rs.getInt("HorarioInicial"));
                    medicamento.setDosagem(rs.getFloat("Dosagem"));
                    medicamento.setPeriodicidade(rs.getInt("Periodicidade"));
                    medicamento.setDuracaoTratamento(rs.getInt("DuracaoDoTratamento"));
                    //add objeto no arrayList
                    arrayMedicamento.add(medicamento);
                    
                }
                return arrayMedicamento;
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
                return null;
            }
        }
        
        public static Boolean insertMedicamento(String NomeMedicamento, String Tipo, int HorarioInicial, float Dosagem, int Periodicidade, int DuracaoDoTratamento){
            try{
                Connection con = open();
                PreparedStatement stm = con.prepareStatement(instrucao_insert);
                stm.setString(1, NomeMedicamento);
                stm.setString(2, Tipo);
                stm.execute();
                PreparedStatement stm2 = con.prepareStatement(instrucao_insert2);
                stm2.setInt(1, HorarioInicial);
                stm2.setFloat(2, Dosagem);
                stm2.setInt(3, Periodicidade);
                stm2.setInt(4, DuracaoDoTratamento);
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
}
