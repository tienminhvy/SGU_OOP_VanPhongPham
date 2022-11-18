package DanhSach;
import HangHoa.HoaDon;
import HangHoa.PhanTu;
import java.util.Scanner;


public class DanhSachHoaDon implements ThaoTacDanhSach {
    private int soLuong = 0;
    private static PhanTu[] dsHoaDon;
    Scanner sc = new Scanner(System.in);
    
    public DanhSachHoaDon() {
        
    }
    
    public int getsoLuong(){
        return soLuong;
    }
    
    public void setsoLuong(int soLuong){
        this.soLuong = soLuong;
    }
    
    public static HoaDon[] getdsHoaDon() {
        return (HoaDon[]) dsHoaDon;
    }
    
    public void setdsHoaDon(PhanTu[] dsHoaDon){
        this.dsHoaDon = dsHoaDon;
    }

    @Override
    public void nhapDanhSach() {
        System.out.println("Moi nhap so luong hoa don:");
        soLuong = sc.nextInt();
        dsHoaDon = new HoaDon[soLuong];
        for(int i=0;i<soLuong;i++){
            dsHoaDon[i] = new HoaDon();
            dsHoaDon[i].nhap();
        }
    }

    @Override
    public void xuatDanhSach() {
        System.out.println("Danh sach hoa don: ");
        for(int i=0;i<soLuong;i++) {
            dsHoaDon[i].xuat();
        }
    }

    @Override
    public void themVaoDanhSach(PhanTu pt) {
        PhanTu[] dsHoaDonTemp = new PhanTu[soLuong+1];
        for(int i=0;i<soLuong;i++)
            dsHoaDonTemp[i] = dsHoaDon[i];
        dsHoaDonTemp[soLuong] = pt;
        setdsHoaDon(dsHoaDonTemp);
    }

    @Override
    public void themKPhanTuVaoDanhSach() {
        System.out.println("Nhap so luong hoa don can them vào danh sach: ");
        int sl = Integer.parseInt(sc.nextLine());
        PhanTu pt;
        for(int i=0;i<sl;i++)
        {
            pt = new HoaDon();
            pt.nhap();
            themVaoDanhSach(pt);
        }
    }

    @Override
    public void chinhSuaThongTinPhanTu() {
        System.out.println("Tim hoa don can chinh sua: ");
        int viTri = timViTriPhanTu();
        if (viTri != -1) dsHoaDon[viTri].suaThongTin();
    }

    @Override
    public void xoaPhanTu() {
        System.out.println("Tim hoa don can xoa: ");
        int viTri = timViTriPhanTu();
        if (viTri != -1) {
            PhanTu[] dsHoaDonTemp = new PhanTu[soLuong-1];
            for(int i=0, k=0;i<soLuong;i++) {
                if (i==viTri) continue;
                dsHoaDonTemp[k++] = dsHoaDon[i];
            }
            setdsHoaDon(dsHoaDonTemp);
        } else System.out.println("Khong tim thay san pham!");
    }

    @Override
    public PhanTu timPhanTu() {
        System.out.print("Nhap so hoa don can tim: ");
        int soHoaDonCanTim = Integer.parseInt(sc.nextLine());
        HoaDon[] dsHoaDonTmp = getdsHoaDon();
        for(int i=0;i<soLuong;i++) {
            if (dsHoaDonTmp[i].getSoHoaDon() == soHoaDonCanTim)
                return dsHoaDonTmp[i];
        }
        return null;
    }
    
    @Override
    public int timViTriPhanTu() {
        System.out.print("Nhap so hoa don can tim: ");
        int soHoaDonCanTim = Integer.parseInt(sc.nextLine());
        HoaDon[] dsHoaDonTmp = getdsHoaDon();
        for(int i=0;i<soLuong;i++) {
            if (dsHoaDonTmp[i].getSoHoaDon() == soHoaDonCanTim)
                return i;
        }
        return -1;
    }
    
    @Override
    public PhanTu layPhanTuVoi(String thamSo) {
        HoaDon[] dsHoaDonTmp = getdsHoaDon();
        for(int i=0;i<soLuong;i++) {
            if (dsHoaDonTmp[i].getSoHoaDon() == Integer.parseInt(thamSo))
                return dsHoaDonTmp[i];
        }
        return null;
    }

    @Override
    public void thongKe() {
    
    }

    @Override
    public void tongSL() {
    
    }
}
