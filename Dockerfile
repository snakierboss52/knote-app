FROM adoptopenjdk/openjdk11-openj9 AS jar

RUN addgroup --system spring && adduser --system spring --ingroup spring

USER spring:spring

RUN mkdir -p /tmp/logs && chown spring:spring /tmp/logs

COPY --chown=spring ./build/libs/jorge*.jar ./jorge.jar

VOLUME /tmp/logs

ENTRYPOINT ["java", "-jar", "/jorge.jar"]