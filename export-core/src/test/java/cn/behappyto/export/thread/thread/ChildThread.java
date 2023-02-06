package cn.behappyto.export.thread.thread;

/**
 * ChildThread
 *
 * @author behappyto.cn
 * @date 2022/11/07 22:24
 */
public class ChildThread extends Thread {

    /**
     * 线程名称
     */
    private final String threadName;

    /**
     * 构造函数
     *
     * @param threadName 线程名称
     */
    public ChildThread(String threadName) {
        this.threadName = threadName;
    }

    /**
     * 重写run方式
     */
    @Override
    public void run() {
        System.out.println(threadName);
    }
}
