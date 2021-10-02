# Read4Share

[TOC]

## Versioning table

| Version | Date       | Author     | Changes                                                   |
| :------ | ---------- | ---------- | --------------------------------------------------------- |
| 1.0     | 15/09/2021 | F. Palazzi | Initial version                                           |
| 1.1     | 16/09/2021 | F. Palazzi | Added intro, user stories and acceptance criteria section |
| 1.2     | 17/09/2021 | F. Palazzi | Added UML Diagrams section, updated User Stories          |
| 1.3     | 29/09/2021 | F. Palazzi | Added additional User Stories                             |

## Intro

The goal of this project is to create an online platform that allows general users (especially students) to share new and second-hand books, either in free form or asking an amount of money.

This platform doesn't aim to handle an eventual payment for the books exchange, but it will permit sellers and buyers to keep in touch each other through an online chat system.

### Example of operation

- A user (the *seller*) wants to sell a book that he owns; the web app will allow him to create a new advertisement and to insert all the book's info (title, authors, ISBN, etc...).
-  Another user (the *buyer*) has seen a book advertisement and he would like to buy it; the web platform will allow him to contact the buyer and it will help him to make a purchase proposal for the book.

### Build instructions

1. Clone the repository with either [HTTPS](https://gitlab.com/IlPalazz/read4share.git) or [SSH](git@gitlab.com:IlPalazz/read4share.git)
2. Open the terminal and navigate to the project directory (or open it with an IDE)
3. Run the `./gradlew build` command to build the project

## Backlog

### Types of users

- `viewer` - unregistered / unlogged user
- `seller` - user who wants to sell / share a book
- `buyer` - user who wants to buy a book
- `admin` - administrator of the platform

### User stories & Acceptance criteria

[Click to view](resources/stories.md)

## UML Diagrams

### Use Case

<details>
    <summary>Click to expand</summary>
    <img src="./resources/Use_Case.png" style="zoom: 67%;" />
</details>

## Test plan

- Unit tests

## External resources

- [Jira Software](https://strykerstorm.atlassian.net/jira/software/projects/R4S/boards/2/roadmap?shared=&atlOrigin=eyJpIjoiYjQzM2IwMDIxZDFiNDdkYzg5N2ZmNjU4ZTdlZGJjNTciLCJwIjoiaiJ9) - issue tracking product
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) - Java IDE

## Credits

- Federico Palazzi (*author*)