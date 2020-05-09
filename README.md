## payMent-app


## Technical Design Document

Project name: **EazyPay Wallet**

Prepared By: **Pratik D. Gadge (**  **46022637** )

**EazyPay** is created to meet the needs of online payment system. The different functional requirements in the project are as follows:

**Login** **:**

A user will be required to log in into the application with mobile number as username and wallet pin as password in order to perform wallet operations.

**Sign Up** **:**

If User has no account, they have to register by providing their name, their contact number, Adhar number, email id, wallet pin as a password, etc.

**Add Money**  **to wallet account** **:**

For making the payment the user need to add money in the wallet. The money can be added by using add balance service where user has to provide wallet pin in order to add amount.

**Add Money**  **to bank account** **:**

For making the payment the user need to add money in the bank account. The money can be added by using deposit service where user have to provide wallet pin in order to add amount.

**Money Transfer:**

A user can transfer money to another user of the wallet. The money can be transferred if available in the wallet. You can transfer money less than or equal to available balance. You need to provide mobile number of receiver to whom money will be transferred. You need to provide password while transferring money to ensure that, you are right person/account holder.

**Check Balance:**

A user can be able to check available balance in the wallet after logging in.

**Transactions**  **details** **:**

The recent transactions of a particular user can be seen by the user. Transactions contain the deposit, withdraw and transfer records of the particular user. It should also show the date and time when occurred along with the purpose of money transfer as a caption.

**Wallet Services:**

- **Registration:** Register a new user for wallet.
- **Login:** Login as a customer in wallet.
- **Deposit Money:** Add money in the wallet.
- **Withdraw Money:** Withdraw money from the wallet.
- **Transfer Money:** Transfer money from wallet to the other customer of the wallet.
- **Check Balance:** Check available balance in the wallet.
- **Show Transactions:** See the recent transactions done from the wallet

**Architecture Diagram:**

- **Refer documentation folder for more details**

## **Wireframes**
:

**Register:**

![newUser](https://user-images.githubusercontent.com/59358401/81468250-ffa45500-91fb-11ea-83ab-572dfdbb398b.jpg)

**Login:**

![sign in-login](https://user-images.githubusercontent.com/59358401/81468261-0a5eea00-91fc-11ea-986a-be5db48ea567.jpg)

**DashBoard**

![dashboard](https://user-images.githubusercontent.com/59358401/81468246-f87d4700-91fb-11ea-90b0-dfd8c9cea2f2.jpg)

**Deposit:**

![bankdeposit](https://user-images.githubusercontent.com/59358401/81468240-f1563900-91fb-11ea-9733-30d73bb960f6.jpg)

**Withdraw / add balance to wallet:**

![addbalance](https://user-images.githubusercontent.com/59358401/81468214-cff54d00-91fb-11ea-929b-2374dd10e84d.jpg)

**Transfer:**

![fundTransfer](https://user-images.githubusercontent.com/59358401/81468206-c835a880-91fb-11ea-9aa7-977db70166d0.png)

**Show Transactions:**

![showTransaction](https://user-images.githubusercontent.com/59358401/81468172-8c9ade80-91fb-11ea-8151-5de408e530fe.jpg)

