# Foodbar Recipe

## Recipe Organizer

Foodbar is an easy to use, all-in-one recipe organizer that lets create and share your recipes. Also discover hundreds
of other recipe from your fellow users and follow them.

#### Software requirements

- JDK 19
- MonogDB version 6 (Optional, I have also included DB url for cloud instance or you can use the local)
- Andorid Studio Dolphin 2021.3.1
- Mongo Compass (Optional, but helps you visualize the data stored in DB)

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
#openjdk version "19.0.1" 2022-10-18
```

#### Starting MongoDB

```shell
brew services start mongodb-community@6.0
```

#### Stopping MongoDB

```shell
brew services stop mongodb-community@6.0
```

#### Create database named recipe

```shell
use FoodBar
```

#### Running app

```shell
git clone https://github.com/CSC207-2022F-UofT/course-project-group-92.git
cd course-project-group-92
./gradlew run
```
Or alternatively running the recipe.foodbar.app.rest.JavelinApplication starts the webserver.
Makesure MongoDB is running before.

#### Running Android App

Open Android Studio and open folder course-project-92/app
Run the app, use the the emulator as the app needs to connect to localhost for server