package builder;

public class MyURL {
    public String protocol;
    public String host;
    public String port;
    public String pathParam;

    /**
     * only be invoked by Builder class
     */
    public MyURL(String protocol, String host, String port, String pathParam) {
        if(null == protocol) {
            protocol = "";
        }
        else if(null == host){
            host = "";
        }
        else if(null == port){
            port = "";
        } else if (null == pathParam) {
            pathParam = "";
        }

        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.pathParam = pathParam;
    }

    @Override
    public String toString() {
        return "MyURL{" +
                "protocol='" + protocol + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", queryParam='" + pathParam + '\'' +
                '}';
    }
}
