package com.example.schoolmanagement_01.core.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.schoolmanagement_01.core.DBHelper;
import com.example.schoolmanagement_01.core.dto.PointDTO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.RuleDTO;
import com.example.schoolmanagement_01.core.dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class GeneralDAO {

    DBHelper dbHelper;

    public GeneralDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public List<StudentDTO> findStudentByClassRoom(String classRoom) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM student_tbl as s where s.class_room = " + "'" + classRoom+ "'";
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        if (cursor.getCount() != 0) {
            do {
                StudentDTO item;
                item = new StudentDTO(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                );
                studentDTOList.add(item);
            } while (cursor.moveToNext());
        }
        return studentDTOList;
    }

    public void saveReport(ReportDTO reportDTO){

        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("week",reportDTO.getWeek());
        values.put("class",reportDTO.getClassRoom());
        values.put("rule_name",reportDTO.getRuleName());
        values.put("ruleId",reportDTO.getRuleId());
        values.put("student_name",reportDTO.getStudentName());
        values.put("minus_point",reportDTO.getMinusPoint());
        values.put("path_image",reportDTO.getPathImage());
        values.put("created_date",reportDTO.getCreatedDate());
        values.put("collection_code",reportDTO.getCollectionCode());
        values.put("group_code",reportDTO.getGroupCode());
        db.insert("report_tbl", null, values);
        db.close();
    }
    public Long savePoint(PointDTO pointDTO){
        PointDTO pointDTOExisting = findPointByWeekAndClass(pointDTO.getWeek(), pointDTO.getClassRoom());
        if (pointDTOExisting!=null){
            return Long.valueOf(-1);
        }
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("week",pointDTO.getWeek());
        values.put("class_room",pointDTO.getClassRoom());
        values.put("so_tiet",pointDTO.getSoTiet());
        values.put("diem_ntvt",pointDTO.getDiemNguoiTotViecTot());
        values.put("diem_phong_trao",pointDTO.getDiemPhongTrao());
        values.put("diem_doc_sach",pointDTO.getDiemDocSach());
        values.put("hoc_sinh_tuyen_duong",pointDTO.getTenTuyenDuong());
        Long id = db.insert("point_tbl", null, values);
        db.close();
        return id;
    }

    public Cursor findReportCursorByWeekAndClass(String week, String classRoom){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM report_tbl as s where s.week = " + "'" + week +"' AND " +"s.class='"+classRoom+"'";
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public List<ReportDTO> findReportByWeekAndClass(String week, String classRoom){
        List<ReportDTO> reportDTOList = new ArrayList<>();
        Cursor cursor = findReportCursorByWeekAndClass(week,classRoom);
        if (cursor.getCount() != 0) {
            do {
                ReportDTO item;
                item = new ReportDTO( );
                item.setWeek(cursor.getString(1));
                item.setClassRoom(cursor.getString(2));
                item.setRuleName(cursor.getString(3));
                item.setRuleId(cursor.getInt(4));
                item.setStudentName(cursor.getString(5));
                item.setMinusPoint(cursor.getInt(6));
                item.setPathImage(cursor.getString(7));
                item.setCreatedDate(cursor.getString(8));
                item.setCollectionCode(cursor.getString(9));
                item.setGroupCode(cursor.getString(10));
                reportDTOList.add(item);
            } while (cursor.moveToNext());
        }
        return reportDTOList;
    }
    public PointDTO findPointByWeekAndClass(String week, String classRoom){
        PointDTO item = new PointDTO();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM point_tbl as s where s.week = " + "'" + week +"' AND " +"s.class_room='"+classRoom+"'";
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }else {
            return null;
        }
        if (cursor.getCount() != 0) {
            do {
                item = new PointDTO();
                item.setWeek(cursor.getString(1));
                item.setClassRoom(cursor.getString(2));
                item.setSoTiet(cursor.getInt(3));
                item.setDiemNguoiTotViecTot(cursor.getInt(4));
                item.setDiemPhongTrao(cursor.getInt(5));
                item.setDiemDocSach(cursor.getInt(6));
                item.setTenTuyenDuong(cursor.getString(7));
            } while (cursor.moveToNext());
        }else {
            return null;
        }
        return item;
    }

    public void clearPonintByWeekAndClass(String week, String classRoom) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "DELETE FROM point_tbl where week = " + "'" + week +"' AND " +"class_room='"+classRoom+"'";
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
    }
}

