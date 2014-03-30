import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by luis on 3/12/14.
 */
public class FileReaderUni {

    private ArrayList<String> words = new ArrayList<String>();
    FileReaderUni(String filename){

        try{

            String name = filename;
            FileReader f = new FileReader(new File(name));
            BufferedReader bf = new BufferedReader(f);

           // Scanner fileReader = new Scanner( new File(filename));
            Scanner fileReader = new Scanner(bf);

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
