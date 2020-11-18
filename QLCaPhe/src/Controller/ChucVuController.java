/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.ChucVuDTO;
import Model.ChucVuModel;
import java.util.ArrayList;

/**
 *
 * @author LAPTOPTOKYO
 */
public class ChucVuController {
    static ArrayList<ChucVuDTO> arCV=new ArrayList<ChucVuDTO>();
    ChucVuModel mChucVu = new ChucVuModel();
    //Trả về danh sách nhân viên trong database
    //Input: N/A
    //Output: ArrayList
    public ArrayList LoadChucVu () throws Exception{
        arCV.clear();
        arCV=mChucVu.DSChucVu();
        return arCV;
    }
}
