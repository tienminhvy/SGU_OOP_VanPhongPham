package ThanhToan;
import static ThanhToan.ThanhToan.sc;

public class CKNganHang {
    private String soTheTk;
    private int CVV;

    public CKNganHang(){

    }

    public CKNganHang(String soTheTk, int CVV) {
        this.soTheTk = soTheTk;
        this.CVV = CVV;
    }

    public String getSoTheTk() {
        return soTheTk;
    }

    public void setSoTheTk(String soTheTk) {
        this.soTheTk = soTheTk;
    }
    
    public boolean kiemTraSo(char c){ // phương thức kiểm tra số
        try {
            Integer.parseInt(""+c);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void setSoTheTk() {
        boolean check = true;
        do {
            System.out.print("Nhap so the: ");
            soTheTk = sc.nextLine();
            if(soTheTk.length() == 16 || soTheTk.length() == 19){ // kiểm tra số thẻ
                for(int i = 0; i < soTheTk.length(); i++){
                    if( !kiemTraSo(soTheTk.charAt(i)) ) { // nếu có chứa ký tự
                        check = false;
                        break;
                    }
                }
            } else {
                System.out.println("So the khong hop le!");
                check = false;
            }
        } while(!check);
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public void setCVV() {
        boolean check = true;
        do {
            System.out.print("Nhap so CVV/CVC: ");
            String CVVTemp = sc.nextLine();
            
            if(CVVTemp.length() == 3){
                
                for(int i = 0; i < CVVTemp.length(); i++){
                    if( !kiemTraSo(CVVTemp.charAt(i)) ) {
                        check = false;
                        break;
                    }
                }
                CVV = Integer.parseInt(CVVTemp);
                
            } else {
                System.out.println("So CVV/CVC khong hop le!");
                check = false;
            }
        } while(!check);
    }
     
    public void nhapThongTin(){
        System.out.print("Nhap so the/tai khoan: ");
        setSoTheTk();
        System.out.print("Nhap CVV: ");
        setCVV();        
    }
    
    public void xuat() {
        System.out.println("So the/tai khoan: "+soTheTk);
        System.out.println("CVV: "+CVV);
    }
}
