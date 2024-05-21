package sql.DAOS;

import GUI.InterfacePrincipalPaciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static sql.Conexao.open;
import users.UsrPaciente;

public class DAO_Paciente {
    private static String instrucao_select = "SELECT * FROM usuariopaciente;";
    private static String instrucao_insert = "INSERT INTO usuariopaciente( NomePerfil, Cpf, DescricaoNecessidades, ddd, numero, idadePaciente, senhaPaciente, Bairro, Cidade) VALUES (?,?,?,?,?,?,?,?,?);";

    public static HashMap<String, UsrPaciente> consultaPaciente() throws Exception{
            HashMap<String, UsrPaciente> mapPaciente = new HashMap<>(); // Inicializa o HashMap
            Connection con = open(); // Abre conexão
            Statement sentenca = con.createStatement();
            ResultSet rs = sentenca.executeQuery(instrucao_select); // Executa query

            try {
                while (rs.next()) {
                    UsrPaciente usr = new UsrPaciente(); // Inicia instância de usuário

                    // Seta os dados da query como dados do objeto usuário
                    usr.setId(rs.getString("IDpaciente"));
                    usr.setNome(rs.getString("NomePerfil"));
                    usr.setCpf(rs.getString("Cpf"));
                    usr.setDescricaoNecessidades(rs.getString("DescricaoNecessidades"));
                    usr.setDdd(rs.getString("ddd"));
                    usr.setNumero(rs.getString("numero"));
                    usr.setIdade(rs.getInt("idadePaciente"));
                    usr.setSenhaPaciente(rs.getString("senhaPaciente"));
                    usr.setCidade(rs.getString("Cidade"));
                    usr.setBairro(rs.getString("Bairro"));

                    // Adiciona o objeto no HashMap usando o CPF como chave
                    mapPaciente.put(usr.getCpf(), usr);
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println(mapPaciente);
            return mapPaciente;
        }
        

    public static Boolean insertPaciente(String NomePerfil, String cpf, String DescricaoNecessidade, String ddd, String numero, int idadePaciente, String senhaPaciente, String bairro, String cidade){
        try{
            Connection con = open();
            PreparedStatement stm = con.prepareStatement(instrucao_insert);
            stm.setString(1, NomePerfil);
            stm.setString(2, cpf);
            stm.setString(3, DescricaoNecessidade);
            stm.setString(4, ddd);
            stm.setString(5, numero);
            stm.setInt(6, idadePaciente);
            stm.setString(7, senhaPaciente);
            stm.setString(8, bairro);
            stm.setString(9, cidade);
            stm.execute();
            con.close();
            return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }


   public String[] loginPaciente(String cpf, String senha) {
        try {
            HashMap<String, UsrPaciente> pacientes = consultaPaciente();

            // Verificar se o Paciente existe e se a senha corresponde
            UsrPaciente paciente = pacientes.get(cpf);
            String[] dados = new String[7];
            if (paciente != null && paciente.getSenhaPaciente().equals(senha)) {
                JOptionPane.showMessageDialog(null, "Logado");
                dados[0] = paciente.getId();
                dados[1] = paciente.getNome();
                dados[2] = Integer.toString(paciente.getIdade());
                dados[3] = paciente.getDescricaoNecessidades();
                dados[4] = paciente.getDdd()+" "+paciente.getNumero();
                dados[5] = paciente.getCidade();
                dados[6]= paciente.getBairro();
                InterfacePrincipalPaciente inter = new InterfacePrincipalPaciente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6]);
                inter.dispose();
                inter.setVisible(true);
                return dados;
            } else {
                JOptionPane.showMessageDialog(null, "CPF ou senha inválidos");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
        
    }
    


}
