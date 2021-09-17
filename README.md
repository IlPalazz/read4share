# Read4Share

[TOC]

## Intro

The goal of this project is to create an online platform that allows general users (especially students) to share new and second-hand books, either in free form or asking an amount of money.

This platform doesn't aim to handle an eventual payment for the books exchange, but it will permit sellers and buyers to keep in touch each other through an online chat system.

### Example of operation

- A user (the *seller*) wants to sell a book that he owns; the web app will allow him to create a new advertisement and to insert all the book's info (title, authors, ISBN, ecc...).
-  Another user (the *buyer*) has seen a book advertisement and he would like to buy it; the web platform will allow him to contact the buyer and it will help him to make a purchase proposal for the book.

## Backlog

### Types of users

- `viewer` - an unregistered/unlogged user
- `seller` - a user who wants to sell/share a book
- `buyer` - a user who wants to buy a book
- `admin` - administrator of the platform

### User stories & Acceptance criteria

#### As a *viewer* I want to...

- visualize the entire book library so that I can choose something interesting for me
  - *given that* the user has choosen a category of interest 
- search for a specific book that I am interested in
  - *given that* the user has entered some of the book's info (title, author, ISBN)
- create a personal account so that I can chat with sellers
  - *given that* the user is not already registered on the platform

#### As a *buyer* I want to...

- visualize the entire book library so that I can choose something interesting for me
- search for a specific book that I am interested in
  - *given that* the user has entered some of the book's info (title, author, ISBN)
- have a Login Validation functionality so that I can access my personal info safely
  1. **Given that** I am a valid user **when** I enter username and password and click the login button **then** the system redirects the user to the home page.
  2. **Given that** I am an invalid user **when** I enter username and password and click the login button **then** the system throws an "invalid user" error message.
  3. **Given that** I am already logged in **when** I access the web platform **then** the system should not ask me to reinsert my credentials.
- logout from the current session so that no one else can access my account
  - *given that* the user is logged in his account
- contact a seller so that I can get more info about the book
  - *given that* the user is already logged in
- submit a purchase proposal so that I can buy/obtain the book I was looking for
  - *given that* the user is already logged in
  - *given that* the user has contacted the seller
- visualize a list of suggested books so that I can choose one among them
  - *given that* the user has provided one or more fields of interest

#### As a *seller* I want to...

- login into my account so that I can access my personal info
  - *given that* the user is not already logged in
  - *given that* the user enters the right email and password
- logout from the current session so that no one else can access my account
  - *given that* the user is logged in his account
- post a new advertisement so that buyers can see it and contact me
  - *given that* the seller inserts all the required book's info, the price, current condition, ecc...
- accept a purchase proposal so that I can sell the book
  - *given that* a buyer has submitted a proposal
- decline a purchase proposal because I am not interested in
  - *given that* a buyer has submitted a proposal

#### As an *admin* I want to...

- 

## UML Diagrams

### Use Case

<img src="./resources/Use_Case.png" style="zoom: 67%;" />

## Test plan

- Unit tests

## External resources

- [Jira Software](https://strykerstorm.atlassian.net/jira/software/projects/R4S/boards/2/roadmap?shared=&atlOrigin=eyJpIjoiYjQzM2IwMDIxZDFiNDdkYzg5N2ZmNjU4ZTdlZGJjNTciLCJwIjoiaiJ9) - issue tracking product

## Credits

- Federico Palazzi (*author*)



