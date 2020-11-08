/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ConnectDATABASE.MyConnectUnit;
import DTO.TaiKhoanDTO;
import ConnectDATABASE.MyConnect;
import DTO.NhanVienDTO;
import Model.NhanVienModel;
import Model.TaiKhoanModel;
import View.FrameMenu;
import java.sql.ResultSet;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LAPTOPTOKYO
 */
public class DangNhapController {
    static ArrayList<TaiKhoanDTO> arTK=new ArrayList<TaiKhoanDTO>();
    static ArrayList<NhanVienDTO> arNV=new ArrayList<NhanVienDTO>();
    TaiKhoanModel TKDangNhap = new TaiKhoanModel();
    NhanVienModel TTNhanVien = new NhanVienModel();
    public String DangNhapController(String strTaiKhoan,String strMatKhau) throws Exception
    {
        //Tìm thông tin tài khoản khi biết tên Tài khoản
        arTK=TKDangNhap.TaiKhoan(strTaiKhoan);
        //Kiểm tra xem Row có rỗng hay không nếu rỗng trả về 0 nghĩa là tài khoản không tồn tại
        if(arTK.size()==0)
        {
            JOptionPane.showMessageDialog(null,"Tài khoản "+strTaiKhoan+" không tồn tại.");
            return "Tài khoản không tồn tại";
        }
        else{
            //Nếu mật khẩu tài khoản trùng
            if(arTK.get(0).getStrMatKhau().equals(strMatKhau))
            {
                JOptionPane.showMessageDialog(null,"Đăng nhập thành công. Chào bạn "+strTaiKhoan+".");
                //Tìm thông tin nhân viênkhi biết mã nhân viên
                arNV=TTNhanVien.NhanVien(arTK.get(0).getStrMaNV());
                FrameMenu Start= new FrameMenu(arTK.get(0).getStrMaNV(),arNV.get(0).getStrHoNV()+arNV.get(0).getStrTenNV(),arNV.get(0).getStrChucVu());
                Start.setVisible(true);
                return "Đăng nhập thành công";
            }
            JOptionPane.showMessageDialog(null,"Đăng nhập không thành công. vui lòng nhập lại mật khẫu của "+strTaiKhoan+".");
            return "Đăng nhập không thành công";
        }
    }
}
