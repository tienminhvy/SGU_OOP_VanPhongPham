package Nguoi;

/**
 *
 * @author Tien Minh Vy
 */
import static Nguoi.NhanVien.sc;
import java.util.Scanner;
public class KhachHang extends Nguoi {
    private int soDonHangDaThanhToan;
    private int tongTienDaThanhToan;
    private int maKhachHang;
    public static Scanner sc = new Scanner(System.in);

    public KhachHang() {
    }

    public KhachHang(int soDonHangDaThanhToan, int tongTienDaThanhToan, int maKhachHang) {
        this.soDonHangDaThanhToan = soDonHangDaThanhToan;
        this.tongTienDaThanhToan = tongTienDaThanhToan;
        this.maKhachHang = maKhachHang;
    }

    public KhachHang(int soDonHangDaThanhToan, int tongTienDaThanhToan, int maKhachHang, String hoTen, String ngaySinh, String cmt, String diaChi, String soDienThoai) {
        super(hoTen, cmt, diaChi, soDienThoai);
        this.soDonHangDaThanhToan = soDonHangDaThanhToan;
        this.tongTienDaThanhToan = tongTienDaThanhToan;
        this.maKhachHang = maKhachHang;
    }

    public int getSoDonHangDaThanhToan() {
        return soDonHangDaThanhToan;
    }

    public void setSoDonHangDaThanhToan(int soDonHangDaThanhToan) {
        this.soDonHangDaThanhToan = soDonHangDaThanhToan;
    }

    public int getTongTienDaThanhToan() {
        return tongTienDaThanhToan;
    }

    public void setTongTienDaThanhToan(int tongTienDaThanhToan) {
        this.tongTienDaThanhToan = tongTienDaThanhToan;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = Integer.parseInt(maKhachHang);
    }

    @Override
    public void nhap() {
        System.out.print("Nhap ma khach hang: ");
        setMaKhachHang(sc.nextLine());
        super.nhap();
    }

    @Override
    public void xuat() {
        System.out.println("Ma khach hang: "+getMaKhachHang());
        super.xuat();
    }
    
    public static void xuat(KhachHang kh) {
        kh.xuat();
    }

    @Override
    public void suaThongTin() {
        System.out.println("=== Sua thong tin khach hang ===");
        System.out.println("1. Sua ho ten");
        System.out.println("2. Sua chung minh thu");
        System.out.println("3. Sua dia chi");
        System.out.println("4. Sua so dien thoai");
        System.out.println("===============================");
        int chon;
        do {
            System.out.print("Nhập lựa chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    System.out.println("Thong tin hien tai: "+getHoTen());
                    setHoTen();
                    break;
                case 2:
                    System.out.println("Thong tin hien tai: "+getCmt());
                    setCmt();
                    break;
                case 3:
                    System.out.println("Thong tin hien tai: "+getDiaChi());
                    setDiaChi();
                    break;
                case 4:
                    System.out.println("Thong tin hien tai: "+getSoDienThoai());
                    setSoDienThoai();
                    break;
                default:
                    chon = 0;
                    break;
            }
            if (chon==0) System.out.println("Hay chon lai!");
        } while(chon==0);
    }
}
