package DanhSach;
import HangHoa.PhanTu;
import Nguoi.Nguoi;
/**
 *
 * @author Tien Minh Vy
 */
interface ThaoTacDanhSach {
    public void nhapDanhSach();
    public void xuatDanhSach();
    public void themVaoDanhSach(PhanTu pt);
    public void themKPhanTuVaoDanhSach();
    public void chinhSuaThongTinPhanTu();
    public void xoaPhanTu();
    public PhanTu timPhanTu();
    public int timViTriPhanTu();
    public PhanTu layPhanTuVoi(String thamSo);
    public void thongKe();
    public void tongSL();
}

