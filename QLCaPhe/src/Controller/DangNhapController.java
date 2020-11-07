/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ConnectDATABASE.MyConnectUnit;
import Model.DangNhapModel;
import Model.ModelConnect;
import java.sql.ResultSet;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAPTOPTOKYO
 */
public class DangNhapController {
    static ArrayList<DangNhapModel> dsnv=new ArrayList<DangNhapModel>();
    MyConnectUnit connect;
    ResultSet rsTaiKhoan;
    public DangNhapController(){
        try {
            this.connect=ModelConnect.getDAO();
        } catch (Exception ex) {
            Logger.getLogger(DangNhapController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String kiemtra(String strTaiKhoan,String strMatKhau) throws Exception
    {
        String userkt="tentk ='"+strTaiKhoan+"'";
        rsTaiKhoan=this.connect.Select("taikhoan", userkt);
        //Đưa con trỏ về cuối rsTaiKhoan
        while(rsTaiKhoan.next()){
            DangNhapModel nv=new DangNhapModel();
            nv.setStrMaNV(rsTaiKhoan.getString(1));
            nv.setStrTaiKhoan(rsTaiKhoan.getString(2));
            nv.setStrMatKhau(rsTaiKhoan.getString(3));
            dsnv.add(nv);
        }
        //System.out.println(rsTaiKhoan.getRow());
        //Kiểm tra xem Row có rỗng hay không nếu rỗng trả về 0 nghĩa là tài khoản không tồn tại
        if(dsnv.size()==0)
        {
            //System.out.println("Tài khoản không tồn tại");
            return "Tài khoản không tồn tại";
        }
        else{
            //Nếu mật khẩu tài khoản trùng
            System.out.println(dsnv.get(0).getStrMatKhau());
            if(dsnv.get(0).getStrMatKhau().equals(strMatKhau))
            {
                return "Đăng nhập thành công";
            }
            return "Đăng nhập không thành công";
        }
    }
}
