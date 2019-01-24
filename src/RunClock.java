import utils.InfoUtil;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RunClock {
    private final static String TITLE="温馨提醒";
    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                InfoUtil test = new InfoUtil();
                test.show(TITLE, "您已连续工作1小时，做个眼保健操吧！");
            }
        }, 60, 60, TimeUnit.SECONDS);
    }
}
