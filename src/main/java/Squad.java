import java.util.ArrayList;
public class Squad {
private String mDetails;
private static ArrayList<Squad> instances = new ArrayList<Squad>();
private int mId;

  public Squad(String details) {
  	mDetails = details;
  	instances.add(this);
  	mId = instances.size();
  }

  public String getDetails() {
  	return mDetails;
  }

  public static ArrayList<Squad> all() {
  	return instances;
  }

  public static void clear() {
  	instances.clear();
  }

  public int getId() {
  	return mId;
  }

  public static Squad find(int id) {
  	return instances.get(id - 1);
  }

}