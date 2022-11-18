/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThanhToan;

import java.util.Scanner;

public class CKTinDung {
   private String soThe;
   private int CVV;
   private String loaiThe;
   
   Scanner sc = new Scanner(System.in);
   
   public CKTinDung(){
       
   }

    public CKTinDung(String soThe, int CVV, String loaiThe) {
        this.soThe = soThe;
        this.CVV = CVV;
        this.loaiThe = loaiThe;
    }

    public String getSoThe() {
        return soThe;
    }
    
    //hàm kiểm tra số thẻ;
    
    public boolean kiemTraSo(char c){
        try {
            Integer.parseInt(""+c);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void setSoThe() {
        boolean check = true;
        do {
            System.out.print("Nhập số thẻ: ");
            soThe = sc.nextLine();
            if(soThe.length() == 16 ){
                for(int i = 0; i < soThe.length(); i++){
                    if( !kiemTraSo(soThe.charAt(i)) ) {
                        check = false;
                        break;
                    }
                }
            } else check = false;
        } while(!check);
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public String getLoaiThe() {
        return loaiThe;
    }
    
    //kiểm tra loại thẻ từ số thẻ (bằng những kí tự đâù)

    public void setLoaiThe() {
        loaiThe = "";
        if (soThe.charAt(0) == '5')
            loaiThe = "Master Card";
        else if (soThe.charAt(0) == '4')
            loaiThe = "Visa";
    }
    
    public void nhapThongTin(){
        setSoThe();
        setLoaiThe();
        System.out.print("Nhập CVV: ");
        CVV = Integer.parseInt(sc.nextLine());
                
    }
   
   
}