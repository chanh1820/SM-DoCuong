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
        if(pointDTO == null){
            summaryDTO.setClassRoom(classRoom);
            summaryDTO.setDiemSTD("");
            summaryDTO.setDiemTPT("");
            summaryDTO.setDiemNTVT("");
            summaryDTO.setDiemPhongTrao("");
            summaryDTO.setDiemDocSach("");
            summaryDTO.setTongDiem("0");
            summaryDTO.setHocSinhTuyenDuong("");
            return summaryDTO;
        }
        float totalPointSTD = DBConstants.POINT_ONE_LESSION * pointDTO.getSoTiet();//1000
        float totalPointTPT = DBConstants.POINT_ONE_LESSION * pointDTO.getSoTiet();//1000
        // calculator Diem

        for (ReportDTO item: reportDTOList) {
            switch (item.getGroupCode()){
                case DBConstants.RULE_GROUP_CODE_STD:
                    totalPointSTD -= Math.abs(item.getMinusPoint());
                    break;
                case DBConstants.RULE_GROUP_CODE_TPT:
                    totalPointTPT -= Math.abs(item.getMinusPoint());
                    break;
                default:
                    Log.e("not found", item.getGroupCode());
                    break;
            }
        }
        float pointSTD = totalPointSTD / DBConstants.POINT_ONE_LESSION;
        float pointTPT = totalPointTPT / DBConstants.POINT_ONE_LESSION;
        float tongDiem = pointSTD+ pointTPT + pointDTO.getDiemNguoiTotViecTot() + pointDTO.getDiemDocSach() + pointDTO.getDiemPhongTrao();
        Log.e("pointSTD", String.valueOf(pointSTD));
        Log.e("pointTPT", String.valueOf(pointTPT));
        Log.e("tongDiem", String.valueOf(tongDiem));
        summaryDTO.setClassRoom(classRoom);
        summaryDTO.setDiemSTD(String.format("%.2f", pointSTD));
        summaryDTO.setDiemTPT(String.format("%.2f", pointTPT));
        summaryDTO.setDiemNTVT(pointDTO.getDiemNguoiTotViecTot().toString());
        summaryDTO.setDiemPhongTrao(pointDTO.getDiemPhongTrao().toString());
        summaryDTO.setDiemDocSach(pointDTO.getDiemDocSach().toString());
        summaryDTO.setHocSinhTuyenDuong(pointDTO.getTenTuyenDuong().toString());
        summaryDTO.setTongDiem(String.format("%.2f", tongDiem));
        return summaryDTO;
    }
}
