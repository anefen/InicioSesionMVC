package dad.javafx.iniciosesion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.codec.digest.DigestUtils;

public class SesionModel {

	public boolean checkLogin(String user, String password) throws Exception {
		boolean isValid = false;
		String passwordMD5 = DigestUtils.md5Hex(password).toUpperCase();
		File csvFile = new File("users.csv");
		FileReader fr = new FileReader(csvFile);
		BufferedReader br = new BufferedReader(fr);
		String line;

		while ((line = br.readLine()) != null && !isValid) {
			String[] lines = line.split(",");

			if (lines[0].equals(user) && lines[1].equals(passwordMD5)) {
				isValid = true;

			}
		}
		br.close();
		return isValid;

	}

}
