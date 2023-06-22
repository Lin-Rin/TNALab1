FROM openjdk:20

RUN mkdir /app

#COPY out/production/lab1/ /app
#COPY out/production/lab2/ /app
COPY out/production/lab3/ /app

WORKDIR /app

CMD java main.Main