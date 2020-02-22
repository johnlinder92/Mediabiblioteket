import collections.ArrayList;
import collections.List;
import com.github.javafaker.Faker;

import java.io.*;

public class CreateTestData {
    private Faker faker;

    public CreateTestData() {
        this.faker = new Faker();
    }

    private void createData(int n) throws IOException {

        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("test.txt"));
        for (int i = 0; i < n; i++) {
            outputWriter.write(faker.gameOfThrones().character());
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }

    public static void main(String[] args) throws IOException {
        CreateTestData createTestData = new CreateTestData();
        createTestData.createData(100);
    }
}
