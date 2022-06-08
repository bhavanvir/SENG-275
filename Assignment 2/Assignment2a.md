# Bhavanvir Rai
#### SENG 275 Assignment 2a

**Q1)**

**1. C: Conformance**

| Test Case ID | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail | 
| - | - | - | - | - | - | - |
| TC01 | Input an `Email_ID` that only contains `@` and `domain` | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter an `Email_ID` that only contains `@` and `domain` | Email_ID: @uvic.ca | Prompt the user that the `id` portion of their `Email_ID` is missing | As expected | Pass |
| TC02 | Input an `Email_ID` that only contains `id` and `domain` |1. Go to site www.uvic.ca/registration_page <br> 2. Enter an `Email_ID` that only contains `id` and `domain` | Email_ID: braiuvic.ca | Prompt the user that the `@` portion of their `Email_ID` is missing | As expected | Pass |
| TC03 | Input an `Email_ID` that only contains `id` and `@` | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter an `Email_ID` that only contains `id` and `@` | Email_ID: brai@ | Prompt the user that the `domain` portion of their `Email_ID` is missing | As expected | Pass |
| TC04 | Input an `Email_ID` that only contains the `domain` | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter an `Email_ID` that only contains the `domain` | Email_ID: uvic.ca | Prompt the user that the `id` and `@` portion of their `Email_ID` is missing | As expected | Pass |
| TC05 | Input an `Email_ID` that only contains the `@` | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter an `Email_ID` that only contains the `@` | Email_ID: uvic.ca | Prompt the user that the `id` and `domain` portion of their `Email_ID` is missing | As expected | Pass |
| TC06 | Input an `Email_ID` that only contains the `id` | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter an `Email_ID` that only contains the `id` | Email_ID: uvic.ca | Prompt the user that the `@` and `domain` portion of their `Email_ID` is missing | As expected | Pass |

**2. O: Order**

| Test Case ID | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail | 
| - | - | - | - | - | - | - |
| TC01 | Enrolling in a `SENG` course without selecting some `ECE` prerequisites | 1. Go to site www.uvic.ca/registration_page <br> 2. Select a single `SENG` course <br> 3. Select a single `ECE` prerequisite | Courses: SENG 275, ECE 458 | Display a message saying all prerequisite for the course must be selected first | As expected | Pass |
| TC02 | Enrolling in a `SENG` course then selecting all `ECE` prerequisites | 1. Go to site www.uvic.ca/registration_page <br> 2. Select a single `SENG` course <br> 3. Select all `ECE` courses | Courses: SENG 321, ECE 260 | Display a message saying all prequisites for the course must be selected first | As expected | Pass |
| TC03 | Enroll in a `SENG` course then select an `ECE` prequisite | 1. Go to site www.uvic.ca/registration_page <br> 2. Select a single `SENG` course <br> 3. Select a single `ECE` prerequisite | Courses: SENG 265, ECE 255 | Display a message saying that the prerequisite must be selected first | As expected | Pass|
| TC04 | Enroll in only a `SENG` course | 1. Go to site www.uvic.ca/registration_page <br> 2. Select a single `SENG` course | Course: SENG 350 | Display a message saying all prequisites for the course must be selected first | As expected | Pass |
| TC05 | Enroll in only an `ECE` course | 1. Go to site www.uvic.ca/registration_page <br> 2. Select a single `ECE` course | Course: ECE 310 | Don't display a message to the user | As expected | Pass |

**3. R: Range**

Assuming only whole numbers are enterable:

| Test Case ID | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail | 
| - | - | - | - | - | - | - |
| TC01 | Enter an `Age` of less than `15` | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter an `Age` of less than `15` in the `Age` input box | Age: 14 | Prompt the user that their age is invalid | As expected | Pass |
| TC02 | Enter an `Age` of `15` | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter an `Age` of `15` in the `Age` input box | Age: 15 | Don't prompt the user anything | As expected | Pass |
| TC03 | Enter an `Age` of greater than `70` | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter an `Age` of greater than `70` in the `Age` input box | Age: 71 | Prompt the user that their age is invalid | As expected | Pass |
| TC04 | Enter an `Age` of `70` | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter an `Age` of `70` in the `Age` input box | Age: 70 | Don't prompt the user anything | As expected | Pass |
| TC05 | Enter an `Age` of `0` | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter an `Age` of `0` in the `Age` input box | Age: 0 | Prompt the user that their age is invalid | As expected | Pass |

**4. R: Reference**

Assuming a user can only have a single active session:

| Test Case ID | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail | 
| - | - | - | - | - | - | - |
| TC01 | Entering a `Uname` and `Pword` that is not recognized by the database| 1. Go to site www.uvic.ca/login <br> 2. Enter invalid `Uname` and `Pword` | Uname: brai <br> Pword: IncorrectPword456| Prompt the user that either their `Uname` or `Pword` credentials are in | As expected | Pass |
| TC02 | Entering a `Pword` and `Uname` that is recognized by the database | 1. Go to site www.uvic.ca/login <br> 2. Enter a valid `Uname` and `Pword`  | Uname: brai <br> Pword: ValidPword123| Don't prompt the user anything | As expected | Pass |

**5. E: Existence**

| Test Case ID | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail | 
| - | - | - | - | - | - | - |
| TC01 | Registering in a course that isn't offered in a specfic term | 1. Go to site www.uvic.ca/registration_page <br> 2. Select a course that isn't offered in a specific term | Course: ECE 360 | Prompt the user that the selected course isn't offered in the specificed term | As expected | Pass |
| TC02 | Registering in a  course with an empty name | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter a course with an empty name | Course: "" | Prompt the user that the entered course is invalid | As expected | Pass |
| TC02 | Registering in a  course with an invalid number | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter a course with an invalid name | Course: ECE 999 | Prompt the user that the entered course is invalid | As expected | Pass |

**6. C: Cardinality**

Assuming a student is able to take a maximum of 6 courses per term:

| Test Case ID | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail | 
| - | - | - | - | - | - | - |
| TC01 | Producing a message when there are `0` courses in the list | 1. Go to site www.uvic.ca/registration_page <br> 2. Select no courses | N/A | Prompt the user that at least one course has to be selected | As expected | Pass |
| TC02 | Producing a message when there's only `1` course with no prerequisites in the list | 1. Go to site www.uvic.ca/registration_page <br> 2. Select any course with no prerequisites | Course: SENG 265 | Don't prompt the user anything | As expected | Pass |
| TC03 | Producing a message when there aren't yet `6` courses in the list | 1. Go to site www.uvic.ca/registration_page <br> 2. Select any course | Courses: ECE 355 | Display the selected list of courses to the user | As expected | Pass |
| TC04 | Adding a course when there are `0` courses in the list | 1. Go to site www.uvic.ca/registration_page <br> 2. Select any course | Course: SENG 499 |  Course is added to the list | As expected | Pass |
| TC05 | Adding a course when there's only `1` course in the list | 1. Go to site www.uvic.ca/registration_page <br> 2. Select any course | Course: ECE 255 | Course is added to the list | As expected | Pass |
| TC06 | Adding a course when there aren't yet `6` courses in the list | 1. Go to site www.uvic.ca/registration_page <br> 2. Select any course | Course: SENG 426 | Course is added to the list | As expected | Pass |
| TC07 | Adding a course when there are already `6` courses in the list | 1. Go to site www.uvic.ca/registration_page <br> 2. Select any course | Course: SENG 499 | Prompt the user that more than 6 courses can't be taken together in a single term | As expected | Pass |

**7. T: Time**

Assuming a global clock is implemented, with `E` being the maximum time elapseable without producing an error:

| Test Case ID | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail | 
| - | - | - | - | - | - | - |
| TC01 | Produce an error if the elapsed time reaches `E` when trying to access the database | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter a valid `Email_ID` | Email_ID: test@uvic.ca | Prompt the user that an error has occured when time E is reached trying to access the database | As expected | Pass |
| TC02 | Produce an error if the elapsed time querying the database for duplicity reaches `E` | 1. Go to site www.uvic.ca/registration_page <br> 2. Enter a valid `Email_ID` | Email_ID: test@uvic.ca | Prompt the user that an error has occured when time E is reached trying to query the database for duplicity | As expected | Pass |
| TC03 | Produce an error if the elapsed time reaches `E` when writing the `Email_ID` to the database |  1. Go to site www.uvic.ca/registration_page <br> 2. Enter a new valid `Email_ID` | Email_ID: newtest@uvic.ca | Prompt the user that an error has occured when time E is reached trying to write the `Email_ID` to the databse | As expected | Pass |
