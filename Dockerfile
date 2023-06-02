FROM openjdk:20

RUN mkdir /app

COPY out/production/lab1/ /app

WORKDIR /app

CMD java main.Main