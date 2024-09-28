package accesslog;

import edu.sm.dto.AccessLog;
import edu.sm.service.AccessLogService;

public class AccessLogInsert {
    public static void main(String[] args) {
        AccessLogService accessLogService = new AccessLogService();

        AccessLog accessLog = new AccessLog();
        accessLog.setCid(1);  // 사용자의 ID를 설정
        try {
            accessLogService.add(accessLog);
            System.out.println("Access log가 성공적으로 추가되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
