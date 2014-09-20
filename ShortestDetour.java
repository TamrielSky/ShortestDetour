import java.util.HashMap;
import java.util.Scanner;


public class ShortestDetour {

	HashMap<String, GeoPoint> GeoLocations = new HashMap<String, GeoPoint>();
	
	double Driver1Distance; 
	double Driver2Distance;

	
	double Driver1Detour;
	double Driver2Detour;
	
	public void getDriver1Detour(HashMap<String, GeoPoint> GeoLocations)
	{
	
		double detour = distanceBetween(GeoLocations.get("A").getLatitude(), GeoLocations.get("A").getLongitude(), GeoLocations.get("C").getLatitude(), GeoLocations.get("C").getLongitude());
		
		detour = detour + distanceBetween(GeoLocations.get("D").getLatitude(), GeoLocations.get("D").getLongitude(), GeoLocations.get("B").getLatitude(), GeoLocations.get("B").getLongitude());
        
		Driver1Detour = detour;
		
	}
	
	public void getDriver2Detour(HashMap<String, GeoPoint> GeoLocations)
	{
	
		double detour = distanceBetween(GeoLocations.get("C").getLatitude(), GeoLocations.get("C").getLongitude(), GeoLocations.get("A").getLatitude(), GeoLocations.get("A").getLongitude());
		
		detour = detour + distanceBetween(GeoLocations.get("B").getLatitude(), GeoLocations.get("B").getLongitude(), GeoLocations.get("D").getLatitude(), GeoLocations.get("D").getLongitude());
        
		Driver2Detour = detour;

		
	}
	
	 public double distanceBetween(double latitude1, double longitude1, double latitude2, double longitude2 ) {  
	        double R = 6371; // km  
	        double dLat = Math.toRadians(latitude2-latitude1);  
	        double dLon = Math.toRadians(longitude2-longitude1);  
	        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +  
	                Math.cos(Math.toRadians(latitude2)) * Math.cos(Math.toRadians(latitude1)) *   
	                Math.sin(dLon/2) * Math.sin(dLon/2);   
	        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));   
	        return R * c;         
	 }
	 
	 
	public static void main(String args[])
	{
		 double latitude1, longitude1, latitude2, longitude2;	
		 ShortestDetour sd = new ShortestDetour();
		 
		 Scanner s = new Scanner(System.in);

		 System.out.println("----Enter start and end points for Driver 1----");
		 System.out.println("Enter start point latitude");
		 latitude1 = s.nextDouble();
		 System.out.println("Enter start point longitude");
		 
		 longitude1 = s.nextDouble(); 		 
		 sd.GeoLocations.put("A", new GeoPoint(latitude1, longitude1));
         
		 System.out.println("Enter end point latitude");
		 latitude2 = s.nextDouble();
		 System.out.println("Enter end point longitude");

		 longitude2 = s.nextDouble(); 		 

		 sd.GeoLocations.put("B", new GeoPoint(latitude2, longitude2));
         sd.Driver1Distance = sd.distanceBetween(latitude1, longitude1, latitude2, longitude2 );
         System.out.println("A to B is "+ sd.Driver1Distance);
         
		 System.out.println("----Enter start and end points for Driver 2----");
		 System.out.println("Enter start point latitude");
		 latitude1 = s.nextDouble();
		 
		 System.out.println("Enter start point longitude");

		 longitude1 = s.nextDouble();
         
		 sd.GeoLocations.put("C", new GeoPoint(latitude1, longitude1));
         
		 System.out.println("Enter end point latitude");
		 latitude2 = s.nextDouble();
		 System.out.println("Enter end point longitude");

		 longitude2 = s.nextDouble(); 		 

		 sd.GeoLocations.put("D", new GeoPoint(latitude2, longitude2));
         sd.Driver2Distance = sd.distanceBetween(latitude1, longitude1, latitude2, longitude2 );

         System.out.println("C to D is "+ sd.Driver2Distance);
         
         sd.getDriver1Detour( sd.GeoLocations);
         sd.getDriver2Detour( sd.GeoLocations);
         
         if(sd.Driver1Detour > sd.Driver2Detour)
         {
        	 System.out.println("Detour for driver 1 is" +sd.Driver1Detour );
        	 System.out.println("Detour is less for driver 1 via route ACDB");
         }
         else
         {
        	 System.out.println("Detour for driver 2 is" +sd.Driver2Detour );
        	 System.out.println("Detour is less for driver 2 via route CABD");

         }

         
	}
	
	
	
}

class GeoPoint {

	private double latitude;
	private double longitude;
	
	public double getLatitude()
	{
	 return latitude;	
	}
	
	public double getLongitude()
	{
		return longitude;
	}
	
	public GeoPoint(double latitude, double longitude)
	{
       this.latitude = latitude;
       this.longitude = longitude;
	}
	
}

