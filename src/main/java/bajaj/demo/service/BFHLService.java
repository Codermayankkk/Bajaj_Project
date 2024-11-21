package bajaj.demo.service;

import bajaj.demo.model.RequestModel;
import bajaj.demo.response.ResponseModel;
import bajaj.demo.fileUtils.FileUtils;
import bajaj.demo.fileUtils.DataUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BFHLService {

    public Object getOperationCode() {
        return new Object() {
            public final int operation_code = 1;
        };
    }

    public ResponseModel processRequest(RequestModel request) {
        ResponseModel response = new ResponseModel();

        // Set static fields
        response.setIsSuccess(true);
        response.setUserId("john_doe_17091999");
        response.setEmail("john@xyz.com");
        response.setRollNumber("ABCD123");

        // Process data
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        String highestLowercase = null;

        for (String item : request.getData()) {
            if (item.matches("\\d+")) {
                // Add to numbers if it's a digit
                numbers.add(item);
            } else if (item.matches("[a-zA-Z]")) {
                // Add to alphabets if it's a letter
                alphabets.add(item);

               
                if (item.matches("[a-z]")) {
                    if (highestLowercase == null || item.compareTo(highestLowercase) > 0) {
                        highestLowercase = item;
                    }
                }
            }
        }

        // Set the processed data in the rvesponse
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);
        response.setHighestLowercaseAlphabet(
            highestLowercase != null ? List.of(highestLowercase) : new ArrayList<>()
        );
        response.setIsPrimeFound(containsPrime(numbers));

        // File processing is assumed to be implemented elsewhere
        response.setFileValid(false); // Example placeholder
        response.setFileMimeType(null); // Example placeholder
        response.setFileSizeKb(0.0); // Example placeholder

        return response;
    }

private Object containsPrime(List<String> numbers) {
// TODO Auto-generated method stub
return null;
}
}