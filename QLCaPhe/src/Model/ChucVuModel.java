/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import ConnectDATABASE.MyConnect;
import ConnectDATABASE.MyConnectUnit;
import Controller.DangNhapController;
import DTO.ChucVuDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAPTOPTOKYO
 */
public class ChucVuModel {
    static ArrayList<ChucVuDTO> arCV=new ArrayList<ChucVuDTO>();
    MyConnectUnit connect;
    ResultSet rsChucVu;
    public ChucVuModel(){
        try {
            this.connect=MyConnect.getDAO();
        } catch (Exception ex) {
            Logger.getLogger(DangNhapController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Danh sách chức vụ trong database
    //Input: N/A
    //Output: ArrayList Chức vụ
    public ArrayList DSChucVu() throws Exception{
        rsChucVu=this.connect.Select("chucvu");
        arCV.clear();
        while(rsChucVu.next()){
            ChucVuDTO cv=new ChucVuDTO();
            cv.setStrMaCV(rsChucVu.getString(1));
            cv.setStrTenCV(rsChucVu.getString(2));
            cv.setiLuong(rsChucVu.getInt(3));
            cv.setiTrangThai(rsChucVu.getInt(4));
            arCV.add(cv);
        }
        return arCV;
    }
}
