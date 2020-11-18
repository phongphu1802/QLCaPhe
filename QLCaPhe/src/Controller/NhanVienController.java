/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.NhanVienDTO;
import Model.NhanVienModel;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LAPTOPTOKYO
 */
public class NhanVienController {
    static ArrayList<NhanVienDTO> arNV=new ArrayList<NhanVienDTO>();
    NhanVienModel mNhanVien = new NhanVienModel();
    //Trả về danh sách nhân viên trong database
    //Input: N/A
    //Output: ArrayList
    public ArrayList LoadNhanVien () throws Exception{
        arNV.clear();
        arNV=mNhanVien.DSNhanVien();
        return arNV;
    }
    //Trả về nhân viên có mã cần tìm trong database
    //Input: strMaNV
    //Output: ArrayList( Thông tin nhân viên tìm kiếm)
    public ArrayList SelectNhanVien (String strMaNV) throws Exception{
        arNV.clear();
        arNV=mNhanVien.NhanVien(strMaNV);
        return arNV;
    }
    //Hàm trả về số lượng nhân viên
    //Input: N/A
    //Output: Số nhân viên
    public int DemNhanVien() throws Exception{
        LoadNhanVien();
        //System.out.println(arNV.size());
        return arNV.size();
    }
    //Thêm nhân viên
    //Input: Vector(manv,honv,tennv,gioitinh,ngaysinh,diachi,cmnd,sodienthoai,ngayvaolam,chucvu,trangthai)
    //Output: N/A.
    public void ThemNhanVien(Vector vNhanVien) throws Exception{
        mNhanVien.ThemNhanVien(vNhanVien);
        JOptionPane.showMessageDialog(null,"Thêm thành công.");
    }
    //Cập nhật nhân viên
    //Input: Vector(manv,honv,tennv,gioitinh,ngaysinh,diachi,cmnd,sodienthoai,ngayvaolam,chucvu,trangthai)
    //Output: N/A.
    public void CapNhatNhanVien(Vector vNhanVien) throws Exception{
        mNhanVien.CapNhatNhanVien(vNhanVien);
    }
    public void CapNhatTrangThai(String strMaNV,String strTrangThai) throws Exception{
        mNhanVien.CapNhatTrangThai(strMaNV,strTrangThai);
    }
}
