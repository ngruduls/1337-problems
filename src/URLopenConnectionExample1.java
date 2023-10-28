import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLopenConnectionExample1{

    public static void main(String args[]) throws Exception
    {
        URL url = new URL("http://www.javatpoint.com");
        URLConnection connection = url.openConnection( );
        String mimeType = connection.getContentType( );
        System.out.println(" The mime type is : "+mimeType);
        System.out.println(" The time out time of connection is : "+connection.getConnectTimeout());
    }
}