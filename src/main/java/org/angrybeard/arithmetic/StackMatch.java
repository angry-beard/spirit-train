package org.angrybeard.arithmetic;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by angry_beary on 2019/6/22.
 */
public class StackMatch {

    private final static Map<Character, Character> brackets = new HashMap();

    static {
        brackets.put(']', '[');
        brackets.put('}', '{');
        brackets.put(')', '(');
    }

    public static void main(String[] args) throws IOException {
        String targetStr = getFileContext("/Users/angry_beary/projects/myProjects/2019/spirit-train/src/main/java/org/angrybeard/arithmetic/BinarySearch.java");
        if (isMatch(targetStr)) {
            System.out.println("括号成对");
        } else {
            System.out.println("括号不成对");
        }

    }

    private static boolean isMatch(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (Character ch : str.toCharArray()) {
            if (brackets.containsValue(ch)) {
                stack.push(ch);
            } else if (brackets.containsKey(ch)) {
                if (stack.empty() || stack.pop() != brackets.get(ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static String getFileContext(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        //缓冲区使用完必须关掉
        reader.close();
        return fileData.toString();
    }
}
