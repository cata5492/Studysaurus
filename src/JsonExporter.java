import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonExporter {

	private Set _set;

	JsonExporter(Set set) {
		_set = set;
	}

	public int export() {
		JSONObject termValues = new JSONObject();

		for (Pair pair : set.getPairs()) {
			termValues.put(pair.getValue0(), pair.getValue1());
		}

		set.put("name", set.getName());
		set.put(set.getName(), termValues);

		try {
			FileWriter file = new FileWriter("/home/user/Desktop/Studysaurus/Sets/" + set.getName() + ".json");
			file.write(set.toJSONString());
			file.flush();
			file.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	public static void main(String[] args) {
		
	}
}
