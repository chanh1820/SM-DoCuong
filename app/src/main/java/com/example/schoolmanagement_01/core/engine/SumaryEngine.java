package com.example.schoolmanagement_01.core.engine;

import android.util.Log;

import com.example.schoolmanagement_01.core.DBConstants;
import com.example.schoolmanagement_01.core.dto.PointDTO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.SummaryDTO;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.material.math.MathUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SumaryEngine {

    public static SummaryDTO calculatorSummary(String classRoom, PointDTO pointDTO, List<ReportDTO> reportDTOList) {
        SummaryDTO summaryDTO = new SummaryDTO();
        summaryDTO.setClassRoom(classRoom);
        if(pointDTO == null){
            summaryDTO.setNeNep("");
            summaryDTO.setDiemCong("");
            summaryDTO.setXepLoai("");
            summaryDTO.setTongDiem("0");
            summaryDTO.setHocSinhTuyenDuong("");
            return summaryDTO;
        }
        // calculator Diem
        Integer total = DBConstants.DEFAULT_POINT_OF_WEEK;
        Integer pointMinus = 0;
        Integer diemCong = pointDTO.getDiemNguoiTotViecTot() + pointDTO.getDiemPhongTrao();
        for (ReportDTO item: reportDTOList) {
            total -= Math.abs(item.getMinusPoint());
            pointMinus -= Math.abs(item.getMinusPoint());
        }
        total += diemCong;
        summaryDTO.setHocSinhTuyenDuong(pointDTO.getTenTuyenDuong().toString());
        summaryDTO.setNeNep(String.valueOf(pointMinus));
        summaryDTO.setDiemCong(String.valueOf(diemCong));
        summaryDTO.setTongDiem(String.valueOf(total));
        summaryDTO.setHocSinhTuyenDuong(pointDTO.getTenTuyenDuong());
        if(total > 410){
            summaryDTO.setXepLoai("Tốt");
        }else if (total>400 && total < 409 ){
            summaryDTO.setXepLoai("Khá");
        }else if (total>350 && total < 399 ){
            summaryDTO.setXepLoai("Trung bình");
        }else if (total<350 ){
            summaryDTO.setXepLoai("Yếu");
        }
        return summaryDTO;
    }
}
