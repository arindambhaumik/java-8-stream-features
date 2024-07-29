package builder;

/**
 * Example of custom Builder pattern. Here is the Builder class for URL
 */
public class URLBuilder {

    private String protocol;
    private String host;
    private String port;
    private String pathParam;

    public URLBuilder setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public URLBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public URLBuilder setPort(String port) {
        this.port = port;
        return this;
    }

    public URLBuilder setPathParam(String pathParam) {
        this.pathParam = pathParam;
        return this;
    }

    /**
     * Create and return the new URL object based on property
     */
    public MyURL buildURL(){
        return new MyURL(protocol,host,port, pathParam);
    }
}
