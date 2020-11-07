/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectDATABASE;

import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class MySQLConnect {
    String Host ="jdbc:sqlserver://localhost;databaseName=csdlcaphe;user=sa;password=123456789";
    String UserName="sa";
    String Password="123456789";
    String Database="csdlcaphe";
    String url="jdbc:sqlserver://localhost;databaseName=csdlcaphe;user=sa;password=123456789";
    Connection connect= null;
    Statement statement=null;
    ResultSet result=null;
    
    public MySQLConnect(String Host, String UserName, String Password, String Database) throws ClassNotFoundException, SQLException, Exception
    {
        try{
            this.Host=Host;
            this.UserName=UserName;
            this.Password=Password;
            this.Database=Database;
            this.url = "jdbc:sqlserver://" + this.Host + ";databaseName="+ this.Database+";user="+this.UserName+";password="+this.Password;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connect = DriverManager.getConnection(this.url);
             if (connect != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) connect.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
        }catch(Exception ex){
            System.err.println("Cannot connect database, " + ex);
        }
    }

    MySQLConnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    protected Statement getStatement() throws Exception{
        if(this.statement==null ? true:this.statement.isClosed()){
            this.statement=this.connect.createStatement();
        }
        return this.statement;
    }
    
    public ResultSet executeQuery(String Query) throws Exception{
        try{
            this.result=this.getStatement().executeQuery(Query);
        }catch(Exception e){
            throw new Exception("Error"+e.getMessage()+"-"+Query);
        }
        return this.result;
    }
    
    public int executeUpdate(String Query) throws Exception{
        int res=Integer.MIN_VALUE;
        try{
            res=this.getStatement().executeUpdate(Query);
        }catch(Exception e){
            throw new Exception("Error: "+e.getMessage()+"-"+Query);
        }//finally{
           // this.Close();
        //}
        return res;
    }

    public void Close() {
        try{
            this.connect.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException, Exception {
        MySQLConnect s1= new MySQLConnect("localhost","sa","123456789","csdlcaphe");
    }
}
