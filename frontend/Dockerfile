FROM node:18.12.1-alpine as build

WORKDIR /usr/src/app

COPY package.json package-lock.json ./

RUN npm install

COPY . .

RUN npm run build

### STAGE 2: Run ###

FROM nginx:latest
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build /usr/src/app/dist/you-booking /usr/share/nginx/html
EXPOSE 80

