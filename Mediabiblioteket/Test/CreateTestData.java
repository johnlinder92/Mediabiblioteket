import collections.ArrayList;
import collections.List;
import com.github.javafaker.Faker;

import java.io.*;

public class CreateTestData {
    private Faker faker;

    public CreateTestData() {
        this.faker = new Faker();
    }

    private void createDataLantagare(int n) throws IOException {

        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("Lantagare.txt"));
        for (int i = 0; i < n; i++) {
            outputWriter.write(faker.idNumber().validSvSeSsn()+";"+faker.name().fullName()+";"+faker.phoneNumber().cellPhone());
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }

    public static void main(String[] args) throws IOException {
        CreateTestData createTestData = new CreateTestData();
        createTestData.createDataLantagare(100);
    }
}
