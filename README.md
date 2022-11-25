# Foodbar Recipe

## Recipe Organizer

Foodbar is an easy to use, all-in-one recipe organizer that lets create and share your recipes. Also discover hundreds
of other recipe from your fellow users and follow them.

#### Software requirements

- JDK 11
- MonogDB version 6

#### Installing MongoDB on MacOS

```shell
xcode-select --install
brew tap mongodb/brew
brew update
brew install mongodb-community@6.0
```

Instructions for [Linux](https://www.mongodb.com/docs/manual/administration/install-on-linux/)
and [Windows](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-windows/).

``` shell
$ java -version
openjdk version "11.0.16.1" 2022-08-12 LTS
```

#### Starting MongoDB

```shell
brew services start mongodb-community@6.0
```

#### Stopping MongoDB

```shell
brew services stop mongodb-community@6.0
```

#### Start MongoDB Shell

```shell
mongosh
```

#### Create database named recipe

```shell
use recipe
```

#### Running app

```shell
git clone https://github.com/CSC207-2022F-UofT/course-project-group-92.git
cd course-project-group-92
./gradlew run
```