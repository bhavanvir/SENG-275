# Bhavanvir Rai
#### SENG 275 Assignment 2a

**Q1)**

**1. C: Conformance**
- T1: No `id`, just `@` and `domain`
- T2: No `@`, just `id` and `domain`
- T3: No `domain`, just `id` and `@`
- T4: Just `domain`
- T5: Just `@`
- T6: Just `id`

**2. O: Order**
- T1: Enroll in a `SENG` course without selecting some `ECE` prerequisites 
- T2: Enroll in a `SENG` course without selecting all `ECE` prerequisites
- T3: Enroll in a `SENG` course then select an `ECE` prerequisite
- T4: Enroll in just a `SENG` course
- T5: Enroll in just a `ECE` course

**3. R: Range**

Assuming only positive integers are enterable:
- T1: Age of `14`
- T2: Age of `15`
- T3: Age of `71`
- T4: Age of `70`
- T5: Age of `0`

**4. R: Reference**
- T1: Requires for the `Uname` to be valid
- T2: Requires for the `Pword` to be valid for the `login id` instance

**5. E: Existence**
- T1: Registering in a course that isn't offered in a term
- T2: Registering in a course with an empty name
- T3: Registering in a course with an invalid name

**6. C: Cardinality**

Assuming a student is able to take a maximum of 6 courses per term:
- T1: Producing a message when there are `0` courses in the list
- T2: Producing a message when there's only `1` course in the list
- T3: Producing a message when there aren't yet `6` courses in the list
- T4: Adding a course when there are `0` courses in the list
- T5: Adding a course when there's only `1` course in the list
- T6: Adding a course when there aren't yet `6` courses in the list
- T7: Adding a course when there are already `6` courses in the list

**7. T: Time**

Assuming a global clock is implemented, with `E` being the maximum time elapseable without producing an error:
- T1: Produce an error if the elapsed time reaches `E` when trying to access the database
- T2: Produce an error if the elapsed time querying the database for duplicity reaches `E`
- T3: Produce an error if the elapsed time reaches `E` when writing the `email id` to the database
