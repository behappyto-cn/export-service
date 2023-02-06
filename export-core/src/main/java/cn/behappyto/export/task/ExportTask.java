package cn.behappyto.export.task;

import cn.behappyto.export.biz.ExportTaskBiz;
import cn.hutool.core.date.StopWatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 导出任务
 *
 * @author behappyto.cn
 */
@Slf4j
@Component
public class ExportTask {

    @Resource
    private ExportTaskBiz exportTaskBiz;

    /**
     * 暂定使用本地任务，执行未处理的任务
     */
    @Scheduled(fixedDelay = 5000)
    public void startNotHandle() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Boolean execute = exportTaskBiz.execute(0, 0);

        stopWatch.stop();
        log.info("处理未处理任务导出状态：{}, {} ms", execute, stopWatch.getTotalTimeMillis());
    }

    /**
     * 暂定使用本地任务，执行处理失败的任务
     */
    @Scheduled(fixedDelay = 60000)
    public void startHandleError() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Boolean execute = exportTaskBiz.execute(0, -1);

        stopWatch.stop();
        log.info("处理失败任务导出状态：{}, {} ms", execute, stopWatch.getTotalTimeMillis());
    }
}
