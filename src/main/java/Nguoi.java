/**
 *
 * @author Tien Minh Vy
 */
import java.util.Scanner;
public class Nguoi {
    private String hoTen;
    private String ngaySinh;
    private String cmt;
    private String diaChi;
    private String soDienThoai;
    
    public static Scanner sc = new Scanner(System.in);

    public Nguoi() {
    }

    public Nguoi(String hoTen, String ngaySinh, String cmt, String diaChi, String soDienThoai) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh() {
        boolean check = true;
        int ngay, thang, nam;
        do {
            System.out.print("Nhap ngay: ");
            ngay = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap thang: ");
            thang = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap nam: ");
            nam = Integer.parseInt(sc.nextLine());
            
            if (ngay <= 0 || ngay > 31) check = false;
            if (thang <= 0 || ngay > 12) check = false;
            if (nam <= 1920 || nam > 2022) check = false;
            
            if (nam % 400 == 0 || (nam % 4 == 0 && nam % 100 != 0)) {
                // nam nhuan
                if (thang == 2) {
                    if (ngay > 29) check = false;
                }
            } else {
                if (thang == 2) {
                    if (ngay > 28) check = false;
                }
            }
            
            switch (thang) {
                case 4,6,9,11:
                    if (ngay > 30) check = false;
                    break;
            }
            
            if (2022 - nam < 18) check = false;
            
        } while (!check);
        this.ngaySinh = ngay+"/"+thang+"/"+nam;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt() {
        String cmt;
        boolean check = true;
        do {
            cmt = sc.nextLine();
            if (cmt.length() == 9) break;
            if (cmt.length() == 12) break;
        } while(!check);
        this.cmt = cmt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi() {
        this.diaChi = sc.nextLine();
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai() {
        boolean check = true;
        String soDienThoai;
        do {
            soDienThoai = sc.nextLine();
            if (soDienThoai.indexOf("0") != 0) check = false;
            if (soDienThoai.length() != 10) check = false;
        } while (!check);
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    public void nhap() {
        System.out.print("Nhap ho ten: ");
        setHoTen();
        System.out.print("Nhap ngay sinh: ");
        setNgaySinh();
        System.out.print("Nhap chung minh thu: ");
        setCmt();
        System.out.print("Nhap dia chi: ");
        setDiaChi();
        System.out.print("Nhap so dien thoai: ");
        setSoDienThoai();
    }
    
    public void xuat() {
        System.out.println("Ho ten: "+getHoTen());
        System.out.println("Ngay Sinh: "+getNgaySinh());
        System.out.println("Chung minh nhan dan/Can cuoc cong dan: "+getCmt());
        System.out.println("Dia chi: "+getDiaChi());
        System.out.println("So dien thoai: "+getSoDienThoai());
    }
}
