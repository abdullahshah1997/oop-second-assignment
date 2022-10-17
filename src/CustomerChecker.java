import java.io.IOException;
import java.util.ArrayList;

public class CustomerChecker {
    DataList dataGetter = new DataList();
    ArrayList<String> dataList = dataGetter.get("src/customers.txt");
    for(int i = 0;i<dataList.size();i++){


    }

    public CustomerChecker() throws IOException {
    }

    public static void main(String[]args) throws IOException {
        DataList dataGetter = new DataList();
        ArrayList<String> dataList = dataGetter.get("src/customers.txt");
        System.out.println(dataList.size());

    }
}
