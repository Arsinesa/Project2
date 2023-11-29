import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class NetworkScanner {

    public static List <String> NetworkScanner(){
        List <String> activeIPs= new ArrayList<String>();
        try {
            String localHostAddress = InetAddress.getLocalHost().getHostAddress();
            String[] LocalHostAddressParts = localHostAddress.split("//.");
            for (int i = 1; i<255; i++){
                String ipAddress = LocalHostAddressParts[0]+"." +
                        ""+LocalHostAddressParts[1]+"."+LocalHostAddressParts[2]+"."+i;
                        if (InetAddress.getByName(ipAddress).isReachable(1000)){
                            activeIPs.add(ipAddress);

                        }
            }

        } catch (UnknownHostException e){
            System.out.println("Error: "+ e.getMessage());}
        catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());}
        return activeIPs;
        }
    }

