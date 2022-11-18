/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThanhToan;

import java.util.Scanner;

public class CKViDienTu {
    private String tenVi;
    private String soDienThoaiLienKet;
    Scanner sc = new Scanner(System.in);
    public CKViDienTu() {
    }

    public CKViDienTu(String tenVi, String soDienThoaiLienKet) {
        this.tenVi = tenVi;
        this.soDienThoaiLienKet = soDienThoaiLienKet;
    }

    public boolean kiemTraSo(char c){
        try {
            Integer.parseInt(""+c);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public String getTenVi() {
        return tenVi;
    }

    public void setTenVi() {
        int chon = 0;
        do {
            System.out.println("1. ZaloPay");
            System.out.println("2. Momo");
            System.out.println("3. VNPay");
            System.out.print("Chọn loại ví: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    tenVi = "Zalo Pay";                
                    break;
                case 2:
                    tenVi = "Momo";                
                    break; 
                case 3:
                    tenVi = "VNPay";                
                    break;    
                default:
                    chon = 0;
                    break;
            }
            if (chon == 0){
                System.out.println("Mời chọn lại tên ví.");
            }
        } while(chon == 0);
    }

    public String getSoDienThoaiLienKet() {
        return soDienThoaiLienKet;
    }

    public void setSoDienThoaiLienKet() {
        boolean check = true;
        do {
            System.out.print("Mời nhâp số điện thoại liên kết của ví: ");
            soDienThoaiLienKet = sc.nextLine();
            if(soDienThoaiLienKet.length() != 10){
                check = false;
                continue;
            }
            for(int i=0; i<soDienThoaiLienKet.length();i++) {
                if (!kiemTraSo(soDienThoaiLienKet.charAt(i))) {
                    check = false;
                    break;
                }
            }
        } while(!check);
    }
    
    public void nhapThongTin(){
        setTenVi();
        setSoDienThoaiLienKet();
    }
}