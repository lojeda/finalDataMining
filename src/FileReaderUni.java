import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by luis on 3/12/14.
 */
public class FileReaderUni {

    private ArrayList<String> words = new ArrayList<String>();
    FileReaderUni(String filename){

        try{

            Scanner fileReader = new Scanner( new File(filename));

            while(fileReader.hasNextLine() == true){

                String line =fileReader.nextLine();
                String[] tokens = line.split(" ");
                for(int i=0; i<tokens.length; i++){

                    words.add(tokens[i].trim());

                }

            }

            fileReader.close();
        }

        catch(Exception e){

        }

    }

   public ArrayList<String> getData(){
        return words;
    }
}
