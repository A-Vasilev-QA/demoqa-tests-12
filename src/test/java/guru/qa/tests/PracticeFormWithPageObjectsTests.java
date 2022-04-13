package guru.qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;
import static guru.qa.pages.AutomationPracticeFormPage.*;
import static guru.qa.pages.AutomationPracticeFormPage.checkResultsValue;
import static guru.qa.tests.TestData.*;

public class PracticeFormWithPageObjectsTests extends BaseTest {

    @Test
    public void fillFormTest() {
        generateTestData();
        openPage();
        typeFirstName(TestData.firstName);
        typeLastName(lastName);
        typeUserEmail(userEmail);
        String genderValue = selectGender(genderNumber);
        typeUserNumber(userNumber);
        String fullDate = selectDate(birthDate);
        String subjectName = inputSubject(subjectLetter);
        String hobbies = selectHobbies(isHobby);
        uploadPicture(fileName);
        typeCurrentAddress(currentAddress);
        String StateAndCity = selectStateAndCity(stateNumber, cityNumber);
        clickSubmit();

        checkResultsValue("Student Name", firstName + " " + lastName);
        checkResultsValue("Student Email", userEmail);
        checkResultsValue("Gender", genderValue);
        checkResultsValue("Mobile", userNumber);
        checkResultsValue("Date of Birth", fullDate);
        checkResultsValue("Subjects", subjectName);
        checkResultsValue("Hobbies", hobbies);
        checkResultsValue("Picture", fileName);
        checkResultsValue("Address", currentAddress);
        checkResultsValue("State and City", StateAndCity);
    }
}
