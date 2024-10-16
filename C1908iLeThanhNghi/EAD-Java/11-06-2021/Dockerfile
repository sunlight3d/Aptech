
# Build image:
# docker build --tag=my-node-image:1.0 -f Dockerfile . 

# Start container in detach mode, forward port 3000 -> 3001, map Volume
docker run -d -it -p 3001:3000 \
-v /Users/nguyenduchoang/Documents/code/Aptech/C1908iLeThanhNghi/EAD/11-06-2021:/home/node \
--name=my-node-container \
my-node-image:1.0

# Access to terminal in container:
# docker exec -it my-node-container /bin/sh

FROM node:latest
WORKDIR /home/node
COPY ./ ./
RUN npm install
#Neu debug chay lenh nay trong terminal
#CMD node inspect ./index.js
CMD node --inspect=0.0.0.0 ./index.js
#CMD bin/sh