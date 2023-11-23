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
        TextView tvNeNep = convertView.findViewById(R.id.tv_ne_nep);
        TextView tvDiemCong = convertView.findViewById(R.id.tv_diem_cong);
        TextView tvStudentTuyenDuong = convertView.findViewById(R.id.tv_student_tuyen_duong);
        TextView tvTong = convertView.findViewById(R.id.tv_tong_diem);
        TextView tvXepLoai = convertView.findViewById(R.id.tv_xep_loai);
        TextView tvHang = convertView.findViewById(R.id.tv_xep_hang);


        SummaryDTO summaryDTO = getItem(position);
        tvClassRoom.setText(summaryDTO.getClassRoom());
        tvNeNep.setText(summaryDTO.getNeNep());
        tvDiemCong.setText(summaryDTO.getDiemCong());
        tvXepLoai.setText(summaryDTO.getXepLoai());
        tvStudentTuyenDuong.setText(summaryDTO.getHocSinhTuyenDuong());
        tvTong.setText(summaryDTO.getTongDiem());
        tvHang.setText(summaryDTO.getHang());


        return convertView;
    }
}
