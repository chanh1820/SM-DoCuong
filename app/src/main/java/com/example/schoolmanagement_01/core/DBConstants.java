package com.example.schoolmanagement_01.core;

import com.example.schoolmanagement_01.core.dto.CalculatorMinusMap;
import com.example.schoolmanagement_01.core.dto.ClassRoomDTO;
import com.example.schoolmanagement_01.core.dto.RuleDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBConstants {

    /**
     * type
     */
    public static final String RULE_GROUP_CODE_STD = "STD";

    public static final String RULE_GROUP_CODE_TPT = "TPT";

    public static final Integer POINT_ONE_LESSION = 50;


    /**
     * classRoomDTOS
     */
    public static final ArrayList<ClassRoomDTO> classRoomDTOS = new ArrayList<ClassRoomDTO>() {{
        add(new ClassRoomDTO(1, "0601", "6/1"));
        add(new ClassRoomDTO(2, "0602", "6/2"));
        add(new ClassRoomDTO(3, "0603", "6/3"));
        add(new ClassRoomDTO(4, "0604", "6/4"));
        add(new ClassRoomDTO(6, "0701", "7/1"));
        add(new ClassRoomDTO(7, "0702", "7/2"));
        add(new ClassRoomDTO(8, "0703", "7/3"));
        add(new ClassRoomDTO(9, "0801", "8/1"));
        add(new ClassRoomDTO(9, "0802", "8/2"));
        add(new ClassRoomDTO(9, "0901", "9/1"));
        add(new ClassRoomDTO(9, "0902", "9/2"));
        add(new ClassRoomDTO(9, "0903", "9/3"));
    }};
    public static final ArrayList<String> listClassRoom = new ArrayList<String>() {{
        for (ClassRoomDTO classRoomDTO : classRoomDTOS) {
            add(classRoomDTO.getClassName());
        }
    }};

    public static final List<String> listClassSang = new ArrayList<String>() {{
        add("6/1");
        add("6/2");
        add("6/3");
        add("6/4");
        add("9/1");
        add("9/2");
        add("9/3");
    }};
    public static final List<String> listClassChieu = new ArrayList<String>() {{
        add("7/1");
        add("7/2");
        add("7/3");
        add("8/1");
        add("8/2");
    }};
    /**
     * listRuleDTO
     */
    public static final List<RuleDTO> listRuleDTO = new ArrayList<RuleDTO>() {{
        add(new RuleDTO(1, 0, "Học tập", 2));
        add(new RuleDTO(2, 1, "Không thuộc bài", -2, "1", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(3, 1, "Không chép bài", -2, "1", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(4, 1, "Không soạn bài", -2, "1", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(5, 1, "Không làm bài", -2, "1", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(6, 1, "Không làm bài", -2, "1", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(7, 1, "Không mang dụng cụ học tập", -2, "1", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(8, 1, "Lớp thụ động", -3, "1", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(8, 1, "Học sinh không tích cực tham gia phát biểu", -3, "1", RULE_GROUP_CODE_TPT));

        add(new RuleDTO(9, 0, "Thái độ", 4));
        add(new RuleDTO(11, 9, "Trả treo", -5, "2", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(11, 9, "Nói leo", -5, "2", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(11, 9, "Vô lễ với giáo viên", -5, "2", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(12, 9, "Lớp còn ồn, mất trật tự trong tiết học", -3, "2", RULE_GROUP_CODE_TPT));

        add(new RuleDTO(13, 0, "Tác phong", 5));
        add(new RuleDTO(14, 13, "Đến trễ sau khi lớp đã vào tiết học", -1, "3", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(15, 13, "Thiếu logo", -1, "3", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(16, 13, "Thiếu phù hiệu", -1, "3", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(17, 13, "Thiếu khăn quàng", -1, "3", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(18, 13, "Mang giày bata", -1, "3", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(19, 13, "Mặc quần áo không đúng quy định", -1, "3", RULE_GROUP_CODE_TPT));

        add(new RuleDTO(20, 0, "Vệ sinh", 5));
        add(new RuleDTO(21, 20, "Vệ sinh trong phòng học không sạch, còn rác", -2, "4", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(22, 20, "Không lau bảng khi bắt đầu tiết học", -2, "4", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(23, 20, "Không có khảm tải bàn", -2, "4", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(24, 20, "Khảm trải bàn không ngay ngắn", -2, "4", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(25, 20, "Không có phấn, bông lau bảng", -2, "4", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(26, 20, "Không có bình hoa trên bàn giáo viên", -2, "4", RULE_GROUP_CODE_TPT));

        add(new RuleDTO(27, 16, "Hành lang còn rác sau khi lớp tan tiết cuối ra về", -5, "4", RULE_GROUP_CODE_STD));
        add(new RuleDTO(28, 27, "Trong phòng học còn rác sau khi lớp tan tiết cuối ra về", -5, "4", RULE_GROUP_CODE_STD));
        add(new RuleDTO(29, 27, "Hộc bàn còn rác sau khi lớp tan tiết cuối ra về", -5, "4", RULE_GROUP_CODE_STD));
        add(new RuleDTO(30, 27, "Phía sau phòng học vẫn còn rác", -5, "4", RULE_GROUP_CODE_STD));
        add(new RuleDTO(31, 27, "Lớp tan tiết cuối ra về nhưng chưa chưa đổ rác", -5, "4", RULE_GROUP_CODE_STD));
        add(new RuleDTO(32, 27, "Lớp tan tiết cuối ra về nhưng chưa chưa lau bảng", -5, "4", RULE_GROUP_CODE_STD));
        add(new RuleDTO(33, 27, "Lớp tan tiết cuối ra về nhưng chưa chưa tắt đèn", -5, "4", RULE_GROUP_CODE_STD));
        add(new RuleDTO(34, 27, "Lớp tan tiết cuối ra về nhưng chưa chưa tắt quạt", -5, "4", RULE_GROUP_CODE_STD));
        add(new RuleDTO(35, 27, "Lớp tan tiết cuối ra về nhưng chưa không đóng cửa sổ", -5, "4", RULE_GROUP_CODE_STD));
        add(new RuleDTO(36, 27, "Lớp có học sinh mang đồ ăn vào phòng học", -5, "4", RULE_GROUP_CODE_STD));
        add(new RuleDTO(37, 27, "Lớp có học sinh quà bánh vào phòng học", -5, "4", RULE_GROUP_CODE_STD));
        add(new RuleDTO(38, 27, "Lớp có học sinh mang nước uống vào phòng học", -5, "4", RULE_GROUP_CODE_STD));

        add(new RuleDTO(39, 0, "Chuyên cần", 5));
        add(new RuleDTO(40, 39, "Nghỉ học có phép", 0, "5", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(41, 39, "Nghỉ học không phép", 0, "5", RULE_GROUP_CODE_TPT));
        add(new RuleDTO(42, 39, "Cúp tiết", 0, "5", RULE_GROUP_CODE_TPT));

        add(new RuleDTO(43, 0, "Nề nếp", 5));
        add(new RuleDTO(44, 43, "Lớp không xếp hàng sau khi nghe chuông báo tập trung 15 phút", -5, "6", RULE_GROUP_CODE_STD));
        add(new RuleDTO(45, 43, "Lớp không đứng xếp hàng tan tiết cuối ra về", -5, "6", RULE_GROUP_CODE_STD));
        add(new RuleDTO(46, 43, "Lớp không giữ được trật tự", -5, "6", RULE_GROUP_CODE_STD));
        add(new RuleDTO(47, 43, "Còn học sinh ở bên ngoài trong thời gian 15 phút đầu giờ", -5, "6", RULE_GROUP_CODE_STD));
        add(new RuleDTO(48, 43, "Lớp còn học sinh đi trễ trong 15 phút đầu giờ", -5, "6", RULE_GROUP_CODE_STD));

        add(new RuleDTO(49, 0, "Giao thông", 5));
        add(new RuleDTO(50, 49, "Lớp có học sinh không đội nón bảo hiểm", -5, "7", RULE_GROUP_CODE_STD));
        add(new RuleDTO(51, 49, "Lớp có học sinh có đội nón bảo hiểm nhưng không cài quay đúng quy cách", -5, "7", RULE_GROUP_CODE_STD));
    }};

    /**
     * listWeek
     */
    public static final List<String> listWeek = new ArrayList<String>() {{
        add("1");
        add("2");
        add("3");
        add("4");
        add("5");
        add("6");
        add("7");
        add("8");
        add("9");
        add("10");
        add("11");
        add("12");
        add("13");
        add("14");
        add("15");
        add("16");
        add("17");
        add("18");
        add("19");
        add("20");
        add("21");
        add("22");
        add("23");
        add("24");
        add("25");
        add("26");
        add("27");
        add("28");
        add("29");
        add("30");
        add("31");
        add("32");
        add("33");
        add("34");
        add("35");
    }};
    public static final List<String> listYear = new ArrayList<String>() {{
        add("2023-2024");
        add("2024-2025");
        add("2025-2026");
        add("2026-2027");
        add("2027-2028");
    }};

    public static final Map<Integer, CalculatorMinusMap> calculatorMinusMap = new HashMap<Integer, CalculatorMinusMap>() {{
        for (RuleDTO item : listRuleDTO) {
            if (item.getParentId() != 0) {
                put(item.getId(), new CalculatorMinusMap(item.getMinusPoint(), item.getParentId()));
            }
        }
    }};

    public static final List<String> listSession = new ArrayList<String>() {{
        add("Sáng");
        add("Chiều");
    }};


//      public  static final  ArrayList<String> classRoomName = new ArrayList<String>(){{
//            "6/1"
//            ,"6/2"
//            ,"6/3"
//            ,"6/4"
//            ,"7/1"
//            ,"7/2"
//            ,"7/3"
//            ,"7/4"
//            ,"8/1"
//            ,"8/2"
//            ,"8/3"
//            ,"8/4"
//            ,"9/1"
//            ,"9/2"
//            ,"9/3"
//            ,"9/4"
//      }};

}
