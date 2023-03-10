import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static randomUtils.RandomUtils.getRandomEmail;
import static randomUtils.RandomUtils.getRandomString;

public class TestDemoQADiWithFakerPageObject extends TestBase {


    @Test
    void fillTest() {

         Faker faker =  new Faker();

        String userName = faker.name().firstName(),
                lastNme = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                currentAddress = faker.address().fullAddress(),
                number = "8"+ faker.number().randomNumber(11, true);
          registrationPage.openPage()
                .executeJS()
                .setFirsName(userName)
                .setLastName(lastNme)
                .setEmail(userEmail)
                .setGender("Female")
                .setNumber(number)
                .setBirthDay("13", "March", "1993")
                .setSubject("Maths")
                .setCheckbox("Sports")
                .uploadFile("src/test/resources/pictures/temp.png")
                .setAddress(currentAddress)
                .setState("Uttar Pradesh")
                .setstateCity("Agra")
                .submitclick();
        registrationPage.verifiability();
        registrationPage.verifyValueTable("Student Name", userName + " " + lastNme);
        registrationPage.verifyValueTable("Student Email", userEmail);
        registrationPage.verifyValueTable("Gender", "Female");
        registrationPage.verifyValueTable("Mobile", number);
        registrationPage.verifyValueTable("Date of Birth", "13 March,1993");
        registrationPage.verifyValueTable("Subjects", "Maths");
        registrationPage.verifyValueTable("Hobbies", "Sports");
        registrationPage.verifyValueTable("Picture", "temp.png");
        registrationPage.verifyValueTable("Address", currentAddress);
        registrationPage.verifyValueTable("State and City", "Uttar Pradesh Agra");
        registrationPage.closeModal();
    }
}
