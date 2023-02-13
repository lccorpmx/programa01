package uv.org.programa01cc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Programa01CC {

    public static void main(String[] args) {
            Connection con = null;
            Statement st = null;
        try {
  
            String url = "jdbc:postgresql://localhost:7000/emp";
            String usuario = "postgres";
            String contra = "password";
            String sql= "insert into prueba (id, nombre, telefono, direccion) values"
                    + "('02','Jona', '2342342', 'Av 2 ')";
            
            con = DriverManager.getConnection(url,usuario,contra);
            Logger.getLogger(Programa01CC.class.getName()).log(Level.INFO, "Se conecto la BD");
            
            st = con.createStatement();
            boolean res = st.execute(sql);
            if(res)
                Logger.getLogger(Programa01CC.class.getName()).log(Level.INFO, "No se guardo");
            else
                Logger.getLogger(Programa01CC.class.getName()).log(Level.INFO, "se guardo");
            
        } catch (SQLException ex) {
            Logger.getLogger(Programa01CC.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            try {
                if (st!=null) {
                    st.close();
                }
            } catch (SQLException ex) {
            Logger.getLogger(Programa01CC.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                if (con!=null) {
                    con.close();
                }
                
            } catch (SQLException ex) {
            Logger.getLogger(Programa01CC.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    } 
}
