package Nguoi;
import HangHoa.PhanTu;

public abstract class Nguoi extends PhanTu {
    private String hoTen;
    private String cmt;
    private String diaChi;
    private String soDienThoai;

    public Nguoi() {
    }

    public Nguoi(String hoTen, String cmt, String diaChi, String soDienThoai) {
        this.hoTen = hoTen;
        this.cmt = cmt;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen() {
        boolean check = false;
        char ch;
        do {
            check = true;
            hoTen = sc.nextLine();
            for (int i = 0; i < hoTen.length(); i++) {
                ch = hoTen.charAt(i);
                if (Character.isDigit(ch)) {
                    check = false;
                    break;
                }
            }
            if (!check) System.out.println("Ho ten khong duoc phep chua ky tu so! Moi nhap lai:");
        } while (!check);
        
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt() {
        String cmt;
        boolean check = false;
        do {
            cmt = sc.nextLine();
            if (cmt.length() == 9) check = true;
            if (cmt.length() == 12) check = true;
            if (!check) System.out.print("Moi nhap lai: ");
        } while(!check);
        this.cmt = cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi() {
        this.diaChi = sc.nextLine();
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai() {
        boolean check = false;
        String soDienThoai;
        do {
            soDienThoai = sc.nextLine();
            if (soDienThoai.length() == 10) check = true;
            else check = false;
            
            if (soDienThoai.indexOf("0") == 0) check = true;
            else check = false;

            for (int i = 0; i < soDienThoai.length(); i++) {
                if (!Character.isDigit(soDienThoai.charAt(i)))
                {
                    check = false;
                    break;
                }
            }
            
            if (!check) System.out.print("Moi nhap lai: ");
        } while (!check);
        this.soDienThoai = soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
    public void nhap() {
        System.out.print("Nhap ho ten: ");
        setHoTen();
        System.out.print("Nhap chung minh thu: ");
        setCmt();
        System.out.print("Nhap dia chi: ");
        setDiaChi();
        System.out.print("Nhap so dien thoai: ");
        setSoDienThoai();
    }
    
    public void xuat() {
        System.out.printf("%-25s %-20s %-50s %-20s ", getHoTen(), getCmt(), getDiaChi(), getSoDienThoai());
    }
    
    public abstract void suaThongTin();
}
