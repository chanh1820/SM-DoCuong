package com.example.schoolmanagement_01.core.dto;

public class PointDTO {

    private Integer id;

    private String week;

    private String classRoom;

    private Integer soTiet;

    private Integer diemNguoiTotViecTot;

    private Integer diemPhongTrao;

    private Integer diemDocSach;

    private String tenTuyenDuong;

    public PointDTO() {
    }


    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public Integer getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(Integer soTiet) {
        this.soTiet = soTiet;
    }

    public Integer getDiemNguoiTotViecTot() {
        return diemNguoiTotViecTot;
    }

    public void setDiemNguoiTotViecTot(Integer diemNguoiTotViecTot) {
        this.diemNguoiTotViecTot = diemNguoiTotViecTot;
    }

    public Integer getDiemPhongTrao() {
        return diemPhongTrao;
    }

    public void setDiemPhongTrao(Integer diemPhongTrao) {
        this.diemPhongTrao = diemPhongTrao;
    }

    public Integer getDiemDocSach() {
        return diemDocSach;
    }

    public void setDiemDocSach(Integer diemDocSach) {
        this.diemDocSach = diemDocSach;
    }

    public String getTenTuyenDuong() {
        return tenTuyenDuong;
    }

    public void setTenTuyenDuong(String tenTuyenDuong) {
        this.tenTuyenDuong = tenTuyenDuong;
    }
}
