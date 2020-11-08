/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import ConnectDATABASE.MyConnect;
import ConnectDATABASE.MyConnectUnit;
import Controller.DangNhapController;
import DTO.TaiKhoanDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAPTOPTOKYO
 */
public class TaiKhoanModel {
    static ArrayList<TaiKhoanDTO> arTK=new ArrayList<TaiKhoanDTO>();
    MyConnectUnit connect;
    ResultSet rsTaiKhoan;
    public TaiKhoanModel(){
        try {
            this.connect=MyConnect.getDAO();
        } catch (Exception ex) {
            Logger.getLogger(DangNhapController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Tìm thông tin tài khoản khi biết ten đăng nhap
    public ArrayList TaiKhoan(String strTenDangNhap) throws Exception{
        String userkt="tentk ='"+strTenDangNhap+"'";
        rsTaiKhoan=this.connect.Select("taikhoan", userkt);
        //Lấy thông tin table tai khoản
        while(rsTaiKhoan.next()){
            TaiKhoanDTO nv=new TaiKhoanDTO();
            nv.setStrMaNV(rsTaiKhoan.getString(1));
            nv.setStrTaiKhoan(rsTaiKhoan.getString(2));
            nv.setStrMatKhau(rsTaiKhoan.getString(3));
            arTK.add(nv);
        }
        return arTK;
    }
    
}
