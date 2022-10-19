import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerChecker {

    public String [] customerInfo(String filePath, String idOrName) throws IOException {
        DataList dataGetter = new DataList();
        ArrayList<String> dataList = dataGetter.get(filePath);
        LocalDate today = LocalDate.now();
        LocalDate aYearAgo = today.minusYears(1);
        String visitorStatus = "";
        String [] informationArray = new String[2];
        String customerLog = "";
        idOrName = idOrName.trim();
        for (int i = 0; i < dataList.size(); i++) {
            if(!dataList.get(i).contains("-"))
                if (dataList.get(i).split(", ")[0].equals(idOrName)
                        ||dataList.get(i).split(", ")[1].equalsIgnoreCase(idOrName)){
                    LocalDate memberDate = LocalDate.parse(dataList.get(i+1));
                    if(memberDate.isBefore(aYearAgo)||memberDate.equals(aYearAgo)){
                        visitorStatus = "Personen är en före detta medlem.";
                        break;
                    }
                    else{
                        visitorStatus = "Personen är en nuvarande medlem.";
                        customerLog+=dataList.get(i)+"\n"+today+"\n";
                        break;
                    }
                }
                else
                    if(!idOrName.equalsIgnoreCase("x"))
                    visitorStatus = "Personen har aldrig varit medlem.";
        }

        informationArray[0] = visitorStatus;
        informationArray[1] = customerLog;
        return informationArray;

    }

    public CustomerChecker() throws IOException {
    }
}