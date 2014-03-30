/**
 * Created by luis on 3/13/14.
 */

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderMulti {

    private ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();

    FileReaderMulti(String filename){

        try{

            String name = "data/" +filename;
            FileReader f = new FileReader(new File(name));
            BufferedReader bf = new BufferedReader(f);

            Scanner fileReader = new Scanner(bf);

            while(fileReader.hasNextLine() == true){

                String line =fileReader.nextLine();
                String[] tokens = line.split(" ");

                ArrayList<String> temp = new ArrayList<String>();

                for(int i=0; i<tokens.length; i++){

                    temp.add(tokens[i].trim());


                }

                lines.add(temp);

                //String word = lines.get(0).get(10);

               // int blah = 0;

            }

            fileReader.close();

        }

        catch(Exception e){

        }

    }

    public ArrayList<ArrayList<String>> getDataMulti(){
        return lines;
    }
}
