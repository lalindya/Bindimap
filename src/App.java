import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import model.*;


class App{

    public static final int QUERY_FREQUENCY = 1;
    
    private static int getTimeSpentAt(String locationName, int radius){
        Position position = getLocationCordinatesByName(locationName);
        int count = 0;
        if(position != null){
            count = getNearbyReadingCount(position.getX(), position.getY(), radius);
        }else{
            System.out.println( locationName + "Not found");
        }
        return count * QUERY_FREQUENCY; //Querying in every second
    }

    private static Position getLocationCordinatesByName(String name){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Location> locationArray = new ArrayList<>();
        try {
            locationArray.addAll(objectMapper.readValue(new File("src/data/Location.json"),new TypeReference<List<Location>>(){}));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Position position = null;
        for(Location data : locationArray){
            if(data.getName().equals(name)){
                position = data.getPosition();
                break;
            }
        }
        return position;
    }

    static int getNearbyReadingCount(double venue_x, double venue_y,double rad){
        
        List<Session> sessions = readJsonData();
        int count = 0;

        for (Session session : sessions) {
            for (SessionEvent event: session.getPath()){
                Double x = event.getPosition().getX();
                Double y = event.getPosition().getY();
                
                // Compare radius of circle with
                // distance of its center from
                // given point
                
                if ((x - venue_x) * (x - venue_x) +
                (y - venue_y) * (y - venue_y) <= rad * rad)
                    count += 1;
            }
         }
        return count;
    }

    static double getAverageTimePerSession(String locationName, int radius){
        List<Session> sessions = readJsonData();
        Position position = getLocationCordinatesByName(locationName);
        int count = 0;
        if(position != null){
            count = getNearbyReadingCount(position.getX(), position.getY(), radius);
        }
        System.out.println(sessions.size());
        double average = (double)count/sessions.size();
        return (double)count/sessions.size();
    }

    private static List<Session> readJsonData(){
        
        ObjectMapper objectMapper = new ObjectMapper();
        List<Session> sessions = new ArrayList<>();
        try {
            sessions.addAll(objectMapper.readValue(new File("src/data/Session.json"),new TypeReference<List<Session>>(){}));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessions;
    }

    public static void main(String arg[]){   
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("\n \nEnter Location Name or type 'exit' to exit");
            String name = "";
            try {
                name = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (name.equals("exit")){break;}
            
            System.out.println("\n \nEnter radius in meters");

            int radius = 0;
            try {
                radius = Integer.valueOf(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("\n \n ******** User stayed at " + name +" for "+ getTimeSpentAt(name,radius) + " Seconds ****** \n \n");

            Formatter formatter = new Formatter();
            formatter.format("%.2f",getAverageTimePerSession(name, radius));
            System.out.println("\n \n ******** Average visit time of " + name +" per session is "+ formatter.toString() + " Seconds ****** \n \n");
        }
    }
}
