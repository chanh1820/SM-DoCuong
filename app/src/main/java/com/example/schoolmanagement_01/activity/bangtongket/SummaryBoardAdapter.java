package com.example.schoolmanagement_01.activity.bangtongket;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.dto.ClassRoomDTO;
import com.example.schoolmanagement_01.core.dto.SummaryDTO;

import java.util.ArrayList;
import java.util.List;

public class SummaryBoardAdapter extends ArrayAdapter<SummaryDTO> {


    public SummaryBoardAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SummaryDTO> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listview_summary, parent, false);
        }

        TextView tvClassRoom = convertView.findViewById(R.id.tv_class_room_summary);
        TextView tvDiemSTD = convertView.findViewById(R.id.tv_diem_std);
        TextView tvDiemTPT = convertView.findViewById(R.id.tv_diem_tpt);
        TextView tvDiemNTVT = convertView.findViewById(R.id.tv_diem_ntvt);
        TextView tvDiemPhongTrao = convertView.findViewById(R.id.tv_diem_phong_trao);
        TextView tvDiemDocSach = convertView.findViewById(R.id.tv_diem_doc_sach);
        TextView tvTuyenDuong = convertView.findViewById(R.id.tv_tuyen_duong);
        TextView tvStudentTuyenDuong = convertView.findViewById(R.id.tv_student_tuyen_duong);
        TextView tvTong = convertView.findViewById(R.id.tv_tong_diem);
        TextView tvHang = convertView.findViewById(R.id.tv_xep_hang);


        SummaryDTO summaryDTO = getItem(position);
        tvClassRoom.setText(summaryDTO.getClassRoom());
        tvDiemSTD.setText(summaryDTO.getDiemSTD());
        tvDiemTPT.setText(summaryDTO.getDiemTPT());
        tvDiemNTVT.setText(summaryDTO.getDiemNTVT());
        tvDiemPhongTrao.setText(summaryDTO.getDiemPhongTrao());
        tvDiemDocSach.setText(summaryDTO.getDiemDocSach());
        tvStudentTuyenDuong.setText(summaryDTO.getHocSinhTuyenDuong());
        tvTong.setText(summaryDTO.getTongDiem());
        tvHang.setText(summaryDTO.getHang());

        if(summaryDTO.getTuyenDuong()==Boolean.TRUE){
            tvTuyenDuong.setText("✔");
        }else {
            tvTuyenDuong.setText("");
        }
        return convertView;
    }
}
