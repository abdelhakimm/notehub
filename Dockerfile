FROM payara/server-full:6.2024.5-jdk17
# ou, si ce tag n’existe pas chez toi, essaye:
# FROM payara/server-full:6.2024.5-jdk-17
# (les deux existent selon les releases; l’un des deux fonctionnera)

COPY target/notehub.war /opt/payara/deployments/
