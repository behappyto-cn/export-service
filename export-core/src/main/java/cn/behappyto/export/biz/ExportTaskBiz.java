package cn.behappyto.export.biz;

/**
 * 导出任务
 *
 * @author behappyto.cn
 */
public interface ExportTaskBiz {

    /**
     * 开始导出
     *
     * @param sliceNum 分片的值
     * @param status   执行的状态
     * @return 返回 是否成功
     */
    Boolean execute(int sliceNum, int status);
}
