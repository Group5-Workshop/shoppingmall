package accesslog;

import edu.sm.service.AccessLogService;

import java.util.List;

public class AccessLogStats {
    public static void main(String[] args) {
        AccessLogService accessLogService = new AccessLogService();

        try {
            // 시간별 접속 통계
            List<String> hourlyStats = accessLogService.getHourlyStats();
            System.out.println("시간별 접속 통계:");
            for (String stat : hourlyStats) {
                System.out.println(stat);
            }

            // 일별 접속 통계
            List<String> dailyStats = accessLogService.getDailyStats();
            System.out.println("일별 접속 통계:");
            for (String stat : dailyStats) {
                System.out.println(stat);
            }

            // 요일별 접속 통계
            List<String> weeklyStats = accessLogService.getWeeklyStats();
            System.out.println("요일별 접속 통계:");
            for (String stat : weeklyStats) {
                System.out.println(stat);
            }

            // 월별 접속 통계
            List<String> monthlyStats = accessLogService.getMonthlyStats();
            System.out.println("월별 접속 통계:");
            for (String stat : monthlyStats) {
                System.out.println(stat);
            }

            // 연도별 접속 통계
            List<String> yearlyStats = accessLogService.getYearlyStats();
            System.out.println("연도별 접속 통계:");
            for (String stat : yearlyStats) {
                System.out.println(stat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
