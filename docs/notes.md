# Notes

[TOC]

## PostgreSQL

### General commands

```bash
# Access psql shell
sudo –i –u postgres psql				# Switch to user postgres

# Print connection info (default port: 5432)
\conninfo

# Clear shell screen
 \! clear  |  CTRL+L
```

### User commands

```bash
# Create a new user
createuser --interactive --password [USER_NAME]		### SHELL ###

# Lists the existing permissions assigned to the users
\du												 	### PSQL ###
```

### DB commands

```bash
# Create | Delete DB
createdb [NAME] | dropdb [NAME]						### SHELL ###

# Create DB owned by another user
createdb testdb -O [USER_NAME]						### SHELL ###

# List DBs
\l										# Prints basic info
\l+										# Additional info
SELECT datname FROM pg_database;		# Prints only db names

# Access DB
\c [DB_NAME] |  \connect [DB_NAME]					### PSQL ###

# Access DB switching user
psql -U [USER_NAME] -d [DB_NAME] -W					### SHELL ###

# List all the tables
\dt  |  \dtables
SELECT * FROM pg_catalog.pg_tables WHERE schemaname != 'information_schema' AND schemaname != 'pg_catalog';
```

## MongoDB

### Notes

- **MongoShell**
  - Interactive Javascript console to interact with MongoDB.
- **Collections**
  - Mongo stores documents (*rows*) in collections (*tables*)
  - Documents are similar to JSON Objects
- **Documents**
  - MongoDB stores data records as BSON documents (Binary JSON)

### General commands

```bash
# Access the container from docker
docker exec -it [CONTAINER_ID]
# Access mongo shell
mongo mongodb://localhost:27017 -u [USER] -p [PASSW]
# Commands help
db.help()
```

### User commands

```bash

```

### DB commands

```bash
# List DBs
show dbs
# Create/switch DB
use [DB_NAME]
# Get current DB name
db.getName()
# Drop current DB
db.dropDatabase()
```

### Manage data

#### Collections

```bash
# Create a new collection
db.createCollection("NAME")
# List all collections
show collections
# Print collection stats
db.[COLL_NAME].stats()
# Drop collection
db.[COLL_NAME].drop()

# Insert document in a collection
db.[COLL_NAME].insert([DOC_NAME])		# DOC_NAME = JsonObject
db.[COLL_NAME].insertMany([DOCS_NAME])	# DOCS_NAME = JsonArray
# Get number of document in a collection
db.[COLL_NAME].count()
```

#### Query documents

```bash
# Find all the documents in a collection
db.[COLL_NAME].find()
db.[COLL_NAME].find().pretty()			# Prettify

# Search parameters
db.[COLL_NAME].find({ [KEY] : [VALUE] })
	Ex: db.student.find({firstName: "Leo"})

# Return only certains fields
# 1 = include field, 0 = exclude field
db.[COLL_NAME].find({},{[FIELD] : 1})
	Ex: db.student.find({}, {firstName: 1}).pretty()
```

#### Update documents

```bash
# Update a document
db.[COLL_NAME].update({[PARAMETERS]}, {$set: {[FIELD]: [VALUE]} })
	Ex: db.student.update({_id: ...}, {$set: {firstName: "Mike"}})
# Update many documents
db.[COLL_NAME].updateMany({[PARAMETERS]}, {$set: {v1}, {v2} })

# Remove a field from a document
db.[COLL_NAME].update({[PARAMETERS]}, {$unset: {[FIELD]: 1} })

# Increase numerical fields
db.[COLL_NAME].update({[PARAMETERS]}, {$inc: {[FIELD]: [QT]} })

# Remove a value from a field
db.[COLL_NAME].update({[PARAMETERS]}, {$pull: {[FIELD]: 1} })

# Add a value in a field
db.[COLL_NAME].update({[PARAMETERS]}, {$push: {[FIELD]: [VALUE]} })
```

#### Remove documents

```bash
# Remove a single document
db.[COLL_NAME].deleteOne({[FILTER_PARAM]})
	Ex: db.student.deleteOne({_id: ...})
# Remove many documents
db.[COLL_NAME].deleteMany({[FILTER_PARAM]})
	Ex: db.student.deleteMany({gender: 'F'})
# Remove all the documents in a collection
db.[COLL_NAME].deleteMany({})
```

## Angular

### RxJs and Observable

#### Stream, Observable and RxJs

- **Stream**: sequence of values in time (numeric values, sequence of mouse click events over time).
- **Observable**: API used to define a stream, subscribe to it and trasform it.
- **RxJs** (Reactive Extensions for Javascript): implementation of Observables for Javascript.

### Operators and pipe syntax

```typescript
// Observable that emits a value every second for 5 times
const obs = interval(1000).pipe(take(5))
```

- **Operator**: function that takes an Observable and returns another Observable.

  *Ex:* 

  - `interval(1000)` is an Observable that emits values every second forever.
  - `takes(5)` is an operator that transforms the Observable in input in another that emits values for 5 seconds and then stops.
  - `pipe()` or `| ` is similar to Unix pipe, it is used to concatenate multiple operators together.

### Hot and cold observable

If an Observable has no subscribers, it will not be triggered. The observable is said to be *cold* because it does not generate new values if no subscriptions exist.

### Shared Observable

```typescript
const obs = interval(1000).pipe(take(5),
               tap(i => console.log("obs value "+ i) ));

// Create 2 subscriptions to the previous Observable
obs.subscribe(value => console.log("observer 1 received " + value));

obs.subscribe(value => console.log("observer 2 received " + value));
```

> The `tap` operator doesn't modify the original Observable (it is used mainly to debug the Observable, for example by printing its value).

Output:

```
obs value 0
observer 1 received 0
obs value 0
observer 2 received 0

obs value 1
observer 1 received 1
obs value 1
observer 2 received 1
```

The output of the tap operator (the side-effect) is being called twice, that's the proof that *Observable are not shared by default*:

- The `obs` variable is just a blueprint of how the chain of operators should be set up.
- When we create a subscriber, a new separate processing chain is being set and the side-effect is printed once for each chain.





