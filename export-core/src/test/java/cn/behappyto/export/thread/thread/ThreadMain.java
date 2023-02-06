package cn.behappyto.export.thread.thread;

/**
 * 线程的入口类
 */
public class ThreadMain {

    /**
     * 程序的入口
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        // 子线程1
        ChildThread childThread = new ChildThread("thread1-");
        childThread.start();

        // 子线程2
        childThread = new ChildThread("thread2-");
        childThread.start();
    }
}
