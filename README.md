# gog-parser Project

GOG parser fetches game data from the the official GOG side and their API. It
then converts the data for internal use.

This project uses Quarkus, the Supersonic Subatomic Java Framework.

There are 2 REST point available:

Get games by search string:
GET
example url: http://localhost:8080/gog-parser/api/v1/gog/game?searchString=witcher

Get game prices:
GET
example url: http://localhost:8080/gog-parser/api/v1/gog/price?ids=1207664663

To run the project locally in docker run commands:

## Docker build

```shell script
docker build -f Dockerfile.jvm -t tjasad/rso-gog-parser .
```

## Docker run

```shell script
docker run -i --rm -p 8082:8082 tjasad/rso-gog-parser
```

## Dockerhub link

https://hub.docker.com/repository/docker/tjasad/rso-gog-parser

There is also a deployment file for k8s present which can be used for kubernetes deployment.