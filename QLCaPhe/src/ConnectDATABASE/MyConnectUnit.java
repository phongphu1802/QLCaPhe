/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectDATABASE;

import ConnectDATABASE.MySQLConnect;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class MyConnectUnit {
    private MySQLConnect connect ; 

    public MyConnectUnit(String Host, String UserName, String Password, String Database) throws SQLException, Exception{
        connect = new MySQLConnect( Host,UserName,Password,Database);
    }
    
    
    //Hàm hỗ trợ Select CSDL
    // Select * from TableName Where condition ORDER BY OrderBy       
    public ResultSet Select (String TableName,String Condition,String OrderBy) throws Exception{
        //Khai báo biến StringBuildler để tạo chuỗi Select
        StringBuilder query = new StringBuilder("SELECT * FROM " + TableName);
        //Đưa câu lệnh điều khiển vào trong câu query 
        this.AddCondition(query,Condition);
        //Đưa câu lệnh order vào trong câu query 
        this.AddOrderBy(query,OrderBy);
        //chèn ký tự ';' vào cuối dòng câu lệnh để cách dòng
        query.append(";");
        //Thực thi câu query và trả kêt quả ra ngoài
        System.out.println(query);
        return this.connect.executeQuery(query.toString());
    }
        
    //Hàm Overload Select Giảm OrderBy
    public ResultSet Select (String TableName,String Condition) throws Exception{
        return this.Select(TableName,Condition,null);
    }
        
    //Hàm Overload Select Giảm OrderBy và Condition
    public ResultSet Select (String TableName) throws Exception{
        return this.Select(TableName,null);
    }
    
    //Hàm thêm điều kiện vào query
    private void AddCondition(StringBuilder query, String Condition ){
        //Kiểm tra nếu Condition khác null
        if(Condition != null){
            query.append(" WHERE " + Condition);
        }
    }
    
    //Hàm thêm OrderBy vào query
    private void AddOrderBy(StringBuilder query, String OrderBy ){
        //Kiểm tra nếu Condition khác null
        if(OrderBy != null){
            query.append("ORDER BY" + OrderBy);
        }
    }
    
    //Hàm hỗ trợ Insert xuống CSDL
    //INSERT INTO TableName(ColumnName..) VALUES (Column Values..)    
    public boolean Insert(String TableName, HashMap< String, Object > ColumnValues) throws Exception{
        

        //Khai báo biến StringBuilder để tạo chuỗi Select
        StringBuilder query = new StringBuilder("INSERT INTO " + TableName);
        
        //Khai báo biến StringBuilder để tạo chuỗi Column Values
        StringBuilder valueInsert = new StringBuilder();
        
        query.append("(");
        //Duyệt và đưa thông tin lên cột và giá trị của cột và các câu Select
        
        for(String key: ColumnValues.keySet()){
            query.append(key+",");
            valueInsert.append("'"+ColumnValues.get(key).toString()+"' ,");
            
        }
        
        //Cắt bớt ký tự ',' cuối câu
        query = query.delete(query.length()-1,query.length());
        valueInsert = valueInsert.delete(valueInsert.length()-1,valueInsert.length());
        
        //Đưa giá trị của cột vào câu query
        query.append(") VALUE("+valueInsert.toString()+")");
        
        // Chèn ký tự ';' vào cuối dòng lệnh để cách các câu
        query.append(";");
        
        //Thực thi câu query và trả kết quả ra ngoài
        return this.connect.executeUpdate(query.toString())>0;
    }
            
    public boolean Update(String TableName, HashMap< String, Object > ColumnValues,String Condition) throws Exception{
        //Khai báo biến StringBuilder để tạo chuỗi Select
        StringBuilder query = new StringBuilder("UPDATE " + TableName +" SET ");
        
        //Duyệt và đưa thông tin tên cột và giá trị của cột vào câu Select
        for(String key: ColumnValues.keySet()){
            query.append(key+" = '"+ColumnValues.get(key).toString()+"' ,");     
        }
        //Cắt bớt ký tự ',' cuối câu
        query = query.delete(query.length()-1,query.length());
        
        //Đưa câu điều kiện vào câu query
        this.AddCondition(query, Condition);
        
        // Chèn ký tự ';' vào cuối dòng lệnh để cách các câu
        query.append(";");
        
        //Thực thi câu query và trả kết quả ra ngoài
        return this.connect.executeUpdate(query.toString())>0;
    }
    
    public boolean Delete(String TableName,String Condition) throws Exception{
        //Khai báo biến StringBuilder để tạo chuỗi Select
        StringBuilder query = new StringBuilder("DELETE FROM " + TableName);
        
        //Đưa câu điều kiện vào câu query
        this.AddCondition(query, Condition);
            
        // Chèn ký tự ';' vào cuối dòng lệnh để cách các câu
        query.append(";");
            
        //Thực thi câu query và trả kết quả ra ngoài
        return this.connect.executeUpdate(query.toString())>0;
    }
    
    //Đếm số cột trong Result select từ CSDL    
    public static int getColumnCount(ResultSet result) throws SQLException{
        //Lây số lượng cột từ Metadata của Result
        return result.getMetaData().getColumnCount();
        
    }
    
    //Hàm lấy danh sách tên cột trong Result select từ CSDL    
    public static String[] getColumnName(ResultSet result) throws SQLException{
        //Lây ResultSetMetaDate từ Result
        ResultSetMetaData rsMetaData = (ResultSetMetaData)result.getMetaData();
        
        //Lây số lượng cột trong Result
        int columnCount  = rsMetaData.getColumnCount();
        
        //Khai báo danh sách các cột
        String[] list = new String[columnCount];
        
        //Duyệt các cột
        for(int i = 0 ; i<columnCount; i++){
            //Lấy tên đưa vào danh sách
            list[i] = rsMetaData.getColumnName(i);
            
        }
            //Trả danh sách ra ngoài  
            return list;   
    }

    public void Close() throws Exception{
        this.connect.Close();
    }
    public static void main(String[] args) throws SQLException, Exception {
        MyConnectUnit s1= new MyConnectUnit("localhost","sa","123456789","csdlcaphe");
        s1.Select("nhanvien");
    }
}
