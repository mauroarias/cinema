FROM adoptopenjdk/openjdk11:alpine-jre as base

ARG USER="user"

RUN adduser --disabled-password --uid 1000 --gecos '' ${USER}
RUN apk update

WORKDIR /home/${USER}/
COPY ./target/cinema*.jar ./app.jar
EXPOSE 80 8081

ENV SPRING_PROFILES_ACTIVE=dev
ENV JAVA_OPTS=""
ENV CONFIG_PATH=/etc/cfg/

ENTRYPOINT exec java $JAVA_OPTS -jar app.jar --spring.config.location=$CONFIG_PATH/,classpath:/
