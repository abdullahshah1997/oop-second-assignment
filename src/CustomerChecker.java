import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerChecker {

    public void customerInfo(String filePath, String idOrName) throws IOException {
        DataList dataGetter = new DataList();
        ArrayList<String> dataList = dataGetter.get(filePath);
        LocalDate today = LocalDate.now();
        LocalDate aYearAgo = today.minusYears(1);
        String customerInfo = "";
        for (int i = 0; i < dataList.size(); i++) {
            if(!dataList.get(i).contains("-"))
                if (dataList.get(i).split(", ")[0].equals(idOrName)
                        ||dataList.get(i).split(", ")[1].equals(idOrName)){
                    LocalDate memberDate = LocalDate.parse(dataList.get(i+1));
                    if(memberDate.isBefore(aYearAgo)||memberDate.equals(aYearAgo)){
                        customerInfo = "Personen är en före detta medlem.";
                    }
                    else{
                        customerInfo = "Personen är en nuvarande medlem.";
                    }
                }
                else
                    customerInfo = "Personen har aldrig varit medlem.";
        }

        System.out.print(customerInfo);

    }
    public CustomerChecker() throws IOException {
    }
}
