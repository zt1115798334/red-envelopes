FROM java:8
MAINTAINER zt
VOLUME /tmp

ADD /target/red-envelopes-0.0.1-SNAPSHOT.jar red-envelopes-0.0.1-SNAPSHOT.jar
RUN export LC_ALL=zh_CN.UTF-8
RUN echo "export LC_ALL=zh_CN.UTF-8"  >>  /etc/profile
RUN echo "Asia/shanghai" > /etc/timezone
EXPOSE 8080
ENTRYPOINT ["java","-jar","red-envelopes-0.0.1-SNAPSHOT.jar"]
