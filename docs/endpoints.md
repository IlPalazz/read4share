# Endpoints

## Advertisements

- Root path: `/api/adv`

| Method |   Path    |     Parameters      |                         Description                          |
| :----: | :-------: | :-----------------: | :----------------------------------------------------------: |
|  GET   |  /latest  |       *N / A*       |             Most recently posted advertisements              |
|  GET   | /bestrate |       *N / A*       |           Advertisements with the best rated books           |
|  GET   |   /free   |       *N / A*       |                     Free advertisements                      |
|  GET   | /freedel  |       *N / A*       |             Advertisements with no delivery fees             |
|  GET   |  /asnew   |       *N / A*       |           Advertisements with books marked as new            |
|  GET   |   /cat    | id: Long, page: int | Advertisements with books that belong to a specific category |

## Users

- Root path: `/api/auth`

| Method |      Path      |                    Parameters                     |                Description                |
| :----: | :------------: | :-----------------------------------------------: | :---------------------------------------: |
|  POST  |   /register    | username: string, email: string, password: string |            Register a new user            |
|  POST  |     /login     |        username: string, password: string         | Log in a registered user and return a JWT |
|  POST  | /registerAdmin | username: string, email: string, password: string |           Register a new admin            |
|  GET   |    /details    |                      *N / A*                      |          Return the user details          |

## Categories

- Root path: `/api/cat`

| Method | Path | Parameters |           Description            |
| :----: | :--: | :--------: | :------------------------------: |
|  GET   | /all |  *N / A*   | List of all the books categories |

