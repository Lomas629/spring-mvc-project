package librarymvc.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import librarymvc.dao.ExtractData;

@Service
public class UserService {
	
	@Autowired
	ExtractData api;
	
	public boolean checkforUser(String name,String password) throws IOException, InterruptedException {
		return api.check(name, password);
	}

	
	
}
