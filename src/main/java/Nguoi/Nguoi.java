package Nguoi;
import HangHoa.PhanTu;
/**
 *
 * @author Tien Minh Vy
 */
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
        this.hoTen = sc.nextLine();
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
            if (!check) System.out.print("Moi nhap lai: ");
        } while (!check);
        this.soDienThoai = soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return super.toString();
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
        System.out.println("Ho ten: "+getHoTen());
        System.out.println("Chung minh nhan dan/Can cuoc cong dan: "+getCmt());
        System.out.println("Dia chi: "+getDiaChi());
        System.out.println("So dien thoai: "+getSoDienThoai());
    }
    
    public abstract void suaThongTin();
}
