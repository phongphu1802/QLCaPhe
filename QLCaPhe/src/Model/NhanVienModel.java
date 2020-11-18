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
import java.util.HashMap;
import java.util.Vector;
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
    //Tìm thông tin nhân vien khi biết mã nhân viên.
    //Input: manv(Mã nhân viên).
    //Output: Thông tin nhân viên theo mã.
    public ArrayList NhanVien(String strMaNV) throws Exception{
        String strSQL="manv ='"+strMaNV+"'";
        rsNhanVien=this.connect.Select("nhanvien", strSQL);
        arNV.clear();
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
    //Danh sách nhân viên trong database
    //Input: N/A
    //Output: ArrayList Nhân viên
    public ArrayList DSNhanVien() throws Exception{
        rsNhanVien=this.connect.Select("nhanvien");
        arNV.clear();
        //Lấy thông tin table
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
    //Thêm nhân viên
    //Input: Vector(manv,honv,tennv,gioitinh,ngaysinh,diachi,cmnd,sodienthoai,ngayvaolam,chucvu,trangthai)
    //Output: N/A.
    public void ThemNhanVien(Vector vNhanVien) throws Exception{
        HashMap<String, Object>map=new HashMap<String,Object>();
        map.put("manv", vNhanVien.get(0).toString());
        map.put("honv", vNhanVien.get(1).toString());
        map.put("tennv", vNhanVien.get(2).toString());
        map.put("gioitinh", vNhanVien.get(3).toString());
        map.put("ngaysinh", vNhanVien.get(4).toString());
        map.put("diachi", vNhanVien.get(5).toString());
        map.put("cmnd", vNhanVien.get(6).toString());
        map.put("sodienthoai", vNhanVien.get(7).toString());
        map.put("ngayvaolam", vNhanVien.get(8).toString());
        map.put("chucvu", vNhanVien.get(9).toString());
        map.put("trangthai", vNhanVien.get(10).toString());
        this.connect.Insert("nhanvien", map);
    }
    //Cập nhật trạng thái nhân viên
    //Input: strMaNV
    //Ouput: N/A
    public void CapNhatNhanVien(Vector vNhanVien) throws Exception{
        HashMap<String, Object>map=new HashMap<String,Object>();
        //map.put("manv", vNhanVien.get(0).toString());
        map.put("honv", vNhanVien.get(1).toString());
        map.put("tennv", vNhanVien.get(2).toString());
        map.put("gioitinh", vNhanVien.get(3).toString());
        map.put("ngaysinh", vNhanVien.get(4).toString());
        map.put("diachi", vNhanVien.get(5).toString());
        map.put("cmnd", vNhanVien.get(6).toString());
        map.put("sodienthoai", vNhanVien.get(7).toString());
        map.put("ngayvaolam", vNhanVien.get(8).toString());
        map.put("chucvu", vNhanVien.get(9).toString());
        map.put("trangthai", vNhanVien.get(10).toString());
        String sql="manv='"+vNhanVien.get(0).toString()+"'";
        this.connect.Update("nhanvien", map,sql);
    }
    //Cập nhật trạng thái nhân viên
    //Input: strMaNV
    //Ouput: N/A
    public void CapNhatTrangThai(String strMaNV,String strTrangThai) throws Exception{
        HashMap<String, Object>map=new HashMap<String,Object>();
        map.put("trangthai", strTrangThai);
        String sql="manv='"+strMaNV+"'";
        this.connect.Update("nhanvien", map,sql);
    }
}
