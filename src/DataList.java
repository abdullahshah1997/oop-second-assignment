import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataList {
    public ArrayList<String> get(String filePath) throws IOException{
        BufferedReader instream = new BufferedReader((new FileReader(filePath)));
        ArrayList<String> dataList = new ArrayList<String>();
        while(true){
            String currentLine = instream.readLine();
            if(currentLine!=null) {
                dataList.add(currentLine);
            }//if
            else {
                break;
            }//else
        }//while
        dataList.remove(28);
        return dataList;
    }
}
