/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author LAPTOPTOKYO
 */
public class NhanVienDTO {
    private String strMaNV;
    private String strHoNV;
    private String strTenNV;
    private String strGioiTinh;
    private String strDiaChi;
    private String strCMND;
    private String strSDT;
    private String strChucVu;
    private int iTrangThai;
    private String strNgaySinh;
    private String strNgayVaoLam;
    public NhanVienDTO(String strMaNV,String strHoNV, String strTenNV, String strGioiTinh, String strDiaChi, String strCMND, String strSDT, String strChucVu, int iTrangThai,String strNgaySinh, String strNgayVaoLam){
        this.strMaNV=strMaNV;
        this.strHoNV=strHoNV;
        this.strTenNV=strTenNV;
        this.strGioiTinh=strGioiTinh;
        this.strChucVu=strChucVu;
        this.strDiaChi=strDiaChi;
        this.strCMND=strCMND;
        this.strSDT=strSDT;
        this.iTrangThai=iTrangThai;
        this.strNgaySinh=strNgaySinh;
        this.strNgayVaoLam=strNgayVaoLam;
    }

    public NhanVienDTO() {
        this.strMaNV="";
        this.strHoNV="";
        this.strTenNV="";
        this.strGioiTinh="";
        this.strChucVu="";
        this.strDiaChi="";
        this.strCMND="";
        this.strSDT="";
        this.iTrangThai=0;
        this.strNgaySinh="";
        this.strNgayVaoLam="";
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
     * @return the strHoNV
     */
    public String getStrHoNV() {
        return strHoNV;
    }

    /**
     * @param strHoNV the strHoNV to set
     */
    public void setStrHoNV(String strHoNV) {
        this.strHoNV = strHoNV;
    }

    /**
     * @return the strTenNV
     */
    public String getStrTenNV() {
        return strTenNV;
    }

    /**
     * @param strTenNV the strTenNV to set
     */
    public void setStrTenNV(String strTenNV) {
        this.strTenNV = strTenNV;
    }

    /**
     * @return the strGioiTinh
     */
    public String getStrGioiTinh() {
        return strGioiTinh;
    }

    /**
     * @param strGioiTinh the strGioiTinh to set
     */
    public void setStrGioiTinh(String strGioiTinh) {
        this.strGioiTinh = strGioiTinh;
    }

    /**
     * @return the strDiaChi
     */
    public String getStrDiaChi() {
        return strDiaChi;
    }

    /**
     * @param strDiaChi the strDiaChi to set
     */
    public void setStrDiaChi(String strDiaChi) {
        this.strDiaChi = strDiaChi;
    }

    /**
     * @return the strCMND
     */
    public String getStrCMND() {
        return strCMND;
    }

    /**
     * @param strCMND the strCMND to set
     */
    public void setStrCMND(String strCMND) {
        this.strCMND = strCMND;
    }

    /**
     * @return the strSDT
     */
    public String getStrSDT() {
        return strSDT;
    }

    /**
     * @param strSDT the strSDT to set
     */
    public void setStrSDT(String strSDT) {
        this.strSDT = strSDT;
    }

    /**
     * @return the strChucVu
     */
    public String getStrChucVu() {
        return strChucVu;
    }

    /**
     * @param strChucVu the strChucVu to set
     */
    public void setStrChucVu(String strChucVu) {
        this.strChucVu = strChucVu;
    }

    /**
     * @return the iTrangThai
     */
    public int getiTrangThai() {
        return iTrangThai;
    }

    /**
     * @param iTrangThai the iTrangThai to set
     */
    public void setiTrangThai(int iTrangThai) {
        this.iTrangThai = iTrangThai;
    }

    /**
     * @return the strNgaySinh
     */
    public String getStrNgaySinh() {
        return strNgaySinh;
    }

    /**
     * @param strNgaySinh the strNgaySinh to set
     */
    public void setStrNgaySinh(String strNgaySinh) {
        this.strNgaySinh = strNgaySinh;
    }

    /**
     * @return the strNgayVaoLam
     */
    public String getStrNgayVaoLam() {
        return strNgayVaoLam;
    }

    /**
     * @param strNgayVaoLam the strNgayVaoLam to set
     */
    public void setStrNgayVaoLam(String strNgayVaoLam) {
        this.strNgayVaoLam = strNgayVaoLam;
    }   
}
