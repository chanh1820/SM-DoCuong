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
    public static final String RULE_GROUP_DI_HOC = "1";
    public static final String RULE_GROUP_VE_SINH = "2";
    public static final String RULE_GROUP_CHAM_SOC_HOA = "3";
    public static final String RULE_GROUP_TRUY_BAI = "4";
    public static final String RULE_GROUP_DE_XE = "5";
    public static final String RULE_GROUP_TAP_THE_DUC = "6";
    public static final String RULE_GROUP_HAT = "7";
    public static final String RULE_GROUP_TAP_TRUNG = "8";
    public static final String RULE_GROUP_NEP_SONG_VAN_MINH = "9";
    public static final String RULE_GROUP_BAO_VE_CONG_CHUNG = "10";
    public static final String RULE_GROUP_CO_DO = "11";

    public static final Integer POINT_ONE_LESSION = 50;


    /**
     * classRoomDTOS
     */
    public static final ArrayList<ClassRoomDTO> classRoomDTOS = new ArrayList<ClassRoomDTO>() {{
        add(new ClassRoomDTO(1, "0", "6A1"));
        add(new ClassRoomDTO(2, "0", "6A2"));
        add(new ClassRoomDTO(3, "0", "6A3"));
        add(new ClassRoomDTO(4, "0", "6A4"));
        add(new ClassRoomDTO(6, "0", "6A5"));
        add(new ClassRoomDTO(7, "0", "7A1"));
        add(new ClassRoomDTO(8, "0", "7A2"));
        add(new ClassRoomDTO(9, "0", "7A3"));
        add(new ClassRoomDTO(9, "0", "7A4"));
        add(new ClassRoomDTO(9, "0", "8A1"));
        add(new ClassRoomDTO(9, "0", "8A2"));
        add(new ClassRoomDTO(9, "0", "8A3"));
        add(new ClassRoomDTO(9, "0", "9A1"));
        add(new ClassRoomDTO(9, "0", "9A2"));
        add(new ClassRoomDTO(9, "0", "9A3"));
        add(new ClassRoomDTO(9, "0", "9A4"));
        add(new ClassRoomDTO(9, "0", "9A5"));
    }};
    public static final ArrayList<String> listClassRoom = new ArrayList<String>() {{
        for (ClassRoomDTO classRoomDTO : classRoomDTOS) {
            add(classRoomDTO.getClassName());
        }
    }};

    public static final List<String> listClassSang = new ArrayList<String>() {{
        add("6A1");
        add("6A2");
        add("6A3");
        add("6A4");
        add("6A5");
        add("9A1");
        add("9A2");
        add("9A3");
        add("9A4");
        add("9A5");
    }};
    public static final List<String> listClassChieu = new ArrayList<String>() {{
        add("7A1");
        add("7A2");
        add("7A3");
        add("7A4");
        add("8A1");
        add("8A2");
        add("8A3");
    }};
    /**
     * listRuleDTO
     */
    public static final List<RuleDTO> listRuleDTO = new ArrayList<RuleDTO>() {{
        add(new RuleDTO(1, 0, "Đi học", 2));
        add(new RuleDTO(2, 1, "Đi học muộn", -2, "1", RULE_GROUP_DI_HOC));
        add(new RuleDTO(3, 1, "Bỏ giờ, bỏ tiết", -5, "1", RULE_GROUP_DI_HOC));
        add(new RuleDTO(4, 1, "Nghỉ học không lí do", -2, "1", RULE_GROUP_DI_HOC));

        add(new RuleDTO(5, 0, "Vệ sinh", 4));
        add(new RuleDTO(6, 5, "Vứt rác xuống tầng dưới, mái nhà", -10, "2", RULE_GROUP_VE_SINH));
        add(new RuleDTO(7, 5, "Để rác cuối lớp", -5, "2", RULE_GROUP_VE_SINH));
        add(new RuleDTO(8, 5, "Vệ sinh muộn", -5, "2", RULE_GROUP_VE_SINH));
        add(new RuleDTO(9, 5, "Không vệ sinh", -10, "2", RULE_GROUP_VE_SINH));
        add(new RuleDTO(10, 5, "Thiếu khăn chải bàn, khăn lau bảng, thau, thước kẻ, lọ hoa", -2, "2", RULE_GROUP_VE_SINH));
        add(new RuleDTO(11, 5, "Không xóa bảng sạch", -2, "2", RULE_GROUP_VE_SINH));
        add(new RuleDTO(12, 5, "Vứt giấy rác ra lớp, sân trường, viết bậy lên tường", -2, "2", RULE_GROUP_VE_SINH));
        add(new RuleDTO(13, 5, "Hất nước xuống tấng dưới", -10, "2", RULE_GROUP_VE_SINH));
        add(new RuleDTO(14, 5, "Vệ sinh bẩn", -2, "2", RULE_GROUP_VE_SINH));

        add(new RuleDTO(15, 0, "Chăm sóc bồn hoa cây cảnh", 5));
        add(new RuleDTO(16, 15, "Không nhặt lá, giấy rác", -2, "3", RULE_GROUP_CHAM_SOC_HOA));
        add(new RuleDTO(17, 15, "Không tưới nước", -2, "3", RULE_GROUP_CHAM_SOC_HOA));

        add(new RuleDTO(18, 0, "Truy bài", 5));
        add(new RuleDTO(19, 18, "Vào lớp muộn", -2, "4", RULE_GROUP_TRUY_BAI));
        add(new RuleDTO(20, 18, "Nói chuyện riêng", -2, "4", RULE_GROUP_TRUY_BAI));
        add(new RuleDTO(21, 18, "Không mở sách vở", -2, "4", RULE_GROUP_TRUY_BAI));
        add(new RuleDTO(22, 18, "Đi lại lộn xộn", -2, "4", RULE_GROUP_TRUY_BAI));

        add(new RuleDTO(23, 0, "Đi và để xe", -5, "4", RULE_GROUP_DE_XE));
        add(new RuleDTO(24, 23, "Để sai vị trí", -2, "4", RULE_GROUP_DE_XE));
        add(new RuleDTO(25, 23, "Không vệ sinh nhà xe", -5, "4", RULE_GROUP_DE_XE));
        add(new RuleDTO(26, 23, "Ra về đứng ngoài cổng", -5, "4", RULE_GROUP_DE_XE));
        add(new RuleDTO(27, 23, "Hàng xe không thẳng", -5, "4", RULE_GROUP_DE_XE));
        add(new RuleDTO(28, 23, "Để xe ngoài cổng", -20, "4", RULE_GROUP_DE_XE));
        add(new RuleDTO(29, 23, "Đi xe máy điện đến trường", -30, "4", RULE_GROUP_DE_XE));
        add(new RuleDTO(30, 23, "Đi xe trong sân trường ", -5, "4", RULE_GROUP_DE_XE));

        add(new RuleDTO(31, 0, "Tập thể dục giữa giờ", 5));
        add(new RuleDTO(32, 31, "Ra muộn sau 3 phút", -2, "5", RULE_GROUP_TAP_THE_DUC));
        add(new RuleDTO(33, 31, "Tập sai, không đều", -2, "5", RULE_GROUP_TAP_THE_DUC));
        add(new RuleDTO(34, 31, "Xếp hàng không thẳng", -2, "5", RULE_GROUP_TAP_THE_DUC));
        add(new RuleDTO(35, 31, "Không có dầy hoặc dép có quai", -5, "5", RULE_GROUP_TAP_THE_DUC));
        add(new RuleDTO(36, 31, "Không đội mũ ca nô", -2, "5", RULE_GROUP_TAP_THE_DUC));
        add(new RuleDTO(37, 31, "Không sơ vin", -5, "5", RULE_GROUP_TAP_THE_DUC));
        add(new RuleDTO(38, 31, "Bỏ tập thể dục", -5, "5", RULE_GROUP_TAP_THE_DUC));

        add(new RuleDTO(39, 0, "Hát", 5));
        add(new RuleDTO(40, 39, "Không hát đều", -10, "6", RULE_GROUP_HAT));
        add(new RuleDTO(41, 39, "Cả lớp không hát", -5, "6", RULE_GROUP_HAT));
        add(new RuleDTO(42, 39, "Học sinh không hát", -2, "6", RULE_GROUP_HAT));

        add(new RuleDTO(43, 0, "Tập trung (chào cờ, ngoại khóa)", 5));
        add(new RuleDTO(44, 43, "Xếp hàng không thẳng", -2, "7", RULE_GROUP_TAP_TRUNG));
        add(new RuleDTO(45, 43, "Mất trật tự", -2, "7", RULE_GROUP_TAP_TRUNG));
        add(new RuleDTO(46, 43, "Không có ghế ngồi", -2, "7", RULE_GROUP_TAP_TRUNG));
        add(new RuleDTO(47, 43, "Không có mũ ca nô", -2, "7", RULE_GROUP_TAP_TRUNG));
        add(new RuleDTO(48, 43, "Không đi dầy, dép có quai", -5, "7", RULE_GROUP_TAP_TRUNG));
        add(new RuleDTO(49, 43, "Ngồi không đúng vị trí", -2, "7", RULE_GROUP_TAP_TRUNG));
        add(new RuleDTO(50, 43, "Ra muôn sau 3 phút", -2, "7", RULE_GROUP_TAP_TRUNG));

        add(new RuleDTO(51, 0, "Nếp sống văn minh", 5));
        add(new RuleDTO(52, 51, "Ăn quà vặt", -10, "7", RULE_GROUP_NEP_SONG_VAN_MINH));
        add(new RuleDTO(53, 51, "Sử dụng điện thoại", -30, "7", RULE_GROUP_NEP_SONG_VAN_MINH));
        add(new RuleDTO(54, 51, "Không có đồng phục", -2, "7", RULE_GROUP_NEP_SONG_VAN_MINH));
        add(new RuleDTO(55, 51, "Đánh nhau (Tùy mức độ, nặng có thể đuổi học)", -60, "7", RULE_GROUP_NEP_SONG_VAN_MINH));
        add(new RuleDTO(56, 51, "Ra ngoài cổng tự do", -20, "7", RULE_GROUP_NEP_SONG_VAN_MINH));
        add(new RuleDTO(57, 51, "Không sơ vin", -2, "7", RULE_GROUP_NEP_SONG_VAN_MINH));
        add(new RuleDTO(58, 51, "Không khăn quàng", -2, "7", RULE_GROUP_NEP_SONG_VAN_MINH));
        add(new RuleDTO(59, 51, "Lấy đồ của người khác", -20, "7", RULE_GROUP_NEP_SONG_VAN_MINH));
        add(new RuleDTO(60, 51, "Mang vũ khí, chất cấm, hút thuốc lá khi đến trường", -20, "7", RULE_GROUP_NEP_SONG_VAN_MINH));
        add(new RuleDTO(61, 51, "Đá bóng trong sân trường", -20, "7", RULE_GROUP_NEP_SONG_VAN_MINH));
        add(new RuleDTO(62, 51, "Đi tông, dép đến trường", -5, "7", RULE_GROUP_NEP_SONG_VAN_MINH));
        add(new RuleDTO(63, 51, "Nói tục chửi bậy", -5, "7", RULE_GROUP_NEP_SONG_VAN_MINH));


        add(new RuleDTO(64, 0, "Bảo vệ của công", 5));
        add(new RuleDTO(65, 64, "Ra về không đóng cửa chính, cửa sổ", -20, "7", RULE_GROUP_BAO_VE_CONG_CHUNG));
        add(new RuleDTO(66, 64, "Vẽ bậy lên bàn", -2, "7", RULE_GROUP_BAO_VE_CONG_CHUNG));
        add(new RuleDTO(67, 64, "Đập phá bàn ghế, đồ dùng giảng dạy, học tập", -20, "7", RULE_GROUP_BAO_VE_CONG_CHUNG));
        add(new RuleDTO(68, 64, "Bàn ghế không ngay ngắn, thẳng hàng, lộn xộn", -2, "7", RULE_GROUP_BAO_VE_CONG_CHUNG));
        add(new RuleDTO(69, 64, "Ra về không tắt điện tắt quạt", -20, "7", RULE_GROUP_BAO_VE_CONG_CHUNG));

        add(new RuleDTO(70, 0, "Cờ đỏ", 5));
        add(new RuleDTO(71, 70, "Nộp sổ trực muộn", -2, "7", RULE_GROUP_CO_DO));
        add(new RuleDTO(72, 70, "Không nộp sổ trực", -5, "7", RULE_GROUP_CO_DO));
        add(new RuleDTO(73, 70, "Tính sai điểm sổ trực", -2, "7", RULE_GROUP_CO_DO));
        add(new RuleDTO(74, 70, "Không tính điểm sổ trực", -2, "7", RULE_GROUP_CO_DO));
        add(new RuleDTO(75, 70, "Thiếu điểm tiết học và chữ kí của giáo viên", -5, "7", RULE_GROUP_CO_DO));

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

    public static final Integer DEFAULT_POINT_OF_WEEK = 420;
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
