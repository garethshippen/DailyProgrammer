import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//r/dailyprogrammer Challenge #399

public class LetterSum
{
    public static void fakeMain()
    {
        int total;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = input.nextLine().toLowerCase();
        total = addLetters(word);
        System.out.printf("lettersum(\"%s\") => %d\n", word, total);
    }
    private static int addLetters(String _input)
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

    public static void getFile()
    {
        FileSystem fs = FileSystems.getDefault();
        Path filePath = null;
        BufferedReader bufferedReader = null;
        try
        {
            ClassLoader classLoader = LetterSum.class.getClassLoader();
            URL resource = classLoader.getResource("dailyprogrammer399.txt");
            filePath = Paths.get(resource.toURI());
            File myFile = new File(filePath.toUri());
            bufferedReader = new BufferedReader(new FileReader(myFile));

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
