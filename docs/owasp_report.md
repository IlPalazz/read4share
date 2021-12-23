# OWASP Security report

## Vulnerability analysis

| Vulnerability                                     | Likelihood    | Impact   | Risk     | Actions possible                                             | Planned            |
| ------------------------------------------------- | ------------- | -------- | -------- | ------------------------------------------------------------ | ------------------ |
| A01 - Broken Access Control                       | Probable      | Severe   | High     | Appropriate configuration of Authentication/Authorization on both backend and frontend | Yes                |
| A02 - Cryptographic Failures                      | Unlikely      | Severe   | Moderate | Do not store/send sensible information in clear text         | Yes (partially)    |
| A03 - Injection                                   | High          | Moderate | Moderate | Validate and sanitize user-supplied data                     | Yes                |
| A04 - Insecure Design                             | Unlikely      | Moderate | Low      | Implementation of various types of tests                     | Yes                |
| A05 - Security Misconfiguration                   | Very unlikely | Moderate | Low      | Deny by default, install only what is necessary              | Yes                |
| A06 - Vulnerable and Outdated Components          | Very unlikely | Low      | Low      | N/A, components updated                                      | No                 |
| A07 - Indentification and Authentication Failures | High          | Severe   | High     | Prohibit the use of weak passwords, protection against brute force attacks | Yes (partially)    |
| A08 - Software and Data Integrity Failures        | Unlikely      | Moderate | Moderate | N/A                                                          | No, risks accepted |
| A09 - Security Logging and Monitoring Failures    | High          | Severe   | High     | Ensure that all input validation failures can be logged      | N/A                |
| A10 - Server Side Request Forgery (SSRF)          | High          | Moderate | Moderate | Segment remote resource access functionality in separate networks, enforce "deny by default" firewall policies | No, risks accepted |

## Risks and impact on my application

- **A01 - Broken Access Control**

  - *Risk*: This vulnerability may allow unauthenticated/unauthorized users to act outside of their intended permissions. Failures typically lead to unauthorized information disclosure, modification, or destruction of all data or performing a business function outside the user's limits.
  - *Impact*: It's unlikely that this vulnerability can affect my application since:
    - I configured Auth with Spring Security on the server side to allow access to high privileges API operation (either user or admin specific) by first validating the JWT signature.
    - I set the expiration date of the JWT to 1 hour in order to restrict a possible attack time window.
    - I configured Angular Route Guards to prevent users from navigating to parts of the application without authorization.

- **A02 - Cryptographic failures**

  - *Risk*: This vulnerability may allow malicious users to intercept other users' sensible information (such as passwords, credit card number, ecc...).

  - *Impact*: The chances of affecting my application are quite high because I haven't implemented a secure protocol for transmitting sensible info over HTTPS. 

    On the other hand, I store all the users' credentials inside the database using a strong hash algorithm (bcript).

- **A03 - Injection**

  - *Risk*: This vulnerability can be exploited by malicious users to retrieve sensible information by sending a special payload inside an input field (such as the login form).
  - *Impact*: The chances of affecting my application are very low since:
    - I use an ORM (Hibernate) to retrieve and send data to the DB, so it automatically prepares the SQL statement and sanitizes it.
    - I implemented some constraints over the user requests' fields using the javax constraint library.

- **A04 - Insecure Design**

  - *Risk*: This is a design vulnerability, which means that a user can take advantage of a broken logic in a certain part of an application to carry out unauthorized operations.
  - *Impact*: It is not easy to give an estimation of the impact of this vulnerability since it concerns the design of the application's structure, but I have implemented a quite good number of tests in order to avoid any sort of broken logic.

- **A05 - Security Misconfiguration**

  - *Risk*: Malicious users can gain access to the internal application system exploiting some security failures due to a misconfiguration of ports, network services, user accounts.
  - *Impact*: It is very unlikely that my application can be hit by this vulnerability since:
    - I have enabled CORS only for the Angular specific port.
    - I could deploy the app on the cloud in order to not be worried by the security misconfiguration of the backend environment.

- **A06 - Vulnerable and Outdated Components**

  - *Risk*: Attackers may take advantage of known vulnerabilities found in outdated softwares/libraries and exploit them to gain access to the system/steal personal info. 
  - *Impact*: I have built the application with (almost) the latest version of the frameworks and libraries that I used, so it is very unlikely that someone can exploit this vulnerability.

- **A07 - Identification and Authentication Failures**

  - *Risk*: Malicious users may use automated tools to make many attempts of brute forcing user credentials and gain access to the system.
  - *Impact*: My application might be vulnerable to this because on the frontend I have implemented a length check on the user's password when creating a new account but I have not introduced any backend functions to prevent brute force attacks.

- **A08 - Software and Data Integrity Failures**

  - *Risk*: Attackers can exploit failures relate to code and infrastructure that does not protect against integrity violations.
  - *Impact*: It is unlikely that someone uses this vulnerability to access my application given that almost all the libraries that I used are included in the Angular/Spring framework.

- **A09 - Security Logging and Monitoring Failures**

  - *Risk*: If a breach in the application system occurs, without sufficient logging and monitoring could be very difficult to find out what has happened.
  - *Impact*: Currently the app does not have implemented a logging/monitoring system to detect failed logins and other auditable events, so if a breach occurs the impact may be high.

- **A10 - Server Side Request Forgery (SSRF)**

  - *Risk*: This vulnerability occurs whenever a web application is fetching a remote resource without validating the user-supplied URL. It allows an attacker to coerce the application to send a crafted request to an unexpected destination, even when protected by a firewall, VPN, or another type of network access control list (ACL).
  - *Impact*: The chances of affecting my application are moderate given that I sanitize and validate all client-supplied input data and the app does not send raw responses to clients. In order to prevent this vulnerability, it is necessary to secure also the network layer of the system (such as segment remote resource access functionality in separate networks).

## Conclusion

After writing this report I can conclude that my app is not secure enough yet and it would need some improvements. Some of the most important are:

- Invalidate the JWT on the server side after a user logout from the system (for example by implementing a "JWT black list").

- Encrypt all data in transit between frontend and backend with secure protocols (such as TLS) and do not use legacy protocols like FTP and SMTP for transporting sensitive data.
- Implement specific controllers integration tests in order to avoid logic/security failures.