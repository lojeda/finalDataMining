/**
 * Created by luis on 3/12/14.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class DataMiningFinal {

    public static void main(String[] args){

        ArrayList<ArrayList<String>> value = new ArrayList<ArrayList<String>>();

       // Double similar;

        String [] files = {"/../Webscope_A1/ydata-ysm-advertiser-bids-v1_0.txt","data/keywords-dataset-2.txt"};
       // String [] files = {"/../Webscope_A1/ydata-ysm-advertiser-bids-v1_0.txt","data/keywords-dataset-2.txt","data/webpages-dataset-1.txt","data/webpages-dataset-2.txt"};
        Double[] j_similar = new Double[6];
        Double[] a_similar = new Double[6];
        Double a_similarX;
        Double j_similarX;
        int k =0;


            for(int j=0; j<files.length; j++){

                value.add(kmeans(files[j]));

            }


            for(int j =0; j<files.length; j++){

                for(int i=j+1; i< files.length; i++){
                    try{
                        j_similar[k] = jaccardSimilarity(value.get(j),value.get(i));
                        a_similar[k] = andbergSimilarity(value.get(j),value.get(i));

                        System.out.println("\n The Jaccard Similarity Between A and B : " + j_similar[k]);
                        System.out.println("\n The Andberg Similarity Between A and B : " + a_similar[k]);

                    }
                    catch(Exception e){

                    }

                    k++;
                }

            }

        j_similarX = jaccardSimilarity(value.get(0),value.get(1));
        a_similarX = andbergSimilarity(value.get(0),value.get(1));

        System.out.println("LAST Jaccard Similarity Between A and B : " + j_similarX);

        System.out.println("LAST Andberg Similarity Between A and B : " + a_similarX);

    }

    public static ArrayList<String> getUnidimensionalArray(String fileName){

        ArrayList<String> info;

            FileReaderUni data;

            data = new FileReaderUni(fileName);

            info = data.getData();

        return info;
    }

    public static ArrayList<ArrayList<String>> getMultiDimensionalArray(String fileName){

        ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();

            FileReaderMulti dataMulti;

            dataMulti = new FileReaderMulti(fileName);

            lines = dataMulti.getDataMulti();

        return lines;
    }

    public static ArrayList<String> kmeans(String filename){

        ArrayList<String> dataUni;
        ArrayList<String>  answerKw = new ArrayList<String>();
        ArrayList<ArrayList<String>> lines;
        int k =3;


            dataUni = getUnidimensionalArray(filename);

            answerKw = getkwords(k,dataUni);

        return answerKw;

    }

    public static Double jaccardSimilarity(ArrayList<String> answerOne, ArrayList<String> answerTwo){

        ArrayList<String> unionAns;
        ArrayList<String> intersectionAns;
        Double similarity;


            answerOne = uniqueList(answerOne);
            answerTwo = uniqueList(answerTwo);

            unionAns = union(answerOne,answerTwo);
            intersectionAns = intersection(answerOne,answerTwo);

            unionAns = uniqueList(unionAns);

        //System.out.println("\n The Intersection A and  B : " + intersectionAns.size());
        //System.out.println("The Union between A U B: " + unionAns.size());


        similarity = (double)intersectionAns.size()/ (double)unionAns.size();

        return similarity;
    }

    public static Double andbergSimilarity(ArrayList<String> answerOne, ArrayList<String> answerTwo)
    {
        ArrayList<String> unionAns;
        ArrayList<String> intersectionAns;
        ArrayList<String> symmetricDifference;
        Double similarity=0.0;

        answerOne = uniqueList(answerOne);
        answerTwo = uniqueList(answerTwo);

        unionAns=union(answerOne,answerTwo);
        unionAns=uniqueList(unionAns);

        intersectionAns=intersection(answerOne,answerTwo);

        symmetricDifference=unionAns;

        for(int i=0;i<intersectionAns.size();i++)
        {
            for(int j=0;j<unionAns.size();j++)
            {
                if(intersectionAns.get(i).equals(unionAns.get(j)))
                {
                    symmetricDifference.remove(j);
                }
            }
        }

        similarity=(double)intersectionAns.size()/((double)unionAns.size()+(double)symmetricDifference.size());

        return similarity;



    }


    public static ArrayList<String> uniqueList( ArrayList<String> dataValues){

         HashSet hsOne = new HashSet();

            hsOne.addAll(dataValues);
            dataValues.clear();
            dataValues.addAll(hsOne);

         return dataValues;
     }

     public static ArrayList<String> getkwords(int k, ArrayList<String> dataUni){

         String newWord = "";
         ArrayList<String>  answer = new ArrayList<String>();
         int j =0;

         for(int i=0; i<dataUni.size(); i++){

            if(j < k){

                newWord = newWord+ " "+ dataUni.get(i);
                j++;

            }else{

                answer.add(newWord.trim());
                i = i - j;
                j =0;
                newWord = "";

            }

        }

         return answer;
    }


    public  static <T> ArrayList<T> union(ArrayList<T> list1, ArrayList<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }

    public static <T> ArrayList<T> intersection(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
}
