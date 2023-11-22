package com.example.schoolmanagement_01.activity.bangtongket;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.DBConstants;
import com.example.schoolmanagement_01.core.UltilService;
import com.example.schoolmanagement_01.core.dao.GeneralDAO;
import com.example.schoolmanagement_01.core.dto.PointDTO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.SummaryDTO;
import com.example.schoolmanagement_01.core.engine.SumaryEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SummaryBoardActivity extends AppCompatActivity {
    ListView lvSummary;
    TextView tvStaffName, tvWeek, tvYear; //khai báo năm học hiển thị trong texview
    Button btnSaveScreenShot;
    ArrayList<SummaryDTO> summaryDTOList;

    GeneralDAO generalDAO;
    SummaryBoardAdapter summaryBoardAdapter;
    List<String> listSessionClass ;
    String week = "0";
    String year = "0";
   //String nam = "0";   //chuỗi năm học
    String staffName = "";
    int lastRank = 0;
    SharedPreferences sharedPreferences;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_board);
        Intent intent = getIntent();
        Integer session = intent.getIntExtra("session",0);
        Log.e("session",session.toString());
        switch (session){
            case 0:
                listSessionClass = DBConstants.listClassSang;
                break;
            case 1:
                listSessionClass = DBConstants.listClassChieu;
                break;
        }
        lvSummary = findViewById(R.id.lvSummary);
        tvStaffName = findViewById(R.id.tv_summary_staff_name);
        tvWeek = findViewById(R.id.tv_summary_week);
        tvYear = findViewById(R.id.tv_summary_year);
       // tvNam = findViewById(R.id.tv_summary_nam); // Tìm đến textview để gán vào
        btnSaveScreenShot = findViewById(R.id.btnSaveScreenShot);
        generalDAO = new GeneralDAO(getApplicationContext());
        summaryDTOList = new ArrayList<SummaryDTO>();
        sharedPreferences = getSharedPreferences("week",MODE_PRIVATE);
        week = sharedPreferences.getString("week",-1+"");

        sharedPreferences = getSharedPreferences("year",MODE_PRIVATE);
        year = sharedPreferences.getString("year",0+"");

        staffName = sharedPreferences.getString("staff_name",0+"");
        tvWeek.setText("Tuần: "+ week);
        tvYear.setText("Năm học: "+year);
        tvStaffName.setText("Người trực: "+staffName);
        //Hiển thị số lớp đưa vào mảng trong bảng tổng kết
        float [] arr = new float[listSessionClass.size()];
        int position = 0;
        for (String classRoom: listSessionClass){
            PointDTO pointDTO = generalDAO.findPointByWeekAndClass(week, classRoom);
            List<ReportDTO> reportDTOList = generalDAO.findReportByWeekAndClass(week,classRoom);

            SummaryDTO summaryDTO = SumaryEngine.calculatorSummary(classRoom,pointDTO, reportDTOList);
            summaryDTOList.add(summaryDTO);
            arr[position] = Float.parseFloat(summaryDTO.getTongDiem());
            position++;
        }
        float[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(temp);
        UltilService.reverseArrayFloat(temp);
        HashMap<Float, Integer> map = new HashMap<>();
        int index = 1;
        float prev = temp[0];
        map.put(prev, index);

        for(int i = 1; i<arr.length; i++){
            if(prev!=temp[i])
                index++;
            map.put(temp[i], index);
            prev=temp[i];
            lastRank = index;
        }

        for(int i=0; i<arr.length; i++){
            summaryDTOList.get(i).setHang(String.valueOf(map.get(arr[i])));
        }
        for (int i = 0; i < summaryDTOList.size(); i++) {
            if(Integer.valueOf(summaryDTOList.get(i).getHang()) == 1){
                summaryDTOList.get(i).setTuyenDuong(true);
            }
        }
        summaryBoardAdapter = new SummaryBoardAdapter(getApplicationContext(),0, summaryDTOList);
        lvSummary.setAdapter(summaryBoardAdapter);
    }
//    private void takeScreenshot(View view , String fileName) {
//        Date now = new Date();
//        CharSequence format = DateFormat.format("yyyy-MM-dd_hh:mm:ss",now);
//
//        try {
////            // image naming and path  to include sd card  appending name you choose for file
//            ContextWrapper cw = new ContextWrapper(getApplicationContext());
//            String fullPath =cw.getExternalFilesDir(Environment.DIRECTORY_MUSIC).toString();
////            String mPath = getApplicationContext().get.getExternalFilesDir(Environment.DIRECTORY_DCIM) + "/" + now + ".jpg";
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1) {
//                fullPath= SummaryBoardActivity.this.getExternalFilesDir
//                        (Environment.DIRECTORY_DCIM).toString();
//            }
//            else
//            {
//                fullPath = Environment.getExternalStorageDirectory()
//                        .toString();
//            }
//
////            String dirPath =Environment.getExternalStorageDirectory().toString()+"/chanh";
//            File fileDir = new File(fullPath);
//            if(!fileDir.exists()){
//                boolean mkdir = fileDir.mkdir();
//            }
//
//            String path = fullPath+"/"+ fileName +"-"+format +"jpeg";
//            // create bitmap screen capture
//            View v1 = view;
//            v1.setDrawingCacheEnabled(true);
//            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
//            v1.setDrawingCacheEnabled(false);
//
//            File imageFile  = new File(path);
//            FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
//            bitmap.compress(Bitmap.CompressFormat.JPEG,100, fileOutputStream);
//            fileOutputStream.flush();
//            fileOutputStream.close();
//            v1.setDrawingCacheEnabled(false);
//
//            File imageFile = new File(fullPath);
//
//            FileOutputStream outputStream = new FileOutputStream(imageFile);
//            int quality = 100;
//            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
//            outputStream.flush();
//            outputStream.close();

//            openScreenshot(imageFile);
//        } catch (Throwable e) {
//            // Several error may come out with file handling or DOM
//            e.printStackTrace();
//        }
//    }
//    private void openScreenshot(File imageFile) {
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_VIEW);
//        Uri uri = FileProvider.getUriForFile(SummaryBoardActivity.this, BuildConfig.APPLICATION_ID + ".provider",imageFile);
//        intent.setDataAndType(uri, "image/*");
//        startActivity(intent);
//    }
//
//    public  Bitmap getBitmapFromView(View view) {
//        android.graphics.Bitmap bitmap =
//                android.graphics.Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        view.draw(canvas);
//        return bitmap;
//    }
//    public static Bitmap loadBitmapFromView(Context context, View v) {
//        DisplayMetrics dm = context.getResources().getDisplayMetrics();
//        v.measure(View.MeasureSpec.makeMeasureSpec(dm.widthPixels, View.MeasureSpec.EXACTLY),
//                View.MeasureSpec.makeMeasureSpec(dm.heightPixels, View.MeasureSpec.EXACTLY));
//        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
//        Bitmap returnedBitmap = Bitmap.createBitmap(v.getMeasuredWidth(),
//                v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
//        Canvas c = new Canvas(returnedBitmap);
//        v.draw(c);
//
//        return returnedBitmap;
//    }
}