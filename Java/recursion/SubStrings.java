package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubStrings {

    static void printAllSubStrings(String input,String output){
        if(input.length() == 0){
            if(output.length() == 0) System.out.println("Empty "); else System.out.println(output);
        } else {
            printAllSubStrings(input.substring(1),output);
            printAllSubStrings(input.substring(1),input.charAt(0)+output);
        }
    }

    static String[] getAllSubStrings(String word){
        if(word.length() == 0){
            return new String[]{""};
        } else {
            String[] smallResult = getAllSubStrings(word.substring(1));
            String[] result = new String[2 * smallResult.length];
            for (int i = 0; i <smallResult.length ; i++) {
                result[i]=smallResult[i];
            }
            for (int i = smallResult.length; i < result.length ; i++) {
                result[i]=word.charAt(0)+smallResult[i-smallResult.length];
            }
            return result;
        }
    }
    public static String[] getAllStringsByBitMasking(String str){
        int noOfSubStrings = (1 << str.length()) ;
        String[] subStrings = new String[noOfSubStrings];
        subStrings[0]="";
        for (int i = 1; i < noOfSubStrings ; i++) {
            int temp = i;
            int j=0;
            StringBuilder sbr = new StringBuilder("");
            while (temp > 0){
                if((temp & 1) == 1){
                    sbr.append(str.charAt(j));
                }
                j++;
                temp = temp >> 1;
            }
            subStrings[i]= sbr.toString();
        }
        return subStrings;

        /*String[] abc = getAllSubStrings("ABCD");
        String[] abc = getAllStringsByBitMasking("ABC");
        for (int i = 0; i < abc.length; i++) {
            System.out.println(abc[i]);
        }*/
    }
    static int[] acmTeam(String[] topic) {
        int max=-1;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <topic.length-1 ; i++) {
            for (int j = i+1; j <topic.length ; j++) {
                int count =0;
                for (int k = 0; k <topic[0].length() ; k++) {
                    if(topic[i].charAt(k)=='1'||'1' == topic[j].charAt(k)){
                        count++;
                    }
                }
                if(max == count){
                    List<Integer> t = new ArrayList<Integer>(2);
                    t.add(i);
                    t.add(j);
                    list.add(t);
                } else  if(max < count){
                    list.clear();
                    max = count;
                    List<Integer> t = new ArrayList<Integer>(2);
                    t.add(i);
                    t.add(j);
                    list.add(t);
                }
            }
        }
        return new int[]{max,list.size()};
        /*String[] strArray = new String[]{"10101","11100","11010","00101"};
        int[] result = acmTeam(strArray);
        System.out.println(result[0]);
        System.out.println(result[1]);*/
    }
    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        long total = 0;
        if((bc < wc) && (bc + z < wc)){
            total = (long) (b + w) * (long) bc +(long) w * z;
        } else if ((bc > wc) && (wc + z < bc)){
            total = (long) (b + w) * (long) wc + (long) b * z;
        } else {
            total = (long) w * (long)wc +(long) b * (long) bc;
        }
        return total;

        //        System.out.println(taumBday(443463982,833847400,429734889, 628664883, 610875522));
//        System.out.println(taumBday(623669229, 435417504, 266946955, 600641444, 515391879));
//        System.out.println(taumBday(763364819, 37220400,711640763, 34378393, 655626808));
//        System.out.println(taumBday(177742229, 51792729,358392247, 642296973, 158448705));
//        System.out.println(taumBday(402332409, 253667421,384186676, 728988281, 883897044));
//
//        System.out.println(taumBday(962555475, 753433321, 20275090, 23915540, 815412555));
//        System.out.println(taumBday(853918694, 319895873, 649259954, 136169934, 948560755));
//        System.out.println(taumBday(112651828, 759839162, 236494610, 379598782, 212996957));
//        System.out.println(taumBday(751886489, 142963601, 250217357, 463527251, 29858345));
//        System.out.println(taumBday(905844164, 493785831, 81651073, 116752762, 136082804));
    }
    public static void main(String[] args) {


        System.out.println("Long largest : "+Long.MAX_VALUE);

    }

}
