package com.bwieckowski.toolbox;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringReplace{

    private static String replace(String[] oldstring, String[] newstring, String input){
        if(oldstring.length == newstring.length)
            for (int i = 0; i < oldstring.length; i++)
                input = input.replace(oldstring[i], newstring[i]);
        return input;
    }

    public static String strReplace(String input1, String input2, String input3){
        String[] inputarr1 = input1.split("~");
        String[] inputarr2 = input2.split("~");
        return replace(inputarr1, inputarr2, input3);
    }

    public static String argReplace(String input1, String input2){
        if(input1.charAt(0) == '{')
            input1 = input1.substring(1);
        if(input1.charAt(input1.length() - 1) == '}')
            input1 = input1.substring(0, input1.length() - 1);

        String[] argsvalues = input1.split(", ");
        String[] args = new String[argsvalues.length];
        String[] values = new String[argsvalues.length];
        for(int i = 0; i < argsvalues.length; i++){
            String[] temp = argsvalues[i].split("=");
            args[i] = ":\"" + temp[0]+"\"";
            if(1 >= temp.length)
                values[i] = "";
            else
                values[i] = temp[1];
        }
        //System.out.println(Arrays.toString(args));\

        return replace(args, values, input2);
    }

}
