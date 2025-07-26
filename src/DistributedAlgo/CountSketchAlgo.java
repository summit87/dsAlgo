package DistributedAlgo;

import java.util.Random;
import java.util.RandomAccess;

/**
 * This algothiam we are using to find the min count so far 
 * This is data structure will give probabalistic minimum count
 * We use below pram to claculate the min count 
 * 1. epsilon : This param will defined margin error in frequency
 * 2. delta : This param will defined probaility in error
 *  We creare 2D table : depth and width or (row and column)
 * depth : Math.ceill(lon(1/delta))
 * width :  Math.ceill(log(1/epsilon))
 */

public class CountSketchAlgo {
    public static void main(String[] args) {
        generateCountSketchTable(0.01, 0.001);
    }


    private static void generateCountSketchTable(double epsilon,double delta){
        int width = (int) Math.ceil((Math.E/epsilon));
        int depth = (int) Math.ceil(Math.log(1/delta));
        int[][] mat= new int[depth][width];
        int large = 2_147_483_647;
        int[] hash = new int[depth];
        Random random = new Random();
        for(int i=0;i<depth;i++){
            hash[i] =random.nextInt(large);
        }

        String[] stream = {
            "dog", "cat", "dog", "dog", "fish", "cat",
            "bird", "dog", "cat", "bird", "lion", "lion", "lion"
        };

        for(String s : stream){
            for(int i=0;i< depth;i++){
                mat[i][getIndex(s, hash[i], width)] ++;
            }
        }

       for(int i=0;i<depth;i++){
        for(int j=0;j<width;j++){
            System.out.print(mat[i][j]+" , ");
        }
        System.out.println();
       }
    }

    private static int getIndex(String key,int val,int width){
        return (key.hashCode() ^ val) % width;
    }
}
