package com.example.schoolmanagement_01.core.dto;

public class SummaryDTO {

    private Integer id;

    private String classRoom;

    private String diemSTD;

    private String diemTPT;

    private String diemNTVT;

    private String diemPhongTrao;

    private String diemDocSach;

    private String tongDiem;

    private String hang;

    private Boolean tuyenDuong;

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

    public String getDiemSTD() {
        return diemSTD;
    }

    public void setDiemSTD(String diemSTD) {
        this.diemSTD = diemSTD;
    }

    public String getDiemTPT() {
        return diemTPT;
    }

    public void setDiemTPT(String diemTPT) {
        this.diemTPT = diemTPT;
    }

    public String getDiemNTVT() {
        return diemNTVT;
    }

    public void setDiemNTVT(String diemNTVT) {
        this.diemNTVT = diemNTVT;
    }

    public String getDiemPhongTrao() {
        return diemPhongTrao;
    }

    public void setDiemPhongTrao(String diemPhongTrao) {
        this.diemPhongTrao = diemPhongTrao;
    }

    public String getDiemDocSach() {
        return diemDocSach;
    }

    public void setDiemDocSach(String diemDocSach) {
        this.diemDocSach = diemDocSach;
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

    public Boolean getTuyenDuong() {
        return tuyenDuong;
    }

    public void setTuyenDuong(Boolean tuyenDuong) {
        this.tuyenDuong = tuyenDuong;
    }

    public String getHocSinhTuyenDuong() {
        return hocSinhTuyenDuong;
    }

    public void setHocSinhTuyenDuong(String hocSinhTuyenDuong) {
        this.hocSinhTuyenDuong = hocSinhTuyenDuong;
    }
}
