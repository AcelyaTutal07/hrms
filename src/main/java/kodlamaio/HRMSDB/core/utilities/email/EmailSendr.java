package kodlamaio.HRMSDB.core.utilities.email;

import org.springframework.stereotype.Component;

@Component
public class EmailSendr implements EmailSendrService {

	//doğrulama emaili oluşturduk
	//body= email konu
	@Override
	public void send(String body) {
		System.out.println(body);
		
	}

}
