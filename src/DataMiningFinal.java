/**
 * Created by luis on 3/12/14.
 */

import java.util.ArrayList;


public class DataMiningFinal {

    public static void main(String[] args){

        //Getting Data in an uni-dimensional Array

       ArrayList<String> info;

        try{

            FileReaderUni data;

            data = new FileReaderUni("keywords-dataset-1.txt");

            info = data.getData();

            for(int i=0; i<info.size(); i++){

                System.out.println(info.get(i));
            }

        }
        catch(Exception e){


        }

        //Getting Data in a bi-dimensional Array

        ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();

            FileReaderMulti dataMulti;

            dataMulti = new FileReaderMulti("keywords-dataset-1.txt");

            lines = dataMulti.getDataMulti();

            for(int i=0; i<lines.size(); i++){

                System.out.println(lines.get(i));
            }

    }
}
