/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author LAPTOPTOKYO
 */
public class DangNhapModel {
    private String strMaNV;
    private String strTaiKhoan;
    private String strMatKhau;
    
    public DangNhapModel(){     
    }
    
    public DangNhapModel(String strMaNV,String strTaiKhoan,String strMatKhau){
        this.strMaNV = strMaNV;
        this.strTaiKhoan = strTaiKhoan;
        this.strMatKhau = strMatKhau;
    }
    
    /**
     * @return the strMaNV
     */
    public String getStrMaNV() {
        return strMaNV;
    }

    /**
     * @param strMaNV the strMaNV to set
     */
    public void setStrMaNV(String strMaNV) {
        this.strMaNV = strMaNV;
    }
    
    /**
     * @return the strTaiKhoan
     */
    public String getStrTaiKhoan() {
        return strTaiKhoan;
    }

    /**
     * @param strTaiKhoan the strTaiKhoan to set
     */
    public void setStrTaiKhoan(String strTaiKhoan) {
        this.strTaiKhoan = strTaiKhoan;
    }

    /**
     * @return the strMatKhau
     */
    public String getStrMatKhau() {
        return strMatKhau;
    }

    /**
     * @param strMatKhau the strMatKhau to set
     */
    public void setStrMatKhau(String strMatKhau) {
        this.strMatKhau = strMatKhau;
    }           
}
