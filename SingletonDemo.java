class SystemLogger {
    private static final SystemLogger instance = new SystemLogger();
    private int eventCount = 0;

    private SystemLogger() { }

    public static SystemLogger getInstance() {
        return instance;
    }

    public void recordEvent() {
        eventCount++;
    }

    public int getTotalEvents() {
        return eventCount;
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        SystemLogger[] loggers = new SystemLogger[3];

        for (int i = 0; i < 3; i++) {
            loggers[i] = SystemLogger.getInstance();
            loggers[i].recordEvent();
            System.out.println("Current Event Count: " + loggers[i].getTotalEvents());
        }
    }
}