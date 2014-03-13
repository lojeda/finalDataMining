/**
 * Created by luis on 3/12/14.
 */

import java.util.ArrayList;


public class DataMiningFinal {

    public static void main(String[] args){

        //Getting Data in an uni-dimensional Array
        getUnidimensionalArray("keywords-dataset-1.txt");


        //Getting Data in a bi-dimensional Array
        getMultiDimensionalArray("keywords-dataset-1.txt");

    }

    public static void getUnidimensionalArray(String fileName){

        ArrayList<String> info;

            FileReaderUni data;

            data = new FileReaderUni(fileName);

            info = data.getData();

            for(int i=0; i<info.size(); i++){

                System.out.println(info.get(i));
            }

        // This is when we want to get the real value of Info and not Print it as it is right now
        // Keep in mind to change the void for the method

        //return info;
    }

    public static void getMultiDimensionalArray(String fileName){

        ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();

        FileReaderMulti dataMulti;

        dataMulti = new FileReaderMulti(fileName);

        lines = dataMulti.getDataMulti();

        for(int i=0; i<lines.size(); i++){

            System.out.println(lines.get(i));
        }

        // This is when we want to get the real value of Info and not Print it as it is right now
        // Keep in mind to change the void for the method

        //return lines;
    }
}
