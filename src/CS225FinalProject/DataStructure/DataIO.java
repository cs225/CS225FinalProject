package CS225FinalProject.DataStructure;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.JOptionPane;

/*
 * Author: Ramsey
 * This class will load in an array of data based on the calling method
 * loadUsers will load in a file which is a list of users to be checked on login and pass them to the calling class as an array list
 * loadData will load in user sessions as objects and pass them back
 * commented out scenario info - as this is now held in the user objects themselves.
 */

public class DataIO {

	private File userFile;
	private File scenarioFile;
	private File classNameFile;

	private String password = "cs225yay";
	private SecretKeyFactory keyFactory;
	private SecretKey secretKey;
	private Cipher desCipher;

	// private File completedScenarioFile;

	public DataIO() {
		// Define files here
		userFile = new File("users.lst");
		scenarioFile = new File("scenarios.lst");
		classNameFile = new File("classnames.lst");
		// completedScenarioFile = new File("completed.lst");

		byte key[] = password.getBytes();
		DESKeySpec desKeySpec;
		try {
			desKeySpec = new DESKeySpec(key);

			keyFactory = SecretKeyFactory.getInstance("DES");

			secretKey = keyFactory.generateSecret(desKeySpec);
			desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public ArrayList<User> loadUserList() {
		// new array list

		ArrayList<User> userList = new ArrayList<User>();

		// read file and de-serialize
		try {
			desCipher.init(Cipher.DECRYPT_MODE, secretKey);

			FileInputStream fis = new FileInputStream(userFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			CipherInputStream cis = new CipherInputStream(bis, desCipher);
			ObjectInputStream ois = new ObjectInputStream(cis);

			userList = (ArrayList<User>) ois.readObject();

			ois.close();

		} catch (IOException e) {

			System.out.println("Error Finding File:"
					+ userFile.getAbsolutePath());

			// returning null if file not found
			return null;
			// can allow user to select file if file not found?
		} catch (Exception e) {

			e.printStackTrace();
		}

		// return array list
		return userList;
	}

	public ArrayList<Scenario> loadScenarioList() {
		ArrayList<Scenario> scenarioList = new ArrayList<Scenario>();

		try {
			desCipher.init(Cipher.DECRYPT_MODE, secretKey);

			FileInputStream fis = new FileInputStream(scenarioFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			CipherInputStream cis = new CipherInputStream(bis, desCipher);
			ObjectInputStream ois = new ObjectInputStream(cis);

			scenarioList = (ArrayList<Scenario>) ois.readObject();

			ois.close();
		} catch (IOException e) {

			System.out.println("Error Finding File:"
					+ scenarioFile.getAbsolutePath());

			return null;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return scenarioList;

	}
        
        /**
         * This method is to import from a file. 
         * 
         * @param file
         * @return
         *@author Eric
         */
        public ArrayList<Scenario> loadScenarioList(String file) {
		ArrayList<Scenario> scenarioList = new ArrayList<Scenario>();

		try {
			desCipher.init(Cipher.DECRYPT_MODE, secretKey);

			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			CipherInputStream cis = new CipherInputStream(bis, desCipher);
			ObjectInputStream ois = new ObjectInputStream(cis);

			scenarioList = (ArrayList<Scenario>) ois.readObject();

			ois.close();
		} catch (IOException e) {

			System.out.println("Error Finding File:"
					+ scenarioFile.getAbsolutePath());

			return null;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return scenarioList;

	}
        

	public ArrayList<String> loadClassNameList() {
		ArrayList<String> classList = new ArrayList<String>();

		try {
			desCipher.init(Cipher.DECRYPT_MODE, secretKey);

			FileInputStream fis = new FileInputStream(classNameFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			CipherInputStream cis = new CipherInputStream(bis, desCipher);
			ObjectInputStream ois = new ObjectInputStream(cis);

			classList = (ArrayList<String>) ois.readObject();

			ois.close();
		} catch (IOException e) {

			System.out.println("Error Finding File:"
					+ classNameFile.getAbsolutePath());

			return null;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return classList;
	}

	public boolean writeUserList(ArrayList<User> userList) {
		try {

			desCipher.init(Cipher.ENCRYPT_MODE, secretKey);

			FileOutputStream fos = new FileOutputStream(userFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			CipherOutputStream cos = new CipherOutputStream(bos, desCipher);
			ObjectOutputStream oos = new ObjectOutputStream(cos);

			oos.writeObject(userList);
			oos.flush();
			oos.close();
			// success
			return true;

		} catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "Could not the record of the students. Please check that you have free space in your computer");
			System.out.println(e);
			return false;
		}

	}

	public boolean writeScenarioList(ArrayList<Scenario> scenarioList) {
		try {

			desCipher.init(Cipher.ENCRYPT_MODE, secretKey);

			FileOutputStream fos = new FileOutputStream(scenarioFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			CipherOutputStream cos = new CipherOutputStream(bos, desCipher);
			ObjectOutputStream oos = new ObjectOutputStream(cos);

			oos.writeObject(scenarioList);
			oos.flush();
			oos.close();
			return true;

		} catch (Exception e) {

           JOptionPane.showMessageDialog(null, "Could not the records of the scenarios Please check that you have free space in your computer");

			System.out.println(e.getMessage());
			return false;
		}
	}
        
        /**
         * Exporting method for scenarios
         * @param file
         * @param scenarioList
         * @return 
         * *@author Eric
         */
        public boolean writeScenarioList(String fileName ,ArrayList<Scenario> scenarioList) {
		try {

			desCipher.init(Cipher.ENCRYPT_MODE, secretKey);

			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			CipherOutputStream cos = new CipherOutputStream(bos, desCipher);
			ObjectOutputStream oos = new ObjectOutputStream(cos);

			oos.writeObject(scenarioList);
			oos.flush();
			oos.close();
			return true;

		} catch (Exception e) {

                               JOptionPane.showMessageDialog(null, "Could not the records of the scenarios Please check that you have free space in your computer");

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean writeClassNameList(ArrayList<String> classNameList) {
		try {

			desCipher.init(Cipher.ENCRYPT_MODE, secretKey);

			FileOutputStream fos = new FileOutputStream(classNameFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			CipherOutputStream cos = new CipherOutputStream(bos, desCipher);
			ObjectOutputStream oos = new ObjectOutputStream(cos);

			oos.writeObject(classNameList);
			oos.flush();
			oos.close();
			return true;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}
}
