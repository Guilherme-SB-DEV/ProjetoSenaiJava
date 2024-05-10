package main;
import static sql.DAO.consulta;
import static sql.DAO.insert;
import static sql.DAO.update;
import static sql.DAO.delete;
import users.Usr;
public class Main extends Usr{
    public static void main(String[] args){
        // TODO code application logic here
        int counter = 0;
        Usr usuario = new Usr();
        update(1, "nome", "nome_teste");
        delete(2);
        for(Usr usr: consulta()){
            System.out.println(consulta().get(counter).getNome());
            System.out.println(consulta().get(counter).getCidade());
            System.out.println(consulta().get(counter).getBairro());
            System.out.println(consulta().get(counter).getCidade());
            System.out.println(consulta().get(counter).getCpf());
            System.out.println(consulta().get(counter).getDdd());
            System.out.println(consulta().get(counter).getNumero());
            counter++;
        }
        
        insert("gui", "cidade de sla", "bairro da palma", "71", "numero", "666.666.666-66");
    }
    
}
