package DanhSach;
import File.FileHandler;
import HangHoa.*;
import Nguoi.*;

public class DanhSachHoaDon implements ThaoTacDanhSach {
    private int soLuong;
    private HoaDon[] dsHoaDon;
    
    public DanhSachHoaDon() {
        dsHoaDon = getdsHoaDon();
    }
    
    public int getsoLuong(){
        return soLuong;
    }
    
    public void setSoLuong(int soLuong){
        this.soLuong = soLuong;
    }
    
    public HoaDon[] getdsHoaDon() { // đọc từ file
        String data = FileHandler.docFile("dshd.txt");
        // tách thành mảng các phần tử chuỗi
        String[] dArr = data.split("\n");
        
        // nếu file rỗng
        if (dArr[0].length() == 0) setSoLuong(0);
        else setSoLuong(Integer.parseInt(dArr[0]));
        
        dsHoaDon = new HoaDon[soLuong];
        HoaDon hd;
        SanPham sp;
        SanPham[] dssp;
        String[] lArr;
        int k = 0, m, slsp=0;
        // khởi tạo các đối tượng từ các class danh sách trung tâm
        DanhSachKhachHang ttdskh = new DanhSachKhachHang();
        DanhSachNhanVien ttdsnv = new DanhSachNhanVien();
        DanhSachSanPham ttdssp = new DanhSachSanPham();
        
        for (int i = 1; i < dArr.length; i++) {
            lArr = dArr[i].split("#");

            hd = new HoaDon();
            
            m = 0;

            hd.setSoHoaDon(Integer.parseInt(lArr[m++]));
            
            slsp = Integer.parseInt(lArr[m++]);
            
            hd.setSoLuongSanPham(slsp);
            
            hd.setTongTien(Integer.parseInt(lArr[m++]));
            
            hd.setKhachHang((KhachHang) ttdskh.layPhanTuVoi(lArr[m++]));
            
            hd.setThuNgan((NhanVien) ttdsnv.layPhanTuVoi(lArr[m++]));
            
            hd.setPhThThanhToan(lArr[m++]);
            
            // đọc danh sách sản phẩm
            dssp = new SanPham[slsp];
            for(int j=0;j<slsp;j++) {
                sp = (SanPham) ttdssp.layPhanTuVoi(lArr[m++]);
                sp.setSoLuong(Integer.parseInt(lArr[m++]));
                dssp[j] = sp;
            }
            
            hd.setDsSanPham(dssp);
            dsHoaDon[k++] = hd;
        }
        return dsHoaDon;
    }
    
    public void setdsHoaDon(PhanTu[] dsHoaDon){ // ghi file
        HoaDon hd;
        String tenFile = "dshd.txt";
        FileHandler.resetFile(tenFile);
        FileHandler.ghiFile(soLuong+"", tenFile);
        SanPham[] dssp;
        
        for(int i=0;i<soLuong;i++) {
            // đọc từng phần tử từ mảng dsHoaDon
            hd = (HoaDon) dsHoaDon[i];
            // khởi tạo dssp và đọc từng phần tử của danh sách
            dssp = new SanPham[hd.getSoLuongSanPham()];
            for(int j=0;j<dssp.length;j++) {
                dssp[j] = (SanPham) hd.getDsSanPham()[j];
            }
            FileHandler.themHd(hd.getSoHoaDon(),hd.getSoLuongSanPham(), hd.getTongTien(),
                    hd.getKhachHang().getMaKhachHang(),
                    hd.getThuNgan().getMaNhanVien(), hd.getPhThThanhToan(), dssp);
        }
        this.dsHoaDon = (HoaDon[])dsHoaDon;
    }

    @Override
    public void nhapDanhSach() {
        System.out.println("Moi nhap so luong hoa don:");
        
        soLuong = Integer.parseInt(sc.nextLine());
        
        dsHoaDon = new HoaDon[soLuong];
        
        int stt, soLuongTemp=0, soLuongCurrent = soLuong;;
        
        for(int i=0;i<soLuongCurrent;i++){
            dsHoaDon[i] = new HoaDon();
            stt = i+1;
            System.out.println("** Hoa don thu "+stt+" **");
            
            dsHoaDon[i].nhap();
            soLuong = ++soLuongTemp;
            setdsHoaDon(dsHoaDon);
        }
    }

    @Override
    public void xuatDanhSach() {
        System.out.println("=== Danh sach hoa don ===");
        System.out.printf("%-20s %-20s %-20s %-25s %-25s %-30s\n", "So hoa don", "So luong san pham", "Tong tien", "Ten khach hang", "Ten thu ngan", "Phuong thuc thanh toan");
        for(int i=0;i<soLuong;i++) {
            dsHoaDon[i].xuat();
        }
        System.out.println();
    }

    @Override
    public void themVaoDanhSach(PhanTu pt) {
        HoaDon[] dsHoaDonTemp = new HoaDon[soLuong+1];
        
        for(int i=0;i<soLuong;i++)
            dsHoaDonTemp[i] = dsHoaDon[i];
        dsHoaDonTemp[soLuong] = (HoaDon) pt;
        
        soLuong++;
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
        
        HoaDon[] dsHd = getdsHoaDon();
        
        if (viTri != -1) {
            dsHd[viTri].suaThongTin();
            setdsHoaDon(dsHd);
        } else System.out.println("Khong tim thay!");
    }

    @Override
    public void xoaPhanTu() {
        System.out.println("Tim hoa don can xoa: ");
        
        int viTri = timViTriPhanTu();
        
        if (viTri != -1) {
            
            HoaDon[] dsHoaDonTemp = new HoaDon[soLuong-1];
            
            for(int i=0, k=0;i<soLuong;i++) {
                if (i==viTri) continue; // bỏ phần tử
                dsHoaDonTemp[k++] = dsHoaDon[i];
            }
            
            soLuong--;
            setdsHoaDon(dsHoaDonTemp);
        } else System.out.println("Khong tim thay san pham!");
    }

    @Override
    public PhanTu timPhanTu() { // tìm hoá đơn theo tên hoặc khoá (tương đối || tuyệt đối)
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
}
