# Bhavanvir Rai
#### SENG 275 Assignment 2c

**Q1)**

a)
![image](https://user-images.githubusercontent.com/20825496/172967033-b076ed8e-5d3b-4d9c-bc9b-c7ed37e02895.png)

b)
![image](https://user-images.githubusercontent.com/20825496/174452257-667f449e-984e-4459-955d-96bc6f2267aa.png)

| Node | Action | 
| - | - |
| 1 | User enters a parking space ID |
| 2 | User selects a method of payment | 
| 3 | User selects a method of payment that is invalid the first time and thus is given a chance to select a new method of payment | 
| 4 | User selects a valid method of payment | 
| 5 | User saves the payment information | 
| 6 | User doesn't save the payment information | 
| 7 | User completes the payment and receives a payment receipt to their email | 

c)

Assuming `Mastercard` is a valid method of payment, and `Visa` is an invalid method of payment:
| Path | 1-2-4-5-7 | 1-2-4-6-7 | 1-2-3-2-4-5-7 | 1-2-3-2-4-6-7 |
| - | - | - | - | - |
| Initial Conditions | Parking space ID is valid, <br> `Mastercard` is a valid payment method | Parking space ID is valid, <br> `Mastercard` is a valid payment method | Parking space ID is valid, <br> `Mastercard` is a valid payment method | Parking space ID is valid, <br> `Mastercard` is a valid payment method |
| Test Steps | 1. User enters a parking space ID <br> 2. User selects `Mastercard` as a method of payment <br> 3. User saves the payment information <br> 4. User completes the payment | 1. User enters a parking space ID <br> 2. User selects `Mastercard` as a method of payment <br> 3. User doesn't save the payment information <br> 4. User completes the payment | 1. User enters a parking space ID <br> 2. User selects `Visa` as a method of payment <br> 3. User selects `Mastercard` as a method of payment <br> 4. User saves the payment information <br> 5. User completes the payment |  1. User enters a parking space ID <br> 2. User selects `Visa` as a method of payment <br> 3. User selects `Mastercard` as a method of payment <br> 4. User doesn't save the payment information <br> 5. User completes the payment |
| Expected Results | User receives a payment receipt to their email | User receives a payment receipt to their email | User receives a payment receipt to their email | User receives a payment receipt to their email
