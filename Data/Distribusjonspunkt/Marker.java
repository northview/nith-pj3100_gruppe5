package GetMarkers;

public class Marker {
	private double latitude;
	private double longitude;
	private String name;
	private String address;
	private String city;
	private String url;
	
	public Marker(String latitude, String longitude, String name, String address, String city) {
		this.latitude = Double.parseDouble(latitude);
		this.longitude = Double.parseDouble(longitude);
		this.name = name;
		this.address = address;
		this.city = city;
	}
	
	public Marker(Double latitude, Double longitude, String name, String address, String city) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.address = address;
		this.city = city;
	}
	
	public Marker() {
		
	}
	

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = Double.parseDouble(latitude);
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = Double.parseDouble(longitude);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		String s = "" + latitude + "\n" + longitude + "\n" + name + "\n" + address + "\n" + url;
		
		return s;
		
	}

}
