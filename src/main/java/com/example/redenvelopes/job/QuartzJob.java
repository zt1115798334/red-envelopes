package com.example.redenvelopes.job;

import com.alibaba.fastjson.JSONObject;
import com.example.redenvelopes.utils.DateUtils;
import com.example.redenvelopes.utils.HttpClientUtils;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuartzJob extends QuartzJobBean {
    final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() << 1);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LocalDateTime localDateTime = DateUtils.currentDateTime();
        String time = DateUtils.formatDateTime(localDateTime);
        log.info("当前时间为：{}", time);
        log.info("当前日期为：{}", localDateTime.getDayOfMonth());
        LocalDateTime startTime1 = LocalDateTime.of(2021, 2, 11, 19, 55, 0);
        LocalDateTime endTime1 = LocalDateTime.of(2021, 2, 11, 20, 20, 0);

        LocalDateTime startTime2 = LocalDateTime.of(2021, 2, 12, 19, 55, 0);
        LocalDateTime endTime2 = LocalDateTime.of(2021, 2, 12, 20, 20, 0);

        LocalDateTime startTime3 = LocalDateTime.of(2021, 2, 16, 19, 55, 0);
        LocalDateTime endTime3 = LocalDateTime.of(2021, 2, 16, 20, 20, 0);
        if (DateUtils.intervalTime(startTime1, endTime1, LocalDateTime.now()) ||
                DateUtils.intervalTime(startTime2, endTime2, LocalDateTime.now()) ||
                DateUtils.intervalTime(startTime3, endTime3, LocalDateTime.now())) {
            String url = "https://wap.365autogo.com/fuPacketApi/shareCars/awardSendFoton210126.action";
            for (int i = 0; i < 10; i++) {

                for (int j = 1; j < 4; j++) {
                    String redpackType = "210126030" + j;
                    executorService.execute(() -> {
                        String params = " {limit:{},param:{activityNumber:'210126',telephone:'15600663638',redpackType:" + redpackType + ",openid:'ovCTS067u5CDFW23Id_qyOVXF4-o'}}";
                        Map<String, Object> map = Maps.newHashMap();
                        map.put("jsonParame", params);
                        String s = HttpClientUtils.getInstance().httpPostFrom(url, map);
                        JSONObject result = JSONObject.parseObject(s);
                        if (Objects.equal(result.getInteger("code"), 0)) {
                            log.info("抢购成功啦");
                        }
                        log.info("接口返回：{}", s);
                    });
                }
            }
            executorService.shutdown();
            while (true) {
                if (executorService.isTerminated()) {
                    break;
                }
            }
        }

        log.info("运行成功");

    }
}
