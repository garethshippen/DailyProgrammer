import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//r/dailyprogrammer Challenge #399

public class LetterSum
{
    public static void problemZero()
    {
        int total;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = input.nextLine().toLowerCase();
        total = addLetters(word);
        System.out.printf("lettersum(\"%s\") => %d\n", word, total);
    }
    public static int addLetters(String _input)
    {
        //a = 97
        //z = 122
        final int UNICODE_OFFSET = 96;
        int total = 0;
        char[] letters = _input.toCharArray();
        if(letters.length != 0)
        {
            for (char c : letters)
            {
                total += ((int) c) - UNICODE_OFFSET;
            }
        }
        return total;
    }
    public static File getFile(String _fileName)
    {
        Path filePath;
        File myFile = null;
        try
        {
            ClassLoader classLoader = LetterSum.class.getClassLoader();
            URL resource = classLoader.getResource(_fileName);
            filePath = Paths.get(resource.toURI());
            myFile = new File(filePath.toUri());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return myFile;
    }
    public static void problemOne(String _fileName)
    {
        File myFile = getFile(_fileName);
        BufferedReader bufferedReader;
        String line = null;
        try
        {
            bufferedReader = new BufferedReader(new FileReader(myFile));
            int total;
            boolean running = true;
            while(running && (line = bufferedReader.readLine()) != null)
            {
                total = addLetters(line);
                if (total == 319) running = false;
            }
            bufferedReader.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.printf("The word with a total of 319 is %s\n", line);
    }
    public static void problemTwo(String _fileName)
    {
        File myFile = getFile(_fileName);
        BufferedReader bufferedReader;
        int evenSums = 0;
        int oddSums = 0;
        int total;
        String line;
        int count = 0;
        try
        {
            bufferedReader = new BufferedReader(new FileReader(myFile));
            while((line = bufferedReader.readLine()) != null)
            {
                count++;
                total = addLetters(line);
                if(total % 2 == 0){evenSums++;} else {oddSums++;}
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.printf("There are %d words\n", count);
        System.out.printf("There are %d even words\n", evenSums);
        System.out.printf("There are %d odd words\n", oddSums);
        System.out.printf("%d + %d = %d\n", evenSums, oddSums, (evenSums+oddSums));
    }
    public static void problemThree(String _fileName)
    {
        File myFile = getFile(_fileName);
        BufferedReader bufferedReader;
        int[] totals = new int[320];
        String line;
        int highest = 0;
        int highestIndex = 0;
        int total;
        int count = 0;
        try
        {
            bufferedReader = new BufferedReader(new FileReader(myFile));
            while((line = bufferedReader.readLine()) != null)
            {
                total = addLetters(line);
                totals[total]++;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        for(int i = 1; i < 320; i++)
        {
            if(totals[i] > highest)
            {
                highest = totals[i];
                highestIndex = i;
            }
        }
        System.out.printf("The most totals was %d occuring %d times\n", totals[highestIndex], highestIndex);
    }
}
