# Virtual Pet API

Now we will take Virtual pet to its logical conclusion! A fully functional MVC application! Your team will choose one of
your virtual pet applications and transform it into a backend application with a functional front end! This will test
everything you’ve learned up until this point, and will also be your first group project.

## Creating a new database for the Project

* `mysql -u root -e "drop database rangers"`
* `mysql -u root -e "create database rangers"`

# Curl Commands

## Shelter Commands

* GET ALL SHELTERS:
    * `curl -X GET http://localhost:8080/api/shelters -H 'Content-Type: application/json'`
* GET A SHELTER:
    * `curl -X GET http://localhost:8080/api/shelters/1 -H 'Content-Type: application/json'`
* POST A SHELTER:
    * `curl -X POST http://localhost:8080/api/shelters -H 'Content-Type: application/json' -d '{"name": "test"}'`
* PUT A SHELTER:
    * `curl -X PUT http://localhost:8080/api/shelters/1 -H 'Content-Type: application/json' -d '{"id":1, "name": "nameChanged"}'`
* DELETE AN EMPTY SHELTER:
    * `curl -X DELETE http://localhost:8080/api/shelters/1 -H 'Content-Type: application/json'`

## OrganicDog Commands

* POST Create an Organic Dog:
    * `curl -s -X POST http://localhost:8080/api/shelters/1/organicDog -H 'Content-Type: application/json' -d '{"name": "testDog"}'`

* PUT Feed an Organic Dog
    * `curl -X PUT http://localhost:8080/api/shelters/1/organicDog/1 -H 'Content-Type: application/json'`

* DELETE Adopt a pet feature
    * `curl -X DELETE http://localhost:8080/api/organicDog/1 -H 'Content-Type: application/json'`

## OrganicCat Commands

* POST Create an Organic Cat:
    * `curl -s -X POST http://localhost:8080/api/shelters/1/organicCat -H 'Content-Type: application/json' -d '{"name": "testCat"}'`

* PUT Feed an Organic Cat
    * `curl -X PUT http://localhost:8080/api/shelters/1/organicCat/1 -H 'Content-Type: application/json'`

* DELETE Adopt a pet feature
    * `curl -X DELETE http://localhost:8080/api/organicCat/1 -H 'Content-Type: application/json'`

## RoboticCat Commands

* POST Create a Robotic Cat:
    * `curl -s -X POST http://localhost:8080/api/shelters/1/roboticCat -H 'Content-Type: application/json' -d '{"name": "testCat"}'`

* PUT Feed a Robotic Cat
    * `curl -X PUT http://localhost:8080/api/roboticCat/1 -H 'Content-Type: application/json'`

* DELETE Adopt a pet feature
    * `curl -X DELETE http://localhost:8080/api/roboticCat/1 -H 'Content-Type: application/json'`

## RoboticDog Commands

* POST Create a Robotic Dog:
    * `curl -s -X POST http://localhost:8080/api/shelters/1/roboticDog -H 'Content-Type: application/json' -d '{"name": "testDog"}'`

* PUT Feed a Robotic Dog
    * `curl -X PUT http://localhost:8080/api/roboticDog/1 -H 'Content-Type: application/json'`

* DELETE Adopt a pet feature
    * `curl -X DELETE http://localhost:8080/api/roboticDog/1 -H 'Content-Type: application/json'`

# User Stories

See project Board  https://github.com/orgs/2023-Spring-Cohort/projects/22

# Required Tasks

## Backend

- DONE Choose which student’s virtual pet will be used for this project.
- DONE Use the Virtual Pet classes from Virtual Pet Amok as your model. This will probably require substantial
  modifications,
  that’s what the team is for!
- DONE Relate Shelter to Virtual Pet. Allow for more than one shelter, though you still only need one shelter unless you
  want
  to get fancy.
- DONE Make appropriate repos for your model.
- DONE Make controller endpoints that can do everything your original pets did in Amok. For instance, make an endpoint
  that
  will feed all your pets. Make sure you still tick() when you should!

## Frontend

- DONE Create a frontend that has the following pages:
    - Shelter view which shows the names and basic stats of a pet. Also, should allow you to adopt pets out and call
      appropriate shelter methods.
    - Pet view which shows a pet in detail. Also,git should be capable of running any pet specific methods you have.
    - DONE Add pet view which allows you to add a new pet. Feel free to incorporate this one directly into the shelter
      view
      or pet view if you think it looks better.
- DONE IN PROGRESS Use CSS styling and keep a consistent styling throughout the frontend.
- DONE Use Javascript to interact with your back end.

## Stretch Tasks

Animation:
Add Javascript animations to the view.

DONE Make your pets tick in real time:
DONE Make it so that rather than calling tick() every time you interact with your shelter, tick() gets called every few
seconds and updates the view.

Use your creativity:
If you think of something and have extra time, feel free to attempt it!
