/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import ConnectDATABASE.MyConnect;
import ConnectDATABASE.MyConnectUnit;
import Controller.DangNhapController;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAPTOPTOKYO
 */
public class NhanVienModel {
    static ArrayList<NhanVienDTO> arNV=new ArrayList<NhanVienDTO>();
    MyConnectUnit connect;
    ResultSet rsNhanVien;
    public NhanVienModel(){
        try {
            this.connect=MyConnect.getDAO();
        } catch (Exception ex) {
            Logger.getLogger(DangNhapController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Tìm thông tin nhân vien khi biết mã nhân viên
    public ArrayList NhanVien(String strMaNV) throws Exception{
        String strSQL="manv ='"+strMaNV+"'";
        rsNhanVien=this.connect.Select("nhanvien", strSQL);
        //Lấy thông tin table tai khoản
        while(rsNhanVien.next()){
            NhanVienDTO nv=new NhanVienDTO();
            nv.setStrMaNV(rsNhanVien.getString(1));
            nv.setStrHoNV(rsNhanVien.getString(2));
            nv.setStrTenNV(rsNhanVien.getString(3));
            nv.setStrGioiTinh(rsNhanVien.getString(4));
            nv.setStrNgaySinh(rsNhanVien.getString(5));
            nv.setStrDiaChi(rsNhanVien.getString(6));
            nv.setStrCMND(rsNhanVien.getString(7));
            nv.setStrSDT(rsNhanVien.getString(8));
            nv.setStrNgayVaoLam(rsNhanVien.getString(9));
            nv.setStrChucVu(rsNhanVien.getString(10));
            nv.setiTrangThai(rsNhanVien.getInt(11));
            arNV.add(nv);
        }
        return arNV;
    }
}
