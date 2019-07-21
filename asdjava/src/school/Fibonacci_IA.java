package school;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci_IA {
    static int Val1 = 1;
    static int Val2 = 1;
    final static double phi = ((1+ Math.sqrt(5))/2);
    static double acc = 0.000005;
    static int total=13;
    static int[][] all =new int[total][total];
    static  double[][] all2 = new double[total][total];
    static int testTerm=10;
    static File outPath = new File("C:\\Users\\s-damania\\OneDrive - Bellevue School District\2018-2019\\math ia\\test1.csv");

    public static void main(String[] args) throws FileNotFoundException {


        System.out.println(phi);
        System.out.println();
        ArrayList<Integer> numArr = createSeq(2,1);
        ArrayList<Double> delArr = del(numArr);
        System.out.println(numArr);
        System.out.println(delArr);
        System.out.println(test(delArr));


        for (int f = 1; f <total; f++) {
            for (int h = 1; h < total; h++) {
                all[f][h]=full(f,h);
            }
        }
        for (int p = 1; p <total; p++) {
            for (int l = 1; l < total; l++) {
                all2[p][l]=full2(p,l);
            }
        }
        System.out.println(Arrays.toString(all[1]));
        out();

    }
    public static void out() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter (outPath);
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append("id");
        sb.append("\n");
        sb.append(",");
        
        for (int f = 1; f <total; f++) {
            for (int h = 1; h < total; h++) {
                sb.append(Math.abs(all2[f-1][h-1]*Math.pow(10,3)));
                sb.append(",");
            }
            sb.append("\n");
        }

        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }

    public static ArrayList<Integer> createSeq(int V1,int V2){
        Val1=V1;
        Val2=V2;
        ArrayList <Integer> numArr = new ArrayList <Integer>();
        for(int i=1;i<20;i++) {
            numArr.add(fib(i));
        }

        return numArr;
    }
    public static ArrayList<Double> del(ArrayList<Integer> seq){
        ArrayList<Double> delArr = new ArrayList<Double>();
        for(int j = 0; j < seq.size()-1; j++) {
            delArr.add(phi-(double)seq.get(j+1)/(double)seq.get(j));
        }
        return delArr;

    }
    public static int test(ArrayList<Double> dArr){
        boolean c=false;
        int ind = 0;
        for(int g=0;g < dArr.size();g++) {
            if(!c) {
                if(dArr.get(g) < acc && dArr.get(g) > -1*acc) {
                    ind=g;
                    c=true;
                }
            }
        }
        return ind;
    }

    public static int full(int M1,int M2){
        return test(del(createSeq(M1,M2)));
    }
    public static double full2(int M1,int M2){
        return del(createSeq(M1,M2)).get(testTerm);
    }

    public static int fib(int n) {
        if(n == 1)
            return Val1;
        else if(n == 2)
            return Val2;
        else {
            return fib(n-1)+fib(n-2);
        }
    }
}