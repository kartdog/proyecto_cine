
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Felipe
 */
public class ConexionOracle {
    
    Connection cone;
    
    // se encarga de realizar la conexion
    public void conectar(){
        try {
            
            String user = "PROYECTODS";
            String password = "123";
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cone = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage()) ;
        }
    }

    public ConexionOracle() {
        conectar();
    }

    public Connection getCone() {
        return cone;
    }
}
