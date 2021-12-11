# User stories & Acceptance criteria

#### As a *viewer* I want to...

- visualize the entire book library so that I can choose something interesting for me
  1. **Given that** I want to visualize books which belong to a certain category, **when** I select the category **then** the system presents a list of all books that match the criteria spread over several pages.
- search for a specific book that I am interested in
  1. **Given that** I enter at least one of the book's info (title, author, ISBN), **when** I click the *Search button* or I press enter **then** the system displays the results of my query.
- filter the query results so that I can find the book I am looking for more easily
  1. **Given that** I choose at least one of the available filters (price range, city of the seller, book condition, seller rating), **when** I change one of the filter **then** the system changes the results dynamically according to my preferences.
- sort the query results so that I can find at the top of the list the books I am looking for
  1. **Given that** I choose a sorting order, **when** I change the type of sorting **then** the system updates the views according to my selections.
- visualize additional info about a specific book
  1. **Given that** I choose a book from the library, **when** I click on its title or its cover image **then** the system displays a page with detailed info about the book.
- visualize additional info about the seller of a book
  1. **Given that** I am in the brief or detailed view of a book, **when** I click on the seller nickname **then** the system displays a page with additional info about the seller including location (city) and rating (users' reviews).
- create a personal account so that I can chat with sellers in order to buy a book
  1. **Given that** I am a new user of the platform, **when** I click the *Signup button* and I insert my data **then** the system creates a new user account and it will authenticate me.
  2. **Given that** I am a new user of the platform, **when** I click the *Signup button* and I insert my data incorrectly (ex: missing field) **then** the system notifies me that some fields are incorrect or missing and it allows me to fix the them.
  3. **Given that** I am already registered on the platform, **when** I click the *Signup button* and I insert my data **then** the system notifies me that the account already exists and it offers me the possibility to recover the password through my email.

#### As a *buyer* I want to...

- have a Login Validation functionality so that I can access my personal info safely
  1. **Given that** I am a valid user, **when** I enter username and password and click the *Login button* **then** the system redirects the user to the home page.
  2. **Given that** I am an invalid user **when** I enter username and password and click the *Login button* **then** the system throws an *invalid user* error message.
  3. **Given that** I am already logged in, **when** I access the web platform **then** the system should not ask me to reinsert my credentials.
- logout from the current session so that no one else can access my account
  1. **Given that** I am logged into my account, **when** I click the *Logout button* **then** the system disconnects my current session and redirects me back to the home page.
  2. **Given that** I am not logged into my account, **when** I search for the *Logout button* **then** the system hides it from me.
- contact a seller so that I can get more info about the book and eventually buy it
  1. **Given that** I am logged in, **when** I click the *Contact button* in order to talk to a seller **then** the system opens the chat panel and starts a chat with the specified seller.
  2. **Given that** I am not logged in, **when** I click the contact button in order to talk to a seller **then** the system redirects me to the *Login / Register* page.
- visualize the chat panel so that I can scroll and read the chat history with all the sellers that I have contacted
  1. **Given that** I am logged in and I have never contacted a seller, **when** I click the *Chat button* **then** the system opens the chat panel with the empty template.
  2. **Given that** I am logged in and I have contacted at least one seller, **when** I click the *Chat button* **then** the system opens the chat panel and shows me the chat history.
  3. **Given that** I am not logged in, **when** I search for the *Chat button* **then** the system hides it from the view.
- visualize the list of previous books purchased
  1. **Given that** I am logged in and I have bought at least one book, **when** I click the *Purchase history button* **then** the system shows a page containing all the books previously bought.
  2. **Given that** I am logged in and I have never bought a book, **when** I click the *Purchase history button* **then** the system shows a page with an empty purchase list.
- visualize a list of suggested books so that I can choose one among them
  1. **Given that** I am logged in and I have provided one or more fields of interest during the registration process, **when** I visit the website home page **then** the system shows me the *Suggested books panel* based on my interests.
- leave a rating to the seller so that I can share my purchase experience with other users
  1. **Given that** I bought a book from a seller, **when** I open the chat panel and click on the seller's chat **then** the system allows me to leave rating from 1 star up to 5.

#### As a *seller* I want to...

- receive a notification every time a buyer contact me so that I can quickly reply to him
  1. **Give that** I receive a new message from a buyer, **when** I enter the website homepage **then** the system shows me a notification counter of the unread messages.
  2. **Given that** I am not using the web platform, **when** a new buyer contact me through the chat **then** the system sends me an email notification telling me that a new buyer wants to contact me.
  3. **Given that** I am not using the web platform, **when** a buyer reply to an already started conversation in the chat **then** the system sends me an email notification telling me that the buyer replied to the last message.
- post a new advertisement so that buyers can see it and contact me
  1. **Given that** I am logged in, **when** I click the *New Advertisement button* **then** the system redirects me to the sale page where I can insert all the book's info.
  2. **Given that** I have clicked the *New Advertisement button* and I have inserted all the required info, **when** I press the *Post advertisement button* **then** the system:
     - creates the advertisement and displays it in the web platform
     - redirects me to the *My sales* page
     - notifies me in case of either success or error during the request handling
  3.  **Given that** I have clicked the *New Advertisement button* and I have not inserted all the required info, **when** I press the *Post advertisement button* **then** the system notifies me of some missing fields to complete.
- visualize the list of previous books sold
  1. **Given that** I am logged in and I have sold at least one book, **when** I click the *Sales history button* **then** the system shows a page containing all the books previously sold by me.
  2. **Given that** I am logged in and I have never sold a book, **when** I click the *Sales history button* **then** the system shows a page with an empty sales list.

#### As an *admin* I want to...

- have the control over users' account (create, modify, delete, update) so that I can resolve any issues related to them
  1. **Given that** I am logged in with a valid admin account, **when** I access the admin control panel **then** the system allows me to add a new user to the platform, delete an existing one, view and update an existing user's info.
- edit the book categories so that I can add new categories that are not present in the platform yet
  1. **Given that** I am logged in with a valid admin account, **when** I access the admin control panel **then** the system allows me to add new books categories and to update their info.
- visualize global stats regarding the system so that I can monitor the traffic on the website
  1. **Given that** I am logged in with a valid admin account, **when** I access the admin control panel **then** the system allows me to visualize a serie of global stats regarding web traffic (number of users), purchases and sales (number of books being sold/bought).