/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Tran Quoc Huy
 */
public class ChucVuDTO {
    private String strMaCV;
    private String strTenCV;
    private int iLuong;
    private int iTrangThai;

    public ChucVuDTO(String strMaCV, String strTenCV, int iLuong, int iTrangThai) {
        this.strMaCV = strMaCV;
        this.strTenCV = strTenCV;
        this.iLuong = iLuong;
        this.iTrangThai = iTrangThai;
    }

    public ChucVuDTO() {
        this.strMaCV="";
        this.strTenCV="";
        this.iLuong=0;
        this.iTrangThai=0;
    }

    public String getStrMaCV() {
        return strMaCV;
    }

    public String getStrTenCV() {
        return strTenCV;
    }

    public int getiLuong() {
        return iLuong;
    }

    public int getiTrangThai() {
        return iTrangThai;
    }

    public void setStrMaCV(String strMaCV) {
        this.strMaCV = strMaCV;
    }

    public void setStrTenCV(String strTenCV) {
        this.strTenCV = strTenCV;
    }

    public void setiLuong(int iLuong) {
        this.iLuong = iLuong;
    }

    public void setiTrangThai(int iTrangThai) {
        this.iTrangThai = iTrangThai;
    }
    

}
