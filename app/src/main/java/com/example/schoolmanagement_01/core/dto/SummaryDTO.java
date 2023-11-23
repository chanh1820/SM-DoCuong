package com.example.schoolmanagement_01.core.dto;

public class SummaryDTO {

    private Integer id;

    private String classRoom;

    private String neNep;

    private String diemCong;

    private String xepLoai;

    private String tongDiem;

    private String hang;

    private String hocSinhTuyenDuong;

    public SummaryDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(String tongDiem) {
        this.tongDiem = tongDiem;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }


    public String getHocSinhTuyenDuong() {
        return hocSinhTuyenDuong;
    }

    public void setHocSinhTuyenDuong(String hocSinhTuyenDuong) {
        this.hocSinhTuyenDuong = hocSinhTuyenDuong;
    }

    public String getNeNep() {
        return neNep;
    }

    public void setNeNep(String neNep) {
        this.neNep = neNep;
    }

    public String getDiemCong() {
        return diemCong;
    }

    public void setDiemCong(String diemCong) {
        this.diemCong = diemCong;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }
}
