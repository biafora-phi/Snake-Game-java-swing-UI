package Controller;

import java.io.*;

public class GestioneFile {

    public GestioneFile(){
    }

    public void scriviSuFile(String a) {

        try {
            PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("src/ef.txt", true)));
            w.println(a + " ");
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String lastScore() {
    	BufferedReader input;
    	String last = null;
    	String line;
		try {
			input = new BufferedReader(new FileReader("src/ef.txt"));
			try {
				while ((line = input.readLine()) != null) { 
				    last = line;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return last;
       
    }
}
