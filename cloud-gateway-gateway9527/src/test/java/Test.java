import java.time.ZonedDateTime;

public class Test {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
        //2023-06-06T09:51:37.510+08:00[GMT+08:00]
    }
}
