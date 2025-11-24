FROM payara/server-full:6.2024.5-jdk17

USER root

# 1) Download and install Postgres driver
ADD https://repo1.maven.org/maven2/org/postgresql/postgresql/42.7.4/postgresql-42.7.4.jar \
    /opt/payara/appserver/glassfish/domains/domain1/lib/postgresql.jar

RUN chown payara:payara /opt/payara/appserver/glassfish/domains/domain1/lib/postgresql.jar \
 && chmod 644 /opt/payara/appserver/glassfish/domains/domain1/lib/postgresql.jar

USER payara

# 2) Copy commands
COPY payara-postboot.asadmin /opt/payara/config/post-boot-commands

# 3) Copy WAR to a TEMP location (NOT deployments)
# This prevents Payara from trying to deploy it before the DB connection is ready
COPY target/notehub.war /tmp/notehub.war