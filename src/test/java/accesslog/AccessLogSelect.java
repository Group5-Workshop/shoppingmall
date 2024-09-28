package accesslog;

import edu.sm.dto.AccessLog;
import edu.sm.service.AccessLogService;

public class AccessLogSelect {
    public static void main(String[] args) {
        AccessLogService accessLogService = new AccessLogService();

        int logId = 1;  // 조회할 로그 ID 설정
        try {
            AccessLog accessLog = accessLogService.get(logId);
            if (accessLog != null) {
                System.out.println("로그 ID: " + accessLog.getLogId());
                System.out.println("사용자 ID: " + accessLog.getCid());
                System.out.println("접속 시간: " + accessLog.getAccessTime());
            } else {
                System.out.println("해당 로그가 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
