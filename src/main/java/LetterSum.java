import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.Buffer;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
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
        FileSystem fs = FileSystems.getDefault();
        Path filePath = null;
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
    public static String problemOne(File _myFile)
    {
        BufferedReader bufferedReader = null;
        String line = null;
        try
        {
            bufferedReader = new BufferedReader(new FileReader(_myFile));
            int total = 0;
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
        return line;
    }
    public static void problemTwo(File _myFile)
    {
        BufferedReader bufferedReader;
        int evenSums = 0;
        int oddSums = 0;
        int total;
        String line;
        int count = 0;
        try
        {
            bufferedReader = new BufferedReader(new FileReader(_myFile));
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
    }
}
