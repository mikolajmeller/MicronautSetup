## Cleaning
`docker-compose rm -v` clean docker-compose volumes (for example MySql database)
`docker inspect -f '{{.Name}} - {{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $(docker ps -aq)` - list container names and IPs
`docker cp backend:/backend/src/main/java/micronautsetup/jooq ./src/main/java/micronautsetup/jooq` - copy files from container to host folder
