/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThanhToan;

import java.util.Scanner;

public class CKNganHang {
    private String soThe;
    private int CVV;

    Scanner sc = new Scanner(System.in);

    public CKNganHang(){

    }

    public CKNganHang(String soThe, int CVV) {
        this.soThe = soThe;
        this.CVV = CVV;
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
            System.out.print("Nhập lại số thẻ: ");
            soThe = sc.nextLine();
            if(soThe.length() == 16 || soThe.length() == 19){
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
     
    public void nhapThongTin(){
        System.out.print("Nhập số thẻ: ");
        soThe = sc.nextLine();
        System.out.print("Nhập CVV: ");
        CVV = Integer.parseInt(sc.nextLine());        
    }
    
    
}
