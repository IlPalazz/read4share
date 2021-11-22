# Endpoints

## Advertisements

- Root path: `/api/adv`

| Method |   Path    |     Parameters     |                         Description                          |
| :----: | :-------: | :----------------: | :----------------------------------------------------------: |
|  GET   |  /latest  |      *N / A*       |             Most recently posted advertisements              |
|  GET   | /bestrate |      *N / A*       |           Advertisements with the best rated books           |
|  GET   |   /free   |      *N / A*       |                     Free advertisements                      |
|  GET   | /freedel  |      *N / A*       |             Advertisements with no delivery fees             |
|  GET   |  /asnew   |      *N / A*       |           Advertisements with books marked as new            |
|  GET   |   /cat    | id: Long, pag: Int | Advertisements with books that belong to a specific category |
|  GET   |   /all    |      *N / A*       |               List of all the books categories               |

## Users

- Root path: `/api/user`

| Method | Path | Parameters | Description |
| :----: | :--: | :--------: | :---------: |
|        |      |            |             |

## Categories

- Root path: `/api/cat`

| Method | Path | Parameters |           Description            |
| :----: | :--: | :--------: | :------------------------------: |
|  GET   | /all |  *N / A*   | List of all the books categories |

