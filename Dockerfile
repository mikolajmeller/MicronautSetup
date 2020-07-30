# TODO optimize it
FROM gradle:jdk11
EXPOSE 8080
WORKDIR /backend
ADD . .
RUN gradle build --no-daemon
ENTRYPOINT gradle run --no-daemon # verbose --warning-mode all