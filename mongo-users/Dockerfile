FROM ubuntu:18.04
RUN apt-get update && apt-get install -y mongodb && apt-get install nano
COPY mongodb.conf /etc/mongodb.conf

# Create the MongoDB data directory
RUN mkdir -p /data/db
#RUN ./adminscript.sh
# Expose port #37017 from the container to the host
# EXPOSE 37017
#ENTRYPOINT ["/adminscript.sh"]
#Start MongoDb
CMD ["mongod", "-f", "/etc/mongodb.conf" ]
#ENTRYPOINT ["/adminscript.sh"]
