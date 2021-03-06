FROM ubuntu:18.04
RUN apt-get update
RUN apt-get install python3 python3-pip openjdk-8-jdk maven -y

WORKDIR /nimrod-hunor
COPY nimrod nimrod/
COPY subjects subjects/
COPY setup.py setup.py
COPY MANIFEST.in MANIFEST.in
COPY README.md README.md

ENV PYTHONPATH "/nimrod-hunor"
RUN pip3 install beautifulsoup4

# --- Comandos desnecessários na versão em Docker
# RUN pip3 install virtualenv
# RUN virtualenv -p /usr/bin/python3 env
# CMD [ "source env/bin/activate" ]
