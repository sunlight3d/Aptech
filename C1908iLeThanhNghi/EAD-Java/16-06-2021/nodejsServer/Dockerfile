FROM node
WORKDIR /app
COPY ./ /app/
RUN npm install express
RUN npm install
RUN npm install nodemon
CMD ["nodemon", "./index.js"]
#CMD sh
