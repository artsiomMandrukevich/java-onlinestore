package by.artem.store.middleware;

public class MiddlewareServer {
    private Middleware middleware;

    public void setMiddleware(Middleware middleware){
        this.middleware = middleware;
    }

    public boolean processingMiddleware(String consoleCommand){
        return middleware.check(consoleCommand);
    }

}
