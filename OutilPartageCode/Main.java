package runtimeExecAvecParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		String[] cmdarray = {"/home/jordane/Bureau/afficherNbArgs.sh", "a", "z", "a z e r t y"};
		Process process = Runtime.getRuntime().exec(cmdarray);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
	}

}
