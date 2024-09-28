package accesslog;

import edu.sm.dto.AccessLog;
import edu.sm.service.AccessLogService;

import java.util.List;

public class AccessLogSelectAll {
    public static void main(String[] args) {
        AccessLogService accessLogService = new AccessLogService();

        try {
            List<AccessLog> accessLogs = accessLogService.get();
            for (AccessLog log : accessLogs) {
                System.out.print("로그 ID: " + log.getLogId() + ", ");
                System.out.print("사용자 ID: " + log.getCid()+ ", ");
                System.out.println("접속 시간: " + log.getAccessTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
