# MeetUp Web API
> Web API project for scheduling meetings

## Methods

- [get all meet up's](#GetAll)
- [get meet up by id](#GetById)
- [get sorted meet up's](#GetSorted)
- [get filtered meet up's](#GetFiltered)
- [create](#Create)
- [update](#Update)
- [delete](#Delete)

## Date format 
Date format : dd/MM/yyyy HH:mm:ss

## Environment variables :
In files:
  - FlyWayMigration.java
  - hibernate.cfg.xml
  
## Intellij IDEA start tutorial:
  - Change environment variables (database_url, database_user, database_password)
  - Build and run
  
## Docker-compose start tutorial:
  - Chagnge database url connection to ```jdbc:postgresql://postgres:5432/MeetUp```
  - Rebuild jar file
  - Start docker-compose.yaml in Intellij IDEA or in cmd 

## Examples
### 1. <a name="GetAll">Get all meet up's</a>
Request URL: 
```
[GET] localhost:8080/meetUp
```

Response body:
```
[
	{
		"theme": "dailyScrum",
		"description": "Framework's",
		"organizer": "PM",
		"date": "2022-12-10T09:00:00.000+00:00",
		"place": "googlemeets"
	},
	{
		"theme": "dailyScrum",
		"description": "Team building",
		"organizer": "PM",
		"date": "2022-12-10T12:00:00.000+00:00",
		"place": "googlemeets"
	}
]
```
### 2. <a name="GetById">Get meet up by id</a>
Request URL: 
```
[GET] localhost:8080/meetUp/{id}
```
Example request URL:
```
[GET] localhost:8080/meetUp/36
```
Response body:
```
{
	"theme": "dailyScrum",
	"description": "Framework's",
	"organizer": "PM",
	"date": "2022-12-10T09:00:00.000+00:00",
	"place": "googlemeets"
}
```
### 3. <a name="GetSorted">Get sorted meet up's</a>
Request URL: 
```
[GET] localhost:8080/meetUp/sorted
```
Request json body:
```
[theme] [, description] [, organizer] [, date] [, place]
```
Example request json body:
```
date, description
```
Response body:
```
[
	{
		"theme": "dailyScrum",
		"description": "Framework's",
		"organizer": "PM",
		"date": "2022-12-10T09:00:00.000+00:00",
		"place": "googlemeets"
	},
	{
		"theme": "dailyScrum",
		"description": "Team building",
		"organizer": "PM",
		"date": "2022-12-10T12:00:00.000+00:00",
		"place": "googlemeets"
	}
]
```
### 4. <a name="GetFiltered">Get filtered meet up's</a>
Request URL: 
```
[GET] localhost:8080/meetUp/filter
```
Request json body:
```
{
	["theme": "fileter_theme",]
	["description": "fileter_description",]
	["organizer": "fileter_organizer",]
	["date": "fileter_date",]
	["place": "fileter_place"]
}
```
Example request json body:
```
{
	"description":"Framework",
	"place":"googlemeets"
}
```
Response body:
```
[
	{
		"theme": "dailyScrum",
		"description": "Framework's",
		"organizer": "PM",
		"date": "2022-12-10T09:00:00.000+00:00",
		"place": "googlemeets"
	}
]
```
### 5. <a name="Create">Create</a>
Request URL: 
```
[POST] localhost:8080/meetUp/
```
Request json body:
```
{
 	"theme":"ur_theme",
	"description":"ur_description",
	"organizer":"ur_organizer",
	"date":"ur_date",
	"place":"ur_place"
}
```
Example request json body:
```
{
	"theme":"dailyScrum",
	"description":"Team building",
	"organizer":"PM",
	"date":"10/12/2022 15:00:00",
	"place":"googlemeets"
}
```
Response body(id):
```
37
```
### 6. <a name="Update">Update</a>
Request URL: 
```
[PATCH] localhost:8080/meetUp/{id}
```
Request json body:
```
{
  	"theme":"new_theme",
	"description":"new_description",
	"organizer":"new_organizer",
	"date":"new_date",
	"place":"new_place"
}
```
Example request URL: 
```
[PATCH] localhost:8080/meetUp/37
```
Example request json body:
```
{
	"description":"Team building",
	"organizer":"Alexey",
}
```
### 7. <a name="Delete">Delete</a>
Reqyest url
```
[DELETE] localhost:8080/meetUp/{id}
```
Example request URL: 
```
[DELETE] localhost:8080/meetUp/37
```

