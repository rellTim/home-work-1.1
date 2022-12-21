public class Worker {
    @FunctionalInterface
    interface OnTaskDoneListener{
        void onDone(String result);
    }
    @FunctionalInterface
    interface OnTaskErrorListener{
        void onError(String result);
    }
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;
    Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback){
        this.callback = callback;
        this.errorCallback = errorCallback;
    }
    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33){
                errorCallback.onError("err");
                i++;
            }
            callback.onDone("Task " + i + " is done");
        }
    }
}
