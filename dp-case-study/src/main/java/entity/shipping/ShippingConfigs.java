package entity.shipping;

/**
 * @author
 */
public class ShippingConfigs {

    private static final String[] PROVINCES = {
            "Bắc Giang", 	"Bắc Kạn", 			"Cao Bằng", 	"Hà Giang", 	"Lạng Sơn", 	"Phú Thọ",
            "Quảng Ninh", 	"Thái Nguyên", 		"Tuyên Quang", 	"Yên Bái", 		"Điện Biên", 	"Hòa Bình",
            "Lai Châu", 	"Sơn La", 			"Bắc Ninh", 	"Hà Nam", 		"Hải Dương", 	"Hưng Yên",
            "Nam Định", 	"Ninh Bình", 		"Thái Bình", 	"Vĩnh Phúc", 	"Hà Nội", 		"Hải Phòng",
            "Hà Tĩnh", 		"Nghệ An", 			"Quảng Bình", 	"Quảng Trị", 	"Thanh Hóa", 	"Thừa Thiên-Huế",
            "Đắk Lắk", 		"Đắk Nông", 		"Gia Lai", 		"Kon Tum", 		"Lâm Đồng", 	"Bình Định",
            "Bình Thuận", 	"Khánh Hòa", 		"Ninh Thuận", 	"Phú Yên", 		"Quảng Nam", 	"Quảng Ngãi",
            "Đà Nẵng", 		"Bà Rịa-Vũng Tàu", 	"Bình Dương", 	"Bình Phước", 	"Đồng Nai", 	"Tây Ninh",
            "Hồ Chí Minh", 	"An Giang", 		"Bạc Liêu", 	"Bến Tre", 		"Cà Mau", 		"Đồng Tháp",
            "Hậu Giang", 	"Kiên Giang", 		"Long An", 		"Sóc Trăng", 	"Tiền Giang", 	"Trà Vinh",
            "Vĩnh Long", 	"Cần Thơ",          "Lào Cai" };

    private static int[] RUSH_SUPPORT_PROVINCES_INDEX = {22, 48};

    public static String[] getProvinces() {
        return PROVINCES;
    }

    public static int[] getRushSupportProvincesIndex() {
        return RUSH_SUPPORT_PROVINCES_INDEX;
    }
    /*
    PROVINCES và RUSH_SUPPORT_PROVINCES_INDEX vi phạm common coupling
    giải pháp:
        1: change public to private
        2: provide getter
     */
}
