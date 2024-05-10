package main;
import sql.DAO;
import static sql.DAO.consulta;
import users.Usr;
public class Main extends Usr{
    public static void main(String[] args){
        // TODO code application logic here
        Usr usuario = new Usr();
        System.out.println(consulta());
        consulta();
    }
    
}
