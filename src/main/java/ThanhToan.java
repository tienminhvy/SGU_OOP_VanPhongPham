import ThanhToan.*;
import java.util.Scanner;

public class ThanhToan {
    private String phuongThucThanhToan;

    static Scanner sc = new Scanner(System.in);
    private CKNganHang PTNganHang;
    private CKTinDung PTTinDung;
    private CKViDienTu PTViDienTu;
    
    public void chonPhThThanhToan(){
        System.out.println("Mời chọn phương thức thanh toán: ");
        int chon = 0;
        do{
            switch (chon) {
                case 1:
                    phuongThucThanhToan = "TienMat";
                    break;
                case 2:
                    phuongThucThanhToan = "CK_NganHang";
                    break;
                case 3:
                     phuongThucThanhToan = "CK_TinDung";
                    break;
                case 4:
                     phuongThucThanhToan = "CK_ViDienTu";
                    break;
                default:
                    chon = 0;
                    break;
            }
            if(chon == 0){
                System.out.println("Mời chọn lại phương thức thanh toán.");
            }
        }while (chon == 0);

    }

    public void LienKet() {
        if(phuongThucThanhToan.equals("CK_NganHang")) {
            PTNganHang = new CKNganHang();
            PTNganHang.nhapThongTin();
        } 
        else if (phuongThucThanhToan.equals("CK_TinDung")){
            PTTinDung = new CKTinDung();
            PTTinDung.nhapThongTin();
        }
        else{
            PTViDienTu = new CKViDienTu();
            PTViDienTu.nhapThongTin();
        }
    }
}