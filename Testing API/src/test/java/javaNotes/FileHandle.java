package javaNotes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandle {
	//create new file
	//File class - will only create file or delete or perform action asround file or directory
	//FileWriter - to overwrite the content add and append in file or it creates the file it does not exist.
	//filereader = reads the files content

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\anupa\\eclipse-workspace\\Testing API\\File/test12.txt";
		File file = new File(path);
//		FileWriter fl= new FileWriter(file);//creating a new file
//		//or we can pass the file name
//		fl.write("hello worldruyty\nbhgf");
//		fl.close();
	}

}
