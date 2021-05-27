package kodlamaio.HRMSDB.core.utilities.verificationCode;

import java.util.UUID;

//kodu oluşturduk
public class CodeGenerator {

//c# daki gibi guid oluşturup onu stringe çeviriyor ve döndürüyor.
	
	public static String codeGenerator() {
		UUID uuid = UUID.randomUUID();
        String verificationCode = uuid.toString();
        return verificationCode;
		
	}

}
