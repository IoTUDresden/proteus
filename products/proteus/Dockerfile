# PROtEUS docker image

# Base image
FROM frolvlad/alpine-oraclejdk8:slim

# Set the working directory to /vicci-runtime
WORKDIR /vicci-runtime

# Copy the binaries to the container
COPY target/eu.vicci.proteus-1.0.0-SNAPSHOT.jar /vicci-runtime/bin/

# Make port 8081 available to the world outside this container
EXPOSE 8081
EXPOSE 8082

# Run runtime when the container launches
CMD ["java", "-jar", "/vicci-runtime/bin/eu.vicci.proteus-1.0.0-SNAPSHOT.jar", "-container"]