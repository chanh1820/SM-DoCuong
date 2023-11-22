package com.example.schoolmanagement_01.activity.quanlytrucnhat;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.activity.quanlytrucnhat.adapter.ChooseRuleChildAdapter;
import com.example.schoolmanagement_01.activity.quanlytrucnhat.adapter.ChooseRuleParentAdapter;
import com.example.schoolmanagement_01.activity.quanlytrucnhat.adapter.ChooseStudentAdapter;
import com.example.schoolmanagement_01.core.DBConstants;
import com.example.schoolmanagement_01.core.UltilService;
import com.example.schoolmanagement_01.core.dao.GeneralDAO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.RuleDTO;
import com.example.schoolmanagement_01.core.dto.StudentDTO;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



public class AddReportActivity extends AppCompatActivity {
    Spinner studentSpinner;
    Spinner chooseRuleParentSpinner;
    Spinner chooseRuleChildSpinner;
    ImageView imvInitImage;
    Button btnSaveReport, btnBack;
    private static final int CAMERA_REQUEST_CODE = 100;
    List<StudentDTO> studentDTOList = new ArrayList<>();
    List<RuleDTO> ruleDTOList = DBConstants.listRuleDTO;
    List<RuleDTO> ruleParentList = UltilService.getRules(ruleDTOList,0);
    List<RuleDTO> ruleChildList = new ArrayList<>();

    ChooseStudentAdapter chooseStudentAdapter;
    ChooseRuleParentAdapter chooseRuleParentAdapter;
    ChooseRuleChildAdapter chooseRuleChildAdapter;
    GeneralDAO generalDAO;
    ReportDTO reportDTO = new ReportDTO();
//    String className = "";
//    String studentName = "";
//    String ruleChild = "";
//    Integer ruleId = -1;
//    Integer minusPoint = 0;
//    String imageBitmap="";
    SharedPreferences  sharedPref;
    String weekCurrent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_report);
        sharedPref = getSharedPreferences("week", MODE_PRIVATE);
        weekCurrent = sharedPref.getString("week", 0+"");
        initView();
        action();

    }

    private void action() {
        imvInitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,CAMERA_REQUEST_CODE);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == CAMERA_REQUEST_CODE){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imvInitImage.setImageBitmap(bitmap);
                reportDTO.setPathImage(UltilService.BitMapToString(bitmap));
            }
        }
    }

    private void initView() {
        studentSpinner = findViewById(R.id.spn_choose_student);
        chooseRuleChildSpinner = findViewById(R.id.spn_choose_rule_child);
        chooseRuleParentSpinner = findViewById(R.id.spn_choose_rule_parent);
        imvInitImage = findViewById(R.id.imv_init_image);
        btnSaveReport = findViewById(R.id.btn_save_report);
        btnBack = findViewById(R.id.btn_back_add_report);
        reportDTO.setWeek(weekCurrent);
        Log.e("week",weekCurrent);
        btnSaveReport.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                reportDTO.setCreatedDate(dtf.format(now));
                generalDAO.saveReport(reportDTO);
                Toast.makeText(AddReportActivity.this,"Lưu thành công",Toast.LENGTH_SHORT).show();

           }
        });


        Intent i = getIntent();
        reportDTO.setClassRoom(i.getStringExtra("class"));
        generalDAO = new GeneralDAO(getApplicationContext());
        studentDTOList = generalDAO.findStudentByClassRoom(reportDTO.getClassRoom());
        chooseStudentAdapter = new ChooseStudentAdapter(getApplicationContext(),studentDTOList);
        studentSpinner.setAdapter(chooseStudentAdapter);
        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                reportDTO.setStudentName(studentDTOList.get(i).getStudentName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        chooseRuleParentAdapter = new ChooseRuleParentAdapter(getApplicationContext(), ruleParentList);
        chooseRuleParentSpinner.setAdapter(chooseRuleParentAdapter);
        chooseRuleParentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ruleChildList = UltilService.getRules(ruleDTOList,ruleParentList.get(i).getId());
                updateRuleChildSpinner(ruleChildList);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void updateRuleChildSpinner(List<RuleDTO> ruleChildList) {
        chooseRuleChildAdapter = new ChooseRuleChildAdapter(getApplicationContext(),ruleChildList);
        chooseRuleChildSpinner.setAdapter(chooseRuleChildAdapter);
        chooseRuleChildSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                reportDTO.setRuleName(ruleChildList.get(i).getRuleName());
                reportDTO.setRuleId(ruleChildList.get(i).getId());
                reportDTO.setMinusPoint(ruleChildList.get(i).getMinusPoint());
                reportDTO.setCollectionCode(ruleChildList.get(i).getCollectionCode());
                reportDTO.setGroupCode(ruleChildList.get(i).getGroupCode());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}