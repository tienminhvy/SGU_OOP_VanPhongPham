/**
 *
 * @author Tien Minh Vy
 */
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
        super(hoTen, ngaySinh, cmt, diaChi, soDienThoai);
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
    
    
}
