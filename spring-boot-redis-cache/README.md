Spring boot with Redis Cache
--
This project is a simple example of how to use Redis cache with Spring Boot.

Start redis server with docker:
```shell
docker run --name redis -p 6379:6379 -d redis:latest
# docker start redis
# docker stop redis
```

Start postgres server with docker:
```shell
docker run -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=postgres -p "5432:5432" -d postgres:latest
# docker start postgres
# docker stop postgres
docker exec -it <container_id> psql -U postgres -c "CREATE DATABASE spring_boot_example;"
```

Create table in postgres:
```shell
```postgresql
CREATE TABLE Item (
    id varchar(11) NOT NULL,
    description varchar(200) NOT NULL,
    PRIMARY KEY (id)
);
```
