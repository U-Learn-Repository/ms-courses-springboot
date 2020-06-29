FROM postgres:12
MAINTAINER skoltun
ENV POSTGRES_HOST=u_learn
ENV POSTGRES_DB=u_learn
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=root
ENV POSTGRES_HOST_AUTH_METHOD=trust
COPY schema.sql /docker-entrypoint-initdb.d/
