/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectDATABASE;

import ConnectDATABASE.MyConnectUnit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author LAPTOPTOKYO
 */
public class MyConnect {
    public static MyConnectUnit getDAO() throws Exception{
        return new MyConnectUnit("localhost","sa","123456789","csdlcaphe");
    }
}
