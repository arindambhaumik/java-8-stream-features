package builder;

public class BuilderPatternDemo {

    public static void main(String[] args) {

        // flexible object creation by builder pattern, we can skip any of the property if not needed.
        URLBuilder builder = new URLBuilder()
                .setProtocol("http://")
                .setHost("localhost:")
                //.setPort("8080/")
                .setPathParam("api/version");
        MyURL myURL = builder.buildURL();

        System.out.print(myURL.protocol);
        System.out.print(myURL.host);
        System.out.print(myURL.port);
        System.out.println(myURL.pathParam);

        //System.out.println(myURL);

    }
}
