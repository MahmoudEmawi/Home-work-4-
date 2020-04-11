/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jit
 */
public class Q_2{

    interface CountInterface {

        void countOccurences(String fileName);
    }

    public static void main(String args[]) {
        CountInterface count = (String fileName) -> {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            BufferedReader bufferedReaders;
            try {
                bufferedReaders = new BufferedReader(new FileReader(fileName));
                String string = bufferedReaders.readLine();
                while (string != null) { 
                    char[] charArray = string.toCharArray();
                    for (char x : charArray) {
                        if (x != ' ') {
                            if (map.containsKey(x)) {
                                map.put(x, map.get(x) + 1); 
                            } else {
                                map.put(x, 1); 
                            }
                        }
                    }
                    string = bufferedReaders.readLine();
                }
                bufferedReaders.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (Map.Entry element : map.entrySet()) { 
                System.out.println(element.getKey() + " " + element.getValue());
            }

        };
        count.countOccurences("count.txt"); 
    }
}
