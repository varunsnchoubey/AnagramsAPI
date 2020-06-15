# AnagramsAPI

AnagramsAPI has been developed using Springboot and docker.
Maven build creates project jar under target folder.
It is an independent jar which has integrated tomcat which accepts requests on port 8081.
Docker file has been added which helps in building docker image which is used by docker-compose.yml.
Docker container accepts connection requests on 8082 and redirects it to internal tomcat at port 8081.

Instructions to run project:
git-clone project from Master branch.
Set up Docker (If system does not have Docker)
Once docker has been set up, simply run following commands:
docker-compose build (This builds the image)
docker-compose up (This creates docker container and it starts accepting connection request at port 8082)

API:
Request : GET
url : http://localhost:8082/anagrams/abc/bac
Response : { "areAnagrams" : true }
http status code : 200 - OK

Request : GET
url : http://localhost:8082/anagrams/abc/bac*sb
Response : Empty
http status code : 400 - Bad Request

Request : GET
url : http://localhost:8082/anagrams/abc
Response : {
    "anagrams": [
        "abc",
        "acb",
        "bac",
        "bca",
        "cab",
        "cba"
    ]
}
http status code : 200 - OK

Request : GET
url : http://localhost:8082/anagrams/bac*sb
Response : Empty
http status code : 400 - Bad Request


This project also contains springboot test : src/test/java directory


