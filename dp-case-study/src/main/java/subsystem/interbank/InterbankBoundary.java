package subsystem.interbank;

import common.exception.UnrecognizedException;
import utils.ApplicationProgrammingInterface;
import utils.PostAPI;

public class InterbankBoundary {
	// Communicational cohesion
	String query(String url, String data) {
		String response = null;
		try {
//			response = ApplicationProgrammingInterface.post(url, data);
			response = new PostAPI().execute(url, data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UnrecognizedException();
		}
		return response;
	}

}
