package HangHoa;
import DanhSach.*;
import Nguoi.*;
import ThanhToan.CKNganHang;
import ThanhToan.CKTinDung;
import ThanhToan.CKViDienTu;
import ThanhToan.ThanhToan;

public class HoaDon extends PhanTu {
   private int soHoaDon;
   private int soLuongSanPham;
   private int tongTien = 0;
   private String phThThanhToan;
   private KhachHang khachHang;
   private NhanVien thuNgan;
   private SanPham[] dsSanPham;

    public HoaDon() {
    }

    public HoaDon(int soHoaDon, int soLuongSanPham, KhachHang khachHang, NhanVien thuNgan, SanPham[] dsSanPham) {
        this.soHoaDon = soHoaDon;
        this.soLuongSanPham = soLuongSanPham;
        this.khachHang = khachHang;
        this.thuNgan = thuNgan;
        this.dsSanPham = dsSanPham;
    }
    
    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setKhachHang() {
        DanhSachKhachHang ttds = new DanhSachKhachHang();
        PhanTu pt;
        String maKhachHang;
        int chon;
        do {
            System.out.println("Ban co muon xuat ra man hinh danh sach khach hang khong? (1 - in, 0 - khong)");
            chon = Integer.parseInt(sc.nextLine());
            chon = (chon==0) ? 0 : 1;

            if (chon == 1) ttds.xuatDanhSach();

            System.out.print("Nhap ma khach hang: ");
            maKhachHang = sc.nextLine();
            
            pt = ttds.layPhanTuVoi(maKhachHang);
            
            if (pt == null) {
                System.out.println("Khong tim thay khach hang!");
                System.out.println("Ban co muon them khach hang moi khong? (1 - them, 0 - khong)");
                chon = Integer.parseInt(sc.nextLine());
                chon = (chon==0) ? 0 : 1;

                if (chon == 1) {
                    pt = new KhachHang();
                    pt.nhap();
                    ttds.themVaoDanhSach(pt);
                    khachHang = (KhachHang) pt;
                }

            } else khachHang = (KhachHang) pt;
            
        } while(pt == null);
    }

    public NhanVien getThuNgan() {
        return thuNgan;
    }

    public void setThuNgan(NhanVien thuNgan) {
        this.thuNgan = thuNgan;
    }

    public void setThuNgan() {
        DanhSachNhanVien ttds = new DanhSachNhanVien();
        NhanVien pt;
        do {
            System.out.print("Nhap ma nhan vien la thu ngan: ");
            
            pt = (NhanVien) ttds.layPhanTuVoi(sc.nextLine());
            
            if (pt == null) System.out.println("Khong tim thay nhan vien!");
            else thuNgan = pt;
        } while(pt == null);
    }

    public PhanTu[] getDsSanPham() {
        return dsSanPham;
    }

    public void setDsSanPham(SanPham[] dsSanPham) {
        this.dsSanPham = dsSanPham;
    }

    public void setDsSanPham() {
        // Khai b??o
        DanhSachSanPham ttds = new DanhSachSanPham();
        DanhSachDanhMucSP dmsp = new DanhSachDanhMucSP();
        DanhSachKhachHang dskh = new DanhSachKhachHang();
        
        SanPham[] dsspFile = ttds.getdsSanPham();
        SanPham[] dssp = new SanPham[soLuongSanPham];
        
        SanPham pt, timThay;
        int slcl, vtsp, stt, chon;
        // xem l???i danh m???c s???n ph???m (tu??? ch???n)
        System.out.print("Ban co muon xem lai danh sach san pham? (0 - khong, 1 - xem):");
        chon = Integer.parseInt(sc.nextLine());
        
        if (chon==1) dmsp.xuatDanhSach();
        
        for(int i=0;i<soLuongSanPham;i++) {
            stt=i+1;
            System.out.println("Them san pham thu "+stt);
            
            do {
                System.out.print("Nhap ma san pham:");
                pt = (SanPham) ttds.layPhanTuVoi(sc.nextLine());
                
                if (pt == null) 
                    System.out.println("Khong tim thay san pham!");
                else {
                    dssp[i] = pt;
                    
                    if (pt.getSoLuong() == 0) { // n???u s???n ph???m ???? h???t h??ng
                        System.out.println("San pham da het hang, vui long chon san pham khac!");
                        pt=null;
                        continue;
                    }
                    
                    // t??m s???n ph???m trong danh s??ch sp v???i m?? s???n ph???m
                    timThay = (SanPham) ttds.layPhanTuVoi(pt.getMaSanPham());
                    
                    do {
                        pt.setSoLuong();
                        
                        // t??nh to??n s??? l?????ng s???n ph???m c??n l???i
                        slcl = timThay.getSoLuong()-pt.getSoLuong();
                        
                        // n???u v?????t qu?? s??? l?????ng s???n ph???m hi???n c??
                        if (slcl < 0) System.out.println("So luong san pham khong du! San pham hien tai con: " + timThay.getSoLuong());
                    } while (slcl < 0);
                    
                    // gi???m s??? l?????ng s???n ph???m trong danh s??ch v?? ???? th??m s???n ph???m v??o ho?? ????n.
                    timThay.setSoLuong(timThay.getSoLuong()-pt.getSoLuong());
                    
                    // t??m v??? tr?? s???n ph???m ???? nh???p trong danh s??ch
                    vtsp = ttds.timViTriSanPham(pt.getMaSanPham());
                    
                    // c???p nh???t l???i s??? l?????ng s???n ph???m
                    dsspFile[vtsp] = timThay;
                    ttds.setdsSanPham(dsspFile);
                    
                    // c???p nh???t t???ng ti???n
                    tongTien += pt.getGia() * pt.getSoLuong();
                }
            } while (pt == null);
        }
        // T??m kh??ch h??ng trong danh s??ch
        KhachHang[] dsKhTemp = dskh.getDsKhachHang();
        int vtkh = dskh.timViTriKhachHang(khachHang.getMaKhachHang());
        
        // l???y thu???c t??nh t???ng ti???n ???? thanh to??n v?? s??? ????n h??ng ???? thanh to??n
        int tienTam = dsKhTemp[vtkh].getTongTienDaThanhToan();
        int dhDaThanhToan = dsKhTemp[vtkh].getSoDonHangDaThanhToan();
        
        tienTam += tongTien; // c???ng s??? ti???n c???a c??? ho?? ????n ???? nh???p
        
        // N???u l?? ch???nh s???a danh s??ch s???n ph???m
        if (dsSanPham != null) {
            if (dsSanPham.length > 0) { // n???u danh s??ch s???n ph???m > 0
                int tongTienTraLai = 0;
                int viTriCanChinhSua;
                for(SanPham x: dsSanPham) // ???ng v???i t???ng ph???n t???
                {
                    // t??m s???n ph???m trong danh s??ch v???i m?? s???n ph???m
                    timThay = (SanPham) ttds.layPhanTuVoi(x.getMaSanPham());
                    
                    // t??ng s??? l?????ng s???n ph???m trong danh s??ch v?? xo?? s???n ph???m kh???i ho?? ????n
                    timThay.setSoLuong(timThay.getSoLuong()+x.getSoLuong());
                    
                    // t??m v??? tr?? s???n ph???m c???n ch???nh s???a trong danh s??ch
                    viTriCanChinhSua = ttds.timViTriSanPham(x.getMaSanPham());
                    dsSanPham[viTriCanChinhSua] = timThay;
                    
                    // c???p nh???t l???i danh s??ch
                    ttds.setdsSanPham(dsSanPham);
                    
                    // t??m t???ng ti???n c???n tr??? l???i cho kh??ch
                    tongTienTraLai += x.getGia() * x.getSoLuong();
                }
                
                tienTam -= tongTienTraLai;
            }
        } else dhDaThanhToan++; // n???u ????n h??ng m???i ho??n to??n
        
        // l??u l???i
        dsKhTemp[vtkh].setTongTienDaThanhToan(tienTam);
        dsKhTemp[vtkh].setSoDonHangDaThanhToan(dhDaThanhToan);
        dskh.setDsKhachHang(dsKhTemp);
        
        dsSanPham = dssp;
    }
   
    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon() {
        System.out.print("Nhap so hoa don: ");
        DanhSachHoaDon ttds = new DanhSachHoaDon();
        boolean check;
        do
        {
            check = true;
            try {
                soHoaDon = Integer.parseInt(sc.nextLine());
                check = ttds.layPhanTuVoi(soHoaDon+"") == null;
                if (!check) System.out.print("So hoa don da ton tai, moi nhap lai: ");
            } catch (Exception e) {
                check = false;
                System.out.print("Vui long nhap mot so: ");
            }
        } while (!check);
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public void setSoLuongSanPham() {
        boolean check;
        do
        {
            check = true;
            try {
                System.out.print("Nhap so luong san pham: ");
                soLuongSanPham = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                check = false;
                System.out.print("Vui long nhap mot so: ");
            }
        } while (!check);
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getPhThThanhToan() {
        return phThThanhToan;
    }

    public void setPhThThanhToan(String phThThanhToan) {
        this.phThThanhToan = phThThanhToan;
    }
    
    public void setPhThThanhToan() {
        System.out.println("Moi chon phuong thuc thanh toan cho hoa don nay: ");
        System.out.println("1. Tien mat");
        System.out.println("2. Tai khoan ngan hang");
        System.out.println("3. Tai khoan the tin dung");
        System.out.println("4. Vi dien tu");
        System.out.print("Chon: ");
        int chon, chontl = 0;
        // c??c bi???n l???a ch???n
        KhachHang[] dsKhachHang;

        do{
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui long nhap mot so!");
                continue;
            }
            switch (chon) {
                case 1:
                    phThThanhToan = "TienMat";
                    break;
                case 2:
                    phThThanhToan = "CK_NganHang";
                    break;
                case 3:
                     phThThanhToan = "CK_TinDung";
                    break;
                case 4:
                     phThThanhToan = "CK_ViDienTu";
                    break;
                default:
                    chon = 0;
                    break;
            }
            
            if(chon == 0)
            { // n???u ng?????i d??ng nh???p s??? kh??c c??c s??? tr??n
                System.out.print("Moi chon lai: ");
                continue;
            }
            
            
            if (chon == 1) break; // ph th???c ti???n m???t
            
            // ki???m tra
            DanhSachKhachHang dskh = new DanhSachKhachHang();
        
            int maKH = getKhachHang().getMaKhachHang();
            int vtkh = dskh.timViTriKhachHang(maKH);
            
            dsKhachHang = dskh.getDsKhachHang();

            ThanhToan pttt = dsKhachHang[vtkh].getPhThThanhToan();
            
            switch (chon) { // n???u ch???n ????ng ph????ng th???c
                case 2:
                    if (pttt.getPTNganHang() == null) chontl = 1;
                    break;
                case 3:
                    if (pttt.getPTTinDung()== null) chontl = 1;
                    break;
                case 4:
                    if (pttt.getPTViDienTu()== null) chontl = 1;
                    break;
                default:
                    chontl = 1;
                    break;
            }
            
            if (chontl == 1) {
                System.out.println("Khach hang chua thiet lap phuong thuc thanh toan nay!");

                System.out.print("Ban co muon thiet lap phuong thuc thanh toan cho khach hang nay khong? (1 - co, 0 - khong): ");
                chontl = Integer.parseInt(sc.nextLine());
                chontl = (chontl == 1) ? 1 : 0;

                if (chontl == 1) { // n???u ch???n thi???t l???p
                    System.out.println("Moi chon phuong thuc thanh toan cho khach hang nay: ");
                    System.out.println("1. Tai khoan ngan hang");
                    System.out.println("2. Tai khoan the tin dung");
                    System.out.println("3. Vi dien tu");
                    System.out.print("Chon: ");
                    chon = Integer.parseInt(sc.nextLine());
                    switch (chon) {
                        case 1:
                            CKNganHang cknh = new CKNganHang();
                            cknh.nhapThongTin();
                            dsKhachHang[vtkh].getPhThThanhToan().setPTNganHang(cknh);
                            break;
                        case 2:
                            CKTinDung cktd = new CKTinDung();
                            cktd.nhapThongTin();
                            dsKhachHang[vtkh].getPhThThanhToan().setPTTinDung(cktd);
                            break;
                        case 3:
                            CKViDienTu ckvdt = new CKViDienTu();
                            ckvdt.nhapThongTin();
                            dsKhachHang[vtkh].getPhThThanhToan().setPTViDienTu(ckvdt);
                            break;
                        default:
                            System.out.print("Moi chon phuong thuc thanh toan khac: ");
                            chontl = 0;
                            break;
                    }
                    dskh.setDsKhachHang(dsKhachHang);
                } else System.out.print("Moi chon phuong thuc thanh toan khac: ");
            }
        }while (chontl == 0);
    }
    
    @Override
    public void nhap(){
        setSoHoaDon();
        setSoLuongSanPham();
        setKhachHang();
        setThuNgan();
        setDsSanPham();
        setPhThThanhToan();
    }

    @Override
    public void xuat() {
        System.out.printf("%-20s %-20s %-20s %-25s %-25s %-30s\n", "So hoa don", "So luong san pham", "Tong tien", "Ten khach hang", "Ten thu ngan", "Phuong thuc thanh toan");
        System.out.printf("%-20s %-20s %-20s %-25s %-25s %-30s \n", soHoaDon, soLuongSanPham, tongTien, khachHang.getHoTen(), thuNgan.getHoTen(), phThThanhToan);
        System.out.println("Danh sach san pham: ");
        System.out.printf("%-20s %-50s %-20s %-20s %-20s %-20s \n","Ma san pham", "Ten san pham", "Thuong hieu", "Noi san xuat", "So luong", "Gia");
        for(int i=0;i<dsSanPham.length;i++)
            dsSanPham[i].xuat();
        System.out.println("**************************");
    }

    @Override
    public void suaThongTin() {
        System.out.println("=== Sua thong tin hoa don ===");
        System.out.println("1. Sua so hoa don");
        System.out.println("2. Sua ma khach hang");
        System.out.println("3. Sua ma thu ngan");
        System.out.println("4. Sua danh sach san pham");
        System.out.println("5. Sua phuong thuc thanh toan");
        System.out.println("0. Quay ve menu quan ly san pham");
        System.out.println("===============================");
        int chon;
        do {
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 0:
                    break;
                case 1:
                    System.out.println("Thong tin hien tai: "+getSoHoaDon());
                    setSoHoaDon();
                    break;
                case 2:
                    System.out.println("Thong tin hien tai: "+getKhachHang().getMaKhachHang());
                    setKhachHang();
                    break;
                case 3:
                    System.out.println("Thong tin hien tai: "+getThuNgan().getMaNhanVien());
                    setThuNgan();
                    break;
                case 4:
                    System.out.println("Thong tin hien tai: ");
                    // xu???t danh s??ch s???n ph???m
                    SanPham[] dssp = (SanPham[]) getDsSanPham();
                    for(int i=0;i<dssp.length;i++)
                        dssp[i].xuat();
                    
                    System.out.println("Nhap moi danh sach san pham: ");
                    setSoLuongSanPham();
                    setDsSanPham();
                    break;
                case 5:
                    System.out.println("Thong tin hien tai: "+getPhThThanhToan());
                    setPhThThanhToan();
                    break;
                default:
                    System.out.println("Hay chon lai!");
                    break;
            }
        } while(chon!=0);
    }
}