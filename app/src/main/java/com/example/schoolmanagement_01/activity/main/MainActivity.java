package com.example.schoolmanagement_01.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextClock;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.activity.bangtongket.SummaryBoardActivity;
import com.example.schoolmanagement_01.activity.danhsachvipham.ReportActivity;
import com.example.schoolmanagement_01.activity.diemxeploaitiethoc.AddPointActivity;
import com.example.schoolmanagement_01.activity.quanlytrucnhat.ChooseClassActivity;
import com.example.schoolmanagement_01.core.DBConstants;
import com.example.schoolmanagement_01.core.DBHelper;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnQuanLyTrucNhat, btnDanhSachViPham, btnXepLoaiTietHoc, btnBangTongKet;
    TextClock textClock;
    EditText edtInputStaff;
    Spinner spnChooseWeek;
    Spinner spnChooseYear;
    ChooseWeekAdapter chooseWeekAdapter;
    ChooseYearAdapter chooseYearAdapter;
    ChooseSeesionAdapter chooseSeesionAdapter;
    List<String> listWeek = DBConstants.listWeek;
    SharedPreferences weekSPr;
    List<String> listYear = DBConstants.listYear;
    SharedPreferences yearSPr;
    //SharedPreferences namSPr;
    List<String> listSession = DBConstants.listSession;
    /**Spinner sp_namhoc;
    ArrayAdapter<String> adapter; //tạo vector adapter để truyền vào Spinner
    // Biến mảng namhoc là các giá trị sẽ hiện ra
    String namhoc[] = {"2022-2023","2023-2024","2024-2025","2025-2026","2026-2027"};
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weekSPr = getSharedPreferences("week",MODE_PRIVATE);
        yearSPr = getSharedPreferences("year",MODE_PRIVATE);
        initView();
        action();

        /**sp_namhoc = (Spinner) findViewById(R.id.spin_namhoc);
        //lấy các giá trị của namhoc vào adapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, namhoc);
        // chọn kiểu hiển thị khi lick vào Spinner giống như một dialog custom
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        //Thêm mảng adapter vừa tạo vào spinner
        sp_namhoc.setAdapter(adapter);*/



    }

    private void action() {
        btnQuanLyTrucNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ChooseClassActivity.class);
                startActivity(i);
            }
        });
        btnDanhSachViPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ReportActivity.class);
                startActivity(i);
            }
        });
        btnXepLoaiTietHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(MainActivity.this, AddPointActivity.class);
                startActivity(i);
            }
        });
        btnBangTongKet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_choose_session);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().setAttributes(lp);

                dialog.show();

                chooseSeesionAdapter = new ChooseSeesionAdapter(listSession, getApplicationContext());
                GridView gvListSession = dialog.findViewById(R.id.gv_list_session);
                gvListSession.setAdapter(chooseSeesionAdapter);
                gvListSession.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MainActivity.this, SummaryBoardActivity.class);
                        intent.putExtra("session", position);
                        startActivity(intent);
                    }
                });
            }
        });
        edtInputStaff.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                SharedPreferences.Editor week = weekSPr.edit();
                week.putString("staff_name",edtInputStaff.getText().toString().trim());
                week.commit();
                SharedPreferences.Editor year = yearSPr.edit();
                year.putString("staff_name",edtInputStaff.getText().toString().trim());
                year.commit();
            }
        });
    }

    private void initView() {
        DBHelper db = new DBHelper(this);
        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        btnQuanLyTrucNhat = findViewById(R.id.btn_quan_ly_truc_nhat);
        btnDanhSachViPham = findViewById(R.id.btn_danh_sach_vi_pham);
        btnXepLoaiTietHoc = findViewById(R.id.btn_xep_loai_tiet_hoc);
        btnBangTongKet = findViewById(R.id.btn_bang_tong_ket);
        edtInputStaff = findViewById(R.id.edt_input_staff);
        textClock = findViewById(R.id.textclock);
        spnChooseWeek = findViewById(R.id.spn_choose_week);
        spnChooseYear = findViewById(R.id.spn_choose_year);
        String formatdate = "E, d-M-yyyy k:m:sa";
        textClock.setFormat12Hour(formatdate);
        textClock.setFormat24Hour(formatdate);
        chooseWeekAdapter = new ChooseWeekAdapter(getApplicationContext(), listWeek);
        spnChooseWeek.setAdapter(chooseWeekAdapter);
        spnChooseWeek.setSelection(Integer.parseInt(weekSPr.getString("position", 0+"")));
        spnChooseWeek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences.Editor week = weekSPr.edit();
                week.putString("week", listWeek.get(i));
                week.putString("position",String.valueOf(i));
                week.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        chooseYearAdapter = new ChooseYearAdapter(getApplicationContext(),listYear);
        spnChooseYear.setAdapter(chooseYearAdapter);
        spnChooseYear.setSelection(Integer.parseInt(yearSPr.getString("position", 0+"")));
        spnChooseYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences.Editor year = yearSPr.edit();
                year.putString("year", listYear.get(i));
                year.putString("position",String.valueOf(i));
                year.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






    }
}