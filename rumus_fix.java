/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author mz-hafizha
 */
public class rumus_fix {

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new LinkedHashSet 
        Set<T> set = new LinkedHashSet<>();

        // Add the elements to set 
        set.addAll(list);

        // Clear the list 
        list.clear();

        // add the elements of set 
        // with no duplicates to the list 
        list.addAll(set);

        // return the list 
        return list;
    }

    static int knapsackDP(int[] w, int[] v, int n, int W) {
        List<String> surahList = new ArrayList<>();
        System.out.println(surahList.size());

        if (n <= 0 || W <= 0) {
            return 0;
        }

        int[][] m = new int[n + 1][W + 1];
        for (int j = 0; j <= W; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>> i: " + i);

            for (int j = 1; j <= W; j++) {
                System.out.println(">>>>>>>>>>>>>j: " + j);
//                System.out.println(surahList.size());
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
//                    System.out.println("a :::: " + (i - 1) + " " + (j) + " " + m[i][j]);
//                    System.out.println(j - w[i - 1] + " " + v[i - 1]);
                } else {
                    m[i][j] = Math.max(
                            m[i - 1][j],
                            m[i - 1][j - w[i - 1]] + v[i - 1]);
//                    System.out.println("b :::: " + (i - 1) + " " + (j - w[i - 1]) + " " + m[i][j]);
//                    System.out.println(j - w[i - 1] + " " + v[i - 1]);
//                    System.out.println("baru " + (m[i - 1][j - w[i - 1]] + v[i - 1]));
                    int inj = j - w[i - 1];

                    // kalo maks pada tahap i lebih besar dari i-1
                    if (j == W && i == n) {
                        int k = W;
                        for (int x = n; x >= 1; x--) {
//                            System.out.println(k);
                            if (k != 0) {
                                int a = m[x - 1][k]; // tadi
                                int b = m[x - 1][k - w[x - 1]] + v[x - 1];
                                if (a < b) {
//                                    System.out.println("a<b " + a + " " + b + " k " + k);
//                                System.out.println(m[x - 1][j - w[x - 1]]);
                                    System.out.println(v[x - 1] + " x " + x);
                                    if (v[x - 1] == 162) {
                                        surahList.add("At-Tin");
                                    } else if (v[x - 1] == 102){
                                        surahList.add("Al-Insyirah");
                                    } else if (v[x - 1] == 165){
                                        surahList.add("Ad-Dhuha");
                                    } else if (v[x - 1] == 158){
                                        surahList.add("Al-Zalzalah");
                                    } else if (v[x - 1] == 169){
                                        surahList.add("Al-Adhiyat");
                                    } else if (v[x - 1] == 160){
                                        surahList.add("Al-Qori'ah");
                                    }
                                    System.out.println(surahList);
                                    
                                    k = k - w[x - 1];

                                }
                                // sekarang
//                             System.out.println("ha");
                            } else {
                                System.out.println("err");
                            }
//                            if ((m[x - 1][j - w[x - 1]] + v[x - 1]) > (m[x - 1][j]) && (m[x - 1][j - w[x - 1]] > 0)) {
//                                System.out.println(v[x-1]+" x "+x);
//                            } else {
//                                System.out.println(v[x-2]);
//                            }

                        }

                    }

//                    if ((m[i - 1][j - w[i - 1]] + v[i - 1]) > (m[i - 1][j])) {
//                        surahList.add(v[i-1]);
//                         List<Integer> newList = surahList.stream() 
//                                      .distinct() 
//                                      .collect(Collectors.toList());
//                         System.out.println(newList);
//                    } else {
//                        break;
//                    }
//                    System.out.println("======================================");
//                    System.out.println("op: " + m[i][j]);
////                    surahList.add(1, Integer.toString(v[i-1]));
////                    System.out.println(surahList.get(surahList.size()-2)+" "+ surahList.get(surahList.size()-1));
////                    System.out.println(surahList.get(surahList.size()-1));
//                    
////                    System.out.println(surahList.get(surahList.size()-2)==surahList.get(surahList.size()-1));
//                    
//                    int inj = j - w[i - 1];
//                    int a = m[i - 1][j - w[i - 1]] + v[i - 1];
//                    int b = m[i - 1][j];
//
//                    if (inj >=0) {
//                        if (a > b) {
//                            if (surahList.size()==0 || surahList.size()==1) {
//                                surahList.add(v[i-1]);
////                                System.out.println(surahList.get(surahList.size()-1));
//                            }   else if(surahList.size()==2 ) {
////                                surahList.set(surahList.size()-1, surahList.get(surahList.size()));
////                                surahList.remove(surahList.size()-2);
//
//                                if (surahList.get(surahList.size()-1)== surahList.get(surahList.size()-2)) {
//                                    surahList.remove(surahList.size()-1);
//                                    System.out.println("suraaaaaaaaaaah" + surahList);
//                                } else {
//                                    surahList.add(v[i-1]);
//                                    System.out.println("suraaaaaaaaaaah" + surahList);
//                                }
//                                    
//                            } else {
//                                System.out.println("elseeeeeeeeeeee");
//                                surahList.remove(surahList.size()-1);
//                                if (surahList.get(surahList.size()-1)== surahList.get(surahList.size()-2)) {
//                                    surahList.remove(surahList.size()-1);
//                                    System.out.println("suraaaaaaaaaaah" + surahList);
//                                } else {
//                                    surahList.add(v[i-1]);
//                                    System.out.println("suraaaaaaaaaaah" + surahList);
//                                }
//                            }
//                    } else {
//                        surahList.add(v[i-1]);
//                        surahList.remove(surahList.size()-1);
//                    }
//                    
////                    System.out.println(surahList.get(surahList.size()-1) + Integer.toString(v[i - 1]));
//                    System.out.println(w[i - 1]);
//                    System.out.println("inj "+inj);
//                    System.out.println(a + " " + b);
//                    System.out.println("W "+ W);
//                    System.out.println("suraaaaaaaaaaah" + surahList);
//                    System.out.println("---" + m[i - 1][j - w[i - 1]] + " " + v[i - 1] + " " + (j - w[i - 1]));
//                    } else {
//                        for (int surah : surahList) {
//                            if (surah(-1)) {
//                                
//                            }
//                        }
//                    } 
                }
            }
        }
        for (int i = 0; i < surahList.size(); i++) {
            System.out.println(surahList.get(i));
        }
        return m[n][W];
    }

    public static void main(String args[]) {
        int val[] = new int[]{162,  158, 165,102};
        int wt[] = new int[]{ 18, 19, 23,13};
        int W = 60;
        int n = val.length;
        System.out.println(knapsackDP(wt, val, n, W));

//        cek();
    }
}
